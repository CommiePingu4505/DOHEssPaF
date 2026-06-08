package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowSL5Procedure {
	public static String execute(IWorld world) {
		return "5: " + DohessModVariables.WorldVariables.get(world).SL5.substring(41, (DohessModVariables.WorldVariables.get(world).SL5).length() - 21);
	}
}