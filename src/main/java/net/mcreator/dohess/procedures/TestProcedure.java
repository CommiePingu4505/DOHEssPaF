package net.mcreator.dohess.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.entity.GasCartEntity;
import net.mcreator.dohess.DohessMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TestProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != Hand.MAIN_HAND)
			return;
		execute(event, event.getWorld(), event.getTarget(), event.getPlayer());
	}

	public static void execute(IWorld world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, IWorld world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof GasCartEntity) {
			if ((sourceentity instanceof LivingEntity ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("wingsoffreedom:gas_cartridge"))) {
				if (entity.getPersistentData().getDouble("StoredGasCart") > 200) {
					DohessMod.queueServerWork(1, () -> {
						entity.getPersistentData().putDouble("StoredGasCart",
								(entity.getPersistentData().getDouble("StoredGasCart") - (200 - (sourceentity instanceof LivingEntity ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().getDouble("StoredGas"))));
						DohessMod.queueServerWork(1, () -> {
							(sourceentity instanceof LivingEntity ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putDouble("StoredGas", 200);
						});
					});
				} else if (entity.getPersistentData().getDouble("StoredGasCart") == 0) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "tellraw @s {\"text\":\"Tank Is Empty!\",\"color\":\"dark_red\"}");
					}
				} else if (entity.getPersistentData().getDouble("StoredGasCart") < 200 || entity.getPersistentData().getDouble("StoredGasCart") == 200) {
					DohessMod.queueServerWork(1, () -> {
						(sourceentity instanceof LivingEntity ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putDouble("StoredGas", (entity.getPersistentData().getDouble("StoredGasCart")));
						DohessMod.queueServerWork(1, () -> {
							entity.getPersistentData().putDouble("StoredGasCart", 0);
							DohessMod.queueServerWork(1, () -> {
								entity.setCustomName(new StringTextComponent("\u00A74Empty"));
							});
						});
					});
				}
			}
		}
	}
}