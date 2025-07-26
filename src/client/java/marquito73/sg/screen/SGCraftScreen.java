package marquito73.sg.screen;

import marquito73.sg.entity.SGCraftBlockEntity;
import marquito73.sg.screenhandler.SGCraftScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * Represent a screen client's side
 *
 * @param <TBlockEntity> A block entity
 * @param <TPayload> A payload, contains some data
 * @param <TScreenHandler> A screen handler
 */
public abstract class SGCraftScreen<TBlockEntity extends SGCraftBlockEntity, TPayload extends CustomPayload, TScreenHandler extends SGCraftScreenHandler<TBlockEntity, TPayload>>
        extends HandledScreen<TScreenHandler> {
    /**
     * The texture for render the screen
     */
    private final Identifier screenTexture;

    /**
     * Represent a screen client's side
     *
     * @param handler A screen handler
     * @param inventory The inventory of the player
     * @param title The screen title
     * @param screenTexture The texture for render the screen
     */
    public SGCraftScreen(TScreenHandler handler, PlayerInventory inventory, Text title, Identifier screenTexture) {
        super(handler, inventory, title);
        this.screenTexture = screenTexture;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawTexture(this.screenTexture, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }
}