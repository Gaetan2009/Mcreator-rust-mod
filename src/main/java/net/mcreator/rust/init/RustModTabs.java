/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rust.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.rust.RustMod;

@EventBusSubscriber
public class RustModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RustMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RUST = REGISTRY.register("rust",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.rust.rust")).icon(() -> new ItemStack(Items.ZOMBIE_HEAD)).displayItems((parameters, tabData) -> {
				tabData.accept(RustModItems.ROCHE.get());
				tabData.accept(RustModItems.ROCHEE.get());
				tabData.accept(RustModBlocks.FURNACERUST.get().asItem());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(RustModItems.GRENADE_F_1_ENTITEE_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(RustModItems.SALVAGED_CLEAVER.get());
		}
	}
}