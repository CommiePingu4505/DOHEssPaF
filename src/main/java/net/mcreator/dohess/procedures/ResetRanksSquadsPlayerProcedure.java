package net.mcreator.dohess.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class ResetRanksSquadsPlayerProcedure {
	public static void execute(CommandContext<CommandSource> arguments) {
		{
			String _setval = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
			(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MCPlayerRank = _setval;
				capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
			});
		}
		{
			String _setval = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
			(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MCPlayerSquad = _setval;
				capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
			});
		}
		{
			String _setval = "white";
			(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MCPlayerColour = _setval;
				capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
			});
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