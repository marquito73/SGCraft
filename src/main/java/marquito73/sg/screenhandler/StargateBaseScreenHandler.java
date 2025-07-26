package marquito73.sg.screenhandler;

import marquito73.sg.entity.StargateBaseBlockEntity;
import marquito73.sg.init.SGCraftBlocks;
import marquito73.sg.init.SGCraftScreenHandlerTypes;
import marquito73.sg.network.StargatePayload;
import marquito73.sg.screenhandler.slot.OneBlockOnlySlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

/**
 * The Stargate screen handler
 */
public class StargateBaseScreenHandler extends SGCraftScreenHandler<StargateBaseBlockEntity, StargatePayload> {
    /**
     * The Stargate screen handler
     *
     * @param syncId Sync ID
     * @param playerInventory The player inventory
     * @param payload Payload for the screen
     */
    public StargateBaseScreenHandler(int syncId, PlayerInventory playerInventory, StargatePayload payload) {
        super(SGCraftScreenHandlerTypes.STARGATE_BASE, syncId, playerInventory, payload);
    }

    /**
     * The Stargate screen handler
     *
     * @param syncId Sync ID
     * @param playerInventory The player inventory
     * @param blockEntity Block entity
     */
    public StargateBaseScreenHandler(int syncId, PlayerInventory playerInventory, StargateBaseBlockEntity blockEntity) {
        super(SGCraftScreenHandlerTypes.STARGATE_BASE, syncId, playerInventory, blockEntity);
    }

    @Override
    protected void initOtherInventories(PlayerInventory playerInventory) {
        SimpleInventory inventory = this.blockEntity.getInventory();
        inventory.onOpen(playerInventory.player);
        checkSize(inventory, 5);

        this.addStargateBaseInventory(inventory);
    }

    @Override
    protected BlockPos getPayloadPos(StargatePayload payload) {
        return payload.pos();
    }

    /**
     * Add inventory for the Sargate base (5 slots for the 5 blocks at the base of the Stargate)
     *
     * @param inventory Inventory of the Stargate
     */
    private void addStargateBaseInventory(SimpleInventory inventory) {
        for (int column = 0; column < 5; column++) {
            this.addSlot(new OneBlockOnlySlot(inventory, column, 8 + (column * 18), 54));
        }
    }

    @Override
    protected void addPlayerInventory(PlayerInventory playerInventory) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInventory, 9 + (column + (row * 9)), 8 + (column * 18), 84 + (row * 18)));
            }
        }
    }

    @Override
    protected void addPlayerHotBar(PlayerInventory playerInventory) {
        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(playerInventory, column, 8 + (column * 18), 142));
        }
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.blockEntity.getInventory().onClose(player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack stack = ItemStack.EMPTY;

        Slot slot = this.getSlot(slotIndex);

        if (slot != null && slot.hasStack()) {
            ItemStack inSlot = slot.getStack();
            stack = inSlot.copy();

            if (slotIndex < 5) {
                if (!this.insertItem(inSlot, 5, this.slots.size(), true)) {
                    stack = ItemStack.EMPTY;
                }
            } else if (!this.insertItem(inSlot, 0, 5, false)) {
                stack = ItemStack.EMPTY;
            }

            if (inSlot.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return stack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, SGCraftBlocks.STARGATE_BASE);
    }
}
