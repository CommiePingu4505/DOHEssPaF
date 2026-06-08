package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank16Procedure {
	public static String execute(IWorld world) {
		return "16: " + DohessModVariables.WorldVariables.get(world).Rank16.substring(43, (DohessModVariables.WorldVariables.get(world).Rank16).length() - 23);
	}
}