package net.mcreator.rust.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.rust.procedures.Roche_attackProcedure;

import javax.annotation.Nullable;

public class RocheeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10, 1f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("rust:rochee_repair_items")));

	public RocheeItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 1f, -4f));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		if (equipmentSlot == EquipmentSlot.MAINHAND)
			Roche_attackProcedure.execute(entity, itemstack);
	}
}