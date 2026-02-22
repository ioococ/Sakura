package cn.mcmod.sakura.block;

import cn.mcmod.sakura.Sakura;
import cn.mcmod.sakura.block.crops.RiceCrop;
import cn.mcmod.sakura.block.crops.RiceCropRoot;
import cn.mcmod.sakura.block.foods.NabeBlock;
import cn.mcmod.sakura.block.foods.TeishokuBlock;
import cn.mcmod.sakura.block.foods.TeishokuFinishedBlock;
import cn.mcmod.sakura.block.machines.ChoppingBoardBlock;
import cn.mcmod.sakura.block.machines.CookingPotBlock;
import cn.mcmod.sakura.block.machines.DistillerBlock;
import cn.mcmod.sakura.block.machines.FermenterBlock;
import cn.mcmod.sakura.block.machines.StoneMortarBlock;
import cn.mcmod.sakura.client.particle.ParticleRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod.sakura.level.tree.MapleTreeGrower;
import cn.mcmod.sakura.level.tree.SakuraTreeFeatures;
import cn.mcmod.sakura.level.tree.SakuraTreeGrower;
import cn.mcmod_mmf.mmlib.block.Age3CropBlock;
import cn.mcmod_mmf.mmlib.block.BaseCropBlock;
import cn.mcmod_mmf.mmlib.block.BaseHorizonBlock;
import cn.mcmod_mmf.mmlib.block.FacingSlab;
import cn.mcmod_mmf.mmlib.block.HighCropBlock;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Sakura.MOD_ID);

    public static final RegistryObject<Block> SAKURA_LEAVES = BLOCKS.register("sakura_leaves",
            () -> new SakuraLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion(), ParticleRegistry.SAKURA_LEAF));

    public static final RegistryObject<Block> GREEN_MAPLE_LEAVES = BLOCKS.register("green_maple_leaves",
            () -> new SakuraLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion(), ParticleRegistry.RED_MAPLE_LEAF));
    public static final RegistryObject<Block> YELLOW_MAPLE_LEAVES = BLOCKS.register("yellow_maple_leaves",
            () -> new SakuraLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion(), ParticleRegistry.YELLOW_MAPLE_LEAF));
    public static final RegistryObject<Block> ORANGE_MAPLE_LEAVES = BLOCKS.register("orange_maple_leaves",
            () -> new SakuraLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion(), ParticleRegistry.ORANGE_MAPLE_LEAF));
    public static final RegistryObject<Block> RED_MAPLE_LEAVES = BLOCKS.register("red_maple_leaves",
            () -> new SakuraLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion(), ParticleRegistry.GREEN_MAPLE_LEAF));

    public static final RegistryObject<RotatedPillarBlock> SAKURA_LOG = BLOCKS.register("sakura_log",
            () -> log(MaterialColor.WOOD, MaterialColor.PODZOL));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SAKURA_LOG = BLOCKS.register("stripped_sakura_log",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));

    public static final RegistryObject<RotatedPillarBlock> SAKURA_WOOD = BLOCKS.register("sakura_wood",
            () -> log(MaterialColor.PODZOL, MaterialColor.PODZOL));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SAKURA_WOOD = BLOCKS.register("stripped_sakura_wood",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));

    public static final RegistryObject<SaplingBlock> SAKURA_SAPLING = BLOCKS.register("sakura_sapling",
            () -> sapling(new SakuraTreeGrower()));

    public static final RegistryObject<RotatedPillarBlock> MAPLE_LOG = BLOCKS.register("maple_log",
            MapleTreeLogBlock::new);

    public static final RegistryObject<RotatedPillarBlock> MAPLE_SAP_LOG = BLOCKS.register("maple_sap_log",
            MapleTreeSapLogBlock::new);

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_MAPLE_LOG = BLOCKS.register("stripped_maple_log",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));

    public static final RegistryObject<RotatedPillarBlock> MAPLE_WOOD = BLOCKS.register("maple_wood",
            () -> log(MaterialColor.PODZOL, MaterialColor.PODZOL));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_MAPLE_WOOD = BLOCKS.register("stripped_maple_wood",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));

    public static final RegistryObject<RotatedPillarBlock> BAMBOO_BLOCK = BLOCKS.register("bamboo_block", BambooBlock::new);
    public static final RegistryObject<RotatedPillarBlock> SUNBURNT_BAMBOO_BLOCK = BLOCKS
            .register("sunburnt_bamboo_block", () -> simplebambooBlock(MaterialColor.SAND, MaterialColor.WOOD));
    public static final RegistryObject<RotatedPillarBlock> CHARCOAL_BAMBOO_BLOCK = BLOCKS.register(
            "charcoal_bamboo_block", () -> simplebambooBlock(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_BLACK));

    public static final RegistryObject<Block> GREEN_MAPLE_SAPLING = BLOCKS.register("green_maple_sapling",
            () -> sapling(new MapleTreeGrower(SakuraTreeFeatures.GREEN_MAPLE, SakuraTreeFeatures.FANCY_GREEN_MAPLE)));
    public static final RegistryObject<Block> YELLOW_MAPLE_SAPLING = BLOCKS.register("yellow_maple_sapling",
            () -> sapling(new MapleTreeGrower(SakuraTreeFeatures.YELLOW_MAPLE, SakuraTreeFeatures.FANCY_YELLOW_MAPLE)));
    public static final RegistryObject<Block> ORANGE_MAPLE_SAPLING = BLOCKS.register("orange_maple_sapling",
            () -> sapling(new MapleTreeGrower(SakuraTreeFeatures.ORANGE_MAPLE, SakuraTreeFeatures.FANCY_ORANGE_MAPLE)));
    public static final RegistryObject<Block> RED_MAPLE_SAPLING = BLOCKS.register("red_maple_sapling",
            () -> sapling(new MapleTreeGrower(SakuraTreeFeatures.RED_MAPLE, SakuraTreeFeatures.FANCY_RED_MAPLE)));

    public static final RegistryObject<Block> BAMBOO_PLANT = BLOCKS.register("bamboo_plant", BambooPlant::new);
    public static final RegistryObject<Block> BAMBOO_SHOOT = BLOCKS.register("bamboo_shoot", BambooShoot::new);

    public static final RegistryObject<Block> SAKURA_PLANK = BLOCKS.register("sakura_plank", () -> plank(MaterialColor.WOOD));
    public static final RegistryObject<Block> MAPLE_PLANK = BLOCKS.register("maple_plank", () -> plank(MaterialColor.SAND));
    public static final RegistryObject<Block> BAMBOO_PLANK = BLOCKS.register("bamboo_plank", () -> plank(MaterialColor.SAND));
    
    public static final RegistryObject<Block> STRAW_BLOCK = BLOCKS.register("straw_block",
            () -> new Block(Block.Properties.copy(Blocks.HAY_BLOCK)));

    public static final RegistryObject<Block> TATAMI = BLOCKS.register("tatami",
            () -> new TatamiBlock(Block.Properties.copy(Blocks.HAY_BLOCK)));
    public static final RegistryObject<FacingSlab> TATAMI_SLAB = BLOCKS.register("tatami_slab",
            () -> new TatamiSlabBlock(Block.Properties.copy(Blocks.HAY_BLOCK)));
    public static final RegistryObject<Block> SUNBURNT_TATAMI = BLOCKS.register("sunburnt_tatami",
            () -> new BaseHorizonBlock(Block.Properties.copy(Blocks.HAY_BLOCK)));
    public static final RegistryObject<FacingSlab> SUNBURNT_TATAMI_SLAB = BLOCKS.register("sunburnt_tatami_slab",
            () -> new FacingSlab(Block.Properties.copy(Blocks.HAY_BLOCK)));

    public static final RegistryObject<Block> RICE_CROP_ROOT = BLOCKS.register("rice_crop_root",
            () -> new RiceCropRoot(Block.Properties.copy(Blocks.WHEAT).strength(0.2F)));
    public static final RegistryObject<Block> RICE_CROP = BLOCKS.register("rice_crop",
            () -> new RiceCrop(Block.Properties.copy(Blocks.WHEAT).strength(0.2F)));

    public static final RegistryObject<Block> CABBAGE_CROP = BLOCKS.register("cabbage_crop",
            () -> new BaseCropBlock(Block.Properties.copy(Blocks.CARROTS).strength(0.2F), ItemRegistry.CABBAGE_SEEDS));

    public static final RegistryObject<Block> RADISH_CROP = BLOCKS.register("radish_crop",
            () -> new Age3CropBlock(Block.Properties.copy(Blocks.CARROTS).strength(0.2F), ItemRegistry.RADISH_SEEDS));

    public static final RegistryObject<Block> ONION_CROP = BLOCKS.register("onion_crop",
            () -> new Age3CropBlock(Block.Properties.copy(Blocks.CARROTS).strength(0.2F), ItemRegistry.ONION_SEEDS));

    public static final RegistryObject<Block> RED_BEAN_CROP = BLOCKS.register("red_bean_crop",
            () -> new Age3CropBlock(Block.Properties.copy(Blocks.WHEAT).strength(0.2F), ItemRegistry.RED_BEAN));

    public static final RegistryObject<Block> SOYBEAN_CROP = BLOCKS.register("soybean_crop",
            () -> new Age3CropBlock(Block.Properties.copy(Blocks.WHEAT).strength(0.2F), ItemRegistry.SOYBEAN));

    public static final RegistryObject<Block> RAPE_SEEDS_CROP = BLOCKS.register("rape_seeds_crop",
            () -> new BaseCropBlock(Block.Properties.copy(Blocks.WHEAT).strength(0.2F), ItemRegistry.RAPE_SEEDS));

    public static final RegistryObject<Block> BUCKWHEAT_CROP = BLOCKS.register("buckwheat_crop",
            () -> new BaseCropBlock(Block.Properties.copy(Blocks.WHEAT).strength(0.2F), ItemRegistry.BUCKWHEAT));

    public static final RegistryObject<Block> TARO_CROP = BLOCKS.register("taro_crop",
            () -> new Age3CropBlock(Block.Properties.copy(Blocks.WHEAT).strength(0.2F), ItemRegistry.TARO));

    public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop",
            () -> new HighCropBlock(Block.Properties.copy(Blocks.CARROTS).strength(0.2F), ItemRegistry.TOMATO_SEEDS));

    public static final RegistryObject<Block> EGGPLANT_CROP = BLOCKS.register("eggplant_crop",
            () -> new HighCropBlock(Block.Properties.copy(Blocks.CARROTS).strength(0.2F), ItemRegistry.EGGPLANT_SEEDS));

    public static final RegistryObject<Block> STONE_MORTAR = BLOCKS.register("stone_mortar", StoneMortarBlock::new);
    public static final RegistryObject<Block> COOKING_POT = BLOCKS.register("cooking_pot", CookingPotBlock::new);
    public static final RegistryObject<Block> FERMENTER = BLOCKS.register("fermenter", FermenterBlock::new);
    public static final RegistryObject<Block> DISTILLER = BLOCKS.register("distiller", DistillerBlock::new);
    public static final RegistryObject<Block> OBON = BLOCKS.register("obon", ObonBlock::new);
    public static final RegistryObject<Block> CHOPPING_BOARD = BLOCKS.register("chopping_board", ChoppingBoardBlock::new);
    public static final RegistryObject<Block> FINISHED_TEISHOKU = BLOCKS.register("finished_teishoku", TeishokuFinishedBlock::new);
    public static final RegistryObject<Block> SHIOYAKI_TEISHOKU = BLOCKS.register("sashimi_teishoku",
            ()->new TeishokuBlock(FoodInfo.builder().amountAndCalories(8, 0.8f).build()));
    public static final RegistryObject<Block> YAKIZANA_TEISHOKU = BLOCKS.register("yakizana_teishoku",
            ()->new TeishokuBlock(FoodInfo.builder().amountAndCalories(8, 0.8f).build()));
    public static final RegistryObject<Block> SASHIMI_TEISHOKU = BLOCKS.register("shioyaki_teishoku",
            ()->new TeishokuBlock(FoodInfo.builder().amountAndCalories(6, 0.8f).build()));
    public static final RegistryObject<Block> TAMAGOYAKI_TEISHOKU = BLOCKS.register("tamagoyaki_teishoku",
            ()->new TeishokuBlock(FoodInfo.builder().amountAndCalories(6, 0.8f).build()));
    public static final RegistryObject<Block> YAKINIKU_TEISHOKU = BLOCKS.register("yakiniku_teishoku",
            ()->new TeishokuBlock(FoodInfo.builder().amountAndCalories(10, 0.8f).build()));

    public static final RegistryObject<Block> SUKIYAKI_NABE = BLOCKS.register("sukiyaki_nabe",
            ()->new NabeBlock(FoodInfo.builder().amountAndCalories(12, 1f).build()));
    public static final RegistryObject<Block> ODEN_NABE = BLOCKS.register("oden_nabe",
            ()->new NabeBlock(FoodInfo.builder().amountAndCalories(12, 1f).build()));
    
    private static RotatedPillarBlock log(MaterialColor top, MaterialColor bark) {
        return new RotatedPillarBlock(BlockBehaviour.Properties
                .of(Material.WOOD, state -> (state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? top : bark))
                .strength(2.0F).sound(SoundType.WOOD));
    }

    private static SaplingBlock sapling(AbstractTreeGrower tree) {
        return new SaplingBlock(tree, BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks()
                .instabreak().sound(SoundType.GRASS));
    }

    private static RotatedPillarBlock simplebambooBlock(MaterialColor top, MaterialColor bark) {
        return new RotatedPillarBlock(BlockBehaviour.Properties
                .of(Material.BAMBOO,
                        state -> (state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? top : bark))
                .strength(2.0F).sound(SoundType.BAMBOO));
    }

    private static Block plank(MaterialColor material_color) {
        return new Block(
                BlockBehaviour.Properties.of(Material.WOOD, material_color).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }

}
