package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;

import java.util.ArrayList;

public class SetUsernameShownProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		for (Entity entityiterator : new ArrayList<>(world.getPlayers())) {
			if ((entityiterator.getCachedUniqueIdString()).equals((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).ChangingRankSquad)) {
				if ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).NameVisibility == true) {
					{
						boolean _setval = false;
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.NameVisibility = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						Entity _ent = entityiterator;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("team modify " + (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
											+ ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)
											+ " nametagVisibility never"));
					}
				} else if ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).NameVisibility == false) {
					{
						boolean _setval = true;
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.NameVisibility = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						Entity _ent = entityiterator;
						if (!_ent.world.isRemote() && _ent.world.getServer() != null)
							_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									("team modify " + (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
											+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
											+ ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)
											+ " nametagVisibility always"));
					}
				}
			}
		}
	}
}