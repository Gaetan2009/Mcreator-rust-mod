package net.mcreator.rust.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.rust.world.inventory.CodeMenu;
import net.mcreator.rust.init.RustModScreens;

public class CodeScreen extends AbstractContainerScreen<CodeMenu> implements RustModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_1;
	private Button button_2;
	private Button button_3;
	private Button button_4;
	private Button button_5;
	private Button button_6;
	private Button button_7;
	private Button button_8;
	private Button button_9;
	private Button button_0;
	private Button button_valide;

	public CodeScreen(CodeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 150;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("rust:textures/screens/code.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.rust.code.label_valeur"), 57, 116, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_1 = Button.builder(Component.translatable("gui.rust.code.button_1"), e -> {
		}).bounds(this.leftPos + 12, this.topPos + 16, 30, 20).build();
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.rust.code.button_2"), e -> {
		}).bounds(this.leftPos + 57, this.topPos + 16, 30, 20).build();
		this.addRenderableWidget(button_2);
		button_3 = Button.builder(Component.translatable("gui.rust.code.button_3"), e -> {
		}).bounds(this.leftPos + 102, this.topPos + 16, 30, 20).build();
		this.addRenderableWidget(button_3);
		button_4 = Button.builder(Component.translatable("gui.rust.code.button_4"), e -> {
		}).bounds(this.leftPos + 12, this.topPos + 41, 30, 20).build();
		this.addRenderableWidget(button_4);
		button_5 = Button.builder(Component.translatable("gui.rust.code.button_5"), e -> {
		}).bounds(this.leftPos + 57, this.topPos + 41, 30, 20).build();
		this.addRenderableWidget(button_5);
		button_6 = Button.builder(Component.translatable("gui.rust.code.button_6"), e -> {
		}).bounds(this.leftPos + 102, this.topPos + 41, 30, 20).build();
		this.addRenderableWidget(button_6);
		button_7 = Button.builder(Component.translatable("gui.rust.code.button_7"), e -> {
		}).bounds(this.leftPos + 12, this.topPos + 66, 30, 20).build();
		this.addRenderableWidget(button_7);
		button_8 = Button.builder(Component.translatable("gui.rust.code.button_8"), e -> {
		}).bounds(this.leftPos + 57, this.topPos + 66, 30, 20).build();
		this.addRenderableWidget(button_8);
		button_9 = Button.builder(Component.translatable("gui.rust.code.button_9"), e -> {
		}).bounds(this.leftPos + 102, this.topPos + 66, 30, 20).build();
		this.addRenderableWidget(button_9);
		button_0 = Button.builder(Component.translatable("gui.rust.code.button_0"), e -> {
		}).bounds(this.leftPos + 57, this.topPos + 91, 30, 20).build();
		this.addRenderableWidget(button_0);
		button_valide = Button.builder(Component.translatable("gui.rust.code.button_valide"), e -> {
		}).bounds(this.leftPos + 47, this.topPos + 136, 56, 20).build();
		this.addRenderableWidget(button_valide);
	}
}