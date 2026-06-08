package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank17Procedure {
	public static String execute(IWorld world) {
		return "17: " + DohessModVariables.WorldVariables.get(world).Rank17.substring(43, (DohessModVariables.WorldVariables.get(world).Rank17).length() - 23);
	}
}