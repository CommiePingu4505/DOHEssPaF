package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;
import net.mcreator.dohess.DohessMod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class SetCadetProcedure {
	public static void execute(IWorld world, CommandContext<CommandSource> arguments) {
		{
			String _setval = DohessModVariables.WorldVariables.get(world).CadetRank;
			(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MCPlayerRank = _setval;
				capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
			});
		}
		{
			String _setval = "y";
			(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MCPlayerRankPri = _setval;
				capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
			});
		}
		{
			String _setval = DohessModVariables.WorldVariables.get(world).CadetSquad;
			(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MCPlayerSquad = _setval;
				capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
			});
		}
		{
			String _setval = "y";
			(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MCPlayerSquadPri = _setval;
				capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
			});
		}
		{
			String _setval = "gold";
			(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MCPlayerColour = _setval;
				capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
			});
		}
		{
			Entity _ent = (commandParameterEntity(arguments, "username"));
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						("team remove " + ((commandParameterEntity(arguments, "username")) instanceof LivingEntity && ((LivingEntity) (commandParameterEntity(arguments, "username"))).world.getScoreboard()
								.getPlayersTeam(((LivingEntity) (commandParameterEntity(arguments, "username"))) instanceof PlayerEntity
										? ((PlayerEntity) ((LivingEntity) (commandParameterEntity(arguments, "username")))).getGameProfile().getName()
										: ((LivingEntity) (commandParameterEntity(arguments, "username"))).getCachedUniqueIdString()) != null
												? ((LivingEntity) (commandParameterEntity(arguments, "username"))).world.getScoreboard()
														.getPlayersTeam(((LivingEntity) (commandParameterEntity(arguments, "username"))) instanceof PlayerEntity
																? ((PlayerEntity) ((LivingEntity) (commandParameterEntity(arguments, "username")))).getGameProfile().getName()
																: ((LivingEntity) (commandParameterEntity(arguments, "username"))).getCachedUniqueIdString())
														.getName()
												: "")));
		}
		DohessMod.queueServerWork(1, () -> {
			{
				Entity _ent = (commandParameterEntity(arguments, "username"));
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							("team add " + ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
									+ ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
									+ (((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)));
			}
			{
				Entity _ent = (commandParameterEntity(arguments, "username"));
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							("team join " + ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
									+ ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
									+ (((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)));
			}
			{
				Entity _ent = (commandParameterEntity(arguments, "username"));
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							("team modify " + ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
									+ ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
									+ (((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)
									+ " color gold"));
			}
			{
				Entity _ent = (commandParameterEntity(arguments, "username"));
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager()
							.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("team modify " + ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
											+ ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
											+ (((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(
													2)
											+ " prefix " + ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquad
											+ ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRank));
			}
		});
	}

	private static Entity commandParameterEntity(CommandContext<CommandSource> arguments, String parameter) {
		try {
			return EntityArgument.getEntity(arguments, parameter);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}