package mods.MerlinsLegacy.client;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import mods.MerlinsLegacy.common.EntitySpriteR;
import mods.MerlinsLegacy.common.ModelSprite;
import mods.MerlinsLegacy.common.RenderSpriteR;
import mods.MerlinsLegacy.common.ServerProxy;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderers() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySpriteR.class, new RenderSpriteR(new ModelSprite(), 0.1f));
		
	}
	
	@Override
	public int addArmor(String armor) {
		
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
