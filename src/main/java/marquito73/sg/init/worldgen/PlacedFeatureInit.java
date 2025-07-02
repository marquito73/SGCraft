package marquito73.sg.init.worldgen;

import marquito73.sg.SGCraft;
import marquito73.sg.common.Modifiers;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class PlacedFeatureInit {
    public static final RegistryKey<PlacedFeature> OVERWORLD_NAQUADAH_ORE_KEY = registerKey("overworld_naquadah_ore");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, OVERWORLD_NAQUADAH_ORE_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.OVERWORLD_NAQUADAH_ORE_KEY),
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
