package net.mcreator.dohess.network;

import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.dohess.procedures.SetUsernameShownProcedure;
import net.mcreator.dohess.procedures.SetTCITeamProcedure;
import net.mcreator.dohess.procedures.SetPDTeamProcedure;
import net.mcreator.dohess.procedures.SetCustomSquadProcedure;
import net.mcreator.dohess.procedures.SetCustomRankProcedure;
import net.mcreator.dohess.procedures.SetColourProcedure;
import net.mcreator.dohess.procedures.SetColourBackProcedure;
import net.mcreator.dohess.DohessMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GeneralManagingMenuButtonMessage {
	private final int buttonID, x, y, z;

	public GeneralManagingMenuButtonMessage(PacketBuffer buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public GeneralManagingMenuButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(GeneralManagingMenuButtonMessage message, PacketBuffer buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(GeneralManagingMenuButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> handleButtonAction(context.getSender(), message.buttonID, message.x, message.y, message.z));
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetPDTeamProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			SetTCITeamProcedure.execute(world, entity);
		}
		if (buttonID == 2) {

			SetCustomSquadProcedure.execute(world, entity);
		}
		if (buttonID == 3) {

			SetCustomRankProcedure.execute(world, entity);
		}
		if (buttonID == 4) {

			SetUsernameShownProcedure.execute(world, entity);
		}
		if (buttonID == 5) {

			SetColourBackProcedure.execute(world, entity);
		}
		if (buttonID == 6) {

			SetColourProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DohessMod.addNetworkMessage(GeneralManagingMenuButtonMessage.class, GeneralManagingMenuButtonMessage::buffer, GeneralManagingMenuButtonMessage::new, GeneralManagingMenuButtonMessage::handler);
	}
}