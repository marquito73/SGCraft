package marquito73.sg.data.provider;

import marquito73.sg.SGCraft;
import marquito73.sg.init.BlockInit;
import marquito73.sg.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SGCraftRecipeProvider extends FabricRecipeProvider {
    public SGCraftRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // Smelting
        offerSmelting(exporter,
                List.of(ItemInit.NAQUADAH_RAW),
                RecipeCategory.MISC,
                ItemInit.NAQUADAH_INGOT,
                0.7f,
                200,
                "naquadah");

        // Blasting
        offerBlasting(exporter,
                List.of(ItemInit.NAQUADAH_RAW),
                RecipeCategory.MISC,
                ItemInit.NAQUADAH_INGOT,
                0.7f,
                100,
                "naquadah");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.NAQUADAH_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ItemInit.NAQUADAH_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ItemInit.NAQUADAH_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ItemInit.NAQUADAH_INGOT))
                .offerTo(exporter, SGCraft.getID(BlockInit.NAQUADAH_BLOCK.getTranslationKey()));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.NAQUADAH_INGOT, 9)
                .input(BlockInit.NAQUADAH_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.NAQUADAH_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(BlockInit.NAQUADAH_BLOCK))
                .offerTo(exporter, SGCraft.getID(ItemInit.NAQUADAH_INGOT.getTranslationKey()));
    }
}
