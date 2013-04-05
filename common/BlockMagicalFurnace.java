package mods.MerlinsLegacy.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMagicalFurnace extends BlockContainer
{
	
		private final Random furnaceRand = new Random();


	private final boolean isActive;


	private static boolean keepFurnaceInventory = false;
	@SideOnly(Side.CLIENT)
	private Icon field_94458_cO;
	@SideOnly(Side.CLIENT)
	private Icon field_94459_cP;

	protected BlockMagicalFurnace(int par1, boolean par2)
	{
		super(par1, Material.rock);
		this.isActive = par2;
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return MerlinsLegacy.MagicalFurnace.blockID;
	}


	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}


	private void setDefaultDirection(World par1World, int par2, int par3, int par4)
	{
		if (!par1World.isRemote)
		{
			int l = par1World.getBlockId(par2, par3, par4 - 1);
			int i1 = par1World.getBlockId(par2, par3, par4 + 1);
			int j1 = par1World.getBlockId(par2 - 1, par3, par4);
			int k1 = par1World.getBlockId(par2 + 1, par3, par4);
			byte b0 = 3;

			if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
			{
				b0 = 3;
			}

			if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
			{
				b0 = 2;
			}

			if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
			{
				b0 = 5;
			}

			if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
			{
				b0 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		}
	}

	@SideOnly(Side.CLIENT)


	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		return par1 == 1 ? this.field_94458_cO : (par1 == 0 ? this.field_94458_cO : (par1 != par2 ? this.blockIcon : this.field_94459_cP));
	}

	@SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("MerlinsLegacy:FurnaceSide");
        this.field_94459_cP = par1IconRegister.registerIcon(this.isActive ? "MerlinsLegacy:FurnaceFrontOn" : "MerlinsLegacy:FurnaceFront");
        this.field_94458_cO = par1IconRegister.registerIcon("MerlinsLegacy:FurnaceSide");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int idk, float what, float these, float are) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking()) {
			return false;
		}

		player.openGui(MerlinsLegacy.instance, 0, world, x, y, z);
		return true;
	}



	public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
		keepFurnaceInventory = true;

		if (par0)
		{
			par1World.setBlock(par2, par3, par4, MerlinsLegacy.MagicalFurnaceOn.blockID);
		}
		else
		{
			par1World.setBlock(par2, par3, par4, MerlinsLegacy.MagicalFurnace.blockID);
		}

		keepFurnaceInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

		if (tileentity != null)
		{
			tileentity.validate();
			par1World.setBlockTileEntity(par2, par3, par4, tileentity);
		}
	}

	@SideOnly(Side.CLIENT)


	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (this.isActive)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			float f = (float)par2 + 0.5F;
			float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
			float f2 = (float)par4 + 0.5F;
			float f3 = 0.52F;
			float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

			if (l == 4)
			{
				par1World.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
			}
			else if (l == 5)
			{
				par1World.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
			}
			else if (l == 2)
			{
				par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
			}
			else if (l == 3)
			{
				par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
			}
		}
	}


	public TileEntity createNewTileEntity(World par1World)
	{
		return new TileEntityMFurnace();
	}


	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
	{
		int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}

		if (l == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
		}

		if (l == 2)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}

		if (l == 3)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		}

		if (par6ItemStack.hasDisplayName())
		{
			((TileEntityMFurnace)par1World.getBlockTileEntity(par2, par3, par4)).func_94129_a(par6ItemStack.getDisplayName());
		}
	}


	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		if (!keepFurnaceInventory)
		{
			TileEntityMFurnace tileentityMfurnace = (TileEntityMFurnace)par1World.getBlockTileEntity(par2, par3, par4);

			if (tileentityMfurnace != null)
			{
				for (int j1 = 0; j1 < tileentityMfurnace.getSizeInventory(); ++j1)
				{
					ItemStack itemstack = tileentityMfurnace.getStackInSlot(j1);

					if (itemstack != null)
					{
						float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

						while (itemstack.stackSize > 0)
						{
							int k1 = this.furnaceRand.nextInt(21) + 10;

							if (k1 > itemstack.stackSize)
							{
								k1 = itemstack.stackSize;
							}

							itemstack.stackSize -= k1;
							EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound())
							{
								entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							}

							float f3 = 0.05F;
							entityitem.motionX = (double)((float)this.furnaceRand.nextGaussian() * f3);
							entityitem.motionY = (double)((float)this.furnaceRand.nextGaussian() * f3 + 0.2F);
							entityitem.motionZ = (double)((float)this.furnaceRand.nextGaussian() * f3);
							par1World.spawnEntityInWorld(entityitem);
						}
					}
				}
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	public boolean func_96468_q_()
	{
		return true;
	}


    
	
	public int func_94328_b_(World par1World, int par2, int par3, int par4, int par5)
	{
		return Container.func_94526_b((IInventory)par1World.getBlockTileEntity(par2, par3, par4));
	}
}
