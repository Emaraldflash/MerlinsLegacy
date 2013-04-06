package mods.MerlinsLegacy.common.Armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.MerlinsLegacy.common.MerlinsLegacy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemLegsPurple extends ItemArmor implements IArmorTextureProvider {

	public ItemLegsPurple(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);
		
	}

	@Override
	public String getArmorTextureFile(ItemStack stack) {
		if (stack.itemID == MerlinsLegacy.HelmetPurple.itemID
				|| stack.itemID == MerlinsLegacy.PlatePurple.itemID
				|| stack.itemID == MerlinsLegacy.BootsPurple.itemID) {
			return "/mods/MerlinsLegacy/textures/Armour/Purple_1.png";
		} else if (stack.itemID == MerlinsLegacy.LegsPurple.itemID) {
			return "/mods/MerlinsLegacy/textures/Armour/Purple_2.png";
		}
		return "/mods/MerlinsLegacy/textures/Armour/Purple_2.png";
	}

	@Override
	@SideOnly(Side.CLIENT)
	 public void updateIcons(IconRegister par1IconRegister)
	 {
	   this.iconIndex = par1IconRegister.registerIcon("MerlinsLegacy:LegsP");
     }

}
