package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;

import java.util.ArrayList;

public class ReturnTCIProcedure {
	public static String execute(IWorld world, Entity entity) {
		if (entity == null)
			return "";
		Entity player = null;
		for (Entity entityiterator : new ArrayList<>(world.getPlayers())) {
			if ((entityiterator.getCachedUniqueIdString()).equals((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).ChangingRankSquad)) {
				player = entityiterator;
			}
		}
		if ((player.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).TCI == true) {
			return "\u00A7fTCI :\u00A7aOn";
		}
		return "\u00A7fTCI:\u00A7cOff";
	}
}