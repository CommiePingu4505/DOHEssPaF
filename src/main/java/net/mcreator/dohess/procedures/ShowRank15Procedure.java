package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank15Procedure {
	public static String execute(IWorld world) {
		return "15: " + DohessModVariables.WorldVariables.get(world).Rank15.substring(43, (DohessModVariables.WorldVariables.get(world).Rank15).length() - 23);
	}
}