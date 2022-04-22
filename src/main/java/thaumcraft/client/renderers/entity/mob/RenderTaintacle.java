// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.client.renderers.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import thaumcraft.client.renderers.models.entity.ModelTaintacle;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class RenderTaintacle extends RenderLiving
{
    private static ResourceLocation rl;
    
    public RenderTaintacle(RenderManager rm, float shadow, int length) {
        super(rm, new ModelTaintacle(length, false), shadow);
    }
    
    protected ResourceLocation getEntityTexture(Entity entity) {
        return RenderTaintacle.rl;
    }
    
    static {
        rl = new ResourceLocation("thaumcraft", "textures/entity/taintacle.png");
    }
}
