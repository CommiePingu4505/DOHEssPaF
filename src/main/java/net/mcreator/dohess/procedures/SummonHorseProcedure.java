package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;
import net.mcreator.dohess.DohessMod;

import java.util.stream.Collectors;
import java.util.Comparator;

public class SummonHorseProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		if (DohessModVariables.WorldVariables.get(world).PD == 0) {
			{
				final Vector3d _center = new Vector3d((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()));
				for (Entity entityiterator : world.getLoadedEntitiesWithinAABB(Entity.class, new AxisAlignedBB(_center, _center).grow(DohessModVariables.WorldVariables.get(world).HorseDistant / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.getDistanceSq(_center))).collect(Collectors.toList())) {
					if ((entityiterator.getCachedUniqueIdString()).equals((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).HorseID)) {
						DohessMod.queueServerWork(3, () -> {
							if (!entityiterator.world.isRemote())
								entityiterator.remove();
						});
					} else {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote() && _ent.world.getServer() != null)
								_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
										("kill " + (entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).HorseID));
						}
					}
				}
			}
			DohessMod.queueServerWork(1, () -> {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), ("summon horse ~ ~ ~ {Variant:5,Tame:1,CustomName:'[{\"text\":\"" + ""
								+ entity.getCachedUniqueIdString() + "\"}]',Attributes:[{Name:\"generic.movement_speed\",Base:" + DohessModVariables.WorldVariables.get(world).HorsesPEED + "7f}],SaddleItem:{id:saddle,Count:1}}"));
				}
				{
					final Vector3d _center = new Vector3d((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()));
					for (Entity entityiterator : world.getLoadedEntitiesWithinAABB(Entity.class, new AxisAlignedBB(_center, _center).grow(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.getDistanceSq(_center)))
							.collect(Collectors.toList())) {
						if ((entityiterator.getDisplayName().getString()).equals(entity.getCachedUniqueIdString())) {
							{
								String _setval = entityiterator.getCachedUniqueIdString();
								entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.HorseID = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							entityiterator.setCustomName(new StringTextComponent(((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).HorseName)));
						}
					}
				}
			});
		} else {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "tellraw @s {\"text\":\"You cannot recall your horse during PD\",\"color\":\"dark_red\"}");
			}
		}
	}
}