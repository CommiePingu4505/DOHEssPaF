/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dohess.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.block.Block;

import net.mcreator.dohess.block.TCIDoorBlock;
import net.mcreator.dohess.block.TCIChestBlock;
import net.mcreator.dohess.block.TCIButtonBlock;
import net.mcreator.dohess.DohessMod;

public class DohessModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DohessMod.MODID);
	public static final RegistryObject<Block> TCI_CHEST = REGISTRY.register("tci_chest", TCIChestBlock::new);
	public static final RegistryObject<Block> TCI_DOOR = REGISTRY.register("tci_door", TCIDoorBlock::new);
	public static final RegistryObject<Block> TCI_BUTTON = REGISTRY.register("tci_button", TCIButtonBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			TCIDoorBlock.registerRenderLayer();
			TCIButtonBlock.registerRenderLayer();
		}
	}
}