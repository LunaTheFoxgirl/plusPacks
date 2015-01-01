package com.plusmods.boomplus.common;

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
import net.minecraft.init.Blocks;
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
import net.minecraftforge.common.util.EnumHelper;
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

import com.plusmods.boomplus.acheivement.AchievementCool;
import com.plusmods.boomplus.acheivement.AchievementNuclear;
import com.plusmods.boomplus.acheivement.AchievementOreIsIt;
import com.plusmods.boomplus.blocks.BlockBlazeOre;
import com.plusmods.boomplus.blocks.BlockCrashyBoom;
import com.plusmods.boomplus.blocks.BlockEnderBoom;
import com.plusmods.boomplus.blocks.BlockInstaBoom;
import com.plusmods.boomplus.blocks.BlockLargeBoom;
import com.plusmods.boomplus.blocks.BlockLavaBoom;
import com.plusmods.boomplus.blocks.BlockMagicBoom;
import com.plusmods.boomplus.blocks.BlockMassiveBoom;
import com.plusmods.boomplus.blocks.BlockMediumBoom;
import com.plusmods.boomplus.blocks.BlockNetherBoom;
import com.plusmods.boomplus.blocks.BlockRadioactiveOre;
import com.plusmods.boomplus.blocks.BlockRadioactiveBoom;
import com.plusmods.boomplus.blocks.BlockSmallBoom;
import com.plusmods.boomplus.blocks.BlockSneakyBoomStone;
import com.plusmods.boomplus.blocks.BlockSneakyBoomChest;
import com.plusmods.boomplus.blocks.BlockSneakyBoomDiamond;
import com.plusmods.boomplus.blocks.BlockSneakyBoomGold;
import com.plusmods.boomplus.blocks.BlockSneakyBoomIron;
import com.plusmods.boomplus.creativeTab.BoomPlusTab;
import com.plusmods.boomplus.entities.TileEntityChestValues;
import com.plusmods.boomplus.events.BoomCraftEvent;
import com.plusmods.boomplus.events.BoomSpawn;
import com.plusmods.boomplus.gui.GuiBeginnerWelcomeGUI;
import com.plusmods.boomplus.gui.GuiWelcomeGui;
import com.plusmods.boomplus.items.ItemBoomJacket;
import com.plusmods.boomplus.items.ItemCoolGlasses;
import com.plusmods.boomplus.items.ItemSneakyBoomEdible;
import com.plusmods.boomplus.items.ItemDetonator;
import com.plusmods.boomplus.items.ItemGuideBook;
import com.plusmods.boomplus.items.ItemRadioactivePowder;
import com.plusmods.boomplus.items.ItemStrangeSymbol;
import com.plusmods.oresplus.blocks.UraniumBlock;
import com.plusmods.oresplus.creativeTabs.OresPlusTab;

import java.util.*;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import cpw.mods.fml.relauncher.*;

/*
 * Author: Member1221
 * Boom+ creators: ZakDoesGaming, Member1221.
 * Code rewritten for Multiplayer, and non MCreator sloppy-ness by: Member1221.
 */

@Mod(modid = BoomPlus.MODID, version = BoomPlus.VERSION)
public class BoomPlus
{

	//Mod id information
		public static final String MODID = "BoomPlus";
		public static final String VERSION = "1.3.0";
	
	//Items
		public static Item boomJacket;
		public static Item detonator;
		public static Item guideBook;
		public static Item coolGlasses;
		public static Item strangeSymbol;
		public static Item sneakyBoomEdible;
		public static Item radioactivePowder;
		
	//Blocks
		
		//Ores
			public static Block blazeOre;
			public static Block radioactiveOre;
			
		//Booms
			public static Block enderBoom;
			public static Block largeBoom;
			public static Block lavaBoom;
			public static Block magicBoom;
			public static Block massiveBoom;
			public static Block mediumBoom;
			public static Block netherBoom;
			public static Block radioactiveBoom;
			public static Block smallBoom;
			public static Block sneakyBoomChest, sneakyBoomDiamond, sneakyBoomGold, sneakyBoomIron, sneakyBoomStone;
			public static Block crashyBoom;
			public static Block instaBoom;
			
			
		//ToolMaterials
			public static final Item.ToolMaterial strangeMaterial = EnumHelper.addToolMaterial("jadeToolMaterial", 12, 2000, 6, 999999999, 0);
	
			
		//Achievements & Pages
			public static Achievement oreIsItAchievement;
			public static Achievement goingNuclearAchievement;
			public static Achievement coolAchievement;
			public static AchievementPage boomPage;

			
			
			

	//@SidedProxy(clientSide = "com.plusmods.boomplus.ClientProxyBoomPlus", serverSide = "com.plusmods.boomplus.CommonProxyBoomPlus")

	@Instance(MODID)
	public static BoomPlus instance;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		//Items
		
			//BoomJacket
				boomJacket = new ItemBoomJacket(ArmorMaterial.CLOTH, 0, 1).setUnlocalizedName("BoomJacket").setTextureName("boomplus:boom_jacket");
			
			//RadioactivePowder
				radioactivePowder = new ItemRadioactivePowder(0).setUnlocalizedName("RadioactivePowder").setTextureName("boomplus:radioactive_powder");
		
			//Detonator
				detonator = new ItemDetonator(2013).setUnlocalizedName("Detonator").setTextureName("boomplus:detonator_up");
		
			//GuideBook
				guideBook = new ItemGuideBook(1).setUnlocalizedName("GuideBook").setTextureName("boomplus:guide_book");
		
			//CoolGlasses
				coolGlasses = new ItemCoolGlasses(ArmorMaterial.CLOTH, 0, 0).setUnlocalizedName("CoolGlasses").setTextureName("boomplus:cool_glasses");
		
			//StrangeSymbol
				strangeSymbol = new ItemStrangeSymbol(strangeMaterial).setUnlocalizedName("StrangeSymbol").setTextureName("boomplus:ore_is_it");
	
			//SneakyBoomEdible
				sneakyBoomEdible = new ItemSneakyBoomEdible(2, 1.0f, true).setUnlocalizedName("SneakyBoomEdible").setTextureName("boomplus:sneaky_boom_edible");
		    
		    
	//Blocks
			
		//Ores
			
			//BlazeOre
				blazeOre = new BlockBlazeOre().setBlockName("BlazeOre").setBlockTextureName("boomplus:blaze_ore");
				
			//RadioactiveOre
				radioactiveOre = new BlockRadioactiveOre().setBlockName("RadioactiveOre").setBlockTextureName("boomplus:radioactive_ore");
		
		//Booms
				
			//CrashyBoom
				crashyBoom = new BlockCrashyBoom(Material.tnt).setBlockName("CrashyBoom").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:radioactive_boom");
		
			//EnderBoom
				enderBoom = new BlockEnderBoom(Material.rock).setBlockName("EnderBoom").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:ender_boom");
			
			//SmallBoom
				smallBoom = new BlockSmallBoom(Material.tnt).setBlockName("SmallBoom").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:small_boom");
				
			//MediumBoom
				mediumBoom = new BlockMediumBoom(Material.tnt).setBlockName("MediumBoom").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:medium_boom");
				
			//LargeBoom
				largeBoom = new BlockLargeBoom(Material.tnt).setBlockName("LargeBoom").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:large_boom");
				
			//MassiveBoom
				massiveBoom = new BlockMassiveBoom(Material.tnt).setBlockName("MassiveBoom").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:massive_boom");
				
			//LavaBoom
				lavaBoom = new BlockLavaBoom().setBlockName("LavaBoom").setBlockName("LavaBoom").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:lava_boom");
				
			//SneakyBoomStone
				sneakyBoomStone = new BlockSneakyBoomStone().setBlockName("SneakyBoomStone").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:sneaky_boom_stone");
				
			//SneakyBoomIron
				sneakyBoomIron = new BlockSneakyBoomIron().setBlockName("SneakyBoomIron").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:sneaky_boom_iron");
				
			//SneakyBoomGold
				sneakyBoomGold = new BlockSneakyBoomGold().setBlockName("SneakyBoomGold").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:sneaky_boom_gold");
				
			//SneakyBoomDiamond
				sneakyBoomDiamond = new BlockSneakyBoomDiamond().setBlockName("SneakyBoomDiamond").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:sneaky_boom_diamond");
				
			//SneakyBoomChest
				sneakyBoomChest = new BlockSneakyBoomChest(1).setBlockName("SneakyBoomChest").setHardness(0.5f).setCreativeTab(BoomPlusTab.tab); //Texture is overwritten by normal chest, so no texture is needed to be defined
				
			//NetherBoom
				netherBoom = new BlockNetherBoom(Material.tnt).setBlockName("NetherBoom").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:nether_boom");
		
			//RadioactiveBoom
				radioactiveBoom = new BlockRadioactiveBoom(Material.tnt).setBlockName("RadioactiveBoom").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:radioactive_boom");
				
			//MagicBoom
				magicBoom = new BlockMagicBoom(Material.tnt).setBlockName("MagicBoom").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:magic_boom");
				
			//InstaBoom
				instaBoom = new BlockInstaBoom().setBlockName("InstantBoom").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:instant_boom");
		
	//Achievements
				
			//OreIsIt
				oreIsItAchievement = AchievementOreIsIt.achievement;
				
			//GoingNuclear
				goingNuclearAchievement = AchievementNuclear.achievement;
				
			//Cool (Guys don't look at explosions)
				coolAchievement = AchievementCool.achievement;
				
			//BoomPage
				boomPage =  new AchievementPage("Boom+", new Achievement[]{oreIsItAchievement, goingNuclearAchievement, coolAchievement});
				
				
				
	
	//Tile Entities
			//IsArmed
				GameRegistry.registerTileEntity(TileEntityChestValues.class, "isArmed");
	}
	

	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		//Items
		
			//All
		
				//BoomJacket
					GameRegistry.registerItem(boomJacket, "BoomJacket");
					
				//RadioactivePowder
					GameRegistry.registerItem(radioactivePowder, "RadioactivePowder");
					
				//Detonator
					GameRegistry.registerItem(detonator, "Detonator");
					
				//Guidebook
					GameRegistry.registerItem(guideBook, "GuideBook");
					
				//CoolGlasses
					GameRegistry.registerItem(coolGlasses, "CoolGlasses");
				
				//StrangeSymbol
					GameRegistry.registerItem(strangeSymbol, "StrangeSymbol");
					
				//SneakyBoomEdible
					GameRegistry.registerItem(sneakyBoomEdible, "SneakyBoomEdible");
		
		//Blocks
					
			//Ores
					
				//BlazeOre
					GameRegistry.registerBlock(blazeOre, "BlazeOre");
				
				//RadioactiveOre
					GameRegistry.registerBlock(radioactiveOre, "RadioactiveOre");
					
			//Booms
					
				//CrashyBoom
					GameRegistry.registerBlock(crashyBoom, "CrashyBoom");
					
				//EnderBoom
					GameRegistry.registerBlock(enderBoom, "EnderBoom");
					
				//SmallBoom
					GameRegistry.registerBlock(smallBoom, "SmallBoom");
					
				//MediumBoom
					GameRegistry.registerBlock(mediumBoom, "MediumBoom");
					
				//LargeBoom
					GameRegistry.registerBlock(largeBoom, "LargeBoom");
					
				//MassiveBoom
					GameRegistry.registerBlock(massiveBoom, "MassiveBoom");
					
				//LavaBoom
					GameRegistry.registerBlock(lavaBoom, "LavaBoom");
					
				//SneakyBoomStone
					GameRegistry.registerBlock(sneakyBoomStone, "SneakyBoomStone");
					
				//SneakyBoomIron
					GameRegistry.registerBlock(sneakyBoomIron, "SneakyBoomIron");
					
				//SneakyBoomGold
					GameRegistry.registerBlock(sneakyBoomGold, "SneakyBoomGold");
					
				//SneakyBoomDiamond
					GameRegistry.registerBlock(sneakyBoomDiamond, "SneakyBoomDiamond");
					
				///SneakyBoomChest
					GameRegistry.registerBlock(sneakyBoomChest, "SneakyBoomChest");
					
				//NetherBoom
					GameRegistry.registerBlock(netherBoom, "NetherBoom");
					
				//RadioactiveBoom
					GameRegistry.registerBlock(radioactiveBoom, "RadioactiveBoom");
					
				//MagicBoom
					GameRegistry.registerBlock(magicBoom, "MagicBoom");
					
				//InstaBoom
					GameRegistry.registerBlock(instaBoom, "InstantBoom");	//Last register needed.
					
					
		//AchievementPages
					
			//BoomPage
				AchievementPage.registerAchievementPage(boomPage);
				
				
		//CraftingRecipes
			
			//Items
				
				//BoomJacket
					GameRegistry.addRecipe(new ItemStack(boomJacket),
							"ITI", 
							"TCT", 
							"ITI", 
							'I', Items.iron_ingot,
							'T', Blocks.tnt,
							'C', Items.diamond_chestplate);
				//Detonator
					GameRegistry.addRecipe(new ItemStack(detonator),
							"IWI", 
							"RRR", 
							"IRI", 
							'I', Items.iron_ingot,
							'W', new ItemStack(Blocks.wool, 1, 14),
							'R', Items.redstone);
				//CoolGlasses
					GameRegistry.addRecipe(new ItemStack(coolGlasses),
							"   ", 
							"WGW", 
							"   ", 
							'G', Blocks.glass,
							'W', new ItemStack(Blocks.wool, 1, 15));
				//SneakyBoomEdible
					GameRegistry.addRecipe(new ItemStack(sneakyBoomEdible),
							" B ", 
							"BTB", 
							" B ", 
							'T', Blocks.tnt,
							'B', Items.beef);
					
			//Blocks
				
				//InstantBoom
					GameRegistry.addRecipe(new ItemStack(instaBoom),
							"PRP", 
							"TTT", 
							"PRP", 
							'P', Items.iron_pickaxe,
							'R', Items.redstone,
							'T', Blocks.tnt);
				//InstantBoom
					GameRegistry.addRecipe(new ItemStack(enderBoom),
							"SES", 
							"ETE", 
							"SES", 
							'S', Blocks.end_stone,
							'E', Items.ender_pearl,
							'T', Blocks.tnt);
				//SmallBoom
					GameRegistry.addRecipe(new ItemStack(smallBoom),
							"WTW", 
							"WTW", 
							"WTW", 
							'T', Blocks.tnt,
							'W', new ItemStack(Blocks.wool, 1, 4));
				//MediumBoom
					GameRegistry.addRecipe(new ItemStack(mediumBoom),
							"WTW", 
							"TTT", 
							"WTW", 
							'T', Blocks.tnt,
							'W', new ItemStack(Blocks.wool, 1, 9));
				//LargeBoom
					GameRegistry.addRecipe(new ItemStack(largeBoom),
							"TTT", 
							"TWT", 
							"TTT", 
							'T', Blocks.tnt,
							'W', new ItemStack(Blocks.wool, 1, 10));
				//MassiveBoom
					GameRegistry.addRecipe(new ItemStack(massiveBoom),
							"WMW", 
							"MLM", 
							"WMW", 
							'M', largeBoom,
							'L', mediumBoom,
							'W', new ItemStack(Blocks.wool, 1, 4));
				//LavaBoom
					GameRegistry.addRecipe(new ItemStack(lavaBoom),
							"CLC", 
							"LTL", 
							"CLC", 
							'C', Blocks.cobblestone,
							'L', Items.lava_bucket,
							'T', Blocks.tnt);
				//LavaBoom
					GameRegistry.addRecipe(new ItemStack(sneakyBoomStone),
							"CLC", 
							"LTL", 
							"CLC", 
							'C', Blocks.cobblestone,
							'L', Items.lava_bucket,
							'T', Blocks.tnt);
				//SneakyBoomStone
					GameRegistry.addRecipe(new ItemStack(sneakyBoomStone),
							"TTT", 
							"TST", 
							"TTT", 
							'S', Blocks.stone,
							'T', Blocks.tnt);
				//SneakyBoomIron
					GameRegistry.addRecipe(new ItemStack(sneakyBoomIron),
							"TTT", 
							"TIT", 
							"TTT", 
							'I', Items.iron_ingot,
							'T', Blocks.tnt);
				//SneakyBoomGold
					GameRegistry.addRecipe(new ItemStack(sneakyBoomGold),
							"TTT", 
							"TGT", 
							"TTT", 
							'G', Items.gold_ingot,
							'T', Blocks.tnt);
				//SneakyBoomGold
					GameRegistry.addRecipe(new ItemStack(sneakyBoomDiamond),
							"TTT", 
							"TDT", 
							"TTT", 
							'D', Items.diamond,
							'T', Blocks.tnt);
				//SneakyBoomChest
					GameRegistry.addRecipe(new ItemStack(sneakyBoomChest),
							"TTL", 
							"TCR", 
							"TTT", 
							'C', Blocks.chest,
							'T', Blocks.tnt,
							'R', Items.redstone,
							'L', Blocks.lever);
				//NetherBoom
					GameRegistry.addRecipe(new ItemStack(netherBoom),
							"BGB", 
							"GTG", 
							"BGB", 
							'C', Items.blaze_powder,
							'T', Blocks.tnt,
							'G', Items.ghast_tear);
				//RadioactiveBoom
					GameRegistry.addRecipe(new ItemStack(radioactiveBoom),
							"TRT", 
							"RTR", 
							"TRT", 
							'R', radioactivePowder,
							'T', Blocks.tnt);
				
				//Magic
					/*GameRegistry.addRecipe(new ItemStack(magicBoom),
							"BGB", 
							"GTG", 
							"BGB", 
							'C', Items.blaze_powder,
							'T', Blocks.tnt,
							'G', Items.ghast_tear);*/  //TODO: ADD RECIPE HERE
					
				
				
				
				
					
					
		//GUIHandlers
					
				//GuideBook
					
					NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
					
					
		//Event
					
			//Bus
					
				//BoomSpawn
					MinecraftForge.EVENT_BUS.register(new BoomSpawn());
					
				//BoomCraftEvent
					FMLCommonHandler.instance().bus().register(new BoomCraftEvent());
	}

	
	
	public void replaceCraftingItem(ItemStack itemStack, Item itemCraftingToReplace, Object... addition)
	{
		
	}
	
	public void replaceCraftingBlock(ItemStack itemStack, Block blockCraftingToReplace, Object... addition)
	{
		
	}
	
	//Gui Handler
	public static class GuiHandler implements IGuiHandler {
		@Override
		public Object getServerGuiElement(int id, EntityPlayer player,
				World world, int x, int y, int z) {
			if (id == GuiWelcomeGui.GUIID)
				return new GuiWelcomeGui.GuiContainerMod(player);
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player,
				World world, int x, int y, int z) {
			if (id == GuiWelcomeGui.GUIID)
				return new GuiWelcomeGui.GuiWindow(world, x, y, z, player);
			return null;
		}
	}
}
