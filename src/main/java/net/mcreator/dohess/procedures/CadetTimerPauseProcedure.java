package net.mcreator.dohess.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;

public class CadetTimerPauseProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).TCI == true) {
			if (DohessModVariables.WorldVariables.get(world).PauseTimerCadets == true) {
				DohessModVariables.WorldVariables.get(world).PauseTimerCadets = false;
				DohessModVariables.WorldVariables.get(world).syncData(world);
				if (world instanceof ServerWorld)
					((ServerWorld) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
							("bossbar set minecraft:69 name [\"\",{\"text\":\"Cadet Timer: \",\"color\":\"gold\"},{\"text\":\"" + "" + new java.text.DecimalFormat("##").format(DohessModVariables.WorldVariables.get(world).CadetTimerNumber)
									+ " \",\"color\":\"aqua\"},{\"text\":\"[\",\"color\":\"dark_purple\"},{\"text\":\"Paused\",\"color\":\"light_purple\"},{\"text\":\"]\",\"color\":\"dark_purple\"}]"));
			} else if (DohessModVariables.WorldVariables.get(world).PauseTimerCadets == false) {
				DohessModVariables.WorldVariables.get(world).PauseTimerCadets = true;
				DohessModVariables.WorldVariables.get(world).syncData(world);
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "tellraw @s {\"text\":\"Only TCI's can use this cmd\",\"color\":\"red\"}");
			}
		}
	}
}