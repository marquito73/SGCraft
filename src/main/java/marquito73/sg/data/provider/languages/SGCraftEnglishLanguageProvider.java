package marquito73.sg.data.provider.languages;

import marquito73.sg.SGCraft;
import marquito73.sg.init.BlockInit;
import marquito73.sg.init.ItemGroupInit;
import marquito73.sg.init.ItemInit;
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
        translationBuilder.add(ItemInit.NAQUADAH_INGOT, "Naquadah Ingot");
        translationBuilder.add(ItemInit.NAQUADAH_RAW, "Naquadah Raw");

        // Crystal
        translationBuilder.add(ItemInit.STARGATE_CORE_CRYSTAL, "Stargate Core Crystal");
        translationBuilder.add(ItemInit.STARGATE_CONTROLLER_CRYSTAL, "Stargate Controller Crystal");
        translationBuilder.add(ItemInit.STARGATE_PEGASUS_UPGRADE_CRYSTAL, "Pegasus Upgrade Cystal");

        // Chevron upgade
        translationBuilder.add(ItemInit.STARGATE_CHEVRON_UPGRADE, "Stargate Chevron Upgrade");

        // Iris
        translationBuilder.add(ItemInit.STARGATE_IRIS_BLADE, "Stargate Iris Blade");
        translationBuilder.add(ItemInit.STARGATE_IRIS_UPGRADE, "Stargate Iris Upgrade");


        // Blocks
        translationBuilder.add(BlockInit.NAQUADAH_BLOCK, "Block of Naquadah");
        translationBuilder.add(BlockInit.NAQUADAH_ORE, "Naquadah Ore");
        translationBuilder.add(BlockInit.DEEPSLATE_NAQUADAH_ORE, "Naquadah Deepslate Ore");
        translationBuilder.add(BlockInit.STARGATE_RING, "Stargate Ring Block");
        translationBuilder.add(BlockInit.STARGATE_CHEVRON, "Stargate Chevron Block");
        translationBuilder.add(BlockInit.STARGATE_BASE, "Stargate Base Block");
    }
}
