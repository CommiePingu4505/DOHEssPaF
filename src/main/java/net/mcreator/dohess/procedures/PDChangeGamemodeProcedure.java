package net.mcreator.dohess.procedures;

import net.minecraft.world.GameType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.Minecraft;

public class PDChangeGamemodeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (getEntityGameType(entity) == GameType.SURVIVAL) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).setGameType(GameType.CREATIVE);
		} else if (getEntityGameType(entity) == GameType.CREATIVE) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).setGameType(GameType.SPECTATOR);
		} else if (getEntityGameType(entity) == GameType.SPECTATOR) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).setGameType(GameType.SURVIVAL);
		}
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