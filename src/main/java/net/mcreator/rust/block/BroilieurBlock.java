package net.mcreator.rust.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class BroilieurBlock extends Block {
	private static final VoxelShape SHAPE = Shapes.or(box(12, 18, 22, 14, 23, 24), box(12, 18, 19, 14, 23, 21), box(12, 18, 15, 14, 23, 17), box(12, 18, 12, 14, 23, 14), box(12, 18, 25, 14, 23, 27), box(12, 18, 9, 14, 23, 11),
			box(1.9, 18, 22, 3.9, 23, 24), box(1.9, 18, 19, 3.9, 23, 21), box(1.9, 18, 15, 3.9, 23, 17), box(1.9, 18, 12, 3.9, 23, 14), box(1.9, 18, 25, 3.9, 23, 27), box(1.9, 18, 9, 3.9, 23, 11), box(12, 17.5, 28, 15, 25.5, 31),
			box(14, 0, 4, 15, 10, 5), box(1, 0, 4, 2, 10, 5), box(1, 17.8, 28, 4, 25.8, 31), box(1, 18, 29, 15, 26, 31), box(1, 18, 4, 15, 26, 6), box(13, 18, 4, 15, 26, 31), box(1, 18, 4, 3, 26, 31), box(1, 10, 4, 15, 18, 31),
			box(7, 13, 1, 9, 14, 4), box(6, 12, 1, 10, 13, 4), box(4, 0, 1, 12, 11, 4), box(5, 11, 1, 11, 12, 4), box(12, 17.5, 4, 15, 25.5, 7), box(1, 17.5, 4, 4, 25.5, 7), box(1, 0, 30, 2, 10, 31), box(14, 0, 30, 15, 10, 31),
			box(2, 9, 2, 3, 13, 4));

	public BroilieurBlock(BlockBehaviour.Properties properties) {
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
}