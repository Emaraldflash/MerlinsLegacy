package mods.MerlinsLegacy.common;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemElementiumYellow extends Item {

	public ItemElementiumYellow(int par1) {
		super(par1);
		setMaxStackSize(64);
		this.setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);
	}

	public void updateIcons(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.registerIcon("MerlinsLegacy:Yellowcrystal");
	}
		
}
