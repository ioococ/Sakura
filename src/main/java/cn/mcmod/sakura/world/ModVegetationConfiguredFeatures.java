package cn.mcmod.sakura.world;

import cn.mcmod.sakura.Sakura;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomBooleanFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModVegetationConfiguredFeatures {
    public static ConfiguredFeature<RandomBooleanFeatureConfiguration, ?> TREES_GREEN_MAPLE;
    public static ConfiguredFeature<RandomBooleanFeatureConfiguration, ?> TREES_YELLOW_MAPLE;
    public static ConfiguredFeature<RandomBooleanFeatureConfiguration, ?> TREES_ORANGE_MAPLE;
    public static ConfiguredFeature<RandomBooleanFeatureConfiguration, ?> TREES_RED_MAPLE;

    /**
     * Registers all vegatation features into the game via the configured feature registry
     */
    public static void register(IEventBus eventBus) {
        TREES_GREEN_MAPLE = Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                new ResourceLocation(Sakura.MOD_ID, "trees_green_maple"),
                new ConfiguredFeature<>(
                        Feature.RANDOM_BOOLEAN_SELECTOR,
                        new RandomBooleanFeatureConfiguration( // 使用 RandomBooleanFeatureConfiguration
                                ModPlacedFeatures.GREEN_MAPLE_TREE.getHolder().orElseThrow(), // 第一个特征
                                ModPlacedFeatures.GREEN_FANCY_MAPLE_TREE.getHolder().orElseThrow() // 第二个特征
                        )
                )
        );
        TREES_YELLOW_MAPLE = Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                new ResourceLocation(Sakura.MOD_ID, "trees_yellow_maple"),
                new ConfiguredFeature<>(
                        Feature.RANDOM_BOOLEAN_SELECTOR,
                        new RandomBooleanFeatureConfiguration( // 使用 RandomBooleanFeatureConfiguration
                                ModPlacedFeatures.YELLOW_MAPLE_TREE.getHolder().orElseThrow(), // 第一个特征
                                ModPlacedFeatures.YELLOW_FANCY_MAPLE_TREE.getHolder().orElseThrow() // 第二个特征
                        )
                )
        );
        TREES_ORANGE_MAPLE = Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                new ResourceLocation(Sakura.MOD_ID, "trees_orange_maple"),
                new ConfiguredFeature<>(
                        Feature.RANDOM_BOOLEAN_SELECTOR,
                        new RandomBooleanFeatureConfiguration( // 使用 RandomBooleanFeatureConfiguration
                                ModPlacedFeatures.ORANGE_MAPLE_TREE.getHolder().orElseThrow(), // 第一个特征
                                ModPlacedFeatures.ORANGE_FANCY_MAPLE_TREE.getHolder().orElseThrow() // 第二个特征
                        )
                )
        );
        TREES_RED_MAPLE = Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                new ResourceLocation(Sakura.MOD_ID, "trees_red_maple"),
                new ConfiguredFeature<>(
                        Feature.RANDOM_BOOLEAN_SELECTOR,
                        new RandomBooleanFeatureConfiguration( // 使用 RandomBooleanFeatureConfiguration
                                ModPlacedFeatures.RED_MAPLE_TREE.getHolder().orElseThrow(), // 第一个特征
                                ModPlacedFeatures.RED_FANCY_MAPLE_TREE.getHolder().orElseThrow() // 第二个特征
                        )
                )
        );
    }
}