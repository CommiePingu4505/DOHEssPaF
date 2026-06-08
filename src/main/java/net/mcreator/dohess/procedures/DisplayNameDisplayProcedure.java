package net.mcreator.dohess.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;

public class DisplayNameDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).NameVisibility == true) {
			return "\u00A7fUsername:\u00A7aOn";
		}
		return "\u00A7fUsername:\u00A7cOff";
	}
}