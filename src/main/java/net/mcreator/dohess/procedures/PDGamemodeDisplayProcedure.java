package net.mcreator.dohess.procedures;

import net.minecraft.world.GameType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.Minecraft;

public class PDGamemodeDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (getEntityGameType(entity) == GameType.SURVIVAL) {
			return "\u00A7cSurvival";
		} else if (getEntityGameType(entity) == GameType.CREATIVE) {
			return "\u00A73Creative";
		} else if (getEntityGameType(entity) == GameType.SPECTATOR) {
			return "\u00A77Spectator";
		}
		return "Null";
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayerEntity) {
			return ((ServerPlayerEntity) entity).interactionManager.getGameType();
		} else if (entity instanceof PlayerEntity && ((PlayerEntity) entity).world.isRemote()) {
			NetworkPlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(((PlayerEntity) entity).getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameType();
		}
		return null;
	}
}