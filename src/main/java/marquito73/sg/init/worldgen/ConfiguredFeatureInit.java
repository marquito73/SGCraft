package marquito73.sg.init.worldgen;

import marquito73.sg.SGCraft;
import marquito73.sg.init.SGCraftBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ConfiguredFeatureInit {
    public static final RegistryKey<ConfiguredFeature<?, ?>> NAQUADAH_ORE_KEY = registerKey(SGCraftBlocks.NAQUADAH_ORE.getTranslationKey());
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_NAQUADAH_ORE_KEY = registerKey(SGCraftBlocks.DEEPSLATE_NAQUADAH_ORE.getTranslationKey());


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneOreReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateOreReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldTargets = List.of(
                OreFeatureConfig.createTarget(stoneOreReplaceables, SGCraftBlocks.NAQUADAH_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateOreReplaceables, SGCraftBlocks.DEEPSLATE_NAQUADAH_ORE.getDefaultState())
        );

        register(context, NAQUADAH_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTargets, 9));
        register(context, DEEPSLATE_NAQUADAH_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTargets, 9));
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, SGCraft.getID(name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                            RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                            F feature,
                                                                            FC featureConfig) {
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }
}
