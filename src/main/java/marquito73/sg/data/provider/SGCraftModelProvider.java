package marquito73.sg.data.provider;

import marquito73.sg.SGCraft;
import marquito73.sg.init.BlockInit;
import marquito73.sg.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;

public class SGCraftModelProvider extends FabricModelProvider {
    public SGCraftModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.NAQUADAH_BLOCK);

        // Ores

        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.NAQUADAH_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.DEEPSLATE_NAQUADAH_ORE);

        // Stargate

        // Stargate ring block
        blockStateModelGenerator.registerCubeWithCustomTextures(BlockInit.STARGATE_RING, BlockInit.STARGATE_RING,
                (block, source) -> TextureMap.of(TextureKey.PARTICLE, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.TOP, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.SIDE, SGCraft.getID("block/stargate_ring"))
                        .put(TextureKey.BOTTOM, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.UP, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.DOWN, SGCraft.getID("block/stargate_block"))
        );
        // Stargate chevron block
        blockStateModelGenerator.registerCubeWithCustomTextures(BlockInit.STARGATE_CHEVRON, BlockInit.STARGATE_CHEVRON,
                (block, source) -> TextureMap.of(TextureKey.PARTICLE, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.TOP, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.SIDE, SGCraft.getID("block/stargate_chevron"))
                        .put(TextureKey.BOTTOM, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.UP, SGCraft.getID("block/stargate_block"))
                        .put(TextureKey.DOWN, SGCraft.getID("block/stargate_block"))
        );
        // Stargate base block
        // TODO Check how put a different texture on front of block
        blockStateModelGenerator.registerCubeWithCustomTextures(BlockInit.STARGATE_BASE, BlockInit.STARGATE_BASE,
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
        itemModelGenerator.register(ItemInit.NAQUADAH_INGOT, Models.GENERATED);
        itemModelGenerator.register(ItemInit.NAQUADAH_RAW, Models.GENERATED);

        itemModelGenerator.register(ItemInit.STARGATE_CORE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ItemInit.STARGATE_CONTROLLER_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ItemInit.STARGATE_PEGASUS_UPGRADE_CRYSTAL, Models.GENERATED);

        itemModelGenerator.register(ItemInit.STARGATE_CHEVRON_UPGRADE, Models.GENERATED);

        itemModelGenerator.register(ItemInit.STARGATE_IRIS_BLADE, Models.GENERATED);
        itemModelGenerator.register(ItemInit.STARGATE_IRIS_UPGRADE, Models.GENERATED);
    }
}
