package net.mcreator.dohess.procedures;

import net.minecraft.entity.Entity;

public class SpawnValentinaRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "function snc:auxiliar/spawn/valentina");
		}
	}
}