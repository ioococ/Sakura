package cn.mcmod.sakura.item;

import cn.mcmod.sakura.Sakura;
import cn.mcmod.sakura.item.group.SakuraDrinkSet;
import cn.mcmod.sakura.utils.ResourceLocationUtil;
import cn.mcmod_mmf.mmlib.item.ItemDrinkBase;
import cn.mcmod_mmf.mmlib.item.ItemDrinkType;
import cn.mcmod_mmf.mmlib.item.info.DrinkInfo;
import cn.mcmod_mmf.mmlib.utils.ItemRegistryUtil;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.function.Supplier;

public class DrinkRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Sakura.MOD_ID);

    public static final Map<SakuraDrinkSet, RegistryObject<ItemDrinkBase>> DRINKSET =
            ItemRegistryUtil.mapOfKeys(
                    SakuraDrinkSet.class,
                    info -> DrinkRegistry.register(
                            info.getDrinkInfo().getName(),
                            info.getDrinkInfo().getType(),
                            () -> normalDrink(info.getDrinkInfo())));

    private static ItemDrinkBase normalDrink(DrinkInfo info) {
        return new ItemDrinkBase(Sakura.drinkTabProperties(), info);
    }

    private static ItemDrinkBase normalDrink(DrinkInfo info, Item container) {
        if (container == null) return normalDrink(info);
        return new ItemDrinkBase(Sakura.drinkTabProperties().craftRemainder(container), info);
    }

    private static <V extends Item> RegistryObject<V> register(String name, Supplier<V> item) {
        return ITEMS.register(name, item);
    }

    private static <V extends Item> RegistryObject<V> register(String name, ItemDrinkType type, Supplier<V> item) {
        if (SakuraDrinkSet.isContainer(name)) return register(name, item);
        switch (type) {
            case CUP -> name = ResourceLocationUtil.cup(name).getPath();
            case BOTTLE -> name = ResourceLocationUtil.bottle(name).getPath();
            case TEA -> name = ResourceLocationUtil.tea(name).getPath();
            case JUICE -> name = ResourceLocationUtil.juice(name).getPath();
        }
        return register(name, item);
    }
}