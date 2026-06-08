package net.mcreator.dohess.network;

import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.dohess.procedures.SetSpeedProcedure;
import net.mcreator.dohess.procedures.SetNameDisplayProcedure;
import net.mcreator.dohess.procedures.SetInvisibleProcedure;
import net.mcreator.dohess.procedures.SetImmortalProcedure;
import net.mcreator.dohess.procedures.RemoveAllProcedure;
import net.mcreator.dohess.procedures.PDChangeGamemodeProcedure;
import net.mcreator.dohess.procedures.GiveZweiProcedure;
import net.mcreator.dohess.procedures.GiveVladlenProcedure;
import net.mcreator.dohess.procedures.GiveValentinaProcedure;
import net.mcreator.dohess.procedures.GiveMichelleBlockyProcedure;
import net.mcreator.dohess.procedures.GiveBlockyProcedure;
import net.mcreator.dohess.procedures.GiveAmmerAllanProcedure;
import net.mcreator.dohess.procedures.GiveAllanProcedure;
import net.mcreator.dohess.procedures.GiveAllProcedure;
import net.mcreator.dohess.DohessMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PDMenuGUIButtonMessage {
	private final int buttonID, x, y, z;

	public PDMenuGUIButtonMessage(PacketBuffer buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public PDMenuGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(PDMenuGUIButtonMessage message, PacketBuffer buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(PDMenuGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

			SetSpeedProcedure.execute(entity);
		}
		if (buttonID == 1) {

			SetImmortalProcedure.execute(entity);
		}
		if (buttonID == 2) {

			SetInvisibleProcedure.execute(entity);
		}
		if (buttonID == 3) {

			SetNameDisplayProcedure.execute(entity);
		}
		if (buttonID == 4) {

			PDChangeGamemodeProcedure.execute(entity);
		}
		if (buttonID == 5) {

			GiveAllanProcedure.execute(entity);
		}
		if (buttonID == 6) {

			GiveAmmerAllanProcedure.execute(entity);
		}
		if (buttonID == 7) {

			GiveBlockyProcedure.execute(entity);
		}
		if (buttonID == 8) {

			GiveMichelleBlockyProcedure.execute(entity);
		}
		if (buttonID == 9) {

			GiveValentinaProcedure.execute(entity);
		}
		if (buttonID == 10) {

			GiveVladlenProcedure.execute(entity);
		}
		if (buttonID == 11) {

			GiveZweiProcedure.execute(entity);
		}
		if (buttonID == 12) {

			GiveAllProcedure.execute(entity);
		}
		if (buttonID == 13) {

			RemoveAllProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DohessMod.addNetworkMessage(PDMenuGUIButtonMessage.class, PDMenuGUIButtonMessage::buffer, PDMenuGUIButtonMessage::new, PDMenuGUIButtonMessage::handler);
	}
}