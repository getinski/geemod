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
public class GrapplingHook extends Item {

	public GrapplingHook() {
		this(CreativeTabs.tabTools);
	}
	
	public GrapplingHook(CreativeTabs tab) {
		setUnlocalizedName(GMod.MODID + "_" + "grapplingHook");
		setTextureName(GMod.MODID + ":" + "grapplingHook");
		setCreativeTab(tab);
	}
	
}
