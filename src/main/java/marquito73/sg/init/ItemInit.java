package marquito73.sg.init;

import marquito73.sg.SGCraft;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemInit {
    public static final Item NAQUADAH_INGOT = register("naquadah_ingot", new Item(new Item.Settings()));
    public static final Item NAQUADAH_RAW = register("naquadah_raw", new Item(new Item.Settings()));

    public static void load() {
    }

    public static <T extends Item> T register(String name, T item) {
        Identifier id = SGCraft.getID(name);

        if (Registries.ITEM.containsId(id)) {
            item = (T) Registries.ITEM.get(id);
        } else {
            item = Registry.register(Registries.ITEM, id, item);
        }

        return item;
    }
}
