package net.mcreator.dohess.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LeaveProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
		execute(event, event.getPlayer());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						("team remove " + (entity instanceof LivingEntity && ((LivingEntity) entity).world.getScoreboard()
								.getPlayersTeam(((LivingEntity) entity) instanceof PlayerEntity ? ((PlayerEntity) ((LivingEntity) entity)).getGameProfile().getName() : ((LivingEntity) entity).getCachedUniqueIdString()) != null
										? ((LivingEntity) entity).world.getScoreboard()
												.getPlayersTeam(((LivingEntity) entity) instanceof PlayerEntity ? ((PlayerEntity) ((LivingEntity) entity)).getGameProfile().getName() : ((LivingEntity) entity).getCachedUniqueIdString()).getName()
										: "")));
		}
	}
}