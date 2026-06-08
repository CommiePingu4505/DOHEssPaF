package net.mcreator.dohess.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.dohess.procedures.SelfHarmProcedure;
import net.mcreator.dohess.init.DohessModTabs;

import java.util.List;

public class KnifeItem extends Item {
	public KnifeItem() {
		super(new Item.Properties().group(DohessModTabs.TAB_DOH_ESSENTAILS).maxStackSize(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
		super.addInformation(itemstack, world, list, flag);
		list.add(new TranslationTextComponent("item.dohess.knife.description_0"));
		list.add(new TranslationTextComponent("item.dohess.knife.description_1"));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		SelfHarmProcedure.execute(entity);
		return ar;
	}
}