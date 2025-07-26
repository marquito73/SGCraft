package marquito73.sg.screenhandler;

import marquito73.sg.entity.SGCraftBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.math.BlockPos;

/**
 * A screen handler
 *
 * @param <TBlockEntity> Block entity for open the screen
 * @param <TPayload> Payload for the screen
 */
public abstract class SGCraftScreenHandler<TBlockEntity extends SGCraftBlockEntity, TPayload extends CustomPayload> extends ScreenHandler {
    protected final TBlockEntity blockEntity;
    protected ScreenHandlerContext context;

    /**
     * A screen handler
     *
     * @param screenHandlerType A screen handler type
     * @param syncId Sync ID
     * @param playerInventory The player inventory
     * @param payload Payload for the screen
     */
    public SGCraftScreenHandler(ScreenHandlerType<? extends SGCraftScreenHandler> screenHandlerType, int syncId, PlayerInventory playerInventory, TPayload payload) {
        super(screenHandlerType, syncId);

        this.blockEntity = (TBlockEntity) playerInventory.player.getWorld().getBlockEntity(this.getPayloadPos(payload));

        this.initInventories(playerInventory);
    }

    /**
     * A screen handler
     *
     * @param screenHandlerType A screen handler type
     * @param syncId Sync ID
     * @param playerInventory The player inventory
     * @param blockEntity Block entity
     */
    public SGCraftScreenHandler(ScreenHandlerType<? extends SGCraftScreenHandler> screenHandlerType, int syncId, PlayerInventory playerInventory, TBlockEntity blockEntity) {
        super(screenHandlerType, syncId);

        this.blockEntity = blockEntity;

        this.initInventories(playerInventory);
    }

    /**
     * Init inventories
     *
     * @param playerInventory Player inventory
     */
    private void initInventories(PlayerInventory playerInventory) {
        this.context = ScreenHandlerContext.create(this.blockEntity.getWorld(), this.blockEntity.getPos());

        this.addPlayerInventory(playerInventory);
        this.addPlayerHotBar(playerInventory);
        this.initOtherInventories(playerInventory);
    }

    /**
     * Init player inventory slots
     *
     * @param playerInventory Player inventory
     */
    protected abstract void addPlayerInventory(PlayerInventory playerInventory);

    /**
     * Init player inventory hot bar slots
     *
     * @param playerInventory Player inventory
     */
    protected abstract void addPlayerHotBar(PlayerInventory playerInventory);

    /**
     * Init screen other inventories
     *
     * @param playerInventory Player inventory
     */
    protected abstract void initOtherInventories(PlayerInventory playerInventory);

    /**
     * Return position of entity associated to the screen
     *
     * @param payload Screen payload
     * @return Position of entity associated to the screen
     */
    protected abstract BlockPos getPayloadPos(TPayload payload);
}
