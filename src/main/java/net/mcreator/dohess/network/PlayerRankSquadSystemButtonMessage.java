package net.mcreator.dohess.network;

import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.dohess.procedures.SetSL8Procedure;
import net.mcreator.dohess.procedures.SetSL7Procedure;
import net.mcreator.dohess.procedures.SetSL6Procedure;
import net.mcreator.dohess.procedures.SetSL5Procedure;
import net.mcreator.dohess.procedures.SetSL4Procedure;
import net.mcreator.dohess.procedures.SetSL3Procedure;
import net.mcreator.dohess.procedures.SetSL2Procedure;
import net.mcreator.dohess.procedures.SetSL1Procedure;
import net.mcreator.dohess.procedures.SetRank9Procedure;
import net.mcreator.dohess.procedures.SetRank8Procedure;
import net.mcreator.dohess.procedures.SetRank7Procedure;
import net.mcreator.dohess.procedures.SetRank6Procedure;
import net.mcreator.dohess.procedures.SetRank5Procedure;
import net.mcreator.dohess.procedures.SetRank4Procedure;
import net.mcreator.dohess.procedures.SetRank3Procedure;
import net.mcreator.dohess.procedures.SetRank2Procedure;
import net.mcreator.dohess.procedures.SetRank20Procedure;
import net.mcreator.dohess.procedures.SetRank1Procedure;
import net.mcreator.dohess.procedures.SetRank19Procedure;
import net.mcreator.dohess.procedures.SetRank18Procedure;
import net.mcreator.dohess.procedures.SetRank17Procedure;
import net.mcreator.dohess.procedures.SetRank16Procedure;
import net.mcreator.dohess.procedures.SetRank15Procedure;
import net.mcreator.dohess.procedures.SetRank14Procedure;
import net.mcreator.dohess.procedures.SetRank13Procedure;
import net.mcreator.dohess.procedures.SetRank12Procedure;
import net.mcreator.dohess.procedures.SetRank11Procedure;
import net.mcreator.dohess.procedures.SetRank10Procedure;
import net.mcreator.dohess.DohessMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlayerRankSquadSystemButtonMessage {
	private final int buttonID, x, y, z;

	public PlayerRankSquadSystemButtonMessage(PacketBuffer buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public PlayerRankSquadSystemButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(PlayerRankSquadSystemButtonMessage message, PacketBuffer buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(PlayerRankSquadSystemButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

			SetRank1Procedure.execute(world, entity);
		}
		if (buttonID == 1) {

			SetRank2Procedure.execute(world, entity);
		}
		if (buttonID == 2) {

			SetRank3Procedure.execute(world, entity);
		}
		if (buttonID == 3) {

			SetRank4Procedure.execute(world, entity);
		}
		if (buttonID == 4) {

			SetRank5Procedure.execute(world, entity);
		}
		if (buttonID == 5) {

			SetRank7Procedure.execute(world, entity);
		}
		if (buttonID == 6) {

			SetRank6Procedure.execute(world, entity);
		}
		if (buttonID == 7) {

			SetRank8Procedure.execute(world, entity);
		}
		if (buttonID == 8) {

			SetRank9Procedure.execute(world, entity);
		}
		if (buttonID == 9) {

			SetRank10Procedure.execute(world, entity);
		}
		if (buttonID == 10) {

			SetRank20Procedure.execute(world, entity);
		}
		if (buttonID == 11) {

			SetRank11Procedure.execute(world, entity);
		}
		if (buttonID == 12) {

			SetRank12Procedure.execute(world, entity);
		}
		if (buttonID == 13) {

			SetRank13Procedure.execute(world, entity);
		}
		if (buttonID == 14) {

			SetRank14Procedure.execute(world, entity);
		}
		if (buttonID == 15) {

			SetRank15Procedure.execute(world, entity);
		}
		if (buttonID == 16) {

			SetRank16Procedure.execute(world, entity);
		}
		if (buttonID == 17) {

			SetRank17Procedure.execute(world, entity);
		}
		if (buttonID == 18) {

			SetRank18Procedure.execute(world, entity);
		}
		if (buttonID == 19) {

			SetRank19Procedure.execute(world, entity);
		}
		if (buttonID == 20) {

			SetSL1Procedure.execute(world, entity);
		}
		if (buttonID == 21) {

			SetSL2Procedure.execute(world, entity);
		}
		if (buttonID == 22) {

			SetSL3Procedure.execute(world, entity);
		}
		if (buttonID == 23) {

			SetSL4Procedure.execute(world, entity);
		}
		if (buttonID == 24) {

			SetSL5Procedure.execute(world, entity);
		}
		if (buttonID == 25) {

			SetSL6Procedure.execute(world, entity);
		}
		if (buttonID == 26) {

			SetSL7Procedure.execute(world, entity);
		}
		if (buttonID == 27) {

			SetSL8Procedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DohessMod.addNetworkMessage(PlayerRankSquadSystemButtonMessage.class, PlayerRankSquadSystemButtonMessage::buffer, PlayerRankSquadSystemButtonMessage::new, PlayerRankSquadSystemButtonMessage::handler);
	}
}