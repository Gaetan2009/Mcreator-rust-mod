package net.mcreator.rust.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.rust.init.RustModMenus;

public class CodebProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			final String _tagName = "Code";
			final double _tagValue = ((int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity0 && _entity0.containerMenu instanceof RustModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "Code", "") : ""));
			CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
		}
	}
}