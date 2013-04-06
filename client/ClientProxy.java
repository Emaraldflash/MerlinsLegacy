package mods.MerlinsLegacy.client;

import net.minecraftforge.client.MinecraftForgeClient;
import mods.MerlinsLegacy.common.ServerProxy;
import mods.MerlinsLegacy.common.mob.entity.EntitySpriteB;
import mods.MerlinsLegacy.common.mob.entity.EntitySpriteG;
import mods.MerlinsLegacy.common.mob.entity.EntitySpriteR;
import mods.MerlinsLegacy.common.mob.entity.EntitySpriteY;
import mods.MerlinsLegacy.common.mob.model.ModelSprite;
import mods.MerlinsLegacy.common.mob.render.RenderSpriteB;
import mods.MerlinsLegacy.common.mob.render.RenderSpriteG;
import mods.MerlinsLegacy.common.mob.render.RenderSpriteR;
import mods.MerlinsLegacy.common.mob.render.RenderSpriteY;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySpriteR.class, new RenderSpriteR(new ModelSprite(), 0.1f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpriteB.class, new RenderSpriteB(new ModelSprite(), 0.1f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpriteG.class, new RenderSpriteG(new ModelSprite(), 0.1f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpriteY.class, new RenderSpriteY(new ModelSprite(), 0.1f));
	}
	
	@Override
	public int addArmor(String armor) {
		
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
