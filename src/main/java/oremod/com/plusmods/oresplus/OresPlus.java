package com.plusmods.oresplus;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = OresPlus.MODID, version = OresPlus.VERSION)
public class OresPlus {

	public static final String MODID = "OresPlus";
    public static final String VERSION = "1.1.0";

	//@SidedProxy(clientSide="com.plusmods.oresplus.ClientProxy", serverSide="com.plusmods.oresplus.CommonProxy")
    //@SidedProxy(clientSide="mod.mcreator.ClientProxyTestEnvironmentMod", serverSide="mod.mcreator.CommonProxyTestEnvironmentMod")
    public static CommonProxy proxy;
    //public static EnumMap<Side, FMLEmbeddedChannel> channels = NetworkRegistry.INSTANCE.newChannel("MCRBUS", new ChannelHandlerTestEnvironmentMod());

	@Instance(value = "oresplus")
    public static OresPlus instance;
	
	
	//Blocks
		public static Block jadeStone;
		public static Block theisOre;
		public static Block rubyOre;

	
	//Items
		public static Item jade;
		public static Item theisIngot;
		public static Item ruby;
		
	//Tools
		public static Item jadePickaxe;
		public static Item rubyPickaxe;


	public void serverLoad(FMLServerStartingEvent event) 
	{
		
	}
	
	@EventHandler
	public void load(FMLPreInitializationEvent event) 
	{
			//Jade
				jade = new ItemJade(5000).setCreativeTab(OresPlusTab.tab).setUnlocalizedName("Jade").setTextureName("oresplus:jade");
				
				
			//JadeStone
				jadeStone = new BlockJadeStone(5001).setBlockName("JadeStone").setHardness(2.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:jade_ore");
				jadeStone.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				jadeStone.setHarvestLevel("pickaxe", 2);
				
			//JadePickaxe
				jadePickaxe = new ItemJadePickaxe(ToolMaterials.jadeMaterial).setCreativeTab(OresPlusTab.tab).setUnlocalizedName("JadePickaxe").setTextureName("oresplus:jade_pickaxe");
			
			//TheisIngot
				theisIngot = new TheisIngot(5002).setUnlocalizedName("TheisIngot").setCreativeTab(OresPlusTab.tab).setTextureName("oresplus:theis_ingot");
			
			
			//TheisOre
				theisOre = new TheisOre(Material.iron).setBlockName("TheisOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:theis_ore");
				theisOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				theisOre.setHarvestLevel("pickaxe", 2);
				
			//RubyOre
				rubyOre = new RubyOre(Material.iron).setBlockName("RubyOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:ruby_ore");
				rubyOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				rubyOre.setHarvestLevel("pickaxe", 2);
				
			//Ruby
				ruby = new ItemRuby(5003).setUnlocalizedName("Ruby").setCreativeTab(OresPlusTab.tab).setTextureName("oresplus:ruby");
				
			//RubyPickaxe
				rubyPickaxe = new ItemRubyPickaxe(ToolMaterials.rubyMaterial).setCreativeTab(OresPlusTab.tab).setUnlocalizedName("RubyPickaxe").setTextureName("oresplus:ruby_pickaxe");
	
	}
	
	@EventHandler
	public void init(FMLPreInitializationEvent event) 
	{
		
		
		//Register everything
			//Block
				GameRegistry.registerBlock(jadeStone, "JadeStone");
				GameRegistry.registerBlock(theisOre, "TheisOre");
				GameRegistry.registerBlock(rubyOre, "RubyOre");
		
			//Item
				GameRegistry.registerItem(jade, "Jade");
				GameRegistry.registerItem(theisIngot, "TheisIngot");
				GameRegistry.registerItem(jadePickaxe, "JadePickaxe");
				GameRegistry.registerItem(rubyPickaxe, "RubyPickaxe");
				GameRegistry.registerItem(ruby, "Ruby");
				
			//Crafting Recipe
				//JadePickaxe
					GameRegistry.addRecipe(new ItemStack(jadePickaxe), "XXX", " I ", " I ", 
							'X', new ItemStack(jade),
							'I', new ItemStack(Items.stick));
				//RubyPickaxe
					GameRegistry.addRecipe(new ItemStack(rubyPickaxe), "XXX", " I ", " I ",
							'X', new ItemStack(ruby),
							'I', new ItemStack(Items.stick));
				
				
			//IWorldGenerator		
				GameRegistry.registerWorldGenerator(new JadeOreGenerator(), 3);
				GameRegistry.registerWorldGenerator(new TheisOreGen(), 6);
				GameRegistry.registerWorldGenerator(new RubyOreGen(), 3);
				
			//Smeling Recipe
				GameRegistry.addSmelting(theisOre, new ItemStack(theisIngot, 2), 10.0f);
	}
}