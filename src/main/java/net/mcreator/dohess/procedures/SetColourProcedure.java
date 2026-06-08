package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;

import java.util.ArrayList;

public class SetColourProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		for (Entity entityiterator : new ArrayList<>(world.getPlayers())) {
			if ((entityiterator.getCachedUniqueIdString()).equals((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).ChangingRankSquad)) {
				if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("dark_red")) {
					{
						String _setval = "red";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("red")) {
					{
						String _setval = "gold";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("gold")) {
					{
						String _setval = "yellow";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("yellow")) {
					{
						String _setval = "green";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("green")) {
					{
						String _setval = "dark_green";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("dark_green")) {
					{
						String _setval = "aqua";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("aqua")) {
					{
						String _setval = "dark_aqua";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("dark_aqua")) {
					{
						String _setval = "blue";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("blue")) {
					{
						String _setval = "dark_blue";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("dark_blue")) {
					{
						String _setval = "light_purple";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("light_purple")) {
					{
						String _setval = "dark_purple";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("dark_purple")) {
					{
						String _setval = "white";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("white")) {
					{
						String _setval = "gray";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("gray")) {
					{
						String _setval = "dark_gray";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("dark_gray")) {
					{
						String _setval = "black";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour).equals("black")) {
					{
						String _setval = "red";
						entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MCPlayerColour = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				}
				{
					Entity _ent = entityiterator;
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								("team modify " + (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
										+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
										+ ((entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2) + " color "
										+ (entityiterator.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerColour));
				}
			}
		}
	}
}