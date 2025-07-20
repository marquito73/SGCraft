package marquito73.sg.entity;

import marquito73.sg.init.SGCraftBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

/**
 * Stargate base chevron entity
 */
public class StargateChevronBlockEntity extends StargateBlockEntity {
    public StargateChevronBlockEntity(BlockPos pos, BlockState state) {
        super(SGCraftBlockEntityTypes.STARGATE_CHEVRON, pos, state);
    }
}
