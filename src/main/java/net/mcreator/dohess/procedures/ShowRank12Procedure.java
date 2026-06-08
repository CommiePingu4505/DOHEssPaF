package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowRank12Procedure {
	public static String execute(IWorld world) {
		return "12: " + DohessModVariables.WorldVariables.get(world).Rank12.substring(43, (DohessModVariables.WorldVariables.get(world).Rank12).length() - 23);
	}
}