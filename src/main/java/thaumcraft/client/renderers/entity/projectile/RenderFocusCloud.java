// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.client.renderers.entity.projectile;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderManager;
import java.util.Random;
import net.minecraft.client.renderer.entity.Render;

public class RenderFocusCloud extends Render
{
    private Random random;
    
    public RenderFocusCloud(RenderManager rm) {
        super(rm);
        random = new Random();
        shadowSize = 0.0f;
    }
    
    public void renderEntityAt(Entity entity, double x, double y, double z, float fq, float pticks) {
    }
    
    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
        renderEntityAt(entity, d, d1, d2, f, f1);
    }
    
    protected ResourceLocation getEntityTexture(Entity entity) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
}
