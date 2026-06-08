package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank8Procedure {
	public static String execute(IWorld world) {
		return "8: " + DohessModVariables.WorldVariables.get(world).Rank8.substring(43, (DohessModVariables.WorldVariables.get(world).Rank8).length() - 23);
	}
}