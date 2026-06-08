/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dohess.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.common.extensions.IForgeContainerType;

import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.dohess.world.inventory.TCIChestGUIMenu;
import net.mcreator.dohess.world.inventory.PlayerRankSquadSystemMenu;
import net.mcreator.dohess.world.inventory.PDMenuGUIMenu;
import net.mcreator.dohess.world.inventory.ManageCadetsEquipmentMenu;
import net.mcreator.dohess.world.inventory.GeneralManagingMenuMenu;
import net.mcreator.dohess.network.MenuStateUpdateMessage;
import net.mcreator.dohess.DohessMod;

import java.util.Map;

public class DohessModMenus {
	public static final DeferredRegister<ContainerType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.CONTAINERS, DohessMod.MODID);
	public static final RegistryObject<ContainerType<ManageCadetsEquipmentMenu>> MANAGE_CADETS_EQUIPMENT = REGISTRY.register("manage_cadets_equipment", () -> IForgeContainerType.create(ManageCadetsEquipmentMenu::new));
	public static final RegistryObject<ContainerType<PlayerRankSquadSystemMenu>> PLAYER_RANK_SQUAD_SYSTEM = REGISTRY.register("player_rank_squad_system", () -> IForgeContainerType.create(PlayerRankSquadSystemMenu::new));
	public static final RegistryObject<ContainerType<TCIChestGUIMenu>> TCI_CHEST_GUI = REGISTRY.register("tci_chest_gui", () -> IForgeContainerType.create(TCIChestGUIMenu::new));
	public static final RegistryObject<ContainerType<PDMenuGUIMenu>> PD_MENU_GUI = REGISTRY.register("pd_menu_gui", () -> IForgeContainerType.create(PDMenuGUIMenu::new));
	public static final RegistryObject<ContainerType<GeneralManagingMenuMenu>> GENERAL_MANAGING_MENU = REGISTRY.register("general_managing_menu", () -> IForgeContainerType.create(GeneralManagingMenuMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(PlayerEntity player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayerEntity) {
				DohessMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player), new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.world.isRemote) {
				if (Minecraft.getInstance().currentScreen instanceof DohessModScreens.ScreenAccessor && needClientUpdate)
					((DohessModScreens.ScreenAccessor) Minecraft.getInstance().currentScreen).updateMenuState(elementType, name, elementState);
				DohessMod.PACKET_HANDLER.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}