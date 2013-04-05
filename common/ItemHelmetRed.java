package mods.MerlinsLegacy.common;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemHelmetRed extends ItemArmor implements IArmorTextureProvider{

	public ItemHelmetRed(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);
	}

	
	 public String getTextureFile(){
         return"/mods/MerlinsLegacy/textures/Items/HelmetR.png";
	  }

	@Override
	public String getArmorTextureFile(ItemStack stack)
	{
		if(stack.itemID == MerlinsLegacy.HelmetRed.itemID || stack.itemID == MerlinsLegacy.PlateRed.itemID ||
				stack.itemID == MerlinsLegacy.BootsRed.itemID)
		{
			return "/mods/MerlinsLegacy/textures/Armour/Red_1.png";
		}
		else if(stack.itemID == MerlinsLegacy.LegsRed.itemID)
		{
			return "/mods/MerlinsLegacy/textures/Armour/Red_2.png";
		}
		return "/mods/MerlinsLegacy/textures/Armour/Red_2.png";
	}
}


