package cn.mcmod.sakura.world;

import cn.mcmod.sakura.Sakura;
import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Sakura.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> FEATURE_PATCH_BAMBOOSHOOT;

    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_LEAF_PILE_LAYER;

    static {

        FEATURE_PATCH_BAMBOOSHOOT = CONFIGURED_FEATURE.register(
                "patch_bambooshoot",
                () -> wildPlantFeature(BlockRegistry.BAMBOO_SHOOT, BlockTags.DIRT));

        MAPLE_LEAF_PILE_LAYER = CONFIGURED_FEATURE.register(
                "maple_leaf_pile_layer",
                () -> new ConfiguredFeature<>(
                        ModFeatures.LEAF_PILE_COVER.get(), FeatureConfiguration.NONE)
        );

    }


    public static final BlockPos BLOCK_BELOW = new BlockPos(0, -1, 0);

    private static ConfiguredFeature<?, ?> wildPlantFeature(Supplier<Block> wildCrop, TagKey<Block> blockTag) {
        return new ConfiguredFeature<>(Feature.RANDOM_PATCH, getWildCropConfiguration(wildCrop.get(),
                64, 1, BlockPredicate.matchesTag(blockTag, new BlockPos(0, -1, 0))));
    }

    private static RandomPatchConfiguration getWildCropConfiguration(Block block, int tries, int xzSpread, BlockPredicate plantedOn) {
        return new RandomPatchConfiguration(tries, xzSpread, 3, PlacementUtils.filtered(
                Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block)),
                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, plantedOn)));
    }

    /**
     * Registers all miscellaneous overworld features into the game via the configured feature registry
     */
    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURE.register(eventBus);
    }
}