package net.mcreator.dohess.client.renderer;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;

import net.mcreator.dohess.entity.GasCartEntity;
import net.mcreator.dohess.client.model.Modeltest;

import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GasCartRenderer extends MobRenderer<GasCartEntity, Modeltest<GasCartEntity>> {
	public GasCartRenderer(EntityRendererManager context) {
		super(context, new Modeltest<GasCartEntity>(), 0.5f);
	}

	@Override
	protected void preRenderCallback(GasCartEntity entity, MatrixStack poseStack, float f) {
		poseStack.scale(0.5f, 0.5f, 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(GasCartEntity entity) {
		return new ResourceLocation("dohess:textures/entities/gas_txt.png");
	}
}