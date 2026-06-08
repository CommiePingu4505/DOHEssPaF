package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowSL3Procedure {
	public static String execute(IWorld world) {
		return "3: " + DohessModVariables.WorldVariables.get(world).SL3.substring(41, (DohessModVariables.WorldVariables.get(world).SL3).length() - 21);
	}
}