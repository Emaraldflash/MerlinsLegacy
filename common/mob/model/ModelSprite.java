package mods.MerlinsLegacy.common.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSprite extends ModelBase

{
	// fields
	ModelRenderer Body;
	ModelRenderer LeftLeg;
	ModelRenderer RightLeg;
	ModelRenderer LeftArm;
	ModelRenderer RightArm;
	ModelRenderer Head;
	ModelRenderer LeftWing;
	ModelRenderer RightWing;

	public ModelSprite() {
		textureWidth = 32;
		textureHeight = 32;

		Body = new ModelRenderer(this, 10, 10);
		Body.addBox(0F, 0F, 0F, 3, 5, 2);
		Body.setRotationPoint(0F, 0F, 0F);
		Body.setTextureSize(32, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		LeftLeg = new ModelRenderer(this, 17, 19);
		LeftLeg.addBox(0F, 0F, -0.5F, 1, 4, 1);
		LeftLeg.setRotationPoint(2F, 5F, 1F);
		LeftLeg.setTextureSize(32, 32);
		LeftLeg.mirror = true;
		setRotation(LeftLeg, 0F, 0F, 0F);
		RightLeg = new ModelRenderer(this, 10, 19);
		RightLeg.addBox(-1F, 0F, -0.5F, 1, 4, 1);
		RightLeg.setRotationPoint(0.9666666F, 5F, 1F);
		RightLeg.setTextureSize(32, 32);
		RightLeg.mirror = true;
		setRotation(RightLeg, 0F, 0F, 0F);
		LeftArm = new ModelRenderer(this, 21, 10);
		LeftArm.addBox(0F, 0F, 0F, 1, 4, 1);
		LeftArm.setRotationPoint(3F, 0F, 0F);
		LeftArm.setTextureSize(32, 32);
		LeftArm.mirror = true;
		setRotation(LeftArm, -0.6108652F, 0F, 0F);
		RightArm = new ModelRenderer(this, 5, 10);
		RightArm.addBox(-1F, 0F, 0F, 1, 4, 1);
		RightArm.setRotationPoint(0F, 0F, 0F);
		RightArm.setTextureSize(32, 32);
		RightArm.mirror = true;
		setRotation(RightArm, -0.6108652F, 0F, 0F);
		Head = new ModelRenderer(this, 11, 4);
		Head.addBox(-1F, -2F, -1F, 2, 2, 2);
		Head.setRotationPoint(1.5F, 0F, 1F);
		Head.setTextureSize(32, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		LeftWing = new ModelRenderer(this, 23, 0);
		LeftWing.addBox(0F, 0F, 0F, 0, 3, 4);
		LeftWing.setRotationPoint(2F, 1F, 1.5F);
		LeftWing.setTextureSize(32, 32);
		LeftWing.mirror = true;
		setRotation(LeftWing, 0.9424778F, 0.715585F, 0F);
		RightWing = new ModelRenderer(this, 1, 0);
		RightWing.addBox(0F, 0F, 0F, 0, 3, 4);
		RightWing.setRotationPoint(1F, 1F, 1.5F);
		RightWing.setTextureSize(32, 32);
		RightWing.mirror = true;
		setRotation(RightWing, 0.9424778F, -0.715585F, 0F);
	}

	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		Body.render(par7);
		Body.render(par7);
		LeftLeg.render(par7);
		RightLeg.render(par7);
		LeftArm.render(par7);
		RightArm.render(par7);
		Head.render(par7);
		LeftWing.render(par7);
		RightWing.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, Entity par7Entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
		float f7 = MathHelper.sin((1.0F - (1.0F - this.onGround) * (1.0F - this.onGround)) * (float)Math.PI);
		this.Head.rotateAngleX = par6 / (180F / (float)Math.PI);
        this.Head.rotateAngleY = par5 / (180F / (float)Math.PI);
        this.Head.rotateAngleZ = 0.0F;
        this.Head.setRotationPoint(1.5F, 0F, 1F);
        this.RightWing.setRotationPoint(1F, 1F, 1.5F);
        this.LeftWing.setRotationPoint(2F, 1F, 1.5F);
        this.RightWing.rotateAngleY = MathHelper.cos(par4 * 1.3F) * (float)Math.PI * 0.25F;
        this.LeftWing.rotateAngleY = -this.RightWing.rotateAngleY;
        this.RightWing.rotateAngleY = this.RightWing.rotateAngleY * 1F;
        this.LeftWing.rotateAngleY = -this.RightWing.rotateAngleY * 0.7F;
        this.RightArm.rotateAngleZ = 0.0F;
        this.LeftArm.rotateAngleZ = 0.0F;
        this.RightArm.rotateAngleY = -(0.1F - par6 * 0.6F);
        this.LeftArm.rotateAngleY = 0.1F - par6 * 0.6F;
        this.RightArm.rotateAngleX = -((float)Math.PI / 2F);
        this.LeftArm.rotateAngleX = -((float)Math.PI / 2F);
        this.RightArm.rotateAngleX -= par6 * 90.2F - f7 * 0.4F;
        this.LeftArm.rotateAngleX -= par6 * 90.2F - f7 * 0.4F;
        this.RightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        this.LeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        this.RightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
        this.LeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
        this.RightLeg.rotateAngleZ = 0.0F;
        this.LeftLeg.rotateAngleZ = 0.0F;
        this.RightLeg.rotateAngleY = -(0.1F - par6 * 0.6F);
        this.LeftLeg.rotateAngleY = 0.1F - par6 * 0.6F;
        this.RightLeg.rotateAngleX = -((float)Math.PI / 2F);
        this.LeftLeg.rotateAngleX = -((float)Math.PI / 2F);
        this.RightLeg.rotateAngleX -= par6 * 270.2F - f7 * 0.4F;
        this.LeftLeg.rotateAngleX -= par6 * 270.2F - f7 * 0.4F;
        this.RightLeg.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        this.LeftLeg.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        this.RightLeg.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
        this.LeftLeg.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
        
    }
        
    }



