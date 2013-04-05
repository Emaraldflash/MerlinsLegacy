package mods.MerlinsLegacy.common;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.StatCollector;

public class GUIMFurnace extends GuiContainer {

	private TileEntityMFurnace furnaceInventory;

	public GUIMFurnace(InventoryPlayer par1InventoryPlayer, TileEntityMFurnace par2TileEntity)
	{
		super(new ContainerMFurnace(par1InventoryPlayer, par2TileEntity));
		this.furnaceInventory = par2TileEntity;
	}

	 protected void drawGuiContainerForegroundLayer(int par1, int par2)
	    {
	        this.fontRenderer.drawString("Magical Furnace", 8, 6, 4210752);
	        this.fontRenderer.drawString("Inventory", 8, 72, 4210752);
	    }

	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture("/mods/MerlinsLegacy/textures/Gui/MFurnaceGUI.png");
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;

		if (this.furnaceInventory.isBurning())
		{
			i1 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
		}

		i1 = this.furnaceInventory.getCookProgressScaled(24);
		this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	}
}

