package net.mcreator.dohess.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;
import net.mcreator.dohess.DohessMod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class SetCadetScoutProcedure {
	public static void execute(IWorld world, CommandContext<CommandSource> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).TCI == true) {
			{
				String _setval = DohessModVariables.WorldVariables.get(world).Rank20;
				(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MCPlayerRank = _setval;
					capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
				});
			}
			{
				String _setval = "t";
				(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MCPlayerRankPri = _setval;
					capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
				});
			}
			{
				String _setval = DohessModVariables.WorldVariables.get(world).SL8;
				(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MCPlayerSquad = _setval;
					capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
				});
			}
			{
				String _setval = "h";
				(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MCPlayerSquadPri = _setval;
					capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
				});
			}
			{
				String _setval = "blue";
				(commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MCPlayerColour = _setval;
					capability.syncPlayerVariables((commandParameterEntity(arguments, "username")));
				});
			}
			{
				Entity _entity = (commandParameterEntity(arguments, "username"));
				if (_entity instanceof PlayerEntity) {
					((PlayerEntity) _entity).inventory.armorInventory.set(2, DohessModVariables.WorldVariables.get(world).SLJacket);
					((PlayerEntity) _entity).inventory.markDirty();
				} else if (_entity instanceof LivingEntity) {
					((LivingEntity) _entity).setItemStackToSlot(EquipmentSlotType.CHEST, DohessModVariables.WorldVariables.get(world).SLJacket);
				}
			}
			if ((commandParameterEntity(arguments, "username")) instanceof PlayerEntity) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).SLCape.copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) (commandParameterEntity(arguments, "username"))), _setstack);
			}
			if ((commandParameterEntity(arguments, "username")) instanceof PlayerEntity) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).SLFormal.copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) (commandParameterEntity(arguments, "username"))), _setstack);
			}
			{
				Entity _ent = (commandParameterEntity(arguments, "username"));
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							("team remove " + ((commandParameterEntity(arguments, "username")) instanceof LivingEntity && ((LivingEntity) (commandParameterEntity(arguments, "username"))).world.getScoreboard()
									.getPlayersTeam(((LivingEntity) (commandParameterEntity(arguments, "username"))) instanceof PlayerEntity
											? ((PlayerEntity) ((LivingEntity) (commandParameterEntity(arguments, "username")))).getGameProfile().getName()
											: ((LivingEntity) (commandParameterEntity(arguments, "username"))).getCachedUniqueIdString()) != null
													? ((LivingEntity) (commandParameterEntity(arguments, "username"))).world.getScoreboard()
															.getPlayersTeam(((LivingEntity) (commandParameterEntity(arguments, "username"))) instanceof PlayerEntity
																	? ((PlayerEntity) ((LivingEntity) (commandParameterEntity(arguments, "username")))).getGameProfile().getName()
																	: ((LivingEntity) (commandParameterEntity(arguments, "username"))).getCachedUniqueIdString())
															.getName()
													: "")));
			}
			DohessMod.queueServerWork(1, () -> {
				{
					Entity _ent = (commandParameterEntity(arguments, "username"));
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), ("team add "
								+ ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
								+ ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
								+ (((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)));
				}
				{
					Entity _ent = (commandParameterEntity(arguments, "username"));
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), ("team join "
								+ ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
								+ ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
								+ (((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)));
				}
				{
					Entity _ent = (commandParameterEntity(arguments, "username"));
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								("team modify " + ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
										+ ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
										+ (((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)
										+ " color blue"));
				}
				{
					Entity _ent = (commandParameterEntity(arguments, "username"));
					if (!_ent.world.isRemote() && _ent.world.getServer() != null)
						_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								("team modify " + ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquadPri
										+ ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri
										+ (((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).toLowerCase().substring(2)
										+ " prefix " + ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerSquad
										+ ((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRank));
				}
			});
		} else {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "tellraw @s {\"text\":\"Only TCI's can use this cmd\",\"color\":\"red\"}");
			}
		}
	}

	private static Entity commandParameterEntity(CommandContext<CommandSource> arguments, String parameter) {
		try {
			return EntityArgument.getEntity(arguments, parameter);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}