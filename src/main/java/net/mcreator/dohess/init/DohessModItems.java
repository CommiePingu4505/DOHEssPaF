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
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.TallBlockItem;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;

import net.mcreator.dohess.procedures.SetKnifeModelProcedure;
import net.mcreator.dohess.item.UlivactoItem;
import net.mcreator.dohess.item.SpawnZweiItem;
import net.mcreator.dohess.item.SpawnVladlenItem;
import net.mcreator.dohess.item.SpawnValentinaItem;
import net.mcreator.dohess.item.SpawnMichelleBlockyItem;
import net.mcreator.dohess.item.SpawnBlockyItem;
import net.mcreator.dohess.item.SpawnAmmerAllanItem;
import net.mcreator.dohess.item.SpawnAllanItem;
import net.mcreator.dohess.item.RenomorphisItem;
import net.mcreator.dohess.item.KnifeItem;
import net.mcreator.dohess.item.HesterianItem;
import net.mcreator.dohess.item.CalostriophaItem;
import net.mcreator.dohess.item.BowieKnifeItem;
import net.mcreator.dohess.item.BandagesItem;
import net.mcreator.dohess.DohessMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DohessModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DohessMod.MODID);
	public static final RegistryObject<Item> BANDAGES = REGISTRY.register("bandages", BandagesItem::new);
	public static final RegistryObject<Item> HESTERIAN = REGISTRY.register("hesterian", HesterianItem::new);
	public static final RegistryObject<Item> RENOMORPHIS = REGISTRY.register("renomorphis", RenomorphisItem::new);
	public static final RegistryObject<Item> CALOSTRIOPHA = REGISTRY.register("calostriopha", CalostriophaItem::new);
	public static final RegistryObject<Item> ULIVACTO = REGISTRY.register("ulivacto", UlivactoItem::new);
	public static final RegistryObject<Item> KNIFE = REGISTRY.register("knife", KnifeItem::new);
	public static final RegistryObject<Item> GAS_CART_SPAWN_EGG = REGISTRY.register("gas_cart_spawn_egg", () -> new ForgeSpawnEggItem(DohessModEntities.GAS_CART, -10079488, -6724096, new Item.Properties().group(DohessModTabs.TAB_DOH_ESSENTAILS)));
	public static final RegistryObject<Item> TCI_CHEST = blockCMT(DohessModBlocks.TCI_CHEST, DohessModTabs.TAB_DOH_ESSENTAILS);
	public static final RegistryObject<Item> TCI_DOOR = doubleBlockCMT(DohessModBlocks.TCI_DOOR, DohessModTabs.TAB_DOH_ESSENTAILS);
	public static final RegistryObject<Item> TCI_BUTTON = blockCMT(DohessModBlocks.TCI_BUTTON, DohessModTabs.TAB_DOH_ESSENTAILS);
	public static final RegistryObject<Item> BOWIE_KNIFE = REGISTRY.register("bowie_knife", BowieKnifeItem::new);
	public static final RegistryObject<Item> SPAWN_ALLAN = REGISTRY.register("spawn_allan", SpawnAllanItem::new);
	public static final RegistryObject<Item> SPAWN_AMMER_ALLAN = REGISTRY.register("spawn_ammer_allan", SpawnAmmerAllanItem::new);
	public static final RegistryObject<Item> SPAWN_BLOCKY = REGISTRY.register("spawn_blocky", SpawnBlockyItem::new);
	public static final RegistryObject<Item> SPAWN_MICHELLE_BLOCKY = REGISTRY.register("spawn_michelle_blocky", SpawnMichelleBlockyItem::new);
	public static final RegistryObject<Item> SPAWN_VALENTINA = REGISTRY.register("spawn_valentina", SpawnValentinaItem::new);
	public static final RegistryObject<Item> SPAWN_VLADLEN = REGISTRY.register("spawn_vladlen", SpawnVladlenItem::new);
	public static final RegistryObject<Item> SPAWN_ZWEI = REGISTRY.register("spawn_zwei", SpawnZweiItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> blockCMT(RegistryObject<Block> block, ItemGroup tab) {
		return block(block, new Item.Properties().group(tab));
	}

	private static RegistryObject<Item> block(RegistryObject<Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}

	private static RegistryObject<Item> doubleBlockCMT(RegistryObject<Block> block, ItemGroup tab) {
		return doubleBlock(block, new Item.Properties().group(tab));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new TallBlockItem(block.get(), properties));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemModelsProperties.registerProperty(KNIFE.get(), new ResourceLocation("dohess:knife_knife"), (itemStackToRender, clientWorld, entity) -> (float) SetKnifeModelProcedure.execute(itemStackToRender));
		});
	}
}