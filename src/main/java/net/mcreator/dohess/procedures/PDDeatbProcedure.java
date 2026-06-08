package net.mcreator.dohess.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;
import net.mcreator.dohess.DohessMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PDDeatbProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().world, event.getEntity());
		}
	}

	public static void execute(IWorld world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, IWorld world, Entity entity) {
		if (entity == null)
			return;
		if (DohessModVariables.WorldVariables.get(world).PD == 1) {
			if (entity instanceof PlayerEntity) {
				DohessMod.queueServerWork(2, () -> {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).setGameType(GameType.SPECTATOR);
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("tellraw @s {\"text\":\"" + "" + DohessModVariables.WorldVariables.get(world).DeathMessageOnDeath + "\",\"color\":\"dark_red\"}"));
					}
				});
			}
		}
	}
}