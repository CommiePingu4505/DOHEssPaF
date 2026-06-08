package net.mcreator.dohess.item;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.dohess.procedures.SpawnMichelleBlockyRightclickedProcedure;

public class SpawnMichelleBlockyItem extends Item {
	public SpawnMichelleBlockyItem() {
		super(new Item.Properties().group(null));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		SpawnMichelleBlockyRightclickedProcedure.execute(entity);
		return ar;
	}
}