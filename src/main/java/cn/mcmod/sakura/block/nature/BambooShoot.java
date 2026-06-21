package cn.mcmod.sakura.block.nature;

import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class BambooShoot extends BushBlock implements BonemealableBlock, SimpleWaterloggedBlock {

    private static final VoxelShape SHAPE = Block.box(6D, 0.0D, 6D, 10D, 4.0D, 10D);

    /* Property */
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 1);
    public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

    public BambooShoot() {
        super(Properties.copy(Blocks.BAMBOO_SAPLING));
        /** Default state **/
        registerDefaultState(this.defaultBlockState().setValue(STAGE, 0)
                .setValue(WATERLOGGED, false));
    }

    /* Collisions for each property. + .dynamicShape() */
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter levelIn, BlockPos pos, CollisionContext context) {
        Vec3 vector3d = state.getOffset(levelIn, pos);
        return SHAPE.move(vector3d.x, vector3d.y, vector3d.z);
    }

    /* TickRandom */
    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        int i = state.getValue(STAGE);
        if (rand.nextInt(3) == 0 && worldIn.isEmptyBlock(pos.above()) && worldIn.getRawBrightness(pos.above(), LightLayer.BLOCK.surrounding) >= 9) {
            if (i != 1) { worldIn.setBlock(pos, state.setValue(STAGE, i + 1), 3); }
            if (i == 1) { this.placeBamboo(worldIn, pos, state); }
        }
    }

    protected void placeBamboo(ServerLevel worldIn, BlockPos pos, BlockState state) {
        worldIn.setBlock(pos, BlockRegistry.BAMBOO_PLANT.get().defaultBlockState()
                .setValue(BambooPlant.WATERLOGGED, worldIn.getFluidState(pos).getType() == Fluids.WATER)
                .setValue(BambooPlant.STAGE, 12), 3);
        worldIn.setBlock(pos.above(), BlockRegistry.BAMBOO_PLANT.get().defaultBlockState()
                .setValue(BambooPlant.WATERLOGGED, worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)
                .setValue(BambooPlant.STAGE, 1), 3);
    }

    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

        return !(state.canSurvive(worldIn, pos)) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
    }

    /* Update BlockState. */
    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockState dawnState = worldIn.getBlockState(pos.below());
        return dawnState.getBlock() instanceof SpreadingSnowyDirtBlock || dawnState.is(BlockTags.DIRT);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter p_50897_, BlockPos p_50898_, BlockState p_50899_, boolean p_50900_) {
        return true;
    }

    /* Create Blockstate */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE, WATERLOGGED);
    }

    @Override
    public boolean isBonemealSuccess(Level level, Random rand, BlockPos pos, BlockState state) {
        boolean b = rand.nextInt(2) == 0;
        return level.isRaining() ? !b : b;
    }

    @Override
    public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
        if (rand.nextInt(2) == 0) return;
        growBamboo(worldIn, pos);
    }

    private void growBamboo(ServerLevel worldIn, BlockPos pos) {
        if (!worldIn.isEmptyBlock(pos.above())) {
            return;
        }
        if (worldIn.isEmptyBlock(pos.above(2))) {
            worldIn.setBlockAndUpdate(pos.above(2), BlockRegistry.BAMBOO_PLANT.get().defaultBlockState()
                    .setValue(BambooPlant.STAGE, 1)
                    .setValue(BambooPlant.LEAVES, BambooLeaves.LARGE));
        }
        worldIn.setBlockAndUpdate(pos.above(),
                BlockRegistry.BAMBOO_PLANT.get().defaultBlockState()
                        .setValue(BambooPlant.STAGE, 1)
                        .setValue(BambooPlant.LEAVES, BambooLeaves.SMALL));
        worldIn.setBlockAndUpdate(pos, BlockRegistry.BAMBOO_PLANT.get().defaultBlockState()
                .setValue(BambooPlant.STAGE, 1));
    }



    /* Waterlogged */
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter worldIn, BlockPos pos, BlockState state, Fluid fluid) {
        return !state.getValue(BlockStateProperties.WATERLOGGED) && fluid == Fluids.WATER;
    }

    @Override
    public boolean placeLiquid(LevelAccessor worldIn, BlockPos pos, BlockState state, FluidState fluid) {
        if (!state.getValue(BlockStateProperties.WATERLOGGED) && fluid.getType() == Fluids.WATER) {
            if (!worldIn.isClientSide()) {
                worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true)), 3);
                worldIn.scheduleTick(pos, fluid.getType(), fluid.getType().getTickDelay(worldIn));
            }
            return true;
        }

        else return false;
    }
}