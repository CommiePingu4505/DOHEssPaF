package net.mcreator.dohess.block;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;

import net.mcreator.dohess.world.inventory.TCIChestGUIMenu;
import net.mcreator.dohess.procedures.TCIChestGUIWhileThisGUIIsOpenTickProcedure;
import net.mcreator.dohess.block.entity.TCIChestBlockEntity;

import io.netty.buffer.Unpooled;

public class TCIChestBlock extends Block {
	public TCIChestBlock() {
		super(AbstractBlock.Properties.create(Material.REDSTONE_LIGHT).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f));
	}

	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public ActionResultType onBlockActivated(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockRayTraceResult hit) {
		super.onBlockActivated(blockstate, world, pos, entity, hand, hit);
		if (entity instanceof ServerPlayerEntity) {
			NetworkHooks.openGui(((ServerPlayerEntity) entity), new INamedContainerProvider() {
				@Override
				public ITextComponent getDisplayName() {
					return new StringTextComponent("TCI Chest");
				}

				@Override
				public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
					return new TCIChestGUIMenu(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getHitVec().x;
		double hitY = hit.getHitVec().y;
		double hitZ = hit.getHitVec().z;
		Direction direction = hit.getFace();
		TCIChestGUIWhileThisGUIIsOpenTickProcedure.execute(world, entity);
		return ActionResultType.SUCCESS;
	}

	@Override
	public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		return tileEntity instanceof INamedContainerProvider ? ((INamedContainerProvider) tileEntity) : null;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TCIChestBlockEntity();
	}

	@Override
	public boolean eventReceived(BlockState state, World world, BlockPos pos, int eventID, int eventParam) {
		super.eventReceived(state, world, pos, eventID, eventParam);
		TileEntity blockEntity = world.getTileEntity(pos);
		return blockEntity != null && blockEntity.receiveClientEvent(eventID, eventParam);
	}

	@Override
	public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity blockEntity = world.getTileEntity(pos);
			if (blockEntity instanceof TCIChestBlockEntity) {
				InventoryHelper.dropInventoryItems(world, pos, ((TCIChestBlockEntity) blockEntity));
				world.updateComparatorOutputLevel(pos, this);
			}
			super.onReplaced(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasComparatorInputOverride(BlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(BlockState blockState, World world, BlockPos pos) {
		TileEntity tileentity = world.getTileEntity(pos);
		if (tileentity instanceof TCIChestBlockEntity)
			return Container.calcRedstoneFromInventory(((TCIChestBlockEntity) tileentity));
		else
			return 0;
	}
}