package cn.mcmod.sakura.block.nature;

import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolActions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class BambooPlant extends Block implements BonemealableBlock, SimpleWaterloggedBlock {

    /* Property */
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 16);
    public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
    /* Collision */
    protected static final VoxelShape AABB_BOX = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 7.0D, 11.0D);
    protected static final VoxelShape SMALL_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    protected static final VoxelShape LARGE_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);

    private static final VoxelShape SHAPE = Block.box(6D, 0.0D, 6D, 10D, 16.0D, 10D);
    public static final EnumProperty<BambooLeaves> LEAVES = BlockStateProperties.BAMBOO_LEAVES;
    public static final int MAX_HEIGHT = 16;
    public static final int STAGE_GROWING = 1;
    public static final int STAGE_DONE_GROWING = 2;
    public static final int AGE_THIN_BAMBOO = 0;
    public static final int AGE_THICK_BAMBOO = 1;

    public BambooPlant() {
        super(Properties.copy(Blocks.BAMBOO));
        this.registerDefaultState(this.stateDefinition.any().setValue(LEAVES, BambooLeaves.NONE));
        /** Default state **/
        registerDefaultState(this.defaultBlockState().setValue(STAGE, 0)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48928_) {
        p_48928_.add(LEAVES, STAGE, WATERLOGGED);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState p_48941_, BlockGetter p_48942_, BlockPos p_48943_) {
        return true;
    }

    /* Collisions for each property. + .dynamicShape() */
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        Vec3 vector3d = state.getOffset(worldIn, pos);
        return SHAPE.move(vector3d.x, vector3d.y, vector3d.z);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Override
    public boolean isCollisionShapeFullBlock(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }

    @Override
    public void tick(BlockState state, ServerLevel levelIn, BlockPos pos, Random random) {
        if (!state.canSurvive(levelIn, pos)) levelIn.destroyBlock(pos, true);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

        if (!state.canSurvive(worldIn, pos)) { worldIn.scheduleTick(pos, this, 1); }

        return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
    }

    /* Update BlockState. */
    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        int i = state.getValue(STAGE);
        // Manually placed, must be placed on a full block
        if (i == 0) return !worldIn.isEmptyBlock(pos.below());

        BlockState downState = worldIn.getBlockState(pos.below());
        Block upBlock = worldIn.getBlockState(pos.above()).getBlock();
        boolean downValid = isDirt(downState) || downState.getBlock() instanceof BambooPlant;


        // Tall bamboo (stage > 11): needs dirt or bamboo below AND bamboo above
        if (i >= 11) {
            return (isDirt(downState) || downValid) && upBlock instanceof BambooPlant;
        }

        // Short bamboo: just needs dirt or bamboo below
        return downValid;
    }

    private boolean isDirt(BlockState blockState) {
        return blockState.getBlock() instanceof SpreadingSnowyDirtBlock || blockState.getMaterial() == Material.DIRT;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        int i = state.getValue(STAGE);
        int jump7  = rand.nextInt(2) == 0 ? 7 : i + 1;
        int jump11 = rand.nextInt(2) == 0 ? 11 : i + 1;
        BlockState downState = worldIn.getBlockState(pos.below());
        state.setValue(LEAVES, BambooLeaves.NONE);
        if (!state.canSurvive(worldIn, pos)) return;

        switch (i) {
            case 0:
                if (this == BlockRegistry.BAMBOO_PLANT.get() && rand.nextInt(100) == 0) worldIn.setBlock(pos, BlockRegistry.SUNBURNT_BAMBOO_PLANT.get().defaultBlockState().setValue(STAGE, 0).setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);

                break; // Manual placement, no growth
            case 1:
                if (!checkLightAndRand(worldIn, pos, rand)) break;
                worldIn.setBlock(pos, state.setValue(STAGE, 13).setValue(LEAVES, BambooLeaves.SMALL), 3);
                worldIn.setBlock(pos.above(1), state.setValue(STAGE, i + 1).setValue(LEAVES, BambooLeaves.LARGE), 3);
                break;

            case 2:
                if (!checkLightAndRand(worldIn, pos, rand)) break;
                worldIn.setBlock(pos.below(1), state.setValue(STAGE, 12), 3);
                worldIn.setBlock(pos, state.setValue(STAGE, 13), 3);
                worldIn.setBlock(pos.above(1), state.setValue(STAGE, i + 1), 3);
                break;

            case 3:
                if (!checkLightAndRand(worldIn, pos, rand)) break;
                worldIn.setBlock(pos.below(3), state.setValue(STAGE, 14), 3);
                worldIn.setBlock(pos.below(2), state.setValue(STAGE, 14), 3);
                worldIn.setBlock(pos.below(1), state.setValue(STAGE, 15), 3);
                worldIn.setBlock(pos, state.setValue(STAGE, 15), 3);
                worldIn.setBlock(pos.above(1), state.setValue(STAGE, i + 1), 3);
                break;

            case 4:
                if (!checkLightAndRand(worldIn, pos, rand)) break;
                worldIn.setBlock(pos.below(2), state.setValue(STAGE, 14), 3);
                worldIn.setBlock(pos, state.setValue(STAGE, 15), 3);
                worldIn.setBlock(pos.above(1), state.setValue(STAGE, i + 1), 3);
                break;

            case 5:
                if (!checkLightAndRand(worldIn, pos, rand)) break;
                if (isJungle(worldIn, pos)) {
                    worldIn.setBlock(pos.below(2), state.setValue(STAGE, 14), 3);
                    worldIn.setBlock(pos, state.setValue(STAGE, 16), 3);
                    worldIn.setBlock(pos.above(1), state.setValue(STAGE, i + 1), 3);
                } else {
                    worldIn.setBlock(pos.below(2), state.setValue(STAGE, 14), 3);
                    worldIn.setBlock(pos, state.setValue(STAGE, 16), 3);
                    worldIn.setBlock(pos.above(1), state.setValue(STAGE, jump7), 3);
                }
                break;

            case 6:
                if (!checkLightAndRand(worldIn, pos, rand)) break;
                worldIn.setBlock(pos.below(2), state.setValue(STAGE, 14), 3);
                worldIn.setBlock(pos.below(1), state.setValue(STAGE, 15), 3);
                worldIn.setBlock(pos, state.setValue(STAGE, 16), 3);
                worldIn.setBlock(pos.above(1), state.setValue(STAGE, i + 1), 3);
                break;

            case 7:
                if (isJungle(worldIn, pos) && checkLightAndRand(worldIn, pos, rand)) {
                    worldIn.setBlock(pos.below(1), state.setValue(STAGE, 15), 3);
                    worldIn.setBlock(pos, state.setValue(STAGE, 16), 3);
                    worldIn.setBlock(pos.above(1), state.setValue(STAGE, i + 1), 3);
                }
                break;

            case 8:
                if (isJungle(worldIn, pos) && checkLightAndRand(worldIn, pos, rand)) {
                    worldIn.setBlock(pos.below(3), state.setValue(STAGE, 14), 3);
                    worldIn.setBlock(pos.below(1), state.setValue(STAGE, 15), 3);
                    worldIn.setBlock(pos, state.setValue(STAGE, 16), 3);
                    worldIn.setBlock(pos.above(1), state.setValue(STAGE, jump11), 3);
                }
                break;

            case 9:
                if (isJungle(worldIn, pos) && checkLightAndRand(worldIn, pos, rand)) {
                    worldIn.setBlock(pos.below(3), state.setValue(STAGE, 14), 3);
                    worldIn.setBlock(pos, state.setValue(STAGE, 16), 3);
                    worldIn.setBlock(pos.above(1), state.setValue(STAGE, jump11), 3);
                }
                break;

            case 10:
                if (isJungle(worldIn, pos) && checkLightAndRand(worldIn, pos, rand)) {
                    worldIn.setBlock(pos.below(3), state.setValue(STAGE, 14), 3);
                    worldIn.setBlock(pos.below(2), state.setValue(STAGE, 15), 3);
                    worldIn.setBlock(pos, state.setValue(STAGE, 16), 3);
                    worldIn.setBlock(pos.above(1), state.setValue(STAGE, i + 1), 3);
                }
                break;

            case 11, 12, 13: break;

            case 14:
                if (!isDirt(downState)) break;

                double x = pos.getX();
                double y = pos.getY();
                double z = pos.getZ();

                BlockPos pos1 = new BlockPos(x - 1, y, z - 1);
                BlockPos pos2 = new BlockPos(x,     y, z - 1);
                BlockPos pos3 = new BlockPos(x + 1, y, z - 1);
                BlockPos pos4 = new BlockPos(x - 1, y, z);
                BlockPos pos6 = new BlockPos(x + 1, y, z);
                BlockPos pos7 = new BlockPos(x - 1, y, z + 1);
                BlockPos pos8 = new BlockPos(x,     y, z + 1);
                BlockPos pos9 = new BlockPos(x + 1, y, z + 1);

                List<BlockPos> posList = Arrays.asList(pos1, pos2, pos3, pos4, pos6, pos7, pos8, pos9);
                List<BlockState> stateList = posList.stream().map(worldIn::getBlockState).toList();

                BlockState BAMBOO_SHOOT = BlockRegistry.BAMBOO_SHOOT.get().defaultBlockState();

                if (countBamboo(state, worldIn, pos) >= 7) return; // >= 7

                // < 7
                int chance = worldIn.isRaining() ? 6 : 10;
                if (checkDirt1(state, worldIn, pos) && stateList.get(0).getMaterial().isReplaceable() && rand.nextInt(chance) == 0) worldIn.setBlock(pos1, BAMBOO_SHOOT, 3);
                if (checkDirt2(state, worldIn, pos) && stateList.get(1).getMaterial().isReplaceable() && rand.nextInt(chance) == 0) worldIn.setBlock(pos2, BAMBOO_SHOOT, 3);
                if (checkDirt3(state, worldIn, pos) && stateList.get(2).getMaterial().isReplaceable() && rand.nextInt(chance) == 0) worldIn.setBlock(pos3, BAMBOO_SHOOT, 3);
                if (checkDirt4(state, worldIn, pos) && stateList.get(3).getMaterial().isReplaceable() && rand.nextInt(chance) == 0) worldIn.setBlock(pos4, BAMBOO_SHOOT, 3);
                if (checkDirt6(state, worldIn, pos) && stateList.get(4).getMaterial().isReplaceable() && rand.nextInt(chance) == 0) worldIn.setBlock(pos6, BAMBOO_SHOOT, 3);
                if (checkDirt7(state, worldIn, pos) && stateList.get(5).getMaterial().isReplaceable() && rand.nextInt(chance) == 0) worldIn.setBlock(pos7, BAMBOO_SHOOT, 3);
                if (checkDirt8(state, worldIn, pos) && stateList.get(6).getMaterial().isReplaceable() && rand.nextInt(chance) == 0) worldIn.setBlock(pos8, BAMBOO_SHOOT, 3);
                if (checkDirt9(state, worldIn, pos) && stateList.get(7).getMaterial().isReplaceable() && rand.nextInt(chance) == 0) worldIn.setBlock(pos9, BAMBOO_SHOOT, 3);

                break;

            case 15, 16: break;
        } // switch STAGE_0_16
    }

    private boolean checkLightAndRand(ServerLevel worldIn, BlockPos pos, Random rand) {
        return worldIn.isEmptyBlock(pos.above()) && worldIn.getRawBrightness(pos.above(), LightLayer.BLOCK.surrounding) >= 9 && rand.nextInt(3) == 0;
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(state.getBlock().asItem());
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter getter, BlockPos pos, BlockState state, boolean p_48889_) {
        return state.getValue(STAGE) != 0;
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        return InteractionResult.PASS;
    }

    @Override
    public boolean isBonemealSuccess(Level p_48891_, Random p_48892_, BlockPos p_48893_, BlockState p_48894_) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel p_48876_, Random p_48877_, BlockPos p_48878_, BlockState p_48879_) {
        int i = getHeightAboveUpToMax(p_48876_, p_48878_);
        int j = getHeightBelowUpToMax(p_48876_, p_48878_);
        int k = i + j + 1;
        int l = 1 + p_48877_.nextInt(2);

        for (int i1 = 0; i1 < l; ++i1) {
            BlockPos blockpos = p_48878_.above(i);
            BlockState blockstate = p_48876_.getBlockState(blockpos);
            if (k >= 16 || !p_48876_.isEmptyBlock(blockpos.above())) {
                growBambooShoot(p_48876_, p_48878_, p_48877_);
                return;
            }

            growBamboo(blockstate, p_48876_, blockpos, p_48877_, k);

            ++i;
            ++k;
        }

    }

    @Override
    public float getDestroyProgress(BlockState p_48901_, Player p_48902_, BlockGetter p_48903_, BlockPos p_48904_) {
        return p_48902_.getMainHandItem().canPerformAction(ToolActions.AXE_DIG) ? 1.0F
                : super.getDestroyProgress(p_48901_, p_48902_, p_48903_, p_48904_);
    }

    public void growBamboo(BlockState p_48911_, Level level, BlockPos pos, Random p_48914_, int p_48915_) {
        BlockState blockstate = level.getBlockState(pos.below());
        BlockPos blockpos = pos.below(2);
        BlockState blockstate1 = level.getBlockState(blockpos);
        BambooLeaves bambooleaves = BambooLeaves.NONE;
        if (p_48915_ >= 1) {
            if (blockstate.is(this) && blockstate.getValue(LEAVES) != BambooLeaves.NONE) {
                    bambooleaves = BambooLeaves.LARGE;
                    if (blockstate1.is(this)) {
                        level.setBlock(pos.below(), blockstate.setValue(LEAVES, BambooLeaves.SMALL), 3);
                        level.setBlock(blockpos, blockstate1.setValue(LEAVES, BambooLeaves.NONE), 3);
                }
            } else {
                bambooleaves = BambooLeaves.SMALL;
            }
        }

        level.setBlock(pos.above(), this.defaultBlockState().setValue(STAGE, 1).setValue(LEAVES, bambooleaves), 3);
    }

    public void growBambooShoot(ServerLevel levelIn, BlockPos pos, Random random) {
        BlockPos target = pos.offset(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
        boolean canSurvive = BlockRegistry.BAMBOO_SHOOT.get().defaultBlockState().canSurvive(levelIn, target);
        boolean hasSpace = levelIn.isEmptyBlock(target) && levelIn.isEmptyBlock(target.above());

        if (canSurvive && hasSpace) levelIn.setBlockAndUpdate(target, BlockRegistry.BAMBOO_SHOOT.get().defaultBlockState());
    }

    protected int getHeightAboveUpToMax(BlockGetter p_48883_, BlockPos p_48884_) {
        int i;
        for (i = 0; i < 16 && p_48883_.getBlockState(p_48884_.above(i + 1)).is(this); ++i) ;

        return i;
    }

    protected int getHeightBelowUpToMax(BlockGetter p_48933_, BlockPos p_48934_) {
        int i;
        for (i = 0; i < 16 && p_48933_.getBlockState(p_48934_.below(i + 1)).is(this); ++i) ;

        return i;
    }

    @Override
    public float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return 1F;
    }

    @Override
    public ItemStack pickupBlock(LevelAccessor worldIn, BlockPos pos, BlockState state) {
        if (state.getValue(BlockStateProperties.WATERLOGGED)) {
            worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, false), 3);

            if (!state.canSurvive(worldIn, pos)) worldIn.destroyBlock(pos, true);
            return new ItemStack(Items.WATER_BUCKET);
        }

        else { return ItemStack.EMPTY; }
    }

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Fluids.WATER.getPickupSound();
    }

    /* Check */
    private boolean checkDirt(BlockState state, Level worldIn, BlockPos pos) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        BlockState downState1 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z - 1));
        BlockState downState2 = worldIn.getBlockState(new BlockPos(x, y - 1, z - 1));
        BlockState downState3 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z - 1));
        BlockState downState4 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z));
        BlockState downState6 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z));
        BlockState downState7 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z + 1));
        BlockState downState8 = worldIn.getBlockState(new BlockPos(x, y - 1, z + 1));
        BlockState downState9 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z + 1));

        return isDirt(downState1) || isDirt(downState2) || isDirt(downState3) || isDirt(downState4) || isDirt(downState6) || isDirt(downState7) || isDirt(downState8) || isDirt(downState9);
    }

    private boolean checkDirt1(BlockState state, Level worldIn, BlockPos pos) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        BlockState downState1 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z - 1));
        return isDirt(downState1);
    }

    private boolean checkDirt2(BlockState state, Level worldIn, BlockPos pos) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        BlockState downState2 = worldIn.getBlockState(new BlockPos(x, y - 1, z - 1));
        return isDirt(downState2);
    }

    private boolean checkDirt3(BlockState state, Level worldIn, BlockPos pos) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        BlockState downState3 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z - 1));
        return isDirt(downState3);
    }

    private boolean checkDirt4(BlockState state, Level worldIn, BlockPos pos) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        BlockState downState4 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z));
        return isDirt(downState4);
    }

    private boolean checkDirt6(BlockState state, Level worldIn, BlockPos pos) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        BlockState downState6 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z));
        return isDirt(downState6);
    }

    private boolean checkDirt7(BlockState state, Level worldIn, BlockPos pos) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        BlockState downState7 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z + 1));
        return isDirt(downState7);
    }

    private boolean checkDirt8(BlockState state, Level worldIn, BlockPos pos) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        BlockState downState8 = worldIn.getBlockState(new BlockPos(x, y - 1, z + 1));
        return isDirt(downState8);
    }

    private boolean checkDirt9(BlockState state, Level worldIn, BlockPos pos) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        BlockState downState9 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z + 1));
        return isDirt(downState9);
    }

    private boolean checkSpace(BlockState state, Level worldIn, BlockPos pos) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        BlockPos pos1 = new BlockPos(x - 1, y, z - 1);
        BlockPos pos2 = new BlockPos(x, y, z - 1);
        BlockPos pos3 = new BlockPos(x + 1, y, z - 1);
        BlockPos pos4 = new BlockPos(x - 1, y, z);
        BlockPos pos6 = new BlockPos(x + 1, y, z);
        BlockPos pos7 = new BlockPos(x - 1, y, z + 1);
        BlockPos pos8 = new BlockPos(x, y, z + 1);
        BlockPos pos9 = new BlockPos(x + 1, y, z + 1);
        BlockState state1 = worldIn.getBlockState(pos1);
        BlockState state2 = worldIn.getBlockState(pos2);
        BlockState state3 = worldIn.getBlockState(pos3);
        BlockState state4 = worldIn.getBlockState(pos4);
        BlockState state6 = worldIn.getBlockState(pos6);
        BlockState state7 = worldIn.getBlockState(pos7);
        BlockState state8 = worldIn.getBlockState(pos8);
        BlockState state9 = worldIn.getBlockState(pos9);

        return (state1.getMaterial().isReplaceable()) || (state2.getMaterial().isReplaceable()) || (state3.getMaterial().isReplaceable()) || (state4.getMaterial().isReplaceable()) || (state6.getMaterial().isReplaceable()) || (state7.getMaterial().isReplaceable()) || (state8.getMaterial().isReplaceable()) || (state9.getMaterial().isReplaceable());
    }

    private boolean isJungle(ServerLevel worldIn, BlockPos pos) {
        Holder<Biome> biome = worldIn.getBiome(pos);
        return (biome.is(Biomes.JUNGLE) || biome.is(Biomes.BAMBOO_JUNGLE) || biome.is(Biomes.SPARSE_JUNGLE));
    }

    private int countBamboo(BlockState state, ServerLevel worldIn, BlockPos pos) {
        int count = 0;
        for (int rangeX = -3; rangeX <= 3; rangeX++) {
            for (int rangeZ = -3; rangeZ <= 3; rangeZ++) {
                if (worldIn.getBlockState(pos.offset(rangeX, 0, rangeZ)).getBlock() instanceof BambooPlant) count++;

                if (worldIn.getBlockState(pos.offset(rangeX, 0, rangeZ)).getBlock() instanceof BambooShoot) count++;

                if (worldIn.getBlockState(pos.offset(rangeX, 0, rangeZ)).getBlock() instanceof BambooBlock) count++;

                if (worldIn.getBlockState(pos.offset(rangeX, 0, rangeZ)).getBlock() instanceof BambooSaplingBlock) count++;
            }
        }
        return count;
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
                worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.TRUE), 3);
                worldIn.scheduleTick(pos, fluid.getType(), fluid.getType().getTickDelay(worldIn)); }
            return true;
        }

        else return false;
    }


}