package net.mcreator.rust.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CaisseBlock extends Block implements EntityBlock {
	private static final VoxelShape SHAPE = Shapes.or(box(22, 24, -1, 27, 25, 0), box(22, 18, -1, 27, 19, 0), box(22, 19, -1, 23, 24, 1), box(22, 19, 1, 27, 24, 2), box(26, 19, -1, 27, 24, 1), box(5, 24, -1, 10, 25, 0), box(5, 18, -1, 10, 19, 0),
			box(5, 19, -1, 6, 24, 1), box(5, 19, 1, 10, 24, 2), box(9, 19, -1, 10, 24, 1), box(6, 0, 31, 9, 30, 32), box(23, 0, 31, 26, 30, 32), box(23, 31, 5, 26, 32, 27), box(6, 31, 5, 9, 32, 27), box(6, 30, 1, 9, 31, 6), box(23, 30, 1, 26, 31, 6),
			box(6, 30, 26, 9, 31, 31), box(23, 30, 26, 26, 31, 31), box(1, 30, 23, 31, 31, 26), box(1, 30, 6, 31, 31, 9), box(0, 0, 6, 1, 30, 9), box(0, 0, 23, 1, 30, 26), box(31, 0, 23, 32, 30, 26), box(23, 0, 0, 26, 30, 1),
			box(31, 0, 6, 32, 30, 9), box(6, 0, 0, 9, 30, 1), box(2, 1, 2, 30, 29, 30), box(30, 27, 1, 31, 29, 31), box(2, 27, 1, 30, 29, 2), box(2, 1, 30, 30, 3, 31), box(2, 27, 30, 30, 29, 31), box(2, 1, 1, 30, 3, 2), box(30, 1, 1, 31, 3, 31),
			box(1, 1, 1, 2, 3, 31), box(1, 27, 1, 2, 29, 31), box(1, 0, 1, 31, 1, 31), box(1, 29, 1, 31, 30, 31));

	public CaisseBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.GRAVEL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
		return (SHAPE);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		if (entity instanceof ServerPlayer player) {
			player.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Caisse");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new GuiCaisseMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CaisseBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	protected void affectNeighborsAfterRemoval(BlockState blockstate, ServerLevel world, BlockPos blockpos, boolean flag) {
		Containers.updateNeighboursAfterDestroy(blockstate, world, blockpos);
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof CaisseBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}