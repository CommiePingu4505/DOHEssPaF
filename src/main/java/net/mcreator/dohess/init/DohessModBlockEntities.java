/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dohess.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;

import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Block;

import net.mcreator.dohess.block.entity.TCIChestBlockEntity;
import net.mcreator.dohess.DohessMod;

import java.util.function.Supplier;

public class DohessModBlockEntities {
	public static final DeferredRegister<TileEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, DohessMod.MODID);
	public static final RegistryObject<TileEntityType<TCIChestBlockEntity>> TCI_CHEST = register("tci_chest", DohessModBlocks.TCI_CHEST, TCIChestBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(String registryname, RegistryObject<Block> block, Supplier<? extends T> supplier) {
		return REGISTRY.register(registryname, () -> TileEntityType.Builder.create(supplier, block.get()).build(null));
	}
}