package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;

import java.util.ArrayList;

public class ReturnColourProcedure {
	public static String execute(IWorld world, Entity entity) {
		if (entity == null)
			return "";
		Entity player = null;
		for (Entity entityiterator : new ArrayList<>(world.getPlayers())) {
			if ((entityiterator.getCachedUniqueIdString()).equals((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).ChangingRankSquad)) {
				player = entityiterator;
			}
		}
		if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("dark_red")) {
			return "\u00A74Dark red";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("red")) {
			return "\u00A7cRed";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("gold")) {
			return "\u00A76Gold";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("yellow")) {
			return "\u00A7eYellow";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("green")) {
			return "\u00A7aGreen";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("dark_green")) {
			return "\u00A72Dark Green";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("aqua")) {
			return "\u00A7bAqua";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("dark_aqua")) {
			return "\u00A73Dark Aqua";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("blue")) {
			return "\u00A79Blue";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("dark_blue")) {
			return "\u00A71Dark Blue";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("light_purple")) {
			return "\u00A7dLight Purple";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("dark_purple")) {
			return "\u00A75Dark Purple";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("white")) {
			return "\u00A7fWhite";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("gray")) {
			return "\u00A77Gray";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("dark_gray")) {
			return "\u00A78Dark Gray";
		} else if (((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("black")) {
			return "\u00A70Black";
		}
		return "Null";
	}
}