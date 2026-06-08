package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank19Procedure {
	public static String execute(IWorld world) {
		return "19: " + DohessModVariables.WorldVariables.get(world).Rank19.substring(43, (DohessModVariables.WorldVariables.get(world).Rank19).length() - 23);
	}
}