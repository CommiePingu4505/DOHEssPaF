package net.mcreator.dohess.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class SetTCIProcedure {
	public static void execute(CommandContext<CommandSource> arguments) {
		if (BoolArgumentType.getBool(arguments, "tci") == true) {
			{
				boolean _setval = true;
				(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.TCI = _setval;
					capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
				});
			}
		} else if (BoolArgumentType.getBool(arguments, "tci") == false) {
			{
				boolean _setval = false;
				(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.TCI = _setval;
					capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
				});
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