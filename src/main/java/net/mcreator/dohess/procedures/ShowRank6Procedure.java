package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank6Procedure {
	public static String execute(IWorld world) {
		return "6: " + DohessModVariables.WorldVariables.get(world).Rank6.substring(43, (DohessModVariables.WorldVariables.get(world).Rank6).length() - 23);
	}
}