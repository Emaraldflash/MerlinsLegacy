package mods.MerlinsLegacy.common;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderSpriteG extends RenderLiving {

	protected ModelSprite model;

	public RenderSpriteG(ModelSprite par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((ModelSprite)mainModel);

	}

	public void renderSpriteG(EntitySpriteG par1EntitySpriteG, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRenderLiving(par1EntitySpriteG, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderSpriteG((EntitySpriteG)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderSpriteG((EntitySpriteG)par1Entity, par2, par4, par6, par8, par9);
	}

}
