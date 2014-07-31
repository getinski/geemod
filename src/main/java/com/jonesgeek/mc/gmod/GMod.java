package com.jonesgeek.mc.gmod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.jonesgeek.mc.gmod.item.GeeWillickerSword;
import com.jonesgeek.mc.gmod.item.GrapplingHook;
import com.jonesgeek.mc.gmod.item.OreDetector;
import com.jonesgeek.mc.gmod.tabs.GTab;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = GMod.MODID, version = GMod.VERSION)
public class GMod {
    public static final String MODID = "gmod";
    public static final String VERSION = "1.0";

    public static Item oreDetector;
    public static Item grapplingHook;
    public static Item gsword;
    public static CreativeTabs gTab;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	gTab = new GTab();
    	
    	grapplingHook = new GrapplingHook(gTab);
    	gsword = new GeeWillickerSword(gTab);
    	oreDetector = new OreDetector().setCreativeTab(gTab);
    	
    	GameRegistry.registerItem(grapplingHook, "grapplingHook");
    	GameRegistry.registerItem(gsword, "gsword");
    	GameRegistry.registerItem(oreDetector,"oreDetector");
    	
    	registerDetectors("coal", Blocks.coal_ore, Items.coal);
    	registerDetectors("iron", Blocks.iron_ore, Items.iron_ingot);
    	registerDetectors("lapis", Blocks.lapis_ore, Items.dye, 4);
    	registerDetectors("gold", Blocks.gold_ore, Items.gold_ingot);
    	registerDetectors("diamond", Blocks.diamond_ore, Items.diamond);
    	registerDetectors("redstone", Blocks.redstone_ore, Items.redstone);
    	registerDetectors("emerald", Blocks.emerald_ore, Items.emerald);
    	registerDetectors("quartz", Blocks.quartz_ore, Items.quartz);
    	
    }
    
    private void registerDetectors(String oreType, Block oreBlock, Item oreItem) {
    	registerDetectors(oreType, oreBlock, oreItem, -1);
    }
    
    private void registerDetectors(String oreType, Block oreBlock, Item oreItem, int damage) {
    	OreDetector basicDetector = registerDetector(oreType+"Detector", oreBlock, oreItem, oreDetector, 1, damage);
    	OreDetector betterDetector = registerDetector(oreType+"DetectorBetter", oreBlock, oreItem, basicDetector, 3, damage);
    	registerDetector(oreType+"DetectorBest", oreBlock, oreItem, betterDetector, 6, damage);
    }
    
    private OreDetector registerDetector(String itemName, Block oreBlock, Item oreItem, Item extendsDetector,  int sensitivity, int damage) {
    	OreDetector detector = new OreDetector(oreBlock, sensitivity);
    	detector.setUnlocalizedName(GMod.MODID + "_" + itemName);
    	detector.setTextureName(GMod.MODID + ":" + itemName);
    	GameRegistry.registerItem(detector, itemName);
    	
    	ItemStack oreItemStack = (damage == -1 ? 
    			new ItemStack(oreItem) : 
    			new ItemStack(oreItem, 1, damage));
    	
    	GameRegistry.addRecipe(new ItemStack(detector, 1), new Object[]{
    		" A ",
    		" B ",
    		'A', extendsDetector,
    		'B', oreItemStack
    	});
    	
    	return detector;
    }
}
