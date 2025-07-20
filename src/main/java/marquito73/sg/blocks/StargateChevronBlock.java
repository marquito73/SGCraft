package marquito73.sg.blocks;

import marquito73.sg.init.SGCraftBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

/**
 * Stargate chevron block
 */
public class StargateChevronBlock extends StargateCommonGateBlock {
    public StargateChevronBlock() {
        super();
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return SGCraftBlockEntityTypes.STARGATE_CHEVRON.instantiate(pos, state);
    }
}
