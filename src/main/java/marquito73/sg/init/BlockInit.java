package marquito73.sg.init;

import marquito73.sg.SGCraft;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class BlockInit {
    public static final Block NAQUADAH_BLOCK = registerWithItem("naquadah_block", new Block(AbstractBlock.Settings
            .create()
            .strength(1.5F, 6.0F)
            .requiresTool()));

    // Ores

    public static final Block OVERWORLD_NAQUADAH_ORE = registerWithItem("overworld_naquadah_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 6), Block.Settings
                    .create()
                    .strength(3F, 3F)
                    .requiresTool()
                    .mapColor(MapColor.STONE_GRAY)));

    public static final Block DEEPSLATE_NAQUADAH_ORE = registerWithItem("deepslate_naquadah_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 6), Block.Settings
                    .create()
                    .strength(4.5F, 3F)
                    .requiresTool()
                    .mapColor(MapColor.STONE_GRAY)));

    public static void load() {

    }

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, SGCraft.getID(name), block);
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block);

        ItemInit.register(name, new BlockItem(registered, settings));

        return registered;
    }
    public static <T extends Block> T registerWithItem(String name, T block) {
        return registerWithItem(name, block, new Item.Settings());
    }
}
