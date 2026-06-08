package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank10Procedure {
	public static String execute(IWorld world) {
		return "10: " + DohessModVariables.WorldVariables.get(world).Rank10.substring(43, (DohessModVariables.WorldVariables.get(world).Rank10).length() - 23);
	}
}