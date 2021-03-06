package defeatedcrow.addonforamt.economy.common.build;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import defeatedcrow.addonforamt.economy.api.BuildType;

public class ItemBoardBuild extends ItemSimpleBuild {

	public ItemBoardBuild() {
		super();
		this.setTextureName("economical:tools/buildcard_board");
	}

	@Override
	public boolean onBuild(World world, int x, int y, int z, int dir, EntityPlayer player, ItemStack stack) {
		int[] ofx = {
				0,
				-1,
				0,
				1 };
		int[] ofz = {
				1,
				0,
				-1,
				0 };
		int range = this.getArea(stack.getItemDamage());
		int minX = ofx[dir] < 0 ? x + ofx[dir] * range : x;
		int maxX = ofx[dir] < 0 ? x : x + ofx[dir] * range;
		int minZ = ofz[dir] < 0 ? z + ofz[dir] * range : z;
		int maxZ = ofz[dir] < 0 ? z : z + ofz[dir] * range;
		int minY = y + 1;
		int maxY = y + range + 1;
		BlockSet set = this.getPlaceBlock(stack.getItemDamage());
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j < maxY; j++) {
				for (int k = minZ; k <= maxZ; k++) {
					if (this.isReplaceable(world, i, j, k)) {
						world.setBlock(i, j, k, set.block, set.meta, 3);
					}
				}
			}
		}
		return true;
	}

	@Override
	public BuildType getType(int meta) {
		return BuildType.BOARD;
	}

	@Override
	public boolean forceReplace() {
		return false;
	}

}
