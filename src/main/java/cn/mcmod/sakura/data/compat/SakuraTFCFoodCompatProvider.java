package cn.mcmod.sakura.data.compat;

import cn.mcmod.sakura.Sakura;
import cn.mcmod.sakura.item.FoodRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod_mmf.mmlib.data.compat.TFCFoodDefinitionProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SakuraTFCFoodCompatProvider extends TFCFoodDefinitionProvider {

    public SakuraTFCFoodCompatProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, existingFileHelper, Sakura.MOD_ID);
    }
    
    @Override
    public void addDatas() {
        FoodRegistry.ITEMS.getEntries().forEach( item -> {
            this.addData(item.get());
        });
        ItemRegistry.ITEMS.getEntries().forEach( item -> {
            this.addData(item.get());
        });
    }
    
    @Override
    public String getName() {
        return "Sakura TFC FoodDefinition Provider";
    }
}
