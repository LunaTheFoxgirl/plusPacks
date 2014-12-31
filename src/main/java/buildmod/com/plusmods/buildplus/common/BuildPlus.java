package com.plusmods.buildplus.common;

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
import com.plusmods.buildplus.blocks.BlockStoneBrickBlue;
import com.plusmods.buildplus.blocks.BlockStoneBrickPurple;
import com.plusmods.buildplus.blocks.BlockStoneBrickRed;
import com.plusmods.buildplus.blocks.BlockStoneBrickYellow;
import com.plusmods.buildplus.creativeTab.BuildPlusTab;
import com.plusmods.oresplus.blocks.BlockJadeStone;
import com.plusmods.oresplus.creativeTabs.OresPlusTab;

import java.util.*;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import cpw.mods.fml.relauncher.*;

@Mod(modid = BuildPlus.MODID, version = BuildPlus.VERSION)
public class BuildPlus {

	// Mod id information
	public static final String MODID = "BuildPlus";
	public static final String VERSION = "1.0.0";

	// Blocks
	public static Block redStoneBrick;
	public static Block blueStoneBrick;
	public static Block yellowStoneBrick;
	public static Block purpleStoneBrick;

	// @SidedProxy(clientSide = "com.plusmods.boomplus.ClientProxyBoomPlus",
	// serverSide = "com.plusmods.boomplus.CommonProxyBoomPlus")

	@Instance(MODID)
	public static BuildPlus instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("BuildPlus Initialized");
		// Register Blocks
		// RedStoneBrick
		redStoneBrick = new BlockStoneBrickRed(Material.iron)
				.setBlockName("StoneBrickRed").setHardness(1.0f)
				.setCreativeTab(BuildPlusTab.tab)
				.setBlockTextureName("buildplus:stone_brick_red");
		redStoneBrick.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		redStoneBrick.setHarvestLevel("pickaxe", 1);
		
		// BlueStoneBrick
		blueStoneBrick = new BlockStoneBrickBlue(Material.iron)
				.setBlockName("StoneBrickBlue").setHardness(1.0f)
				.setCreativeTab(BuildPlusTab.tab)
				.setBlockTextureName("buildplus:stone_brick_blue");
		blueStoneBrick.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		blueStoneBrick.setHarvestLevel("pickaxe", 1);
		
		// YellowStoneBrick
		yellowStoneBrick = new BlockStoneBrickYellow(Material.iron)
				.setBlockName("StoneBrickYellow").setHardness(1.0f)
				.setCreativeTab(BuildPlusTab.tab)
				.setBlockTextureName("buildplus:stone_brick_yellow");
		yellowStoneBrick.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		yellowStoneBrick.setHarvestLevel("pickaxe", 1);
		
		// PurpleStoneBrick
		purpleStoneBrick = new BlockStoneBrickPurple(Material.iron)
				.setBlockName("StoneBrickPurple").setHardness(1.0f)
				.setCreativeTab(BuildPlusTab.tab)
				.setBlockTextureName("buildplus:stone_brick_purple");
		purpleStoneBrick.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		purpleStoneBrick.setHarvestLevel("pickaxe", 1);
		System.out.println("Blocks Loaded");
		}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		// Add Blocks here
		GameRegistry.registerBlock(redStoneBrick, "RedStoneBrick");
		GameRegistry.registerBlock(blueStoneBrick, "BlueStoneBrick");
		GameRegistry.registerBlock(yellowStoneBrick, "YellowStoneBrick");
		GameRegistry.registerBlock(purpleStoneBrick, "PurpleStoneBrick");
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		System.out.println("Blocks Registered");
	}

	public void replaceCraftingItem(ItemStack itemStack,
			Item itemCraftingToReplace, Object... addition) {

	}

	public void replaceCraftingBlock(ItemStack itemStack,
			Block blockCraftingToReplace, Object... addition) {

	}

	// Gui Handler
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
