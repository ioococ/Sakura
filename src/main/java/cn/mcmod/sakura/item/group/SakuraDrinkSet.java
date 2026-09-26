package cn.mcmod.sakura.item.group;

import cn.mcmod_mmf.mmlib.item.ItemDrinkType;
import cn.mcmod_mmf.mmlib.item.info.DrinkInfo;

import java.util.Set;

public enum SakuraDrinkSet {
    WINE_BOTTLE(               DrinkInfo.builder().name("wine_bottle")  .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    BEER_BOTTLE(               DrinkInfo.builder().name("brandy")       .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    CHAMPAGNE_BOTTLE(          DrinkInfo.builder().name("champagne")    .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    COCOA_LIQUEUR_BOTTLE(      DrinkInfo.builder().name("cocoa_liqueur").amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    DOBUROKU_BOTTLE(           DrinkInfo.builder().name("doburoku")     .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    GIN_BOTTLE(                DrinkInfo.builder().name("gin")          .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    LIQUEUR_BOTTLE(            DrinkInfo.builder().name("liqueur")      .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    RED_WINE_BOTTLE(           DrinkInfo.builder().name("red_wine")     .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    RUM_BOTTLE(                DrinkInfo.builder().name("rum")          .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    SAKE_BOTTLE(               DrinkInfo.builder().name("sake")         .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    SHOUCHU_BOTTLE(            DrinkInfo.builder().name("shouchu")      .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    TEQUILA_BOTTLE(            DrinkInfo.builder().name("tequila")      .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    VODKA_BOTTLE(              DrinkInfo.builder().name("vodka")        .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    WHISKEY_BOTTLE(            DrinkInfo.builder().name("whiskey")      .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),
    WHITE_WINE_BOTTLE(         DrinkInfo.builder().name("white_wine")   .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.BOTTLE).decayModifier(2F).build()),

    GLASS_CUP(                DrinkInfo.builder().name("glass_cup")           .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).decayModifier(2F).build()),
    ALEXANDER_CUP(            DrinkInfo.builder().name("alexander")           .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    AVIATION_CUP(             DrinkInfo.builder().name("aviation")            .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    BEER_CUP(                 DrinkInfo.builder().name("beer")                .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    BEER_MARGARITA_CUP(       DrinkInfo.builder().name("beer_margarita")      .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    BETWEEN_THE_SHEETS_CUP(   DrinkInfo.builder().name("between_the_sheets")  .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    BLACK_RUSSIAN_CUP(        DrinkInfo.builder().name("black_russian")       .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    BLOODY_MARY_CUP(          DrinkInfo.builder().name("bloody_mary")         .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    BOILERMAKER_CUP(          DrinkInfo.builder().name("boilermaker")         .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    BRANDY_CUP(               DrinkInfo.builder().name("brandy")              .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    CHAMPAGNE_CUP(            DrinkInfo.builder().name("champagne")           .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    COCOA_LIQUEUR_CUP(        DrinkInfo.builder().name("cocoa_liqueur")       .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    DAIQUIRI_CUP(             DrinkInfo.builder().name("daiquiri")            .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    DOBUROKU_CUP(             DrinkInfo.builder().name("doburoku")            .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    EGGNOG_CUP(               DrinkInfo.builder().name("eggnog")              .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    FLYING_GRASSHOPPER_CUP(   DrinkInfo.builder().name("flying_grasshopper")  .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    FRENCH_SEVENFIVE_CUP(     DrinkInfo.builder().name("french_sevenfive")    .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    GIMLET_CUP(               DrinkInfo.builder().name("gimlet")              .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    GIN_CUP(                  DrinkInfo.builder().name("gin")                 .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    GODFATHER_CUP(            DrinkInfo.builder().name("godfather")           .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    GODMOTHER_CUP(            DrinkInfo.builder().name("godmother")           .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    GRASSHOPPER_CUP(          DrinkInfo.builder().name("grasshopper")         .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    HIGHBALL_CUP(             DrinkInfo.builder().name("highball")            .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    JOHN_COLLINS_CUP(         DrinkInfo.builder().name("john_collins")        .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    KIR_CUP(                  DrinkInfo.builder().name("kir")                 .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    LEMON_MARGARITA_CUP(      DrinkInfo.builder().name("lemon_margarita")     .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    LIQUEUR_CUP(              DrinkInfo.builder().name("liqueur")             .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    LONG_ISLAND_ICED_TEA_CUP( DrinkInfo.builder().name("long_island_iced_tea").amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    MARGARITA_CUP(            DrinkInfo.builder().name("margarita")           .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    MINT_JULEP_CUP(           DrinkInfo.builder().name("mint_julep")          .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    MOJITO_CUP(               DrinkInfo.builder().name("mojito")              .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    MOSCOW_MULE_CUP(          DrinkInfo.builder().name("moscow_mule")         .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    NEGRONI_CUP(              DrinkInfo.builder().name("negroni")             .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    OLD_FASHIONED_CUP(        DrinkInfo.builder().name("old_fashioned")       .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    PANACHE_CUP(              DrinkInfo.builder().name("panache")             .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    PARADISE_CUP(             DrinkInfo.builder().name("paradise")            .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    PORCHCRAWLER_CUP(         DrinkInfo.builder().name("porchcrawler")        .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    PORTO_FLIP_CUP(           DrinkInfo.builder().name("porto_flip")          .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    RED_EYES_CUP(             DrinkInfo.builder().name("red_eyes")            .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    RED_WINE_CUP(             DrinkInfo.builder().name("red_wine")            .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    ROYAL_KIR_CUP(            DrinkInfo.builder().name("royal_kir")           .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    RUM_CUP(                  DrinkInfo.builder().name("rum")                 .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    RUSSIAN_SPRING_CUP(       DrinkInfo.builder().name("russian_spring")      .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    RUSTY_NAIL_CUP(           DrinkInfo.builder().name("rusty_nail")          .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    SAKE_CUP(                 DrinkInfo.builder().name("sake")                .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    SAKETINI_CUP(             DrinkInfo.builder().name("saketini")            .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    SCORPION_CUP(             DrinkInfo.builder().name("scorpion")            .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    SCREW_DRIVER_CUP(         DrinkInfo.builder().name("screw_driver")        .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    SHOUCHU_CUP(              DrinkInfo.builder().name("shouchu")             .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    SIDECAR_CUP(              DrinkInfo.builder().name("sidecar")             .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    SPRITZER_CUP(             DrinkInfo.builder().name("spritzer")            .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    STINGER_CUP(              DrinkInfo.builder().name("stinger")             .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    TEQUILA_CUP(              DrinkInfo.builder().name("tequila")             .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    TEQUILA_SUNRISE_CUP(      DrinkInfo.builder().name("tequila_sunrise")     .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    VODKA_CUP(                DrinkInfo.builder().name("vodka")               .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    WHISKEY_CUP(              DrinkInfo.builder().name("whiskey")             .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    WHISKEY_SOUR_CUP(         DrinkInfo.builder().name("whiskey_sour")        .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),
    WHITE_WINE_CUP(           DrinkInfo.builder().name("white_wine")          .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.CUP).build()),

    TEA_CUP(                   DrinkInfo.builder().name("tea_cup")           .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(2F).build()),
    BLACK_TEA(                 DrinkInfo.builder().name("black_tea")         .amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),
    MILK_TEA(                  DrinkInfo.builder().name("milk_tea")          .amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),
    GREEN_MILK_TEA(            DrinkInfo.builder().name("green_milk_tea")    .amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),
    EARL_GREY(                 DrinkInfo.builder().name("earl_grey_tea")     .amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),
    EARL_GREY_MILK_TEA(        DrinkInfo.builder().name("earl_grey_milk_tea").amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),
    FRUIT_TEA(                 DrinkInfo.builder().name("fruit_tea")         .amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),
    FRUIT_MILK_TEA(            DrinkInfo.builder().name("fruit_milk_tea")    .amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),
    GREEN_TEA(                 DrinkInfo.builder().name("green_tea")         .amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),
    LEMON_BLACK_TEA(           DrinkInfo.builder().name("lemon_black_tea")   .amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),
    LEMON_GREEN_TEA(           DrinkInfo.builder().name("lemon_green_tea")   .amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),
    MINT_TEA(                  DrinkInfo.builder().name("mint_tea")          .amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),
    BARLEY_TEA(                DrinkInfo.builder().name("barley_tea")        .amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),
    BROWN_RICE_TEA(            DrinkInfo.builder().name("brown_rice_tea")    .amount(1).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.TEA).decayModifier(5F).build()),

    ORANGE_JUICE(              DrinkInfo.builder().name("orange_juice")      .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.JUICE).decayModifier(2F).build()),
    LEMON_JUICE(               DrinkInfo.builder().name("lemon_juice")       .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.JUICE).decayModifier(2F).build()),
    BLACKCURRANT_JUICE(        DrinkInfo.builder().name("blackcurrant_juice").amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.JUICE).decayModifier(2F).build()),
    SODA_WATER(                DrinkInfo.builder().name("soda_water")        .amount(2).calories(0.5F).water(50F).compostChance(0.2F).type(ItemDrinkType.JUICE).decayModifier(2F).build()),
    ;

    private final DrinkInfo info;

    SakuraDrinkSet(DrinkInfo info) {
        this.info = info;
    }

    public DrinkInfo getDrinkInfo() {
        return info;
    }

    private static final Set<String> CONTAINERS = Set.of("glass_cup", "tea_cup", "wine_bottle");

    public static boolean isContainer(String name) {
        return CONTAINERS.contains(name);
    }
}