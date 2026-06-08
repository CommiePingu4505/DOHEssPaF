package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class DistantHorsesProcedure {
	public static void execute(IWorld world, CommandContext<CommandSource> arguments, Entity entity) {
		if (entity == null)
			return;
		DohessModVariables.WorldVariables.get(world).HorseDistant = DoubleArgumentType.getDouble(arguments, "distantnumber");
		DohessModVariables.WorldVariables.get(world).syncData(world);
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						("tellraw @s [\"\",{\"text\":\"Distant of calling horses set to \",\"color\":\"green\"},{\"text\":\"" + "" + DoubleArgumentType.getDouble(arguments, "distantnumber") + "\",\"color\":\"aqua\"}]"));
		}
	}
}