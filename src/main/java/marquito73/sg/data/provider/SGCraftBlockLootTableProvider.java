package marquito73.sg.data.provider;

import marquito73.sg.init.SGCraftBlocks;
import marquito73.sg.init.SGCraftItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SGCraftBlockLootTableProvider extends FabricBlockLootTableProvider {

    public SGCraftBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        this.addDrop(SGCraftBlocks.NAQUADAH_BLOCK);
        this.addDrop(SGCraftBlocks.STARGATE_RING);
        this.addDrop(SGCraftBlocks.STARGATE_CHEVRON);
        this.addDrop(SGCraftBlocks.STARGATE_BASE);

        this.addDrop(SGCraftBlocks.NAQUADAH_ORE,
                this.oreDrops(SGCraftBlocks.NAQUADAH_ORE, SGCraftItems.NAQUADAH_RAW));

        this.addDrop(SGCraftBlocks.DEEPSLATE_NAQUADAH_ORE,
                this.oreDrops(SGCraftBlocks.DEEPSLATE_NAQUADAH_ORE, SGCraftItems.NAQUADAH_RAW));
    }
}
