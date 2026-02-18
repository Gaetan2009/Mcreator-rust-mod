package net.mcreator.rust.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class EtablieBlock extends Block {
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
	private static final VoxelShape SHAPE_NORTH = Shapes.or(box(2, 4, 6, 3, 7, 14), box(2, 3, 5, 12, 4, 15), box(2, 7, 12, 3, 8, 14), box(2, 7, 6, 3, 8, 8), box(2, 8, 6, 3, 9, 14), box(2, 4, 14, 12, 9, 15), box(2, 4, 5, 12, 9, 6),
			box(11, 4, 6, 12, 7, 14), box(11, 7, 12, 12, 8, 14), box(11, 7, 6, 12, 8, 8), box(11, 8, 6, 12, 9, 14), box(1, 0, 30, 2, 14, 31), box(0, 2, 1, 16, 3, 31), box(1, 0, 1, 2, 14, 2), box(8, 0, 0, 16, 30, 1), box(0, 12, 0, 1, 14, 32),
			box(0, 14, 0, 8, 15, 32), box(8, 14, 1, 16, 15, 31), box(8, 0, 31, 16, 30, 32), box(9, 23, 1, 16, 24, 31), box(8, 30, 0, 16, 31, 32), box(0, 31, 0, 16, 32, 32), box(9, 26, 30, 16, 29, 31), box(9, 20, 30, 16, 23, 31),
			box(9, 15, 30, 16, 18, 31), box(9, 15, 1, 16, 18, 2), box(9, 20, 1, 16, 23, 2), box(9, 26, 1, 16, 29, 2), box(10, 24, 4, 15, 25, 13), box(10, 25, 5, 11, 26, 12), box(10, 26, 10, 11, 27, 12), box(10, 26, 5, 11, 27, 7),
			box(10, 27, 5, 11, 28, 12), box(10, 25, 12, 15, 28, 13), box(10, 25, 4, 15, 28, 5), box(14, 25, 5, 15, 26, 12), box(14, 27, 5, 15, 28, 12), box(14, 26, 5, 15, 27, 7), box(14, 26, 10, 15, 27, 12), box(10, 24, 22, 12, 26, 26),
			box(12, 24, 15, 14, 26, 19), box(11, 15, 17, 16, 16, 22), box(15, 16, 19, 16, 21.5, 20), box(15, 21.5, 19, 15.5, 22, 20), box(11, 21, 19, 15, 22, 20), box(10.5, 18, 18.5, 12.5, 21, 20.5), box(11, 18.5, 21, 12, 21.5, 22),
			box(11.25, 16.5, 19.25, 11.75, 18.5, 19.75), box(11, 19.5, 20, 12, 20.5, 21), box(7.5, 20, 24.5, 11.5, 21, 25.5), box(6, 15.5, 27.5, 7, 18.5, 28.5), box(6.5, 18, 26.5, 7.5, 19, 27.5), box(7.5, 19, 24.5, 8.5, 20, 25.5),
			box(6.5, 15, 26.5, 7.5, 16, 27.5), box(6, 15, 25, 9, 19, 28), box(6, 15, 5, 11, 18, 15), box(7.5, 17, 9, 8.5, 18, 11), box(7.59039, 18, 2.42621, 12.59039, 19, 12.42621));
	private static final VoxelShape SHAPE_SOUTH = Shapes.or(box(13, 4, 2, 14, 7, 10), box(4, 3, 1, 14, 4, 11), box(13, 7, 2, 14, 8, 4), box(13, 7, 8, 14, 8, 10), box(13, 8, 2, 14, 9, 10), box(4, 4, 1, 14, 9, 2), box(4, 4, 10, 14, 9, 11),
			box(4, 4, 2, 5, 7, 10), box(4, 7, 2, 5, 8, 4), box(4, 7, 8, 5, 8, 10), box(4, 8, 2, 5, 9, 10), box(14, 0, -15, 15, 14, -14), box(0, 2, -15, 16, 3, 15), box(14, 0, 14, 15, 14, 15), box(0, 0, 15, 8, 30, 16), box(15, 12, -16, 16, 14, 16),
			box(8, 14, -16, 16, 15, 16), box(0, 14, -15, 8, 15, 15), box(0, 0, -16, 8, 30, -15), box(0, 23, -15, 7, 24, 15), box(0, 30, -16, 8, 31, 16), box(0, 31, -16, 16, 32, 16), box(0, 26, -15, 7, 29, -14), box(0, 20, -15, 7, 23, -14),
			box(0, 15, -15, 7, 18, -14), box(0, 15, 14, 7, 18, 15), box(0, 20, 14, 7, 23, 15), box(0, 26, 14, 7, 29, 15), box(1, 24, 3, 6, 25, 12), box(5, 25, 4, 6, 26, 11), box(5, 26, 4, 6, 27, 6), box(5, 26, 9, 6, 27, 11), box(5, 27, 4, 6, 28, 11),
			box(1, 25, 3, 6, 28, 4), box(1, 25, 11, 6, 28, 12), box(1, 25, 4, 2, 26, 11), box(1, 27, 4, 2, 28, 11), box(1, 26, 9, 2, 27, 11), box(1, 26, 4, 2, 27, 6), box(4, 24, -10, 6, 26, -6), box(2, 24, -3, 4, 26, 1), box(0, 15, -6, 5, 16, -1),
			box(0, 16, -4, 1, 21.5, -3), box(0.5, 21.5, -4, 1, 22, -3), box(1, 21, -4, 5, 22, -3), box(3.5, 18, -4.5, 5.5, 21, -2.5), box(4, 18.5, -6, 5, 21.5, -5), box(4.25, 16.5, -3.75, 4.75, 18.5, -3.25), box(4, 19.5, -5, 5, 20.5, -4),
			box(4.5, 20, -9.5, 8.5, 21, -8.5), box(9, 15.5, -12.5, 10, 18.5, -11.5), box(8.5, 18, -11.5, 9.5, 19, -10.5), box(7.5, 19, -9.5, 8.5, 20, -8.5), box(8.5, 15, -11.5, 9.5, 16, -10.5), box(7, 15, -12, 10, 19, -9), box(5, 15, 1, 10, 18, 11),
			box(7.5, 17, 5, 8.5, 18, 7), box(3.40961, 18, 3.57379, 8.40961, 19, 13.57379));
	private static final VoxelShape SHAPE_EAST = Shapes.or(box(2, 4, 2, 10, 7, 3), box(1, 3, 2, 11, 4, 12), box(2, 7, 2, 4, 8, 3), box(8, 7, 2, 10, 8, 3), box(2, 8, 2, 10, 9, 3), box(1, 4, 2, 2, 9, 12), box(10, 4, 2, 11, 9, 12),
			box(2, 4, 11, 10, 7, 12), box(2, 7, 11, 4, 8, 12), box(8, 7, 11, 10, 8, 12), box(2, 8, 11, 10, 9, 12), box(-15, 0, 1, -14, 14, 2), box(-15, 2, 0, 15, 3, 16), box(14, 0, 1, 15, 14, 2), box(15, 0, 8, 16, 30, 16), box(-16, 12, 0, 16, 14, 1),
			box(-16, 14, 0, 16, 15, 8), box(-15, 14, 8, 15, 15, 16), box(-16, 0, 8, -15, 30, 16), box(-15, 23, 9, 15, 24, 16), box(-16, 30, 8, 16, 31, 16), box(-16, 31, 0, 16, 32, 16), box(-15, 26, 9, -14, 29, 16), box(-15, 20, 9, -14, 23, 16),
			box(-15, 15, 9, -14, 18, 16), box(14, 15, 9, 15, 18, 16), box(14, 20, 9, 15, 23, 16), box(14, 26, 9, 15, 29, 16), box(3, 24, 10, 12, 25, 15), box(4, 25, 10, 11, 26, 11), box(4, 26, 10, 6, 27, 11), box(9, 26, 10, 11, 27, 11),
			box(4, 27, 10, 11, 28, 11), box(3, 25, 10, 4, 28, 15), box(11, 25, 10, 12, 28, 15), box(4, 25, 14, 11, 26, 15), box(4, 27, 14, 11, 28, 15), box(9, 26, 14, 11, 27, 15), box(4, 26, 14, 6, 27, 15), box(-10, 24, 10, -6, 26, 12),
			box(-3, 24, 12, 1, 26, 14), box(-6, 15, 11, -1, 16, 16), box(-4, 16, 15, -3, 21.5, 16), box(-4, 21.5, 15, -3, 22, 15.5), box(-4, 21, 11, -3, 22, 15), box(-4.5, 18, 10.5, -2.5, 21, 12.5), box(-6, 18.5, 11, -5, 21.5, 12),
			box(-3.75, 16.5, 11.25, -3.25, 18.5, 11.75), box(-5, 19.5, 11, -4, 20.5, 12), box(-9.5, 20, 7.5, -8.5, 21, 11.5), box(-12.5, 15.5, 6, -11.5, 18.5, 7), box(-11.5, 18, 6.5, -10.5, 19, 7.5), box(-9.5, 19, 7.5, -8.5, 20, 8.5),
			box(-11.5, 15, 6.5, -10.5, 16, 7.5), box(-12, 15, 6, -9, 19, 9), box(1, 15, 6, 11, 18, 11), box(5, 17, 7.5, 7, 18, 8.5), box(3.57379, 18, 7.59039, 13.57379, 19, 12.59039));
	private static final VoxelShape SHAPE_WEST = Shapes.or(box(6, 4, 13, 14, 7, 14), box(5, 3, 4, 15, 4, 14), box(12, 7, 13, 14, 8, 14), box(6, 7, 13, 8, 8, 14), box(6, 8, 13, 14, 9, 14), box(14, 4, 4, 15, 9, 14), box(5, 4, 4, 6, 9, 14),
			box(6, 4, 4, 14, 7, 5), box(12, 7, 4, 14, 8, 5), box(6, 7, 4, 8, 8, 5), box(6, 8, 4, 14, 9, 5), box(30, 0, 14, 31, 14, 15), box(1, 2, 0, 31, 3, 16), box(1, 0, 14, 2, 14, 15), box(0, 0, 0, 1, 30, 8), box(0, 12, 15, 32, 14, 16),
			box(0, 14, 8, 32, 15, 16), box(1, 14, 0, 31, 15, 8), box(31, 0, 0, 32, 30, 8), box(1, 23, 0, 31, 24, 7), box(0, 30, 0, 32, 31, 8), box(0, 31, 0, 32, 32, 16), box(30, 26, 0, 31, 29, 7), box(30, 20, 0, 31, 23, 7), box(30, 15, 0, 31, 18, 7),
			box(1, 15, 0, 2, 18, 7), box(1, 20, 0, 2, 23, 7), box(1, 26, 0, 2, 29, 7), box(4, 24, 1, 13, 25, 6), box(5, 25, 5, 12, 26, 6), box(10, 26, 5, 12, 27, 6), box(5, 26, 5, 7, 27, 6), box(5, 27, 5, 12, 28, 6), box(12, 25, 1, 13, 28, 6),
			box(4, 25, 1, 5, 28, 6), box(5, 25, 1, 12, 26, 2), box(5, 27, 1, 12, 28, 2), box(5, 26, 1, 7, 27, 2), box(10, 26, 1, 12, 27, 2), box(22, 24, 4, 26, 26, 6), box(15, 24, 2, 19, 26, 4), box(17, 15, 0, 22, 16, 5), box(19, 16, 0, 20, 21.5, 1),
			box(19, 21.5, 0.5, 20, 22, 1), box(19, 21, 1, 20, 22, 5), box(18.5, 18, 3.5, 20.5, 21, 5.5), box(21, 18.5, 4, 22, 21.5, 5), box(19.25, 16.5, 4.25, 19.75, 18.5, 4.75), box(20, 19.5, 4, 21, 20.5, 5), box(24.5, 20, 4.5, 25.5, 21, 8.5),
			box(27.5, 15.5, 9, 28.5, 18.5, 10), box(26.5, 18, 8.5, 27.5, 19, 9.5), box(24.5, 19, 7.5, 25.5, 20, 8.5), box(26.5, 15, 8.5, 27.5, 16, 9.5), box(25, 15, 7, 28, 19, 10), box(5, 15, 5, 15, 18, 10), box(9, 17, 7.5, 11, 18, 8.5),
			box(2.42621, 18, 3.40961, 12.42621, 19, 8.40961));

	public EtablieBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.WOOD).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return (switch (state.getValue(FACING)) {
			case NORTH -> SHAPE_NORTH;
			case SOUTH -> SHAPE_SOUTH;
			case EAST -> SHAPE_EAST;
			case WEST -> SHAPE_WEST;
			default -> SHAPE_NORTH;
		});
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}