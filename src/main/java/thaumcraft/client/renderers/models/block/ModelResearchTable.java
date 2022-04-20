// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.client.renderers.models.block;

import java.awt.Color;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelResearchTable extends ModelBase
{
    ModelRenderer Inkwell;
    ModelRenderer ScrollTube;
    ModelRenderer ScrollRibbon;
    
    public ModelResearchTable() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Inkwell = new ModelRenderer(this, 0, 16)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 3);
        this.Inkwell.setRotationPoint(-6.0f, -2.0f, 3.0f);
        this.Inkwell.mirror = true;
        this.setRotation(this.Inkwell, 0.0f, 0.0f, 0.0f);
        (this.ScrollTube = new ModelRenderer(this, 0, 0)).addBox(-8.0f, -0.5f, 0.0f, 8, 2, 2);
        this.ScrollTube.setRotationPoint(-2.0f, -2.0f, 2.0f);
        this.ScrollTube.mirror = true;
        this.setRotation(this.ScrollTube, 0.0f, 10.0f, 0.0f);
        (this.ScrollRibbon = new ModelRenderer(this, 0, 4)).addBox(-4.25f, -0.275f, 0.0f, 1, 2, 2);
        this.ScrollRibbon.setRotationPoint(-2.0f, -2.0f, 2.0f);
        this.ScrollRibbon.mirror = true;
        this.setRotation(this.ScrollRibbon, 0.0f, 10.0f, 0.0f);
    }
    
    public void renderInkwell() {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        this.Inkwell.render(0.0625f);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public void renderScroll(final int color) {
        GL11.glPushMatrix();
        this.ScrollTube.render(0.0625f);
        final Color c = new Color(color);
        GL11.glColor4f(c.getRed() / 255.0f, c.getGreen() / 255.0f, c.getBlue() / 255.0f, 1.0f);
        GL11.glScalef(1.2f, 1.2f, 1.2f);
        this.ScrollRibbon.render(0.0625f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}