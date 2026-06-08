package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank4Procedure {
	public static String execute(IWorld world) {
		return "4: " + DohessModVariables.WorldVariables.get(world).Rank4.substring(43, (DohessModVariables.WorldVariables.get(world).Rank4).length() - 23);
	}
}