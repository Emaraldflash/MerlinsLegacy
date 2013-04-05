package mods.MerlinsLegacy.common;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockMInfuse extends Block{

	@SideOnly(Side.CLIENT)
	private Icon field_94385_a;
	private Icon field_94384_b;

	public BlockMInfuse(int id, Material mat){ 
		super(id, mat);
		this.setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);

	}

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		return par1 == 1 ? this.field_94385_a : (par1 == 0 ? MerlinsLegacy.Constructor.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.field_94384_b));
	}
	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return this.getBlockTextureFromSide(par5);
	}



	@SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("MerlinsLegacy:MinfSide");
		this.field_94385_a = par1IconRegister.registerIcon("MerlinsLegacy:MInfTop");
		this.field_94384_b = par1IconRegister.registerIcon("MerlinsLegacy:MinfSide");

	}

	public int idDropped(int par1, Random rand, int par2){
		return this.blockID;


	}

	public int quantityDropped(Random rand){
		return 1;

	}
}
