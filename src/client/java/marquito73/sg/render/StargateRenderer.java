package marquito73.sg.render;

import marquito73.sg.blocks.StargateBaseBlock;
import marquito73.sg.entity.StargateBaseBlockEntity;
import marquito73.sg.entity.StargateBlockEntity;
import marquito73.sg.model.SGCraftModel;
import marquito73.sg.model.stargate.InnerRingModel;
import marquito73.sg.model.stargate.OuterRingModel;
import marquito73.sg.structure.StargateStructure;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.random.LocalRandom;

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

    @Override
    protected void renderStructureBlocks(StargateBlockEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (entity instanceof StargateBaseBlockEntity stargateBaseBlockEntity) {
            BlockRenderManager blockRenderDispatcher = MinecraftClient.getInstance().getBlockRenderManager();
            Direction facing = entity.getCachedState().get(Properties.HORIZONTAL_FACING).rotateYClockwise().getOpposite();

            // The stargate base has 5 blocks to render
            for (int baseIndex = 0; baseIndex < 5; baseIndex++) {
                if (stargateBaseBlockEntity.getInventory().getStack(baseIndex).getItem() instanceof BlockItem blockItem) {
                    // The block in inventory is a blockitem, we can render it
                    BlockPos pos = entity.getPos().offset(facing, baseIndex - 2);
                    // Get the block texture
                    VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayers.getBlockLayer(blockItem.getBlock().getDefaultState()));

                    matrices.push();
                    // Translate matrice at the correct position
                    matrices.translate(pos.getX() - entity.getPos().getX(), pos.getY() - entity.getPos().getY(), pos.getZ() - entity.getPos().getZ());
                    // Render the block at the correct position
                    blockRenderDispatcher.renderBlock(blockItem.getBlock().getDefaultState(), pos, entity.getWorld(), matrices, vertexConsumer,
                            false, new LocalRandom(0));

                    matrices.pop();
                }
            }
        }
    }
}