package net.mcreator.rust.procedures;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.rust.network.PlayPlayerAnimationMessage;
import net.mcreator.rust.RustMod;

public class FlyProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (entity.level().isClientSide()) {
				CompoundTag data = entity.getPersistentData();
				data.putString("PlayerCurrentAnimation", "rust:animation.model.fly");
				data.putBoolean("OverrideCurrentAnimation", true);
				data.putBoolean("FirstPersonAnimation", false);
			} else {
				PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "rust:animation.model.fly", true, false));
			}
		}
		RustMod.queueServerWork(100, () -> {
			if (entity instanceof Player) {
				if (entity.level().isClientSide()) {
					CompoundTag data = entity.getPersistentData();
					data.putString("PlayerCurrentAnimation", "rust:animation.model.fly2");
					data.putBoolean("OverrideCurrentAnimation", true);
					data.putBoolean("FirstPersonAnimation", false);
				} else {
					PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "rust:animation.model.fly2", true, false));
				}
			}
		});
		for (int index0 = 0; index0 < 100; index0++) {
			entity.push(0, 1, 0);
		}
	}
}