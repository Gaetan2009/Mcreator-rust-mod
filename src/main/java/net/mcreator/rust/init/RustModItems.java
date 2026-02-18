/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rust.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.rust.item.RocheeItem;
import net.mcreator.rust.item.RocheItem;
import net.mcreator.rust.item.GrenadeF1Item;
import net.mcreator.rust.RustMod;

import java.util.function.Function;

public class RustModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(RustMod.MODID);
	public static final DeferredItem<Item> ROCHE;
	public static final DeferredItem<Item> ROCHEE;
	public static final DeferredItem<Item> ETABLIE;
	public static final DeferredItem<Item> GRENADE_F_1;
	static {
		ROCHE = register("roche", RocheItem::new);
		ROCHEE = register("rochee", RocheeItem::new);
		ETABLIE = block(RustModBlocks.ETABLIE);
		GRENADE_F_1 = register("grenade_f_1", GrenadeF1Item::new);
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
}