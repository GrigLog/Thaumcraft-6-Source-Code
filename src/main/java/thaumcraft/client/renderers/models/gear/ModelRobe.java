package thaumcraft.client.renderers.models.gear;

import org.lwjgl.opengl.GL11;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelRobe extends ModelCustomArmor
{
    ModelRenderer Hood1;
    ModelRenderer Hood2;
    ModelRenderer Hood3;
    ModelRenderer Hood4;
    ModelRenderer Chestthing;
    ModelRenderer Mbelt;
    ModelRenderer MbeltB;
    ModelRenderer ClothchestL;
    ModelRenderer ClothchestR;
    ModelRenderer Book;
    ModelRenderer Scroll;
    ModelRenderer BeltR;
    ModelRenderer Backplate;
    ModelRenderer MbeltL;
    ModelRenderer MbeltR;
    ModelRenderer BeltL;
    ModelRenderer Chestplate;
    ModelRenderer ShoulderplateR1;
    ModelRenderer ShoulderplateR2;
    ModelRenderer ShoulderplateR3;
    ModelRenderer ShoulderplateTopR;
    ModelRenderer RArm1;
    ModelRenderer RArm2;
    ModelRenderer RArm3;
    ModelRenderer LArm1;
    ModelRenderer LArm2;
    ModelRenderer LArm3;
    ModelRenderer ShoulderplateL1;
    ModelRenderer ShoulderplateL2;
    ModelRenderer ShoulderplateL3;
    ModelRenderer ShoulderplateTopL;
    ModelRenderer ShoulderL;
    ModelRenderer ShoulderR;
    ModelRenderer ClothBackR3;
    ModelRenderer FrontclothR2;
    ModelRenderer FrontclothR1;
    ModelRenderer SideclothR2;
    ModelRenderer SideclothR1;
    ModelRenderer SideclothR3;
    ModelRenderer ClothBackR1;
    ModelRenderer ClothBackR2;
    ModelRenderer SidepanelR1;
    ModelRenderer LegpanelR6;
    ModelRenderer LegpanelR5;
    ModelRenderer LegpanelR4;
    ModelRenderer FrontclothL2;
    ModelRenderer ClothBackL3;
    ModelRenderer ClothBackL1;
    ModelRenderer FrontclothL1;
    ModelRenderer SideclothL2;
    ModelRenderer SideclothL3;
    ModelRenderer Focipouch;
    ModelRenderer SideclothL1;
    ModelRenderer ClothBackL2;
    ModelRenderer LegpanelL4;
    ModelRenderer LegpanelL5;
    ModelRenderer LegpanelL6;
    ModelRenderer SidepanelL1;
    
    public ModelRobe(float f) {
        super(f, 0, 128, 64);
        textureWidth = 128;
        textureHeight = 64;
        (Hood1 = new ModelRenderer(this, 16, 7)).addBox(-4.5f, -9.0f, -4.6f, 9, 9, 9);
        Hood1.setTextureSize(128, 64);
        setRotation(Hood1, 0.0f, 0.0f, 0.0f);
        (Hood2 = new ModelRenderer(this, 52, 13)).addBox(-4.0f, -9.7f, 2.0f, 8, 9, 3);
        Hood2.setTextureSize(128, 64);
        setRotation(Hood2, -0.2268928f, 0.0f, 0.0f);
        (Hood3 = new ModelRenderer(this, 52, 14)).addBox(-3.5f, -10.0f, 3.5f, 7, 8, 3);
        Hood3.setTextureSize(128, 64);
        setRotation(Hood3, -0.3490659f, 0.0f, 0.0f);
        (Hood4 = new ModelRenderer(this, 53, 15)).addBox(-3.0f, -10.7f, 3.5f, 6, 7, 3);
        Hood4.setTextureSize(128, 64);
        setRotation(Hood4, -0.5759587f, 0.0f, 0.0f);
        (Chestthing = new ModelRenderer(this, 56, 50)).addBox(-2.5f, 1.0f, -4.0f, 5, 7, 1);
        Chestthing.setTextureSize(128, 64);
        setRotation(Chestthing, 0.0f, 0.0f, 0.0f);
        (Mbelt = new ModelRenderer(this, 16, 55)).addBox(-4.0f, 7.0f, -3.0f, 8, 5, 1);
        Mbelt.setTextureSize(128, 64);
        setRotation(Mbelt, 0.0f, 0.0f, 0.0f);
        (MbeltB = new ModelRenderer(this, 16, 55)).addBox(-4.0f, 7.0f, -4.0f, 8, 5, 1);
        MbeltB.setTextureSize(128, 64);
        setRotation(MbeltB, 0.0f, 3.141593f, 0.0f);
        ClothchestL = new ModelRenderer(this, 108, 38);
        ClothchestL.mirror = true;
        ClothchestL.addBox(2.1f, 0.5f, -3.5f, 2, 8, 1);
        ClothchestL.setTextureSize(128, 64);
        setRotation(ClothchestL, 0.0f, 0.0f, 0.0f);
        (ClothchestR = new ModelRenderer(this, 108, 38)).addBox(-4.1f, 0.5f, -3.5f, 2, 8, 1);
        ClothchestR.setTextureSize(128, 64);
        setRotation(ClothchestR, 0.0f, 0.0f, 0.0f);
        (Book = new ModelRenderer(this, 81, 16)).addBox(1.0f, 0.0f, 4.0f, 5, 7, 2);
        Book.setTextureSize(128, 64);
        setRotation(Book, 0.0f, 0.0f, 0.7679449f);
        (Scroll = new ModelRenderer(this, 78, 25)).addBox(-2.0f, 9.5f, 4.0f, 8, 3, 3);
        Scroll.setTextureSize(128, 64);
        setRotation(Scroll, 0.0f, 0.0f, 0.1919862f);
        (BeltR = new ModelRenderer(this, 16, 36)).addBox(-5.0f, 4.0f, -3.0f, 1, 3, 6);
        BeltR.setTextureSize(128, 64);
        setRotation(BeltR, 0.0f, 0.0f, 0.0f);
        (Backplate = new ModelRenderer(this, 36, 45)).addBox(-4.0f, 1.0f, 1.9f, 8, 11, 2);
        Backplate.setTextureSize(128, 64);
        setRotation(Backplate, 0.0f, 0.0f, 0.0f);
        (MbeltL = new ModelRenderer(this, 16, 36)).addBox(4.0f, 8.0f, -3.0f, 1, 3, 6);
        MbeltL.setTextureSize(128, 64);
        setRotation(MbeltL, 0.0f, 0.0f, 0.0f);
        (MbeltR = new ModelRenderer(this, 16, 36)).addBox(-5.0f, 8.0f, -3.0f, 1, 3, 6);
        MbeltR.setTextureSize(128, 64);
        setRotation(MbeltR, 0.0f, 0.0f, 0.0f);
        (BeltL = new ModelRenderer(this, 16, 36)).addBox(4.0f, 4.0f, -3.0f, 1, 3, 6);
        BeltL.setTextureSize(128, 64);
        setRotation(BeltL, 0.0f, 0.0f, 0.0f);
        (Chestplate = new ModelRenderer(this, 16, 25)).addBox(-4.0f, 1.0f, -3.0f, 8, 6, 1);
        Chestplate.setTextureSize(128, 64);
        setRotation(Chestplate, 0.0f, 0.0f, 0.0f);
        (ShoulderplateR1 = new ModelRenderer(this, 56, 33)).addBox(-4.5f, -1.5f, -3.5f, 1, 4, 7);
        ShoulderplateR1.setTextureSize(128, 64);
        setRotation(ShoulderplateR1, 0.0f, 0.0f, 0.4363323f);
        (ShoulderplateR2 = new ModelRenderer(this, 40, 33)).addBox(-3.5f, 1.5f, -3.5f, 1, 3, 7);
        ShoulderplateR2.setTextureSize(128, 64);
        setRotation(ShoulderplateR2, 0.0f, 0.0f, 0.4363323f);
        (ShoulderplateR3 = new ModelRenderer(this, 40, 33)).addBox(-2.5f, 3.5f, -3.5f, 1, 3, 7);
        ShoulderplateR3.setTextureSize(128, 64);
        setRotation(ShoulderplateR3, 0.0f, 0.0f, 0.4363323f);
        (ShoulderplateTopR = new ModelRenderer(this, 56, 25)).addBox(-5.5f, -2.5f, -3.5f, 2, 1, 7);
        ShoulderplateTopR.setTextureSize(128, 64);
        setRotation(ShoulderplateTopR, 0.0f, 0.0f, 0.4363323f);
        (RArm1 = new ModelRenderer(this, 88, 39)).addBox(-3.5f, 2.5f, -2.5f, 5, 7, 5);
        RArm1.setTextureSize(128, 64);
        setRotation(RArm1, 0.0f, 0.0f, 0.0f);
        (RArm2 = new ModelRenderer(this, 76, 32)).addBox(-3.0f, 5.5f, 2.5f, 4, 4, 2);
        RArm2.setTextureSize(128, 64);
        setRotation(RArm2, 0.0f, 0.0f, 0.0f);
        (RArm3 = new ModelRenderer(this, 88, 32)).addBox(-2.5f, 3.5f, 2.5f, 3, 2, 1);
        RArm3.setTextureSize(128, 64);
        setRotation(RArm3, 0.0f, 0.0f, 0.0f);
        (ShoulderplateL1 = new ModelRenderer(this, 56, 33)).addBox(3.5f, -1.5f, -3.5f, 1, 4, 7);
        ShoulderplateL1.setTextureSize(128, 64);
        setRotation(ShoulderplateL1, 0.0f, 0.0f, -0.4363323f);
        (ShoulderplateL2 = new ModelRenderer(this, 40, 33)).addBox(2.5f, 1.5f, -3.5f, 1, 3, 7);
        ShoulderplateL2.setTextureSize(128, 64);
        setRotation(ShoulderplateL2, 0.0f, 0.0f, -0.4363323f);
        (ShoulderplateL3 = new ModelRenderer(this, 40, 33)).addBox(1.5f, 3.5f, -3.5f, 1, 3, 7);
        ShoulderplateL3.setTextureSize(128, 64);
        setRotation(ShoulderplateL3, 0.0f, 0.0f, -0.4363323f);
        (ShoulderplateTopL = new ModelRenderer(this, 56, 25)).addBox(3.5f, -2.5f, -3.5f, 2, 1, 7);
        ShoulderplateTopL.setTextureSize(128, 64);
        setRotation(ShoulderplateTopL, 0.0f, 0.0f, -0.4363323f);
        ShoulderR = new ModelRenderer(this, 16, 45);
        ShoulderR.mirror = true;
        ShoulderR.addBox(-3.5f, -2.5f, -2.5f, 5, 5, 5);
        ShoulderR.setTextureSize(128, 64);
        setRotation(ShoulderR, 0.0f, 0.0f, 0.0f);
        LArm1 = new ModelRenderer(this, 88, 39);
        LArm1.mirror = true;
        LArm1.addBox(-1.5f, 2.5f, -2.5f, 5, 7, 5);
        LArm1.setTextureSize(128, 64);
        setRotation(LArm1, 0.0f, 0.0f, 0.0f);
        (LArm2 = new ModelRenderer(this, 76, 32)).addBox(-1.0f, 5.5f, 2.5f, 4, 4, 2);
        LArm2.setTextureSize(128, 64);
        setRotation(LArm2, 0.0f, 0.0f, 0.0f);
        (LArm3 = new ModelRenderer(this, 88, 32)).addBox(-0.5f, 3.5f, 2.5f, 3, 2, 1);
        LArm3.setTextureSize(128, 64);
        setRotation(LArm3, 0.0f, 0.0f, 0.0f);
        (ShoulderL = new ModelRenderer(this, 16, 45)).addBox(-1.5f, -2.5f, -2.5f, 5, 5, 5);
        ShoulderL.setTextureSize(128, 64);
        ShoulderL.mirror = true;
        setRotation(ShoulderL, 0.0f, 0.0f, 0.0f);
        (FrontclothR1 = new ModelRenderer(this, 108, 38)).addBox(0.0f, 0.0f, 0.0f, 3, 8, 1);
        FrontclothR1.setRotationPoint(-3.0f, 11.0f, -2.9f);
        FrontclothR1.setTextureSize(128, 64);
        setRotation(FrontclothR1, -0.1047198f, 0.0f, 0.0f);
        (FrontclothR2 = new ModelRenderer(this, 108, 47)).addBox(0.0f, 7.5f, 1.7f, 3, 3, 1);
        FrontclothR2.setRotationPoint(-3.0f, 11.0f, -2.9f);
        FrontclothR2.setTextureSize(128, 64);
        setRotation(FrontclothR2, -0.3316126f, 0.0f, 0.0f);
        FrontclothL1 = new ModelRenderer(this, 108, 38);
        FrontclothL1.mirror = true;
        FrontclothL1.addBox(0.0f, 0.0f, 0.0f, 3, 8, 1);
        FrontclothL1.setRotationPoint(0.0f, 11.0f, -2.9f);
        FrontclothL1.setTextureSize(128, 64);
        setRotation(FrontclothL1, -0.1047198f, 0.0f, 0.0f);
        FrontclothL2 = new ModelRenderer(this, 108, 47);
        FrontclothL2.mirror = true;
        FrontclothL2.addBox(0.0f, 7.5f, 1.7f, 3, 3, 1);
        FrontclothL2.setRotationPoint(0.0f, 11.0f, -2.9f);
        FrontclothL2.setTextureSize(128, 64);
        setRotation(FrontclothL2, -0.3316126f, 0.0f, 0.0f);
        ClothBackR1 = new ModelRenderer(this, 118, 16);
        ClothBackR1.mirror = true;
        ClothBackR1.addBox(0.0f, 0.0f, 0.0f, 4, 8, 1);
        ClothBackR1.setRotationPoint(-4.0f, 11.5f, 2.9f);
        ClothBackR1.setTextureSize(128, 64);
        setRotation(ClothBackR1, 0.1047198f, 0.0f, 0.0f);
        (ClothBackR2 = new ModelRenderer(this, 123, 9)).addBox(0.0f, 7.8f, -0.9f, 1, 2, 1);
        ClothBackR2.setRotationPoint(-4.0f, 11.5f, 2.9f);
        ClothBackR2.setTextureSize(128, 64);
        setRotation(ClothBackR2, 0.2268928f, 0.0f, 0.0f);
        ClothBackR3 = new ModelRenderer(this, 120, 12);
        ClothBackR3.mirror = true;
        ClothBackR3.addBox(1.0f, 7.8f, -0.9f, 3, 3, 1);
        ClothBackR3.setRotationPoint(-4.0f, 11.5f, 2.9f);
        ClothBackR3.setTextureSize(128, 64);
        setRotation(ClothBackR3, 0.2268928f, 0.0f, 0.0f);
        (ClothBackL1 = new ModelRenderer(this, 118, 16)).addBox(0.0f, 0.0f, 0.0f, 4, 8, 1);
        ClothBackL1.setRotationPoint(0.0f, 11.5f, 2.9f);
        ClothBackL1.setTextureSize(128, 64);
        setRotation(ClothBackL1, 0.1047198f, 0.0f, 0.0f);
        ClothBackL2 = new ModelRenderer(this, 123, 9);
        ClothBackL2.mirror = true;
        ClothBackL2.addBox(3.0f, 7.8f, -0.9f, 1, 2, 1);
        ClothBackL2.setRotationPoint(0.0f, 11.5f, 2.9f);
        ClothBackL2.setTextureSize(128, 64);
        setRotation(ClothBackL2, 0.2268928f, 0.0f, 0.0f);
        (ClothBackL3 = new ModelRenderer(this, 120, 12)).addBox(0.0f, 7.8f, -0.9f, 3, 3, 1);
        ClothBackL3.setRotationPoint(0.0f, 11.5f, 2.9f);
        ClothBackL3.setTextureSize(128, 64);
        setRotation(ClothBackL3, 0.2268928f, 0.0f, 0.0f);
        (SideclothL2 = new ModelRenderer(this, 116, 34)).addBox(0.5f, 5.5f, -2.5f, 1, 3, 5);
        SideclothL2.setTextureSize(128, 64);
        setRotation(SideclothL2, 0.0f, 0.0f, -0.296706f);
        (SideclothR1 = new ModelRenderer(this, 116, 42)).addBox(-2.5f, 0.5f, -2.5f, 1, 5, 5);
        SideclothR1.setTextureSize(128, 64);
        setRotation(SideclothR1, 0.0f, 0.0f, 0.122173f);
        (SideclothR2 = new ModelRenderer(this, 116, 34)).addBox(-1.5f, 5.5f, -2.5f, 1, 3, 5);
        SideclothR2.setTextureSize(128, 64);
        setRotation(SideclothR2, 0.0f, 0.0f, 0.296706f);
        (SideclothR3 = new ModelRenderer(this, 116, 1)).addBox(0.4f, 8.4f, -2.5f, 1, 3, 5);
        SideclothR3.setTextureSize(128, 64);
        setRotation(SideclothR3, 0.0f, 0.0f, 0.5235988f);
        (SidepanelR1 = new ModelRenderer(this, 116, 25)).addBox(-2.5f, 0.5f, -2.5f, 1, 4, 5);
        SidepanelR1.setTextureSize(128, 64);
        SidepanelR1.mirror = true;
        setRotation(SidepanelR1, 0.0f, 0.0f, 0.4363323f);
        (LegpanelR6 = new ModelRenderer(this, 82, 38)).addBox(-3.0f, 4.5f, -1.5f, 2, 3, 1);
        LegpanelR6.setTextureSize(128, 64);
        setRotation(LegpanelR6, -0.4363323f, 0.0f, 0.0f);
        (LegpanelR5 = new ModelRenderer(this, 76, 42)).addBox(-3.0f, 2.5f, -2.5f, 2, 3, 1);
        LegpanelR5.setTextureSize(128, 64);
        setRotation(LegpanelR5, -0.4363323f, 0.0f, 0.0f);
        (LegpanelR4 = new ModelRenderer(this, 76, 38)).addBox(-3.0f, 0.5f, -3.5f, 2, 3, 1);
        LegpanelR4.setTextureSize(128, 64);
        setRotation(LegpanelR4, -0.4363323f, 0.0f, 0.0f);
        (SideclothL3 = new ModelRenderer(this, 116, 1)).addBox(-1.4f, 8.4f, -2.5f, 1, 3, 5);
        SideclothL3.setTextureSize(128, 64);
        setRotation(SideclothL3, 0.0f, 0.0f, -0.5235988f);
        (Focipouch = new ModelRenderer(this, 100, 20)).addBox(3.5f, 0.5f, -2.5f, 3, 6, 5);
        Focipouch.setTextureSize(128, 64);
        setRotation(Focipouch, 0.0f, 0.0f, -0.122173f);
        (SideclothL1 = new ModelRenderer(this, 116, 42)).addBox(1.5f, 0.5f, -2.5f, 1, 5, 5);
        SideclothL1.setTextureSize(128, 64);
        setRotation(SideclothL1, 0.0f, 0.0f, -0.122173f);
        LegpanelL4 = new ModelRenderer(this, 76, 38);
        LegpanelL4.mirror = true;
        LegpanelL4.addBox(1.0f, 0.5f, -3.5f, 2, 3, 1);
        LegpanelL4.setTextureSize(128, 64);
        setRotation(LegpanelL4, -0.4363323f, 0.0f, 0.0f);
        LegpanelL5 = new ModelRenderer(this, 76, 42);
        LegpanelL5.mirror = true;
        LegpanelL5.addBox(1.0f, 2.5f, -2.5f, 2, 3, 1);
        LegpanelL5.setTextureSize(128, 64);
        setRotation(LegpanelL5, -0.4363323f, 0.0f, 0.0f);
        LegpanelL6 = new ModelRenderer(this, 82, 38);
        LegpanelL6.mirror = true;
        LegpanelL6.addBox(1.0f, 4.5f, -1.5f, 2, 3, 1);
        LegpanelL6.setTextureSize(128, 64);
        setRotation(LegpanelL6, -0.4363323f, 0.0f, 0.0f);
        (SidepanelL1 = new ModelRenderer(this, 116, 25)).addBox(1.5f, 0.5f, -2.5f, 1, 4, 5);
        SidepanelL1.setTextureSize(128, 64);
        setRotation(SidepanelL1, 0.0f, 0.0f, -0.4363323f);
        bipedHeadwear.cubeList.clear();
        bipedHead.cubeList.clear();
        bipedHead.addChild(Hood1);
        bipedHead.addChild(Hood2);
        bipedHead.addChild(Hood3);
        bipedHead.addChild(Hood4);
        bipedBody.cubeList.clear();
        bipedRightLeg.cubeList.clear();
        bipedLeftLeg.cubeList.clear();
        bipedBody.addChild(Mbelt);
        bipedBody.addChild(MbeltB);
        bipedBody.addChild(MbeltL);
        bipedBody.addChild(MbeltR);
        if (f < 1.0f) {
            bipedLeftLeg.addChild(Focipouch);
            bipedBody.addChild(FrontclothR1);
            bipedBody.addChild(FrontclothR2);
            bipedBody.addChild(FrontclothL1);
            bipedBody.addChild(FrontclothL2);
            bipedBody.addChild(ClothBackR1);
            bipedBody.addChild(ClothBackR2);
            bipedBody.addChild(ClothBackR3);
            bipedBody.addChild(ClothBackL1);
            bipedBody.addChild(ClothBackL2);
            bipedBody.addChild(ClothBackL3);
        }
        else {
            bipedBody.addChild(Chestplate);
            bipedBody.addChild(Chestthing);
            bipedBody.addChild(Scroll);
            bipedBody.addChild(Backplate);
            bipedBody.addChild(Book);
            bipedBody.addChild(ClothchestL);
            bipedBody.addChild(ClothchestR);
        }
        bipedRightArm.cubeList.clear();
        bipedRightArm.addChild(ShoulderR);
        bipedRightArm.addChild(RArm1);
        bipedRightArm.addChild(RArm2);
        bipedRightArm.addChild(RArm3);
        bipedRightArm.addChild(ShoulderplateTopR);
        bipedRightArm.addChild(ShoulderplateR1);
        bipedRightArm.addChild(ShoulderplateR2);
        bipedRightArm.addChild(ShoulderplateR3);
        bipedLeftArm.cubeList.clear();
        bipedLeftArm.addChild(ShoulderL);
        bipedLeftArm.addChild(LArm1);
        bipedLeftArm.addChild(LArm2);
        bipedLeftArm.addChild(LArm3);
        bipedLeftArm.addChild(ShoulderplateTopL);
        bipedLeftArm.addChild(ShoulderplateL1);
        bipedLeftArm.addChild(ShoulderplateL2);
        bipedLeftArm.addChild(ShoulderplateL3);
        bipedRightLeg.addChild(LegpanelR4);
        bipedRightLeg.addChild(LegpanelR5);
        bipedRightLeg.addChild(LegpanelR6);
        bipedRightLeg.addChild(SidepanelR1);
        bipedRightLeg.addChild(SideclothR1);
        bipedRightLeg.addChild(SideclothR2);
        bipedRightLeg.addChild(SideclothR3);
        bipedLeftLeg.addChild(LegpanelL4);
        bipedLeftLeg.addChild(LegpanelL5);
        bipedLeftLeg.addChild(LegpanelL6);
        bipedLeftLeg.addChild(SidepanelL1);
        bipedLeftLeg.addChild(SideclothL1);
        bipedLeftLeg.addChild(SideclothL2);
        bipedLeftLeg.addChild(SideclothL3);
    }
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float a = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        float b = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        float c = Math.min(a, b);
        ModelRenderer frontclothR1 = FrontclothR1;
        ModelRenderer frontclothL1 = FrontclothL1;
        float n = c - 0.1047198f;
        frontclothL1.rotateAngleX = n;
        frontclothR1.rotateAngleX = n;
        ModelRenderer frontclothR2 = FrontclothR2;
        ModelRenderer frontclothL2 = FrontclothL2;
        float n2 = c - 0.3316126f;
        frontclothL2.rotateAngleX = n2;
        frontclothR2.rotateAngleX = n2;
        ModelRenderer clothBackR1 = ClothBackR1;
        ModelRenderer clothBackL1 = ClothBackL1;
        float n3 = -c + 0.1047198f;
        clothBackL1.rotateAngleX = n3;
        clothBackR1.rotateAngleX = n3;
        ModelRenderer clothBackR2 = ClothBackR2;
        ModelRenderer clothBackL2 = ClothBackL2;
        ModelRenderer clothBackR3 = ClothBackR3;
        ModelRenderer clothBackL3 = ClothBackL3;
        float n4 = -c + 0.2268928f;
        clothBackL3.rotateAngleX = n4;
        clothBackR3.rotateAngleX = n4;
        clothBackL2.rotateAngleX = n4;
        clothBackR2.rotateAngleX = n4;
        if (isChild) {
            float f6 = 2.0f;
            GL11.glPushMatrix();
            GL11.glScalef(1.5f / f6, 1.5f / f6, 1.5f / f6);
            GL11.glTranslatef(0.0f, 16.0f * f5, 0.0f);
            bipedHead.render(f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0f / f6, 1.0f / f6, 1.0f / f6);
            GL11.glTranslatef(0.0f, 24.0f * f5, 0.0f);
            bipedBody.render(f5);
            bipedRightArm.render(f5);
            bipedLeftArm.render(f5);
            bipedRightLeg.render(f5);
            bipedLeftLeg.render(f5);
            bipedHeadwear.render(f5);
            GL11.glPopMatrix();
        }
        else {
            GL11.glPushMatrix();
            GL11.glScalef(1.01f, 1.01f, 1.01f);
            bipedHead.render(f5);
            GL11.glPopMatrix();
            bipedBody.render(f5);
            bipedRightArm.render(f5);
            bipedLeftArm.render(f5);
            bipedRightLeg.render(f5);
            bipedLeftLeg.render(f5);
            bipedHeadwear.render(f5);
        }
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
