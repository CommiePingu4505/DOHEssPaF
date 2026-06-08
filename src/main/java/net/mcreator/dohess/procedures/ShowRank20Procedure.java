package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank20Procedure {
	public static String execute(IWorld world) {
		return "20: " + DohessModVariables.WorldVariables.get(world).Rank20.substring(43, (DohessModVariables.WorldVariables.get(world).Rank20).length() - 23);
	}
}