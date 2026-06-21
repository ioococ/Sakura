package cn.mcmod.sakura.block.nature;

import cn.mcmod.sakura.block.entity.FallingLayerEntity;
import cn.mcmod.sakura.tags.SakuraBlockTags;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class LeafPileBlock extends LayerBlock implements SimpleWaterloggedBlock {
    public static final IntegerProperty LAYERS = IntegerProperty.create("layers", 0, 9);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    private static final VoxelShape[] SHAPE_BY_LAYER_L = {
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.5D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.5*2D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1 * 2D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2 * 2D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3 * 2D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4 * 2D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5 * 2D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6 * 2D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7 * 2D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8 * 2D, 16.0D)
    };
    private static final float[] COLLISIONS = new float[]{1, 0.999f, 0.998f, 0.997f, 0.996f, 0.994f, 0.993f, 0.992f, 0.99f};

    private final List<Supplier<SimpleParticleType>> particles;


    public LeafPileBlock(BlockBehaviour.Properties properties, List<Supplier<SimpleParticleType>> particles) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(WATERLOGGED, false)
                .setValue(LAYERS, 0));
        this.particles = particles;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LAYERS, FACING, WATERLOGGED);
    }

    @Override
    public @NotNull VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_LAYER_L[getLayers(state)];
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (context instanceof EntityCollisionContext c) {
            var e = c.getEntity();
            if (e instanceof FallingLayerEntity) {
                return SHAPE_BY_LAYER_L[state.getValue(LAYERS)];
            }
        }
        return Shapes.empty();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, Random random) {
        if (serverLevel.getBrightness(LightLayer.SKY, pos) == 15) {
            serverLevel.removeBlock(pos, false);
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
//        if (random.nextInt(16) == 0) {
//            BlockPos blockPos = pos.below();
//            if (isFree(level.getBlockState(blockPos))) {
//                var leafParticle = ParticleRegistry.getFallenLeafParticle(state).orElse(null);
//                if (leafParticle == null) return;
//                int color = Minecraft.getInstance().getBlockColors().getColor(state, level, pos, 0);
//                for (var p : particles) {
//                    if (random.nextFloat() < 0.2) {
//                        double d = (double) pos.getX() + random.nextDouble();
//                        double e = (double) pos.getY() - 0.05;
//                        double f = (double) pos.getZ() + random.nextDouble();
//                        level.addParticle(leafParticle, d, e, f, 0.0, color, 0.0);
//                    }
//                }
//            }
//        }

    }

    /* 周囲の光透過 影0.0F -> 1.0F透過*/
    @OnlyIn(Dist.CLIENT)
    public float getShadeBrightness(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0.9F;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 200;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 80;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState blockState = ctx.getLevel().getBlockState(ctx.getClickedPos());
        if (blockState.is(this)) {
            int i = blockState.getValue(LAYERS);
            return blockState.setValue(LAYERS, Math.min(9, i + 1));
        } else {
            if (blockState.getFluidState().is(Fluids.WATER)) return null;
            BlockState below = ctx.getLevel().getBlockState(ctx.getClickedPos().below());
            if (below.getFluidState().is(Fluids.WATER)) {
                if (!blockState.isAir()) return null;
                return this.defaultBlockState().setValue(LAYERS, 0);
            }
            return super.getStateForPlacement(ctx);
        }
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        int layers = this.getLayers(state);

        if (layers > 3) {
            if (entity instanceof LivingEntity && !(entity instanceof Fox || entity instanceof Bee || EnchantmentHelper.getEnchantmentLevel(Enchantments.DEPTH_STRIDER, (LivingEntity) entity) > 0)) {
                float stuck = COLLISIONS[Math.max(0, layers - 1)];
                entity.makeStuckInBlock(state, new Vec3(stuck, 1, stuck));

                if (layers >= 6) {
                    if (!level.isClientSide && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
                        if (!(entity instanceof Player player) || player.getItemBySlot(EquipmentSlot.LEGS).isEmpty()) {

                            double d = Math.abs(entity.getX() - entity.xOld);
                            double e = Math.abs(entity.getZ() - entity.zOld);
                            if (d >= 0.003000000026077032D || e >= 0.003000000026077032D) {
                                entity.hurt(DamageSource.SWEET_BERRY_BUSH, 0.5F * (layers - 5));
                            }
                        }
                    }
                }
            }
        }

        //particles
        if (layers > 0 && level.isClientSide && (entity instanceof LivingEntity && entity.getFeetBlockState().is(this))) {

            Random random = level.getRandom();
            boolean bl = entity.xOld != entity.getX() || entity.zOld != entity.getZ();
            if (bl && random.nextBoolean()) {
                //double yOff = (layers < 5) ? 0.5 : 1;
                double y = pos.getY() + SHAPE_BY_LAYER_L[layers].max(Direction.Axis.Y) + 0.0625;
                int color = Minecraft.getInstance().getBlockColors().getColor(state, level, pos, 0);
                for (var p : particles) {
                    level.addParticle(p.get(),
                            entity.getX() + Mth.randomBetween(random, -0.2f, 0.2f),
                            y,
                            entity.getZ() + Mth.randomBetween(random, -0.2f, 0.2f),
                            Mth.randomBetween(random, -0.75f, -1),
                            color,
                            0);
                    //Mth.randomBetween(random, -1.0F, 1.0F) * 0.001f)
                }
            }
        }
    }

    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return switch (type) {
            case LAND -> !isBurning(state, level, pos);
            case WATER, AIR -> false;
        };
    }

    @Override
    public float getSpeedFactor() {
        return (float) (this.speedFactor * 0.9);
    }

    //just used for placement by blockItem
    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockState bottomState = world.getBlockState(pos.below());
        if (bottomState.getBlock() instanceof LeavesBlock) return true;
        if (state.getValue(LAYERS) != 0 && !bottomState.isFaceSturdy(world, pos.below(), Direction.UP)) return false;
        return !shouldFall(state, world.getBlockState(pos.below()));
    }

    @Override
    public boolean shouldFall(BlockState state, BlockState belowState) {
        if ((state.getValue(LAYERS) == 0 && belowState.is(Blocks.WATER)) || belowState.is(SakuraBlockTags.LEAF_PILES))
            return false;
        return super.shouldFall(state, belowState);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.DOWN && state.getValue(LAYERS) <= 1) {
            state = state.setValue(LAYERS, neighborState.is(Blocks.WATER) ? 0 : 1);
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public VoxelShape getDefaultShape(BlockState state) {
        return SHAPE_BY_LAYER_L[state.getValue(LAYERS)];
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        int i = state.getValue(LAYERS);
        if (context.getItemInHand().is(this.asItem()) && i < 9 && i > 0) {
            return true;
        } else {
            return i < 3;
        }
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter world, BlockPos pos) {
        return 1;
    }

    @Override
    public int getLayers(BlockState state) {
        return state.getValue(LAYERS);
    }

    @Override
    public IntegerProperty layerProperty() {
        return LAYERS;
    }
}