package defeatedcrow.addonforamt.economy.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.economy.client.gui.ContainerDistributor;
import defeatedcrow.addonforamt.economy.client.gui.ContainerENMotor;
import defeatedcrow.addonforamt.economy.client.gui.ContainerENTank;
import defeatedcrow.addonforamt.economy.client.gui.ContainerGeneratorEMT;
import defeatedcrow.addonforamt.economy.client.gui.GuiDistributor;
import defeatedcrow.addonforamt.economy.client.gui.GuiENMotor;
import defeatedcrow.addonforamt.economy.client.gui.GuiENTank;
import defeatedcrow.addonforamt.economy.client.gui.GuiGeneratorEMT;
import defeatedcrow.addonforamt.economy.common.block.TileDistributor;
import defeatedcrow.addonforamt.economy.common.block.TileENMotor;
import defeatedcrow.addonforamt.economy.common.block.TileENTank;
import defeatedcrow.addonforamt.economy.common.block.TileGeneratorEMT;

public class CommonProxyEMT implements IGuiHandler {

	public int getRenderID() {
		return -1;
	}

	public void registerRenderers() {
	}

	public int addArmor(String armor) {
		return 0;
	}

	public World getClientWorld() {
		return null;
	}

	public EntityPlayer getClientPlayer() {
		return null;
	}

	public void registerFluidTex() {
	}

	public void registerTileEntity() {
		GameRegistry.registerTileEntity(TileDistributor.class, "defeatedcrow.emt.distributerTile");
		GameRegistry.registerTileEntity(TileENMotor.class, "defeatedcrow.emt.motorTile");
		GameRegistry.registerTileEntity(TileENTank.class, "defeatedcrow.emt.entankTile");
		GameRegistry.registerTileEntity(TileGeneratorEMT.class, "defeatedcrow.emt.generatorTile");
	}

	// GUIの登録
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (!world.blockExists(x, y, z))
			return null;
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if (tileentity instanceof TileGeneratorEMT) {
			return new ContainerGeneratorEMT(player, (TileGeneratorEMT) tileentity);
		} else if (tileentity instanceof TileENTank) {
			return new ContainerENTank(player, (TileENTank) tileentity);
		} else if (tileentity instanceof TileENMotor) {
			return new ContainerENMotor(player, (TileENMotor) tileentity);
		} else if (tileentity instanceof TileDistributor) {
			return new ContainerDistributor(player, (TileDistributor) tileentity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (!world.blockExists(x, y, z))
			return null;
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if (tileentity instanceof TileGeneratorEMT) {
			return new GuiGeneratorEMT(player, (TileGeneratorEMT) tileentity);
		} else if (tileentity instanceof TileENTank) {
			return new GuiENTank(player, (TileENTank) tileentity);
		} else if (tileentity instanceof TileENMotor) {
			return new GuiENMotor(player, (TileENMotor) tileentity);
		} else if (tileentity instanceof TileDistributor) {
			return new GuiDistributor(player, (TileDistributor) tileentity);
		}
		return null;
	}

	public void loadNEI() {
	}

	public void loadInit() {

	}

}