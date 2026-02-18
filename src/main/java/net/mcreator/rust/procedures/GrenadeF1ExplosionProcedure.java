package net.mcreator.rust.procedures;

import net.neoforged.bus.api.Event;

public class GrenadeF1ExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		RustMod.queueServerWork(20, () -> {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 10, Level.ExplosionInteraction.TNT);
		});
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}