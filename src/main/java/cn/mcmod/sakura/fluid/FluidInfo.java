package cn.mcmod.sakura.fluid;

public enum FluidInfo {
    BEER(              "beer",               0xFFF2A918, 1010, 1500, 10, 280, 4),
    BRANDY(            "brandy",             0xFFBF2F00, 950,  1200, 8,  293, 3),
    CHAMPAGNE(         "champagne",          0xFFFFE772, 990,  1100, 6,  277, 3),
    COCOA_LIQUEUR(     "cocoa_liqueur",      0xFF3A160C, 1100, 3000, 15, 293, 5),
    DOBUROKU(          "doburoku",           0xFFCCC299, 1050, 2000, 12, 283, 4),
    GIN(               "gin",                0xFFB8617C, 940,  1100, 5,  293, 3),
    GREEN_GRAPE_JUICE( "green_grape_juice",  0xFFA7E54E, 1040, 1200, 8,  283, 3),
    FOOD_OIL(          "food_oil",           0xFFFFF050, 920,  5000, 15, 293, 6),
    HOT_SPRING(        "hot_spring",         0xFF91D2FF, 960,  300,  3,  350, 2),
    LIQUEUR(           "liqueur",            0xFFC8102E, 1030, 1500, 10, 293, 4),
    MAPLE_SAP(         "maple_sap",          0x6FE1BE8C, 1030, 1500, 8,  280, 3),
    MAPLE_SYRUP(       "maple_syrup",        0xFFFFCC50, 1330, 5000, 20, 293, 6),
    PURPLE_GRAPE_JUICE("purple_grape_juice", 0xFF4C0099, 1050, 1300, 8,  283, 4),
    RUM(               "rum",                0xFFFFAA32, 950,  1200, 6,  293, 3),
    RED_WINE(          "red_wine",           0xFFA71844, 990,  1500, 8,  293, 4),
    SAKE(              "sake",               0xDDFFF8CC, 1010, 1200, 8,  293, 3),
    SHOUCHU(           "shouchu",            0xBBFFFCF2, 960,  1100, 6,  293, 3),
    TEQUILA(           "tequila",            0x33F5EBD2, 940,  1100, 5,  293, 3),
    VODKA(             "vodka",              0x330089FF, 940,  1100, 5,  293, 3),
    WHISKEY(           "whiskey",            0xFFA52121, 950,  1300, 7,  293, 4),
    WHITE_WINE(        "white_wine",         0xFFFFF8B2, 990,  1200, 7,  293, 3),
    YEAST_LIQUID(      "yeast_liquid",       0xFFF6DABE, 1050, 2000, 12, 303, 4);

    public final String key;
    public final Integer color;
    public final Integer density;
    public final Integer viscosity;
    public final Integer tickRate;
    public final Integer temperature;
    public final Integer slopeFindDistance;

    FluidInfo(String key, int color, int density, int viscosity, int tickRate, int temperature, int slopeFindDistance) {
        this.key = key;
        this.color = color;
        this.density = density;
        this.viscosity = viscosity;
        this.tickRate = tickRate;
        this.temperature = temperature;
        this.slopeFindDistance = slopeFindDistance;
    }
}