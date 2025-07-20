package marquito73.sg.model.stargate;

import de.javagl.obj.FloatTuple;
import marquito73.sg.SGCraft;
import marquito73.sg.model.SGCraftModel;
import net.minecraft.util.Identifier;

public class OuterRingModel extends SGCraftModel {
    public OuterRingModel() {
        super(SGCraft.getID("models/blockentity/stargate/outer_ring.obj"), SGCraft.getID("textures/blockentity/stargate/stargate.png"));
    }

    @Override
    protected Identifier getFaceResourceID(String faceGroupName) {
        Identifier faceResourceID = this.defaultResourceID;

        if (faceGroupName != null) {
            if (faceGroupName.equals("OuterRingBorder")) {
                // Borders of the outer ring
                faceResourceID = SGCraft.getID("textures/blockentity/stargate/outer_ring_border.png");
            } else if (faceGroupName.equals("OuterRingFace")) {
                // Face of the outer ring
                faceResourceID = SGCraft.getID("textures/blockentity/stargate/outer_ring_face.png");
            }
        }

        return faceResourceID;
    }
}
