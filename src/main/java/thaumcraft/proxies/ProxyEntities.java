package thaumcraft.proxies;

import thaumcraft.common.golems.client.RenderThaumcraftGolem;
import thaumcraft.common.golems.EntityThaumcraftGolem;
import thaumcraft.client.renderers.entity.construct.RenderArcaneBore;
import thaumcraft.common.entities.construct.EntityArcaneBore;
import thaumcraft.client.renderers.entity.construct.RenderTurretCrossbow;
import thaumcraft.common.entities.construct.EntityTurretCrossbow;
import thaumcraft.client.renderers.entity.construct.RenderTurretCrossbowAdvanced;
import thaumcraft.common.entities.construct.EntityTurretCrossbowAdvanced;
import thaumcraft.common.entities.projectile.EntityCausalityCollapser;
import thaumcraft.client.renderers.entity.projectile.RenderGrapple;
import thaumcraft.common.entities.projectile.EntityGrapple;
import thaumcraft.client.renderers.entity.projectile.RenderEldritchOrb;
import thaumcraft.common.entities.projectile.EntityEldritchOrb;
import net.minecraft.client.renderer.entity.RenderSnowball;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.common.entities.projectile.EntityBottleTaint;
import thaumcraft.client.renderers.entity.projectile.RenderDart;
import thaumcraft.common.entities.projectile.EntityGolemDart;
import thaumcraft.client.renderers.entity.projectile.RenderElectricOrb;
import thaumcraft.common.entities.projectile.EntityGolemOrb;
import thaumcraft.common.entities.projectile.EntityAlumentum;
import thaumcraft.client.renderers.entity.projectile.RenderFocusMine;
import thaumcraft.common.entities.projectile.EntityFocusMine;
import thaumcraft.client.renderers.entity.projectile.RenderFocusCloud;
import thaumcraft.common.entities.projectile.EntityFocusCloud;
import thaumcraft.client.renderers.entity.projectile.RenderNoProjectile;
import thaumcraft.common.entities.projectile.EntityFocusProjectile;
import thaumcraft.client.renderers.entity.mob.RenderEldritchGolem;
import thaumcraft.client.renderers.models.entity.ModelEldritchGolem;
import thaumcraft.common.entities.monster.boss.EntityEldritchGolem;
import thaumcraft.common.entities.monster.boss.EntityEldritchWarden;
import thaumcraft.client.renderers.entity.construct.RenderCultistPortalLesser;
import thaumcraft.common.entities.monster.cult.EntityCultistPortalLesser;
import thaumcraft.client.renderers.entity.construct.RenderCultistPortalGreater;
import thaumcraft.common.entities.monster.boss.EntityCultistPortalGreater;
import thaumcraft.common.entities.monster.boss.EntityTaintacleGiant;
import thaumcraft.client.renderers.entity.mob.RenderEldritchCrab;
import thaumcraft.common.entities.monster.EntityEldritchCrab;
import thaumcraft.client.renderers.entity.mob.RenderMindSpider;
import thaumcraft.common.entities.monster.EntityMindSpider;
import thaumcraft.client.renderers.entity.mob.RenderEldritchGuardian;
import thaumcraft.client.renderers.models.entity.ModelEldritchGuardian;
import thaumcraft.common.entities.monster.EntityEldritchGuardian;
import thaumcraft.common.entities.monster.cult.EntityCultistCleric;
import thaumcraft.client.renderers.entity.mob.RenderCultistLeader;
import thaumcraft.common.entities.monster.boss.EntityCultistLeader;
import thaumcraft.client.renderers.entity.mob.RenderCultist;
import thaumcraft.common.entities.monster.cult.EntityCultistKnight;
import thaumcraft.client.renderers.entity.mob.RenderTaintSwarm;
import thaumcraft.common.entities.monster.tainted.EntityTaintSwarm;
import thaumcraft.common.entities.monster.tainted.EntityTaintacleSmall;
import thaumcraft.client.renderers.entity.mob.RenderTaintacle;
import thaumcraft.common.entities.monster.tainted.EntityTaintacle;
import thaumcraft.client.renderers.models.entity.ModelTaintSeed;
import thaumcraft.common.entities.monster.tainted.EntityTaintSeedPrime;
import thaumcraft.client.renderers.entity.mob.RenderTaintSeed;
import thaumcraft.common.entities.monster.tainted.EntityTaintSeed;
import thaumcraft.client.renderers.entity.mob.RenderTaintCrawler;
import thaumcraft.common.entities.monster.tainted.EntityTaintCrawler;
import net.minecraft.client.model.ModelBase;
import thaumcraft.client.renderers.entity.mob.RenderThaumicSlime;
import net.minecraft.client.model.ModelSlime;
import thaumcraft.common.entities.monster.EntityThaumicSlime;
import thaumcraft.client.renderers.entity.mob.RenderWisp;
import thaumcraft.common.entities.monster.EntityWisp;
import thaumcraft.client.renderers.entity.mob.RenderPech;
import thaumcraft.client.renderers.models.entity.ModelPech;
import thaumcraft.common.entities.monster.EntityPech;
import thaumcraft.client.renderers.entity.mob.RenderSpellBat;
import thaumcraft.common.entities.monster.EntitySpellBat;
import thaumcraft.client.renderers.entity.mob.RenderFireBat;
import thaumcraft.common.entities.monster.EntityFireBat;
import thaumcraft.common.entities.monster.EntityGiantBrainyZombie;
import thaumcraft.client.renderers.entity.mob.RenderInhabitedZombie;
import thaumcraft.common.entities.monster.EntityInhabitedZombie;
import thaumcraft.client.renderers.entity.mob.RenderBrainyZombie;
import thaumcraft.common.entities.monster.EntityBrainyZombie;
import thaumcraft.client.renderers.entity.RenderFluxRift;
import thaumcraft.common.entities.EntityFluxRift;
import thaumcraft.client.renderers.entity.RenderFallingTaint;
import thaumcraft.common.entities.EntityFallingTaint;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import thaumcraft.common.entities.EntityFollowingItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import thaumcraft.client.renderers.entity.RenderSpecialItem;
import net.minecraft.client.Minecraft;
import thaumcraft.common.entities.EntitySpecialItem;

public class ProxyEntities
{
    public void setupEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySpecialItem.class, new RenderSpecialItem(Minecraft.getMinecraft().getRenderManager(), Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityFollowingItem.class, new RenderEntityItem(Minecraft.getMinecraft().getRenderManager(), Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityFallingTaint.class, new RenderFallingTaint(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityFluxRift.class, new RenderFluxRift(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBrainyZombie.class, new RenderBrainyZombie(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInhabitedZombie.class, new RenderInhabitedZombie(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityGiantBrainyZombie.class, new RenderBrainyZombie(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityFireBat.class, new RenderFireBat(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySpellBat.class, new RenderSpellBat(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPech.class, new RenderPech(Minecraft.getMinecraft().getRenderManager(), new ModelPech(), 0.25f));
        RenderingRegistry.registerEntityRenderingHandler(EntityWisp.class, new RenderWisp(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityThaumicSlime.class, new RenderThaumicSlime(Minecraft.getMinecraft().getRenderManager(), new ModelSlime(16), 0.25f));
        RenderingRegistry.registerEntityRenderingHandler(EntityTaintCrawler.class, new RenderTaintCrawler(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTaintSeed.class, new RenderTaintSeed(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTaintSeedPrime.class, new RenderTaintSeed(Minecraft.getMinecraft().getRenderManager(), new ModelTaintSeed(), 0.6f));
        RenderingRegistry.registerEntityRenderingHandler(EntityTaintacle.class, new RenderTaintacle(Minecraft.getMinecraft().getRenderManager(), 0.6f, 10));
        RenderingRegistry.registerEntityRenderingHandler(EntityTaintacleSmall.class, new RenderTaintacle(Minecraft.getMinecraft().getRenderManager(), 0.2f, 6));
        RenderingRegistry.registerEntityRenderingHandler(EntityTaintSwarm.class, new RenderTaintSwarm(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCultistKnight.class, new RenderCultist(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCultistLeader.class, new RenderCultistLeader(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCultistCleric.class, new RenderCultist(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityEldritchGuardian.class, new RenderEldritchGuardian(Minecraft.getMinecraft().getRenderManager(), new ModelEldritchGuardian(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(EntityMindSpider.class, new RenderMindSpider(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityEldritchCrab.class, new RenderEldritchCrab(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTaintacleGiant.class, new RenderTaintacle(Minecraft.getMinecraft().getRenderManager(), 1.0f, 14));
        RenderingRegistry.registerEntityRenderingHandler(EntityCultistPortalGreater.class, new RenderCultistPortalGreater(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCultistPortalLesser.class, new RenderCultistPortalLesser(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityEldritchWarden.class, new RenderEldritchGuardian(Minecraft.getMinecraft().getRenderManager(), new ModelEldritchGuardian(), 0.6f));
        RenderingRegistry.registerEntityRenderingHandler(EntityEldritchGolem.class, new RenderEldritchGolem(Minecraft.getMinecraft().getRenderManager(), new ModelEldritchGolem(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(EntityFocusProjectile.class, new RenderNoProjectile(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityFocusCloud.class, new RenderFocusCloud(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityFocusMine.class, new RenderFocusMine(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityAlumentum.class, new RenderNoProjectile(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityGolemOrb.class, new RenderElectricOrb(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityGolemDart.class, new RenderDart(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBottleTaint.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ItemsTC.bottleTaint, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityEldritchOrb.class, new RenderEldritchOrb(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityGrapple.class, new RenderGrapple(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCausalityCollapser.class, new RenderNoProjectile(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTurretCrossbowAdvanced.class, new RenderTurretCrossbowAdvanced(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTurretCrossbow.class, new RenderTurretCrossbow(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityArcaneBore.class, new RenderArcaneBore(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityThaumcraftGolem.class, new RenderThaumcraftGolem(Minecraft.getMinecraft().getRenderManager()));
    }
}
