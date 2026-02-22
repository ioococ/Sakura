package cn.mcmod.sakura.data.client;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod_mmf.mmlib.data.AbstractBlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SakuraBlockStateProvider extends AbstractBlockStateProvider {

    public SakuraBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockRegistry.SAKURA_LEAVES.get());
        simpleBlock(BlockRegistry.SAKURA_PLANK.get());
        simpleBlock(BlockRegistry.MAPLE_PLANK.get());
        simpleBlock(BlockRegistry.BAMBOO_PLANK.get());
        
        simpleBlock(BlockRegistry.STRAW_BLOCK.get());

        simpleBlock(BlockRegistry.GREEN_MAPLE_LEAVES.get());
        simpleBlock(BlockRegistry.YELLOW_MAPLE_LEAVES.get());
        simpleBlock(BlockRegistry.ORANGE_MAPLE_LEAVES.get());
        simpleBlock(BlockRegistry.RED_MAPLE_LEAVES.get());

        log(BlockRegistry.SAKURA_LOG);
        log(BlockRegistry.STRIPPED_SAKURA_LOG);
        log(BlockRegistry.MAPLE_LOG);
        log(BlockRegistry.STRIPPED_MAPLE_LOG);
        log(BlockRegistry.BAMBOO_BLOCK);
        log(BlockRegistry.SUNBURNT_BAMBOO_BLOCK);
        log(BlockRegistry.CHARCOAL_BAMBOO_BLOCK);

        horizontalBlock(BlockRegistry.FERMENTER.get(), models().getExistingFile(new ResourceLocation("sakura:block/fermenter")));
        crossBlock(BlockRegistry.SAKURA_SAPLING);
        crossBlock(BlockRegistry.RED_MAPLE_SAPLING);
        crossBlock(BlockRegistry.YELLOW_MAPLE_SAPLING);
        crossBlock(BlockRegistry.GREEN_MAPLE_SAPLING);
        crossBlock(BlockRegistry.ORANGE_MAPLE_SAPLING);

        stageBlock(BlockRegistry.BUCKWHEAT_CROP, BlockStateProperties.AGE_7);
        stageBlock(BlockRegistry.RAPE_SEEDS_CROP, BlockStateProperties.AGE_7);
        stageBlock(BlockRegistry.RED_BEAN_CROP, BlockStateProperties.AGE_3);
        stageBlock(BlockRegistry.TARO_CROP, BlockStateProperties.AGE_3);
        
        horizontalBlock(BlockRegistry.TATAMI.get(), 
                texture("tatami"), 
                texture("tatami"), 
                texture("tatami"));
        horizontalBlock(BlockRegistry.SUNBURNT_TATAMI.get(),
                texture("tan_tatami"), 
                texture("tan_tatami"), 
                texture("tan_tatami"));
        
        facingSlabBlock(BlockRegistry.TATAMI_SLAB, 
                texture("tatami"), 
                texture("tatami"), 
                texture("tatami")
        );
        facingSlabBlock(BlockRegistry.SUNBURNT_TATAMI_SLAB,
                texture("tan_tatami"), 
                texture("tan_tatami"), 
                texture("tan_tatami")
        );
    }

}
