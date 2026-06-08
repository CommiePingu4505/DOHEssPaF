package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank14Procedure {
	public static String execute(IWorld world) {
		return "14: " + DohessModVariables.WorldVariables.get(world).Rank14.substring(43, (DohessModVariables.WorldVariables.get(world).Rank14).length() - 23);
	}
}