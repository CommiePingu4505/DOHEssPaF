package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

public class ShowNameProcedure {
	public static String execute(IWorld world, double x, double y, double z) {
		return getBlockNBTString(world, new BlockPos(x, y, z), "playeruuid");
	}

	private static String getBlockNBTString(IWorld world, BlockPos pos, String tag) {
		TileEntity blockEntity = world.getTileEntity(pos);
		if (blockEntity != null)
			return blockEntity.getTileData().getString(tag);
		return "";
	}
}