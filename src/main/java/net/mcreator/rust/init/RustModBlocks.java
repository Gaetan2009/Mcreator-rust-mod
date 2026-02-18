/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rust.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.rust.block.PorteEnMetalBlock;
import net.mcreator.rust.block.FurnacerustBlock;
import net.mcreator.rust.block.EtablieBlock;
import net.mcreator.rust.RustMod;

import java.util.function.Function;

public class RustModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(RustMod.MODID);
	public static final DeferredBlock<Block> ETABLIE;
	public static final DeferredBlock<Block> PORTE_EN_METAL;
	public static final DeferredBlock<Block> FURNACERUST;
	static {
		ETABLIE = register("etablie", EtablieBlock::new);
		PORTE_EN_METAL = register("porte_en_metal", PorteEnMetalBlock::new);
		FURNACERUST = register("furnacerust", FurnacerustBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}