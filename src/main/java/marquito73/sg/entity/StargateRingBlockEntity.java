package marquito73.sg.entity;

import marquito73.sg.init.SGCraftBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

/**
 * Stargate ring block entity
 */
public class StargateRingBlockEntity extends StargateBlockEntity {
    public StargateRingBlockEntity(BlockPos pos, BlockState state) {
        super(SGCraftBlockEntityTypes.STARGATE_RING, pos, state);
    }
}
