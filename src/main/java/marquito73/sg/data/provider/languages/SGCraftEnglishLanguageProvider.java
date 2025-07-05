package marquito73.sg.data.provider.languages;

import marquito73.sg.SGCraft;
import marquito73.sg.init.SGCraftBlocks;
import marquito73.sg.init.ItemGroupInit;
import marquito73.sg.init.SGCraftItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class SGCraftEnglishLanguageProvider extends FabricLanguageProvider {
    public SGCraftEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    private void addText(@NotNull TranslationBuilder builder, @NotNull Text text, @NotNull String value) {
        if (text.getContent() instanceof TranslatableTextContent translatableTextContent) {
            builder.add(translatableTextContent.getKey(), value);
        } else {
            SGCraft.LOGGER.warn("Failed to add translations for text: {}", text.getString());
        }
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        // Item groups
        this.addText(translationBuilder, ItemGroupInit.STARGATE_TITLE, "Stargate");
        // Items

        // Naquadah
        translationBuilder.add(SGCraftItems.NAQUADAH_INGOT, "Naquadah Ingot");
        translationBuilder.add(SGCraftItems.NAQUADAH_RAW, "Naquadah Raw");

        // Crystal
        translationBuilder.add(SGCraftItems.STARGATE_CORE_CRYSTAL, "Stargate Core Crystal");
        translationBuilder.add(SGCraftItems.STARGATE_CONTROLLER_CRYSTAL, "Stargate Controller Crystal");
        translationBuilder.add(SGCraftItems.STARGATE_PEGASUS_UPGRADE_CRYSTAL, "Pegasus Upgrade Cystal");

        // Chevron upgade
        translationBuilder.add(SGCraftItems.STARGATE_CHEVRON_UPGRADE, "Stargate Chevron Upgrade");

        // Iris
        translationBuilder.add(SGCraftItems.STARGATE_IRIS_BLADE, "Stargate Iris Blade");
        translationBuilder.add(SGCraftItems.STARGATE_IRIS_UPGRADE, "Stargate Iris Upgrade");


        // Blocks
        translationBuilder.add(SGCraftBlocks.NAQUADAH_BLOCK, "Block of Naquadah");
        translationBuilder.add(SGCraftBlocks.NAQUADAH_ORE, "Naquadah Ore");
        translationBuilder.add(SGCraftBlocks.DEEPSLATE_NAQUADAH_ORE, "Naquadah Deepslate Ore");
        translationBuilder.add(SGCraftBlocks.STARGATE_RING, "Stargate Ring Block");
        translationBuilder.add(SGCraftBlocks.STARGATE_CHEVRON, "Stargate Chevron Block");
        translationBuilder.add(SGCraftBlocks.STARGATE_BASE, "Stargate Base Block");
    }
}
