/**
 * 
 */
package com.jonesgeek.mc.gmod.tabs;

import com.jonesgeek.mc.gmod.GMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author ben_000
 *
 */
public class GTab extends CreativeTabs {
	private Item gTabItem;
	
	public GTab() {
		this("GeeMod");
	}

	/**
	 * @param unlocalizedName
	 */
	public GTab(String unlocalizedName) {
		super(unlocalizedName);
		gTabItem = new GTabItem();
		
	}
	
	/**
	 * @param id
	 * @param unlocalizedName
	 */
	public GTab(int id, String unlocalizedName) {
		super(id, unlocalizedName);
		gTabItem = new GTabItem();
	}

	/* (non-Javadoc)
	 * @see net.minecraft.creativetab.CreativeTabs#getTabIconItem()
	 */
	@Override
	public Item getTabIconItem() {
		return gTabItem;
	}
	
	private class GTabItem extends Item {
		public GTabItem() {
			super();
			setUnlocalizedName(GMod.MODID + "_" + "gtab");
			setTextureName(GMod.MODID + ":" + "gtab");
			
			GameRegistry.registerItem(this, "gtab");
		}
	}

}
