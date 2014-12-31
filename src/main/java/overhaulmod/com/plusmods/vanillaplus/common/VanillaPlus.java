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

import com.plusmods.oresplus.creativeTabs.OresPlusItemsTab;
import com.plusmods.oresplus.items.ItemRuby;
import com.plusmods.vanillaplus.blocks.InfusedOre;
import com.plusmods.vanillaplus.creativeTab.VanillaPlusTab;
import com.plusmods.vanillaplus.items.ItemInfusedDust;

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
	
	//Items
	public static Item infusedDust;

	// @SidedProxy(clientSide = "com.plusmods.boomplus.ClientProxyBoomPlus",
	// serverSide = "com.plusmods.boomplus.CommonProxyBoomPlus")

	@Instance(MODID)
	public static VanillaPlus instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("VanillaPlus Initialized");
		//Register Blocks
		infusedOre = new InfusedOre(Material.iron).setBlockName("InfusedOre").setHardness(2.0f).setCreativeTab(VanillaPlusTab.tab).setBlockTextureName("vanillaplus:infused_ore");
		infusedOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		infusedOre.setHarvestLevel("pickaxe", 2);
		
		//Register Items
		infusedDust = new ItemInfusedDust(5000).setUnlocalizedName("InfusedDust").setCreativeTab(VanillaPlusTab.tab).setTextureName("vanillaplus:infused_dust");
		System.out.println("Blocks Loaded");
		}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		//GameRegister Items
		GameRegistry.registerItem(infusedDust, "InfusedDust");
		//GameRegister Blocks
		GameRegistry.registerBlock(infusedOre, "InfusedOre");
		System.out.println("Blocks Registered");
	}

	public void replaceCraftingItem(ItemStack itemStack,
			Item itemCraftingToReplace, Object... addition) {

	}

	public void replaceCraftingBlock(ItemStack itemStack,
			Block blockCraftingToReplace, Object... addition) {

	}

}
