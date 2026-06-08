package net.mcreator.dohess.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

public class GasCartTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth(40);
		if (entity.getPersistentData().getDouble("StoredGasCart") == 4000) {
			entity.setCustomName(new StringTextComponent(("\u00A7b" + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("StoredGasCart")))));
		} else if (entity.getPersistentData().getDouble("StoredGasCart") > 3000) {
			entity.setCustomName(new StringTextComponent(("\u00A7a" + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("StoredGasCart")))));
		} else if (entity.getPersistentData().getDouble("StoredGasCart") > 2000) {
			entity.setCustomName(new StringTextComponent(("\u00A7e" + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("StoredGasCart")))));
		} else if (entity.getPersistentData().getDouble("StoredGasCart") > 1000) {
			entity.setCustomName(new StringTextComponent(("\u00A76" + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("StoredGasCart")))));
		} else if (entity.getPersistentData().getDouble("StoredGasCart") > 1) {
			entity.setCustomName(new StringTextComponent(("\u00A7c" + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("StoredGasCart")))));
		}
	}
}