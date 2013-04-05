package mods.MerlinsLegacy.common;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemElementiumRed extends Item {

	public ItemElementiumRed(int par1) {
		super(par1);
		setMaxStackSize(64);
		this.setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);
	}

	public void updateIcons(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.registerIcon("MerlinsLegacy:redcrystal");
	}
		
}
