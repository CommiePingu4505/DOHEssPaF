package net.mcreator.dohess.item;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.dohess.procedures.SpawnAmmerAllanRightclickedProcedure;

public class SpawnAmmerAllanItem extends Item {
	public SpawnAmmerAllanItem() {
		super(new Item.Properties().group(null));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		SpawnAmmerAllanRightclickedProcedure.execute(entity);
		return ar;
	}
}