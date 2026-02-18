package net.mcreator.rust.item;

public class RocheeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10, 1f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("rust:rochee_repair_items")));

	public RocheeItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 1f, -4f));
	}
}