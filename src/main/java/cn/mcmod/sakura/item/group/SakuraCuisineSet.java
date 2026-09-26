package cn.mcmod.sakura.item.group;

import cn.mcmod.sakura.block.BlockItemRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod.sakura.utils.ResourceLocationUtil;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public enum SakuraCuisineSet {
    BEEF_STICK(FoodInfo.builder().name("beef_stick").amountAndCalories(8, 0.8F).water(2F).nutrients(0F, 0F, 0F, 4F, 0F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(), BlockItemRegistry.BAMBOO_PLANT),
    CHICKEN_STICK(FoodInfo.builder().name("chicken_stick").amountAndCalories(6, 0.4F).water(2F).nutrients(0F, 0F, 0F, 4F, 0F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(), BlockItemRegistry.BAMBOO_PLANT),
    PORK_STICK(FoodInfo.builder().name("pork_stick").amountAndCalories(6, 0.6F).water(2F).nutrients(0F, 0F, 0F, 4F, 0F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(), BlockItemRegistry.BAMBOO_PLANT),

    STANDARD_BENTO(FoodInfo.builder().name("bento").amountAndCalories(10, 1.0F).water(0.5F).nutrients(3.0F, 0.0F, 3.0F, 3.0F, 3.0F).decayModifier(3.0F).heatCapacity(0.0F).cookingTemp(-1.0F).build(), ItemRegistry.MATERIALS.get(SakuraNormalSet.BENTO_BOX)),
    DELUXE_BENTO(FoodInfo.builder().name("deluxe_bento").amountAndCalories(12, 1.0F).water(0.5F).nutrients(3.0F, 0.0F, 3.0F, 3.0F, 3.0F).decayModifier(3.0F).heatCapacity(0.0F).cookingTemp(-1.0F).build(), ItemRegistry.MATERIALS.get(SakuraNormalSet.BENTO_BOX)),
    PREMIUM_BENTO(FoodInfo.builder().name("premium_bento").amountAndCalories(14, 1.0F).water(0.5F).nutrients(3.0F, 0.0F, 3.0F, 3.0F, 3.0F).decayModifier(3.0F).heatCapacity(0.0F).cookingTemp(-1.0F).build(), ItemRegistry.MATERIALS.get(SakuraNormalSet.BENTO_BOX)),
    SUPREME_BENTO(FoodInfo.builder().name("supreme_bento").amountAndCalories(16, 1.0F).water(0.5F).nutrients(3.0F, 0.0F, 3.0F, 3.0F, 3.0F).decayModifier(3.0F).heatCapacity(0.0F).cookingTemp(-1.0F).build(), ItemRegistry.MATERIALS.get(SakuraNormalSet.BENTO_BOX)),
    ;
    private final FoodInfo info;
    private final Supplier<Item> container;

    SakuraCuisineSet(FoodInfo info, Supplier<Item> container) {
        this.info = info;
        this.container = container;
    }

    public FoodInfo getFoodInfo() {
        return info;
    }

    public Supplier<Item> getContainer() {
        return container;
    }

    public static Item getItem(SakuraCuisineSet set) {
        String name = set.getFoodInfo().getName();
        ResourceLocation rl = ResourceLocationUtil.item(name);
        return Registry.ITEM.get(rl);
    }
}
