package cn.mcmod.sakura.block.nature;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.client.particle.ParticleRegistry;
import cn.mcmod.sakura.utils.BlockPosUtils;
import cn.mcmod.sakura.utils.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.dimension.DimensionDefaults;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.RegistryObject;

import java.util.Random;
import java.util.function.Supplier;

public class MapleLeavesBlock extends LeavesBlock implements SimpleWaterloggedBlock {
    private final Supplier<SimpleParticleType> leafParticle;
    private final RegistryObject<LeafPileBlock> carpet;
    private final LeavesTypeEnum leavesType;

    public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE;
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public MapleLeavesBlock(Properties builder, LeavesTypeEnum typeEnum) {
        super(builder.randomTicks());
        this.leavesType = typeEnum;

        switch (typeEnum) {
            case GREEN -> {
                leafParticle = ParticleRegistry.GREEN_MAPLE_LEAF;
                carpet = BlockRegistry.GREEN_MAPLE_LEAF_PILE;
            }
            case YELLOW -> {
                leafParticle = ParticleRegistry.YELLOW_MAPLE_LEAF;
                carpet = BlockRegistry.YELLOW_MAPLE_LEAF_PILE;
            }
            case ORANGE -> {
                leafParticle = ParticleRegistry.ORANGE_MAPLE_LEAF;
                carpet = BlockRegistry.ORANGE_MAPLE_LEAF_PILE;
            }
            case RED -> {
                leafParticle = ParticleRegistry.RED_MAPLE_LEAF;
                carpet = BlockRegistry.RED_MAPLE_LEAF_PILE;
            }
            default -> {
                leafParticle = null;
                carpet = null;
            }
        }

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(DISTANCE, 7)
                .setValue(PERSISTENT, Boolean.FALSE)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, PERSISTENT, WATERLOGGED);
    }

    /**
     * Tick function that runs 20 times a second to update all tile entities.
     * This entity is attached to an instance of a leaves block and traces downwards to see if piles of
     * petals should spawn.
     */
    public void spawnLeafPile(Level level, BlockPos position, BlockState state) {

        Random random = level.getRandom();
        position = BlockPosUtils.randomOffset(position, 2);
//        int randomTick = level.getGameRules().getRule(GameRules.RULE_RANDOMTICKING).get();

        if (random.nextInt(20) != 0) return;

        BlockPos belowPosition = position.below();
        Block carpetBlock = this.carpet.get();

        while (belowPosition.getY() >= DimensionDefaults.OVERWORLD_MIN_Y) {
            BlockState belowState = level.getBlockState(belowPosition);
            if (!level.isEmptyBlock(belowPosition)) {

                BlockPos spawningPosition = belowPosition.above();
                if (belowState.getBlock() == carpetBlock) {
//                    LeafPileBlock leafPile = (LeafPileBlock) belowState.getBlock();
//                    leafPile.updateLayerState(belowPosition, level);
                } else if (BlockUtil.isFree(level.getBlockState(spawningPosition), level, spawningPosition)) {
                    if (carpetBlock.defaultBlockState().canSurvive(level, spawningPosition)) {
                        level.setBlockAndUpdate(spawningPosition, carpetBlock.defaultBlockState());
                    }
                }
                break;
            }
            belowPosition = belowPosition.below();
        }

    }


    private void spawnBurrChestnut(Level level, BlockPos position, BlockState state) {

        Random random = level.getRandom();

        if (random.nextInt(10) != 0) return;

        BlockPos belowPosition = position.below();
        if (!level.isEmptyBlock(belowPosition)) return;
        if (this.leavesType == LeavesTypeEnum.GREEN || this.leavesType == LeavesTypeEnum.RED) return;

        Block burrChestnut = BlockRegistry.BURR_CHESTNUT.get();
        level.setBlockAndUpdate(belowPosition, burrChestnut.defaultBlockState());

    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        if (rand.nextInt(40) == 0) {
            int j = rand.nextInt(2) * 2 - 1;
            int k = rand.nextInt(2) * 2 - 1;

            double d0 = pos.getX() + 0.5D + 0.25D * j;
            double d1 = pos.getY() - 0.15D;
            double d2 = pos.getZ() + 0.5D + 0.25D * k;
            double d3 = rand.nextFloat() * j * 0.1D;
            double d4 = (rand.nextFloat() * 0.055D) + 0.015D;
            double d5 = rand.nextFloat() * k * 0.1D;
            worldIn.addParticle(this.leafParticle.get(), d0, d1, d2, d3, -d4, d5);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(PERSISTENT);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (!isValidTick(level)) return;

        super.randomTick(state, level, pos, random);

//        spawnLeafPile(level, pos, state);

        spawnBurrChestnut(level, pos, state);
//        if (random.nextInt(100) > 10) return;
//        CarpetTreeDecorator.placeCarpet(level, pos, this.carpet.defaultBlockState(), level::setBlockAndUpdate);

    }

    @Override
    public void fallOn(Level worldIn, BlockState stateIn, BlockPos pos, Entity entityIn, float fallDistance) {
        super.fallOn(worldIn, stateIn, pos, entityIn, fallDistance);
        if (!worldIn.isClientSide && fallDistance >= 1 && (entityIn instanceof LivingEntity || entityIn instanceof FallingBlockEntity)) {
            float deathRate = 1;

//            for (BlockPos pos2 : BlockPos.betweenClosed(pos.getX() - 1, pos.getY() - 2, pos.getZ() - 1, pos.getX() + 1, pos.getY(), pos.getZ() + 1)) {

//                CarpetTreeDecorator.placeCarpet(worldIn, pos2, this.carpet.defaultBlockState(), worldIn::setBlockAndUpdate);
//            }
        }
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 30;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 60;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return super.getStateForPlacement(context).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    /**
     * Check if the tick is valid.
     * A valid tick in this entity's case is one that is running against a legitimate world on the server-side
     *
     * @return Whether the current tick is valid
     */
    private static boolean isValidTick(Level world) {
        if (world == null) return false;

        return !world.isClientSide;
    }

    public enum LeavesTypeEnum {
        GREEN, YELLOW, ORANGE, RED
    }
}