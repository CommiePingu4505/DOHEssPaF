package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;
import net.mcreator.dohess.DohessMod;

import java.util.ArrayList;

public class ResetRankSquadProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		Entity t = null;
		for (Entity entityiterator : new ArrayList<>(world.getPlayers())) {
			if ((entityiterator.getCachedUniqueIdString()).equals((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).ChangingRankSquad)) {
				{
					Entity _ent = entityiterator;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								("team remove " + (entity instanceof LivingEntity && ((LivingEntity) entity).world.getScoreboard()
										.getPlayersTeam(((LivingEntity) entity) instanceof PlayerEntity ? ((PlayerEntity) ((LivingEntity) entity)).getGameProfile().getName() : ((LivingEntity) entity).getCachedUniqueIdString()) != null
												? ((LivingEntity) entity).world.getScoreboard()
														.getPlayersTeam(((LivingEntity) entity) instanceof PlayerEntity ? ((PlayerEntity) ((LivingEntity) entity)).getGameProfile().getName() : ((LivingEntity) entity).getCachedUniqueIdString())
														.getName()
												: "")));
				}
				DohessMod.queueServerWork(1, () -> {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("team add " + (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
											+ ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(3)));
					}
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("team join " + (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
											+ ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(3)));
					}
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("team modify " + (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
											+ ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(3) + " color "
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour));
					}
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("team modify " + (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
											+ ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(3) + " prefix "
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquad
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRank));
					}
				});
			}
		}
	}
}