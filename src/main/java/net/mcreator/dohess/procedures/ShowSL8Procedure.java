package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowSL8Procedure {
	public static String execute(IWorld world) {
		return "8: " + DohessModVariables.WorldVariables.get(world).SL8.substring(41, (DohessModVariables.WorldVariables.get(world).SL8).length() - 21);
	}
}