package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.command.arguments.MessageArgument;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class SetPDDeathMessageProcedure {
	public static void execute(IWorld world, CommandContext<CommandSource> arguments) {
		DohessModVariables.WorldVariables.get(world).DeathMessageOnDeath = commandParameterMessage(arguments, "SetMessage");
		DohessModVariables.WorldVariables.get(world).syncData(world);
	}

	private static String commandParameterMessage(CommandContext<CommandSource> arguments, String parameter) {
		try {
			return MessageArgument.getMessage(arguments, parameter).getString();
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return "";
		}
	}
}