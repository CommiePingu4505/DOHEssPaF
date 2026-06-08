package net.mcreator.dohess.procedures;

import net.minecraft.item.ItemStack;

public class SetKnifeModelProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("Knife");
	}
}