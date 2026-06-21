package cn.mcmod.sakura.data;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import cn.mcmod.sakura.Sakura;
import cn.mcmod.sakura.block.BlockItemRegistry;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.data.builder.ChoppingBoardRecipeBuilder;
import cn.mcmod.sakura.data.builder.CookingPotRecipeBuilder;
import cn.mcmod.sakura.data.builder.DistillerRecipeBuilder;
import cn.mcmod.sakura.data.builder.FermenterRecipeBuilder;
import cn.mcmod.sakura.data.builder.StoneMortarRecipeBuilder;
import cn.mcmod.sakura.fluid.BucketItemRegistry;
import cn.mcmod.sakura.fluid.FluidRegistry;
import cn.mcmod.sakura.item.FoodRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod.sakura.item.enums.SakuraCuisineSet;
import cn.mcmod.sakura.item.enums.SakuraFoodSet;
import cn.mcmod.sakura.item.enums.SakuraNormalItemSet;
import cn.mcmod.sakura.tags.SakuraFluidTags;
import cn.mcmod.sakura.tags.SakuraItemTags;
import cn.mcmod_mmf.mmlib.data.AbstractRecipeProvider;
import cn.mcmod_mmf.mmlib.fluid.FluidIngredient;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.fluids.FluidStack;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.registry.ModItems;

public class SakuraRecipeProvider extends AbstractRecipeProvider {

    public SakuraRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        registerCraftingRecipe(consumer);
        registerMortarRecipe(consumer);
        registerCookingRecipe(consumer);
        registerFermenterRecipe(consumer);
        registerDistillerRecipe(consumer);
        registerChoppingRecipes(consumer);
    }

    private void registerCraftingRecipe(Consumer<FinishedRecipe> consumer) {

        makeSlab(BlockRegistry.TATAMI_SLAB, BlockRegistry.TATAMI).save(consumer);
        makeSlab(BlockRegistry.SUNBURNT_TATAMI_SLAB, BlockRegistry.SUNBURNT_TATAMI).save(consumer);

        ShapedRecipeBuilder.shaped(BlockRegistry.STRAW_BLOCK.get(), 4).pattern("LLL").pattern("LLL").pattern("LLL")
                .define('L', SakuraItemTags.STRAW).unlockedBy("has_item", has(SakuraItemTags.STRAW)).save(consumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.IRON_FISH_KNIFE.get()).pattern("  I").pattern(" I ").pattern("L  ")
                .define('I', Tags.Items.INGOTS_IRON).define('L', SakuraItemTags.LUMBER)
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER)).save(consumer);

        ShapedRecipeBuilder.shaped(BlockRegistry.TATAMI.get(), 6).pattern("LLL").pattern("L#L").pattern("LLL")
                .define('#', SakuraItemTags.LUMBER).define('L', SakuraItemTags.STRAW)
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER)).save(consumer);

        ShapedRecipeBuilder.shaped(Items.TORCH, 4).pattern("C").pattern("#")
                .define('C', BlockItemRegistry.CHARCOAL_BAMBOO_PLANT.get())
                .define('#', Tags.Items.RODS_WOODEN).unlockedBy("has_item", has(Tags.Items.RODS_WOODEN))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "torchs_from_charcoal"));

        ShapedRecipeBuilder.shaped(Items.STICK, 4).pattern("#").pattern("#").define('#', SakuraItemTags.LUMBER)
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "sticks_from_lumbers"));

        ShapedRecipeBuilder.shaped(BlockRegistry.OBON.get()).pattern("LLL").pattern("L#L")
                .define('#', BlockRegistry.SAKURA_LEAVES.get()).define('L', SakuraItemTags.LUMBER)
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER)).save(consumer);

        ShapedRecipeBuilder.shaped(Items.PAPER, 4).pattern("###").define('#', SakuraItemTags.LUMBER)
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "papers_from_lumbers"));

        ShapedRecipeBuilder.shaped(BlockItemRegistry.CHOPPING_BOARD.get()).pattern("###").pattern("I I")
                .define('#', SakuraItemTags.LUMBER).define('I', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "chopping_board"));

        ShapedRecipeBuilder.shaped(BlockItemRegistry.FERMENTER.get()).pattern("SSS").pattern("PPP").pattern("SSS")
                .define('S', SakuraItemTags.LUMBER).define('P', ItemTags.LOGS)
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "fermenter"));

        ShapedRecipeBuilder.shaped(BlockItemRegistry.DISTILLER.get()).pattern("ISI").pattern("PPP").pattern("III")
                .define('S', SakuraItemTags.LUMBER).define('P', ItemTags.LOGS).define('I', Tags.Items.INGOTS_IRON)
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "distiller"));

        registerFarmerDelightRecipes(consumer);

        ShapedRecipeBuilder.shaped(BlockRegistry.COOKING_POT.get()).pattern("#L#").pattern("###")
                .define('#', Tags.Items.INGOTS_IRON).define('L', SakuraItemTags.LUMBER)
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER)).save(consumer);

        ShapedRecipeBuilder.shaped(BlockRegistry.STONE_MORTAR.get()).pattern("L  ").pattern("###").pattern("###")
                .define('#', Tags.Items.COBBLESTONE).define('L', SakuraItemTags.LUMBER)
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER)).save(consumer);

        foodSmeltingRecipes("eggplant_bake", FoodRegistry.FOODSET.get(SakuraFoodSet.EGGPLANT).get(),
                FoodRegistry.FOODSET.get(SakuraFoodSet.BAKED_EGGPLANT).get(), 0.5F, consumer);
        foodSmeltingRecipes("taro_bake", ItemRegistry.TARO.get(),
                FoodRegistry.FOODSET.get(SakuraFoodSet.BAKED_TARO).get(), 0.5F, consumer);
        foodSmeltingRecipes("burger", FoodRegistry.FOODSET.get(SakuraFoodSet.RAW_BURGER).get(),
                FoodRegistry.FOODSET.get(SakuraFoodSet.BURGER).get(), 0.5F, consumer);

        foodSmeltingRecipes("chikuwa", FoodRegistry.FOODSET.get(SakuraFoodSet.RAW_CHIKUWA).get(),
                FoodRegistry.FOODSET.get(SakuraFoodSet.CHIKUWA).get(), 0.5F, consumer);

        foodSmeltingRecipes("bun", ItemRegistry.MATERIALS.get(SakuraNormalItemSet.DOUGH).get(),
                FoodRegistry.FOODSET.get(SakuraFoodSet.BUN).get(), 0.5F, consumer);
        foodSmeltingRecipes("buckwheat_bread", ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BUCKWHEAT_DOUGH).get(),
                FoodRegistry.FOODSET.get(SakuraFoodSet.BUCKWHEAT_BREAD).get(), 0.5F, consumer);
        foodSmeltingRecipes("rice_bread", ItemRegistry.MATERIALS.get(SakuraNormalItemSet.RICE_DOUGH).get(),
                FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_BREAD).get(), 0.5F, consumer);

        ShapelessRecipeBuilder.shapeless(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.DOUGH).get(), 3)
                .requires(SakuraItemTags.FLOUR_WHEAT).requires(SakuraItemTags.FLOUR_WHEAT)
                .requires(SakuraItemTags.FLOUR_WHEAT).requires(SakuraItemTags.WATER)
                .unlockedBy("has_flour", has(SakuraItemTags.FLOUR_WHEAT)).save(consumer);

        ShapelessRecipeBuilder.shapeless(BlockItemRegistry.SUKIYAKI_NABE.get())
                .requires(BlockItemRegistry.COOKING_POT.get()).requires(SakuraItemTags.SOYSAUCE)
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MIRIN).get()).requires(SakuraItemTags.RAW_BEEF)
                .requires(Tags.Items.CROPS_CARROT).requires(SakuraItemTags.MUSHROOMS)
                .requires(SakuraItemTags.VEGETABLES).requires(SakuraItemTags.VEGETABLES)
                .unlockedBy("has_pot", has(BlockItemRegistry.COOKING_POT.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(BlockItemRegistry.ODEN_NABE.get())
                .requires(BlockItemRegistry.COOKING_POT.get()).requires(SakuraItemTags.FISHCAKE)
                .requires(SakuraItemTags.FISHCAKE).requires(SakuraItemTags.FISHCAKE).requires(SakuraItemTags.FISHCAKE)
                .requires(SakuraItemTags.EGGS).requires(SakuraItemTags.DASHI).requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MIRIN).get())
                .unlockedBy("has_pot", has(BlockItemRegistry.COOKING_POT.get())).save(consumer);

        makeItemToBucket(BucketItemRegistry.FOOD_OIL_BUCKET, Ingredient.of(SakuraItemTags.SEEDS_RAPE_SEEDS))
                .unlockedBy("has_seeds", has(SakuraItemTags.SEEDS_RAPE_SEEDS)).save(consumer);

        ShapelessRecipeBuilder.shapeless(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BUCKWHEAT_DOUGH).get(), 3)
                .requires(SakuraItemTags.FLOUR_BUCKWHEAT).requires(SakuraItemTags.FLOUR_BUCKWHEAT)
                .requires(SakuraItemTags.FLOUR_BUCKWHEAT).requires(SakuraItemTags.WATER)
                .unlockedBy("has_flour", has(SakuraItemTags.FLOUR_BUCKWHEAT)).save(consumer);

        ShapelessRecipeBuilder.shapeless(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.RICE_DOUGH).get(), 3)
                .requires(SakuraItemTags.FLOUR_RICE).requires(SakuraItemTags.FLOUR_RICE)
                .requires(SakuraItemTags.FLOUR_RICE).requires(SakuraItemTags.WATER)
                .unlockedBy("has_flour", has(SakuraItemTags.FLOUR_RICE)).save(consumer);

        ShapelessRecipeBuilder.shapeless(BlockRegistry.TAMAGOYAKI_TEISHOKU.get()).requires(SakuraItemTags.SOUPS)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(BlockRegistry.OBON.get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.TAMAGOYAKI).get())
                .unlockedBy("has_obon", has(BlockRegistry.OBON.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(BlockRegistry.YAKIZANA_TEISHOKU.get()).requires(SakuraItemTags.SOUPS)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(BlockRegistry.OBON.get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.BAKED_FISH).get())
                .unlockedBy("has_obon", has(BlockRegistry.OBON.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(BlockRegistry.SHIOYAKI_TEISHOKU.get()).requires(SakuraItemTags.SOUPS)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(BlockRegistry.OBON.get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.SALT_BAKED_FISH).get())
                .unlockedBy("has_obon", has(BlockRegistry.OBON.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(BlockRegistry.SASHIMI_TEISHOKU.get()).requires(SakuraItemTags.SOUPS)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(BlockRegistry.OBON.get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.SASHIMI).get())
                .unlockedBy("has_obon", has(BlockRegistry.OBON.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(BlockRegistry.YAKINIKU_TEISHOKU.get()).requires(SakuraItemTags.SOUPS)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(BlockRegistry.OBON.get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.YAKINIKU).get())
                .unlockedBy("has_obon", has(BlockRegistry.OBON.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.SASHIMI).get())
                .requires(SakuraItemTags.SLICES_RAW_FISHES).requires(SakuraItemTags.SLICES_RAW_FISHES)
                .requires(SakuraItemTags.SOYSAUCE).unlockedBy("has_fish", has(SakuraItemTags.SLICES_RAW_FISHES))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.RAW_CHIKUWA).get(), 2)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.SURIMI).get()).requires(SakuraItemTags.SALT)
                .unlockedBy("has_fish", has(FoodRegistry.FOODSET.get(SakuraFoodSet.SURIMI).get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(BlockRegistry.SAKURA_SAPLING.get()).requires(ItemTags.SAPLINGS)
                .requires(Tags.Items.DYES_PINK).unlockedBy("has_sapling", has(ItemTags.SAPLINGS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(BlockRegistry.RED_MAPLE_SAPLING.get()).requires(ItemTags.SAPLINGS)
                .requires(Tags.Items.DYES_RED).unlockedBy("has_sapling", has(ItemTags.SAPLINGS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(BlockRegistry.GREEN_MAPLE_SAPLING.get()).requires(ItemTags.SAPLINGS)
                .requires(Tags.Items.DYES_GREEN).unlockedBy("has_sapling", has(ItemTags.SAPLINGS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(BlockRegistry.YELLOW_MAPLE_SAPLING.get()).requires(ItemTags.SAPLINGS)
                .requires(Tags.Items.DYES_YELLOW).unlockedBy("has_sapling", has(ItemTags.SAPLINGS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(BlockRegistry.ORANGE_MAPLE_SAPLING.get()).requires(ItemTags.SAPLINGS)
                .requires(Tags.Items.DYES_ORANGE).unlockedBy("has_sapling", has(ItemTags.SAPLINGS)).save(consumer);

        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.ONIGIRI).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(Items.DRIED_KELP)
                .unlockedBy("has_rice", has(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.BAMBOO_ONIGIRI).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(Items.DRIED_KELP)
                .requires(BlockRegistry.BAMBOO_SHOOT.get())
                .unlockedBy("has_rice", has(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.SEAWEED_ONIGIRI).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(Items.DRIED_KELP)
                .requires(Items.DRIED_KELP)
                .unlockedBy("has_rice", has(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.MUSHROOM_ONIGIRI).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(Items.DRIED_KELP)
                .requires(SakuraItemTags.MUSHROOMS)
                .unlockedBy("has_rice", has(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.TEMPURA_ONIGIRI).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(Items.DRIED_KELP)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.TEMPURA).get())
                .unlockedBy("has_rice", has(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.SUSHI).get(), 2)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())
                .requires(SakuraItemTags.SLICES_RAW_FISHES)
                .unlockedBy("has_rice", has(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.SHRIMP_SUSHI).get(), 2)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(SakuraItemTags.SHRIMP)
                .unlockedBy("has_rice", has(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.TAMAGO_SUSHI).get(), 3)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.TAMAGOYAKI).get()).requires(Items.DRIED_KELP)
                .unlockedBy("has_rice", has(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.TEMPURA_BATTER).get(), 8)
                .requires(SakuraItemTags.FLOUR).requires(SakuraItemTags.SALT).requires(SakuraItemTags.EGGS)
                .requires(SakuraItemTags.EGGS).requires(SakuraItemTags.WATER)
                .unlockedBy("has_flour", has(SakuraItemTags.FLOUR)).save(consumer);

        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.HAMBURGER).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.BUN).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.BURGER).get()).requires(SakuraItemTags.TOMATOSAUCE)
                .unlockedBy("has_bun", has(FoodRegistry.FOODSET.get(SakuraFoodSet.BUN).get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.CHEESE).get())
                .requires(SakuraItemTags.MILK).requires(SakuraItemTags.SALT)
                .unlockedBy("has_salt", has(SakuraItemTags.SALT)).save(consumer);

        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.BURGER_DISH).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.BURGER).get())
                .requires(SakuraItemTags.SALAD_INGREDIENTS_CABBAGE)
                .unlockedBy("has_burger", has(FoodRegistry.FOODSET.get(SakuraFoodSet.BURGER).get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.CHEESE_BURGER).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.BUN).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.BURGER).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.TOMATO_SAUCE).get()).requires(SakuraItemTags.CHEESE)
                .unlockedBy("has_bun", has(FoodRegistry.FOODSET.get(SakuraFoodSet.BUN).get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.CHEESE_BURGER).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.HAMBURGER).get()).requires(SakuraItemTags.CHEESE)
                .unlockedBy("has_bun", has(FoodRegistry.FOODSET.get(SakuraFoodSet.BUN).get()))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "cheese_burger_from_hamburger"));

        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.MOCHI).get(), 8)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())
                .unlockedBy("has_rice", has(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())).save(consumer);

        foodSmeltingRecipes("toasted_mochi", FoodRegistry.FOODSET.get(SakuraFoodSet.MOCHI).get(),
                FoodRegistry.FOODSET.get(SakuraFoodSet.TOASTED_MOCHI).get(), 0.5F, consumer);

        ShapelessRecipeBuilder.shapeless(FoodRegistry.FOODSET.get(SakuraFoodSet.SAKURA_MOCHI).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.MOCHI).get())
                .requires(BlockRegistry.SAKURA_LEAVES.get())
                .unlockedBy("has_mochi", has(FoodRegistry.FOODSET.get(SakuraFoodSet.MOCHI).get())).save(consumer);

        makeIngotToBlock(BlockRegistry.BAMBOO_BLOCK, BlockItemRegistry.BAMBOO_PLANT)
                .unlockedBy("has_item", has(BlockItemRegistry.BAMBOO_PLANT.get()))
                .save(consumer);
        makeIngotToBlock(BlockRegistry.BAMBOO_BLOCK, () -> Items.BAMBOO).unlockedBy("has_item", has(Items.BAMBOO))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "bamboo_block_from_vanilla_bamboo"));
        makeIngotToBlock(BlockRegistry.SUNBURNT_BAMBOO_BLOCK, BlockItemRegistry.SUNBURNT_BAMBOO_PLANT)
                .unlockedBy("has_item", has(BlockItemRegistry.SUNBURNT_BAMBOO_PLANT.get()))
                .save(consumer);
        makeIngotToBlock(BlockRegistry.CHARCOAL_BAMBOO_BLOCK, BlockItemRegistry.CHARCOAL_BAMBOO_PLANT)
                .unlockedBy("has_item", has(BlockItemRegistry.CHARCOAL_BAMBOO_PLANT.get()))
                .save(consumer);

        makeBlockToIngot(BlockItemRegistry.BAMBOO_PLANT, BlockRegistry.BAMBOO_BLOCK)
                .save(consumer);
        makeBlockToIngot(() -> Items.BAMBOO, BlockRegistry.BAMBOO_BLOCK).save(consumer,
                new ResourceLocation(Sakura.MOD_ID, "bamboo_block_to_vanilla_bamboo"));
        makeBlockToIngot(BlockItemRegistry.CHARCOAL_BAMBOO_PLANT,
                BlockRegistry.CHARCOAL_BAMBOO_BLOCK).save(consumer);
        makeBlockToIngot(BlockItemRegistry.SUNBURNT_BAMBOO_PLANT,
                BlockRegistry.SUNBURNT_BAMBOO_BLOCK).save(consumer);

        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO_LUMBER), Ingredient.of(SakuraItemTags.BAMBOO))
                .unlockedBy("has_item", has(SakuraItemTags.BAMBOO)).save(consumer);
        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MAPLE_LUMBER),
                Ingredient.of(BlockRegistry.MAPLE_LOG.get()))
                .unlockedBy("has_item", has(BlockItemRegistry.MAPLE_LOG.get())).save(consumer);
        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.SAKURA_LUMBER),
                Ingredient.of(BlockRegistry.SAKURA_LOG.get()))
                .unlockedBy("has_item", has(BlockItemRegistry.SAKURA_LOG.get())).save(consumer);

        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MAPLE_LUMBER),
                Ingredient.of(BlockRegistry.MAPLE_WOOD.get()))
                .unlockedBy("has_item", has(BlockItemRegistry.MAPLE_LOG.get()))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "maple_lumber_from_wood"));
        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.SAKURA_LUMBER),
                Ingredient.of(BlockRegistry.SAKURA_WOOD.get()))
                .unlockedBy("has_item", has(BlockItemRegistry.SAKURA_LOG.get()))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "sakura_lumber_from_wood"));

        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MAPLE_LUMBER),
                Ingredient.of(BlockRegistry.STRIPPED_MAPLE_LOG.get()))
                .unlockedBy("has_item", has(BlockItemRegistry.MAPLE_LOG.get()))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "maple_lumber_from_stripped"));
        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.SAKURA_LUMBER),
                Ingredient.of(BlockRegistry.STRIPPED_SAKURA_LOG.get()))
                .unlockedBy("has_item", has(BlockItemRegistry.SAKURA_LOG.get()))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "sakura_lumber_from_stripped"));

        makeLumberToPlank(BlockRegistry.SAKURA_PLANK, Ingredient.of(SakuraItemTags.LUMBER_SAKURA))
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER)).save(consumer);
        makeLumberToPlank(BlockRegistry.MAPLE_PLANK, Ingredient.of(SakuraItemTags.LUMBER_MAPLE))
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER)).save(consumer);
        makeLumberToPlank(BlockRegistry.BAMBOO_PLANK, Ingredient.of(SakuraItemTags.LUMBER_BAMBOO))
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER)).save(consumer);

        smeltingRecipe(BlockRegistry.CHARCOAL_BAMBOO_BLOCK.get(), BlockRegistry.BAMBOO_BLOCK.get(), 0.5F).save(consumer,
                new ResourceLocation(Sakura.MOD_ID, "charcoal_bamboo_block_from_smelt"));

        smeltingRecipe(BlockRegistry.CHARCOAL_BAMBOO_BLOCK.get(), BlockRegistry.SUNBURNT_BAMBOO_BLOCK.get(), 0.5F)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "charcoal_bamboo_block_from_sunburnt_smelt"));

        smeltingRecipe(BlockItemRegistry.CHARCOAL_BAMBOO_PLANT.get(),
                BlockItemRegistry.BAMBOO_PLANT.get(), 0.5F).save(consumer,
                new ResourceLocation(Sakura.MOD_ID, "charcoal_bamboo_from_smelt"));

        smeltingRecipe(BlockItemRegistry.CHARCOAL_BAMBOO_PLANT.get(),
                BlockItemRegistry.SUNBURNT_BAMBOO_PLANT.get(), 0.5F).save(consumer,
                new ResourceLocation(Sakura.MOD_ID, "charcoal_bamboo_from_sunburnt_smelt"));
    }

    private void registerMortarRecipe(Consumer<FinishedRecipe> consumer) {
        StoneMortarRecipeBuilder.mortar(Items.BONE_MEAL, 3).addResult(Items.BONE_MEAL, 3).requires(Tags.Items.BONES)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "bonemeal_from_mortar"));

        StoneMortarRecipeBuilder.mortar(Items.SAND).addResult(Items.FLINT).requires(Tags.Items.GRAVEL).save(consumer,
                new ResourceLocation(Sakura.MOD_ID, "flint_from_mortar"));

        StoneMortarRecipeBuilder.mortar(Items.GRAVEL)
                .addResult(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.SALT).get(), 2)
                .requires(Tags.Items.COBBLESTONE)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "salt_from_mortar"));

        StoneMortarRecipeBuilder.mortar(Items.COBBLESTONE)
                .addResult(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.ALKALINE).get(), 2).requires(Tags.Items.STONE)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "alkaline_from_mortar"));

        StoneMortarRecipeBuilder.mortar(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.CHARCOAL_POWDER).get(), 1)
                .requires(Ingredient.of(Items.CHARCOAL,
                        BlockItemRegistry.CHARCOAL_BAMBOO_PLANT.get()))
                .requires(Ingredient.of(Items.CHARCOAL,
                        BlockItemRegistry.CHARCOAL_BAMBOO_PLANT.get()))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "charcoal_powder"));

        StoneMortarRecipeBuilder.mortar(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BROWN_RICE).get(), 1)
                .addResult(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BROWN_RICE).get(), 1)
                .requires(SakuraItemTags.SEEDS_RICE).requires(SakuraItemTags.SEEDS_RICE)
                .requires(SakuraItemTags.SEEDS_RICE).requires(SakuraItemTags.SEEDS_RICE)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "brown_rice_from_mortar"));
        StoneMortarRecipeBuilder.mortar(Items.GREEN_DYE, 1).addResult(Items.GREEN_DYE, 1).requires(ItemTags.LEAVES)
                .requires(ItemTags.LEAVES).requires(ItemTags.LEAVES).requires(ItemTags.LEAVES)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "dye_green_from_leaves"));

        StoneMortarRecipeBuilder.mortar(FoodRegistry.FOODSET.get(SakuraFoodSet.MINCED_MEAT).get(), 2)
                .addResult(FoodRegistry.FOODSET.get(SakuraFoodSet.MINCED_MEAT).get(), 2)
                .requires(Ingredient.fromValues(Stream.of(new Ingredient.TagValue(SakuraItemTags.RAW_CHICKEN),
                        new Ingredient.TagValue(SakuraItemTags.RAW_PORK),
                        new Ingredient.TagValue(SakuraItemTags.RAW_BEEF),
                        new Ingredient.TagValue(SakuraItemTags.RAW_MUTTON))))
                .requires(Ingredient.fromValues(Stream.of(new Ingredient.TagValue(SakuraItemTags.RAW_CHICKEN),
                        new Ingredient.TagValue(SakuraItemTags.RAW_PORK),
                        new Ingredient.TagValue(SakuraItemTags.RAW_BEEF),
                        new Ingredient.TagValue(SakuraItemTags.RAW_MUTTON))))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "minced_meat"));

        StoneMortarRecipeBuilder.mortar(FoodRegistry.FOODSET.get(SakuraFoodSet.RAW_BURGER).get(), 2)
                .addResult(FoodRegistry.FOODSET.get(SakuraFoodSet.RAW_BURGER).get(), 2)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.MINCED_MEAT).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.BREADCRUMBS).get())
                .requires(SakuraItemTags.CROPS_ONION).requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "raw_burger"));

        StoneMortarRecipeBuilder.mortar(FoodRegistry.FOODSET.get(SakuraFoodSet.SURIMI).get(), 1)
                .addResult(FoodRegistry.FOODSET.get(SakuraFoodSet.SURIMI).get(), 1).requires(SakuraItemTags.FISHES)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "surimi_from_mortar"));

        StoneMortarRecipeBuilder.mortar(FoodRegistry.FOODSET.get(SakuraFoodSet.BREADCRUMBS).get(), 2)
                .addResult(FoodRegistry.FOODSET.get(SakuraFoodSet.BREADCRUMBS).get(), 2).requires(SakuraItemTags.BREAD)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "breadcrumbs_from_breads"));

        StoneMortarRecipeBuilder.mortar(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.RICE).get(), 1)
                .requires(SakuraItemTags.RICE_BROWN).requires(SakuraItemTags.RICE_BROWN)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "rice_from_mortar"));
        StoneMortarRecipeBuilder.mortar(Items.SUGAR, 3)
                .addResult(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MOLASSES).get())
                .requires(Items.SUGAR_CANE).save(consumer,
                        new ResourceLocation(Sakura.MOD_ID, "sugar_from_mortar"));
        StoneMortarRecipeBuilder.mortar(Items.SUGAR, 1)
                .addResult(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MOLASSES).get())
                .requires(Items.BEETROOT).save(consumer,
                        new ResourceLocation(Sakura.MOD_ID, "beetsugar_from_mortar"));
        StoneMortarRecipeBuilder.mortar(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.FLOUR).get(), 1)
                .requires(SakuraItemTags.GRAIN_WHEAT)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "flour_from_mortar"));
        StoneMortarRecipeBuilder.mortar(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BUCKWHEAT_FLOUR).get(), 1)
                .requires(SakuraItemTags.GRAIN_BUCKWHEAT)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "buckwheat_flour_from_mortar"));
        StoneMortarRecipeBuilder.mortar(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.RICE_FLOUR).get(), 1)
                .requires(SakuraItemTags.RICE_RICE)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "rice_flour_from_mortar"));

    }

    private void registerFarmerDelightRecipes(Consumer<FinishedRecipe> consumer) {
        whenModLoaded(StoneMortarRecipeBuilder.mortar(ModItems.RICE.get())
                .addResult(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.STRAW).get())
                .requires(ModItems.RICE_PANICLE.get()), FarmersDelight.MODID, "farmer_rice_mortar_from_sakura")
                .build(consumer, Sakura.MOD_ID, "farmer_rice_mortar_from_sakura");
        whenModLoaded(
                ShapedRecipeBuilder.shaped(ModItems.CANVAS.get()).pattern("##").pattern("##")
                        .define('#', SakuraItemTags.STRAW).unlockedBy("has_straw", has(SakuraItemTags.STRAW)),
                FarmersDelight.MODID).build(consumer, Sakura.MOD_ID, "canvas_from_sakura");
        whenModLoaded(ShapedRecipeBuilder.shaped(ModItems.TATAMI.get(), 2).pattern("S#").pattern("#S")
                .define('#', SakuraItemTags.STRAW).define('S', ModItems.CANVAS.get())
                .unlockedBy("has_straw", has(SakuraItemTags.STRAW)), FarmersDelight.MODID).build(consumer,
                Sakura.MOD_ID, "farmer_tatami_from_sakura");
        whenModLoaded(
                ShapedRecipeBuilder.shaped(ModItems.ROPE.get(), 3).pattern("s").pattern("s").pattern("s")
                        .define('s', SakuraItemTags.STRAW).unlockedBy("has_straw", has(SakuraItemTags.STRAW)),
                FarmersDelight.MODID).build(consumer, Sakura.MOD_ID, "rope_from_sakura");
        whenModLoaded(ShapelessRecipeBuilder.shapeless(ModItems.ORGANIC_COMPOST.get(), 1).requires(Items.DIRT)
                .requires(Items.ROTTEN_FLESH).requires(Items.ROTTEN_FLESH).requires(SakuraItemTags.STRAW)
                .requires(SakuraItemTags.STRAW).requires(Items.BONE_MEAL).requires(Items.BONE_MEAL)
                .requires(Items.BONE_MEAL).requires(Items.BONE_MEAL)
                .unlockedBy("has_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(Items.ROTTEN_FLESH))
                .unlockedBy("has_straw", has(SakuraItemTags.STRAW)), FarmersDelight.MODID).build(consumer,
                Sakura.MOD_ID, "organic_compost_rotten_flesh_from_sakura");
        whenModLoaded(ShapelessRecipeBuilder.shapeless(ModItems.ORGANIC_COMPOST.get(), 1).requires(Items.DIRT)
                .requires(SakuraItemTags.STRAW).requires(SakuraItemTags.STRAW).requires(Items.BONE_MEAL)
                .requires(Items.BONE_MEAL).requires(ModItems.TREE_BARK.get()).requires(ModItems.TREE_BARK.get())
                .requires(ModItems.TREE_BARK.get()).requires(ModItems.TREE_BARK.get())
                .unlockedBy("has_tree_bark", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TREE_BARK.get()))
                .unlockedBy("has_straw", has(SakuraItemTags.STRAW)), FarmersDelight.MODID).build(consumer,
                Sakura.MOD_ID, "organic_compost_bark_from_sakura");
    }

    private void registerCookingRecipe(Consumer<FinishedRecipe> consumer) {
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.EMPTY, FoodRegistry.CUISINES.get(SakuraCuisineSet.BEEF_STICK).get(), 2)
                .requires(SakuraItemTags.RAW_BEEF).requires(SakuraItemTags.BAMBOO)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "beef_stick_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.EMPTY, FoodRegistry.FOODSET.get(SakuraFoodSet.NATTO).get(), 2, 1.0f, 600)
                .requires(SakuraItemTags.CROPS_SOYBEAN).requires(SakuraItemTags.STRAW)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "natto_fermenting"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.EMPTY, FoodRegistry.CUISINES.get(SakuraCuisineSet.CHICKEN_STICK).get(), 2)
                .requires(SakuraItemTags.RAW_CHICKEN).requires(SakuraItemTags.BAMBOO)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "chicken_stick_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.EMPTY, FoodRegistry.CUISINES.get(SakuraCuisineSet.PORK_STICK).get(), 2)
                .requires(SakuraItemTags.RAW_PORK).requires(SakuraItemTags.BAMBOO)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "pork_stick_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 250),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.TOFU).get(), 2)
                .requires(SakuraItemTags.CROPS_SOYBEAN).requires(SakuraItemTags.SALT)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "tofu_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.FRIED_TOFU).get(), 2)
                .requires(SakuraItemTags.TOFU).requires(SakuraItemTags.FLOUR)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "fried_tofu_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.KAMABOKO).get(), 2)
                .requires(SakuraItemTags.SALT).requires(FoodRegistry.FOODSET.get(SakuraFoodSet.SURIMI).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "kamaboko_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.SATSUMAAGE).get(), 2)
                .requires(SakuraItemTags.SALT).requires(FoodRegistry.FOODSET.get(SakuraFoodSet.SURIMI).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "satsumaage_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.KATSU).get(), 2)
                .requires(SakuraItemTags.RAW_PORK)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.BREADCRUMBS).get())
                .requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "pork_katsu_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.FRIED_CHICKEN).get(), 2)
                .requires(SakuraItemTags.RAW_CHICKEN)
                .requires(Ingredient.fromValues(Stream.of(
                        new Ingredient.ItemValue(new ItemStack(FoodRegistry.FOODSET.get(SakuraFoodSet.BREADCRUMBS).get())),
                        new Ingredient.TagValue(SakuraItemTags.FLOUR))
                ))
                .requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "fried_chicken_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.CROQUETTE).get(), 2)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.MASHED_POTATO).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.BREADCRUMBS).get())
                .requires(SakuraItemTags.MILK)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "croquette_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.FISHCAKE).get(), 4)
                .requires(SakuraItemTags.SALT).requires(SakuraItemTags.EGGS).requires(SakuraItemTags.CROPS_TARO)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.SURIMI).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "hanpen_taro_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 250),
                        ItemRegistry.MATERIALS.get(SakuraNormalItemSet.KAESHI).get(), 4)
                .requires(SakuraItemTags.SUGAR)
                .requires(SakuraItemTags.SOYSAUCE)
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MIRIN).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "kaeshi_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.FISHCAKE).get(), 4)
                .requires(SakuraItemTags.SALT).requires(SakuraItemTags.EGGS)
                .requires(
                        Ingredient.fromValues(Stream.of(
                                        new Ingredient.TagValue(SakuraItemTags.CROPS_TARO),
                                        new Ingredient.TagValue(Tags.Items.CROPS_POTATO)
                                )
                        )
                )
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.SURIMI).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "hanpen_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 250),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.RED_BEAN_SOUP).get(), 2)
                .requires(SakuraItemTags.CROPS_RED_BEAN).requires(FoodRegistry.FOODSET.get(SakuraFoodSet.MOCHI).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "red_bean_soup_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.CABBAGE_ROLL).get())
                .requires(SakuraItemTags.SALAD_INGREDIENTS_CABBAGE)
                .requires(Ingredient.fromValues(Stream.of(new Ingredient.TagValue(SakuraItemTags.RAW_CHICKEN),
                        new Ingredient.TagValue(SakuraItemTags.RAW_PORK),
                        new Ingredient.TagValue(SakuraItemTags.RAW_BEEF),
                        new Ingredient.TagValue(SakuraItemTags.RAW_MUTTON),
                        new Ingredient.TagValue(SakuraItemTags.FISHES))))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "cabbage_roll_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.RED_BEAN_PASTE).get(), 2)
                .requires(SakuraItemTags.CROPS_RED_BEAN).requires(SakuraItemTags.CROPS_RED_BEAN)
                .requires(SakuraItemTags.SUGAR)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "red_bean_paste_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 250),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.TOMATO_SAUCE).get(), 2)
                .requires(SakuraItemTags.CROPS_TOMATO).requires(SakuraItemTags.CROPS_TOMATO)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "tomato_sauce_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.DANGO).get(), 2)
                .requires(SakuraItemTags.DOUGH_RICE)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "dango_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.DANANKO).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.DANGO).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.RED_BEAN_PASTE).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "dananko_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.DANMITARASHI).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.DANGO).get()).requires(SakuraItemTags.SUGAR)
                .requires(SakuraItemTags.SUGAR)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "danmitarashi_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.DANSANSYOKU).get())
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.DANGO).get())
                .requires(BlockRegistry.SAKURA_LEAVES.get()).requires(Items.GRASS)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "dansansyoku_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.DAIFUKU).get(), 2)
                .requires(SakuraItemTags.DOUGH_RICE)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.RED_BEAN_PASTE).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "daifuku_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.KUSA_DAIFUKU).get(), 2)
                .requires(SakuraItemTags.DOUGH_RICE).requires(Items.GRASS)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.RED_BEAN_PASTE).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "kusa_daifuku_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_BROWN_RICE).get())
                .requires(SakuraItemTags.RICE_BROWN)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "brown_rice_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get())
                .requires(SakuraItemTags.RICE_RICE)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "rice_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.RED_BEAN_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.CROPS_RED_BEAN)
                .requires(SakuraItemTags.SUGAR)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "red_bean_rice_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.NATTO_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.NATTO)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "natto_rice_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.NATTO_EGG_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.NATTO).requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "natto_egg_rice_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.BAMBOO_RICE).get())
                .requires(SakuraItemTags.RICE_RICE)
                .requires(BlockRegistry.BAMBOO_SHOOT.get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "bamboo_rice_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.MUSHROOM_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.MUSHROOMS)

                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "mushroom_rice_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.BEEF_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.RAW_BEEF)

                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "beef_rice_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.PORK_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.RAW_PORK)

                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "pork_rice_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.FISH_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.RAW_FISHES)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "fish_rice_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.EGG_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "egg_rice_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.BEEF_EGG_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.RAW_BEEF).requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "beef_egg_rice_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.PORK_EGG_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.RAW_PORK).requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "pork_egg_rice_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.FRIED_PORK_RICE).get())
                .requires(SakuraItemTags.RICE_RICE)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.KATSU).get())
                .requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "rice_katsu_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.OYAKO_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.RAW_CHICKEN).requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "oyako_rice_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.OYAKO_FISH_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.RAW_FISHES).requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "fish_oyako_rice_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.OMURICE).get())
                .requires(SakuraItemTags.RICE_RICE)
                .requires(Ingredient.fromValues(Stream.of(new Ingredient.TagValue(SakuraItemTags.RAW_CHICKEN),
                        new Ingredient.TagValue(SakuraItemTags.RAW_PORK),
                        new Ingredient.TagValue(SakuraItemTags.RAW_BEEF),
                        new Ingredient.TagValue(SakuraItemTags.RAW_MUTTON),
                        new Ingredient.TagValue(SakuraItemTags.FISHES))))
                .requires(SakuraItemTags.TOMATOSAUCE)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "omurice_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.TEMPURA).get())
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.TEMPURA_BATTER).get())
                .requires(SakuraItemTags.SHRIMP)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "tempura_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.FRIES).get(), 2)
                .requires(Tags.Items.CROPS_POTATO)
                .requires(SakuraItemTags.SALT)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "fries_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.MASHED_POTATO).get(), 2)
                .requires(Tags.Items.CROPS_POTATO)
                .requires(SakuraItemTags.SALT)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "mashed_potato_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.SALT_BAKED_FISH).get())
                .requires(SakuraItemTags.SALT).requires(SakuraItemTags.RAW_FISHES)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "salt_baked_fish_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.BAKED_FISH).get())
                .requires(SakuraItemTags.RAW_FISHES).requires(SakuraItemTags.SOYSAUCE)

                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "baked_fish_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.TAMAGOYAKI).get(), 2)
                .requires(SakuraItemTags.EGGS).requires(SakuraItemTags.EGGS).requires(SakuraItemTags.SUGAR)
                .requires(SakuraItemTags.DASHI)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "tamagoyaki_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 250),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.OSUIMONO).get(), 2)
                .requires(Items.DRIED_KELP).requires(SakuraItemTags.SOYSAUCE)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "osuimono_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 250),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.MISO_SOUP).get(), 2)
                .requires(SakuraItemTags.MISO).requires(SakuraItemTags.TOFU)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "miso_soup_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.NIKUJAGA).get(), 2)
                .requires(Ingredient.fromValues(Stream.of(new Ingredient.TagValue(SakuraItemTags.RAW_PORK),
                        new Ingredient.TagValue(SakuraItemTags.RAW_BEEF))))
                .requires(Tags.Items.CROPS_CARROT).requires(Tags.Items.CROPS_POTATO).requires(SakuraItemTags.SOYSAUCE)
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MIRIN).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "nikujaga_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 250),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.NIMONO_PUMPKIN).get(), 2)
                .requires(SakuraItemTags.CROPS_PUMPKIN).requires(SakuraItemTags.SOYSAUCE)
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MIRIN).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "nimono_pumpkin_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 250),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.NIMONO_RADISH).get(), 2)
                .requires(SakuraItemTags.CROPS_RADISH).requires(SakuraItemTags.SOYSAUCE)
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MIRIN).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "nimono_radish_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 250),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.IMOTAKI).get(), 2)
                .requires(SakuraItemTags.CROPS_TARO).requires(SakuraItemTags.SOYSAUCE)
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MIRIN).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "imotaki_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 250),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.CHIKUZENNI).get(), 2)
                .requires(SakuraItemTags.RAW_CHICKEN).requires(SakuraItemTags.MUSHROOMS)
                .requires(SakuraItemTags.VEGETABLES).requires(SakuraItemTags.SOYSAUCE)
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MIRIN).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "chikuzenni_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 250),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.NOPPEI_JIRU).get(), 2)
                .requires(SakuraItemTags.RAW_CHICKEN).requires(SakuraItemTags.CROPS_TARO)
                .requires(SakuraItemTags.VEGETABLES).requires(SakuraItemTags.SOYSAUCE)
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MIRIN).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "noppei_jiru_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 250),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.NIMONO_FISH).get(), 2)
                .requires(SakuraItemTags.RAW_FISHES).requires(SakuraItemTags.MISO).requires(SakuraItemTags.SALT)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "nimono_fish_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.FUROFUKI_DAIKON).get(), 2)
                .requires(SakuraItemTags.CROPS_RADISH).requires(SakuraItemTags.MISO).requires(SakuraItemTags.SALT)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "furofuki_daikon_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 500),
                        ItemRegistry.MATERIALS.get(SakuraNormalItemSet.DASHI).get(), 1)
                .requires(SakuraItemTags.RAW_FISHES).requires(Items.DRIED_KELP)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "dashi_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.YAKINIKU).get())
                .requires(Ingredient.fromValues(Stream.of(new Ingredient.TagValue(SakuraItemTags.RAW_PORK),
                        new Ingredient.TagValue(SakuraItemTags.RAW_BEEF),
                        new Ingredient.TagValue(SakuraItemTags.RAW_MUTTON))))
                .requires(SakuraItemTags.SOYSAUCE)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "yakiniku_cooking"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(SakuraFluidTags.FOOD_OIL, 125),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.FRIED_RICE).get())
                .requires(SakuraItemTags.RICE_RICE).requires(SakuraItemTags.EGGS).requires(SakuraItemTags.VEGETABLES)
                .requires(SakuraItemTags.SALT)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "fried_rice_cooking"));
    }

    private void registerFermenterRecipe(Consumer<FinishedRecipe> consumer) {
        FermenterRecipeBuilder
                .fermenting(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 500),
                        ItemRegistry.MATERIALS.get(SakuraNormalItemSet.KOUJI).get(), 2, FluidStack.EMPTY)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(SakuraItemTags.SALT)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "kouji_fermenting"));
        FermenterRecipeBuilder
                .fermenting(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 1000),
                        new FluidStack(FluidRegistry.DOBUROKU.get(), 500))
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(SakuraItemTags.KOUJI)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "doburoku_fermenting"));

        FermenterRecipeBuilder
                .fermenting(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 200),
                        new FluidStack(FluidRegistry.BEER.get(), 100))
                .requires(SakuraItemTags.GRAIN)
                .requires(SakuraItemTags.BROWN_MUSHROOMS)
                .requires(SakuraItemTags.SUGAR)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "basic_beer_fermenting"));

        FermenterRecipeBuilder
                .fermenting(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 200),
                        new FluidStack(FluidRegistry.BEER.get(), 200),0,400)
                .requires(SakuraItemTags.GRAIN)
                .requires(SakuraItemTags.GRAIN)
                .requires(SakuraItemTags.YEAST)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "beer_fermenting"));

        FermenterRecipeBuilder
                .fermenting(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 200),
                        ItemRegistry.MATERIALS.get(SakuraNormalItemSet.YEAST).get(), 4,FluidStack.EMPTY,0,400)
                .requires(SakuraItemTags.BROWN_MUSHROOMS)
                .requires(SakuraItemTags.SUGAR)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "yeast_fermenting"));

        FermenterRecipeBuilder
                .fermenting(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 100),
                        ItemRegistry.MATERIALS.get(SakuraNormalItemSet.YEAST).get(), 4,FluidStack.EMPTY,0,200)
                .requires(SakuraItemTags.YEAST)
                .requires(SakuraItemTags.SUGAR)
                .requires(SakuraItemTags.SUGAR)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "yeast_multiply"));

        FermenterRecipeBuilder
                .fermenting(FluidIngredient.fromTag(SakuraFluidTags.BREWERS_ALCOHOL, 500),
                        ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MIRIN).get(), 8, FluidStack.EMPTY)
                .requires(FoodRegistry.FOODSET.get(SakuraFoodSet.COOKED_RICE).get()).requires(SakuraItemTags.KOUJI)
                .requires(SakuraItemTags.SUGAR)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "mirin_fermenting"));

        FermenterRecipeBuilder
                .fermenting(FluidIngredient.fromFluid(FluidRegistry.DOBUROKU.get(), 500),
                        ItemRegistry.MATERIALS.get(SakuraNormalItemSet.SAKE_KASU).get(), 2,
                        new FluidStack(FluidRegistry.SAKE.get(), 250), 10F, 500)
                .requires(SakuraItemTags.DUST_CHARCOAL)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "sake_charcoal_fermenting"));

        FermenterRecipeBuilder
                .fermenting(FluidIngredient.fromFluid(FluidRegistry.DOBUROKU.get(), 500),
                        new FluidStack(FluidRegistry.SAKE.get(), 100), 10F, 1000)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "sake_fermenting"));
        FermenterRecipeBuilder
                .fermenting(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 1000),
                        ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MISO).get(), 4,
                        FluidStack.EMPTY)
                .addResult(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.SOYSAUCE).get(), 4)
                .requires(SakuraItemTags.CROPS_SOYBEAN)
                .requires(SakuraItemTags.CROPS_SOYBEAN)
                .requires(SakuraItemTags.KOUJI)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "miso_fermenting"));
    }

    private void registerDistillerRecipe(Consumer<FinishedRecipe> consumer) {
        DistillerRecipeBuilder
                .distillation(FluidIngredient.fromFluid(FluidRegistry.SAKE.get(), 1000),
                        new FluidStack(FluidRegistry.SHOUCHU.get(), 500))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "shouchu_from_sake_distillation"));

        DistillerRecipeBuilder
                .distillation(FluidIngredient.fromFluid(FluidRegistry.BEER.get(), 1000),
                        new FluidStack(FluidRegistry.WHISKEY.get(), 500))
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "whiskey_from_beer_distillation"));

        DistillerRecipeBuilder
                .distillation(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 500),
                        new FluidStack(FluidRegistry.RUM.get(), 100))
                .requires(Items.SUGAR_CANE)
                .requires(Items.SUGAR_CANE)
                .requires(SakuraItemTags.YEAST)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "rum_cane_distillation"));

        DistillerRecipeBuilder
                .distillation(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 500),
                        new FluidStack(FluidRegistry.RUM.get(), 100))
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MOLASSES).get())
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.MOLASSES).get())
                .requires(SakuraItemTags.YEAST)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "rum_molasses_distillation"));

        DistillerRecipeBuilder
                .distillation(FluidIngredient.fromTag(SakuraFluidTags.WATER_WATER, 500),
                        new FluidStack(FluidRegistry.SHOUCHU.get(), 100))
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.SAKE_KASU).get())
                .requires(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.SAKE_KASU).get())
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "shouchu_from_sakekasu_distillation"));
    }

    private void registerChoppingRecipes(Consumer<FinishedRecipe> consumer) {
        ChoppingBoardRecipeBuilder.chop(FoodRegistry.FOODSET.get(SakuraFoodSet.MACHINED_FISH).get())
                .requires(Ingredient.fromValues(Stream.of(new Ingredient.ItemValue(new ItemStack(Items.COD)),
                        new Ingredient.ItemValue(new ItemStack(Items.SALMON)),
                        new Ingredient.ItemValue(new ItemStack(Items.TROPICAL_FISH)))))
                .requiresTool(SakuraItemTags.TOOLS_KNIVES_FISH)
                .addByproduce(FoodRegistry.FOODSET.get(SakuraFoodSet.MACHINED_FISH).get())
                .addByproduceWithChance(Items.BONE_MEAL, 0.5F)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "machined_fish_chopping"));

        ChoppingBoardRecipeBuilder.chop(FoodRegistry.FOODSET.get(SakuraFoodSet.SLICED_CABBAGE).get())
                .requires(SakuraItemTags.CROPS_CABBAGE).requiresTool(SakuraItemTags.TOOLS_KNIVES_FISH)
                .addByproduce(FoodRegistry.FOODSET.get(SakuraFoodSet.SLICED_CABBAGE).get())
                .addByproduceWithChance(FoodRegistry.FOODSET.get(SakuraFoodSet.SLICED_CABBAGE).get(), 0.5F)
                .save(consumer, new ResourceLocation(Sakura.MOD_ID, "sliced_cabbage_chopping"));
    }

    private void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience,
                                     Consumer<FinishedRecipe> consumer) {
        String namePrefix = new ResourceLocation(Sakura.MOD_ID, name).toString();
        smeltingRecipe(result, ingredient, experience).save(consumer);
        campfireRecipe(result, ingredient, experience).save(consumer, namePrefix + "_from_campfire_cooking");
        smokingRecipe(result, ingredient, experience).save(consumer, namePrefix + "_from_smoking");
    }

    public ShapedRecipeBuilder makeLumberToPlank(Supplier<? extends Block> blockOut, Ingredient ingreIn) {
        return ShapedRecipeBuilder.shaped(blockOut.get()).pattern("##").pattern("##").define('#', ingreIn);
    }

    public ShapelessRecipeBuilder makeLumber(Supplier<? extends Item> ingotOut, Ingredient ingreIn) {
        return ShapelessRecipeBuilder.shapeless(ingotOut.get(), 8).requires(ingreIn);
    }

    public ShapelessRecipeBuilder makeItemToBucket(Supplier<? extends Item> ingotOut, Ingredient ingreIn) {
        return ShapelessRecipeBuilder.shapeless(ingotOut.get()).requires(ingreIn).requires(ingreIn).requires(ingreIn)
                .requires(ingreIn).requires(ingreIn).requires(ingreIn).requires(ingreIn).requires(ingreIn)
                .requires(Items.BUCKET);
    }

    public ConditionalRecipe.Builder whenModLoaded(CookingPotRecipeBuilder recipe, String modid, String path) {
        return ConditionalRecipe.builder().addCondition(new ModLoadedCondition(modid))
                .addRecipe(consumer -> recipe.save(consumer, new ResourceLocation(Sakura.MOD_ID, path)));
    }

    public ConditionalRecipe.Builder whenModLoaded(StoneMortarRecipeBuilder recipe, String modid, String path) {
        return ConditionalRecipe.builder().addCondition(new ModLoadedCondition(modid))
                .addRecipe(consumer -> recipe.save(consumer, new ResourceLocation(Sakura.MOD_ID, path)));
    }
}
