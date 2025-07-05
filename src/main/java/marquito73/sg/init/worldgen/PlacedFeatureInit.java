package marquito73.sg.init.worldgen;

import marquito73.sg.SGCraft;
import marquito73.sg.common.Modifiers;
import marquito73.sg.init.SGCraftBlocks;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class PlacedFeatureInit {
    public static final RegistryKey<PlacedFeature> NAQUADAH_ORE_KEY = registerKey(SGCraftBlocks.NAQUADAH_ORE.getTranslationKey());
    public static final RegistryKey<PlacedFeature> DEEPSLATE_NAQUADAH_ORE_KEY = registerKey(SGCraftBlocks.DEEPSLATE_NAQUADAH_ORE.getTranslationKey());

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, NAQUADAH_ORE_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.NAQUADAH_ORE_KEY),
                Modifiers.modifiersCount(9, HeightRangePlacementModifier.uniform(YOffset.fixed(-20), YOffset.fixed(50))));

        register(context, DEEPSLATE_NAQUADAH_ORE_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.DEEPSLATE_NAQUADAH_ORE_KEY),
                Modifiers.modifiersCount(9, HeightRangePlacementModifier.uniform(YOffset.fixed(-20), YOffset.fixed(50))));
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, SGCraft.getID(name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context,
                                                                            RegistryKey<PlacedFeature> key,
                                                                            RegistryEntry<ConfiguredFeature<?, ?>> config,
                                                                            List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, modifiers));
    }
}
