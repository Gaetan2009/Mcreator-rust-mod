package net.mcreator.rust.procedures;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.Minecraft;

import net.mcreator.rust.network.PlayPlayerAnimationMessage;

public class Roche_attackProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (new Object() {
			public boolean getValue() {
				boolean retBool = Minecraft.getInstance().options.keyAttack.isDown();
				if (retBool) {
					if (Minecraft.getInstance().options.keyAttack.getKeyModifier().toString().equals("SHIFT")) {
						retBool = Screen.hasShiftDown();
					} else if (Minecraft.getInstance().options.keyAttack.getKeyModifier().toString().equals("CONTROL")) {
						retBool = Screen.hasControlDown();
					} else if (Minecraft.getInstance().options.keyAttack.getKeyModifier().toString().equals("ALT")) {
						retBool = Screen.hasAltDown();
					}
				}
				return retBool;
			}
		}.getValue()) {
			if (entity instanceof Player) {
				if (entity.level().isClientSide()) {
					CompoundTag data = entity.getPersistentData();
					data.putString("PlayerCurrentAnimation", "rust:animation.model.rock_attack");
					data.putBoolean("OverrideCurrentAnimation", true);
					data.putBoolean("FirstPersonAnimation", true);
				} else {
					PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "rust:animation.model.rock_attack", true, true));
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack, 20);
		}
	}
}