package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowSL2Procedure {
	public static String execute(IWorld world) {
		return "2: " + DohessModVariables.WorldVariables.get(world).SL2.substring(41, (DohessModVariables.WorldVariables.get(world).SL2).length() - 21);
	}
}