package cn.mcmod.sakura.level.tree;

import java.util.OptionalInt;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.level.WorldGenerationRegistry;
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

public class SakuraTreeFeatures {

    public static final RegistryObject<ConfiguredFeature<?, ?>> SAKURA = WorldGenerationRegistry.FEATURES.register("sakura",
            ()->registryTree(createSimpleBlobTree(BlockRegistry.SAKURA_LOG.get(), BlockRegistry.SAKURA_LEAVES.get()).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_SAKURA = WorldGenerationRegistry.FEATURES.register("fancy_sakura",
            ()->registryTree(createFancyTree(BlockRegistry.SAKURA_LOG.get(), BlockRegistry.SAKURA_LEAVES.get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GREEN_MAPLE = WorldGenerationRegistry.FEATURES.register("green_maple",
            ()->registryTree(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(),BlockRegistry.GREEN_MAPLE_LEAVES.get(), 5, 2, 0, 2).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_GREEN_MAPLE = WorldGenerationRegistry.FEATURES.register("fancy_green_maple",
            ()->registryTree(createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.GREEN_MAPLE_LEAVES.get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> YELLOW_MAPLE = WorldGenerationRegistry.FEATURES.register("yellow_maple",
            ()->registryTree(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(),BlockRegistry.YELLOW_MAPLE_LEAVES.get(), 5, 2, 0, 2).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_YELLOW_MAPLE = WorldGenerationRegistry.FEATURES.register("fancy_maple_yellow",
            ()->registryTree(createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.YELLOW_MAPLE_LEAVES.get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_MAPLE = WorldGenerationRegistry.FEATURES.register("orange_maple",
            ()->registryTree(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(),BlockRegistry.ORANGE_MAPLE_LEAVES.get(), 5, 2, 0, 2).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_ORANGE_MAPLE = WorldGenerationRegistry.FEATURES.register("fancy_orange_maple",
            ()->registryTree(createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.ORANGE_MAPLE_SAPLING.get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> RED_MAPLE = WorldGenerationRegistry.FEATURES.register("red_maple",
            ()->registryTree(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(),BlockRegistry.RED_MAPLE_LEAVES.get(), 5, 2, 0, 2).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_RED_MAPLE = WorldGenerationRegistry.FEATURES.register("fancy_maple_red",
            ()->registryTree(createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.RED_MAPLE_SAPLING.get())));

    private static ConfiguredFeature<?, ?> registryTree(TreeConfiguration.TreeConfigurationBuilder tree){
        return new ConfiguredFeature<>(Feature.TREE, tree.build());
    }
    
    private static TreeConfiguration.TreeConfigurationBuilder createSimpleBlobTree(Block log, Block leaves) {
        return createStraightBlobTree(log, leaves, 4, 2, 0, 2);
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block log, Block leaves,
            int baseHeight, int heightRandA, int heightRandB, int leaves_radius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log),
                new StraightTrunkPlacer(baseHeight, heightRandA, heightRandB), BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(ConstantInt.of(leaves_radius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createFancyTree(Block log, Block leaves) {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log),
                new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(leaves),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }
}
