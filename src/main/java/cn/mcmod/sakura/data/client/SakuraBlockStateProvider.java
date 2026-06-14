package cn.mcmod.sakura.data.client;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.fluid.FluidBlockRegistry;
import cn.mcmod_mmf.mmlib.data.AbstractBlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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

        fluidBlock(FluidBlockRegistry.BEER_BLOCK);
        fluidBlock(FluidBlockRegistry.BRANDY_BLOCK);
        fluidBlock(FluidBlockRegistry.CHAMPAGNE_BLOCK);
        fluidBlock(FluidBlockRegistry.COCOA_LIQUEUR_BLOCK);
        fluidBlock(FluidBlockRegistry.DOBUROKU_BLOCK);
        fluidBlock(FluidBlockRegistry.FOOD_OIL_BLOCK);
        fluidBlock(FluidBlockRegistry.GIN_BLOCK);
        fluidBlock(FluidBlockRegistry.GREEN_GRAPE_JUICE_BLOCK);
        fluidBlock(FluidBlockRegistry.HOT_SPRING_BLOCK);
        fluidBlock(FluidBlockRegistry.LIQUEUR_BLOCK);
        fluidBlock(FluidBlockRegistry.MAPLE_SAP_BLOCK);
        fluidBlock(FluidBlockRegistry.MAPLE_SYRUP_BLOCK);
        fluidBlock(FluidBlockRegistry.PURPLE_GRAPE_JUICE_BLOCK);
        fluidBlock(FluidBlockRegistry.RED_WINE_BLOCK);
        fluidBlock(FluidBlockRegistry.RUM_BLOCK);
        fluidBlock(FluidBlockRegistry.SAKE_BLOCK);
        fluidBlock(FluidBlockRegistry.SHOUCHU_BLOCK);
        fluidBlock(FluidBlockRegistry.TEQUILA_BLOCK);
        fluidBlock(FluidBlockRegistry.VODKA_BLOCK);
        fluidBlock(FluidBlockRegistry.WHISKEY_BLOCK);
        fluidBlock(FluidBlockRegistry.WHITE_WINE_BLOCK);
        fluidBlock(FluidBlockRegistry.YEAST_FLUID_BLOCK);
    }

    private void fluidBlock(RegistryObject<LiquidBlock> block) {
        ModelFile model = models().getExistingFile(modLoc("block/fluid"));
        getVariantBuilder(block.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(model).build());
    }

}
