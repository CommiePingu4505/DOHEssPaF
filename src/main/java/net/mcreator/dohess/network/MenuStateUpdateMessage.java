package net.mcreator.dohess.network;

import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.network.PacketBuffer;
import net.minecraft.client.Minecraft;

import net.mcreator.dohess.init.DohessModScreens;
import net.mcreator.dohess.init.DohessModMenus;
import net.mcreator.dohess.DohessMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MenuStateUpdateMessage {
	private final int elementType;
	private final String name;
	private final Object elementState;

	public MenuStateUpdateMessage(int elementType, String name, Object elementState) {
		this.elementType = elementType;
		this.name = name;
		this.elementState = elementState;
	}

	public MenuStateUpdateMessage(PacketBuffer buffer) {
		this.elementType = buffer.readInt();
		this.name = buffer.readString();
		Object elementState = null;
		if (elementType == 0) {
			elementState = buffer.readString();
		} else if (elementType == 1) {
			elementState = buffer.readBoolean();
		}
		this.elementState = elementState;
	}

	public static void buffer(MenuStateUpdateMessage message, PacketBuffer buffer) {
		buffer.writeInt(message.elementType);
		buffer.writeString(message.name);
		if (message.elementType == 0) {
			buffer.writeString((String) message.elementState);
		} else if (message.elementType == 1) {
			buffer.writeBoolean((boolean) message.elementState);
		}
	}

	public static void handler(MenuStateUpdateMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		if (message.name.length() > 256 || message.elementState instanceof String && ((String) message.elementState).length() > 8192)
			return;
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			if (context.getSender().openContainer instanceof DohessModMenus.MenuAccessor) {
				((DohessModMenus.MenuAccessor) context.getSender().openContainer).getMenuState().put(message.elementType + ":" + message.name, message.elementState);
				if (!context.getDirection().getReceptionSide().isServer() && Minecraft.getInstance().currentScreen instanceof DohessModScreens.ScreenAccessor) {
					((DohessModScreens.ScreenAccessor) Minecraft.getInstance().currentScreen).updateMenuState(message.elementType, message.name, message.elementState);
				}
			}
		});
		context.setPacketHandled(true);
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DohessMod.addNetworkMessage(MenuStateUpdateMessage.class, MenuStateUpdateMessage::buffer, MenuStateUpdateMessage::new, MenuStateUpdateMessage::handler);
	}
}