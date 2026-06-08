package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank1Procedure {
	public static String execute(IWorld world) {
		return "1: " + DohessModVariables.WorldVariables.get(world).Rank1.substring(43, (DohessModVariables.WorldVariables.get(world).Rank1).length() - 23);
	}
}