package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class SetCadetSquadProcedure {
	public static void execute(IWorld world, CommandContext<CommandSource> arguments, Entity entity) {
		if (entity == null)
			return;
		DohessModVariables.WorldVariables.get(world).CadetSquad = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "squadname") + "\",\"color\":\"#"
				+ StringArgumentType.getString(arguments, "squadhex") + "\"},";
		DohessModVariables.WorldVariables.get(world).syncData(world);
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), ("tellraw @s [\"\",{\"text\":\"Changed Cadet Squad To\",\"color\":\"aqua\"},{\"text\":\"" + ""
						+ StringArgumentType.getString(arguments, "squadname") + " \",\"color\":\"" + StringArgumentType.getString(arguments, "squadhex") + "\"}]"));
		}
	}
}