package cn.mcmod.sakura.block.artificial;

import java.util.Random;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod_mmf.mmlib.block.FacingSlab;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;

public class TatamiSlabBlock extends FacingSlab {

    public TatamiSlabBlock(Properties prop) {
        super(prop.randomTicks());
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        super.randomTick(state, worldIn, pos, rand);
        if (worldIn.isDay() && worldIn.canSeeSky(pos)) {
            worldIn.setBlockAndUpdate(pos, BlockRegistry.SUNBURNT_TATAMI_SLAB.get().withPropertiesOf(state));
        }
    }

}
