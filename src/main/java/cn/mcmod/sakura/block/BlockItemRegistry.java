package cn.mcmod.sakura.block;

import cn.mcmod.sakura.Sakura;
import cn.mcmod.sakura.item.StoneMortarItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Sakura.MOD_ID);

    public static final RegistryObject<Item> SAKURA_LEAVES = ITEMS.register("sakuraleaves",
            () -> new BlockItem(BlockRegistry.SAKURA_LEAVES.get(), Sakura.defaultItemProperties()));

    public static final RegistryObject<Item> MAPLE_LEAVES_RED = ITEMS.register("mapleleaves_red",
            () -> new BlockItem(BlockRegistry.MAPLE_LEAVES_RED.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_LEAVES_YELLOW = ITEMS.register("mapleleaves_yellow",
            () -> new BlockItem(BlockRegistry.MAPLE_LEAVES_YELLOW.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_LEAVES_ORANGE = ITEMS.register("mapleleaves_orange",
            () -> new BlockItem(BlockRegistry.MAPLE_LEAVES_ORANGE.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_LEAVES_GREEN = ITEMS.register("mapleleaves_green",
            () -> new BlockItem(BlockRegistry.MAPLE_LEAVES_GREEN.get(), Sakura.defaultItemProperties()));

    public static final RegistryObject<Item> SAKURA_LOG = ITEMS.register("sakura_log",
            () -> new BlockItem(BlockRegistry.SAKURA_LOG.get(), Sakura.defaultItemProperties()));

    public static final RegistryObject<Item> STRIPPED_SAKURA_LOG = ITEMS.register("stripped_sakura_log",
            () -> new BlockItem(BlockRegistry.STRIPPED_SAKURA_LOG.get(), Sakura.defaultItemProperties()));

    public static final RegistryObject<Item> SAKURA_WOOD = ITEMS.register("sakura_wood",
            () -> new BlockItem(BlockRegistry.SAKURA_WOOD.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> STRIPPED_SAKURA_WOOD = ITEMS.register("stripped_sakura_wood",
            () -> new BlockItem(BlockRegistry.STRIPPED_SAKURA_WOOD.get(), Sakura.defaultItemProperties()));

    public static final RegistryObject<Item> MAPLE_LOG = ITEMS.register("maple_log",
            () -> new BlockItem(BlockRegistry.MAPLE_LOG.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> STRIPPED_MAPLE_LOG = ITEMS.register("stripped_maple_log",
            () -> new BlockItem(BlockRegistry.STRIPPED_MAPLE_LOG.get(), Sakura.defaultItemProperties()));

    public static final RegistryObject<Item> MAPLE_WOOD = ITEMS.register("maple_wood",
            () -> new BlockItem(BlockRegistry.MAPLE_WOOD.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> STRIPPED_MAPLE_WOOD = ITEMS.register("stripped_maple_wood",
            () -> new BlockItem(BlockRegistry.STRIPPED_MAPLE_WOOD.get(), Sakura.defaultItemProperties()));

    public static final RegistryObject<Item> BAMBOO_BLOCK = ITEMS.register("bamboo_block",
            () -> new BlockItem(BlockRegistry.BAMBOO_BLOCK.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> BAMBOO_BLOCK_SUNBURNT = ITEMS.register("bamboo_block_sunburnt",
            () -> new BlockItem(BlockRegistry.BAMBOO_BLOCK_SUNBURNT.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> BAMBOO_CHARCOAL_BLOCK = ITEMS.register("bamboo_charcoal_block",
            () -> new BlockItem(BlockRegistry.BAMBOO_CHARCOAL_BLOCK.get(), Sakura.defaultItemProperties()));

    public static final RegistryObject<Item> SAKURA_PLANK = ITEMS.register("plank_sakura",
            () -> new BlockItem(BlockRegistry.SAKURA_PLANK.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_PLANK = ITEMS.register("plank_maple",
            () -> new BlockItem(BlockRegistry.MAPLE_PLANK.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> BAMBOO_PLANK = ITEMS.register("plank_bamboo",
            () -> new BlockItem(BlockRegistry.BAMBOO_PLANK.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> TATAMI = ITEMS.register("tatami",
            () -> new BlockItem(BlockRegistry.TATAMI.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> TATAMI_SLAB = ITEMS.register("tatami_slab",
            () -> new BlockItem(BlockRegistry.TATAMI_SLAB.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> TATAMI_SUNBURNT = ITEMS.register("tatami_sunburnt",
            () -> new BlockItem(BlockRegistry.TATAMI_SUNBURNT.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> TATAMI_SLAB_SUNBURNT = ITEMS.register("tatami_slab_sunburnt",
            () -> new BlockItem(BlockRegistry.TATAMI_SLAB_SUNBURNT.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> STRAW_BLOCK = ITEMS.register("straw_block",
            () -> new BlockItem(BlockRegistry.STRAW_BLOCK.get(), Sakura.defaultItemProperties()));

    public static final RegistryObject<Item> BAMBOOSHOOT = ITEMS.register("bamboo_shoot",
            () -> new BlockItem(BlockRegistry.BAMBOOSHOOT.get(), Sakura.defaultItemProperties()));

    public static final RegistryObject<Item> SAKURA_SAPLING = ITEMS.register("sakura_sapling",
            () -> new BlockItem(BlockRegistry.SAKURA_SAPLING.get(), Sakura.defaultItemProperties()));

    public static final RegistryObject<Item> MAPLE_SAPLING_RED = ITEMS.register("maple_sapling_red",
            () -> new BlockItem(BlockRegistry.MAPLE_SAPLING_RED.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_SAPLING_YELLOW = ITEMS.register("maple_sapling_yellow",
            () -> new BlockItem(BlockRegistry.MAPLE_SAPLING_YELLOW.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_SAPLING_ORANGE = ITEMS.register("maple_sapling_orange",
            () -> new BlockItem(BlockRegistry.MAPLE_SAPLING_ORANGE.get(), Sakura.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_SAPLING_GREEN = ITEMS.register("maple_sapling_green",
            () -> new BlockItem(BlockRegistry.MAPLE_SAPLING_GREEN.get(), Sakura.defaultItemProperties()));

    public static final RegistryObject<Item> STONE_MORTAR = ITEMS.register("stone_mortar", StoneMortarItem::new);

    public static final RegistryObject<Item> COOKING_POT = ITEMS.register("cooking_pot",
            () -> new BlockItem(BlockRegistry.COOKING_POT.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> FERMENTER = ITEMS.register("fermenter",
            () -> new BlockItem(BlockRegistry.FERMENTER.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> DISTILLER = ITEMS.register("distiller",
            () -> new BlockItem(BlockRegistry.DISTILLER.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> OBON = ITEMS.register("obon",
            () -> new BlockItem(BlockRegistry.OBON.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> CHOPPING_BOARD = ITEMS.register("chopping_board",
            () -> new BlockItem(BlockRegistry.CHOPPING_BOARD.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> TEISHOUKU_FISH_RAW = ITEMS.register("teishoku_fish_raw",
            () -> new BlockItem(BlockRegistry.TEISHOUKU_FISH_RAW.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> TEISHOUKU_FISH_COOKED = ITEMS.register("teishoku_fish_cooked",
            () -> new BlockItem(BlockRegistry.TEISHOUKU_FISH_COOKED.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> TEISHOUKU_FISH_SALT = ITEMS.register("teishoku_fish_salt",
            () -> new BlockItem(BlockRegistry.TEISHOUKU_FISH_SALT.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> TEISHOKO_TAMAGOYAKI = ITEMS.register("teishoku_tamagoyaki",
            () -> new BlockItem(BlockRegistry.TEISHOKO_TAMAGOYAKI.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> TEISHOKO_YAKINIKU = ITEMS.register("teishoku_yakiniku",
            () -> new BlockItem(BlockRegistry.TEISHOKO_YAKINIKU.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> NABE_SUKIYAKI = ITEMS.register("nabe_sukiyaki",
            () -> new BlockItem(BlockRegistry.NABE_SUKIYAKI.get(), Sakura.defaultItemProperties()));
    
    public static final RegistryObject<Item> NABE_ODEN = ITEMS.register("nabe_oden",
            () -> new BlockItem(BlockRegistry.NABE_ODEN.get(), Sakura.defaultItemProperties()));
}
