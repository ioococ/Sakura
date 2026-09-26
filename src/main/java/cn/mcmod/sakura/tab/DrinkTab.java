package cn.mcmod.sakura.tab;

import cn.mcmod.sakura.item.DrinkRegistry;
import cn.mcmod.sakura.item.group.SakuraDrinkSet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DrinkTab extends CreativeModeTab {
    public DrinkTab(String label) {
        super(label + "_drink");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(DrinkRegistry.DRINKSET.get(SakuraDrinkSet.BEER_BOTTLE).get());
    }
}