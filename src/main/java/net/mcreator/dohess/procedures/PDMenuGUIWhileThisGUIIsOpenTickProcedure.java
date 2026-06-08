package net.mcreator.dohess.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;
import net.mcreator.dohess.init.DohessModMenus;

public class PDMenuGUIWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) ? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getMenuState(0, "speedno", "") : "");
			entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PDSpeedNO = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}