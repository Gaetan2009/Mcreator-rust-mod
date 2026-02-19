package net.mcreator.rust.procedures;

import net.neoforged.bus.api.Event;

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