package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowSL1Procedure {
	public static String execute(IWorld world) {
		return "1: " + DohessModVariables.WorldVariables.get(world).SL1.substring(41, (DohessModVariables.WorldVariables.get(world).SL1).length() - 21);
	}
}