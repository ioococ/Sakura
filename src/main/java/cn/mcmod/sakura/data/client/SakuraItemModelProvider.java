package cn.mcmod.sakura.data.client;

import cn.mcmod.sakura.block.BlockItemRegistry;
import cn.mcmod.sakura.fluid.BucketItemRegistry;
import cn.mcmod_mmf.mmlib.data.AbstractItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class SakuraItemModelProvider extends AbstractItemModelProvider {

    public SakuraItemModelProvider(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        normalItem(BlockItemRegistry.BURR_CHESTNUT);
        itemBlock(BlockItemRegistry.SAKURA_LEAVES);
        itemBlock(BlockItemRegistry.UME_LEAVES);
        itemBlock(BlockItemRegistry.GREEN_MAPLE_LEAVES);
        itemBlock(BlockItemRegistry.YELLOW_MAPLE_LEAVES);
        itemBlock(BlockItemRegistry.ORANGE_MAPLE_LEAVES);
        itemBlock(BlockItemRegistry.RED_MAPLE_LEAVES);
        leafPileItem(BlockItemRegistry.GREEN_MAPLE_LEAF_PILE);
        leafPileItem(BlockItemRegistry.YELLOW_MAPLE_LEAF_PILE);
        leafPileItem(BlockItemRegistry.ORANGE_MAPLE_LEAF_PILE);
        leafPileItem(BlockItemRegistry.RED_MAPLE_LEAF_PILE);
        itemBlock(BlockItemRegistry.SAKURA_LOG);
        itemBlock(BlockItemRegistry.UME_LOG);
        itemBlock(BlockItemRegistry.MAPLE_LOG);
        itemBlock(BlockItemRegistry.STRIPPED_SAKURA_LOG);
        itemBlock(BlockItemRegistry.STRIPPED_UME_LOG);
        itemBlock(BlockItemRegistry.STRIPPED_MAPLE_LOG);
        itemBlock(BlockItemRegistry.SAKURA_WOOD);
        itemBlock(BlockItemRegistry.STRIPPED_SAKURA_WOOD);
        itemBlock(BlockItemRegistry.UME_WOOD);
        itemBlock(BlockItemRegistry.STRIPPED_UME_WOOD);
        itemBlock(BlockItemRegistry.MAPLE_WOOD);
        itemBlock(BlockItemRegistry.STRIPPED_MAPLE_WOOD);
        itemBlock(BlockItemRegistry.BAMBOO_PLANT);
        itemBlock(BlockItemRegistry.SUNBURNT_BAMBOO_PLANT);
        itemBlock(BlockItemRegistry.CHARCOAL_BAMBOO_PLANT);
        itemBlock(BlockItemRegistry.BAMBOO_BLOCK);
        itemBlock(BlockItemRegistry.SUNBURNT_BAMBOO_BLOCK);
        itemBlock(BlockItemRegistry.CHARCOAL_BAMBOO_BLOCK);
        itemBlock(BlockItemRegistry.BAMBOO_PLANK);
        itemBlock(BlockItemRegistry.SAKURA_PLANK);
        itemBlock(BlockItemRegistry.UME_PLANK);
        itemBlock(BlockItemRegistry.MAPLE_PLANK);
        itemBlock(BlockItemRegistry.TATAMI);
        itemBlock(BlockItemRegistry.TATAMI_SLAB);
        itemBlock(BlockItemRegistry.SUNBURNT_TATAMI);
        itemBlock(BlockItemRegistry.SUNBURNT_TATAMI_SLAB);
        itemBlock(BlockItemRegistry.STRAW_BLOCK);
        bushItem(BlockItemRegistry.BAMBOO_SHOOT);
        bushItem(BlockItemRegistry.SAKURA_SAPLING);
        bushItem(BlockItemRegistry.UME_SAPLING);
        bushItem(BlockItemRegistry.GREEN_MAPLE_SAPLING);
        bushItem(BlockItemRegistry.YELLOW_MAPLE_SAPLING);
        bushItem(BlockItemRegistry.ORANGE_MAPLE_SAPLING);
        bushItem(BlockItemRegistry.RED_MAPLE_SAPLING);
        itemBlock(BlockItemRegistry.COOKING_POT);
        itemBlock(BlockItemRegistry.FERMENTER);
        itemBlock(BlockItemRegistry.DISTILLER);
        itemBlock(BlockItemRegistry.OBON);
        itemBlock(BlockItemRegistry.CHOPPING_BOARD);
        itemBlock(BlockItemRegistry.SHIOYAKI_TEISHOKU);
        itemBlock(BlockItemRegistry.YAKIZANA_TEISHOKU);
        itemBlock(BlockItemRegistry.SASHIMI_TEISHOKU);
        itemBlock(BlockItemRegistry.TAMAGOYAKI_TEISHOKU);
        itemBlock(BlockItemRegistry.YAKINIKU_TEISHOKU);
        itemBlock(BlockItemRegistry.SUKIYAKI_NABE);
        itemBlock(BlockItemRegistry.ODEN_NABE);

        BucketItemRegistry.ITEMS.getEntries().forEach(this::normalItem);

//        FoodRegistry.ITEMS.getEntries().forEach(this::normalItem);
//        ItemRegistry.ITEMS.getEntries().forEach(this::normalItem);
    }

    private void leafPileItem(Supplier<? extends Item> item) {
        String name = item.get().getRegistryName().getPath();
        withExistingParent(name, modLoc("block/leaf_pile/" + name + "_height1"));
    }

}
