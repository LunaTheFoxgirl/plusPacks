package com.plusmods.vanillaplus.common;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.*;
import net.minecraft.client.audio.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.achievement.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.model.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.client.settings.*;
import net.minecraft.command.*;
import net.minecraft.crash.*;
import net.minecraft.creativetab.*;
import net.minecraft.dispenser.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.init.Items;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.rcon.*;
import net.minecraft.pathfinding.*;
import net.minecraft.potion.*;
import net.minecraft.profiler.*;
import net.minecraft.server.*;
import net.minecraft.server.dedicated.*;
import net.minecraft.server.gui.*;
import net.minecraft.server.integrated.*;
import net.minecraft.server.management.*;
import net.minecraft.src.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.village.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.world.demo.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.world.storage.*;
import net.minecraftforge.classloading.*;
import net.minecraftforge.client.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.event.sound.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.event.entity.item.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.minecart.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.terraingen.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.oredict.*;
import net.minecraftforge.transformers.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.common.network.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.plusmods.oresplus.oreGen.JadeOreGenerator;
import com.plusmods.vanillaplus.blocks.CopperOre;
import com.plusmods.vanillaplus.blocks.InfusedOre;
import com.plusmods.vanillaplus.creativeTab.VanillaPlusItemsTab;
import com.plusmods.vanillaplus.creativeTab.VanillaPlusOresTab;
import com.plusmods.vanillaplus.creativeTab.VanillaPlusToolsTab;
import com.plusmods.vanillaplus.items.ItemCopperAxe;
import com.plusmods.vanillaplus.items.ItemCopperChunk;
import com.plusmods.vanillaplus.items.ItemCopperIngot;
import com.plusmods.vanillaplus.items.ItemCopperPickaxe;
import com.plusmods.vanillaplus.items.ItemCopperShovel;
import com.plusmods.vanillaplus.items.ItemCopperSword;
import com.plusmods.vanillaplus.items.ItemFlintAxe;
import com.plusmods.vanillaplus.items.ItemFlintPickaxe;
import com.plusmods.vanillaplus.items.ItemFlintShovel;
import com.plusmods.vanillaplus.items.ItemFlintSword;
import com.plusmods.vanillaplus.items.ItemInfusedEssence;
import com.plusmods.vanillaplus.oreGen.CopperOreGen;
import com.plusmods.vanillaplus.oreGen.InfusedOreGen;
import com.plusmods.vanillaplus.oreGen.PlatinumOreGen;
import com.plusmods.vanillaplus.oreGen.SilverOreGen;

import java.util.*;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import cpw.mods.fml.relauncher.*;

@Mod(modid = VanillaPlus.MODID, version = VanillaPlus.VERSION)
public class VanillaPlus {

	// Mod id information
	public static final String MODID = "VanillaPlus";
	public static final String VERSION = "1.0.0";

	// Blocks
	public static Block infusedOre;
	public static Block copperOre;
	public static Block silverOre;
	public static Block platinumOre;
	
	//Items
	public static Item infusedEssence;
	public static Item copperIngot;
	public static Item silverIngot;
	public static Item platinumIngot;
	public static Item copperChunk;
	public static Item silverChunk;
	public static Item platinumChunk;
	
	//Tools
	public static Item flintPickaxe;
	public static Item flintSword;
	public static Item flintAxe;
	public static Item flintShovel;
	public static Item copperPickaxe;
	public static Item copperSword;
	public static Item copperAxe;
	public static Item copperShovel;

	// @SidedProxy(clientSide = "com.plusmods.boomplus.ClientProxyBoomPlus",
	// serverSide = "com.plusmods.boomplus.CommonProxyBoomPlus")

	@Instance(MODID)
	public static VanillaPlus instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("VanillaPlus Initialized");
		//Register Blocks
		infusedOre = new InfusedOre(Material.iron).setBlockName("InfusedOre").setHardness(2.0f).setCreativeTab(VanillaPlusOresTab.tab).setBlockTextureName("vanillaplus:infused_ore");
		infusedOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		infusedOre.setHarvestLevel("pickaxe", 2);
		copperOre = new CopperOre(Material.iron).setBlockName("CopperOre").setHardness(2.0f).setCreativeTab(VanillaPlusOresTab.tab).setBlockTextureName("vanillaplus:copper_ore");
		copperOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		copperOre.setHarvestLevel("pickaxe", 2);
		System.out.println("Blocks Loaded");
		
		//Register Items
		infusedEssence = new ItemInfusedEssence(5000).setUnlocalizedName("InfusedEssence").setCreativeTab(VanillaPlusItemsTab.tab).setTextureName("vanillaplus:infused_essence");
		copperIngot = new ItemCopperIngot(5001).setUnlocalizedName("CopperIngot").setCreativeTab(VanillaPlusItemsTab.tab).setTextureName("vanillaplus:copper_ingot");
		copperChunk = new ItemCopperChunk(5002).setUnlocalizedName("CopperChunk").setCreativeTab(VanillaPlusItemsTab.tab).setTextureName("vanillaplus:copper_chunk");
		flintPickaxe = new ItemFlintPickaxe(ToolMaterial.STONE).setUnlocalizedName("FlintPickaxe").setCreativeTab(VanillaPlusToolsTab.tab).setTextureName("vanillaplus:flint_pickaxe");
		flintSword = new ItemFlintSword(ToolMaterial.STONE).setUnlocalizedName("FlintSword").setCreativeTab(VanillaPlusToolsTab.tab).setTextureName("vanillaplus:flint_sword");
		flintAxe = new ItemFlintAxe(ToolMaterial.STONE).setUnlocalizedName("FlintAxe").setCreativeTab(VanillaPlusToolsTab.tab).setTextureName("vanillaplus:flint_axe");
		flintShovel = new ItemFlintShovel(ToolMaterial.STONE).setUnlocalizedName("FlintShovel").setCreativeTab(VanillaPlusToolsTab.tab).setTextureName("vanillaplus:flint_shovel");
		copperPickaxe = new ItemCopperPickaxe(ToolMaterial.STONE).setUnlocalizedName("CopperPickaxe").setCreativeTab(VanillaPlusToolsTab.tab).setTextureName("vanillaplus:copper_pickaxe");
		copperSword = new ItemCopperSword(ToolMaterial.STONE).setUnlocalizedName("CopperSword").setCreativeTab(VanillaPlusToolsTab.tab).setTextureName("vanillaplus:copper_sword");
		copperAxe = new ItemCopperAxe(ToolMaterial.STONE).setUnlocalizedName("CopperAxe").setCreativeTab(VanillaPlusToolsTab.tab).setTextureName("vanillaplus:copper_axe");
		copperShovel = new ItemCopperShovel(ToolMaterial.STONE).setUnlocalizedName("CopperShovel").setCreativeTab(VanillaPlusToolsTab.tab).setTextureName("vanillaplus:copper_shovel");
		System.out.println("Items Loaded");
		
		//Register Mobs
		System.out.println("Mobs Loaded");
		}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		//GameRegister Items
		GameRegistry.registerItem(infusedEssence, "InfusedEssence");
		GameRegistry.registerItem(copperChunk, "CopperChunk");
		GameRegistry.registerItem(copperIngot, "CopperIngot");
		System.out.println("Items Registered");
		//GameRegister Blocks
		GameRegistry.registerBlock(infusedOre, "InfusedOre");
		System.out.println("Blocks Registered");
		//GameRegister Tools
		GameRegistry.registerItem(flintPickaxe, "FlintPickaxe");
		GameRegistry.registerItem(flintSword, "FlintSword");
		GameRegistry.registerItem(flintAxe, "FlintAxe");
		GameRegistry.registerItem(flintShovel, "FlintShovel");
		GameRegistry.registerItem(copperPickaxe, "CopperPickaxe");
		GameRegistry.registerItem(copperSword, "CopperSword");
		GameRegistry.registerItem(copperAxe, "CopperAxe");
		GameRegistry.registerItem(copperShovel, "CopperShovel");
		System.out.println("Tools Registered");
		//GameRegister Recipes
		//FlintPickaxe
		GameRegistry.addRecipe(new ItemStack(flintPickaxe), "XXX", " I ", " I ", 
				'X', new ItemStack(Items.flint),
				'I', new ItemStack(Items.stick));
		//FlintSword
		GameRegistry.addRecipe(new ItemStack(flintSword), " X ", " X ", " I ", 
				'X', new ItemStack(Items.flint),
				'I', new ItemStack(Items.stick));
		//FlintAxe
		GameRegistry.addRecipe(new ItemStack(flintAxe), " XX", " IX", " I ", 
				'X', new ItemStack(Items.flint),
				'I', new ItemStack(Items.stick));
		//FlintShovel
		GameRegistry.addRecipe(new ItemStack(flintShovel), " X ", " I ", " I ",  
				'X', new ItemStack(Items.flint),
				'I', new ItemStack(Items.stick));
		//CopperPickaxe
		GameRegistry.addRecipe(new ItemStack(copperPickaxe), "XXX", " I ", " I ",
				'X', new ItemStack(VanillaPlus.copperIngot),
				'I', new ItemStack(Items.stick));
		//CopperSword
		GameRegistry.addRecipe(new ItemStack(copperSword), " X ", " X ", " I ",
				'X', new ItemStack(VanillaPlus.copperIngot),
				'I', new ItemStack(Items.stick));
		//CopperAxe
		GameRegistry.addRecipe(new ItemStack(copperAxe), " XX", " IX", " I ",
				'X', new ItemStack(VanillaPlus.copperIngot),
				'I', new ItemStack(Items.stick));
		//CopperShovel
		GameRegistry.addRecipe(new ItemStack(copperShovel), " X ", " I ", " I ",
				'X', new ItemStack(VanillaPlus.copperIngot),
				'I', new ItemStack(Items.stick));
		System.out.println("Recipes Registered");
		
		//Smelting Recipes
		GameRegistry.addSmelting(copperChunk, new ItemStack(copperIngot), 0.6f);
		
		//World Generators
		GameRegistry.registerWorldGenerator(new CopperOreGen(), 2);
		GameRegistry.registerWorldGenerator(new SilverOreGen(), 2);
		GameRegistry.registerWorldGenerator(new PlatinumOreGen(), 2);
		GameRegistry.registerWorldGenerator(new InfusedOreGen(), 2);
		System.out.println("World Generators Registered");
	}

	public void replaceCraftingItem(ItemStack itemStack,
			Item itemCraftingToReplace, Object... addition) {

	}

	public void replaceCraftingBlock(ItemStack itemStack,
			Block blockCraftingToReplace, Object... addition) {

	}

}
