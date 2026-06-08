package net.mcreator.dohess.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameRules;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;

public class PDOffProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PDManager == true) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							("discordsrv broadcast PD Is Disabled By:" + (entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser));
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), ("tellraw @a [\"\",{\"text\":\"PD Disabled By: \",\"color\":\"green\"},{\"text\":\"" + ""
							+ (entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser + "\",\"color\":\"aqua\"}]"));
			}
			if (world instanceof World)
				((World) world).getGameRules().get(GameRules.DO_IMMEDIATE_RESPAWN).set(true, ((World) world).getServer());
			if (world instanceof World)
				((World) world).getGameRules().get(GameRules.SHOW_DEATH_MESSAGES).set(true, ((World) world).getServer());
			if (world instanceof World)
				((World) world).getGameRules().get(GameRules.KEEP_INVENTORY).set(true, ((World) world).getServer());
			DohessModVariables.WorldVariables.get(world).PD = 0;
			DohessModVariables.WorldVariables.get(world).syncData(world);
		} else {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "tellraw @s {\"text\":\"Only PD Managers Have Access To This Cmd\",\"color\":\"dark_red\"}");
			}
		}
	}
}