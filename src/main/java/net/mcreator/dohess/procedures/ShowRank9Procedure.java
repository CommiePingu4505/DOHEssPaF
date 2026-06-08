package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank9Procedure {
	public static String execute(IWorld world) {
		return "9: " + DohessModVariables.WorldVariables.get(world).Rank9.substring(43, (DohessModVariables.WorldVariables.get(world).Rank9).length() - 23);
	}
}