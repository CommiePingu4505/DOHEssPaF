/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dohess.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

public class DohessModTabs {
	public static ItemGroup TAB_DOH_ESSENTAILS;

	public static void load() {
		TAB_DOH_ESSENTAILS = new ItemGroup("dohess.doh_essentails") {
			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack createIcon() {
				return new ItemStack(DohessModItems.BANDAGES.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}