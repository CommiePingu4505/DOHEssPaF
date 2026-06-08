package net.mcreator.dohess.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BladeBreakProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().world, event.getSource().getTrueSource());
		}
	}

	public static void execute(IWorld world, Entity sourceentity) {
		execute(null, world, sourceentity);
	}

	private static void execute(@Nullable Event event, IWorld world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("wingsoffreedom:tdmg_handle"))
				&& (sourceentity instanceof LivingEntity ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("wingsoffreedom:tdmg_handle"))) {
			(sourceentity instanceof LivingEntity ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.setDamage((int) ((sourceentity instanceof LivingEntity ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY).getDamage() + DohessModVariables.WorldVariables.get(world).BladeDamage));
			(sourceentity instanceof LivingEntity ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY)
					.setDamage((int) ((sourceentity instanceof LivingEntity ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY).getDamage() + DohessModVariables.WorldVariables.get(world).BladeDamage));
		}
	}
}