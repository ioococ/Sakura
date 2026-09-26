package cn.mcmod.sakura.data.client;

import cn.mcmod.sakura.block.BlockItemRegistry;
import cn.mcmod.sakura.fluid.BucketItemRegistry;
import cn.mcmod.sakura.item.DrinkRegistry;
import cn.mcmod.sakura.item.FoodRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod.sakura.item.group.SakuraCuisineSet;
import cn.mcmod.sakura.item.group.SakuraDrinkSet;
import cn.mcmod.sakura.item.group.SakuraFoodSet;
import cn.mcmod.sakura.item.group.SakuraNormalSet;
import cn.mcmod_mmf.mmlib.data.AbstractItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class SakuraItemModelProvider extends AbstractItemModelProvider {
    private final Set<Item> ordinarySet = new HashSet<>();
    private final Set<Item> foodSet = new HashSet<>();

    public SakuraItemModelProvider(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    {
        ordinarySet.add(SakuraNormalSet.getItem(SakuraNormalSet.BENTO_BOX).asItem());

        foodSet.add(SakuraFoodSet.getItem(SakuraFoodSet.CABBAGE).asItem());
        foodSet.add(SakuraFoodSet.getItem(SakuraFoodSet.DANANKO).asItem());
        foodSet.add(SakuraFoodSet.getItem(SakuraFoodSet.DANMITARASHI).asItem());
        foodSet.add(SakuraFoodSet.getItem(SakuraFoodSet.DANSANSYOKU).asItem());
        foodSet.add(SakuraCuisineSet.getItem(SakuraCuisineSet.BEEF_STICK).asItem());
        foodSet.add(SakuraCuisineSet.getItem(SakuraCuisineSet.CHICKEN_STICK).asItem());
        foodSet.add(SakuraCuisineSet.getItem(SakuraCuisineSet.PORK_STICK).asItem());
        foodSet.add(SakuraCuisineSet.getItem(SakuraCuisineSet.STANDARD_BENTO).asItem());
        foodSet.add(SakuraCuisineSet.getItem(SakuraCuisineSet.DELUXE_BENTO).asItem());
        foodSet.add(SakuraCuisineSet.getItem(SakuraCuisineSet.PREMIUM_BENTO).asItem());
        foodSet.add(SakuraCuisineSet.getItem(SakuraCuisineSet.SUPREME_BENTO).asItem());
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

        ItemRegistry.ITEMS.getEntries().forEach(this::ordinaryItem);
        FoodRegistry.ITEMS.getEntries().forEach(this::foodItem);
        DrinkRegistry.ITEMS.getEntries().forEach(this::drinkItem);

        bentoItem(SakuraCuisineSet.STANDARD_BENTO, "bento_0");
        bentoItem(SakuraCuisineSet.DELUXE_BENTO, "bento_1");
        bentoItem(SakuraCuisineSet.PREMIUM_BENTO, "bento_2");
        bentoItem(SakuraCuisineSet.SUPREME_BENTO, "bento_3");
    }

    private void bentoItem(SakuraCuisineSet set, String model) {
        withExistingParent(set.getFoodInfo().getName(), modLoc("item/" + model));
    }

    private void leafPileItem(Supplier<? extends Item> item) {
        String name = item.get().getRegistryName().getPath();
        withExistingParent(name, modLoc("block/leaf_pile/" + name + "_height1"));
    }


    private void ordinaryItem(Supplier<? extends Item> item) {
        if (ordinarySet.contains(item.get())) return;
        normalItem(item);
    }

    private void drinkItem(Supplier<? extends Item> item) {
        String path = item.get().getRegistryName().getPath();
        if (SakuraDrinkSet.isContainer(path)) return;

        int slash = path.indexOf('/');
        String type = slash == -1 ? "" : path.substring(0, slash);
        String name = slash == -1 ? path : path.substring(slash + 1);
        String model = "item/" + path;
        switch (type) {
            case "bottle" -> withExistingParent(model, modLoc("item/wine_bottle"))
                    .texture("0", modLoc("models/" + name + "_bottle"))
                    .texture("particle", modLoc("models/" + name + "_bottle"));
            case "cup" -> cupItem(model, name);
            case "tea" -> teaItem(model, name);
            case "juice" -> withExistingParent(model, mcLoc("item/generated"))
                    .texture("layer0", modLoc("item/" + name));
            default -> normalItem(item);
        }
    }

    private void cupItem(String model, String name) {
        ResourceLocation flowTex = modLoc("block/" + name + "_flow");
        ResourceLocation drinkTex = modLoc("models/" + name);
        boolean flow = existingFileHelper.exists(flowTex, PackType.CLIENT_RESOURCES, ".png", "textures");
        boolean drink = existingFileHelper.exists(drinkTex, PackType.CLIENT_RESOURCES, ".png", "textures");
        if (!flow && !drink) {
            withExistingParent(model, modLoc("item/glass_cup"));
            return;
        }
        withExistingParent(model, modLoc("item/glass_cup")).texture("1", drink ? drinkTex : flowTex);
    }

    private void teaItem(String model, String name) {
        ResourceLocation drinkTex = modLoc("models/" + name);
        if (existingFileHelper.exists(drinkTex, PackType.CLIENT_RESOURCES, ".png", "textures")) {
            withExistingParent(model, modLoc("item/tea_cup")).texture("2", drinkTex);
            return;
        }
        withExistingParent(model, modLoc("item/tea_cup"));
    }

    private void foodItem(Supplier<? extends Item> item) {
        if (foodSet.contains(item.get())) return;
        normalItem(item);
    }

}
