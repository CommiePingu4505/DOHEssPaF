package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.dohess.network.DohessModVariables;

public class TCIChestGUIWhileThisGUIIsOpenTickProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		if (!(((entity.getCapability(DohessModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DohessModVariables.PlayerVariables())).PlayerUser).equals(getBlockNBTString(world, new BlockPos(
				entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).scale(5)), RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, entity)).getPos().getX(),
				entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).scale(5)), RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, entity)).getPos().getY(),
				entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).scale(5)), RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
				"playeruuid")) || getEntityGameType(entity) == GameType.CREATIVE)) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote() && _ent.world.getServer() != null)
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "tellraw @s {\"text\":\"This dose NOT belong to you\",\"color\":\"dark_red\"}");
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
		}
	}

	private static String getBlockNBTString(IWorld world, BlockPos pos, String tag) {
		TileEntity blockEntity = world.getTileEntity(pos);
		if (blockEntity != null)
			return blockEntity.getTileData().getString(tag);
		return "";
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayerEntity) {
			return ((ServerPlayerEntity) entity).interactionManager.getGameType();
		} else if (entity instanceof PlayerEntity && ((PlayerEntity) entity).world.isRemote()) {
			NetworkPlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(((PlayerEntity) entity).getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameType();
		}
		return null;
	}
}