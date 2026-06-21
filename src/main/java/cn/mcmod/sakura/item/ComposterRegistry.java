package cn.mcmod.sakura.item;

import cn.mcmod.sakura.block.BlockItemRegistry;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod_mmf.mmlib.item.IFoodLike;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;

public class ComposterRegistry {

    public static void registerCompost() {
        FoodRegistry.ITEMS.getEntries().forEach( item-> register(item.get()));

        register(ItemRegistry.CABBAGE_SEEDS.get(), 0.3F);
        register(ItemRegistry.BUCKWHEAT.get(), 0.3F);
        register(ItemRegistry.RED_BEAN.get(), 0.3F);
        register(ItemRegistry.SOYBEAN.get(), 0.3F);
        register(ItemRegistry.RADISH_SEEDS.get(), 0.3F);
        register(ItemRegistry.ONION_SEEDS.get(), 0.3F);
        register(ItemRegistry.RICE_SEEDS.get(), 0.3F);
        register(ItemRegistry.TOMATO_SEEDS.get(), 0.3F);
        register(ItemRegistry.TARO.get(), 0.3F);
        register(ItemRegistry.EGGPLANT_SEEDS.get(), 0.3F);
        register(BlockItemRegistry.BAMBOO_SHOOT.get(), 0.3F);
        register(BlockItemRegistry.BAMBOO_PLANT.get(), 0.5F);
        register(BlockItemRegistry.GREEN_MAPLE_LEAF_PILE.get(), 0.4F);
        register(BlockItemRegistry.YELLOW_MAPLE_LEAF_PILE.get(), 0.4F);
        register(BlockItemRegistry.ORANGE_MAPLE_LEAF_PILE.get(), 0.4F);
        register(BlockItemRegistry.RED_MAPLE_LEAF_PILE.get(), 0.4F);
        register(BlockItemRegistry.SAKURA_LEAVES.get(), 0.5F);
        register(BlockItemRegistry.UME_LEAVES.get(), 0.5F);
        register(BlockItemRegistry.GREEN_MAPLE_LEAVES.get(), 0.5F);
        register(BlockItemRegistry.YELLOW_MAPLE_LEAVES.get(), 0.5F);
        register(BlockItemRegistry.ORANGE_MAPLE_LEAVES.get(), 0.5F);
        register(BlockItemRegistry.RED_MAPLE_LEAVES.get(), 0.5F);
        register(BlockItemRegistry.SAKURA_SAPLING.get(), 0.3F);
        register(BlockItemRegistry.UME_SAPLING.get(), 0.3F);
        register(BlockItemRegistry.GREEN_MAPLE_SAPLING.get(), 0.3F);
        register(BlockItemRegistry.YELLOW_MAPLE_SAPLING.get(), 0.3F);
        register(BlockItemRegistry.ORANGE_MAPLE_SAPLING.get(), 0.3F);
        register(BlockItemRegistry.RED_MAPLE_SAPLING.get(), 0.3F);
    }
    
    private static void register(Item item) {
        if(item instanceof IFoodLike food) register(item, food.getInfo().getCompostChance());
    }
    
    private static void register(Item item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item, chance);
    }
}
