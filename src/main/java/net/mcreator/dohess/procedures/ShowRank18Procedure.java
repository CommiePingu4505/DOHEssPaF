package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank18Procedure {
	public static String execute(IWorld world) {
		return "18: " + DohessModVariables.WorldVariables.get(world).Rank18.substring(43, (DohessModVariables.WorldVariables.get(world).Rank18).length() - 23);
	}
}