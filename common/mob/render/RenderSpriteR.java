package mods.MerlinsLegacy.common.mob.render;

import mods.MerlinsLegacy.common.mob.entity.EntitySpriteR;
import mods.MerlinsLegacy.common.mob.model.ModelSprite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderSpriteR extends RenderLiving {

	protected ModelSprite model;

	public RenderSpriteR(ModelSprite par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((ModelSprite)mainModel);

	}

	public void renderSpriteR(EntitySpriteR par1EntitySpriteR, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRenderLiving(par1EntitySpriteR, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderSpriteR((EntitySpriteR)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderSpriteR((EntitySpriteR)par1Entity, par2, par4, par6, par8, par9);
	}

}
