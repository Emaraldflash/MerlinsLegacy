package mods.MerlinsLegacy.common;

import java.util.Calendar;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySpriteG extends EntityMob {

	  
    private float heightOffset = 0.5F;

    
    private int heightOffsetUpdateTime;
    private int field_70846_g;
	
	public EntitySpriteG(World par1World) {
		super(par1World);
		this.texture = "/mods/MerlinsLegacy/textures/Sprites/SpriteG.png";
		this.moveSpeed = 0.25f;

	 }

    public int getMaxHealth()
    {
        return 20;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }

  
    protected String getLivingSound()
    {
        return "mob.bat.idle";
    }

    protected String getHurtSound()
    {
        return "mob.blaze.hit";
    }

    protected String getDeathSound()
    {
        return "mob.bat.death";
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float par1)
    {
        return 15728880;
    }

    public float getBrightness(float par1)
    {
        return 1.0F;
    }


    public boolean attackEntityAsMob(Entity par1Entity)
    {
        boolean flag = super.attackEntityAsMob(par1Entity);

        if (flag && this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float)this.worldObj.difficultySetting * 0.3F)
        {
            par1Entity.setFire(2 * this.worldObj.difficultySetting);
        }

        return flag;
    }


   
    protected void fall(float par1) {}

    
    protected int getDropItemId()
    {
        return MerlinsLegacy.Gsoul.itemID;
    }

    
    public boolean isBurning()
    {
        return this.func_70845_n();
    }

   
    protected void dropFewItems(boolean par1, int par2)
    {
        if (par1)
        {
            int j = this.rand.nextInt(2 + par2);

            for (int k = 0; k < j; ++k)
            {
                this.dropItem(MerlinsLegacy.Gsoul.itemID, 1);
            }
        }
    }

    public boolean func_70845_n()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void func_70844_e(boolean par1)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (par1)
        {
            b0 = (byte)(b0 | 1);
        }
        else
        {
            b0 &= -2;
        }

        this.dataWatcher.updateObject(16, Byte.valueOf(b0));
    }

   
    protected boolean isValidLightLevel()
    {
        return true;
    }

   
    public int getAttackStrength(Entity par1Entity)
    {
        return 6;
    }
}