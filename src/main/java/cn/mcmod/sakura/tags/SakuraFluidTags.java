package cn.mcmod.sakura.tags;

import cn.mcmod.sakura.Sakura;
import cn.mcmod_mmf.mmlib.utils.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class SakuraFluidTags {
    public static final TagKey<Fluid> WATER_WATER = TagUtils.forgeFluidTag("water/water");
    public static final TagKey<Fluid> FOOD_OIL = TagUtils.modFluidTag(Sakura.MOD_ID, "food_oil");
    public static final TagKey<Fluid> PLANT_OIL = TagUtils.modFluidTag(Sakura.MOD_ID, "plant_oil");
    public static final TagKey<Fluid> GREEN_GRAPE_JUICE = TagUtils.modFluidTag(Sakura.MOD_ID, "green_grape_juice");
    public static final TagKey<Fluid> PURPLE_GRAPE_JUICE = TagUtils.modFluidTag(Sakura.MOD_ID, "purple_grape_juice");
    public static final TagKey<Fluid> HOT_SPRING = TagUtils.modFluidTag(Sakura.MOD_ID, "hot_spring");
    public static final TagKey<Fluid> MAPLE_SAP = TagUtils.modFluidTag(Sakura.MOD_ID, "maple_sap");
    public static final TagKey<Fluid> MAPLE_SYRUP = TagUtils.modFluidTag(Sakura.MOD_ID, "maple_syrup");
    public static final TagKey<Fluid> YEAST_LIQUID = TagUtils.modFluidTag(Sakura.MOD_ID, "yeast_liquid");

    public static final TagKey<Fluid> BREWERS_ALCOHOL = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol");
    public static final TagKey<Fluid> BEER = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/beer");
    public static final TagKey<Fluid> BRANDY = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/brandy");
    public static final TagKey<Fluid> COCOA_LIQUEUR = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/cocoa_liqueur");
    public static final TagKey<Fluid> CHAMPAGNE = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/champagne");
    public static final TagKey<Fluid> DOBUROKU = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/doburoku");
    public static final TagKey<Fluid> GIN = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/gin");
    public static final TagKey<Fluid> LIQUEUR = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/liqueur");
    public static final TagKey<Fluid> RED_WINE = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/red_wine");
    public static final TagKey<Fluid> RUM = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/rum");
    public static final TagKey<Fluid> SAKE = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/sake");
    public static final TagKey<Fluid> SHOUCHU = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/shouchu");
    public static final TagKey<Fluid> TEQUILA = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/tequila");
    public static final TagKey<Fluid> VODKA = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/vodka");
    public static final TagKey<Fluid> WHITE_WINE = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/white_wine");
    public static final TagKey<Fluid> WHISKEY = TagUtils.modFluidTag(Sakura.MOD_ID, "alcohol/whiskey");
}
