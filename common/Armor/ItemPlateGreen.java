package mods.MerlinsLegacy.common.Armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.MerlinsLegacy.common.MerlinsLegacy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemPlateGreen extends ItemArmor implements IArmorTextureProvider {

	public ItemPlateGreen(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);
		
	}

	@Override
	public String getArmorTextureFile(ItemStack stack) {
		if (stack.itemID == MerlinsLegacy.HelmetGreen.itemID
				|| stack.itemID == MerlinsLegacy.PlateGreen.itemID
				|| stack.itemID == MerlinsLegacy.BootsGreen.itemID) {
			return "/mods/MerlinsLegacy/textures/Armour/Green_1.png";
		} else if (stack.itemID == MerlinsLegacy.LegsGreen.itemID) {
			return "/mods/MerlinsLegacy/textures/Armour/Green_2.png";
		}
		return "/mods/MerlinsLegacy/textures/Armour/Green_2.png";
	}

	@Override
	@SideOnly(Side.CLIENT)
	 public void updateIcons(IconRegister par1IconRegister)
	 {
	   this.iconIndex = par1IconRegister.registerIcon("MerlinsLegacy:PlateG");
     }

}
