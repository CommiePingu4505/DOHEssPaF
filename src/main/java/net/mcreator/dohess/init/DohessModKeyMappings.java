/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dohess.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.Minecraft;

import net.mcreator.dohess.network.CallHorseKMessage;
import net.mcreator.dohess.DohessMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DohessModKeyMappings {
	public static final KeyBinding CALL_HORSE_K = new KeyBinding("key.dohess.call_horse_k", GLFW.GLFW_KEY_V, "key.categories.ess");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(CALL_HORSE_K);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().currentScreen == null) {
				if (event.getKey() == CALL_HORSE_K.getKey().getKeyCode()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						DohessMod.PACKET_HANDLER.sendToServer(new CallHorseKMessage(0, 0));
						CallHorseKMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}