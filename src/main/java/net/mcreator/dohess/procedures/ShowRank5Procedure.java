package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank5Procedure {
	public static String execute(IWorld world) {
		return "5: " + DohessModVariables.WorldVariables.get(world).Rank5.substring(43, (DohessModVariables.WorldVariables.get(world).Rank5).length() - 23);
	}
}