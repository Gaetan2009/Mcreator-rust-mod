package net.mcreator.rust.procedures;

import net.neoforged.bus.api.Event;

public class CodeBonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (("" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Code")).equals((entity instanceof Player _entity1 && _entity1.containerMenu instanceof RustModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "Code", "") : "")) {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Code bon"), false);
			}
		} else {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Mauvais code"), false);
			}
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "code"))), false);
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