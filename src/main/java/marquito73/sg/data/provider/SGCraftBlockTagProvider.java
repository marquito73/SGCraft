package marquito73.sg.data.provider;

import marquito73.sg.init.SGCraftBlocks;
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
                .add(SGCraftBlocks.NAQUADAH_BLOCK)
                .add(SGCraftBlocks.STARGATE_RING)
                .add(SGCraftBlocks.STARGATE_CHEVRON)
                .add(SGCraftBlocks.STARGATE_BASE)
                .add(SGCraftBlocks.NAQUADAH_ORE);

        this.getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(SGCraftBlocks.DEEPSLATE_NAQUADAH_ORE);

        this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(SGCraftBlocks.NAQUADAH_BLOCK)
                .add(SGCraftBlocks.STARGATE_RING)
                .add(SGCraftBlocks.STARGATE_CHEVRON)
                .add(SGCraftBlocks.STARGATE_BASE)
                .add(SGCraftBlocks.NAQUADAH_ORE)
                .add(SGCraftBlocks.DEEPSLATE_NAQUADAH_ORE);
    }
}
