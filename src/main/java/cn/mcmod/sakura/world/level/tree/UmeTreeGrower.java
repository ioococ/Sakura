package cn.mcmod.sakura.world.level.tree;

import cn.mcmod.sakura.world.feature.TreeConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public class UmeTreeGrower extends AbstractTreeGrower {

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean hasBees) {
        return TreeConfiguredFeatures.UME.getHolder().orElseThrow();
    }
    @Override
    public boolean growTree(ServerLevel level, ChunkGenerator generator, BlockPos pos, BlockState state, Random random) {

        // TODO Auto-generated method stub
        return super.growTree(level, generator, pos, state, random);
    }

    private Boolean isPlaceable(ServerLevel level, BlockPos blockpos, Random random) {
        boolean randomInt = random.nextInt(3) > 0;
        boolean emptyBlock = level.isEmptyBlock(blockpos) || level.isWaterAt(blockpos);
        boolean maxBuildHeight = blockpos.getY() < level.getMaxBuildHeight();
        boolean material = level.getBlockState(blockpos.below()).getMaterial().isSolid();
        return randomInt && emptyBlock && maxBuildHeight && material;
    }
}