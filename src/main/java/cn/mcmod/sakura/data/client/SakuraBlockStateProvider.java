package cn.mcmod.sakura.data.client;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.block.nature.BambooPlant;
import cn.mcmod.sakura.block.nature.BurrChestnutBlock;
import cn.mcmod.sakura.block.nature.LeafPileBlock;
import cn.mcmod.sakura.block.nature.UmeLeavesBlock;
import cn.mcmod.sakura.fluid.FluidBlockRegistry;
import cn.mcmod_mmf.mmlib.data.AbstractBlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class SakuraBlockStateProvider extends AbstractBlockStateProvider {

    public SakuraBlockStateProvider(DataGenerator gen, String modId, ExistingFileHelper exFileHelper) {
        super(gen, modId, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockRegistry.SAKURA_LEAVES.get());
        umeLeavesBlock(BlockRegistry.UME_LEAVES);
        simpleBlock(BlockRegistry.SAKURA_PLANK.get());
        simpleBlock(BlockRegistry.UME_PLANK.get());
        simpleBlock(BlockRegistry.MAPLE_PLANK.get());
        simpleBlock(BlockRegistry.BAMBOO_PLANK.get());

        simpleBlock(BlockRegistry.STRAW_BLOCK.get());

        simpleBlock(BlockRegistry.GREEN_MAPLE_LEAVES.get());
        simpleBlock(BlockRegistry.YELLOW_MAPLE_LEAVES.get());
        simpleBlock(BlockRegistry.ORANGE_MAPLE_LEAVES.get());
        simpleBlock(BlockRegistry.RED_MAPLE_LEAVES.get());

        leafPileBlock(BlockRegistry.GREEN_MAPLE_LEAF_PILE);
        leafPileBlock(BlockRegistry.YELLOW_MAPLE_LEAF_PILE);
        leafPileBlock(BlockRegistry.ORANGE_MAPLE_LEAF_PILE);
        leafPileBlock(BlockRegistry.RED_MAPLE_LEAF_PILE);

        log(BlockRegistry.SAKURA_LOG);
        log(BlockRegistry.STRIPPED_SAKURA_LOG);
        log(BlockRegistry.UME_LOG);
        log(BlockRegistry.STRIPPED_UME_LOG);
        log(BlockRegistry.MAPLE_LOG);
        log(BlockRegistry.STRIPPED_MAPLE_LOG);
        log(BlockRegistry.BAMBOO_BLOCK);
        log(BlockRegistry.SUNBURNT_BAMBOO_BLOCK);
        log(BlockRegistry.CHARCOAL_BAMBOO_BLOCK);
        woodBlock(BlockRegistry.SAKURA_WOOD);
        woodBlock(BlockRegistry.STRIPPED_SAKURA_WOOD);
        woodBlock(BlockRegistry.UME_WOOD);
        woodBlock(BlockRegistry.STRIPPED_UME_WOOD);
        woodBlock(BlockRegistry.MAPLE_WOOD);
        woodBlock(BlockRegistry.STRIPPED_MAPLE_WOOD);

        horizontalBlock(BlockRegistry.FERMENTER.get(), models().getExistingFile(new ResourceLocation("sakura:block/fermenter")));
        crossBlock(BlockRegistry.SAKURA_SAPLING);
        crossBlock(BlockRegistry.UME_SAPLING);
        crossBlock(BlockRegistry.GREEN_MAPLE_SAPLING);
        crossBlock(BlockRegistry.YELLOW_MAPLE_SAPLING);
        crossBlock(BlockRegistry.ORANGE_MAPLE_SAPLING);
        crossBlock(BlockRegistry.RED_MAPLE_SAPLING);

        bambooPlantBlock(BlockRegistry.BAMBOO_PLANT);
        bambooPlantBlock(BlockRegistry.SUNBURNT_BAMBOO_PLANT);
        bambooPlantBlock(BlockRegistry.CHARCOAL_BAMBOO_PLANT);

        stageBlock(BlockRegistry.BUCKWHEAT_CROP, BlockStateProperties.AGE_7);
        stageBlock(BlockRegistry.RAPE_SEEDS_CROP, BlockStateProperties.AGE_7);
        stageBlock(BlockRegistry.RED_BEAN_CROP, BlockStateProperties.AGE_3);
        stageBlock(BlockRegistry.TARO_CROP, BlockStateProperties.AGE_3);
        ageBlock(BlockRegistry.BURR_CHESTNUT, BurrChestnutBlock.AGE, "block/tinted_cross");
        
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

    private void bushyBlock(@NotNull Block block, String name1, String name2) {
        var model1 = models().getExistingFile(modLoc(name1));
        var model2 = models().getExistingFile(modLoc(name2));

        // 2. 使用 getVariantBuilder 构建没有属性分支的默认变体
        getVariantBuilder(block)
                .partialState() // 空的属性条件，对应生成结果中的 ""
                .setModels(
                        ConfiguredModel.builder()
                                .modelFile(model1)
                                .nextModel()
                                .modelFile(model2)
                                .build()
                );
    }

    private void fluidBlock(RegistryObject<LiquidBlock> block) {
        ModelFile model = models().getExistingFile(modLoc("block/fluid"));
        getVariantBuilder(block.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(model).build());
    }

    private void leafPileBlock(RegistryObject<LeafPileBlock> block) {
        String name = block.getId().getPath();
        int[] layerArray = {1, 2, 3, 4, 6, 8, 10, 12, 14, 16};

        getVariantBuilder(block.get()).forAllStatesExcept(state -> {
            int layers = state.getValue(LeafPileBlock.LAYERS);
            ModelFile model = models().getExistingFile(modLoc("block/leaf_pile/" + name + "_height" + layerArray[layers]));

            return ConfiguredModel.builder().modelFile(model).build();
        }, LeafPileBlock.FACING, LeafPileBlock.WATERLOGGED);
    }

    private void ageBlock(RegistryObject<Block> block, IntegerProperty ageProperty, String mcLoc) {
        String name = block.getId().getPath();
        getVariantBuilder(block.get()).forAllStates(state -> {
            int age = state.getValue(ageProperty);
            ModelFile model = models()
                    .withExistingParent("block/" + name + "/" + name + "_" + age, mcLoc(mcLoc))
                    .texture("cross", modLoc("block/" + name + "/" + name + "_" + age));

            return ConfiguredModel.builder().modelFile(model).build();
        });
    }

    private void umeLeavesBlock(RegistryObject<Block> block) {

        getVariantBuilder(block.get()).forAllStatesExcept(state -> {
            int age = state.getValue(UmeLeavesBlock.AGE);
            ModelFile model;
            if (age == 0) model = models().withExistingParent("block/ume_leaves", mcLoc("block/leaves")).texture("all", modLoc("block/ume_leaves"));
            else if (age == 1) model = models().withExistingParent("block/ume_leaves_flower", mcLoc("block/leaves")).texture("all", modLoc("block/ume_leaves_flower"));
            else if (age == 2) model = models().getExistingFile(modLoc("block/ume_leaves_1"));
            else if (age == 3) model = models().getExistingFile(modLoc("block/ume_leaves_2"));
            else model = models().getExistingFile(modLoc("block/ume_leaves_3"));

            return ConfiguredModel.builder().modelFile(model).build();
        }, UmeLeavesBlock.DISTANCE, UmeLeavesBlock.PERSISTENT, UmeLeavesBlock.WATERLOGGED);
    }

    private void woodBlock(RegistryObject<? extends RotatedPillarBlock> block) {
        String path = block.getId().getPath();
        // UME_WOOD -> UME
        String prefix = path.substring(0,  path.lastIndexOf("_"));
        axisBlock(block.get(), texture(prefix + "_log"), texture(prefix + "_log"));
    }

    private void bambooPlantBlock(RegistryObject<Block> block) {
        String name = block.getId().getPath();
        // bamboo_plant → prefix = bamboo, sunburnt_bamboo_plant → prefix = sunburnt_bamboo
        String prefix = name.endsWith("_plant") ? name.substring(0, name.length() - "_plant".length()) : name;
        getVariantBuilder(block.get()).forAllStatesExcept(state -> {
            ModelFile model;
            switch (state.getValue(BambooPlant.LEAVES)) {
                case SMALL:
                    model = models().getExistingFile(modLoc("block/small_" + prefix + "_leaves"));
                    break;
                case LARGE:
                    model = models().getExistingFile(modLoc("block/large_" + prefix + "_leaves"));
                    break;
                default:
                    model = models().getExistingFile(modLoc("block/" + name));
                    break;
            }
            return ConfiguredModel.builder().modelFile(model).build();
        }, BambooPlant.STAGE, BambooPlant.WATERLOGGED);
    }

}
