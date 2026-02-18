/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rust.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.rust.client.model.Modelmodel_grenade_f1_Converted;

@EventBusSubscriber(Dist.CLIENT)
public class RustModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelmodel_grenade_f1_Converted.LAYER_LOCATION, Modelmodel_grenade_f1_Converted::createBodyLayer);
	}
}