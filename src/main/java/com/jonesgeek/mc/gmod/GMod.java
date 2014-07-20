package com.jonesgeek.mc.gmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.jonesgeek.mc.gmod.item.GeeWillickerSword;
import com.jonesgeek.mc.gmod.item.GrapplingHook;
import com.jonesgeek.mc.gmod.item.MetalDetector;
import com.jonesgeek.mc.gmod.tabs.GTab;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = GMod.MODID, version = GMod.VERSION)
public class GMod {
    public static final String MODID = "gmod";
    public static final String VERSION = "1.0";

    public static Item metaldetect;
    public static Item grapplingHook;
    public static Item gsword;
    public static CreativeTabs gTab;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	gTab = new GTab();
    	
    	grapplingHook = new GrapplingHook(gTab);
    	gsword = new GeeWillickerSword(gTab);
    	metaldetect = new MetalDetector(gTab);
    	
    	GameRegistry.registerItem(grapplingHook, "grapplingHook");
    	GameRegistry.registerItem(gsword, "gsword");
    	GameRegistry.registerItem(metaldetect,"metaldetect");
    	
    	/*GameRegistry.addRecipe(new ItemStack(Items.cookie, 64), new Object[]{
    		"AAA",
    		"AAA",
    		"AAA",
    		'A', new ItemStack(Items.dye, 1, 1)
    	});
    	GameRegistry.addRecipe(new ItemStack(Items.dye, 1, 1), new Object[]{
    		"AA",
    		"AA",
    		'A', Blocks.cobblestone
    	});
    	GameRegistry.addRecipe(new ItemStack(Items.dye, 2, 15), new Object[]{
    		"AB ",
    		"AAC",
    		"A  ",
    		'A', Items.cookie, 'B', Blocks.dirt, 'C', new ItemStack(Items.dye, 1, 1)
    	});
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 1), new Object[]
    	{
    		new ItemStack(Items.dye, 1, 1), Items.redstone
    	});
    	
    	GameRegistry.addSmelting(new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 11), 0.1F);*/
    }
}
