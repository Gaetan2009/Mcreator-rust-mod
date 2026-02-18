package net.mcreator.rust.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.rust.RustMod;

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