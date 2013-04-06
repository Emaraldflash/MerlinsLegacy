package mods.MerlinsLegacy.common.Armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.MerlinsLegacy.common.MerlinsLegacy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemLegsYellow extends ItemArmor implements IArmorTextureProvider {

	public ItemLegsYellow(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);
		
	}

	@Override
	public String getArmorTextureFile(ItemStack stack) {
		if (stack.itemID == MerlinsLegacy.HelmetYellow.itemID
				|| stack.itemID == MerlinsLegacy.PlateYellow.itemID
				|| stack.itemID == MerlinsLegacy.BootsYellow.itemID) {
			return "/mods/MerlinsLegacy/textures/Armour/Yellow_1.png";
		} else if (stack.itemID == MerlinsLegacy.LegsYellow.itemID) {
			return "/mods/MerlinsLegacy/textures/Armour/Yellow_2.png";
		}
		return "/mods/MerlinsLegacy/textures/Armour/Yellow_2.png";
	}

	@Override
	@SideOnly(Side.CLIENT)
	 public void updateIcons(IconRegister par1IconRegister)
	 {
	   this.iconIndex = par1IconRegister.registerIcon("MerlinsLegacy:LegsY");
     }

}
