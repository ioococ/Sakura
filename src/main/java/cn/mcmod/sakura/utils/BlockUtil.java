package cn.mcmod.sakura.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class BlockUtil {

    /**
     * Checks if the current block is a "free" block.
     * One that can be overwritten in place of a pile of leaves
     * Currently checks if the given block is an air block, liquid or is marked replaceable
     *
     * @param state State of the block being checked
     * @return Whether the block is "free" for replacement by a leaf pile or not
     */
    public static boolean isFree(BlockState state, Level world, BlockPos position) {
        Material material = state.getMaterial();
        return state.isAir() || material.isLiquid() || material.isReplaceable();
    }
}