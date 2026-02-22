package cn.mcmod.sakura.item.enums;

import cn.mcmod_mmf.mmlib.item.info.FoodInfo;

public enum SakuraFoodSet {
    SHRIMP(FoodInfo.builder().name("shrimp").amountAndCalories(2, 0.6F).water(0.5F).nutrients(0F, 0F, 0F, 2F, 0F)
            .compostChance(0.2F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    TOMATO(FoodInfo.builder().name("tomato").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
            .compostChance(0.3F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    RADISH(FoodInfo.builder().name("radish").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
            .compostChance(0.3F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    EGGPLANT(FoodInfo.builder().name("eggplant").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
            .compostChance(0.3F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    CABBAGE(FoodInfo.builder().name("cabbage").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
            .compostChance(0.3F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    ONION(FoodInfo.builder().name("onion").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
            .compostChance(0.3F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    SLICED_CABBAGE(FoodInfo.builder().name("sliced_cabbage").amountAndCalories(2, 0.2F).water(5F).compostChance(0.3F)
            .nutrients(0F, 0F, 2F, 0F, 0F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    MACHINED_FISH(FoodInfo.builder().name("machined_fish").amountAndCalories(1, 0.2F).water(1F).nutrients(0F, 0F, 0F, 2F, 2F)
            .compostChance(0.25F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    MINCED_MEAT(FoodInfo.builder().name("minced_meat").amountAndCalories(2, 0.2F).water(1F).compostChance(0.25F)
            .nutrients(0F, 0F, 0F, 3F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build()),
    SURIMI(FoodInfo.builder().name("surimi").amountAndCalories(2, 0.2F).water(1F).compostChance(0.25F)
            .nutrients(0F, 0F, 0F, 3F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build()),

    FISHCAKE(FoodInfo.builder().name("fishcake").amountAndCalories(4, 0.6F).water(1F).nutrients(1F, 0F, 1F, 2F, 0F)
            .compostChance(0.5F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    KAMABOKO(FoodInfo.builder().name("kamaboko").amountAndCalories(4, 0.6F).water(1F).nutrients(1F, 0F, 1F, 2F, 0F)
            .compostChance(0.5F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    RAW_CHIKUWA(FoodInfo.builder().name("raw_chikuwa").amountAndCalories(4, 0.6F).water(1F).nutrients(1F, 0F, 1F, 2F, 0F)
            .compostChance(0.5F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    CHIKUWA(FoodInfo.builder().name("chikuwa").amountAndCalories(4, 0.6F).water(1F).nutrients(1F, 0F, 1F, 2F, 0F)
            .compostChance(0.5F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    SATSUMAAGE(FoodInfo.builder().name("satsumaage").amountAndCalories(4, 0.6F).water(1F).nutrients(1F, 0F, 1F, 2F, 0F)
            .compostChance(0.5F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),

    TOMATO_SAUCE(FoodInfo.builder().name("tomato_sauce").amountAndCalories(2, 0.2F).water(5F).compostChance(0.25F)
            .nutrients(0F, 0F, 2F, 0F, 0F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    BAKED_EGGPLANT(FoodInfo.builder().name("baked_eggplant").amountAndCalories(4, 0.5F).water(0F).compostChance(0.5F)
            .nutrients(0F, 0F, 3F, 0F, 0F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    BAKED_TARO(FoodInfo.builder().name("baked_taro").amountAndCalories(5, 0.6F).water(0F).nutrients(2F, 2F, 0F, 0F, 0F)
            .compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    CHEESE(FoodInfo.builder().name("cheese").amountAndCalories(2, 0.2F).water(1F).nutrients(0F, 0F, 0F, 0F, 2F)
            .compostChance(0.5F).decayModifier(2F).heatCapacity(0F).cookingTemp(-1F).build()),
    TAMAGOYAKI(FoodInfo.builder().name("tamagoyaki").amountAndCalories(6, 0.6F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 3F)
            .compostChance(0.75F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),

    TOFU(FoodInfo.builder().name("tofu").amountAndCalories(2, 0.4F).water(0.5F).nutrients(0F, 0F, 2F, 0F, 0.5F)
            .compostChance(0.5F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    FRIED_TOFU(FoodInfo.builder().name("fried_tofu").amountAndCalories(4, 0.5F).water(0.5F).compostChance(0.5F)
            .nutrients(0.5F, 0F, 3F, 0F, 0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    NATTO(FoodInfo.builder().name("natto").amountAndCalories(2, 0.5F).water(0.5F).nutrients(1F, 0F, 2F, 0F, 0F)
            .compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),

    MASHED_POTATO(FoodInfo.builder().name("mashed_potato").amountAndCalories(5, 0.6F).water(0.5F).compostChance(0.5F)
            .nutrients(2F, 0F, 2F, 0F, 0.5F).decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build()),
    FRIES(FoodInfo.builder().name("fries").amountAndCalories(5, 0.6F).water(1F).nutrients(2F, 0F, 2F, 0F, 0F)
            .decayModifier(1F).heatCapacity(1F).cookingTemp(480F).build()),

    BUN(FoodInfo.builder().name("bun").amountAndCalories(5, 0.6F).water(0F).nutrients(2F, 0F, 0F, 0F, 0F)
            .compostChance(0.5F).decayModifier(0.8F).heatCapacity(1F).cookingTemp(480F).build()),
    BUCKWHEAT_BREAD(FoodInfo.builder().name("buckwheat_bread").amountAndCalories(5, 0.6F).water(0F).compostChance(0.5F)
            .nutrients(2F, 0F, 0F, 0F, 0F).decayModifier(0.5F).heatCapacity(1F).cookingTemp(480F).build()),
    RICE_BREAD(FoodInfo.builder().name("rice_bread").amountAndCalories(5, 0.6F).water(0F).nutrients(2F, 0F, 0F, 0F, 0F)
            .compostChance(0.5F).decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build()),
    RED_BEAN_PASTE(FoodInfo.builder().name("red_bean_paste").amountAndCalories(4, 0.25F).water(4F).compostChance(0.5F)
            .nutrients(0.25F, 0F, 1F, 0F, 0F).decayModifier(4F).heatCapacity(0F).cookingTemp(-1F).build()),
    BREADCRUMBS(FoodInfo.builder().name("breadcrumbs").amountAndCalories(1, 0.1F).water(0F).compostChance(0.5F)
            .nutrients(0.25F, 0F, 0F, 0F, 0F).decayModifier(4F).heatCapacity(0F).cookingTemp(-1F).build()),
    
    FRIED_CHICKEN(FoodInfo.builder().name("fried_chicken").amountAndCalories(6, 0.6F).water(2F).nutrients(1F, 0F, 0F, 4F, 0F)
            .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    CROQUETTE(FoodInfo.builder().name("croquette").amountAndCalories(6, 0.6F).water(2F).nutrients(2F, 0F, 2.5F, 2F, 0F)
            .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    KATSU(FoodInfo.builder().name("katsu").amountAndCalories(9, 0.6F).water(4F).nutrients(0.25F, 0F, 0F, 3F, 0F)
            .decayModifier(1.25F).heatCapacity(0F).cookingTemp(-1F).build()),
    
    TEMPURA(FoodInfo.builder().name("tempura").amountAndCalories(5, 0.6F).water(0F).nutrients(1F, 0F, 0F, 2F, 0F)
            .compostChance(0.5F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    COOKED_BROWN_RICE(FoodInfo.builder().name("cooked_brown_rice").amountAndCalories(4, 0.5F).water(0.5F).compostChance(0.5F)
            .nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    COOKED_RICE(FoodInfo.builder().name("cooked_rice").amountAndCalories(4, 0.5F).water(0.5F).compostChance(0.5F)
            .nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    RED_BEAN_RICE(FoodInfo.builder().name("red_bean_rice").amountAndCalories(6, 0.6F).water(0.5F).compostChance(0.85F)
            .nutrients(4F, 0F, 2F, 0F, 0F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    BAMBOO_RICE(FoodInfo.builder().name("bamboo_rice").amountAndCalories(5, 0.6F).water(0.5F).compostChance(0.85F)
            .nutrients(1.5F, 1F, 0F, 0F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    BEEF_RICE(FoodInfo.builder().name("beef_rice").amountAndCalories(9, 0.8F).water(0.5F).compostChance(1F)
            .nutrients(1.5F, 0F, 0F, 3F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    FISH_RICE(FoodInfo.builder().name("fish_rice").amountAndCalories(7, 0.7F).water(0.5F).compostChance(1F)
            .nutrients(1.5F, 0F, 0F, 2F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    PORK_RICE(FoodInfo.builder().name("pork_rice").amountAndCalories(7, 0.7F).water(0.5F).compostChance(1F)
            .nutrients(1.5F, 0F, 0F, 3F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    FRIED_PORK_RICE(FoodInfo.builder().name("fried_pork_rice").amountAndCalories(10, 1F).water(0.5F)
            .nutrients(2F, 0F, 0F, 4F, 4F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    MUSHROOM_RICE(FoodInfo.builder().name("mushroom_rice").amountAndCalories(6, 0.6F).water(0.5F).compostChance(1F)
            .nutrients(1.5F, 0F, 2F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    EGG_RICE(FoodInfo.builder().name("egg_rice").amountAndCalories(5, 0.6F).water(0.5F).nutrients(1.5F, 0F, 0F, 0F, 2F)
            .compostChance(0.85F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    BEEF_EGG_RICE(FoodInfo.builder().name("beef_egg_rice").amountAndCalories(10, 1F).water(0.5F).compostChance(1F)
            .nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    PORK_EGG_RICE(FoodInfo.builder().name("pork_egg_rice").amountAndCalories(9, 0.8F).water(0.5F).compostChance(1F)
            .nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    OYAKO_RICE(FoodInfo.builder().name("oyako_rice").amountAndCalories(9, 0.8F).water(0.5F).compostChance(1F)
            .nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    OYAKO_FISH_RICE(FoodInfo.builder().name("fish_oyako_rice").amountAndCalories(9, 0.8F).water(0.5F).compostChance(1F)
            .nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    NATTO_RICE(FoodInfo.builder().name("natto_rice").amountAndCalories(5, 0.6F).water(0.5F).nutrients(2.5F, 0F, 2F, 0F, 0F)
            .compostChance(0.85F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    NATTO_EGG_RICE(FoodInfo.builder().name("natto_egg_rice").amountAndCalories(6, 0.6F).water(0.5F).compostChance(1F)
            .nutrients(2.5F, 0F, 3F, 0F, 3F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    FRIED_RICE(FoodInfo.builder().name("fried_rice").amountAndCalories(8, 0.6F).water(0.5F).nutrients(1.5F, 0F, 2F, 2F, 0F)
            .compostChance(1F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    OMURICE(FoodInfo.builder().name("omurice").amountAndCalories(8, 0.6F).water(0.5F).nutrients(2F, 0F, 3F, 3F, 2F)
            .compostChance(1F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    ONIGIRI(FoodInfo.builder().name("onigiri").amountAndCalories(6, 0.6F).water(0.5F).nutrients(2F, 0F, 1F, 0F, 0F)
            .compostChance(0.85F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    BAMBOO_ONIGIRI(FoodInfo.builder().name("bamboo_onigiri").amountAndCalories(7, 0.7F).water(0.5F).compostChance(0.85F)
            .nutrients(2F, 0F, 2F, 0F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    FISH_ONIGIRI(FoodInfo.builder().name("fish_onigiri").amountAndCalories(8, 0.7F).water(0.5F).compostChance(1F)
            .nutrients(2F, 0F, 1F, 2F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    MUSHROOM_ONIGIRI(FoodInfo.builder().name("mushroom_onigiri").amountAndCalories(7, 0.7F).water(0.5F).compostChance(1F)
            .nutrients(2F, 0F, 2F, 0F, 0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    SEAWEED_ONIGIRI(FoodInfo.builder().name("seaweed_onigiri").amountAndCalories(7, 0.7F).water(0.5F).compostChance(1F)
            .nutrients(2F, 0F, 2F, 0F, 0.5F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    TEMPURA_ONIGIRI(FoodInfo.builder().name("tempura_onigiri").amountAndCalories(10, 0.8F).water(0.5F).compostChance(1F)
            .nutrients(2F, 0F, 2F, 4F, 1F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    SUSHI(FoodInfo.builder().name("sushi").amountAndCalories(5, 0.6F).water(1F).nutrients(2F, 0F, 0F, 2F, 0F)
            .compostChance(0.85F).decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build()),
    SHRIMP_SUSHI(FoodInfo.builder().name("shrimp_sushi").amountAndCalories(5, 0.6F).water(1F).nutrients(2F, 0F, 0F, 2F, 0F)
            .compostChance(0.85F).decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build()),
    TAMAGO_SUSHI(FoodInfo.builder().name("tamago_sushi").amountAndCalories(4, 0.6F).water(1F).nutrients(2F, 0F, 0F, 0F, 2F)
            .compostChance(0.85F).decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build()),
    MOCHI(FoodInfo.builder().name("mochi").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F)
            .compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    TOASTED_MOCHI(FoodInfo.builder().name("toasted_mochi").amountAndCalories(4, 0.6F).water(0.5F).compostChance(0.75F)
            .nutrients(3F, 0F, 0F, 0F, 0F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build()),
    SAKURA_MOCHI(FoodInfo.builder().name("sakura_mochi").amountAndCalories(4, 0.6F).water(0.5F).compostChance(0.85F)
            .nutrients(3F, 0F, 1F, 0F, 0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    OHAGI(FoodInfo.builder().name("ohagi").amountAndCalories(6, 0.6F).water(0.5F).nutrients(3F, 0F, 0.5F, 0F, 0.5F)
            .compostChance(0.85F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    DAIFUKU(FoodInfo.builder().name("daifuku").amountAndCalories(4, 0.6F).water(0.5F).nutrients(3F, 0F, 0.5F, 0F, 0.5F)
            .compostChance(0.85F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    KUSA_DAIFUKU(FoodInfo.builder().name("kusa_daifuku").amountAndCalories(6, 0.6F).water(0.5F).compostChance(0.85F)
            .nutrients(3F, 0F, 1.5F, 0F, 0.5F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build()),
    DANGO(FoodInfo.builder().name("dango").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F)
            .compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    DANANKO(FoodInfo.builder().name("dananko").amountAndCalories(6, 0.6F).water(1F).nutrients(3F, 0F, 0F, 0F, 1F)
            .compostChance(0.85F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    DANMITARASHI(FoodInfo.builder().name("danmitarashi").amountAndCalories(6, 0.4F).water(1F).compostChance(0.85F)
            .nutrients(3F, 0F, 0F, 0F, 1F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    DANSANSYOKU(FoodInfo.builder().name("dansansyoku").amountAndCalories(6, 0.6F).water(1F).compostChance(0.85F)
            .nutrients(3F, 0F, 0F, 0F, 1F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build()),
    RED_BEAN_SOUP(FoodInfo.builder().name("red_bean_soup").amountAndCalories(6, 0.6F).water(50F).compostChance(0.5F)
            .nutrients(2F, 0F, 2F, 0F, 2F).decayModifier(5F).heatCapacity(0F).cookingTemp(0F).build()),
    MISO_SOUP(FoodInfo.builder().name("miso_soup").amountAndCalories(5, 0.5F).water(50F).nutrients(0F, 0F, 0F, 0F, 0F)
            .compostChance(0.5F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    OSUIMONO(FoodInfo.builder().name("osuimono").amountAndCalories(4, 0.5F).water(50F).nutrients(0F, 0F, 0F, 0F, 0F)
            .compostChance(0.5F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    RAW_BURGER(FoodInfo.builder().name("raw_burger").amountAndCalories(2, 0.2F).water(1F).compostChance(0.5F)
            .nutrients(0.5F, 0F, 0F, 3F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build()),
    BURGER(FoodInfo.builder().name("burger").amountAndCalories(6, 0.6F).water(2F).nutrients(0.5F, 0F, 0F, 4F, 0F)
            .compostChance(0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build()),
    BURGER_DISH(FoodInfo.builder().name("burger_dish").amountAndCalories(10, 0.8F).water(2.5F).compostChance(1F)
            .nutrients(0.5F, 0F, 2F, 4F, 0F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build()),
    HAMBURGER(FoodInfo.builder().name("hamburger").amountAndCalories(8, 0.6F).water(0.5F).nutrients(2F, 0F, 2F, 4F, 1F)
            .compostChance(1F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    CHEESE_BURGER(FoodInfo.builder().name("cheese_burger").amountAndCalories(10, 0.8F).water(0.5F).compostChance(1F)
            .nutrients(2F, 0F, 2F, 4F, 3F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    CABBAGE_ROLL(FoodInfo.builder().name("cabbage_roll").amountAndCalories(4, 0.4F).water(25F).compostChance(1F)
            .nutrients(0F, 0F, 4F, 0F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    SASHIMI(FoodInfo.builder().name("sashimi").amountAndCalories(6, 0.6F).water(1F).nutrients(0F, 0F, 1F, 3F, 0F)
            .compostChance(1F).decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build()),
    SALT_BAKED_FISH(FoodInfo.builder().name("salt_baked_fish").amountAndCalories(8, 0.8F).water(0.5F).compostChance(1F)
            .nutrients(0F, 0F, 0F, 4F, 0F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    BAKED_FISH(FoodInfo.builder().name("baked_fish").amountAndCalories(9, 0.8F).water(0.5F).nutrients(0F, 0F, 0F, 4F, 0F)
            .compostChance(1F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    YAKINIKU(FoodInfo.builder().name("yakiniku").amountAndCalories(10, 0.8F).water(0.5F).nutrients(0F, 0F, 0F, 4F, 0F)
            .compostChance(1F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    NIKUJAGA(FoodInfo.builder().name("nikujaga").amountAndCalories(8, 0.6F).water(0.5F).nutrients(2F, 0F, 3F, 4F, 2F)
            .compostChance(1F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build()),
    FUROFUKI_DAIKON(FoodInfo.builder().name("furofuki_daikon").amountAndCalories(5, 0.6F).water(25F).compostChance(1F)
            .nutrients(0F, 0F, 4F, 0F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    NIMONO_PUMPKIN(FoodInfo.builder().name("nimono_pumpkin").amountAndCalories(6, 0.5F).water(5F).nutrients(2F, 0F, 2F, 0F, 0F)
            .compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    NIMONO_RADISH(FoodInfo.builder().name("nimono_radish").amountAndCalories(6, 0.5F).water(5F).nutrients(2F, 0F, 2F, 0F, 0F)
            .compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    NIMONO_FISH(FoodInfo.builder().name("nimono_fish").amountAndCalories(8, 1F).water(6F).nutrients(0F, 0F, 0F, 3F, 3F)
            .compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    CHIKUZENNI(FoodInfo.builder().name("chikuzenni").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F)
            .compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    IMOTAKI(FoodInfo.builder().name("imotaki").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F)
            .compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),
    NOPPEI_JIRU(FoodInfo.builder().name("noppei_jiru").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F)
            .compostChance(1F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build()),

    ;

    private final FoodInfo info;

    private SakuraFoodSet(FoodInfo info) {
        this.info = info;
    }

    public FoodInfo getFoodInfo() {
        return info;
    }
}
