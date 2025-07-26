package marquito73.sg.render;

import com.mojang.blaze3d.systems.RenderSystem;
import marquito73.sg.entity.SGCraftBlockEntity;
import marquito73.sg.model.SGCraftModel;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;

import java.util.*;

/**
 * A class for rendering models
 *
 * @param <TBlockEntity> The BlockEntity to render
 */
public abstract class SGCraftRenderer<TBlockEntity extends SGCraftBlockEntity> implements BlockEntityRenderer<TBlockEntity> {
    private Map<String, SGCraftModel> modelParts = new HashMap<>();

    /**
     * A class for rendering models
     *
     * @param ctx
     */
    public SGCraftRenderer(BlockEntityRendererFactory.Context ctx) {
        this.registerParts(this.modelParts);
    }

    /**
     * Structure is valid ?
     *
     * @param entity The block entity
     * @return Structure is valid ?
     */
    protected abstract boolean structureIsValid(TBlockEntity entity);

    /**
     * Get accepted blocks for use this renderer
     *
     * @return Accepted blocks for use this renderer
     */
    protected abstract Set<Class> acceptedBlocks();

    @Override
    public void render(TBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (this.structureIsValid(entity)) {
            entity.setVisible(false);

            if (this.acceptedBlocks().contains(entity.getCachedState().getBlock().getClass())) {
                this.modelParts.forEach((partKey, part) -> {
                    matrices.push();
                    RenderSystem.disableCull();

                    this.renderPart(partKey, part, entity, matrices, vertexConsumers, this.getMaxLightAround(entity), overlay);

                    matrices.pop();
                });

                this.renderStructureBlocks(entity, matrices, vertexConsumers, this.getMaxLightAround(entity), overlay);
            }
        } else {
            entity.setVisible(true);
        }
    }

    /**
     * Get max light around the block
     *
     * @param entity The block entity
     * @return The max light around the block
     */
    private int getMaxLightAround(BlockEntity entity) {
        int maxLight = 0;

        for (Direction dir : Direction.values()) {
            int light = WorldRenderer.getLightmapCoordinates(Objects.requireNonNull(entity.getWorld()), entity.getPos().offset(dir));
            if (light > maxLight) {
                maxLight = light;
            }
        }

        return maxLight;
    }

    /**
     * Register different parts (object model / .obj) for this model
     *
     * @param modelParts Parts
     */
    protected abstract void registerParts(Map<String, SGCraftModel> modelParts);

    /**
     * Render a part
     *
     * @param partKey The key of the part
     * @param part The part
     * @param entity The entity block
     * @param matrices Matrices
     * @param vertexConsumers Consumer
     * @param light The light around the block
     * @param overlay Overlay
     */
    protected abstract void renderPart(String partKey, SGCraftModel part, TBlockEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay);

    /**
     * Render structure blocks
     *
     * @param entity The entity block
     * @param matrices Matrices
     * @param vertexConsumers Consumer
     * @param light The light around the block
     * @param overlay Overlay
     */
    protected abstract void renderStructureBlocks(TBlockEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay);
}
