package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowSL6Procedure {
	public static String execute(IWorld world) {
		return "6: " + DohessModVariables.WorldVariables.get(world).SL6.substring(41, (DohessModVariables.WorldVariables.get(world).SL6).length() - 21);
	}
}