package net.mcreator.dohess.procedures;

import net.minecraft.util.HandSide;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.init.DohessModItems;

public class SelfHarmProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (net.minecraftforge.fml.ModList.get().isLoaded("firstaid")) {
			if (entity instanceof LivingEntity && ((LivingEntity) entity).getPrimaryHand() == HandSide.LEFT) {
				if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == DohessModItems.KNIFE.get()) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "damagePart RIGHT_ARM 1");
					}
				} else if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == DohessModItems.KNIFE.get()) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "damagePart LEFT_ARM 1");
					}
				}
			} else if (entity instanceof LivingEntity && ((LivingEntity) entity).getPrimaryHand() == HandSide.RIGHT) {
				if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == DohessModItems.KNIFE.get()) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "damagePart LEFT_ARM 1");
					}
				} else if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == DohessModItems.KNIFE.get()) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "damagePart RIGHT_ARM 1");
					}
				}
			}
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((entity instanceof LivingEntity ? ((LivingEntity) entity).getHealth() : -1) - 2);
		}
	}
}