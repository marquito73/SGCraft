package marquito73.sg.structure;

import marquito73.sg.blocks.*;
import marquito73.sg.init.SGCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.*;

/**
 * Represent structure of a Stargate
 */
public class StargateStructure extends CommonStructure {
    private final int MAX_STRUCTURE_SIZE = 16;
    private final Direction[] planXY = { Direction.UP, Direction.DOWN, Direction.EAST, Direction.WEST };
    private final Direction[] planYZ = { Direction.UP, Direction.DOWN, Direction.NORTH, Direction.SOUTH };
    private BlockPos centerOfStructure = null;

    /**
     * Represent structure of a Stargate
     */
    public StargateStructure(World world, BlockPos currentBlockPos) {
        super(world, currentBlockPos);
    }

    /**
     * Check Stargate structure on plan XY and YZ
     *
     * @return The Stargate structure is valid
     */
    @Override
    public Boolean structureIsValid() {
        return this.structureIsValid(Direction.Axis.Z, this.planXY) || this.structureIsValid(Direction.Axis.X, this.planYZ);
    }

    /**
     * Check Stargate structure on plan
     *
     * @param axis Axis
     * @param plan Axis plan
     * @return The Stargate structure is valid
     */
    private boolean structureIsValid(Direction.Axis axis,  Direction[] plan) {
        boolean structureIsValid = true;

        if (this.deepFirstSearch(this.world, this.currentBlockPos, this.currentBlockPos, null, new HashSet<>(), 0, plan) && this.centerOfStructure != null) {
            // Planned structure : 5x5
            // Legend
            // C : Chevron Block
            // R : Ring Block
            // B : Base Block
            // A : Air
            String[] pattern = new String[] {
                    "CRBRC",
                    "RAAAR",
                    "CAAAC",
                    "RAAAR",
                    "CRCRC"
            };

            // Offsets for each row / col around the center
            int offset = 2;

            for (int dVertical = -offset; dVertical <= offset; dVertical++) {
                for (int dHorizontal = -offset; dHorizontal <= offset; dHorizontal++) {

                    int row = dVertical + offset;
                    int col = dHorizontal + offset;

                    char expectedChar = pattern[row].charAt(col);
                    Block expectedBlock = switch (expectedChar) {
                        case 'C' -> SGCraftBlocks.STARGATE_CHEVRON;
                        case 'R' -> SGCraftBlocks.STARGATE_RING;
                        case 'B' -> SGCraftBlocks.STARGATE_BASE;
                        default  -> Blocks.AIR;
                    };

                    // Calculate positions depending on the axes
                    BlockPos checkPos;
                    if (axis == Direction.Axis.Z) {
                        // plan X+Y
                        checkPos = this.centerOfStructure.add(dHorizontal, dVertical, 0);
                    } else {
                        // plan Y+Z
                        checkPos = this.centerOfStructure.add(0, dVertical, dHorizontal);
                    }

                    Block found = world.getBlockState(checkPos).getBlock();

                    if (expectedBlock != null && !expectedBlock.equals(found)) {
                        structureIsValid = false;
                        break;
                    }
                }
                if (!structureIsValid) {
                    break;
                }
            }
        } else {
            structureIsValid = false;
        }

        return structureIsValid;
    }

    /**
     * Search for block structure
     *
     * @param world The minecraft world
     * @param current Current block position
     * @param origin Origin block position
     * @param cameFrom From which direction came
     * @param visited Block positions already visited
     * @param depth Depth
     * @param validDirections Valid directions
     * @return Block structure is valid
     */
    private boolean deepFirstSearch(World world, BlockPos current, BlockPos origin, Direction cameFrom,
                                    Set<BlockPos> visited, int depth, Direction[] validDirections) {
        if (depth > MAX_STRUCTURE_SIZE) {
            // Too many blocks, invalid structure
            return false;
        }

        if (visited.contains(current)) {
            return current.equals(origin) && visited.size() == MAX_STRUCTURE_SIZE;
        }

        BlockState state = world.getBlockState(current);

        if (state.getBlock() instanceof StargateCommonGateBlock) {
            visited.add(current);
            this.positions.put(current, state.getBlock());

            if (state.getBlock() instanceof StargateBaseBlock) {
                this.centerOfStructure = current.up(2);
            }

            for (Direction dir : validDirections) {
                if (dir == cameFrom) {
                    // We don't want to go back
                    continue;
                }

                BlockPos next = current.offset(dir);
                if (world.getBlockState(next).getBlock() instanceof StargateCommonGateBlock) {
                    if (this.deepFirstSearch(world, next, origin, dir.getOpposite(), visited, depth + 1, validDirections)) {
                        return true;
                    }
                }
            }

            visited.remove(current); // backtrack
            this.positions.remove(current);
        }

        return false;
    }
}
