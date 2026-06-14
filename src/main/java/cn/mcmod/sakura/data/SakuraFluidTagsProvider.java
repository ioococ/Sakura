package cn.mcmod.sakura.data;

import cn.mcmod.sakura.fluid.FluidRegistry;
import cn.mcmod.sakura.tags.SakuraFluidTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SakuraFluidTagsProvider extends FluidTagsProvider {

    public SakuraFluidTagsProvider(DataGenerator datagen, String modId, ExistingFileHelper existingFileHelper) {
        super(datagen, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(FluidTags.WATER).add(FluidRegistry.BEER.get(), FluidRegistry.BEER_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.BRANDY.get(), FluidRegistry.BRANDY_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.CHAMPAGNE.get(), FluidRegistry.CHAMPAGNE_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.COCOA_LIQUEUR.get(), FluidRegistry.COCOA_LIQUEUR_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.DOBUROKU.get(), FluidRegistry.DOBUROKU_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.FOOD_OIL.get(), FluidRegistry.FOOD_OIL_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.GIN.get(), FluidRegistry.GIN_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.GREEN_GRAPE_JUICE.get(), FluidRegistry.GREEN_GRAPE_JUICE_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.HOT_SPRING.get(), FluidRegistry.HOT_SPRING_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.LIQUEUR.get(), FluidRegistry.LIQUEUR_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.MAPLE_SAP.get(), FluidRegistry.MAPLE_SAP_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.MAPLE_SYRUP.get(), FluidRegistry.MAPLE_SYRUP_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.PURPLE_GRAPE_JUICE.get(), FluidRegistry.PURPLE_GRAPE_JUICE_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.RED_WINE.get(), FluidRegistry.RED_WINE_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.RUM.get(), FluidRegistry.RUM_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.SAKE.get(), FluidRegistry.SAKE_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.SHOUCHU.get(), FluidRegistry.SHOUCHU_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.TEQUILA.get(), FluidRegistry.TEQUILA_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.VODKA.get(), FluidRegistry.VODKA_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.WHISKEY.get(), FluidRegistry.WHISKEY_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.WHITE_WINE.get(), FluidRegistry.WHITE_WINE_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.YEAST_LIQUID.get(), FluidRegistry.YEAST_LIQUID_FLOWING.get());


        tag(SakuraFluidTags.WATER_WATER).add(Fluids.WATER, Fluids.FLOWING_WATER).addOptional(new ResourceLocation("tfc:river_water"));
        tag(SakuraFluidTags.BREWERS_ALCOHOL)
                .add(FluidRegistry.RUM.get(),FluidRegistry.RUM_FLOWING.get())
                .addTag(SakuraFluidTags.BEER)
                .addTag(SakuraFluidTags.BRANDY)
                .addTag(SakuraFluidTags.CHAMPAGNE)
                .addTag(SakuraFluidTags.COCOA_LIQUEUR)
                .addTag(SakuraFluidTags.DOBUROKU)
                .addTag(SakuraFluidTags.GIN)
                .addTag(SakuraFluidTags.LIQUEUR)
                .addTag(SakuraFluidTags.SAKE)
                .addTag(SakuraFluidTags.RED_WINE)
                .addTag(SakuraFluidTags.RUM)
                .addTag(SakuraFluidTags.SHOUCHU)
                .addTag(SakuraFluidTags.WHISKEY)
                .addTag(SakuraFluidTags.WHITE_WINE)
                .addTag(SakuraFluidTags.TEQUILA)
                .addTag(SakuraFluidTags.VODKA);
        tag(SakuraFluidTags.BEER).add(FluidRegistry.BEER.get()).add(FluidRegistry.BEER_FLOWING.get());
        tag(SakuraFluidTags.BRANDY).add(FluidRegistry.BRANDY.get()).add(FluidRegistry.BRANDY_FLOWING.get());
        tag(SakuraFluidTags.CHAMPAGNE).add(FluidRegistry.CHAMPAGNE.get()).add(FluidRegistry.CHAMPAGNE_FLOWING.get());
        tag(SakuraFluidTags.COCOA_LIQUEUR).add(FluidRegistry.COCOA_LIQUEUR.get()).add(FluidRegistry.COCOA_LIQUEUR_FLOWING.get());
        tag(SakuraFluidTags.DOBUROKU).add(FluidRegistry.DOBUROKU.get()).add(FluidRegistry.DOBUROKU_FLOWING.get());
        tag(SakuraFluidTags.FOOD_OIL).add(FluidRegistry.FOOD_OIL.get()).add(FluidRegistry.FOOD_OIL_FLOWING.get());
        tag(SakuraFluidTags.GIN).add(FluidRegistry.GIN.get()).add(FluidRegistry.GIN_FLOWING.get());
        tag(SakuraFluidTags.GREEN_GRAPE_JUICE).add(FluidRegistry.GREEN_GRAPE_JUICE.get(), FluidRegistry.GREEN_GRAPE_JUICE_FLOWING.get());
        tag(SakuraFluidTags.HOT_SPRING).add(FluidRegistry.HOT_SPRING.get(), FluidRegistry.HOT_SPRING_FLOWING.get());
        tag(SakuraFluidTags.LIQUEUR).add(FluidRegistry.LIQUEUR.get(), FluidRegistry.LIQUEUR_FLOWING.get());
        tag(SakuraFluidTags.MAPLE_SAP).add(FluidRegistry.MAPLE_SAP.get(), FluidRegistry.MAPLE_SAP_FLOWING.get());
        tag(SakuraFluidTags.MAPLE_SYRUP).add(FluidRegistry.MAPLE_SYRUP.get(), FluidRegistry.MAPLE_SYRUP_FLOWING.get());
        tag(SakuraFluidTags.YEAST_LIQUID).add(FluidRegistry.YEAST_LIQUID.get(), FluidRegistry.YEAST_LIQUID_FLOWING.get());
        tag(SakuraFluidTags.PURPLE_GRAPE_JUICE).add(FluidRegistry.PURPLE_GRAPE_JUICE.get(), FluidRegistry.PURPLE_GRAPE_JUICE_FLOWING.get());
        tag(SakuraFluidTags.RED_WINE).add(FluidRegistry.RED_WINE.get()).add(FluidRegistry.RED_WINE_FLOWING.get());
        tag(SakuraFluidTags.RUM).add(FluidRegistry.RUM.get()).add(FluidRegistry.RUM_FLOWING.get());
        tag(SakuraFluidTags.SAKE).add(FluidRegistry.SAKE.get()).add(FluidRegistry.SAKE_FLOWING.get());
        tag(SakuraFluidTags.SHOUCHU).add(FluidRegistry.SHOUCHU.get()).add(FluidRegistry.SHOUCHU_FLOWING.get());
        tag(SakuraFluidTags.TEQUILA).add(FluidRegistry.TEQUILA.get()).add(FluidRegistry.TEQUILA_FLOWING.get());
        tag(SakuraFluidTags.VODKA).add(FluidRegistry.VODKA.get()).add(FluidRegistry.VODKA_FLOWING.get());
        tag(SakuraFluidTags.WHISKEY).add(FluidRegistry.WHISKEY.get()).add(FluidRegistry.WHISKEY_FLOWING.get());
        tag(SakuraFluidTags.WHITE_WINE).add(FluidRegistry.WHITE_WINE.get()).add(FluidRegistry.WHITE_WINE_FLOWING.get());

        tag(SakuraFluidTags.FOOD_OIL).addTag(SakuraFluidTags.PLANT_OIL);
        tag(SakuraFluidTags.PLANT_OIL).add(FluidRegistry.FOOD_OIL.get(), FluidRegistry.FOOD_OIL_FLOWING.get()).addOptional(new ResourceLocation("tfc:flowing_olive_oil")).addOptional(new ResourceLocation("tfc:olive_oil"));
    }
}
