package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank2Procedure {
	public static String execute(IWorld world) {
		return "2: " + DohessModVariables.WorldVariables.get(world).Rank2.substring(43, (DohessModVariables.WorldVariables.get(world).Rank2).length() - 23);
	}
}