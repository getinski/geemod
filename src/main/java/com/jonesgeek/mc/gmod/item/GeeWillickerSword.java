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
public class GeeWillickerSword extends Item {

	public GeeWillickerSword() {
		this(CreativeTabs.tabTools);
	}
	
	public GeeWillickerSword(CreativeTabs tab) {
		setUnlocalizedName(GMod.MODID + "_" + "gsword");
		setTextureName(GMod.MODID + ":" + "gsword");
		setCreativeTab(tab);
	}
	
}
