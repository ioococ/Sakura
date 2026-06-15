package cn.mcmod.sakura.tab;

import cn.mcmod.sakura.item.FoodRegistry;
import cn.mcmod.sakura.item.enums.SakuraFoodSet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FoodTab extends CreativeModeTab {
    public FoodTab(String label) {
        super(label + "_food");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(FoodRegistry.FOODSET.get(SakuraFoodSet.ONIGIRI).get());
    }
}