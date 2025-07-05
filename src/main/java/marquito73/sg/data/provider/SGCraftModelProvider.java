package marquito73.sg.data.provider;

import marquito73.sg.SGCraft;
import marquito73.sg.init.SGCraftBlocks;
import marquito73.sg.init.SGCraftItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;

public class SGCraftModelProvider extends FabricModelProvider {
    public SGCraftModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(SGCraftBlocks.NAQUADAH_BLOCK);

        // Ores

        blockStateModelGenerator.registerSimpleCubeAll(SGCraftBlocks.NAQUADAH_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SGCraftBlocks.DEEPSLATE_NAQUADAH_ORE);

        // Stargate

        // Stargate ring block
        blockStateModelGenerator.registerCubeWithCustomTextures(SGCraftBlocks.STARGATE_RING, SGCraftBlocks.STARGATE_RING,
                (block, source) -> TextureMap.of(TextureKey.PARTICLE, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.TOP, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.SIDE, SGCraft.getID("block/stargate_ring"))
                        .put(TextureKey.BOTTOM, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.UP, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.DOWN, SGCraft.getID("block/stargate_block"))
        );
        // Stargate chevron block
        blockStateModelGenerator.registerCubeWithCustomTextures(SGCraftBlocks.STARGATE_CHEVRON, SGCraftBlocks.STARGATE_CHEVRON,
                (block, source) -> TextureMap.of(TextureKey.PARTICLE, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.TOP, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.SIDE, SGCraft.getID("block/stargate_chevron"))
                        .put(TextureKey.BOTTOM, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.UP, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.DOWN, SGCraft.getID("block/stargate_block"))
        );
        // Stargate base block
        // TODO Check how put a different texture on front of block
        blockStateModelGenerator.registerCubeWithCustomTextures(SGCraftBlocks.STARGATE_BASE, SGCraftBlocks.STARGATE_BASE,
                (block, source) -> TextureMap.of(TextureKey.PARTICLE, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.TOP, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.SIDE, SGCraft.getID("block/stargate_base"))
                        .put(TextureKey.BOTTOM, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.UP, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.DOWN, SGCraft.getID("block/stargate_block"))
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(SGCraftItems.NAQUADAH_INGOT, Models.GENERATED);
        itemModelGenerator.register(SGCraftItems.NAQUADAH_RAW, Models.GENERATED);

        itemModelGenerator.register(SGCraftItems.STARGATE_CORE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(SGCraftItems.STARGATE_CONTROLLER_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(SGCraftItems.STARGATE_PEGASUS_UPGRADE_CRYSTAL, Models.GENERATED);

        itemModelGenerator.register(SGCraftItems.STARGATE_CHEVRON_UPGRADE, Models.GENERATED);

        itemModelGenerator.register(SGCraftItems.STARGATE_IRIS_BLADE, Models.GENERATED);
        itemModelGenerator.register(SGCraftItems.STARGATE_IRIS_UPGRADE, Models.GENERATED);
    }
}
