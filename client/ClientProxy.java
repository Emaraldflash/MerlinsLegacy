package mods.MerlinsLegacy.client;

import net.minecraftforge.client.MinecraftForgeClient;
import mods.MerlinsLegacy.common.EntitySpriteB;
import mods.MerlinsLegacy.common.EntitySpriteG;
import mods.MerlinsLegacy.common.EntitySpriteR;
import mods.MerlinsLegacy.common.EntitySpriteY;
import mods.MerlinsLegacy.common.ModelSprite;
import mods.MerlinsLegacy.common.RenderSpriteB;
import mods.MerlinsLegacy.common.RenderSpriteG;
import mods.MerlinsLegacy.common.RenderSpriteR;
import mods.MerlinsLegacy.common.RenderSpriteY;
import mods.MerlinsLegacy.common.ServerProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderers() {
		MinecraftForgeClient.preloadTexture(HelmetRPNG);
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
