package marquito73.sg;

import marquito73.sg.data.generator.SGCraftWorldGenerator;
import marquito73.sg.data.provider.SGCraftBlockLootTableProvider;
import marquito73.sg.data.provider.SGCraftBlockTagProvider;
import marquito73.sg.data.provider.SGCraftModelProvider;
import marquito73.sg.data.provider.SGCraftRecipeProvider;
import marquito73.sg.data.provider.languages.SGCraftEnglishLanguageProvider;
import marquito73.sg.init.worldgen.ConfiguredFeatureInit;
import marquito73.sg.init.worldgen.PlacedFeatureInit;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class SGCraftDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // Providers
        pack.addProvider(SGCraftModelProvider::new);
        pack.addProvider(SGCraftBlockLootTableProvider::new);
        pack.addProvider(SGCraftBlockTagProvider::new);
        pack.addProvider(SGCraftRecipeProvider::new);

        // Languages providers
        pack.addProvider(SGCraftEnglishLanguageProvider::new);

        // World generator provider
        pack.addProvider(SGCraftWorldGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatureInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatureInit::bootstrap);
    }
}
