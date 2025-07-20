package marquito73.sg.render;

import marquito73.sg.blocks.StargateBaseBlock;
import marquito73.sg.entity.StargateBlockEntity;
import marquito73.sg.model.SGCraftModel;
import marquito73.sg.model.stargate.InnerRingModel;
import marquito73.sg.model.stargate.OuterRingModel;
import marquito73.sg.structure.StargateStructure;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.RotationAxis;

import java.util.*;

/**
 * Render a Stargate
 */
public class StargateRenderer extends SGCraftRenderer<StargateBlockEntity> implements BlockEntityRenderer<StargateBlockEntity> {
    /**
     * Render a Stargate
     *
     * @param ctx
     */
    public StargateRenderer(BlockEntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    protected boolean structureIsValid(StargateBlockEntity entity) {
        StargateStructure stargateStructure = new StargateStructure(entity.getWorld(), entity.getPos());

        return stargateStructure.structureIsValid();
    }

    @Override
    protected Set<Class> acceptedBlocks() {
        return new HashSet<>(Arrays.asList(StargateBaseBlock.class));
    }

    @Override
    protected void registerParts(Map<String, SGCraftModel> modelParts) {
        modelParts.put("OUTER_RING", new OuterRingModel());
        modelParts.put("INNER_RING", new InnerRingModel());
    }

    @Override
    protected void renderPart(String partKey, SGCraftModel part, StargateBlockEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        // Manage orientation of the stargate depending on the orientation of the main block
        float anglex = switch (entity.getCachedState().get(Properties.HORIZONTAL_FACING)) {
            case NORTH -> -90f;
            case SOUTH -> 90f;
            case WEST -> 0f;
            case EAST -> 180f;
            default -> 0f;
        };
        switch (partKey) {
            case "OUTER_RING":
                // Move model correctly
                matrices.translate(0.5, 2.5f, 0.5);
                // Manage scale
                matrices.scale(2.50f, 2.50f, 2.50f);
                // Manage orientation of the stargate depending on the orientation of the main block
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(anglex));

                part.render(matrices, vertexConsumers, light, overlay); // Test color
                break;
            case "INNER_RING":
                // Move model correctly
                matrices.translate(0.5, 2.5f, 0.535);
                // Manage scale
                matrices.scale(2.50f, 2.50f, 2.50f);
                // Manage orientation of the stargate depending on the orientation of the main block
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(anglex));

                part.render(matrices, vertexConsumers, light, overlay); // Test color
                break;
            default:
                break;
        }
    }
}