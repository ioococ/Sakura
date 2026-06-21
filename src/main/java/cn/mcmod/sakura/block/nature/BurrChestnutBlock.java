package cn.mcmod.sakura.block.nature;


import cn.mcmod.sakura.block.BlockItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BurrChestnutBlock extends Block implements IForgeShearable, IPlantable {

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 3);

    public static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
//            Block.box(minX, minY, minZ, maxX, maxY, maxZ)
            Block.box(6.0D, 10.0D, 6.0D, 11.0D, 16.0D, 11.0D),

            Block.box(4.0D, 6.0D, 4.0D, 13.0D, 16.0D, 13.0D),

            Block.box(4.0D, 6.0D, 4.0D, 13.0D, 16.0D, 13.0D),

            Block.box(4.0D, 6.0D, 4.0D, 13.0D, 16.0D, 13.0D)
    };

    public BurrChestnutBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(AGE, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    public float getBlockHardness(BlockState blockState, ServerLevel worldIn, BlockPos pos) {

        if (blockState.getValue(AGE) >= 3) return 2f;

        return 5f;
    }

    private boolean canBlockStay(ServerLevel worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.above()).getMaterial().isSolid();
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();

        if (getMetaFromState(state) >= 3) {

            drops.add(new ItemStack(BlockItemRegistry.BURR_CHESTNUT.get()));
        }

        return drops;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        final Block block = level.getBlockState(pos.above()).getBlock();

        return block instanceof MapleLeavesBlock;
    }

    public void neighborChanged(BlockState state, ServerLevel worldIn, BlockPos pos, Block blockIn) {
        validatePosition(worldIn, pos);
    }

    public void validatePosition(ServerLevel level, BlockPos pos) {

        if (!this.canSurvive(this.stateDefinition.any(), level, pos)) {
            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        }
    }

    public int getMetaFromState(BlockState state) {
        return state.getValue(AGE);
    }

    public int getMaxAge() {
        return 3;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random rand) {
        super.randomTick(state, level, pos, rand);

        // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (!level.isAreaLoaded(pos, 1)) return;

        if (level.getRawBrightness(pos.above(), LightLayer.BLOCK.surrounding) >= 9) {
            int i = this.getAge(state);

            if (i < this.getMaxAge()) {
                float f = growthChance(this, level, pos);

                boolean chance = rand.nextInt((int) (25.0F / f) + 1) == 0;

                if (ForgeHooks.onCropsGrowPre(level, pos, state, chance)) {
                    level.setBlock(pos, this.withAge(level, pos, i + 1), 2);
                    ForgeHooks.onCropsGrowPost(level, pos, level.getBlockState(pos));
                }
            }
        }


        if (state.getValue(AGE) < 3) return;

        Item item = BlockItemRegistry.BURR_CHESTNUT.get();
        this.dropItem(level, pos, item);
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

    protected int getAge(BlockState state) {
        return state.getValue(AGE);
    }

    public BlockState withAge(Level world, BlockPos pos, int age) {
        BlockState state = world.getBlockState(pos);
        return state.setValue(AGE, age);
    }

    public boolean isMaxAge(BlockState state) {
        return state.getValue(AGE) >= this.getMaxAge();
    }

    public void dropItem(Level level, BlockPos pos, Item item) {
        if ((level.restoringBlockSnapshots) || (level.isClientSide)) return;

        float f = 0.5F;
        double d0 = pos.getX() + level.random.nextFloat() * f + 0.25D;
        double d1 = pos.getY() + level.random.nextFloat() * f + 0.25D;
        double d2 = pos.getZ() + level.random.nextFloat() * f + 0.25D;

        level.setBlock(pos, Blocks.AIR.getStateDefinition().any(), 3);
        popResource(
                level,
                new BlockPos(d0, d1, d2),
                new ItemStack(item));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.PASS;

        if (canGrow(state)) return InteractionResult.PASS;

        level.setBlock(pos, this.withAge(level, pos, 1), 0);
        dropItem(level, pos,BlockItemRegistry.BURR_CHESTNUT.get());
        return InteractionResult.CONSUME;

    }

    public boolean canGrow(BlockState state) {
        return !this.isMaxAge(state);
    }

    public void grow(ServerLevel worldIn, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();

        if (i > j) i = j;


        worldIn.setBlock(pos, this.withAge(worldIn, pos, i), 2);
    }

    protected int getBonemealAgeIncrease(ServerLevel level) {
        return level.random.nextInt(5) + 2;
    }

    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return this.stateDefinition.any();
        return state;
    }


    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos) {
        return PlantType.CROP;
    }

    /*

        // 以下代码创建一个自定义附魔的物品：
        CompoundTag tag = new CompoundTag();

        // 添加自定义显示名称
        CompoundTag display = new CompoundTag();
        display.putString("Name", "{\"text\":\"Legendary Chestnut\"}");
        tag.put("display", display);

        // 添加自定义属性
        CompoundTag attributes = new CompoundTag();
        attributes.putInt("CustomDurability", 9999);
        tag.put("custom_data", attributes);

        // 创建物品并附加 NBT 数据
        ItemStack customItem = new ItemStack(BlockItemRegistry.CHESTNUT_BURR.get(), 1, tag);



        // 若要从 ItemStack 中提取 NBT 数据：
        ItemStack stack = ...; // 从某个事件或上下文中获取物品
        CompoundTag tag = stack.getTag();
        if (tag != null && tag.contains("custom_data")) {
            int durability = tag.getCompound("custom_data").getInt("CustomDurability");
            System.out.println("Durability: " + durability);
        }

    * */
}