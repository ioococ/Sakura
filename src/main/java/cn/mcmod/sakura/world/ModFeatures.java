package cn.mcmod.sakura.world;

import cn.mcmod.sakura.Sakura;
import cn.mcmod.sakura.world.feature.LeafPileCoverFeature;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES;

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LEAF_PILE_COVER;


    static {
        FEATURES = DeferredRegister.create(Registry.FEATURE_REGISTRY, Sakura.MOD_ID);

        LEAF_PILE_COVER = FEATURES.register("maple_leaf_pile_layer", LeafPileCoverFeature::new);
    }

    public static void register(IEventBus bus) {
        FEATURES.register(bus);
    }

}