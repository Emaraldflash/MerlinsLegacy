package mods.MerlinsLegacy.common.Items;

import mods.MerlinsLegacy.common.MerlinsLegacy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBsoul extends Item {

	public ItemBsoul(int par1) {
		super(par1);
		setMaxStackSize(64);
		this.setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);
	}

	public void updateIcons(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.registerIcon("MerlinsLegacy:BSoul");
	}
		
		}
