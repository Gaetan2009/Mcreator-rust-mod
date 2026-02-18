package net.mcreator.rust.item;

public class SalvagedCleaverItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 1000, 4f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("rust:salvaged_cleaver_repair_items")));

	public SalvagedCleaverItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 99f, 1f).fireResistant());
	}
}