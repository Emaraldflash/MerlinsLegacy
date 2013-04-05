package mods.MerlinsLegacy.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandlerML implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityMFurnace){
			return new ContainerMFurnace(player.inventory, (TileEntityMFurnace) tileEntity);
		}
		return null;
	}


	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityMFurnace){
			return new GUIMFurnace(player.inventory, (TileEntityMFurnace) tileEntity);
		}
		return null;

	}
}
