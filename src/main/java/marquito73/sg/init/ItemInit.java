package marquito73.sg.init;

import marquito73.sg.SGCraft;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemInit {
    public static final Item NAQUADAH_INGOT = register("naquadah_ingot", new Item(new Item.Settings()));
    public static final Item NAQUADAH_RAW = register("naquadah_raw", new Item(new Item.Settings()));

    public static void load() {
    }

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, SGCraft.getID(name), item);
    }
}
