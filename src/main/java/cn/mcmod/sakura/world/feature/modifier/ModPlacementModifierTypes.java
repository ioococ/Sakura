package cn.mcmod.sakura.world.feature.modifier;

import cn.mcmod.sakura.Sakura;
import cn.mcmod.sakura.world.feature.placement.MapleTreePlacement;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacementModifierTypes {
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIER_TYPES = DeferredRegister.create(Registry.PLACEMENT_MODIFIER_REGISTRY, Sakura.MOD_ID);

    public static final RegistryObject<PlacementModifierType<MapleTreePlacement>> MAPLE_TREE =
            PLACEMENT_MODIFIER_TYPES.register(
                    "maple_tree", () -> () -> MapleTreePlacement.CODEC);
}