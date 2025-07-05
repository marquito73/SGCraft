package marquito73.sg.init;

import marquito73.sg.SGCraft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.Optional;

public class ItemGroupInit {
    public static final Text STARGATE_TITLE = Text.translatable("itemGroup." + SGCraft.MOD_ID + ".stargate_group");

    public static final ItemGroup STARGATE_GROUP = register("stargate_group", FabricItemGroup.builder()
            .displayName(STARGATE_TITLE)
            .icon(SGCraftItems.NAQUADAH_INGOT::getDefaultStack)
            .entries((displayContext, entries) -> Registries.ITEM.getIds()
                    .stream()
                    .filter(key -> key.getNamespace().equals(SGCraft.MOD_ID))
                    .map(Registries.ITEM::getOrEmpty)
                    .map(Optional::orElseThrow)
                    .forEach(entries::add))
            .build());


    public static void load() {
    }

    public static <T extends ItemGroup> T register(String name, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, SGCraft.getID(name), itemGroup);
    }
}
