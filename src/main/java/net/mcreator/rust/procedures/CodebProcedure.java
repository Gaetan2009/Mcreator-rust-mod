package net.mcreator.rust.procedures;

import net.neoforged.bus.api.Event;

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
			CustomData.update(DataComponents.CUSTOM_DATA, new ItemStack(RustModItems.DELETED_MOD_ELEMENT.get()), tag -> tag.putDouble(_tagName, _tagValue));
		}
	}
}