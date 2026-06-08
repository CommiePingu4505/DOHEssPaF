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

import net.mcreator.dohess.world.inventory.GeneralManagingMenuMenu;
import net.mcreator.dohess.procedures.ReturnTCIProcedure;
import net.mcreator.dohess.procedures.ReturnPDManagementProcedure;
import net.mcreator.dohess.procedures.ReturnNameProcedure;
import net.mcreator.dohess.procedures.ReturnColourProcedure;
import net.mcreator.dohess.network.GeneralManagingMenuButtonMessage;
import net.mcreator.dohess.init.DohessModScreens;
import net.mcreator.dohess.DohessMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class GeneralManagingMenuScreen extends ContainerScreen<GeneralManagingMenuMenu> implements DohessModScreens.ScreenAccessor {
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	private boolean menuStateUpdateActive = false;
	TextFieldWidget squad;
	TextFieldWidget hexsquad;
	TextFieldWidget rank;
	TextFieldWidget hexrank;
	TextFieldWidget prioritysquad;
	TextFieldWidget priorityrank;
	Button button_empty;
	Button button_empty1;
	Button button_ok;
	Button button_ok1;
	Button button_empty3;
	Button button_empty2;
	Button button_empty4;

	public GeneralManagingMenuScreen(GeneralManagingMenuMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 400;
		this.ySize = 200;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String) {
			if (name.equals("squad"))
				squad.setText((String) elementState);
			else if (name.equals("hexsquad"))
				hexsquad.setText((String) elementState);
			else if (name.equals("rank"))
				rank.setText((String) elementState);
			else if (name.equals("hexrank"))
				hexrank.setText((String) elementState);
			else if (name.equals("prioritysquad"))
				prioritysquad.setText((String) elementState);
			else if (name.equals("priorityrank"))
				priorityrank.setText((String) elementState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = new ResourceLocation("dohess:textures/screens/general_managing_menu.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		squad.render(ms, mouseX, mouseY, partialTicks);
		hexsquad.render(ms, mouseX, mouseY, partialTicks);
		rank.render(ms, mouseX, mouseY, partialTicks);
		hexrank.render(ms, mouseX, mouseY, partialTicks);
		prioritysquad.render(ms, mouseX, mouseY, partialTicks);
		priorityrank.render(ms, mouseX, mouseY, partialTicks);
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
		if (squad.isFocused())
			return squad.keyPressed(key, b, c);
		if (hexsquad.isFocused())
			return hexsquad.keyPressed(key, b, c);
		if (rank.isFocused())
			return rank.keyPressed(key, b, c);
		if (hexrank.isFocused())
			return hexrank.keyPressed(key, b, c);
		if (prioritysquad.isFocused())
			return prioritysquad.keyPressed(key, b, c);
		if (priorityrank.isFocused())
			return priorityrank.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String squadValue = squad.getText();
		String hexsquadValue = hexsquad.getText();
		String rankValue = rank.getText();
		String hexrankValue = hexrank.getText();
		String prioritysquadValue = prioritysquad.getText();
		String priorityrankValue = priorityrank.getText();
		super.resize(minecraft, width, height);
		squad.setText(squadValue);
		hexsquad.setText(hexsquadValue);
		rank.setText(rankValue);
		hexrank.setText(hexrankValue);
		prioritysquad.setText(prioritysquadValue);
		priorityrank.setText(priorityrankValue);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.general_managing_menu.label_teams"), 10, 6, -12829636);
		this.font.func_243248_b(ms, new StringTextComponent(ReturnPDManagementProcedure.execute(world, entity)), 19, 33, -12829636);
		this.font.func_243248_b(ms, new StringTextComponent(ReturnTCIProcedure.execute(world, entity)), 19, 60, -12829636);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.general_managing_menu.label_name_display"), 334, 6, -12829636);
		this.font.func_243248_b(ms, new StringTextComponent(ReturnColourProcedure.execute(world, entity)), 307, 132, -12829636);
		this.font.func_243248_b(ms, new StringTextComponent(ReturnNameProcedure.execute(world, entity)), 316, 33, -12829636);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.general_managing_menu.label_rank"), 181, 87, -12829636);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.general_managing_menu.label_squad"), 181, 51, -12829636);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.general_managing_menu.label_hexcode"), 298, 51, -12829636);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.general_managing_menu.label_hexcode1"), 298, 87, -12829636);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.general_managing_menu.label_p"), 352, 51, -12829636);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.general_managing_menu.label_p1"), 352, 87, -12829636);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		squad = new TextFieldWidget(this.font, this.guiLeft + 182, this.guiTop + 61, 118, 18, new TranslationTextComponent("gui.dohess.general_managing_menu.squad"));
		squad.setMaxStringLength(8192);
		squad.setResponder(content -> {
			if (!menuStateUpdateActive)
				container.sendMenuStateUpdate(entity, 0, "squad", content, false);
		});
		this.addListener(this.squad);
		hexsquad = new TextFieldWidget(this.font, this.guiLeft + 299, this.guiTop + 61, 52, 18, new TranslationTextComponent("gui.dohess.general_managing_menu.hexsquad"));
		hexsquad.setMaxStringLength(8192);
		hexsquad.setResponder(content -> {
			if (!menuStateUpdateActive)
				container.sendMenuStateUpdate(entity, 0, "hexsquad", content, false);
		});
		this.addListener(this.hexsquad);
		rank = new TextFieldWidget(this.font, this.guiLeft + 182, this.guiTop + 97, 118, 18, new TranslationTextComponent("gui.dohess.general_managing_menu.rank"));
		rank.setMaxStringLength(8192);
		rank.setResponder(content -> {
			if (!menuStateUpdateActive)
				container.sendMenuStateUpdate(entity, 0, "rank", content, false);
		});
		this.addListener(this.rank);
		hexrank = new TextFieldWidget(this.font, this.guiLeft + 299, this.guiTop + 97, 52, 18, new TranslationTextComponent("gui.dohess.general_managing_menu.hexrank"));
		hexrank.setMaxStringLength(8192);
		hexrank.setResponder(content -> {
			if (!menuStateUpdateActive)
				container.sendMenuStateUpdate(entity, 0, "hexrank", content, false);
		});
		this.addListener(this.hexrank);
		prioritysquad = new TextFieldWidget(this.font, this.guiLeft + 353, this.guiTop + 61, 16, 18, new TranslationTextComponent("gui.dohess.general_managing_menu.prioritysquad"));
		prioritysquad.setMaxStringLength(8192);
		prioritysquad.setResponder(content -> {
			if (!menuStateUpdateActive)
				container.sendMenuStateUpdate(entity, 0, "prioritysquad", content, false);
		});
		this.addListener(this.prioritysquad);
		priorityrank = new TextFieldWidget(this.font, this.guiLeft + 353, this.guiTop + 97, 16, 18, new TranslationTextComponent("gui.dohess.general_managing_menu.priorityrank"));
		priorityrank.setMaxStringLength(8192);
		priorityrank.setResponder(content -> {
			if (!menuStateUpdateActive)
				container.sendMenuStateUpdate(entity, 0, "priorityrank", content, false);
		});
		this.addListener(this.priorityrank);
		button_empty = new Button(this.guiLeft + 10, this.guiTop + 24, 81, 20, new TranslationTextComponent("gui.dohess.general_managing_menu.button_empty"), e -> {
			int x = GeneralManagingMenuScreen.this.x;
			int y = GeneralManagingMenuScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new GeneralManagingMenuButtonMessage(0, x, y, z));
				GeneralManagingMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		this.addButton(button_empty);
		button_empty1 = new Button(this.guiLeft + 10, this.guiTop + 51, 81, 20, new TranslationTextComponent("gui.dohess.general_managing_menu.button_empty1"), e -> {
			int x = GeneralManagingMenuScreen.this.x;
			int y = GeneralManagingMenuScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new GeneralManagingMenuButtonMessage(1, x, y, z));
				GeneralManagingMenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		this.addButton(button_empty1);
		button_ok = new Button(this.guiLeft + 370, this.guiTop + 60, 18, 20, new TranslationTextComponent("gui.dohess.general_managing_menu.button_ok"), e -> {
			int x = GeneralManagingMenuScreen.this.x;
			int y = GeneralManagingMenuScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new GeneralManagingMenuButtonMessage(2, x, y, z));
				GeneralManagingMenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		this.addButton(button_ok);
		button_ok1 = new Button(this.guiLeft + 370, this.guiTop + 96, 18, 20, new TranslationTextComponent("gui.dohess.general_managing_menu.button_ok1"), e -> {
			int x = GeneralManagingMenuScreen.this.x;
			int y = GeneralManagingMenuScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new GeneralManagingMenuButtonMessage(3, x, y, z));
				GeneralManagingMenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		this.addButton(button_ok1);
		button_empty3 = new Button(this.guiLeft + 307, this.guiTop + 24, 81, 20, new TranslationTextComponent("gui.dohess.general_managing_menu.button_empty3"), e -> {
			int x = GeneralManagingMenuScreen.this.x;
			int y = GeneralManagingMenuScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new GeneralManagingMenuButtonMessage(4, x, y, z));
				GeneralManagingMenuButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		this.addButton(button_empty3);
		button_empty2 = new Button(this.guiLeft + 289, this.guiTop + 123, 18, 20, new TranslationTextComponent("gui.dohess.general_managing_menu.button_empty2"), e -> {
			int x = GeneralManagingMenuScreen.this.x;
			int y = GeneralManagingMenuScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new GeneralManagingMenuButtonMessage(5, x, y, z));
				GeneralManagingMenuButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		this.addButton(button_empty2);
		button_empty4 = new Button(this.guiLeft + 370, this.guiTop + 123, 18, 20, new TranslationTextComponent("gui.dohess.general_managing_menu.button_empty4"), e -> {
			int x = GeneralManagingMenuScreen.this.x;
			int y = GeneralManagingMenuScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new GeneralManagingMenuButtonMessage(6, x, y, z));
				GeneralManagingMenuButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		this.addButton(button_empty4);
	}

	@Override
	public void tick() {
		super.tick();
		squad.tick();
		hexsquad.tick();
		rank.tick();
		hexrank.tick();
		prioritysquad.tick();
		priorityrank.tick();
	}
}