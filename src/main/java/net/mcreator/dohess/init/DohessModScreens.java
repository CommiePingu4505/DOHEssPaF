/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dohess.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.ScreenManager;

import net.mcreator.dohess.client.gui.TCIChestGUIScreen;
import net.mcreator.dohess.client.gui.PlayerRankSquadSystemScreen;
import net.mcreator.dohess.client.gui.PDMenuGUIScreen;
import net.mcreator.dohess.client.gui.ManageCadetsEquipmentScreen;
import net.mcreator.dohess.client.gui.GeneralManagingMenuScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DohessModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ScreenManager.registerFactory(DohessModMenus.MANAGE_CADETS_EQUIPMENT.get(), ManageCadetsEquipmentScreen::new);
			ScreenManager.registerFactory(DohessModMenus.PLAYER_RANK_SQUAD_SYSTEM.get(), PlayerRankSquadSystemScreen::new);
			ScreenManager.registerFactory(DohessModMenus.TCI_CHEST_GUI.get(), TCIChestGUIScreen::new);
			ScreenManager.registerFactory(DohessModMenus.PD_MENU_GUI.get(), PDMenuGUIScreen::new);
			ScreenManager.registerFactory(DohessModMenus.GENERAL_MANAGING_MENU.get(), GeneralManagingMenuScreen::new);
		});
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}