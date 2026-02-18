package net.mcreator.rust.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.rust.init.RustModMenus;
import net.mcreator.rust.init.RustModItems;

public class CodebProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal(((entity instanceof Player _entity0 && _entity0.containerMenu instanceof RustModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "Code", "") : "")), false);
		}
		{
			final String _tagName = "Code";
			final double _tagValue = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity2 && _entity2.containerMenu instanceof RustModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "Code", "") : "");
			CustomData.update(DataComponents.CUSTOM_DATA, new ItemStack(RustModItems.CODE_SET.get()), tag -> tag.putDouble(_tagName, _tagValue));
		}
	}
}