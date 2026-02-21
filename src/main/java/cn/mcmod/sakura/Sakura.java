package cn.mcmod.sakura;

import cn.mcmod.sakura.block.BlockItemRegistry;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.block.entity.BlockEntityRegistry;
import cn.mcmod.sakura.client.particle.ParticleRegistry;
import cn.mcmod.sakura.container.ContainerRegistry;
import cn.mcmod.sakura.fluid.BucketItemRegistry;
import cn.mcmod.sakura.fluid.FluidBlockRegistry;
import cn.mcmod.sakura.fluid.FluidRegistry;
import cn.mcmod.sakura.item.ComposterRegistry;
import cn.mcmod.sakura.item.FoodRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod.sakura.item.enums.SakuraFoodSet;
import cn.mcmod.sakura.loot_modifier.LootModifiterRegistry;
import cn.mcmod.sakura.recipes.RecipeTypeRegistry;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Sakura.MOD_ID)
public class Sakura {
    public static final String MOD_ID = "sakura";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreativeModeTab GROUP = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(FoodRegistry.FOODSET.get(SakuraFoodSet.ONIGIRI).get());
        }
    };

    public static Item.Properties defaultItemProperties() {
        return new Item.Properties().tab(Sakura.GROUP);
    }

    public Sakura() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        eventBus.addListener(this::setupClient);

        BlockRegistry.BLOCKS.register(eventBus);
        BlockItemRegistry.ITEMS.register(eventBus);
        BlockEntityRegistry.BLOCK_ENTITIES.register(eventBus);

        ItemRegistry.ITEMS.register(eventBus);
        FoodRegistry.ITEMS.register(eventBus);

        FluidRegistry.FLUIDS.register(eventBus);
        FluidBlockRegistry.BLOCKS.register(eventBus);
        BucketItemRegistry.ITEMS.register(eventBus);

        ParticleRegistry.PARTICLE_TYPES.register(eventBus);

        ContainerRegistry.CONTAINER_TYPES.register(eventBus);

        LootModifiterRegistry.GLM.register(eventBus);
        RecipeTypeRegistry.RECIPE_TYPES.register(eventBus);
        RecipeTypeRegistry.RECIPE_SERIALIZERS.register(eventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ComposterRegistry::registerCompost);
    }

    private void setupClient(final FMLClientSetupEvent event) {
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
