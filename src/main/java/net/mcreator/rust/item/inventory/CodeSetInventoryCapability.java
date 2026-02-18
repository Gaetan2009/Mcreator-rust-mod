package net.mcreator.rust.item.inventory;

@EventBusSubscriber
public class CodeSetInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == RustModItems.CODE_SET.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof CodeaMenu)
				player.closeContainer();
		}
	}

	public CodeSetInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 9);
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != RustModItems.CODE_SET.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}