/**
 * 
 */
package com.jonesgeek.mc.gmod.item;


import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.lwjgl.input.Mouse;

import com.jonesgeek.mc.gmod.GMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author will
 *
 */
public class OreDetector extends Item {
	
	private Block blockToDetect;
	private int sensitivity;

	public OreDetector( ) {
		this(null, -1);
	}
	
	public OreDetector(Block blockToDetect, int sensitivity) {
		this.blockToDetect = blockToDetect;
		this.sensitivity = sensitivity;
		
		setMaxStackSize(1);
		setFull3D();
		setUnlocalizedName(GMod.MODID + "_" + "oreDetector");
		setTextureName(GMod.MODID + ":" + "oreDetector");
	}

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#onUpdate(net.minecraft.item.ItemStack, net.minecraft.world.World, net.minecraft.entity.Entity, int, boolean)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate(ItemStack itemStack, World world,
			Entity entity, int i1, boolean held) {
		super.onUpdate(itemStack, world, entity, i1, held);
		if(held && Mouse.isButtonDown(1) && blockToDetect != null) {
			Location location = new Location(entity);
			
			int depth = isBlockBeneath(world, location, sensitivity * 10, Block.getIdFromBlock(blockToDetect));
			if( depth > -1) {
				System.out.println("Block that is in range: " + depth);
				world.playSoundAtEntity(entity, "random.bow", 1.0f, 1.0f);
			}
		}
	}
	
	/**
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param depth
	 * @param searchForId
	 * @return
	 */
	private int isBlockBeneath(World world, Location loc, int depth, int searchForId) {
		int yDepth = loc.getY() - depth;
		for( int ySearch = loc.getY(); ySearch >= yDepth; ySearch--) {
			Block block = world.getBlock(loc.getX(), ySearch, loc.getZ());
        	int blockId = Block.getIdFromBlock(block);
            if (blockId == searchForId) {
                return Math.abs(loc.getY() - ySearch);
             }
		}
		return -1;
	}
	
	private class Location {
		private int x, y, z;
		private Location(Entity entity) {
			x = MathHelper.floor_double(entity.posX);
			y = MathHelper.floor_double(entity.posY - 0.20000000298023224D);
			z = MathHelper.floor_double(entity.posZ);
		}
		
		/**
		 * @return the x
		 */
		public int getX() {
			return x;
		}
		
		/**
		 * @return the y
		 */
		public int getY() {
			return y;
		}
		
		/**
		 * @return the z
		 */
		public int getZ() {
			return z;
		}
	}
	
}
