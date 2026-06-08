package net.mcreator.dohess.world.inventory;

import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dohess.init.DohessModMenus;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class ManageCadetsEquipmentMenu extends Container implements DohessModMenus.MenuAccessor {
	public final Map<String, Object> menuState = new HashMap<String, Object>() {
		@Override
		public Object put(String key, Object value) {
			if (!this.containsKey(key) && this.size() >= 29)
				return null;
			return super.put(key, value);
		}
	};
	public final World world;
	public final PlayerEntity entity;
	public int x, y, z;
	private IWorldPosCallable access = IWorldPosCallable.DUMMY;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private TileEntity boundBlockEntity = null;

	public ManageCadetsEquipmentMenu(int id, PlayerInventory inv, PacketBuffer extraData) {
		super(DohessModMenus.MANAGE_CADETS_EQUIPMENT.get(), id);
		this.entity = inv.player;
		this.world = inv.player.world;
		this.internal = new ItemStackHandler(21);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = IWorldPosCallable.of(world, pos);
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack = hand == 0 ? this.entity.getHeldItemMainhand() : this.entity.getHeldItemOffhand();
				this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getHeldItemMainhand() : this.entity.getHeldItemOffhand());
				itemstack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					this.internal = capability;
					this.bound = true;
				});
			} else if (extraData.readableBytes() > 1) { // bound to entity
				extraData.readByte(); // drop padding
				boundEntity = world.getEntityByID(extraData.readVarInt());
				if (boundEntity != null)
					boundEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			} else { // might be bound to block
				boundBlockEntity = this.world.getTileEntity(pos);
				if (boundBlockEntity != null)
					boundBlockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			}
		}
		this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 80, 25) {
			private final int slot = 8;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 26, 25) {
			private final int slot = 0;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 26, 43) {
			private final int slot = 1;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 26, 61) {
			private final int slot = 2;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 26, 79) {
			private final int slot = 3;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 80, 43) {
			private final int slot = 9;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 80, 61) {
			private final int slot = 10;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 152, 61) {
			private final int slot = 11;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 152, 25) {
			private final int slot = 12;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 152, 43) {
			private final int slot = 13;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 98, 25) {
			private final int slot = 18;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 98, 43) {
			private final int slot = 19;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(20, this.addSlot(new SlotItemHandler(internal, 20, 98, 61) {
			private final int slot = 20;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 44, 25) {
			private final int slot = 14;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 44, 43) {
			private final int slot = 15;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 44, 61) {
			private final int slot = 16;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 44, 79) {
			private final int slot = 17;
			private int x = ManageCadetsEquipmentMenu.this.x;
			private int y = ManageCadetsEquipmentMenu.this.y;
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 19 + 8 + sj * 18, 36 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 19 + 8 + si * 18, 36 + 142));
	}

	@Override
	public boolean canInteractWith(PlayerEntity player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return Container.isWithinUsableDistance(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index < 17) {
				if (!this.mergeItemStack(itemstack1, 17, this.inventorySlots.size(), true))
					return ItemStack.EMPTY;
				slot.onSlotChange(itemstack1, itemstack);
			} else if (!this.mergeItemStack(itemstack1, 0, 17, false)) {
				if (index < 17 + 27) {
					if (!this.mergeItemStack(itemstack1, 17 + 27, this.inventorySlots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.mergeItemStack(itemstack1, 17, 17 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override /**
				* Merges provided ItemStack with the first avaliable one in the container/player inventor between minIndex (included) and maxIndex (excluded). Args : stack, minIndex, maxIndex, negativDirection. /!\ the Container implementation do not check if the item is valid for the slot
				*/
	protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
		boolean flag = false;
		int i = startIndex;
		if (reverseDirection) {
			i = endIndex - 1;
		}
		if (stack.isStackable()) {
			while (!stack.isEmpty()) {
				if (reverseDirection) {
					if (i < startIndex) {
						break;
					}
				} else if (i >= endIndex) {
					break;
				}
				Slot slot = this.inventorySlots.get(i);
				ItemStack itemstack = slot.getStack();
				if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && areItemsAndTagsEqual(stack, itemstack)) {
					int j = itemstack.getCount() + stack.getCount();
					int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
					if (j <= maxSize) {
						stack.setCount(0);
						itemstack.setCount(j);
						slot.putStack(itemstack);
						flag = true;
					} else if (itemstack.getCount() < maxSize) {
						stack.shrink(maxSize - itemstack.getCount());
						itemstack.setCount(maxSize);
						slot.putStack(itemstack);
						flag = true;
					}
				}
				if (reverseDirection) {
					--i;
				} else {
					++i;
				}
			}
		}
		if (!stack.isEmpty()) {
			if (reverseDirection) {
				i = endIndex - 1;
			} else {
				i = startIndex;
			}
			while (true) {
				if (reverseDirection) {
					if (i < startIndex) {
						break;
					}
				} else if (i >= endIndex) {
					break;
				}
				Slot slot1 = this.inventorySlots.get(i);
				ItemStack itemstack1 = slot1.getStack();
				if (itemstack1.isEmpty() && slot1.isItemValid(stack)) {
					if (stack.getCount() > slot1.getSlotStackLimit()) {
						slot1.putStack(stack.split(slot1.getSlotStackLimit()));
					} else {
						slot1.putStack(stack.split(stack.getCount()));
					}
					slot1.onSlotChanged();
					flag = true;
					break;
				}
				if (reverseDirection) {
					--i;
				} else {
					++i;
				}
			}
		}
		return flag;
	}

	@Override
	public void onContainerClosed(PlayerEntity playerIn) {
		super.onContainerClosed(playerIn);
		if (!bound && playerIn instanceof ServerPlayerEntity) {
			if (!((ServerPlayerEntity) playerIn).isAlive() || ((ServerPlayerEntity) playerIn).hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					if (j == 8)
						continue;
					if (j == 0)
						continue;
					if (j == 1)
						continue;
					if (j == 2)
						continue;
					if (j == 3)
						continue;
					if (j == 9)
						continue;
					if (j == 10)
						continue;
					if (j == 11)
						continue;
					if (j == 12)
						continue;
					if (j == 13)
						continue;
					if (j == 18)
						continue;
					if (j == 19)
						continue;
					if (j == 20)
						continue;
					if (j == 14)
						continue;
					if (j == 15)
						continue;
					if (j == 16)
						continue;
					if (j == 17)
						continue;
					playerIn.dropItem(internal.getStackInSlot(j), false);
					if (internal instanceof IItemHandlerModifiable)
						((IItemHandlerModifiable) internal).setStackInSlot(j, ItemStack.EMPTY);
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					if (i == 8)
						continue;
					if (i == 0)
						continue;
					if (i == 1)
						continue;
					if (i == 2)
						continue;
					if (i == 3)
						continue;
					if (i == 9)
						continue;
					if (i == 10)
						continue;
					if (i == 11)
						continue;
					if (i == 12)
						continue;
					if (i == 13)
						continue;
					if (i == 18)
						continue;
					if (i == 19)
						continue;
					if (i == 20)
						continue;
					if (i == 14)
						continue;
					if (i == 15)
						continue;
					if (i == 16)
						continue;
					if (i == 17)
						continue;
					playerIn.inventory.placeItemBackInInventory(playerIn.world, internal.getStackInSlot(i));
					if (internal instanceof IItemHandlerModifiable)
						((IItemHandlerModifiable) internal).setStackInSlot(i, ItemStack.EMPTY);
				}
			}
		}
	}

	@Override
	public Map<Integer, Slot> getSlots() {
		return Collections.unmodifiableMap(customSlots);
	}

	@Override
	public Map<String, Object> getMenuState() {
		return menuState;
	}
}