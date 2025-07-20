package marquito73.sg.blocks;

import net.minecraft.block.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

/**
 * Main class for blocks with entity
 */
public abstract class SGCraftBlockWithEntity extends BlockWithEntity {
    public static final BooleanProperty VISIBLE = BooleanProperty.of("visible");
    protected SGCraftBlockWithEntity(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(VISIBLE);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return state.get(VISIBLE) ? BlockRenderType.MODEL : BlockRenderType.INVISIBLE;
    }

    @Override
    protected boolean hasSidedTransparency(BlockState state) {
        return !state.get(VISIBLE);
    }

    @Override
    protected float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return state.get(VISIBLE) ? 0.2f : 1.0f;
    }
}
