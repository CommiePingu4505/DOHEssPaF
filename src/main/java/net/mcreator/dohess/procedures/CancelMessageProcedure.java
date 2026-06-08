package net.mcreator.dohess.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;

import javax.annotation.Nullable;

import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class CancelMessageProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer().world, event.getPlayer(), event.getMessage());
	}

	public static void execute(IWorld world, Entity entity, String text) {
		execute(null, world, entity, text);
	}

	private static void execute(@Nullable Event event, IWorld world, Entity entity, String text) {
		if (entity == null || text == null)
			return;
		if (DohessModVariables.WorldVariables.get(world).PD == 1) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
			{
				String _setval = text;
				entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerMessage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				final Vector3d _center = new Vector3d((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()));
				for (Entity entityiterator : world.getLoadedEntitiesWithinAABB(Entity.class, new AxisAlignedBB(_center, _center).grow(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.getDistanceSq(_center)))
						.collect(Collectors.toList())) {
					{
						Entity _ent = entityiterator;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("tellraw @s {\"text\":\"<" + "" + (entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser + "> "
											+ (entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerMessage + "\"}"));
					}
				}
			}
		} else if (DohessModVariables.WorldVariables.get(world).PD == 0) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
			{
				String _setval = text;
				entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerMessage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			for (Entity entityiterator : new ArrayList<>(world.getPlayers())) {
				{
					Entity _ent = entityiterator;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								("tellraw @s {\"text\":\"<" + "" + (entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser + "> "
										+ (entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerMessage + "\"}"));
				}
			}
		}
	}
}