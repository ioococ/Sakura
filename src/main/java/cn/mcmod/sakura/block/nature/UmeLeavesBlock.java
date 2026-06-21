package cn.mcmod.sakura.block.nature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UmeLeavesBlock extends LeavesBlock implements SimpleWaterloggedBlock, BonemealableBlock, IPlantable {

    public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE;
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 4);


    public  UmeLeavesBlock(Properties builder) {
        super(builder);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(AGE, 0)
                .setValue(DISTANCE, 7)
                .setValue(PERSISTENT, Boolean.FALSE)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, DISTANCE, PERSISTENT, WATERLOGGED);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(PERSISTENT);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {

        // Forge: prevent loading unloaded chunks when checking
        if (!level.isAreaLoaded(pos, 1)) return;

        // neighbor's light
        if (level.getRawBrightness(pos.above(), LightLayer.BLOCK.surrounding) < 9) return;

        int i = this.getAge(state);
        if (i < this.getMaxAge()) {
            float f = growthChance(this, level, pos);
            boolean chance = random.nextInt((int) (25.0F / f) + 1) == 0;
            if (ForgeHooks.onCropsGrowPre(level, pos, state, chance)) {

                BlockState newState = state.setValue(AGE, i + 1);
                level.setBlock(pos, newState, 2);
                ForgeHooks.onCropsGrowPost(level, pos, level.getBlockState(pos));

                return;
            }
        }

        super.randomTick(state, level, pos, random);

    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
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

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();

         if (builder.getOptionalParameter(LootContextParams.BLOCK_STATE) == state) {
            if (Math.random() < 0.05) {
//                drops.add(new ItemStack(yourSaplingBlock));
            }
        }

        return drops;
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (level.isClientSide) return InteractionResult.FAIL;
        return super.use(state, level, pos, player, hand, result);
    }

    public void dropItem(Level level, BlockPos pos, Item item) {
        if ((level.restoringBlockSnapshots) || (level.isClientSide)) return;

        float f = 0.5F;
        double d0 = pos.getX() + level.random.nextFloat() * f + 0.25D;
        double d1 = pos.getY() + level.random.nextFloat() * f + 0.25D;
        double d2 = pos.getZ() + level.random.nextFloat() * f + 0.25D;

        popResource(
                level,
                new BlockPos(d0, d1, d2),
                new ItemStack(item));
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, boolean b) {
        return !blockState.getValue(PERSISTENT);
    }

    @Override
    public boolean isBonemealSuccess(Level level, Random random, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, Random random, BlockPos blockPos, BlockState blockState) {
        this.grow(serverLevel, blockPos, blockState);
    }

    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.getBlock() != this ? this.defaultBlockState() : state;
    }

    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos) {
        return PlantType.PLAINS;
    }

    public void grow(ServerLevel level, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(level);
        int j = this.getMaxAge();

        if (i > j) i = j;

        level.setBlock(pos, this.withAge(level, pos, i), 2);
    }

    protected static float growthChance(Block blockIn, ServerLevel worldIn, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockpos = pos.below();

        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState blockState = worldIn.getBlockState(blockpos.offset(i, 0, j));
                if (
                        blockState.getBlock().canSustainPlant(blockState, worldIn,
                                blockpos.offset(i, 0, j),
                                Direction.UP,
                                (IPlantable) blockIn)) {
                    f1 = 1.0F;

                    if (blockState.getBlock().isFertile(blockState, worldIn, blockpos.offset(i, 0, j))) f1 = 3.0F;
                }

                if (i != 0 || j != 0) f1 /= 4.0F;


                f += f1;
            }
        }

        BlockPos blockPos1 = pos.north();
        BlockPos blockPos2 = pos.south();
        BlockPos blockPos3 = pos.west();
        BlockPos blockPos4 = pos.east();
        boolean flag = blockIn == worldIn.getBlockState(blockPos3).getBlock() || blockIn == worldIn.getBlockState(blockPos4).getBlock();
        boolean flag1 = blockIn == worldIn.getBlockState(blockPos1).getBlock() || blockIn == worldIn.getBlockState(blockPos2).getBlock();

        if (flag && flag1) f /= 2.0F;

        else {
            boolean flag2 = blockIn == worldIn.getBlockState(blockPos3.north()).getBlock() || blockIn == worldIn.getBlockState(blockPos4.north()).getBlock() || blockIn == worldIn.getBlockState(blockPos4.south()).getBlock() || blockIn == worldIn.getBlockState(blockPos3.south()).getBlock();

            if (flag2) f /= 2.0F;

        }

        return f;
    }

    public int getMaxAge() {
        return 4;
    }

    protected int getAge(BlockState state) {
        return state.getValue(AGE);
    }

    public boolean isMaxAge(BlockState state) {
        return state.getValue(AGE) >= this.getMaxAge();
    }

    public BlockState withAge(Level world, BlockPos pos, int age) {
        BlockState state = world.getBlockState(pos);
        return state.setValue(AGE, age);
    }

    protected int getBonemealAgeIncrease(ServerLevel level) {
        return level.random.nextInt(5) + 2;
    }
}