package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;
import net.mcreator.dohess.init.DohessModMenus;
import net.mcreator.dohess.DohessMod;

public class PDMenuGUIThisGUIIsOpenedProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		DohessMod.queueServerWork(5, () -> {
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor)
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).sendMenuStateUpdate((PlayerEntity) entity, 0, "speedno",
						(new java.text.DecimalFormat("##").format((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PDSpeedNO)), true);
		});
	}
}