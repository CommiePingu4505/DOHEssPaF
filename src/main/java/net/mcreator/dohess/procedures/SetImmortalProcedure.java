package net.mcreator.dohess.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;

public class SetImmortalProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PDImmortal == true) {
			{
				boolean _setval = false;
				entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PDImmortal = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PDImmortal == false) {
			{
				boolean _setval = true;
				entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PDImmortal = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}