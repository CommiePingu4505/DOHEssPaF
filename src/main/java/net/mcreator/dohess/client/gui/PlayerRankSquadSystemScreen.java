package net.mcreator.dohess.client.gui;

import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.dohess.world.inventory.PlayerRankSquadSystemMenu;
import net.mcreator.dohess.procedures.ShowSL8Procedure;
import net.mcreator.dohess.procedures.ShowSL7Procedure;
import net.mcreator.dohess.procedures.ShowSL6Procedure;
import net.mcreator.dohess.procedures.ShowSL5Procedure;
import net.mcreator.dohess.procedures.ShowSL4Procedure;
import net.mcreator.dohess.procedures.ShowSL3Procedure;
import net.mcreator.dohess.procedures.ShowSL2Procedure;
import net.mcreator.dohess.procedures.ShowSL1Procedure;
import net.mcreator.dohess.procedures.ShowRank9Procedure;
import net.mcreator.dohess.procedures.ShowRank8Procedure;
import net.mcreator.dohess.procedures.ShowRank7Procedure;
import net.mcreator.dohess.procedures.ShowRank6Procedure;
import net.mcreator.dohess.procedures.ShowRank5Procedure;
import net.mcreator.dohess.procedures.ShowRank4Procedure;
import net.mcreator.dohess.procedures.ShowRank3Procedure;
import net.mcreator.dohess.procedures.ShowRank2Procedure;
import net.mcreator.dohess.procedures.ShowRank20Procedure;
import net.mcreator.dohess.procedures.ShowRank1Procedure;
import net.mcreator.dohess.procedures.ShowRank19Procedure;
import net.mcreator.dohess.procedures.ShowRank18Procedure;
import net.mcreator.dohess.procedures.ShowRank17Procedure;
import net.mcreator.dohess.procedures.ShowRank16Procedure;
import net.mcreator.dohess.procedures.ShowRank15Procedure;
import net.mcreator.dohess.procedures.ShowRank14Procedure;
import net.mcreator.dohess.procedures.ShowRank13Procedure;
import net.mcreator.dohess.procedures.ShowRank12Procedure;
import net.mcreator.dohess.procedures.ShowRank11Procedure;
import net.mcreator.dohess.procedures.ShowRank10Procedure;
import net.mcreator.dohess.procedures.ReturnPlayerGUIRankSquadProcedure;
import net.mcreator.dohess.network.PlayerRankSquadSystemButtonMessage;
import net.mcreator.dohess.init.DohessModScreens;
import net.mcreator.dohess.DohessMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class PlayerRankSquadSystemScreen extends ContainerScreen<PlayerRankSquadSystemMenu> implements DohessModScreens.ScreenAccessor {
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	private boolean menuStateUpdateActive = false;
	Button button_empty;
	Button button_empty1;
	Button button_empty2;
	Button button_empty3;
	Button button_empty4;
	Button button_empty5;
	Button button_empty6;
	Button button_empty7;
	Button button_empty8;
	Button button_empty9;
	Button button_empty10;
	Button button_empty11;
	Button button_empty12;
	Button button_empty13;
	Button button_empty14;
	Button button_empty15;
	Button button_empty16;
	Button button_empty17;
	Button button_empty18;
	Button button_empty19;
	Button button_empty20;
	Button button_empty21;
	Button button_empty22;
	Button button_empty23;
	Button button_empty24;
	Button button_empty25;
	Button button_empty26;
	Button button_empty27;
	ImageButton imagebutton_govemblem24x24;
	ImageButton imagebutton_tcemblem;
	ImageButton imagebutton_slemblem24x24;

	public PlayerRankSquadSystemScreen(PlayerRankSquadSystemMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 350;
		this.ySize = 220;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = new ResourceLocation("dohess:textures/screens/player_rank_squad_system.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		if (ReturnPlayerGUIRankSquadProcedure.execute(world, entity) instanceof LivingEntity) {
			InventoryScreen.drawEntityOnScreen(this.guiLeft + 193, this.guiTop + 198, 30, 0f, 0, (LivingEntity) ReturnPlayerGUIRankSquadProcedure.execute(world, entity));
		}
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
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank1Procedure.execute(world)), 30, 25, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank2Procedure.execute(world)), 30, 43, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank3Procedure.execute(world)), 30, 61, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank5Procedure.execute(world)), 30, 97, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank4Procedure.execute(world)), 30, 79, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank6Procedure.execute(world)), 30, 115, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank7Procedure.execute(world)), 30, 133, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank8Procedure.execute(world)), 30, 151, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank9Procedure.execute(world)), 30, 169, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank10Procedure.execute(world)), 30, 187, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank11Procedure.execute(world)), 93, 25, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank12Procedure.execute(world)), 93, 43, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank13Procedure.execute(world)), 93, 61, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank14Procedure.execute(world)), 93, 79, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank15Procedure.execute(world)), 93, 97, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank16Procedure.execute(world)), 93, 115, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank17Procedure.execute(world)), 93, 133, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank18Procedure.execute(world)), 93, 151, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank19Procedure.execute(world)), 93, 169, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowRank20Procedure.execute(world)), 93, 187, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowSL1Procedure.execute(world)), 228, 25, -1);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.player_rank_squad_system.label_ranks"), 75, 7, -16777165);
		this.font.func_243248_b(ms, new TranslationTextComponent("gui.dohess.player_rank_squad_system.label_squads"), 273, 7, -16777165);
		this.font.func_243248_b(ms, new StringTextComponent(ShowSL2Procedure.execute(world)), 228, 43, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowSL3Procedure.execute(world)), 228, 61, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowSL4Procedure.execute(world)), 228, 79, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowSL6Procedure.execute(world)), 228, 115, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowSL5Procedure.execute(world)), 228, 97, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowSL7Procedure.execute(world)), 228, 133, -1);
		this.font.func_243248_b(ms, new StringTextComponent(ShowSL8Procedure.execute(world)), 228, 151, -1);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		button_empty = new Button(this.guiLeft + 30, this.guiTop + 16, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(0, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		this.addButton(button_empty);
		button_empty1 = new Button(this.guiLeft + 30, this.guiTop + 34, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty1"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(1, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		this.addButton(button_empty1);
		button_empty2 = new Button(this.guiLeft + 30, this.guiTop + 52, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty2"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(2, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		this.addButton(button_empty2);
		button_empty3 = new Button(this.guiLeft + 30, this.guiTop + 70, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty3"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(3, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		this.addButton(button_empty3);
		button_empty4 = new Button(this.guiLeft + 30, this.guiTop + 88, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty4"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(4, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		this.addButton(button_empty4);
		button_empty5 = new Button(this.guiLeft + 30, this.guiTop + 124, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty5"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(5, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		this.addButton(button_empty5);
		button_empty6 = new Button(this.guiLeft + 30, this.guiTop + 106, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty6"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(6, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		this.addButton(button_empty6);
		button_empty7 = new Button(this.guiLeft + 30, this.guiTop + 142, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty7"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(7, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		this.addButton(button_empty7);
		button_empty8 = new Button(this.guiLeft + 30, this.guiTop + 160, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty8"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(8, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		this.addButton(button_empty8);
		button_empty9 = new Button(this.guiLeft + 30, this.guiTop + 178, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty9"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(9, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		this.addButton(button_empty9);
		button_empty10 = new Button(this.guiLeft + 93, this.guiTop + 178, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty10"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(10, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		this.addButton(button_empty10);
		button_empty11 = new Button(this.guiLeft + 93, this.guiTop + 16, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty11"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(11, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		this.addButton(button_empty11);
		button_empty12 = new Button(this.guiLeft + 93, this.guiTop + 34, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty12"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(12, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		});
		this.addButton(button_empty12);
		button_empty13 = new Button(this.guiLeft + 93, this.guiTop + 52, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty13"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(13, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		});
		this.addButton(button_empty13);
		button_empty14 = new Button(this.guiLeft + 93, this.guiTop + 70, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty14"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(14, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 14, x, y, z);
			}
		});
		this.addButton(button_empty14);
		button_empty15 = new Button(this.guiLeft + 93, this.guiTop + 88, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty15"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(15, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		});
		this.addButton(button_empty15);
		button_empty16 = new Button(this.guiLeft + 93, this.guiTop + 106, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty16"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(16, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		});
		this.addButton(button_empty16);
		button_empty17 = new Button(this.guiLeft + 93, this.guiTop + 124, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty17"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(17, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}
		});
		this.addButton(button_empty17);
		button_empty18 = new Button(this.guiLeft + 93, this.guiTop + 142, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty18"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(18, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}
		});
		this.addButton(button_empty18);
		button_empty19 = new Button(this.guiLeft + 93, this.guiTop + 160, 63, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty19"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(19, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 19, x, y, z);
			}
		});
		this.addButton(button_empty19);
		button_empty20 = new Button(this.guiLeft + 228, this.guiTop + 16, 108, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty20"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(20, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 20, x, y, z);
			}
		});
		this.addButton(button_empty20);
		button_empty21 = new Button(this.guiLeft + 228, this.guiTop + 34, 108, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty21"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(21, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 21, x, y, z);
			}
		});
		this.addButton(button_empty21);
		button_empty22 = new Button(this.guiLeft + 228, this.guiTop + 52, 108, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty22"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(22, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 22, x, y, z);
			}
		});
		this.addButton(button_empty22);
		button_empty23 = new Button(this.guiLeft + 228, this.guiTop + 70, 108, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty23"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(23, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 23, x, y, z);
			}
		});
		this.addButton(button_empty23);
		button_empty24 = new Button(this.guiLeft + 228, this.guiTop + 88, 108, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty24"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(24, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 24, x, y, z);
			}
		});
		this.addButton(button_empty24);
		button_empty25 = new Button(this.guiLeft + 228, this.guiTop + 106, 108, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty25"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(25, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 25, x, y, z);
			}
		});
		this.addButton(button_empty25);
		button_empty26 = new Button(this.guiLeft + 228, this.guiTop + 124, 108, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty26"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(26, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 26, x, y, z);
			}
		});
		this.addButton(button_empty26);
		button_empty27 = new Button(this.guiLeft + 228, this.guiTop + 142, 108, 20, new TranslationTextComponent("gui.dohess.player_rank_squad_system.button_empty27"), e -> {
			int x = PlayerRankSquadSystemScreen.this.x;
			int y = PlayerRankSquadSystemScreen.this.y;
			if (true) {
				DohessMod.PACKET_HANDLER.sendToServer(new PlayerRankSquadSystemButtonMessage(27, x, y, z));
				PlayerRankSquadSystemButtonMessage.handleButtonAction(entity, 27, x, y, z);
			}
		});
		this.addButton(button_empty27);
		imagebutton_govemblem24x24 = new ImageButton(this.guiLeft + 3, this.guiTop + 43, 24, 24, 0, 0, 24, new ResourceLocation("dohess:textures/screens/atlas/imagebutton_govemblem24x24.png"), 24, 48, e -> {
		});
		this.addButton(imagebutton_govemblem24x24);
		imagebutton_tcemblem = new ImageButton(this.guiLeft + 3, this.guiTop + 70, 24, 24, 0, 0, 24, new ResourceLocation("dohess:textures/screens/atlas/imagebutton_tcemblem.png"), 24, 48, e -> {
		});
		this.addButton(imagebutton_tcemblem);
		imagebutton_slemblem24x24 = new ImageButton(this.guiLeft + 3, this.guiTop + 16, 24, 24, 0, 0, 24, new ResourceLocation("dohess:textures/screens/atlas/imagebutton_slemblem24x24.png"), 24, 48, e -> {
		});
		this.addButton(imagebutton_slemblem24x24);
	}
}