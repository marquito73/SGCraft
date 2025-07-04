package marquito73.sg.data.provider;

import marquito73.sg.init.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class SGCraftBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public SGCraftBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        this.getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockInit.NAQUADAH_BLOCK)
                .add(BlockInit.STARGATE_RING)
                .add(BlockInit.STARGATE_CHEVRON)
                .add(BlockInit.STARGATE_BASE)
                .add(BlockInit.NAQUADAH_ORE);

        this.getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockInit.DEEPSLATE_NAQUADAH_ORE);

        this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(BlockInit.NAQUADAH_BLOCK)
                .add(BlockInit.STARGATE_RING)
                .add(BlockInit.STARGATE_CHEVRON)
                .add(BlockInit.STARGATE_BASE)
                .add(BlockInit.NAQUADAH_ORE)
                .add(BlockInit.DEEPSLATE_NAQUADAH_ORE);
    }
}
