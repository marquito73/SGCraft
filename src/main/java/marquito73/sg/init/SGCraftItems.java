package marquito73.sg.init;

import marquito73.sg.SGCraft;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class SGCraftItems {
    public static final Item NAQUADAH_INGOT = register("naquadah_ingot", new Item(new Item.Settings()));
    public static final Item NAQUADAH_RAW = register("naquadah_raw", new Item(new Item.Settings()));
    public static final Item STARGATE_CORE_CRYSTAL = register("stargate_core_crystal", new Item(new Item.Settings()));
    public static final Item STARGATE_CONTROLLER_CRYSTAL = register("stargate_controller_crystal", new Item(new Item.Settings()));
    public static final Item STARGATE_PEGASUS_UPGRADE_CRYSTAL = register("stargate_pegasus_upgrade_crystal", new Item(new Item.Settings()));
    public static final Item STARGATE_CHEVRON_UPGRADE = register("stargate_chevron_upgrade", new Item(new Item.Settings()));
    public static final Item STARGATE_IRIS_BLADE = register("stargate_iris_blade", new Item(new Item.Settings()));
    public static final Item STARGATE_IRIS_UPGRADE = register("stargate_iris_upgrade", new Item(new Item.Settings()));

    public static void load() {
    }

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, SGCraft.getID(name), item);
    }
}
