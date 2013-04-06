package mods.MerlinsLegacy.common.Armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.MerlinsLegacy.common.MerlinsLegacy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemLegsRed extends ItemArmor implements IArmorTextureProvider {

	public ItemLegsRed(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);
	}

	@Override
	public String getArmorTextureFile(ItemStack stack) {
		if (stack.itemID == MerlinsLegacy.HelmetRed.itemID
				|| stack.itemID == MerlinsLegacy.PlateRed.itemID
				|| stack.itemID == MerlinsLegacy.BootsRed.itemID) {
			return "/mods/MerlinsLegacy/textures/Armour/Red_1.png";
		} else if (stack.itemID == MerlinsLegacy.LegsRed.itemID) {
			return "/mods/MerlinsLegacy/textures/Armour/Red_2.png";
		}
		return "/mods/MerlinsLegacy/textures/Armour/Red_2.png";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister) {
		this.iconIndex = par1IconRegister.registerIcon("MerlinsLegacy:LegsR");
	}
}
