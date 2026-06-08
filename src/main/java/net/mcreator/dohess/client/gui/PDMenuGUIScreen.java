package net.mcreator.dohess.client.gui;

import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.dohess.world.inventory.PDMenuGUIMenu;
import net.mcreator.dohess.procedures.PDGamemodeDisplayProcedure;
import net.mcreator.dohess.procedures.DisplayspeedProcedure;
import net.mcreator.dohess.procedures.DisplayNameDisplayProcedure;
import net.mcreator.dohess.procedures.DisplayInvisibleProcedure;
import net.mcreator.dohess.procedures.DisplayImmortalProcedure;
import net.mcreator.dohess.network.PDMenuGUIButtonMessage;
import net.mcreator.dohess.init.DohessModScreens;
import net.mcreator.dohess.DohessMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class PDMenuGUIScreen extends ContainerScreen<PDMenuGUIMenu> implements DohessModScreens.ScreenAccessor {
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	private boolean menuStateUpdateActive = false;
	TextFieldWidget speedno;
	Button button_speed;
	Button button_toggle;
	Button button_empty;
	Button button_empty2;
	Button button_empty3;
	Button button_allan;
	Button button_ameer_allan;
	Button button_blocky;
	Button button_michelle;
	Button button_valentina;
	Button button_vladlen;
	Button button_zwei;
	Button button_all;
	Button button_remove;

	public PDMenuGUIScreen(PDMenuGUIMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 200;
		this.ySize = 237;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String) {
			if (name.equals("speedno"))
				speedno.setText((String) elementState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = new ResourceLocation("dohess:textures/screens/pd_menu_gui.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		speedno.render(ms, mouseX, mouseY, partialTicks);
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
		if (speedno.isFocused())
			return speedno.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String speednoValue = speedno.getText();
		super.resize(minecraft, width, height);
		speedno.setText(speednoValue);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.pd_menu_gui.label_gamemode"), 9, 6, -12829636);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.pd_menu_gui.label_pd_menu"), 81, 6, -12829636);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.pd_menu_gui.label_titans"), 162, 6, -12829636);
		this.font.func_243248_b(ms, new StringTextComponent(DisplayImmortalProcedure.execute(entity)), 18, 60, -12829636);
		this.font.func_243248_b(ms, new StringTextComponent(DisplayInvisibleProcedure.execute(entity)), 18, 87, -12829636);
		this.font.func_243248_b(ms, new StringTextComponent(DisplayNameDisplayProcedure.execute(entity)), 18, 114, -12829636);
		this.font.func_243248_b(ms, new StringTextComponent(DisplayspeedProcedure.execute(entity)), 18, 141, -12829636);
		this.font.func_243248_b(ms, new StringTextComponent(PDGamemodeDisplayProcedure.execute(entity)), 18, 33, -12829636);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		speedno = new TextFieldWidget(this.font, this.guiLeft + 10, this.guiTop + 160, 70, 18, new TranslationTextComponent("gui.dohess.pd_menu_gui.speedno"));
		speedno.setMaxStringLength(8192);
		speedno.setResponder(content -> {
			if (!menuStateUpdateActive)
				container.sendMenuStateUpdate(entity, 0, "speedno", content, false);
		});
		speedno.setSuggestion(new TranslationTextComponent("gui.dohess.pd_menu_gui.speedno").getString());
		this.addListener(this.speedno);
		button_speed = new Button(this.guiLeft + 9, this.guiTop + 132, 72, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_speed"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(0, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		this.addButton(button_speed);
		button_toggle = new Button(this.guiLeft + 9, this.guiTop + 51, 72, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_toggle"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(1, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		this.addButton(button_toggle);
		button_empty = new Button(this.guiLeft + 9, this.guiTop + 78, 72, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_empty"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(2, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		this.addButton(button_empty);
		button_empty2 = new Button(this.guiLeft + 9, this.guiTop + 105, 72, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_empty2"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(3, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		this.addButton(button_empty2);
		button_empty3 = new Button(this.guiLeft + 9, this.guiTop + 24, 72, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_empty3"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(4, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		this.addButton(button_empty3);
		button_allan = new Button(this.guiLeft + 117, this.guiTop + 24, 72, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_allan"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(5, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		this.addButton(button_allan);
		button_ameer_allan = new Button(this.guiLeft + 117, this.guiTop + 51, 72, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_ameer_allan"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(6, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		this.addButton(button_ameer_allan);
		button_blocky = new Button(this.guiLeft + 117, this.guiTop + 78, 72, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_blocky"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(7, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		this.addButton(button_blocky);
		button_michelle = new Button(this.guiLeft + 117, this.guiTop + 105, 72, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_michelle"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(8, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		this.addButton(button_michelle);
		button_valentina = new Button(this.guiLeft + 117, this.guiTop + 132, 72, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_valentina"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(9, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		this.addButton(button_valentina);
		button_vladlen = new Button(this.guiLeft + 117, this.guiTop + 159, 72, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_vladlen"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(10, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		this.addButton(button_vladlen);
		button_zwei = new Button(this.guiLeft + 117, this.guiTop + 186, 72, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_zwei"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(11, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		this.addButton(button_zwei);
		button_all = new Button(this.guiLeft + 117, this.guiTop + 213, 36, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_all"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(12, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		});
		this.addButton(button_all);
		button_remove = new Button(this.guiLeft + 153, this.guiTop + 213, 36, 20, new TranslationTextComponent("gui.dohess.pd_menu_gui.button_remove"), e -> {
			int x = PDMenuGUIScreen.this.x;
			int y = PDMenuGUIScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PDMenuGUIButtonMessage(13, x, y, z));
				PDMenuGUIButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		});
		this.addButton(button_remove);
	}

	@Override
	public void tick() {
		super.tick();
		speedno.tick();
	}
}