package cn.mcmod.sakura.world.level.tree;

import java.util.Random;

import cn.mcmod.sakura.world.feature.TreeConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class SakuraTreeGrower extends AbstractTreeGrower {

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean hasBees) {
        if (random.nextInt(10) == 0) {
            return TreeConfiguredFeatures.FANCY_SAKURA.getHolder().orElseThrow();
        } else {
            return TreeConfiguredFeatures.SAKURA.getHolder().orElseThrow();
        }
    }

}
