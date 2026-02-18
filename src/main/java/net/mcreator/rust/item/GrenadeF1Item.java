package net.mcreator.rust.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.mcreator.rust.procedures.GrenadeF1LanceProcedure;

public class GrenadeF1Item extends Item {
	public GrenadeF1Item(Item.Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		GrenadeF1LanceProcedure.execute(entity);
		return ar;
	}
}