package cn.mcmod.sakura.world.feature.placement;

import cn.mcmod.sakura.world.feature.modifier.ModPlacementModifierTypes;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.placement.RepeatingPlacement;

import java.util.Random;

public class MapleTreePlacement extends RepeatingPlacement {
    private static final MapleTreePlacement INSTANCE = new MapleTreePlacement();
    public static final Codec<MapleTreePlacement> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    protected int count(Random random, BlockPos blockPos) {
        int countConfig = 0;
        float chanceConfig = 0.5F;
        int extraCountConfig = 1;
        float weight = 1.0F / chanceConfig;
        SimpleWeightedRandomList<IntProvider> list =
                SimpleWeightedRandomList.<IntProvider>builder()
                        .add(ConstantInt.of(countConfig), (int)weight - 1)
                        .add(ConstantInt.of(countConfig + extraCountConfig), 1).build();
        return new WeightedListInt(list).sample(random);
    }

    @Override
    public PlacementModifierType<?> type() {
        return ModPlacementModifierTypes.MAPLE_TREE.get();
    }
}