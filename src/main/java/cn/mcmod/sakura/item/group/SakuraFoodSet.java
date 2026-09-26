package cn.mcmod.sakura.item.group;

import cn.mcmod.sakura.utils.ResourceLocationUtil;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public enum SakuraFoodSet {
    LEMON(FoodInfo.builder().name("lemon").amountAndCalories(2, 0.6F).water(0.5F).nutrients(0F, 0F, 0F, 2F, 0F).compostChance(0.2F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    UME(FoodInfo.builder().name("ume").amountAndCalories(2, 0.6F).water(0.5F).nutrients(0F, 0F, 0F, 2F, 0F).compostChance(0.2F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    UMEBOSHI(FoodInfo.builder().name("umeboshi").amountAndCalories(2, 0.6F).water(0.5F).nutrients(0F, 0F, 0F, 2F, 0F).compostChance(0.2F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    ALMOND(FoodInfo.builder().name("almond").amountAndCalories(2, 0.6F).water(0.5F).nutrients(0F, 0F, 0F, 2F, 0F).compostChance(0.2F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    GREEN_GRAPE(FoodInfo.builder().name("green_grape").amountAndCalories(2, 0.6F).water(0.5F).nutrients(0F, 0F, 0F, 2F, 0F).compostChance(0.2F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    PURPLE_GRAPE(FoodInfo.builder().name("purple_grape").amountAndCalories(2, 0.6F).water(0.5F).nutrients(0F, 0F, 0F, 2F, 0F).compostChance(0.2F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),

    SHRIMP(FoodInfo.builder().name("shrimp").amountAndCalories(2, 0.6F).water(0.5F).nutrients(0F, 0F, 0F, 2F, 0F).compostChance(0.2F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    TOMATO(FoodInfo.builder().name("tomato").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F).compostChance(0.3F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    RADISH(FoodInfo.builder().name("radish").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F).compostChance(0.3F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    EGGPLANT(FoodInfo.builder().name("eggplant").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F).compostChance(0.3F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    CABBAGE(FoodInfo.builder().name("cabbage").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F).compostChance(0.3F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    ONION(FoodInfo.builder().name("onion").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F).compostChance(0.3F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    SLICED_CABBAGE(FoodInfo.builder().name("sliced_cabbage").amountAndCalories(2, 0.2F).water(5F).compostChance(0.3F).nutrients(0F, 0F, 2F, 0F, 0F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),

    BONITO(FoodInfo.builder().name("bonito").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    BOILED_BONITO(FoodInfo.builder().name("boiled_bonito").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    SHAVED_BONITO(FoodInfo.builder().name("shaved_bonito").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    DRIED_BONITO(FoodInfo.builder().name("dried_bonito").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    MACHINED_BONITO(FoodInfo.builder().name("machined_bonito").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    SMOKED_BONITO(FoodInfo.builder().name("smoked_bonito").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    MACHINED_FISH(FoodInfo.builder().name("machined_fish").amountAndCalories(1, 0.2F).water(1F).nutrients(0F, 0F, 0F, 2F, 2F).compostChance(0.25F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    MINCED_MEAT(FoodInfo.builder().name("minced_meat").amountAndCalories(2, 0.2F).water(1F).compostChance(0.25F).nutrients(0F, 0F, 0F, 3F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build()),
    BUGGYS_MEAT(FoodInfo.builder().name("buggys_meat").amountAndCalories(2, 0.2F).water(1F).compostChance(0.5F).nutrients(0.5F, 0F, 0F, 3F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build()),
    SURIMI(FoodInfo.builder().name("surimi").amountAndCalories(2, 0.2F).water(1F).compostChance(0.25F).nutrients(0F, 0F, 0F, 3F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build()),

    FISHCAKE(FoodInfo.builder().name("fishcake").amountAndCalories(4, 0.6F).water(1F).nutrients(1F, 0F, 1F, 2F, 0F).compostChance(0.5F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    KAMABOKO(FoodInfo.builder().name("kamaboko").amountAndCalories(4, 0.6F).water(1F).nutrients(1F, 0F, 1F, 2F, 0F).compostChance(0.5F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    RAW_CHIKUWA(FoodInfo.builder().name("raw_chikuwa").amountAndCalories(4, 0.6F).water(1F).nutrients(1F, 0F, 1F, 2F, 0F).compostChance(0.5F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    CHIKUWA(FoodInfo.builder().name("chikuwa").amountAndCalories(4, 0.6F).water(1F).nutrients(1F, 0F, 1F, 2F, 0F).compostChance(0.5F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    SATSUMAAGE(FoodInfo.builder().name("satsumaage").amountAndCalories(4, 0.6F).water(1F).nutrients(1F, 0F, 1F, 2F, 0F).compostChance(0.5F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),

    TOMATO_SAUCE(FoodInfo.builder().name("tomato_sauce").amountAndCalories(2, 0.2F).water(5F).compostChance(0.25F).nutrients(0F, 0F, 2F, 0F, 0F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    BAKED_EGGPLANT(FoodInfo.builder().name("baked_eggplant").amountAndCalories(4, 0.5F).water(0F).compostChance(0.5F).nutrients(0F, 0F, 3F, 0F, 0F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    BAKED_TARO(FoodInfo.builder().name("baked_taro").amountAndCalories(5, 0.6F).water(0F).nutrients(2F, 2F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    CHEESE(FoodInfo.builder().name("cheese").amountAndCalories(2, 0.2F).water(1F).nutrients(0F, 0F, 0F, 0F, 2F).compostChance(0.5F).decayModifier(2F).heatCapacity(0F).cookingTemp(-1F).build()),
    TAMAGOYAKI(FoodInfo.builder().name("tamagoyaki").amountAndCalories(6, 0.6F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 3F).compostChance(0.75F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),

    TOFU(FoodInfo.builder().name("tofu").amountAndCalories(2, 0.4F).water(0.5F).nutrients(0F, 0F, 2F, 0F, 0.5F).compostChance(0.5F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    FRIED_TOFU(FoodInfo.builder().name("fried_tofu").amountAndCalories(4, 0.5F).water(0.5F).compostChance(0.5F).nutrients(0.5F, 0F, 3F, 0F, 0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    NATTO(FoodInfo.builder().name("natto").amountAndCalories(2, 0.5F).water(0.5F).nutrients(1F, 0F, 2F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),

    MASHED_POTATO(FoodInfo.builder().name("mashed_potato").amountAndCalories(5, 0.6F).water(0.5F).compostChance(0.5F).nutrients(2F, 0F, 2F, 0F, 0.5F).decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build()),
    FRIES(FoodInfo.builder().name("fries").amountAndCalories(5, 0.6F).water(1F).nutrients(2F, 0F, 2F, 0F, 0F).decayModifier(1F).heatCapacity(1F).cookingTemp(480F).build()),

    BUN(FoodInfo.builder().name("bun").amountAndCalories(5, 0.6F).water(0F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(0.8F).heatCapacity(1F).cookingTemp(480F).build()),
    BUCKWHEAT_BREAD(FoodInfo.builder().name("buckwheat_bread").amountAndCalories(5, 0.6F).water(0F).compostChance(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).decayModifier(0.5F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_BREAD(FoodInfo.builder().name("rice_bread").amountAndCalories(5, 0.6F).water(0F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build()),
    RED_BEAN_PASTE(FoodInfo.builder().name("red_bean_paste").amountAndCalories(4, 0.25F).water(4F).compostChance(0.5F).nutrients(0.25F, 0F, 1F, 0F, 0F).decayModifier(4F).heatCapacity(0F).cookingTemp(-1F).build()),
    BREADCRUMBS(FoodInfo.builder().name("breadcrumbs").amountAndCalories(1, 0.1F).water(0F).compostChance(0.5F).nutrients(0.25F, 0F, 0F, 0F, 0F).decayModifier(4F).heatCapacity(0F).cookingTemp(-1F).build()),
    
    FRIED_CHICKEN(FoodInfo.builder().name("fried_chicken").amountAndCalories(6, 0.6F).water(2F).nutrients(1F, 0F, 0F, 4F, 0F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    CROQUETTE(FoodInfo.builder().name("croquette").amountAndCalories(6, 0.6F).water(2F).nutrients(2F, 0F, 2.5F, 2F, 0F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    CROQUETTE_DISH(FoodInfo.builder().name("croquette_dish").amountAndCalories(6, 0.6F).water(2F).nutrients(2F, 0F, 2.5F, 2F, 0F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    OKINOYAKI_DOUGH(FoodInfo.builder().name("okinoyaki_dough").amountAndCalories(6, 0.6F).water(2F).nutrients(2F, 0F, 2.5F, 2F, 0F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    KATSU(FoodInfo.builder().name("katsu").amountAndCalories(9, 0.6F).water(4F).nutrients(0.25F, 0F, 0F, 3F, 0F).decayModifier(1.25F).heatCapacity(0F).cookingTemp(-1F).build()),
    KATSU_DISH(FoodInfo.builder().name("katsu_dish").amountAndCalories(9, 0.6F).water(4F).nutrients(0.25F, 0F, 0F, 3F, 0F).decayModifier(1.25F).heatCapacity(0F).cookingTemp(-1F).build()),
    
    TEMPURA(FoodInfo.builder().name("tempura").amountAndCalories(5, 0.6F).water(0F).nutrients(1F, 0F, 0F, 2F, 0F).compostChance(0.5F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),

    COOKED_BROWN_RICE(FoodInfo.builder().name("cooked_brown_rice").amountAndCalories(4, 0.5F).water(0.5F).compostChance(0.5F).nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    COOKED_RICE(FoodInfo.builder().name("cooked_rice").amountAndCalories(4, 0.5F).water(0.5F).compostChance(0.5F).nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    DRIED_RICE(FoodInfo.builder().name("dried_rice").amountAndCalories(4, 0.5F).water(0.5F).compostChance(0.5F).nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    DRIED_BROWN_RICE(FoodInfo.builder().name("dried_brown_rice").amountAndCalories(4, 0.5F).water(0.5F).compostChance(0.5F).nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    FRIED_BROWN_RICE(FoodInfo.builder().name("fried_brown_rice").amountAndCalories(4, 0.5F).water(0.5F).compostChance(0.5F).nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    RED_BEAN_RICE(FoodInfo.builder().name("red_bean_rice").amountAndCalories(6, 0.6F).water(0.5F).compostChance(0.85F).nutrients(4F, 0F, 2F, 0F, 0F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    BAMBOO_RICE(FoodInfo.builder().name("bamboo_rice").amountAndCalories(5, 0.6F).water(0.5F).compostChance(0.85F).nutrients(1.5F, 1F, 0F, 0F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    BEEF_RICE(FoodInfo.builder().name("beef_rice").amountAndCalories(9, 0.8F).water(0.5F).compostChance(1F).nutrients(1.5F, 0F, 0F, 3F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    FISH_RICE(FoodInfo.builder().name("fish_rice").amountAndCalories(7, 0.7F).water(0.5F).compostChance(1F).nutrients(1.5F, 0F, 0F, 2F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    PORK_RICE(FoodInfo.builder().name("pork_rice").amountAndCalories(7, 0.7F).water(0.5F).compostChance(1F).nutrients(1.5F, 0F, 0F, 3F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    FRIED_PORK_RICE(FoodInfo.builder().name("fried_pork_rice").amountAndCalories(10, 1F).water(0.5F).nutrients(2F, 0F, 0F, 4F, 4F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    MUSHROOM_RICE(FoodInfo.builder().name("mushroom_rice").amountAndCalories(6, 0.6F).water(0.5F).compostChance(1F).nutrients(1.5F, 0F, 2F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    MATSUTAKE_RICE(FoodInfo.builder().name("matsutake_rice").amountAndCalories(6, 0.6F).water(0.5F).compostChance(1F).nutrients(1.5F, 0F, 2F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    EGG_RICE(FoodInfo.builder().name("egg_rice").amountAndCalories(5, 0.6F).water(0.5F).nutrients(1.5F, 0F, 0F, 0F, 2F).compostChance(0.85F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    BEEF_EGG_RICE(FoodInfo.builder().name("beef_egg_rice").amountAndCalories(10, 1F).water(0.5F).compostChance(1F).nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    PORK_EGG_RICE(FoodInfo.builder().name("pork_egg_rice").amountAndCalories(9, 0.8F).water(0.5F).compostChance(1F).nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    OYAKO_RICE(FoodInfo.builder().name("oyako_rice").amountAndCalories(9, 0.8F).water(0.5F).compostChance(1F).nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    OYAKO_FISH_RICE(FoodInfo.builder().name("fish_oyako_rice").amountAndCalories(9, 0.8F).water(0.5F).compostChance(1F).nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    NATTO_RICE(FoodInfo.builder().name("natto_rice").amountAndCalories(5, 0.6F).water(0.5F).nutrients(2.5F, 0F, 2F, 0F, 0F).compostChance(0.85F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    NATTO_EGG_RICE(FoodInfo.builder().name("natto_egg_rice").amountAndCalories(6, 0.6F).water(0.5F).compostChance(1F).nutrients(2.5F, 0F, 3F, 0F, 3F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    FRIED_RICE(FoodInfo.builder().name("fried_rice").amountAndCalories(8, 0.6F).water(0.5F).nutrients(1.5F, 0F, 2F, 2F, 0F).compostChance(1F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),

    OMURICE(FoodInfo.builder().name("omurice").amountAndCalories(8, 0.6F).water(0.5F).nutrients(2F, 0F, 3F, 3F, 2F).compostChance(1F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    CURRY_OMURICE(FoodInfo.builder().name("curry_omurice").amountAndCalories(8, 0.6F).water(0.5F).nutrients(2F, 0F, 3F, 3F, 2F).compostChance(1F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    ONIGIRI(FoodInfo.builder().name("onigiri").amountAndCalories(6, 0.6F).water(0.5F).nutrients(2F, 0F, 1F, 0F, 0F).compostChance(0.85F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    BAMBOO_ONIGIRI(FoodInfo.builder().name("bamboo_onigiri").amountAndCalories(7, 0.7F).water(0.5F).compostChance(0.85F).nutrients(2F, 0F, 2F, 0F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    FISH_ONIGIRI(FoodInfo.builder().name("fish_onigiri").amountAndCalories(8, 0.7F).water(0.5F).compostChance(1F).nutrients(2F, 0F, 1F, 2F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    MUSHROOM_ONIGIRI(FoodInfo.builder().name("mushroom_onigiri").amountAndCalories(7, 0.7F).water(0.5F).compostChance(1F).nutrients(2F, 0F, 2F, 0F, 0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    SEAWEED_ONIGIRI(FoodInfo.builder().name("seaweed_onigiri").amountAndCalories(7, 0.7F).water(0.5F).compostChance(1F).nutrients(2F, 0F, 2F, 0F, 0.5F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    TEMPURA_ONIGIRI(FoodInfo.builder().name("tempura_onigiri").amountAndCalories(10, 0.8F).water(0.5F).compostChance(1F).nutrients(2F, 0F, 2F, 4F, 1F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    MATSUTAKE_ONIGIRI(FoodInfo.builder().name("matsutake_onigiri").amountAndCalories(10, 0.8F).water(0.5F).compostChance(1F).nutrients(2F, 0F, 2F, 4F, 1F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),

    CURRY_RICE(FoodInfo.builder().name("curry_rice").amountAndCalories(10, 0.8F).water(0.5F).compostChance(1F).nutrients(2F, 0F, 2F, 4F, 1F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    KATSU_CURRY_RICE(FoodInfo.builder().name("katsu_curry_rice").amountAndCalories(12, 0.9F).water(0.5F).compostChance(1F).nutrients(2F, 0F, 2F, 5F, 1F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    BURGER_CURRY_RICE(FoodInfo.builder().name("burger_curry_rice").amountAndCalories(12, 0.9F).water(0.5F).compostChance(1F).nutrients(2F, 0F, 2F, 5F, 1F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    CHEESE_CURRY_RICE(FoodInfo.builder().name("cheese_curry_rice").amountAndCalories(12, 0.9F).water(0.5F).compostChance(1F).nutrients(2F, 0F, 2F, 4F, 3F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    CHEESE_KATSU_CURRY_RICE(FoodInfo.builder().name("cheese_katsu_curry_rice").amountAndCalories(14, 1F).water(0.5F).compostChance(1F).nutrients(2F, 0F, 2F, 5F, 3F).decayModifier(2.75F).heatCapacity(1F).cookingTemp(480F).build()),
    CHEESE_BURGER_CURRY_RICE(FoodInfo.builder().name("cheese_burger_curry_rice").amountAndCalories(14, 1F).water(0.5F).compostChance(1F).nutrients(2F, 0F, 2F, 5F, 3F).decayModifier(2.75F).heatCapacity(1F).cookingTemp(480F).build()),

    SUSHI(FoodInfo.builder().name("sushi").amountAndCalories(5, 0.6F).water(1F).nutrients(2F, 0F, 0F, 2F, 0F).compostChance(0.85F).decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build()),
    SHRIMP_SUSHI(FoodInfo.builder().name("shrimp_sushi").amountAndCalories(5, 0.6F).water(1F).nutrients(2F, 0F, 0F, 2F, 0F).compostChance(0.85F).decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build()),
    TAMAGO_SUSHI(FoodInfo.builder().name("tamago_sushi").amountAndCalories(4, 0.6F).water(1F).nutrients(2F, 0F, 0F, 0F, 2F).compostChance(0.85F).decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build()),
    EHOUMAKI(FoodInfo.builder().name("ehoumaki").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    RAMEN(FoodInfo.builder().name("ramen").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    BEEF_RAMEN(FoodInfo.builder().name("beef_ramen").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    EGG_RAMEN(FoodInfo.builder().name("egg_ramen").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    TEMPURA_RAMEN(FoodInfo.builder().name("tempura_ramen").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    FRIEDTOFU_RAMEN(FoodInfo.builder().name("friedtofu_ramen").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    KATSU_RAMEN(FoodInfo.builder().name("katsu_ramen").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    LARGE_RAMEN(FoodInfo.builder().name("large_ramen").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    CHICKEN_RAMEN(FoodInfo.builder().name("chicken_ramen").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    CROQUETTE_RAMEN(FoodInfo.builder().name("croquette_ramen").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    HYDRA_RAMEN(FoodInfo.builder().name("hydra_ramen").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    UDON(FoodInfo.builder().name("udon").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    BEEF_UDON(FoodInfo.builder().name("beef_udon").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    EGG_UDON(FoodInfo.builder().name("egg_udon").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    TEMPURA_UDON(FoodInfo.builder().name("tempura_udon").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    FRIEDTOFU_UDON(FoodInfo.builder().name("friedtofu_udon").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    KATSU_UDON(FoodInfo.builder().name("katsu_udon").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    LARGE_UDON(FoodInfo.builder().name("large_udon").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    CHICKEN_UDON(FoodInfo.builder().name("chicken_udon").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    CROQUETTE_UDON(FoodInfo.builder().name("croquette_udon").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    YAKI_UDON(FoodInfo.builder().name("yaki_udon").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),

    SOBA(FoodInfo.builder().name("soba").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    BEEF_SOBA(FoodInfo.builder().name("beef_soba").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    EGG_SOBA(FoodInfo.builder().name("egg_soba").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    CHICKEN_SOBA(FoodInfo.builder().name("chicken_soba").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    CROQUETTE_SOBA(FoodInfo.builder().name("croquette_soba").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    TEMPURA_SOBA(FoodInfo.builder().name("tempura_soba").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    FRIEDTOFU_SOBA(FoodInfo.builder().name("friedtofu_soba").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    KATSU_SOBA(FoodInfo.builder().name("katsu_soba").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    LARGE_SOBA(FoodInfo.builder().name("large_soba").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    ZARU_SOBA(FoodInfo.builder().name("zaru_soba").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    YAKI_SOBA(FoodInfo.builder().name("yaki_soba").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),

    TOMATO_PASTA(FoodInfo.builder().name("tomato_pasta").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    MUSHROOM_PASTA(FoodInfo.builder().name("mushroom_pasta").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    WHITESAUCE_PASTA(FoodInfo.builder().name("whitesauce_pasta").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    YAKI_PASTA(FoodInfo.builder().name("yaki_pasta").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),

    MOCHI(FoodInfo.builder().name("mochi").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    TOASTED_MOCHI(FoodInfo.builder().name("toasted_mochi").amountAndCalories(4, 0.6F).water(0.5F).compostChance(0.75F).nutrients(3F, 0F, 0F, 0F, 0F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    SAKURA_MOCHI(FoodInfo.builder().name("sakura_mochi").amountAndCalories(4, 0.6F).water(0.5F).compostChance(0.85F).nutrients(3F, 0F, 1F, 0F, 0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    OHAGI(FoodInfo.builder().name("ohagi").amountAndCalories(6, 0.6F).water(0.5F).nutrients(3F, 0F, 0.5F, 0F, 0.5F).compostChance(0.85F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    POUND_CAKE(FoodInfo.builder().name("pound_cake").amountAndCalories(6, 0.6F).water(0.5F).nutrients(3F, 0F, 0.5F, 0F, 0.5F).compostChance(0.85F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    POUND_CAKE_MOCHA(FoodInfo.builder().name("pound_cake_mocha").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    PUDDING(FoodInfo.builder().name("pudding").amountAndCalories(6, 0.6F).water(0.5F).nutrients(3F, 0F, 0.5F, 0F, 0.5F).compostChance(0.85F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    PUDDING_MAPLE(FoodInfo.builder().name("maple_pudding").amountAndCalories(6, 0.6F).water(0.5F).nutrients(3F, 0F, 0.5F, 0F, 0.5F).compostChance(0.85F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    PUDDING_MOCHA(FoodInfo.builder().name("mocha_pudding").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    DAIFUKU(FoodInfo.builder().name("daifuku").amountAndCalories(4, 0.6F).water(0.5F).nutrients(3F, 0F, 0.5F, 0F, 0.5F).compostChance(0.85F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    KUSA_DAIFUKU(FoodInfo.builder().name("kusa_daifuku").amountAndCalories(6, 0.6F).water(0.5F).compostChance(0.85F).nutrients(3F, 0F, 1.5F, 0F, 0.5F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    DANGO(FoodInfo.builder().name("dango").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    DANANKO(FoodInfo.builder().name("dananko").amountAndCalories(6, 0.6F).water(1F).nutrients(3F, 0F, 0F, 0F, 1F).compostChance(0.85F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    DANMITARASHI(FoodInfo.builder().name("danmitarashi").amountAndCalories(6, 0.4F).water(1F).compostChance(0.85F).nutrients(3F, 0F, 0F, 0F, 1F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    DANSANSYOKU(FoodInfo.builder().name("dansansyoku").amountAndCalories(6, 0.6F).water(1F).compostChance(0.85F).nutrients(3F, 0F, 0F, 0F, 1F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    RED_BEAN_SOUP(FoodInfo.builder().name("red_bean_soup").amountAndCalories(6, 0.6F).water(50F).compostChance(0.5F).nutrients(2F, 0F, 2F, 0F, 2F).decayModifier(5F).heatCapacity(0F).cookingTemp(0F).build()),
    MISO_SOUP(FoodInfo.builder().name("miso_soup").amountAndCalories(5, 0.5F).water(50F).nutrients(0F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    OSUIMONO(FoodInfo.builder().name("osuimono").amountAndCalories(4, 0.5F).water(50F).nutrients(0F, 0F, 0F, 0F, 0F).compostChance(0.5F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    RAW_BURGER(FoodInfo.builder().name("raw_burger").amountAndCalories(2, 0.2F).water(1F).compostChance(0.5F).nutrients(0.5F, 0F, 0F, 3F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build()),
    BURGER(FoodInfo.builder().name("burger").amountAndCalories(6, 0.6F).water(2F).nutrients(0.5F, 0F, 0F, 4F, 0F).compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build()),
    BURGER_DISH(FoodInfo.builder().name("burger_dish").amountAndCalories(10, 0.8F).water(2.5F).compostChance(1F).nutrients(0.5F, 0F, 2F, 4F, 0F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    HAMBURGER(FoodInfo.builder().name("hamburger").amountAndCalories(8, 0.6F).water(0.5F).nutrients(2F, 0F, 2F, 4F, 1F).compostChance(1F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    CHEESE_BURGER(FoodInfo.builder().name("cheese_burger").amountAndCalories(10, 0.8F).water(0.5F).compostChance(1F).nutrients(2F, 0F, 2F, 4F, 3F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    CABBAGE_ROLL(FoodInfo.builder().name("cabbage_roll").amountAndCalories(4, 0.4F).water(25F).compostChance(1F).nutrients(0F, 0F, 4F, 0F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    CHAWANMUSHI(FoodInfo.builder().name("chawanmushi").amountAndCalories(4, 0.4F).water(25F).compostChance(1F).nutrients(0F, 0F, 4F, 0F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    WHITE_STEW(FoodInfo.builder().name("white_stew").amountAndCalories(4, 0.4F).water(25F).compostChance(1F).nutrients(0F, 0F, 4F, 0F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    FRUITSALAD(FoodInfo.builder().name("fruitsalad").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    RAW_TAIYAKI(FoodInfo.builder().name("raw_taiyaki").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    TAIYAKI(FoodInfo.builder().name("taiyaki").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    TAIYAKI_MOCHA(FoodInfo.builder().name("taiyaki_mocha").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    SASHIMI(FoodInfo.builder().name("sashimi").amountAndCalories(6, 0.6F).water(1F).nutrients(0F, 0F, 1F, 3F, 0F).compostChance(1F).decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build()),
    SALT_BAKED_FISH(FoodInfo.builder().name("salt_baked_fish").amountAndCalories(8, 0.8F).water(0.5F).compostChance(1F).nutrients(0F, 0F, 0F, 4F, 0F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    BAKED_FISH(FoodInfo.builder().name("baked_fish").amountAndCalories(9, 0.8F).water(0.5F).nutrients(0F, 0F, 0F, 4F, 0F).compostChance(1F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    YAKINIKU(FoodInfo.builder().name("yakiniku").amountAndCalories(10, 0.8F).water(0.5F).nutrients(0F, 0F, 0F, 4F, 0F).compostChance(1F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    NIKUJAGA(FoodInfo.builder().name("nikujaga").amountAndCalories(8, 0.6F).water(0.5F).nutrients(2F, 0F, 3F, 4F, 2F).compostChance(1F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    MABODOFU(FoodInfo.builder().name("mabodofu").amountAndCalories(8, 0.7F).water(25F).compostChance(1F).nutrients(0F, 0F, 3F, 3F, 0.5F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    MABOQIEZI(FoodInfo.builder().name("maboqiezi").amountAndCalories(8, 0.7F).water(25F).compostChance(1F).nutrients(0F, 0F, 3F, 2F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    FUROFUKI_DAIKON(FoodInfo.builder().name("furofuki_daikon").amountAndCalories(5, 0.6F).water(25F).compostChance(1F).nutrients(0F, 0F, 4F, 0F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    NIMONO_PUMPKIN(FoodInfo.builder().name("nimono_pumpkin").amountAndCalories(6, 0.5F).water(5F).nutrients(2F, 0F, 2F, 0F, 0F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    NIMONO_RADISH(FoodInfo.builder().name("nimono_radish").amountAndCalories(6, 0.5F).water(5F).nutrients(2F, 0F, 2F, 0F, 0F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    NIMONO_FISH(FoodInfo.builder().name("nimono_fish").amountAndCalories(8, 1F).water(6F).nutrients(0F, 0F, 0F, 3F, 3F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    CHIKUZENNI(FoodInfo.builder().name("chikuzenni").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    IMOTAKI(FoodInfo.builder().name("imotaki").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    NOPPEI_JIRU(FoodInfo.builder().name("noppei_jiru").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    OCHAZUKE(FoodInfo.builder().name("ochazuke").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    ODEN(FoodInfo.builder().name("oden").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    BAKED_CHEESE_BEAN(FoodInfo.builder().name("baked_cheese_bean").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    MAPLE_COOKIE(FoodInfo.builder().name("maple_cookie").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    MOCHA_COOKIE(FoodInfo.builder().name("mocha_cookie").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    CHESTNUT_TOASTED(FoodInfo.builder().name("toasted_chestnut").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    CUCUMBER(FoodInfo.builder().name("cucumber").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    DORAYAKI(FoodInfo.builder().name("dorayaki").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    OKINOYAKI(FoodInfo.builder().name("okinoyaki").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    OKINOYAKI_PLUS(FoodInfo.builder().name("okinoyaki_plus").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    OKINOYAKI_FINAL(FoodInfo.builder().name("okinoyaki_final").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    EDODES(FoodInfo.builder().name("edodes").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    MATSUTAKE(FoodInfo.builder().name("matsutake").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    ROAST_MATSUTAKE(FoodInfo.builder().name("roast_matsutake").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    SHIMEJI(FoodInfo.builder().name("shimeji").amountAndCalories(2, 0.2F).water(1F).compostChance(0.25F).nutrients(0F, 0F, 2F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),

    EGG_SOFT(FoodInfo.builder().name("soft_egg").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    EGG_SOYSAUCE(FoodInfo.builder().name("soysauce_egg").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    HYOROGAN(FoodInfo.builder().name("hyorogan").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    SUIKATSUGAN(FoodInfo.builder().name("suikatsugan").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),


    ZOSUI_ZUIKI(FoodInfo.builder().name("zuiki_zosui").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    ZOSUI(FoodInfo.builder().name("zosui").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F).compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    ;

    private final FoodInfo info;

    SakuraFoodSet(FoodInfo info) {
        this.info = info;
    }

    public FoodInfo getFoodInfo() {
        return info;
    }

    public String getName() {
        return info.getName();
    }

    public static Item getItem(SakuraFoodSet set) {
        String name = set.getFoodInfo().getName();
        ResourceLocation rl = ResourceLocationUtil.item(name);
        return Registry.ITEM.get(rl);
    }
}
