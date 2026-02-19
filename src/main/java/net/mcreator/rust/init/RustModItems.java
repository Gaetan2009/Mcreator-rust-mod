/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rust.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.mcreator.rust.item.inventory.CodeSetInventoryCapability;
import net.mcreator.rust.item.*;
import net.mcreator.rust.RustMod;

import java.util.function.Function;

@EventBusSubscriber
public class RustModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(RustMod.MODID);
	public static final DeferredItem<Item> ROCHE;
	public static final DeferredItem<Item> ROCHEE;
	public static final DeferredItem<Item> ETABLIE;
	public static final DeferredItem<Item> GRENADE_F_1;
	public static final DeferredItem<Item> SCRAP;
	public static final DeferredItem<Item> GRENADE_F_1_ENTITEE_SPAWN_EGG;
	public static final DeferredItem<Item> PORTE_EN_METAL;
	public static final DeferredItem<Item> CODE_SET;
	public static final DeferredItem<Item> SALVAGED_CLEAVER;
	public static final DeferredItem<Item> FURNACERUST;
	public static final DeferredItem<Item> BROILIEUR;
	public static final DeferredItem<Item> CAISSE;
	static {
		ROCHE = register("roche", RocheItem::new);
		ROCHEE = register("rochee", RocheeItem::new);
		ETABLIE = block(RustModBlocks.ETABLIE);
		GRENADE_F_1 = register("grenade_f_1", GrenadeF1Item::new);
		SCRAP = register("scrap", ScrapItem::new);
		GRENADE_F_1_ENTITEE_SPAWN_EGG = register("grenade_f_1_entitee_spawn_egg", properties -> new SpawnEggItem(RustModEntities.GRENADE_F_1_ENTITEE.get(), properties));
		PORTE_EN_METAL = doubleBlock(RustModBlocks.PORTE_EN_METAL);
		CODE_SET = register("code_set", CodeSetItem::new);
		SALVAGED_CLEAVER = register("salvaged_cleaver", SalvagedCleaverItem::new);
		FURNACERUST = block(RustModBlocks.FURNACERUST);
		BROILIEUR = block(RustModBlocks.BROILIEUR);
		CAISSE = block(RustModBlocks.CAISSE);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block) {
		return doubleBlock(block, new Item.Properties());
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new DoubleHighBlockItem(block.get(), prop), properties);
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new CodeSetInventoryCapability(stack), CODE_SET.get());
	}
}