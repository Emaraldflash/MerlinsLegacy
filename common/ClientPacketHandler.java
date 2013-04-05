package mods.MerlinsLegacy.common;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class ClientPacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload payload, Player player)
	{
		NBTTagCompound tag_X;
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(payload.data));
		try
		{
	         tag_X = (NBTTagCompound) NBTBase.readNamedTag(data);
	      }
	      catch (IOException e)
	      {
	         throw new RuntimeException(e.toString());
	      }
		
		  EntityPlayer thPl = (EntityPlayer) player;
	      int x = tag_X.getInteger("x");
	      int y = tag_X.getInteger("y");
	      int z = tag_X.getInteger("z");
	      World world = thPl.worldObj;
	      if (world.blockExists(x, y, z))
	      {
	         TileEntityMFurnace te = (TileEntityMFurnace) world.getBlockTileEntity(x, y, z);
	         if (te != null)
	         {
	            te.readFromNBT(tag_X);
	            NBTTagList nbttaglist = tag_X.getTagList("Items");
	            te.furnaceItemStacks = new ItemStack[te.getSizeInventory()];

	            for (int i = 0; i < nbttaglist.tagCount(); ++i)
	            {
	                NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
	                byte b0 = nbttagcompound1.getByte("Slot");

	                if (b0 >= 0 && b0 < te.furnaceItemStacks.length)
	                {
	                	te.furnaceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	                }
	            }

	            te.furnaceBurnTime = tag_X.getShort("BurnTime");
	            te.furnaceCookTime = tag_X.getShort("CookTime");
	            te.currentItemBurnTime = te.getItemBurnTime(te.furnaceItemStacks[1]);

	            if (tag_X.hasKey("CustomName"))
	            {
	                te.field_94130_e = tag_X.getString("CustomName");
	            }
	         }
	      }
	}
}
