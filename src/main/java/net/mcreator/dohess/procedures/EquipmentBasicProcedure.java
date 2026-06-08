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

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class EquipmentBasicProcedure {
	public static void execute(IWorld world, CommandContext<CommandSource> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).TCI == true) {
			if ((((commandParameterEntity(arguments, "username")).getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).MCPlayerRankPri).equals("y")) {
				if ((commandParameterEntity(arguments, "username")) instanceof PlayerEntity) {
					ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot1.copy();
					_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) (commandParameterEntity(arguments, "username"))), _setstack);
				}
				if ((commandParameterEntity(arguments, "username")) instanceof PlayerEntity) {
					ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot2.copy();
					_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo2);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) (commandParameterEntity(arguments, "username"))), _setstack);
				}
				if ((commandParameterEntity(arguments, "username")) instanceof PlayerEntity) {
					ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot3.copy();
					_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo3);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) (commandParameterEntity(arguments, "username"))), _setstack);
				}
				if ((commandParameterEntity(arguments, "username")) instanceof PlayerEntity) {
					ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot4.copy();
					_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo4);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) (commandParameterEntity(arguments, "username"))), _setstack);
				}
				if ((commandParameterEntity(arguments, "username")) instanceof PlayerEntity) {
					ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot5.copy();
					_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo5);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) (commandParameterEntity(arguments, "username"))), _setstack);
				}
				if ((commandParameterEntity(arguments, "username")) instanceof PlayerEntity) {
					ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot6.copy();
					_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo6);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) (commandParameterEntity(arguments, "username"))), _setstack);
				}
				if ((commandParameterEntity(arguments, "username")) instanceof PlayerEntity) {
					ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot7.copy();
					_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo7);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) (commandParameterEntity(arguments, "username"))), _setstack);
				}
				if ((commandParameterEntity(arguments, "username")) instanceof PlayerEntity) {
					ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot8.copy();
					_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo8);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) (commandParameterEntity(arguments, "username"))), _setstack);
				}
				{
					Entity _entity = (commandParameterEntity(arguments, "username"));
					if (_entity instanceof PlayerEntity) {
						((PlayerEntity) _entity).inventory.armorInventory.set(0, DohessModVariables.WorldVariables.get(world).ArmyShoes);
						((PlayerEntity) _entity).inventory.markDirty();
					} else if (_entity instanceof LivingEntity) {
						((LivingEntity) _entity).setItemStackToSlot(EquipmentSlotType.FEET, DohessModVariables.WorldVariables.get(world).ArmyShoes);
					}
				}
				{
					Entity _entity = (commandParameterEntity(arguments, "username"));
					if (_entity instanceof PlayerEntity) {
						((PlayerEntity) _entity).inventory.armorInventory.set(1, DohessModVariables.WorldVariables.get(world).ArmyPants);
						((PlayerEntity) _entity).inventory.markDirty();
					} else if (_entity instanceof LivingEntity) {
						((LivingEntity) _entity).setItemStackToSlot(EquipmentSlotType.LEGS, DohessModVariables.WorldVariables.get(world).ArmyPants);
					}
				}
				{
					Entity _entity = (commandParameterEntity(arguments, "username"));
					if (_entity instanceof PlayerEntity) {
						((PlayerEntity) _entity).inventory.armorInventory.set(2, DohessModVariables.WorldVariables.get(world).CadetJacket);
						((PlayerEntity) _entity).inventory.markDirty();
					} else if (_entity instanceof LivingEntity) {
						((LivingEntity) _entity).setItemStackToSlot(EquipmentSlotType.CHEST, DohessModVariables.WorldVariables.get(world).CadetJacket);
					}
				}
			}
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