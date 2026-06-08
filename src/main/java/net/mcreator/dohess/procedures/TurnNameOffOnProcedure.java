package net.mcreator.dohess.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class TurnNameOffOnProcedure {
	public static void execute(CommandContext<CommandSource> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PDManager == true) {
			if (BoolArgumentType.getBool(arguments, "logic") == false) {
				{
					boolean _setval = false;
					(commandParameterEntity(arguments, "Username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NameVisibility = _setval;
						capability.syncPlayerVariables((commandParameterEntity(arguments, "Username")));
					});
				}
				{
					Entity _ent = (commandParameterEntity(arguments, "Username"));
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								("team modify " + ((commandParameterEntity(arguments, "Username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
										+ ((commandParameterEntity(arguments, "Username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
										+ (((commandParameterEntity(arguments, "Username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)
										+ " nametagVisibility never"));
				}
			} else if (BoolArgumentType.getBool(arguments, "logic") == true) {
				{
					boolean _setval = true;
					(commandParameterEntity(arguments, "Username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NameVisibility = _setval;
						capability.syncPlayerVariables((commandParameterEntity(arguments, "Username")));
					});
				}
				{
					Entity _ent = (commandParameterEntity(arguments, "Username"));
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								("team modify " + ((commandParameterEntity(arguments, "Username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
										+ ((commandParameterEntity(arguments, "Username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
										+ (((commandParameterEntity(arguments, "Username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)
										+ " nametagVisibility always"));
				}
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "tellraw @s {\"text\":\"Only PD Managers Have Access To This Cmd\",\"color\":\"dark_red\"}");
			}
		}
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