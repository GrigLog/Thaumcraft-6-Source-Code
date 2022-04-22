// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.common.entities.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;
import thaumcraft.client.fx.FXDispatcher;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityAlumentum extends EntityThrowable
{
    public EntityAlumentum(World par1World) {
        super(par1World);
    }
    
    public EntityAlumentum(World par1World, EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityAlumentum(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        super.shoot(x, y, z, 0.75f, inaccuracy);
    }
    
    public void onUpdate() {
        super.onUpdate();
        if (world.isRemote) {
            for (double i = 0.0; i < 3.0; ++i) {
                double coeff = i / 3.0;
                FXDispatcher.INSTANCE.drawAlumentum((float)(prevPosX + (posX - prevPosX) * coeff), (float)(prevPosY + (posY - prevPosY) * coeff) + height / 2.0f, (float)(prevPosZ + (posZ - prevPosZ) * coeff), 0.0125f * (rand.nextFloat() - 0.5f), 0.0125f * (rand.nextFloat() - 0.5f), 0.0125f * (rand.nextFloat() - 0.5f), rand.nextFloat() * 0.2f, rand.nextFloat() * 0.1f, rand.nextFloat() * 0.1f, 0.5f, 4.0f);
                FXDispatcher.INSTANCE.drawGenericParticles(posX + world.rand.nextGaussian() * 0.20000000298023224, posY + world.rand.nextGaussian() * 0.20000000298023224, posZ + world.rand.nextGaussian() * 0.20000000298023224, 0.0, 0.0, 0.0, 1.0f, 1.0f, 1.0f, 0.7f, false, 448, 8, 1, 8, 0, 0.3f, 0.0f, 1);
            }
        }
    }
    
    protected void onImpact(RayTraceResult par1RayTraceResult) {
        if (!world.isRemote) {
            world.createExplosion(this, posX, posY, posZ, 1.1f, true);
            setDead();
        }
    }
}
