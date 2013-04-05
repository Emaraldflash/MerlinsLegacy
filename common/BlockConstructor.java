package mods.MerlinsLegacy.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockConstructor extends Block{

	public BlockConstructor(int id, Material mat){ 
		super(id, mat);
		this.setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);

	}

	@Override
	public void registerIcons(IconRegister par1IconRegister){
		this.blockIcon = par1IconRegister.registerIcon("MerlinsLegacy:MinfSide");
	}

	public int idDropped(int par1, Random rand, int par2){
		return this.blockID;


	}

	public int quantityDropped(Random rand){
		return 1;


	}

}





