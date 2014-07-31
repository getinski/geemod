/**
 * 
 */
package com.jonesgeek.mc.gmod.item;


import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
			world.playSoundAtEntity(entity, "random.bow", 1.0f, 1.0f);
		}
	}
	
	
	
}
