package cofh.core.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;

public interface IGuiAccess {

    int getGuiTop();

    int getGuiLeft();

    FontRenderer getFontRenderer();

    PlayerEntity getPlayer();

    boolean handleElementButtonClick(String buttonName, int mouseButton);

    void drawIcon(MatrixStack matrixStack, TextureAtlasSprite icon, int x, int y);

    void drawIcon(MatrixStack matrixStack, TextureAtlasSprite icon, int color, int x, int y);

    void drawIcon(MatrixStack matrixStack, ResourceLocation loc, int x, int y);

    void drawIcon(MatrixStack matrixStack, ResourceLocation loc, int color, int x, int y);

    void drawSizedRect(int x1, int y1, int x2, int y2, int color);

    void drawColoredModalRect(int x1, int y1, int x2, int y2, int color);

    void drawTexturedModalRect(int x, int y, int u, int v, int width, int height);

    void drawTexturedModalRect(int x, int y, int u, int v, int width, int height, float texW, float texH);

}
