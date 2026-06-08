package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank3Procedure {
	public static String execute(IWorld world) {
		return "3: " + DohessModVariables.WorldVariables.get(world).Rank3.substring(43, (DohessModVariables.WorldVariables.get(world).Rank3).length() - 23);
	}
}