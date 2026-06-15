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

    public static final RegistryObject<Item> SAKURA_LEAVES = ITEMS.register("sakura_leaves",
            () -> new BlockItem(BlockRegistry.SAKURA_LEAVES.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> GREEN_MAPLE_LEAVES = ITEMS.register("green_maple_leaves",
            () -> new BlockItem(BlockRegistry.GREEN_MAPLE_LEAVES.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> YELLOW_MAPLE_LEAVES = ITEMS.register("yellow_maple_leaves",
            () -> new BlockItem(BlockRegistry.YELLOW_MAPLE_LEAVES.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> ORANGE_MAPLE_LEAVES = ITEMS.register("orange_maple_leaves",
            () -> new BlockItem(BlockRegistry.ORANGE_MAPLE_LEAVES.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> RED_MAPLE_LEAVES = ITEMS.register("red_maple_leaves",
            () -> new BlockItem(BlockRegistry.RED_MAPLE_LEAVES.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> SAKURA_LOG = ITEMS.register("sakura_log",
            () -> new BlockItem(BlockRegistry.SAKURA_LOG.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> STRIPPED_SAKURA_LOG = ITEMS.register("stripped_sakura_log",
            () -> new BlockItem(BlockRegistry.STRIPPED_SAKURA_LOG.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> SAKURA_WOOD = ITEMS.register("sakura_wood",
            () -> new BlockItem(BlockRegistry.SAKURA_WOOD.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> STRIPPED_SAKURA_WOOD = ITEMS.register("stripped_sakura_wood",
            () -> new BlockItem(BlockRegistry.STRIPPED_SAKURA_WOOD.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> MAPLE_LOG = ITEMS.register("maple_log",
            () -> new BlockItem(BlockRegistry.MAPLE_LOG.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> STRIPPED_MAPLE_LOG = ITEMS.register("stripped_maple_log",
            () -> new BlockItem(BlockRegistry.STRIPPED_MAPLE_LOG.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> MAPLE_WOOD = ITEMS.register("maple_wood",
            () -> new BlockItem(BlockRegistry.MAPLE_WOOD.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> STRIPPED_MAPLE_WOOD = ITEMS.register("stripped_maple_wood",
            () -> new BlockItem(BlockRegistry.STRIPPED_MAPLE_WOOD.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> BAMBOO_BLOCK = ITEMS.register("bamboo_block",
            () -> new BlockItem(BlockRegistry.BAMBOO_BLOCK.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> SUNBURNT_BAMBOO_BLOCK = ITEMS.register("sunburnt_bamboo_block",
            () -> new BlockItem(BlockRegistry.SUNBURNT_BAMBOO_BLOCK.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> CHARCOAL_BAMBOO_BLOCK = ITEMS.register("charcoal_bamboo_block",
            () -> new BlockItem(BlockRegistry.CHARCOAL_BAMBOO_BLOCK.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> SAKURA_PLANK = ITEMS.register("sakura_plank",
            () -> new BlockItem(BlockRegistry.SAKURA_PLANK.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> MAPLE_PLANK = ITEMS.register("maple_plank",
            () -> new BlockItem(BlockRegistry.MAPLE_PLANK.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> BAMBOO_PLANK = ITEMS.register("bamboo_plank",
            () -> new BlockItem(BlockRegistry.BAMBOO_PLANK.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> TATAMI = ITEMS.register("tatami",
            () -> new BlockItem(BlockRegistry.TATAMI.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> TATAMI_SLAB = ITEMS.register("tatami_slab",
            () -> new BlockItem(BlockRegistry.TATAMI_SLAB.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> SUNBURNT_TATAMI = ITEMS.register("sunburnt_tatami",
            () -> new BlockItem(BlockRegistry.SUNBURNT_TATAMI.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> SUNBURNT_TATAMI_SLAB = ITEMS.register("sunburnt_tatami_slab",
            () -> new BlockItem(BlockRegistry.SUNBURNT_TATAMI_SLAB.get(), Sakura.mainTabProperties()));
    
    public static final RegistryObject<Item> STRAW_BLOCK = ITEMS.register("straw_block",
            () -> new BlockItem(BlockRegistry.STRAW_BLOCK.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> BAMBOO_SHOOT = ITEMS.register("bamboo_shoot",
            () -> new BlockItem(BlockRegistry.BAMBOO_SHOOT.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> SAKURA_SAPLING = ITEMS.register("sakura_sapling",
            () -> new BlockItem(BlockRegistry.SAKURA_SAPLING.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> GREEN_MAPLE_SAPLING = ITEMS.register("green_maple_sapling",
            () -> new BlockItem(BlockRegistry.GREEN_MAPLE_SAPLING.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> YELLOW_MAPLE_SAPLING = ITEMS.register("yellow_maple_sapling",
            () -> new BlockItem(BlockRegistry.YELLOW_MAPLE_SAPLING.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> ORANGE_MAPLE_SAPLING = ITEMS.register("orange_maple_sapling",
            () -> new BlockItem(BlockRegistry.ORANGE_MAPLE_SAPLING.get(), Sakura.mainTabProperties()));
    public static final RegistryObject<Item> RED_MAPLE_SAPLING = ITEMS.register("red_maple_sapling",
            () -> new BlockItem(BlockRegistry.RED_MAPLE_SAPLING.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> STONE_MORTAR = ITEMS.register("stone_mortar", StoneMortarItem::new);

    public static final RegistryObject<Item> COOKING_POT = ITEMS.register("cooking_pot",
            () -> new BlockItem(BlockRegistry.COOKING_POT.get(), Sakura.mainTabProperties()));
    
    public static final RegistryObject<Item> FERMENTER = ITEMS.register("fermenter",
            () -> new BlockItem(BlockRegistry.FERMENTER.get(), Sakura.mainTabProperties()));
    
    public static final RegistryObject<Item> DISTILLER = ITEMS.register("distiller",
            () -> new BlockItem(BlockRegistry.DISTILLER.get(), Sakura.mainTabProperties()));
    
    public static final RegistryObject<Item> OBON = ITEMS.register("obon",
            () -> new BlockItem(BlockRegistry.OBON.get(), Sakura.foodTabProperties()));
    
    public static final RegistryObject<Item> CHOPPING_BOARD = ITEMS.register("chopping_board",
            () -> new BlockItem(BlockRegistry.CHOPPING_BOARD.get(), Sakura.mainTabProperties()));

    public static final RegistryObject<Item> SASHIMI_TEISHOKU = ITEMS.register("sashimi_teishoku",
            () -> new BlockItem(BlockRegistry.SASHIMI_TEISHOKU.get(), Sakura.foodTabProperties()));
    public static final RegistryObject<Item> YAKIZANA_TEISHOKU = ITEMS.register("yakizana_teishoku",
            () -> new BlockItem(BlockRegistry.YAKIZANA_TEISHOKU.get(), Sakura.foodTabProperties()));
    public static final RegistryObject<Item> SHIOYAKI_TEISHOKU = ITEMS.register("shioyaki_teishoku",
            () -> new BlockItem(BlockRegistry.SHIOYAKI_TEISHOKU.get(), Sakura.foodTabProperties()));
    public static final RegistryObject<Item> TAMAGOYAKI_TEISHOKU = ITEMS.register("tamagoyaki_teishoku",
            () -> new BlockItem(BlockRegistry.TAMAGOYAKI_TEISHOKU.get(), Sakura.foodTabProperties()));
    public static final RegistryObject<Item> YAKINIKU_TEISHOKU = ITEMS.register("yakiniku_teishoku",
            () -> new BlockItem(BlockRegistry.YAKINIKU_TEISHOKU.get(), Sakura.foodTabProperties()));

    public static final RegistryObject<Item> SUKIYAKI_NABE = ITEMS.register("sukiyaki_nabe",
            () -> new BlockItem(BlockRegistry.SUKIYAKI_NABE.get(), Sakura.foodTabProperties()));
    public static final RegistryObject<Item> ODEN_NABE = ITEMS.register("oden_nabe",
            () -> new BlockItem(BlockRegistry.ODEN_NABE.get(), Sakura.foodTabProperties()));
}
