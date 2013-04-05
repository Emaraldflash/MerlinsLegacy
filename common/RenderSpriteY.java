package mods.MerlinsLegacy.common;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderSpriteY extends RenderLiving {

	protected ModelSprite model;

	public RenderSpriteY(ModelSprite par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((ModelSprite)mainModel);

	}

	public void renderSpriteY(EntitySpriteY par1EntitySpriteY, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRenderLiving(par1EntitySpriteY, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderSpriteY((EntitySpriteY)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderSpriteY((EntitySpriteY)par1Entity, par2, par4, par6, par8, par9);
	}

}
