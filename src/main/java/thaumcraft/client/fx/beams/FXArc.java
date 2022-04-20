// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.client.fx.beams;

import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.BufferBuilder;
import thaumcraft.client.fx.ParticleEngine;
import net.minecraft.util.math.MathHelper;
import thaumcraft.client.fx.particles.FXGeneric;
import thaumcraft.common.lib.utils.Utils;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import java.util.ArrayList;
import net.minecraft.client.particle.Particle;

public class FXArc extends Particle
{
    public int particle;
    ArrayList<Vec3d> points;
    private Entity targetEntity;
    private double tX;
    private double tY;
    private double tZ;
    ResourceLocation beam;
    public int blendmode;
    public float length;
    
    public FXArc(final World par1World, final double x, final double y, final double z, final double tx, final double ty, final double tz, final float red, final float green, final float blue, final double hg) {
        super(par1World, x, y, z, 0.0, 0.0, 0.0);
        this.particle = 16;
        this.points = new ArrayList<Vec3d>();
        this.targetEntity = null;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.beam = new ResourceLocation("thaumcraft", "textures/misc/beamh.png");
        this.blendmode = 1;
        this.length = 1.0f;
        this.particleRed = red;
        this.particleGreen = green;
        this.particleBlue = blue;
        this.setSize(0.02f, 0.02f);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.tX = tx - x;
        this.tY = ty - y;
        this.tZ = tz - z;
        this.particleMaxAge = 3;
        final double xx = 0.0;
        final double yy = 0.0;
        final double zz = 0.0;
        final double gravity = 0.115;
        final double noise = 0.25;
        final Vec3d vs = new Vec3d(xx, yy, zz);
        final Vec3d ve = new Vec3d(this.tX, this.tY, this.tZ);
        Vec3d vc = new Vec3d(xx, yy, zz);
        this.length = (float)ve.lengthVector();
        Vec3d vv = Utils.calculateVelocity(vs, ve, hg, gravity);
        final double l = Utils.distanceSquared3d(new Vec3d(0.0, 0.0, 0.0), vv);
        this.points.add(vs);
        for (int c = 0; Utils.distanceSquared3d(ve, vc) > l && c < 50; ++c) {
            Vec3d vt = vc.addVector(vv.x, vv.y, vv.z);
            vc = new Vec3d(vt.x, vt.y, vt.z);
            vt = vt.addVector((this.rand.nextDouble() - this.rand.nextDouble()) * noise, (this.rand.nextDouble() - this.rand.nextDouble()) * noise, (this.rand.nextDouble() - this.rand.nextDouble()) * noise);
            this.points.add(vt);
            final FXGeneric fb = new FXGeneric(par1World, x + vt.x, y + vt.y, z + vt.z, 0.0, 0.0, 0.0);
            final int age = 30 + this.rand.nextInt(20);
            fb.setMaxAge(age);
            fb.setRBGColorF(MathHelper.clamp(red * 3.0f, 0.0f, 1.0f), MathHelper.clamp(green * 3.0f, 0.0f, 1.0f), MathHelper.clamp(blue * 3.0f, 0.0f, 1.0f), this.rand.nextFloat(), this.rand.nextFloat(), this.rand.nextFloat());
            final float[] alphas = new float[6 + this.rand.nextInt(age / 3)];
            for (int a = 1; a < alphas.length - 1; ++a) {
                alphas[a] = this.rand.nextFloat();
            }
            alphas[0] = 1.0f;
            fb.setAlphaF(alphas);
            final boolean sp = this.rand.nextFloat() < 0.2;
            fb.setParticles(sp ? 320 : 512, 16, 1);
            fb.setLoop(true);
            fb.setGravity(sp ? 0.0f : 0.125f);
            fb.setScale(0.5f, 0.125f);
            fb.setLayer(0);
            fb.setSlowDown(0.995);
            fb.setRandomMovementScale(0.0025f, 0.001f, 0.0025f);
            ParticleEngine.addEffectWithDelay(par1World, fb, 2 + this.rand.nextInt(3));
            vv = vv.subtract(0.0, gravity / 1.9, 0.0);
        }
        this.points.add(ve);
    }
    
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
    }
    
    public void setRGB(final float r, final float g, final float b) {
        this.particleRed = r;
        this.particleGreen = g;
        this.particleBlue = b;
    }
    
    public void renderParticle(final BufferBuilder wr, final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        Tessellator.getInstance().draw();
        GL11.glPushMatrix();
        final double ePX = this.prevPosX + (this.posX - this.prevPosX) * f - FXArc.interpPosX;
        final double ePY = this.prevPosY + (this.posY - this.prevPosY) * f - FXArc.interpPosY;
        final double ePZ = this.prevPosZ + (this.posZ - this.prevPosZ) * f - FXArc.interpPosZ;
        GL11.glTranslated(ePX, ePY, ePZ);
        final float size = 0.125f;
        Minecraft.getMinecraft().renderEngine.bindTexture(this.beam);
        GL11.glDepthMask(false);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        GL11.glDisable(2884);
        final int i = 220;
        final int j = i >> 16 & 0xFFFF;
        final int k = i & 0xFFFF;
        final float alpha = 1.0f - (this.particleAge + f) / this.particleMaxAge;
        wr.begin(5, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
        final float f6 = 0.0f;
        final float f7 = 1.0f;
        for (int c = 0; c < this.points.size(); ++c) {
            final Vec3d v = this.points.get(c);
            final float f8 = c / this.length;
            final double dx = v.x;
            final double dy = v.y;
            final double dz = v.z;
            wr.pos(dx, dy - size, dz).tex(f8, f7).lightmap(j, k).color(this.particleRed, this.particleGreen, this.particleBlue, alpha).endVertex();
            wr.pos(dx, dy + size, dz).tex(f8, f6).lightmap(j, k).color(this.particleRed, this.particleGreen, this.particleBlue, alpha).endVertex();
        }
        Tessellator.getInstance().draw();
        wr.begin(5, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
        for (int c = 0; c < this.points.size(); ++c) {
            final Vec3d v = this.points.get(c);
            final float f8 = c / this.length;
            final double dx = v.x;
            final double dy = v.y;
            final double dz = v.z;
            wr.pos(dx - size, dy, dz - size).tex(f8, f7).lightmap(j, k).color(this.particleRed, this.particleGreen, this.particleBlue, alpha).endVertex();
            wr.pos(dx + size, dy, dz + size).tex(f8, f6).lightmap(j, k).color(this.particleRed, this.particleGreen, this.particleBlue, alpha).endVertex();
        }
        Tessellator.getInstance().draw();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(2884);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
        GL11.glPopMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(ParticleManager.PARTICLE_TEXTURES);
        wr.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
    }
}