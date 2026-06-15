package cn.mcmod.sakura.tab;

import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class MainTab extends CreativeModeTab {
    public MainTab(String label) {
        super(label + "_main");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(BlockRegistry.BAMBOO_BLOCK.get());
    }
}