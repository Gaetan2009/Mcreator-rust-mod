/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rust.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.rust.client.gui.GuiCaisseScreen;
import net.mcreator.rust.client.gui.CodeaScreen;
import net.mcreator.rust.client.gui.CodeScreen;

@EventBusSubscriber(Dist.CLIENT)
public class RustModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(RustModMenus.CODE.get(), CodeScreen::new);
		event.register(RustModMenus.CODEA.get(), CodeaScreen::new);
		event.register(RustModMenus.GUI_CAISSE.get(), GuiCaisseScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}