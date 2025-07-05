package marquito73.sg.data.provider;

import marquito73.sg.init.BlockInit;
import marquito73.sg.init.ItemInit;
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
        this.addDrop(BlockInit.NAQUADAH_BLOCK);
        this.addDrop(BlockInit.STARGATE_RING);
        this.addDrop(BlockInit.STARGATE_CHEVRON);
        this.addDrop(BlockInit.STARGATE_BASE);

        this.addDrop(BlockInit.NAQUADAH_ORE,
                this.oreDrops(BlockInit.NAQUADAH_ORE, ItemInit.NAQUADAH_RAW));

        this.addDrop(BlockInit.DEEPSLATE_NAQUADAH_ORE,
                this.oreDrops(BlockInit.DEEPSLATE_NAQUADAH_ORE, ItemInit.NAQUADAH_RAW));
    }
}
