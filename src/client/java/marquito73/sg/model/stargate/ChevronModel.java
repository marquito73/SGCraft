package marquito73.sg.model.stargate;

import marquito73.sg.SGCraft;
import marquito73.sg.model.SGCraftModel;
import net.minecraft.util.Identifier;

public class ChevronModel extends SGCraftModel {
    public ChevronModel() {
        super(SGCraft.getID("models/blockentity/stargate/chevron.obj"), SGCraft.getID("textures/blockentity/stargate/chevron.png"));
    }

    @Override
    protected Identifier getFaceResourceID(String faceGroupName) {
        return this.defaultResourceID;
    }
}
