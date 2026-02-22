package cn.mcmod.sakura.data;

import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SakuraBlockTagsProvider extends BlockTagsProvider {

    public SakuraBlockTagsProvider(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.LOGS).add(BlockRegistry.STRIPPED_SAKURA_WOOD.get(), BlockRegistry.STRIPPED_MAPLE_WOOD.get(),
                BlockRegistry.SAKURA_WOOD.get(), BlockRegistry.MAPLE_WOOD.get(),
                BlockRegistry.STRIPPED_SAKURA_LOG.get(), BlockRegistry.STRIPPED_MAPLE_LOG.get(),
                BlockRegistry.SAKURA_LOG.get(), BlockRegistry.MAPLE_LOG.get(), BlockRegistry.MAPLE_SAP_LOG.get());
        this.tag(BlockTags.LOGS_THAT_BURN).add(BlockRegistry.STRIPPED_SAKURA_WOOD.get(),
                BlockRegistry.STRIPPED_MAPLE_WOOD.get(), BlockRegistry.SAKURA_WOOD.get(),
                BlockRegistry.MAPLE_WOOD.get(), BlockRegistry.STRIPPED_SAKURA_LOG.get(),
                BlockRegistry.STRIPPED_MAPLE_LOG.get(), BlockRegistry.SAKURA_LOG.get(), BlockRegistry.MAPLE_LOG.get(),
                BlockRegistry.MAPLE_SAP_LOG.get());
        
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockRegistry.STONE_MORTAR.get());

        this.tag(BlockTags.LEAVES).add(BlockRegistry.SAKURA_LEAVES.get(), BlockRegistry.GREEN_MAPLE_LEAVES.get(),
                BlockRegistry.YELLOW_MAPLE_LEAVES.get(), BlockRegistry.ORANGE_MAPLE_LEAVES.get(),
                BlockRegistry.RED_MAPLE_LEAVES.get());

        this.tag(BlockTags.SAPLINGS).add(BlockRegistry.SAKURA_SAPLING.get(), BlockRegistry.RED_MAPLE_SAPLING.get(),
                BlockRegistry.GREEN_MAPLE_SAPLING.get(), BlockRegistry.ORANGE_MAPLE_SAPLING.get(),
                BlockRegistry.YELLOW_MAPLE_SAPLING.get());

        this.tag(BlockTags.CROPS).add(BlockRegistry.RICE_CROP.get(), BlockRegistry.BUCKWHEAT_CROP.get(),
                BlockRegistry.CABBAGE_CROP.get(), BlockRegistry.EGGPLANT_CROP.get(), BlockRegistry.ONION_CROP.get(),
                BlockRegistry.RADISH_CROP.get(), BlockRegistry.RAPE_SEEDS_CROP.get(), BlockRegistry.RED_BEAN_CROP.get(),
                BlockRegistry.RICE_CROP_ROOT.get(), BlockRegistry.TARO_CROP.get(), BlockRegistry.TOMATO_CROP.get());

        this.tag(BlockTags.PLANKS).add(BlockRegistry.SAKURA_PLANK.get(), BlockRegistry.BAMBOO_PLANK.get(),
                BlockRegistry.MAPLE_PLANK.get());
    }

    @Override
    public String getName() {
        return "Sakura Blocks' Tags";
    }
}
