package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank11Procedure {
	public static String execute(IWorld world) {
		return "11: " + DohessModVariables.WorldVariables.get(world).Rank11.substring(43, (DohessModVariables.WorldVariables.get(world).Rank11).length() - 23);
	}
}