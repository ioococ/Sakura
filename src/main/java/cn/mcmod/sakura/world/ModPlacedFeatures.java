package cn.mcmod.sakura.world;

import cn.mcmod.sakura.Sakura;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.world.feature.TreeConfiguredFeatures;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Sakura.MOD_ID);


    public static final RegistryObject<PlacedFeature> MAPLE_LEAF_PILE_LAYER;

    public static final RegistryObject<PlacedFeature> PATCH_BAMBOOSHOOT;

    public static final RegistryObject<PlacedFeature> GREEN_MAPLE_TREE;
    public static final RegistryObject<PlacedFeature> YELLOW_MAPLE_TREE;
    public static final RegistryObject<PlacedFeature> ORANGE_MAPLE_TREE;
    public static final RegistryObject<PlacedFeature> RED_MAPLE_TREE;
    public static final RegistryObject<PlacedFeature> GREEN_FANCY_MAPLE_TREE;
    public static final RegistryObject<PlacedFeature> YELLOW_FANCY_MAPLE_TREE;
    public static final RegistryObject<PlacedFeature> ORANGE_FANCY_MAPLE_TREE;
    public static final RegistryObject<PlacedFeature> RED_FANCY_MAPLE_TREE;


    public static List<PlacementModifier> worldSurfaceSquaredWithRarityFilter(final int chance) {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }

    static {
        MAPLE_LEAF_PILE_LAYER = PLACED_FEATURES.register(
                "patch_maple_leaf_pile_layer",
                () -> new PlacedFeature(
                        ModConfiguredFeatures.MAPLE_LEAF_PILE_LAYER.getHolder().orElseThrow(),
                        List.of(BiomeFilter.biome())));

        PATCH_BAMBOOSHOOT = PLACED_FEATURES.register("patch_bambooshoot",
                () -> wildPlantPatch(
                        ModConfiguredFeatures.FEATURE_PATCH_BAMBOOSHOOT,
                            RarityFilter.onAverageOnceEvery(30),
                            InSquarePlacement.spread(),
                            PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        GREEN_MAPLE_TREE = PLACED_FEATURES.register("green_maple_tree",
                () -> mapleTreePatch(
                        TreeConfiguredFeatures.GREEN_MAPLE,
                        List.of(
                                RarityFilter.onAverageOnceEvery(4), // 生成频率
                                InSquarePlacement.spread(),          // 区块内随机位置
                                PlacementUtils.HEIGHTMAP, // 根据地表高度生成
                                BiomeFilter.biome(),                 // 生物群系过滤
                                SurfaceWaterDepthFilter.forMaxDepth(1) // 仅在水深≤1的地方生成（避免水中生成）


                        )));

        YELLOW_MAPLE_TREE = PLACED_FEATURES.register("yellow_maple_tree",
                () -> mapleTreePatch(
                        TreeConfiguredFeatures.YELLOW_MAPLE,
                        List.of(
                                RarityFilter.onAverageOnceEvery(4), // 生成频率
                                InSquarePlacement.spread(),          // 区块内随机位置
                                //PlacementUtils.filteredByBlockSurvival(BlockRegistry.GREEN_MAPLE_SAPLING.get()),
                                PlacementUtils.HEIGHTMAP, // 根据地表高度生成
                                BiomeFilter.biome(),                 // 生物群系过滤
                                SurfaceWaterDepthFilter.forMaxDepth(1) // 仅在水深≤2的地方生成（避免水中生成）
                        )));

        ORANGE_MAPLE_TREE = PLACED_FEATURES.register("orange_maple_tree",
                () -> mapleTreePatch(
                        TreeConfiguredFeatures.ORANGE_MAPLE,
                        List.of(
                                RarityFilter.onAverageOnceEvery(4), // 生成频率
                                InSquarePlacement.spread(),          // 区块内随机位置
                                // PlacementUtils.filteredByBlockSurvival(BlockRegistry.GREEN_MAPLE_SAPLING.get()),
                                PlacementUtils.HEIGHTMAP, // 根据地表高度生成
                                // BiomeFilter.biome(),                 // 生物群系过滤
                                SurfaceWaterDepthFilter.forMaxDepth(1) // 仅在水深≤2的地方生成（避免水中生成）
                        )));

        RED_MAPLE_TREE = PLACED_FEATURES.register("red_maple_tree",
                () -> mapleTreePatch(
                        TreeConfiguredFeatures.RED_MAPLE,
                        List.of(
                                RarityFilter.onAverageOnceEvery(4), // 生成频率
                                InSquarePlacement.spread(),          // 区块内随机位置
                                // PlacementUtils.filteredByBlockSurvival(BlockRegistry.GREEN_MAPLE_SAPLING.get()),
                                PlacementUtils.HEIGHTMAP, // 根据地表高度生成
                                BiomeFilter.biome(),                 // 生物群系过滤
                                SurfaceWaterDepthFilter.forMaxDepth(1) // 仅在水深≤2的地方生成（避免水中生成）
                        )));

        GREEN_FANCY_MAPLE_TREE = PLACED_FEATURES.register("green_fancy_maple_tree",
                () -> mapleTreePatch(
                        TreeConfiguredFeatures.GREEN_FANCY_MAPLE,
                        PlacementUtils.filteredByBlockSurvival(BlockRegistry.GREEN_MAPLE_SAPLING.get()))
        );

        YELLOW_FANCY_MAPLE_TREE = PLACED_FEATURES.register("yellow_fancy_maple_tree",
                () -> mapleTreePatch(
                        TreeConfiguredFeatures.YELLOW_FANCY_MAPLE,
                        PlacementUtils.filteredByBlockSurvival(BlockRegistry.YELLOW_MAPLE_SAPLING.get()))
        );

        ORANGE_FANCY_MAPLE_TREE = PLACED_FEATURES.register("orange_fancy_maple_tree",
                () -> mapleTreePatch(
                        TreeConfiguredFeatures.YELLOW_FANCY_MAPLE,
                        PlacementUtils.filteredByBlockSurvival(BlockRegistry.ORANGE_MAPLE_SAPLING.get()))
        );

        RED_FANCY_MAPLE_TREE = PLACED_FEATURES.register("red_fancy_maple_tree",
                () -> mapleTreePatch(
                        TreeConfiguredFeatures.RED_FANCY_MAPLE,
                        PlacementUtils.filteredByBlockSurvival(BlockRegistry.RED_MAPLE_SAPLING.get()))
        );

    }

    private static PlacedFeature mapleTreePatch(RegistryObject<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        return new PlacedFeature(feature.getHolder().orElseThrow(), Lists.newArrayList(modifiers));
    }

    private static PlacedFeature mapleTreePatch(RegistryObject<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placement) {
        return new PlacedFeature(feature.getHolder().orElseThrow(), placement);
    }

    private static PlacedFeature wildPlantPatch(RegistryObject<ConfiguredFeature<?, ?>> feature,
                                                PlacementModifier... modifiers) {
        return new PlacedFeature(feature.getHolder().orElseThrow(), Lists.newArrayList(modifiers));

    }

    private static ImmutableList<PlacementModifier> treePlacement(Block block, PlacementModifier modifier) {
        return ImmutableList.<PlacementModifier>builder()
                .add(modifier)
                .add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO)))
                .add(InSquarePlacement.spread())
                .add(VegetationPlacements.TREE_THRESHOLD)
                .add(HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING))
                .add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
                .add(BiomeFilter.biome()).build();
    }

    private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier modifier) {
        return ImmutableList.<PlacementModifier>builder()
                .add(modifier)
                .add(InSquarePlacement.spread())
                .add(VegetationPlacements.TREE_THRESHOLD)
                .add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
                .add(BiomeFilter.biome());
    }
}