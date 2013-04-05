package mods.MerlinsLegacy.common;

import java.util.Calendar;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySpriteG extends EntityMob {

	public EntitySpriteG(World par1World) {
		super(par1World);
		this.texture = "/mods/MerlinsLegacy/textures/Sprites/SpriteG.png";
		this.moveSpeed = 0.25f;

	}
	
	private ChunkCoordinates currentFlightTarget;

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 0));
	}

	protected float getSoundVolume() {
		return 0.1F;
	}

	protected float getSoundPitch() {
		return super.getSoundPitch() * 0.95F;
	}

	protected String getLivingSound() {
		return this.rand.nextInt(4) != 0 ? null : "mob.bat.idle";
	}

	protected String getHurtSound() {
		return "mob.blaze.hurt";
	}

	protected String getDeathSound() {
		return "mob.bat.death";
	}

	public boolean canBePushed() {
		return false;
	}

	protected void collideWithEntity(Entity par1Entity) {
	}

	protected void func_85033_bc() {
	}

	public int getMaxHealth() {
		return 10;
	}

	public int getTotalArmorValue() {
		return 4;
	}

	public int getAttackStrength(Entity par1Entity) {
		return 10;
	}

	protected boolean isAIEnabled() {
		return true;
	}

	public void onUpdate() {
		super.onUpdate();
		this.motionY *= 0.6000000238418579D;
	}

	protected void updateAITasks() {
		super.updateAITasks();

		if (this.currentFlightTarget != null
				&& (!this.worldObj.isAirBlock(this.currentFlightTarget.posX,
						this.currentFlightTarget.posY,
						this.currentFlightTarget.posZ) || this.currentFlightTarget.posY < 1)) {
			this.currentFlightTarget = null;
		}

		if (this.currentFlightTarget == null
				|| this.rand.nextInt(30) == 0
				|| this.currentFlightTarget.getDistanceSquared((int) this.posX,
						(int) this.posY, (int) this.posZ) < 4.0F) {
			this.currentFlightTarget = new ChunkCoordinates((int) this.posX
					+ this.rand.nextInt(7) - this.rand.nextInt(7),
					(int) this.posY + this.rand.nextInt(6) - 2, (int) this.posZ
							+ this.rand.nextInt(7) - this.rand.nextInt(7));
		}

		double d0 = (double) this.currentFlightTarget.posX + 0.5D - this.posX;
		double d1 = (double) this.currentFlightTarget.posY + 0.1D - this.posY;
		double d2 = (double) this.currentFlightTarget.posZ + 0.5D - this.posZ;
		this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
		this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
		this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
		float f = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
		float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
		this.moveForward = 0.5F;
		this.rotationYaw += f1;
	}

	protected boolean canTriggerWalking() {
		return false;
	}

	protected void fall(float par1) {
	}

	protected void updateFallState(double par1, boolean par3) {
	}

	public boolean doesEntityNotTriggerPressurePlate() {
		return true;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.dataWatcher.updateObject(16,
				Byte.valueOf(par1NBTTagCompound.getByte("BatFlags")));
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("BatFlags",
				this.dataWatcher.getWatchableObjectByte(16));
	}

	public boolean getCanSpawnHere() {
		int i = MathHelper.floor_double(this.boundingBox.minY);

		if (i >= 63) {
			return false;
		} else {
			int j = MathHelper.floor_double(this.posX);
			int k = MathHelper.floor_double(this.posZ);
			int l = this.worldObj.getBlockLightValue(j, i, k);
			byte b0 = 4;
			Calendar calendar = this.worldObj.getCurrentDate();

			if ((calendar.get(2) + 1 != 10 || calendar.get(5) < 20)
					&& (calendar.get(2) + 1 != 11 || calendar.get(5) > 3)) {
				if (this.rand.nextBoolean()) {
					return false;
				}
			} else {
				b0 = 7;
			}

			return l > this.rand.nextInt(b0) ? false : super.getCanSpawnHere();
		}
	}

	public void initCreature() {
	}

	protected void dropFewItems(boolean par1, int par2) {
		if (par1) {
			int j = this.rand.nextInt(2 + par2);

			for (int k = 0; k < j; ++k) {
				this.dropItem(MerlinsLegacy.Gsoul.itemID, 1);
			}
		}
	}

}