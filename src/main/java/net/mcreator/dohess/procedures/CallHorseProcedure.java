package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;

import java.util.stream.Collectors;
import java.util.Comparator;

public class CallHorseProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		{
			final Vector3d _center = new Vector3d((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()));
			for (Entity entityiterator : world.getLoadedEntitiesWithinAABB(Entity.class, new AxisAlignedBB(_center, _center).grow(DohessModVariables.WorldVariables.get(world).HorseDistant / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.getDistanceSq(_center))).collect(Collectors.toList())) {
				if ((entityiterator.getCachedUniqueIdString()).equals((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).HorseID)) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), ("tp " + entityiterator.getCachedUniqueIdString() + " @s"));
					}
				}
			}
		}
	}
}