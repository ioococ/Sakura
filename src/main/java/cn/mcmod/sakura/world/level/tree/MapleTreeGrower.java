package cn.mcmod.sakura.world.level.tree;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.registries.RegistryObject;

import java.util.Random;

public class MapleTreeGrower extends AbstractTreeGrower {
    private final RegistryObject<ConfiguredFeature<?, ?>> tree;
    private final RegistryObject<ConfiguredFeature<?, ?>> fancyTree;

    public MapleTreeGrower(RegistryObject<ConfiguredFeature<?, ?>> tree,RegistryObject<ConfiguredFeature<?, ?>> fancyTree) {
        this.tree = tree;
        this.fancyTree = fancyTree;
    }

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean hasBees) {
        if (random.nextInt(10) == 0) {
            return this.fancyTree.getHolder().get();
        } else {
            return this.tree.getHolder().get();
        }
    }
    @Override
    public boolean growTree(ServerLevel level, ChunkGenerator generator, BlockPos pos, BlockState state, Random random) {

        // TODO Auto-generated method stub
        return super.growTree(level, generator, pos, state, random);
    }
}
