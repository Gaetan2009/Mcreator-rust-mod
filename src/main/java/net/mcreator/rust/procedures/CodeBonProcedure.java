package net.mcreator.rust.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.rust.init.RustModMenus;

public class CodeBonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (("" + (int) (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Code"))).equals((entity instanceof Player _entity2 && _entity2.containerMenu instanceof RustModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "Code", "") : "")) {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Code bon"), false);
			}
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
			}
			{
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
			}
		} else {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Mauvais code"), false);
			}
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Code"))), false);
			}
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
			{
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}
}