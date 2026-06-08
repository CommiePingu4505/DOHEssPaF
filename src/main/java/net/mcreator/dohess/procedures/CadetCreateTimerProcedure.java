package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;
import net.mcreator.dohess.DohessMod;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CadetCreateTimerProcedure {
	public static void execute(IWorld world, CommandContext<CommandSource> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).TCI == true) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							("bossbar add 69 [\"\",{\"text\":\"Cadet Timer: \",\"color\":\"gold\"},{\"text\":\"" + "" + DoubleArgumentType.getDouble(arguments, "time") + "\",\"color\":\"aqua\"}]"));
			}
			DohessModVariables.WorldVariables.get(world).PauseTimerCadets = true;
			DohessModVariables.WorldVariables.get(world).syncData(world);
			DohessModVariables.WorldVariables.get(world).CadetTimerNumber = DoubleArgumentType.getDouble(arguments, "time");
			DohessModVariables.WorldVariables.get(world).syncData(world);
			DohessMod.queueServerWork(1, () -> {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								("bossbar set minecraft:69 max " + new java.text.DecimalFormat("##").format(DoubleArgumentType.getDouble(arguments, "time"))));
				}
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), ("bossbar set minecraft:69 value " + DoubleArgumentType.getDouble(arguments, "time")));
				}
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "bossbar set minecraft:69 players @a");
				}
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "bossbar set minecraft:69 color yellow");
				}
			});
		} else {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "tellraw @s {\"text\":\"Only TCI's can use this cmd\",\"color\":\"red\"}");
			}
		}
	}
}