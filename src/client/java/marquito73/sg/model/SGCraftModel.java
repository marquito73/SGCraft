package marquito73.sg.model;

import de.javagl.obj.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.io.InputStream;

/**
 * An object represent an Object Model (.obj)
 */
public abstract class SGCraftModel {
    private final Obj objectModel;
    protected final Identifier defaultResourceID;

    /**
     * An object represent an Object Model (.obj)
     *
     * @param modelID The resource ID of the model file
     * @param defaultResourceID The resource ID of the default texture
     */
    public SGCraftModel(Identifier modelID, Identifier defaultResourceID) {
        try {
            InputStream stream = MinecraftClient.getInstance().getResourceManager().getResource(modelID).orElseThrow().getInputStream();

            this.objectModel = ObjReader.read(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.defaultResourceID = defaultResourceID;
    }

    /**
     * Render a model
     *
     * @param matrices Matrices
     * @param vertexConsumers Consumer for the rendering
     * @param light The light of the block
     * @param overlay Overlay
     */
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        for (int materialGroupIndex = 0; materialGroupIndex < this.objectModel.getNumMaterialGroups(); materialGroupIndex++) {
            ObjGroup materialGroup = this.objectModel.getMaterialGroup(materialGroupIndex);

            VertexConsumer consumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(this.getFaceResourceID(materialGroup.getName())));

            for (int faceIndex = 0; faceIndex < materialGroup.getNumFaces(); faceIndex++) {
                ObjFace face = materialGroup.getFace(faceIndex);

                renderFace(face, consumer, matrices, light, overlay);
            }
        }
    }

    /**
     * Get resource ID for this face
     *
     * @param faceGroupName The group name for this face
     * @return Resource ID for this face
     */
    protected abstract Identifier getFaceResourceID(String faceGroupName);

    /**
     * Render a face
     *
     * @param face The face to render
     * @param matrices Matrices
     * @param consumer Consumer for the rendering (with its textures)
     * @param light The light of the block
     * @param overlay Overlay
     */
    protected void renderFace(ObjFace face, VertexConsumer consumer, MatrixStack matrices, int light, int overlay) {
        for (int vtx = 0; vtx < face.getNumVertices(); vtx++) {
            FloatTuple pos = this.objectModel.getVertex(face.getVertexIndex(vtx));
            FloatTuple uv = this.objectModel.getTexCoord(face.getTexCoordIndex(vtx));
            FloatTuple normals = this.objectModel.getNormal(face.getNormalIndex(vtx));

            consumer.vertex(matrices.peek().getPositionMatrix(), pos.getX(), pos.getY(), pos.getZ())
                    .color(255, 255, 255, 255)
                    .texture(uv.getX(), 1 - uv.getY())
                    .overlay(overlay    )
                    .light(light)
                    .normal(matrices.peek(), normals.getX(), normals.getY(), normals.getZ());
        }
    }
}
