package net.mcreator.dohess.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.dohess.procedures.BandagesRightclickedProcedure;
import net.mcreator.dohess.init.DohessModTabs;

import java.util.List;

public class BandagesItem extends Item {
	public BandagesItem() {
		super(new Item.Properties().group(DohessModTabs.TAB_DOH_ESSENTAILS).maxDamage(100));
	}

	@Override
	public UseAction getUseAction(ItemStack itemstack) {
		return UseAction.BOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 20;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0f;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
		super.addInformation(itemstack, world, list, flag);
		list.add(new TranslationTextComponent("item.dohess.bandages.description_0"));
		list.add(new TranslationTextComponent("item.dohess.bandages.description_1"));
		list.add(new TranslationTextComponent("item.dohess.bandages.description_2"));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		entity.setActiveHand(hand);
		return ar;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
		ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		BandagesRightclickedProcedure.execute(world, entity);
		return retval;
	}
}