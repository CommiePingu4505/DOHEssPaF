package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetDmgProcedure {
	public static void execute(IWorld world, CommandContext<CommandSource> arguments) {
		DohessModVariables.WorldVariables.get(world).BladeDamage = DoubleArgumentType.getDouble(arguments, "number");
		DohessModVariables.WorldVariables.get(world).syncData(world);
	}
}