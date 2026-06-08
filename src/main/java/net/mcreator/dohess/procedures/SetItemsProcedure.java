package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.network.DohessModVariables;
import net.mcreator.dohess.init.DohessModMenus;

public class SetItemsProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		DohessModVariables.WorldVariables.get(world).CadetNo1 = getAmountInGUISlot(entity, 0);
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetNo2 = getAmountInGUISlot(entity, 1);
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetNo3 = getAmountInGUISlot(entity, 2);
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetNo4 = getAmountInGUISlot(entity, 3);
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetNo5 = getAmountInGUISlot(entity, 14);
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetNo6 = getAmountInGUISlot(entity, 15);
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetNo7 = getAmountInGUISlot(entity, 16);
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetNo8 = getAmountInGUISlot(entity, 17);
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetSlot1 = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(0).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetSlot2 = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(1).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetSlot3 = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(2).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetSlot4 = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(3).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetSlot5 = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(14).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetSlot6 = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(15).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetSlot7 = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(16).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetSlot8 = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(17).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetJacket = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(8).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetCape = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(9).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).CadetFormal = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(10).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).ODMGear = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(11).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).ArmyPants = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(12).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).ArmyShoes = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(13).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).SLJacket = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(18).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).SLCape = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(19).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
		DohessModVariables.WorldVariables.get(world).SLFormal = (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor
				? ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(20).getStack()
				: ItemStack.EMPTY).copy();
		DohessModVariables.WorldVariables.get(world).syncData(world);
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof PlayerEntity && ((PlayerEntity) entity).openContainer instanceof DohessModMenus.MenuAccessor) {
			ItemStack stack = ((DohessModMenus.MenuAccessor) ((PlayerEntity) entity).openContainer).getSlots().get(sltid).getStack();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}