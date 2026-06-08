package net.mcreator.dohess.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.world.inventory.ManageCadetsEquipmentMenu;
import net.mcreator.dohess.network.DohessModVariables;
import net.mcreator.dohess.init.DohessModMenus;
import net.mcreator.dohess.DohessMod;

import io.netty.buffer.Unpooled;

public class OpenMenuProcedure {
	public static void execute(IWorld world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayerEntity) {
			BlockPos _bpos = new BlockPos(x, y, z);
			NetworkHooks.openGui((ServerPlayerEntity) entity, new INamedContainerProvider() {
				@Override
				public ITextComponent getDisplayName() {
					return new StringTextComponent("ManageCadetsEquipment");
				}

				@Override
				public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
					return new ManageCadetsEquipmentMenu(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
		DohessMod.queueServerWork(1, () -> {
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot1.copy();
				_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo1);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(0).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot2.copy();
				_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo2);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(1).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot3.copy();
				_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo3);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(2).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot4.copy();
				_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo4);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(3).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot5.copy();
				_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo5);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(14).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot6.copy();
				_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo6);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(15).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot7.copy();
				_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo7);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(16).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetSlot8.copy();
				_setstack.setCount((int) DohessModVariables.WorldVariables.get(world).CadetNo8);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(17).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetJacket.copy();
				_setstack.setCount(1);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(8).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetCape.copy();
				_setstack.setCount(1);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(9).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).CadetFormal.copy();
				_setstack.setCount(1);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(10).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).ODMGear.copy();
				_setstack.setCount(1);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(11).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).ArmyPants.copy();
				_setstack.setCount(1);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(12).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).ArmyShoes.copy();
				_setstack.setCount(1);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(13).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).SLJacket.copy();
				_setstack.setCount(1);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(18).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).SLCape.copy();
				_setstack.setCount(1);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(19).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
				ItemStack _setstack = DohessModVariables.WorldVariables.get(world).SLFormal.copy();
				_setstack.setCount(1);
				((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(20).putStack(_setstack);
				((PlayerEntity) entity).openContainer.detectAndSendChanges();
			}
		});
	}
}