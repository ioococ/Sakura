package cn.mcmod.sakura.world.feature;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.world.ModConfiguredFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.registries.RegistryObject;

import java.util.OptionalInt;

public class TreeConfiguredFeatures {

    public static final RegistryObject<ConfiguredFeature<?, ?>> UME = ModConfiguredFeatures.CONFIGURED_FEATURE.register("ume",
            () -> registryTree(createSimpleBlobTree(BlockRegistry.UME_LOG.get(), BlockRegistry.UME_LEAVES.get()).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SAKURA = ModConfiguredFeatures.CONFIGURED_FEATURE.register("sakura",
            () -> registryTree(createSimpleBlobTree(BlockRegistry.SAKURA_LOG.get(), BlockRegistry.SAKURA_LEAVES.get()).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_SAKURA = ModConfiguredFeatures.CONFIGURED_FEATURE.register("fancy_sakura",
            () -> registryTree(createFancyTree(BlockRegistry.SAKURA_LOG.get(), BlockRegistry.SAKURA_LEAVES.get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GREEN_MAPLE = ModConfiguredFeatures.CONFIGURED_FEATURE.register("green_maple",
            () -> registryTree(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.GREEN_MAPLE_LEAVES.get(), 5, 2, 0, 2).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GREEN_FANCY_MAPLE = ModConfiguredFeatures.CONFIGURED_FEATURE.register("green_fancy_maple",
            () -> registryTree(createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.GREEN_MAPLE_LEAVES.get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> YELLOW_MAPLE = ModConfiguredFeatures.CONFIGURED_FEATURE.register("yellow_maple",
            () -> registryTree(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.YELLOW_MAPLE_LEAVES.get(), 5, 2, 0, 2).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> YELLOW_FANCY_MAPLE = ModConfiguredFeatures.CONFIGURED_FEATURE.register("yellow_fancy_maple",
            () -> registryTree(createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.YELLOW_MAPLE_LEAVES.get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_MAPLE = ModConfiguredFeatures.CONFIGURED_FEATURE.register("orange_maple",
            () -> registryTree(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.ORANGE_MAPLE_LEAVES.get(), 5, 2, 0, 2).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_FANCY_MAPLE = ModConfiguredFeatures.CONFIGURED_FEATURE.register("orange_fancy_maple",
            () -> registryTree(createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.ORANGE_MAPLE_LEAVES.get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> RED_MAPLE = ModConfiguredFeatures.CONFIGURED_FEATURE.register("red_maple",
            () -> registryTree(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.RED_MAPLE_LEAVES.get(), 5, 2, 0, 2).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> RED_FANCY_MAPLE = ModConfiguredFeatures.CONFIGURED_FEATURE.register("red_fancy_maple",
            () -> registryTree(createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.RED_MAPLE_LEAVES.get())));


    public static ConfiguredFeature<TreeConfiguration, ?> registryTree(TreeConfiguration.TreeConfigurationBuilder tree) {
        return new ConfiguredFeature<>(Feature.TREE, tree.build());
    }

    public static TreeConfiguration.TreeConfigurationBuilder createSimpleBlobTree(Block log, Block leaves) {
        return createStraightBlobTree(log, leaves, 4, 2, 0, 2);
    }

    public static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block log, Block leaves,
                                                                                    int baseHeight, int heightRandA, int heightRandB, int leavesRadius) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(log),
                new StraightTrunkPlacer(baseHeight, heightRandA, heightRandB),
                BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(ConstantInt.of(leavesRadius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1));
    }

    public static TreeConfiguration.TreeConfigurationBuilder createFancyTree(Block log, Block leaves) {
        TreeConfiguration.TreeConfigurationBuilder treeConfigurationBuilder = new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(log),
                new FancyTrunkPlacer(3, 11, 0),
                BlockStateProvider.simple(leaves),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)));

        return treeConfigurationBuilder.ignoreVines();
    }
}