package cn.mcmod.sakura;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.block.entity.BlockEntityRegistry;
import cn.mcmod.sakura.client.particle.FallenLeafParticle;
import cn.mcmod.sakura.client.particle.ParticleRegistry;
import cn.mcmod.sakura.client.render.ChoppingBoardRender;
import cn.mcmod.sakura.client.render.ObonRender;
import cn.mcmod.sakura.client.render.StoneMortarRenderer;
import cn.mcmod.sakura.fluid.FluidRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.BushBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Sakura.MOD_ID, value = Dist.CLIENT)
public class SakuraClient {

    @SubscribeEvent
    public static void clientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SAKURA_SAPLING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RICE_CROP_ROOT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BAMBOO_PLANT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BAMBOO_SHOOT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SUNBURNT_BAMBOO_PLANT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.CHARCOAL_BAMBOO_PLANT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.COOKING_POT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BURR_CHESTNUT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GREEN_MAPLE_LEAF_PILE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.YELLOW_MAPLE_LEAF_PILE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.ORANGE_MAPLE_LEAF_PILE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_MAPLE_LEAF_PILE.get(), RenderType.cutoutMipped());

            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.ODEN_NABE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SUKIYAKI_NABE.get(), RenderType.cutoutMipped());

            BlockRegistry.BLOCKS.getEntries().forEach(block -> {
                if (block.get() instanceof BushBlock) ItemBlockRenderTypes.setRenderLayer(block.get(), RenderType.cutoutMipped());
            });
            FluidRegistry.FLUIDS.getEntries().forEach(fluid -> {
                ItemBlockRenderTypes.setRenderLayer(fluid.get(), RenderType.translucent());
            });

            BlockEntityRenderers.register(BlockEntityRegistry.STONE_MORTAR.get(), StoneMortarRenderer::new);
            BlockEntityRenderers.register(BlockEntityRegistry.CHOPPING_BOARD.get(), ChoppingBoardRender::new);
            BlockEntityRenderers.register(BlockEntityRegistry.OBON.get(), ObonRender::new);
        });
    }

    @SuppressWarnings("resource")
    @SubscribeEvent
    public static void onParticleFactoryRegistration(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SAKURA_LEAF.get(),
                FallenLeafParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.RED_MAPLE_LEAF.get(),
                FallenLeafParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.YELLOW_MAPLE_LEAF.get(),
                FallenLeafParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.GREEN_MAPLE_LEAF.get(),
                FallenLeafParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.ORANGE_MAPLE_LEAF.get(),
                FallenLeafParticle.Factory::new);
    }

}
