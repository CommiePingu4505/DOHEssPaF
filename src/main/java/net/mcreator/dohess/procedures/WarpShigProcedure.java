package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;

public class WarpShigProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		if (DohessModVariables.WorldVariables.get(world).PD == 0) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), ("tp " + DohessModVariables.WorldVariables.get(world).WarpShig));
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "tellraw @s {\"text\":\"You cannot warp during PD\",\"color\":\"dark_red\"}");
			}
		}
	}
}