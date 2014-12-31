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

import com.plusmods.boomplus.acheivement.AchievementNuclear;
import com.plusmods.boomplus.acheivement.AchievementOreIsIt;
import com.plusmods.boomplus.blocks.BlockBlazeOre;
import com.plusmods.boomplus.blocks.BlockCrashyBoom;
import com.plusmods.boomplus.blocks.BlockEnderBoom;
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
			
	
	
	
	
	
	
	

	//@SidedProxy(clientSide = "com.plusmods.boomplus.ClientProxyBoomPlus", serverSide = "com.plusmods.boomplus.CommonProxyBoomPlus")

	@Instance(MODID)
	public static BoomPlus instance;

	@EventHandler
	public void load(FMLInitializationEvent event) 
	{
		//Items
			//BoomJacket
				boomJacket = new ItemBoomJacket(ArmorMaterial.CLOTH, 0, 0).setUnlocalizedName("BoomJacket").setTextureName("boomplus:boom_jacket");
				
			//RadioactivePower
				radioactivePowder = new ItemRadioactivePowder(0).setUnlocalizedName("RadioactivePowder").setTextureName("boomplus:radioactive_powder");
			
			//Detonator
				detonator = new ItemDetonator(2013).setUnlocalizedName("Detonator").setTextureName("boomplus:detonator");
			
			//GuideBook
				guideBook = new ItemGuideBook(1).setUnlocalizedName("GuideBook").setTextureName("boomplus:guide_book");
			
			//CoolGlasses
				coolGlasses = new ItemCoolGlasses(ArmorMaterial.CLOTH, 0, 0).setUnlocalizedName("CoolGlasses").setTextureName("boomplus:cool_glasses");
			
			//StrangeSymbol
				strangeSymbol = new ItemStrangeSymbol(ToolMaterial.EMERALD).setUnlocalizedName("StrangeSymbol").setTextureName("boomplus:strangeSymbol");
		
			//SneakyBoomEdible
				sneakyBoomEdible = new ItemSneakyBoomEdible(2, 1.0f, true).setUnlocalizedName("SneakyBoomEdible").setTextureName("boomplus:sneaky_boom_edible");
				
			//CrashyBoom
			    crashyBoom = new BlockCrashyBoom(Material.tnt).setBlockName("CrashyBoom").setHardness(1.0f).setCreativeTab(BoomPlusTab.tab).setBlockTextureName("boomplus:radioactive_boom");
			
		//Blocks
				
			//Ores
				
				//BlazeOre
					Block blazeOre = new BlockBlazeOre().setBlockName("BlazeOre").setBlockTextureName("boomplus:blaze_ore");
					
				//RadioactiveOre
					Block radioactiveOre = new BlockRadioactiveOre().setBlockName("RadioactiveOre").setBlockTextureName("boomplus:radioactive_ore");
				
		//Booms
		GameRegistry.registerBlock(crashyBoom, crashyBoom.getUnlocalizedName().substring(5));	
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}

	
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		//Tile Entities
		GameRegistry.registerTileEntity(TileEntityChestValues.class, "isArmed");
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
