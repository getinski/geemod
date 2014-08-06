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
	private int depth;
	private int radius;

	public OreDetector( ) {
		this(null, 1);
	}
	
	public OreDetector(Block blockToDetect, int sensitivity) {
		this.blockToDetect = blockToDetect;
		this.depth = sensitivity * 50;
		this.radius = sensitivity - 1;
		
		super.setMaxDamage(depth);
		
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
			
			int depth = detectBlock(world, 
					MathHelper.floor_double(entity.posX), 
					MathHelper.floor_double(entity.posY - entity.yOffset),
					MathHelper.floor_double(entity.posZ),
					Block.getIdFromBlock(blockToDetect));
			
			if( depth > -1) {
				super.setDamage(itemStack, depth);
				world.playSoundAtEntity(entity, "random.bow", 1.0f, 1.0f);
			} else {
				super.setDamage(itemStack, 0);
			}
		} else {
			super.setDamage(itemStack, 0);
		}
	}
	
	/**
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param searchForId
	 * @return
	 */
	private int detectBlock(World world, int x, int y, int z, int searchForId) {
		int yDepth = y - (depth);
		for( int ySearch = y; ySearch >= yDepth; ySearch--) {
			for (int xSearch = x - radius; xSearch <= x + radius; xSearch++) {
				for (int zSearch = z - radius; zSearch <= z + radius; zSearch++) {
	            	Block block = world.getBlock(xSearch, ySearch, zSearch);
	            	int blockId = Block.getIdFromBlock(block);
	                if (blockId == searchForId) {
	                	return Math.abs(y - ySearch);
	                 }
	            }
	        }
	    }
	    return -1;
	}
	
}
