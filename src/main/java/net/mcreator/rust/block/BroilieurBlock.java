package net.mcreator.rust.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BroilieurBlock extends Block {
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
	private static final VoxelShape SHAPE_NORTH = Shapes.or(box(12, 18, 22, 14, 23, 24), box(12, 18, 19, 14, 23, 21), box(12, 18, 15, 14, 23, 17), box(12, 18, 12, 14, 23, 14), box(12, 18, 25, 14, 23, 27), box(12, 18, 9, 14, 23, 11),
			box(1.9, 18, 22, 3.9, 23, 24), box(1.9, 18, 19, 3.9, 23, 21), box(1.9, 18, 15, 3.9, 23, 17), box(1.9, 18, 12, 3.9, 23, 14), box(1.9, 18, 25, 3.9, 23, 27), box(1.9, 18, 9, 3.9, 23, 11), box(12, 17.5, 28, 15, 25.5, 31),
			box(14, 0, 4, 15, 10, 5), box(1, 0, 4, 2, 10, 5), box(1, 17.8, 28, 4, 25.8, 31), box(1, 18, 29, 15, 26, 31), box(1, 18, 4, 15, 26, 6), box(13, 18, 4, 15, 26, 31), box(1, 18, 4, 3, 26, 31), box(1, 10, 4, 15, 18, 31),
			box(7, 13, 1, 9, 14, 4), box(6, 12, 1, 10, 13, 4), box(4, 0, 1, 12, 11, 4), box(5, 11, 1, 11, 12, 4), box(12, 17.5, 4, 15, 25.5, 7), box(1, 17.5, 4, 4, 25.5, 7), box(1, 0, 30, 2, 10, 31), box(14, 0, 30, 15, 10, 31),
			box(2, 9, 2, 3, 13, 4));
	private static final VoxelShape SHAPE_SOUTH = Shapes.or(box(2, 18, -8, 4, 23, -6), box(2, 18, -5, 4, 23, -3), box(2, 18, -1, 4, 23, 1), box(2, 18, 2, 4, 23, 4), box(2, 18, -11, 4, 23, -9), box(2, 18, 5, 4, 23, 7), box(12.1, 18, -8, 14.1, 23, -6),
			box(12.1, 18, -5, 14.1, 23, -3), box(12.1, 18, -1, 14.1, 23, 1), box(12.1, 18, 2, 14.1, 23, 4), box(12.1, 18, -11, 14.1, 23, -9), box(12.1, 18, 5, 14.1, 23, 7), box(1, 17.5, -15, 4, 25.5, -12), box(1, 0, 11, 2, 10, 12),
			box(14, 0, 11, 15, 10, 12), box(12, 17.8, -15, 15, 25.8, -12), box(1, 18, -15, 15, 26, -13), box(1, 18, 10, 15, 26, 12), box(1, 18, -15, 3, 26, 12), box(13, 18, -15, 15, 26, 12), box(1, 10, -15, 15, 18, 12), box(7, 13, 12, 9, 14, 15),
			box(6, 12, 12, 10, 13, 15), box(4, 0, 12, 12, 11, 15), box(5, 11, 12, 11, 12, 15), box(1, 17.5, 9, 4, 25.5, 12), box(12, 17.5, 9, 15, 25.5, 12), box(14, 0, -15, 15, 10, -14), box(1, 0, -15, 2, 10, -14), box(13, 9, 12, 14, 13, 14));
	private static final VoxelShape SHAPE_EAST = Shapes.or(box(-8, 18, 12, -6, 23, 14), box(-5, 18, 12, -3, 23, 14), box(-1, 18, 12, 1, 23, 14), box(2, 18, 12, 4, 23, 14), box(-11, 18, 12, -9, 23, 14), box(5, 18, 12, 7, 23, 14),
			box(-8, 18, 1.9, -6, 23, 3.9), box(-5, 18, 1.9, -3, 23, 3.9), box(-1, 18, 1.9, 1, 23, 3.9), box(2, 18, 1.9, 4, 23, 3.9), box(-11, 18, 1.9, -9, 23, 3.9), box(5, 18, 1.9, 7, 23, 3.9), box(-15, 17.5, 12, -12, 25.5, 15),
			box(11, 0, 14, 12, 10, 15), box(11, 0, 1, 12, 10, 2), box(-15, 17.8, 1, -12, 25.8, 4), box(-15, 18, 1, -13, 26, 15), box(10, 18, 1, 12, 26, 15), box(-15, 18, 13, 12, 26, 15), box(-15, 18, 1, 12, 26, 3), box(-15, 10, 1, 12, 18, 15),
			box(12, 13, 7, 15, 14, 9), box(12, 12, 6, 15, 13, 10), box(12, 0, 4, 15, 11, 12), box(12, 11, 5, 15, 12, 11), box(9, 17.5, 12, 12, 25.5, 15), box(9, 17.5, 1, 12, 25.5, 4), box(-15, 0, 1, -14, 10, 2), box(-15, 0, 14, -14, 10, 15),
			box(12, 9, 2, 14, 13, 3));
	private static final VoxelShape SHAPE_WEST = Shapes.or(box(22, 18, 2, 24, 23, 4), box(19, 18, 2, 21, 23, 4), box(15, 18, 2, 17, 23, 4), box(12, 18, 2, 14, 23, 4), box(25, 18, 2, 27, 23, 4), box(9, 18, 2, 11, 23, 4),
			box(22, 18, 12.1, 24, 23, 14.1), box(19, 18, 12.1, 21, 23, 14.1), box(15, 18, 12.1, 17, 23, 14.1), box(12, 18, 12.1, 14, 23, 14.1), box(25, 18, 12.1, 27, 23, 14.1), box(9, 18, 12.1, 11, 23, 14.1), box(28, 17.5, 1, 31, 25.5, 4),
			box(4, 0, 1, 5, 10, 2), box(4, 0, 14, 5, 10, 15), box(28, 17.8, 12, 31, 25.8, 15), box(29, 18, 1, 31, 26, 15), box(4, 18, 1, 6, 26, 15), box(4, 18, 1, 31, 26, 3), box(4, 18, 13, 31, 26, 15), box(4, 10, 1, 31, 18, 15),
			box(1, 13, 7, 4, 14, 9), box(1, 12, 6, 4, 13, 10), box(1, 0, 4, 4, 11, 12), box(1, 11, 5, 4, 12, 11), box(4, 17.5, 1, 7, 25.5, 4), box(4, 17.5, 12, 7, 25.5, 15), box(30, 0, 14, 31, 10, 15), box(30, 0, 1, 31, 10, 2),
			box(2, 9, 13, 4, 13, 14));

	public BroilieurBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.GRAVEL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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