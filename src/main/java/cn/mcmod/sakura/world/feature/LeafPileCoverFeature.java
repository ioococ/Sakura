package cn.mcmod.sakura.world.feature;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.block.nature.LeafPileBlock;
import cn.mcmod.sakura.block.nature.MapleLeavesBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionDefaults;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LeafPileCoverFeature extends Feature<NoneFeatureConfiguration> {
    // Use Map to store the mapping of leaf blocks to corresponding fallen leaf blocks
    private static final Map<LeavesBlock, LeafPileBlock> LEAVES_TO_PILE_MAP = new HashMap<>();
    public static final int SEA_HEIGHT = 63;


    static {
        LEAVES_TO_PILE_MAP.put(BlockRegistry.GREEN_MAPLE_LEAVES.get(), BlockRegistry.GREEN_MAPLE_LEAF_PILE.get());
        LEAVES_TO_PILE_MAP.put(BlockRegistry.YELLOW_MAPLE_LEAVES.get(), BlockRegistry.YELLOW_MAPLE_LEAF_PILE.get());
        LEAVES_TO_PILE_MAP.put(BlockRegistry.ORANGE_MAPLE_LEAVES.get(), BlockRegistry.ORANGE_MAPLE_LEAF_PILE.get());
        LEAVES_TO_PILE_MAP.put(BlockRegistry.RED_MAPLE_LEAVES.get(), BlockRegistry.RED_MAPLE_LEAF_PILE.get());
    }

    private final BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
    private final BlockPos.MutableBlockPos belowPos = new BlockPos.MutableBlockPos();
    private final BlockPos.MutableBlockPos spawnPos = new BlockPos.MutableBlockPos();

    public LeafPileCoverFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos origin = context.origin();
        WorldGenLevel level = context.level();
        Random random = context.random();

        // Get chunk boundary
        int minX = origin.getX();
        int minZ = origin.getZ();
        int maxX = minX + 15;
        int maxZ = minZ + 15;

        // Traverse all positions in the block
        for (BlockPos pos : BlockPos.betweenClosed(minX, DimensionDefaults.OVERWORLD_MIN_Y, minZ, maxX, 256, maxZ)) {
            mutablePos.set(pos);

            BlockState state = level.getBlockState(mutablePos);
            if (state.getBlock() instanceof MapleLeavesBlock leavesBlock) {
                trySpawnLeafPile(level, leavesBlock, random, mutablePos);
            }
        }

        return true;
    }

    private void trySpawnLeafPile(WorldGenLevel level, LeavesBlock leavesBlock, Random random, BlockPos pos) {
        LeafPileBlock leafPile = LEAVES_TO_PILE_MAP.get(leavesBlock);
        if (leafPile == null) return;

        for (int y = pos.getY() - 1; y >= SEA_HEIGHT; y--) {
            belowPos.set(pos.getX(), y, pos.getZ()).move(Direction.DOWN);

            // Quick fail check
            if (level.isEmptyBlock(belowPos)) continue;
            if (level.getBlockState(belowPos).getBlock() instanceof LeafPileBlock) continue;

            spawnPos.set(belowPos).move(Direction.UP);
            BlockState spawnState = level.getBlockState(spawnPos);

            if (!spawnState.isAir()) break;

            if (leafPile.defaultBlockState().canSurvive(level, spawnPos)) {
                placeLeafPile(level, leafPile, random, spawnPos);
            }
            break;
        }
    }

    private void placeLeafPile(WorldGenLevel level, LeafPileBlock leafPile, Random random, BlockPos pos) {
        BlockState leafPileState = leafPile.defaultBlockState()
                .setValue(LeafPileBlock.LAYERS, random.nextInt(4) + 1);
        level.setBlock(pos, leafPileState, 2);
    }
}