package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank7Procedure {
	public static String execute(IWorld world) {
		return "7: " + DohessModVariables.WorldVariables.get(world).Rank7.substring(43, (DohessModVariables.WorldVariables.get(world).Rank7).length() - 23);
	}
}