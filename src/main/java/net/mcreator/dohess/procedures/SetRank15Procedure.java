package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;
import net.mcreator.dohess.DohessMod;

import java.util.ArrayList;

public class SetRank15Procedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		Entity t = null;
		for (Entity entityiterator : new ArrayList<>(world.getPlayers())) {
			if ((entityiterator.getCachedUniqueIdString()).equals((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).ChangingRankSquad)) {
				{
					String _setval = DohessModVariables.WorldVariables.get(world).Rank15;
					entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MCPlayerRank = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				{
					String _setval = "o";
					entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MCPlayerRankPri = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				{
					Entity _ent = entityiterator;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								("team remove " + (entityiterator instanceof LivingEntity && ((LivingEntity) entityiterator).world.getScoreboard().getPlayersTeam(
										((LivingEntity) entityiterator) instanceof PlayerEntity ? ((PlayerEntity) ((LivingEntity) entityiterator)).getGameProfile().getName() : ((LivingEntity) entityiterator).getCachedUniqueIdString()) != null
												? ((LivingEntity) entityiterator).world.getScoreboard().getPlayersTeam(
														((LivingEntity) entityiterator) instanceof PlayerEntity ? ((PlayerEntity) ((LivingEntity) entityiterator)).getGameProfile().getName() : ((LivingEntity) entityiterator).getCachedUniqueIdString())
														.getName()
												: "")));
				}
				DohessMod.queueServerWork(1, () -> {
					{
						Entity _ent = entityiterator;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("team add " + (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
											+ ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)));
					}
					{
						Entity _ent = entityiterator;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("team join " + (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
											+ ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)));
					}
					{
						Entity _ent = entityiterator;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("team modify " + (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
											+ ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2) + " color "
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour));
					}
					{
						Entity _ent = entityiterator;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("team modify " + (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
											+ ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2) + " prefix "
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquad
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRank));
					}
				});
			}
		}
	}
}