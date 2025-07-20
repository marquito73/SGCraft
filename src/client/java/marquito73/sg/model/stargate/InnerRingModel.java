package marquito73.sg.model.stargate;

import de.javagl.obj.FloatTuple;
import marquito73.sg.SGCraft;
import marquito73.sg.model.SGCraftModel;
import net.minecraft.util.Identifier;

public class InnerRingModel extends SGCraftModel {
    public InnerRingModel() {
        super(SGCraft.getID("models/blockentity/stargate/inner_ring.obj"), SGCraft.getID("textures/blockentity/stargate/stargate.png"));
    }

    @Override
    protected Identifier getFaceResourceID(String faceGroupName) {
        Identifier faceResourceID = this.defaultResourceID;

        if (faceGroupName != null) {
            if (faceGroupName.equals("InnerRingBorder")) {
                // Borders of the inner ring
                faceResourceID = SGCraft.getID("textures/blockentity/stargate/inner_ring_border.png");
            } else {
                // Symbols
                try {
                    int symbolNumber = Integer.parseInt(faceGroupName);

                    if (symbolNumber >= 1 && symbolNumber <= 39) {
                        faceResourceID = SGCraft.getID("textures/blockentity/stargate/symbols/" + faceGroupName + ".png");
                    }
                } catch (NumberFormatException ignored) {

                }
            }
        }

        return faceResourceID;
    }
}
