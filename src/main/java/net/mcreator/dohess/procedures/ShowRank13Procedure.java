package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank13Procedure {
	public static String execute(IWorld world) {
		return "13: " + DohessModVariables.WorldVariables.get(world).Rank13.substring(43, (DohessModVariables.WorldVariables.get(world).Rank13).length() - 23);
	}
}