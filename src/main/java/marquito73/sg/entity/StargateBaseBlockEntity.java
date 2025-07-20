package marquito73.sg.entity;

import marquito73.sg.init.SGCraftBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

/**
 * Stargate base block entity
 */
public class StargateBaseBlockEntity extends StargateBlockEntity {
    public StargateBaseBlockEntity(BlockPos pos, BlockState state) {
        super(SGCraftBlockEntityTypes.STARGATE, pos, state);
    }
}
