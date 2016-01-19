package defeatedcrow.addonforamt.economy.plugin.energy;

import net.minecraft.nbt.NBTTagCompound;

public interface IEUSinkChannelEMT {

	public void readFromNBT2(NBTTagCompound par1NBTTagCompound);

	public void writeToNBT2(NBTTagCompound par1NBTTagCompound);

	public void invalidate2();

	public void onChunkUnload2();

	public void updateEntity2();

	public double getEnergyStored2();

	public void setEnergyStored2(double amount);

	public boolean useEnergy2(double amount);

}
