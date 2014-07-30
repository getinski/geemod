/**
 * 
 */
package com.jonesgeek.mc.gmod.item;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.jonesgeek.mc.gmod.GMod;

/**
 * @author will
 *
 */
public class GeeWillickerSword extends Item {

	public GeeWillickerSword() {
		this(CreativeTabs.tabTools);
	}
	
	public GeeWillickerSword(CreativeTabs tab) {
		setMaxStackSize(1);
		setFull3D();
		setUnlocalizedName(GMod.MODID + "_" + "gsword");
		setTextureName(GMod.MODID + ":" + "gsword");
		setCreativeTab(tab);
	}
	
}
