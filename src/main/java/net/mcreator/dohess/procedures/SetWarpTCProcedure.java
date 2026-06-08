package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;

public class SetWarpTCProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		DohessModVariables.WorldVariables.get(world).WarpTc = entity.getPosX() + " " + entity.getPosY() + " " + entity.getPosZ();
		DohessModVariables.WorldVariables.get(world).syncData(world);
	}
}