package marquito73.sg.init;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;

public class ChestLootTableInit {
    public static void load() {
        manageLoots();
    }

    private static void manageLoots() {
        LootTableEvents.MODIFY.register((key, tablebuilder, source, registry) -> {
            generateDungeonChestLoots(key, tablebuilder);
        });
    }

    private static void generateDungeonChestLoots(RegistryKey<LootTable> key, LootTable.Builder tablebuilder) {
        LootPool pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.25f))
                .with(ItemEntry.builder(SGCraftItems.STARGATE_CONTROLLER_CRYSTAL))
                .with(ItemEntry.builder(SGCraftItems.STARGATE_CORE_CRYSTAL))
                .build();

        if (LootTables.SIMPLE_DUNGEON_CHEST.equals(key) || LootTables.DESERT_PYRAMID_CHEST.equals(key)) {
            tablebuilder.pool(pool);
        }
    }
}
