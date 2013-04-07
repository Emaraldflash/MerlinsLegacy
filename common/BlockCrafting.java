package mods.MerlinsLegacy.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCrafting extends BlockWorkbench
{
	@SideOnly(Side.CLIENT)
	private Icon field_94385_a;
	@SideOnly(Side.CLIENT)
	private Icon field_94384_b;

	protected BlockCrafting(int par1)
	{
		super(par1);
		this.setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);
	}

	@SideOnly(Side.CLIENT)

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		return par1 == 1 ? this.field_94385_a : (par1 == 0 ? MerlinsLegacy.ConstructorG.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.field_94384_b));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
		this.blockIcon = par1IconRegister.registerIcon("MerlinsLegacy:CraftSide");
		this.field_94385_a = par1IconRegister.registerIcon("MerlinsLegacy:CraftTop");
		this.field_94384_b = par1IconRegister.registerIcon("MerlinsLegacy:CraftFront");
	}


	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if (par1World.isRemote)
		{
			return true;
		}
		else
		{
			par5EntityPlayer.openGui(MerlinsLegacy.instance, par6, par1World, par6, par6, par6);
			return true;
		}
	}

}

