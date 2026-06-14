package cn.mcmod.sakura.fluid;

import java.util.function.Supplier;

import cn.mcmod.sakura.Sakura;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static cn.mcmod.sakura.fluid.BucketItemRegistry.*;
import static cn.mcmod.sakura.fluid.BucketItemRegistry.COCOA_LIQUEUR_BUCKET;
import static cn.mcmod.sakura.fluid.BucketItemRegistry.GIN_BUCKET;
import static cn.mcmod.sakura.fluid.BucketItemRegistry.GREEN_GRAPE_JUICE_BUCKET;
import static cn.mcmod.sakura.fluid.BucketItemRegistry.HOT_SPRING_BUCKET;
import static cn.mcmod.sakura.fluid.BucketItemRegistry.LIQUEUR_BUCKET;
import static cn.mcmod.sakura.fluid.BucketItemRegistry.MAPLE_SAP_BUCKET;
import static cn.mcmod.sakura.fluid.BucketItemRegistry.MAPLE_SYRUP_BUCKET;
import static cn.mcmod.sakura.fluid.BucketItemRegistry.PURPLE_GRAPE_JUICE_BUCKET;
import static cn.mcmod.sakura.fluid.BucketItemRegistry.TEQUILA_BUCKET;
import static cn.mcmod.sakura.fluid.BucketItemRegistry.VODKA_BUCKET;
import static cn.mcmod.sakura.fluid.BucketItemRegistry.YEAST_FLUID_BUCKET;
import static cn.mcmod.sakura.fluid.FluidBlockRegistry.*;
import static cn.mcmod.sakura.fluid.FluidBlockRegistry.YEAST_FLUID_BLOCK;

public class FluidRegistry {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Sakura.MOD_ID);

    public static final RegistryObject<FlowingFluid> BEER = FLUIDS.register("beer", () -> new ForgeFlowingFluid.Source(FluidRegistry.BEER_PROP));
    public static final RegistryObject<FlowingFluid> BEER_FLOWING = FLUIDS.register("beer_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.BEER_PROP));

    public static final RegistryObject<FlowingFluid> BRANDY = FLUIDS.register("brandy", () -> new ForgeFlowingFluid.Source(FluidRegistry.BRANDY_PROP));
    public static final RegistryObject<FlowingFluid> BRANDY_FLOWING = FLUIDS.register("brandy_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.BRANDY_PROP));

    public static final RegistryObject<FlowingFluid> CHAMPAGNE = FLUIDS.register("champagne", () -> new ForgeFlowingFluid.Source(FluidRegistry.CHAMPAGNE_PROP));
    public static final RegistryObject<FlowingFluid> CHAMPAGNE_FLOWING = FLUIDS.register("champagne_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.CHAMPAGNE_PROP));

    public static final RegistryObject<FlowingFluid> COCOA_LIQUEUR = FLUIDS.register("cocoa_liqueur", () -> new ForgeFlowingFluid.Source(FluidRegistry.COCOA_LIQUEUR_PROP));
    public static final RegistryObject<FlowingFluid> COCOA_LIQUEUR_FLOWING = FLUIDS.register("cocoa_liqueur_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.COCOA_LIQUEUR_PROP));

    public static final RegistryObject<FlowingFluid> DOBUROKU = FLUIDS.register("doburoku", () -> new ForgeFlowingFluid.Source(FluidRegistry.DOBUROKU_PROP));
    public static final RegistryObject<FlowingFluid> DOBUROKU_FLOWING = FLUIDS.register("doburoku_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.DOBUROKU_PROP));

    public static final RegistryObject<FlowingFluid> GIN = FLUIDS.register("gin", () -> new ForgeFlowingFluid.Source(FluidRegistry.GIN_PROP));
    public static final RegistryObject<FlowingFluid> GIN_FLOWING = FLUIDS.register("gin_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.GIN_PROP));

    public static final RegistryObject<FlowingFluid> GREEN_GRAPE_JUICE = FLUIDS.register("green_grape_juice", () -> new ForgeFlowingFluid.Source(FluidRegistry.GREEN_GRAPE_JUICE_PROP));
    public static final RegistryObject<FlowingFluid> GREEN_GRAPE_JUICE_FLOWING = FLUIDS.register("green_grape_juice_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.GREEN_GRAPE_JUICE_PROP));

    public static final RegistryObject<FlowingFluid> FOOD_OIL = FLUIDS.register("food_oil", () -> new ForgeFlowingFluid.Source(FluidRegistry.FOOD_OIL_PROP));
    public static final RegistryObject<FlowingFluid> FOOD_OIL_FLOWING = FLUIDS.register("food_oil_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.FOOD_OIL_PROP));

    public static final RegistryObject<FlowingFluid> HOT_SPRING = FLUIDS.register("hot_spring", () -> new ForgeFlowingFluid.Source(FluidRegistry.HOT_SPRING_PROP));
    public static final RegistryObject<FlowingFluid> HOT_SPRING_FLOWING = FLUIDS.register("hot_spring_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.HOT_SPRING_PROP));

    public static final RegistryObject<FlowingFluid> LIQUEUR = FLUIDS.register("liqueur", () -> new ForgeFlowingFluid.Source(FluidRegistry.LIQUEUR_PROP));
    public static final RegistryObject<FlowingFluid> LIQUEUR_FLOWING = FLUIDS.register("liqueur_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.LIQUEUR_PROP));

    public static final RegistryObject<FlowingFluid> MAPLE_SAP = FLUIDS.register("maple_sap", () -> new ForgeFlowingFluid.Source(FluidRegistry.MAPLE_SAP_PROP));
    public static final RegistryObject<FlowingFluid> MAPLE_SAP_FLOWING = FLUIDS.register("maple_sap_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.MAPLE_SAP_PROP));

    public static final RegistryObject<FlowingFluid> MAPLE_SYRUP = FLUIDS.register("maple_syrup", () -> new ForgeFlowingFluid.Source(FluidRegistry.MAPLE_SYRUP_PROP));
    public static final RegistryObject<FlowingFluid> MAPLE_SYRUP_FLOWING = FLUIDS.register("maple_syrup_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.MAPLE_SYRUP_PROP));

    public static final RegistryObject<FlowingFluid> PURPLE_GRAPE_JUICE = FLUIDS.register("purple_grape_juice", () -> new ForgeFlowingFluid.Source(FluidRegistry.PURPLE_GRAPE_JUICE_PROP));
    public static final RegistryObject<FlowingFluid> PURPLE_GRAPE_JUICE_FLOWING = FLUIDS.register("purple_grape_juice_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.PURPLE_GRAPE_JUICE_PROP));

    public static final RegistryObject<FlowingFluid> RED_WINE = FLUIDS.register("red_wine", () -> new ForgeFlowingFluid.Source(FluidRegistry.RED_WINE_PROP));
    public static final RegistryObject<FlowingFluid> RED_WINE_FLOWING = FLUIDS.register("red_wine_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.RED_WINE_PROP));

    public static final RegistryObject<FlowingFluid> RUM = FLUIDS.register("rum", () -> new ForgeFlowingFluid.Source(FluidRegistry.RUM_PROP));
    public static final RegistryObject<FlowingFluid> RUM_FLOWING = FLUIDS.register("rum_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.RUM_PROP));

    public static final RegistryObject<FlowingFluid> SAKE = FLUIDS.register("sake", () -> new ForgeFlowingFluid.Source(FluidRegistry.SAKE_PROP));
    public static final RegistryObject<FlowingFluid> SAKE_FLOWING = FLUIDS.register("sake_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.SAKE_PROP));

    public static final RegistryObject<FlowingFluid> SHOUCHU = FLUIDS.register("shouchu", () -> new ForgeFlowingFluid.Source(FluidRegistry.SHOUCHU_PROP));
    public static final RegistryObject<FlowingFluid> SHOUCHU_FLOWING = FLUIDS.register("shouchu_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.SHOUCHU_PROP));

    public static final RegistryObject<FlowingFluid> TEQUILA = FLUIDS.register("tequila", () -> new ForgeFlowingFluid.Source(FluidRegistry.TEQUILA_PROP));
    public static final RegistryObject<FlowingFluid> TEQUILA_FLOWING = FLUIDS.register("tequila_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.TEQUILA_PROP));

    public static final RegistryObject<FlowingFluid> VODKA = FLUIDS.register("vodka", () -> new ForgeFlowingFluid.Source(FluidRegistry.VODKA_PROP));
    public static final RegistryObject<FlowingFluid> VODKA_FLOWING = FLUIDS.register("vodka_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.VODKA_PROP));

    public static final RegistryObject<FlowingFluid> WHISKEY = FLUIDS.register("whiskey", () -> new ForgeFlowingFluid.Source(FluidRegistry.WHISKEY_PROP));
    public static final RegistryObject<FlowingFluid> WHISKEY_FLOWING = FLUIDS.register("whiskey_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.WHISKEY_PROP));

    public static final RegistryObject<FlowingFluid> WHITE_WINE = FLUIDS.register("white_wine", () -> new ForgeFlowingFluid.Source(FluidRegistry.WHITE_WINE_PROP));
    public static final RegistryObject<FlowingFluid> WHITE_WINE_FLOWING = FLUIDS.register("white_wine_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.WHITE_WINE_PROP));

    public static final RegistryObject<FlowingFluid> YEAST_LIQUID = FLUIDS.register("yeast_liquid", () -> new ForgeFlowingFluid.Source(FluidRegistry.YEAST_FLUID_PROP));
    public static final RegistryObject<FlowingFluid> YEAST_LIQUID_FLOWING = FLUIDS.register("yeast_liquid_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.YEAST_FLUID_PROP));

    /* Properties */
    private static final ForgeFlowingFluid.Properties BEER_PROP               = createProp(BEER, BEER_FLOWING, FluidInfo.BEER, BEER_BUCKET, BEER_BLOCK);
    private static final ForgeFlowingFluid.Properties BRANDY_PROP             = createProp(BRANDY, BRANDY_FLOWING, FluidInfo.BRANDY, BRANDY_BUCKET, BRANDY_BLOCK);
    private static final ForgeFlowingFluid.Properties CHAMPAGNE_PROP          = createProp(CHAMPAGNE, CHAMPAGNE_FLOWING, FluidInfo.CHAMPAGNE, CHAMPAGNE_BUCKET, CHAMPAGNE_BLOCK);
    private static final ForgeFlowingFluid.Properties COCOA_LIQUEUR_PROP      = createProp(COCOA_LIQUEUR, COCOA_LIQUEUR_FLOWING, FluidInfo.COCOA_LIQUEUR, COCOA_LIQUEUR_BUCKET, COCOA_LIQUEUR_BLOCK);
    private static final ForgeFlowingFluid.Properties DOBUROKU_PROP           = createProp(DOBUROKU, DOBUROKU_FLOWING, FluidInfo.DOBUROKU, DOBUROKU_BUCKET, DOBUROKU_BLOCK);
    private static final ForgeFlowingFluid.Properties GIN_PROP                = createProp(GIN, GIN_FLOWING, FluidInfo.GIN, GIN_BUCKET, GIN_BLOCK);
    private static final ForgeFlowingFluid.Properties GREEN_GRAPE_JUICE_PROP  = createProp(GREEN_GRAPE_JUICE, GREEN_GRAPE_JUICE_FLOWING, FluidInfo.GREEN_GRAPE_JUICE, GREEN_GRAPE_JUICE_BUCKET, GREEN_GRAPE_JUICE_BLOCK);
    private static final ForgeFlowingFluid.Properties FOOD_OIL_PROP           = createProp(FOOD_OIL, FOOD_OIL_FLOWING, FluidInfo.FOOD_OIL, FOOD_OIL_BUCKET, FOOD_OIL_BLOCK);
    private static final ForgeFlowingFluid.Properties HOT_SPRING_PROP         = createProp(HOT_SPRING, HOT_SPRING_FLOWING, FluidInfo.HOT_SPRING, HOT_SPRING_BUCKET, HOT_SPRING_BLOCK);
    private static final ForgeFlowingFluid.Properties LIQUEUR_PROP            = createProp(LIQUEUR, LIQUEUR_FLOWING, FluidInfo.LIQUEUR, LIQUEUR_BUCKET, LIQUEUR_BLOCK);
    private static final ForgeFlowingFluid.Properties MAPLE_SAP_PROP          = createProp(MAPLE_SAP, MAPLE_SAP_FLOWING, FluidInfo.MAPLE_SAP, MAPLE_SAP_BUCKET, MAPLE_SAP_BLOCK);
    private static final ForgeFlowingFluid.Properties MAPLE_SYRUP_PROP        = createProp(MAPLE_SYRUP, MAPLE_SYRUP_FLOWING, FluidInfo.MAPLE_SYRUP, MAPLE_SYRUP_BUCKET, MAPLE_SYRUP_BLOCK);
    private static final ForgeFlowingFluid.Properties PURPLE_GRAPE_JUICE_PROP = createProp(PURPLE_GRAPE_JUICE, PURPLE_GRAPE_JUICE_FLOWING, FluidInfo.PURPLE_GRAPE_JUICE, PURPLE_GRAPE_JUICE_BUCKET, PURPLE_GRAPE_JUICE_BLOCK);
    private static final ForgeFlowingFluid.Properties RUM_PROP                = createProp(RUM, RUM_FLOWING, FluidInfo.RUM, RUM_BUCKET, RUM_BLOCK);
    private static final ForgeFlowingFluid.Properties RED_WINE_PROP           = createProp(RED_WINE, RED_WINE_FLOWING, FluidInfo.RED_WINE, RED_WINE_BUCKET, RED_WINE_BLOCK);
    private static final ForgeFlowingFluid.Properties SAKE_PROP               = createProp(SAKE, SAKE_FLOWING, FluidInfo.SAKE, SAKE_BUCKET, SAKE_BLOCK);
    private static final ForgeFlowingFluid.Properties SHOUCHU_PROP            = createProp(SHOUCHU, SHOUCHU_FLOWING, FluidInfo.SHOUCHU, SHOUCHU_BUCKET, SHOUCHU_BLOCK);
    private static final ForgeFlowingFluid.Properties TEQUILA_PROP            = createProp(TEQUILA, TEQUILA_FLOWING, FluidInfo.TEQUILA, TEQUILA_BUCKET, TEQUILA_BLOCK);
    private static final ForgeFlowingFluid.Properties VODKA_PROP              = createProp(VODKA, VODKA_FLOWING, FluidInfo.VODKA, VODKA_BUCKET, VODKA_BLOCK);
    private static final ForgeFlowingFluid.Properties WHISKEY_PROP            = createProp(WHISKEY, WHISKEY_FLOWING, FluidInfo.WHISKEY, WHISKEY_BUCKET, WHISKEY_BLOCK);
    private static final ForgeFlowingFluid.Properties WHITE_WINE_PROP         = createProp(WHITE_WINE, WHITE_WINE_FLOWING, FluidInfo.WHITE_WINE, WHITE_WINE_BUCKET, WHITE_WINE_BLOCK);
    private static final ForgeFlowingFluid.Properties YEAST_FLUID_PROP        = createProp(YEAST_LIQUID, YEAST_LIQUID_FLOWING, FluidInfo.YEAST_LIQUID, YEAST_FLUID_BUCKET, YEAST_FLUID_BLOCK);

    // color ARGB
    private static ForgeFlowingFluid.Properties createProp(Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing,
                                                           FluidInfo info, Supplier<? extends Item> bucket, Supplier<? extends LiquidBlock> block) {

        return new ForgeFlowingFluid.Properties(still, flowing,
                FluidAttributes.builder(new ResourceLocation("block/water_still"),new ResourceLocation("block/water_flow"))
                        .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY)
                        .color(info.color).density(info.density).viscosity(info.viscosity).temperature(info.temperature))
                .block(block).bucket(bucket).tickRate(info.tickRate).slopeFindDistance(info.slopeFindDistance)
                .explosionResistance(100F);
    }
}
