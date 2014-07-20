/**
 * 
 */
package com.jonesgeek.mc.gmod.item;


import com.jonesgeek.mc.gmod.GMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author will
 *
 */
public class MetalDetector extends Item {

	public MetalDetector() {
		this(CreativeTabs.tabTools);
	}
	
	public MetalDetector(CreativeTabs tab) {
		setUnlocalizedName(GMod.MODID + "_" + "metaldetect");
		setTextureName(GMod.MODID + ":" + "metaldetect");
		setCreativeTab(tab);
	}
	
}
