package cn.mcmod.sakura.block.group;

import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Map;

/**
 * @author uiYzzi
 * @version 1.0
 * @date 05/01/2025 00:54
 */
public enum ArtificialGroup {
    SAKURA("sakura_plank", BlockRegistry.SAKURA_PLANK),
    UME("ume_plank", BlockRegistry.UME_PLANK),
    BAMBOO("bamboo_plank", BlockRegistry.BAMBOO_PLANK),
    MAPLE("maple_plank", BlockRegistry.MAPLE_PLANK),;

    private final String id;
    private final RegistryObject<Block> plank;
    private Map<Type, RegistryObject<? extends Block>> blockMap;
    private Map<Type, RegistryObject<? extends Item>> itemMap;

    ArtificialGroup(String id, RegistryObject<Block> plank) {
        this.id = id;
        this.plank = plank;
    }

    public String id() {
        return id;
    }

    public RegistryObject<Block> plank() {
        return plank;
    }

    public Map<Type, RegistryObject<? extends Block>> blockMap() {
        return this.blockMap;
    }

    public void blockMap(Map<Type, RegistryObject<? extends Block>> blockMap) {
        this.blockMap = blockMap;
    }

    public Map<Type, RegistryObject<? extends Item>> itemMap() {
        return itemMap;
    }

    public void itemMap(Map<Type, RegistryObject<? extends Item>> itemMap) {
        this.itemMap = itemMap;
    }

    public static List<ArtificialGroup> list() {
        return List.of(values());
    }

    public enum Type {
        SLAB, STAIR
    }
}