package marquito73.sg.screen;

import marquito73.sg.SGCraft;
import marquito73.sg.entity.StargateBaseBlockEntity;
import marquito73.sg.network.StargatePayload;
import marquito73.sg.screenhandler.StargateBaseScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

/**
 * Screen of the Stargate base
 */
public class StargateBaseScreen extends SGCraftScreen<StargateBaseBlockEntity, StargatePayload, StargateBaseScreenHandler> {
    /**
     * Screen of the Stargate base
     *
     * @param handler A screen handler
     * @param inventory The inventory of the player
     * @param title The screen title
     */
    public StargateBaseScreen(StargateBaseScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title, SGCraft.getID("textures/gui/stargate_base_gui.png"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
    }
}
