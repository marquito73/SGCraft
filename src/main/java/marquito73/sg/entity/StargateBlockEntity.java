package marquito73.sg.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

/**
 * Main class for blocks entity compose the Stargate
 */
public abstract class StargateBlockEntity extends SGCraftBlockEntity {
    public StargateBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
