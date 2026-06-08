package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.DohessMod;

import java.util.stream.Collectors;
import java.util.Comparator;

public class GasCartSpawnProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		entity.setCustomName(new StringTextComponent("4000"));
		entity.getPersistentData().putDouble("StoredGasCart", 4000);
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null)
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						("summon astikorcarts:animal_cart ~ ~ ~ {CustomName:\"\\\"" + "" + entity.getCachedUniqueIdString() + "\\\"\",CustomNameVisible:1}"));
		}
		DohessMod.queueServerWork(2, () -> {
			{
				final Vector3d _center = new Vector3d((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()));
				for (Entity entityiterator : world.getLoadedEntitiesWithinAABB(Entity.class, new AxisAlignedBB(_center, _center).grow(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.getDistanceSq(_center)))
						.collect(Collectors.toList())) {
					if ((entity.getCachedUniqueIdString()).equals(entityiterator.getDisplayName().getString())) {
						entity.startRiding(entityiterator);
						entityiterator.setCustomName(new StringTextComponent("Gas Supply Cart"));
					}
				}
			}
		});
	}
}