package net.mcreator.dohess.client.gui;

import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.dohess.world.inventory.ManageCadetsEquipmentMenu;
import net.mcreator.dohess.network.ManageCadetsEquipmentButtonMessage;
import net.mcreator.dohess.init.DohessModScreens;
import net.mcreator.dohess.DohessMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class ManageCadetsEquipmentScreen extends ContainerScreen<ManageCadetsEquipmentMenu> implements DohessModScreens.ScreenAccessor {
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	private boolean menuStateUpdateActive = false;
	Button button_done;

	public ManageCadetsEquipmentScreen(ManageCadetsEquipmentMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 214;
		this.ySize = 200;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = new ResourceLocation("dohess:textures/screens/manage_cadets_equipment.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		this.blit(ms, this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.manage_cadets_equipment.label_equipment"), 25, 6, -16750900);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.manage_cadets_equipment.label_uniform"), 88, 6, -39322);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.manage_cadets_equipment.label_jacket"), 115, 24, -6724096);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.manage_cadets_equipment.label_cape"), 115, 42, -16764160);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.manage_cadets_equipment.label_formal"), 115, 60, -13395712);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.manage_cadets_equipment.label_odm_gear"), 169, 60, -10066330);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.manage_cadets_equipment.label_extra"), 160, 6, -6710887);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.manage_cadets_equipment.label_pants"), 169, 24, -12829636);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.manage_cadets_equipment.label_shoes"), 169, 42, -12829636);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.manage_cadets_equipment.label_cdt"), 79, 15, -39373);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.manage_cadets_equipment.label_sl"), 97, 15, -10066177);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		button_done = new Button(this.guiLeft + 25, this.guiTop + 96, 36, 20, new TranslationTextComponent("gui.dohess.manage_cadets_equipment.button_done"), e -> {
			int x = ManageCadetsEquipmentScreen.this.x;
			int y = ManageCadetsEquipmentScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new ManageCadetsEquipmentButtonMessage(0, x, y, z));
				ManageCadetsEquipmentButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		this.addButton(button_done);
	}
}