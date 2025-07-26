package marquito73.sg.screenhandler.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

/**
 * Authorize only one block inside slot
 */
public class OneBlockOnlySlot extends Slot {
    /**
     * Authorize only one block inside slot
     */
    public OneBlockOnlySlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() instanceof BlockItem blockItem && blockItem.getBlock().getDefaultState().isSolid();
    }

    @Override
    public int getMaxItemCount() {
        return 1;
    }
}
