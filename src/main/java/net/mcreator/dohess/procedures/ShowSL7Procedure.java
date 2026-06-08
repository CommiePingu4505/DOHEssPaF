package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowSL7Procedure {
	public static String execute(IWorld world) {
		return "7: " + DohessModVariables.WorldVariables.get(world).SL7.substring(41, (DohessModVariables.WorldVariables.get(world).SL7).length() - 21);
	}
}