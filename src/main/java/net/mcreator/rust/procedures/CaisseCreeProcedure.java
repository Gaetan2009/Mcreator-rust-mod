package net.mcreator.rust.procedures;

import net.neoforged.bus.api.Event;

public class CaisseCreeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double repet = 0;
		repet = 0;
		for (int index0 = 0; index0 < 27; index0++) {
			if (entity instanceof Player _player && _player.containerMenu instanceof RustModMenus.MenuAccessor _menu) {
				ItemStack _setstack0 = new ItemStack(Blocks.POLISHED_GRANITE_SLAB).copy();
				_setstack0.setCount((int) repet);
				_menu.getSlots().get(0).set(_setstack0);
				_player.containerMenu.broadcastChanges();
			}
			repet = repet + 1;
		}
	}
}