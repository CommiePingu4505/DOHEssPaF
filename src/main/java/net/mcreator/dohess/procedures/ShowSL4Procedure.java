package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.dohess.network.DohessModVariables;

public class ShowSL4Procedure {
	public static String execute(IWorld world) {
		return "4: " + DohessModVariables.WorldVariables.get(world).SL4.substring(41, (DohessModVariables.WorldVariables.get(world).SL4).length() - 21);
	}
}