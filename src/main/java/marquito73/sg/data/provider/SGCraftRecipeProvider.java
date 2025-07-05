package marquito73.sg.data.provider;

import marquito73.sg.SGCraft;
import marquito73.sg.init.SGCraftBlocks;
import marquito73.sg.init.SGCraftItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

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
                List.of(SGCraftItems.NAQUADAH_RAW),
                RecipeCategory.MISC,
                SGCraftItems.NAQUADAH_INGOT,
                0.7f,
                200,
                "naquadah");

        // Blasting
        offerBlasting(exporter,
                List.of(SGCraftItems.NAQUADAH_RAW),
                RecipeCategory.MISC,
                SGCraftItems.NAQUADAH_INGOT,
                0.7f,
                100,
                "naquadah");

        this.manageRecipes(exporter);
    }

    private void manageRecipes(RecipeExporter exporter) {
        // Naquadah
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, SGCraftBlocks.NAQUADAH_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', SGCraftItems.NAQUADAH_INGOT)
                .criterion(FabricRecipeProvider.hasItem(SGCraftItems.NAQUADAH_INGOT),
                        FabricRecipeProvider.conditionsFromItem(SGCraftItems.NAQUADAH_INGOT))
                .offerTo(exporter, SGCraft.getID(SGCraftBlocks.NAQUADAH_BLOCK.getTranslationKey()));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, SGCraftItems.NAQUADAH_INGOT, 9)
                .input(SGCraftBlocks.NAQUADAH_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(SGCraftBlocks.NAQUADAH_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(SGCraftBlocks.NAQUADAH_BLOCK))
                .offerTo(exporter, SGCraft.getID(SGCraftItems.NAQUADAH_INGOT.getTranslationKey()));


        // Pegasus upgrade crystal
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, SGCraftItems.STARGATE_PEGASUS_UPGRADE_CRYSTAL)
                .pattern("GLG")
                .pattern("RSR")
                .pattern("GLG")
                .input('G', Items.GLOWSTONE_DUST)
                .input('L', Items.LAPIS_BLOCK)
                .input('R', Items.REDSTONE)
                .input('S', SGCraftItems.STARGATE_CORE_CRYSTAL)
                .criterion(FabricRecipeProvider.hasItem(Items.GLOWSTONE_DUST),
                        FabricRecipeProvider.conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(FabricRecipeProvider.hasItem(Items.LAPIS_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(Items.LAPIS_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(Items.REDSTONE),
                        FabricRecipeProvider.conditionsFromItem(Items.REDSTONE))
                .criterion(FabricRecipeProvider.hasItem(SGCraftItems.STARGATE_CORE_CRYSTAL),
                        FabricRecipeProvider.conditionsFromItem(SGCraftItems.STARGATE_CORE_CRYSTAL))
                .offerTo(exporter, SGCraft.getID(SGCraftItems.STARGATE_PEGASUS_UPGRADE_CRYSTAL.getTranslationKey()));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, SGCraftItems.STARGATE_PEGASUS_UPGRADE_CRYSTAL, 2)
                .pattern("GLG")
                .pattern("RSR")
                .pattern("GLG")
                .input('G', Items.GLOWSTONE_DUST)
                .input('L', Items.LAPIS_BLOCK)
                .input('R', Items.REDSTONE)
                .input('S', SGCraftItems.STARGATE_PEGASUS_UPGRADE_CRYSTAL)
                .criterion(FabricRecipeProvider.hasItem(Items.GLOWSTONE_DUST),
                        FabricRecipeProvider.conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(FabricRecipeProvider.hasItem(Items.LAPIS_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(Items.LAPIS_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(Items.REDSTONE),
                        FabricRecipeProvider.conditionsFromItem(Items.REDSTONE))
                .criterion(FabricRecipeProvider.hasItem(SGCraftItems.STARGATE_PEGASUS_UPGRADE_CRYSTAL),
                        FabricRecipeProvider.conditionsFromItem(SGCraftItems.STARGATE_PEGASUS_UPGRADE_CRYSTAL))
                .offerTo(exporter, SGCraft.getID(SGCraftItems.STARGATE_PEGASUS_UPGRADE_CRYSTAL.getTranslationKey() + "_2"));


        // Iris
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, SGCraftItems.STARGATE_IRIS_BLADE)
                .pattern(" II")
                .pattern("IC ")
                .pattern("I  ")
                .input('I', Items.IRON_INGOT)
                .input('C', Items.COAL)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.COAL),
                        FabricRecipeProvider.conditionsFromItem(Items.COAL))
                .offerTo(exporter, SGCraft.getID(SGCraftItems.STARGATE_IRIS_BLADE.getTranslationKey()));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, SGCraftItems.STARGATE_IRIS_UPGRADE)
                .pattern("III")
                .pattern("IRI")
                .pattern("III")
                .input('I', SGCraftItems.STARGATE_IRIS_BLADE)
                .input('R', Items.REDSTONE)
                .criterion(FabricRecipeProvider.hasItem(SGCraftItems.STARGATE_IRIS_BLADE),
                        FabricRecipeProvider.conditionsFromItem(SGCraftItems.STARGATE_IRIS_BLADE))
                .criterion(FabricRecipeProvider.hasItem(Items.REDSTONE),
                        FabricRecipeProvider.conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, SGCraft.getID(SGCraftItems.STARGATE_IRIS_UPGRADE.getTranslationKey()));
    }
}
