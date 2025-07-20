package marquito73.sg.entity;

import marquito73.sg.blocks.SGCraftBlockWithEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

/**
 * Main block entity
 */
public abstract class SGCraftBlockEntity extends BlockEntity {
    /**
     * Block entity is visible ?
     */
    private boolean visible = true;

    /**
     * Main block entity
     *
     * @param type Type of this block entity
     * @param pos His position
     * @param state His state
     */
    public SGCraftBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    /**
     * Block entity is visible ?
     *
     * @return Block entity is visible ?
     */
    public boolean isVisible() {
        return this.visible;
    }

    /**
     * Set if this block entity is visible
     *
     * @param visible Block entity is visible ?
     */
    public void setVisible(boolean visible) {
        this.visible = visible;

        if (this.world != null) {
            BlockState currentState = this.world.getBlockState(this.pos);
            if (currentState.getBlock() instanceof SGCraftBlockWithEntity) {
                this.world.setBlockState(this.pos, currentState.with(SGCraftBlockWithEntity.VISIBLE, visible), Block.NOTIFY_ALL);
            }
        }
    }
}
