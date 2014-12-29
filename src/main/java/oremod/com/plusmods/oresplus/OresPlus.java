package com.plusmods.oresplus;

import java.util.Random;

import com.plusmods.oresplus.blocks.AmethystOre;
import com.plusmods.oresplus.blocks.BlockJadeStone;
import com.plusmods.oresplus.blocks.CitrineOre;
import com.plusmods.oresplus.blocks.RubyOre;
import com.plusmods.oresplus.blocks.SapphireOre;
import com.plusmods.oresplus.blocks.TheisOre;
import com.plusmods.oresplus.blocks.UraniumOre;
import com.plusmods.oresplus.creativeTabs.OresPlusItemsTab;
import com.plusmods.oresplus.creativeTabs.OresPlusTab;
import com.plusmods.oresplus.creativeTabs.OresPlusToolsTab;
import com.plusmods.oresplus.handles.CommonProxy;
import com.plusmods.oresplus.items.ItemAmethyst;
import com.plusmods.oresplus.items.ItemCitrine;
import com.plusmods.oresplus.items.ItemJade;
import com.plusmods.oresplus.items.ItemJadePickaxe;
import com.plusmods.oresplus.items.ItemRuby;
import com.plusmods.oresplus.items.ItemRubyPickaxe;
import com.plusmods.oresplus.items.ItemSapphire;
import com.plusmods.oresplus.items.ItemSapphirePickaxe;
import com.plusmods.oresplus.items.TheisIngot;
import com.plusmods.oresplus.oreGen.UraniumOreGen;
import com.plusmods.oresplus.toolMaterials.ToolMaterials;

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
		public static Block sapphireOre;
		public static Block amethystOre;
		public static Block citrineOre;
		public static Block uraniumOre;
	
	//Items
		public static Item jade;
		public static Item theisIngot;
		public static Item ruby;
		public static Item sapphire;
		public static Item amethyst;		
		public static Item citrine;
		
		public static Item mixedGem;
		
	//Tools
		public static Item jadePickaxe;
		public static Item jadeSpade;
		public static Item rubyPickaxe;
		public static Item rubySpade;
		public static Item sapphirePickaxe;
		public static Item sapphireSpade;
		public static Item citrinePickaxe;
		public static Item citrineSpade;
		public static Item amethystPickaxe;
		public static Item amethystSpade;


	public void serverLoad(FMLServerStartingEvent event) 
	{
		
	}
	
	@EventHandler
	public void load(FMLPreInitializationEvent event) 
	{
								
			//JadeStone
				jadeStone = new BlockJadeStone(5001).setBlockName("JadeStone").setHardness(2.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:jade_ore");
				jadeStone.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				jadeStone.setHarvestLevel("pickaxe", 2);
				
				//Jade
				jade = new ItemJade(5000).setCreativeTab(OresPlusItemsTab.tab).setUnlocalizedName("Jade").setTextureName("oresplus:jade");
				
			//JadePickaxe
				jadePickaxe = new ItemJadePickaxe(ToolMaterials.jadeMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("JadePickaxe").setTextureName("oresplus:jade_pickaxe");
			
			//TheisIngot
				theisIngot = new TheisIngot(5002).setUnlocalizedName("TheisIngot").setCreativeTab(OresPlusItemsTab.tab).setTextureName("oresplus:theis_ingot");
			
			
			//TheisOre
				theisOre = new TheisOre(Material.iron).setBlockName("TheisOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:theis_ore");
				theisOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				theisOre.setHarvestLevel("pickaxe", 2);
				
			//RubyOre
				rubyOre = new RubyOre(Material.iron).setBlockName("RubyOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:ruby_ore");
				rubyOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				rubyOre.setHarvestLevel("pickaxe", 2);
			
			//Citrine
				citrine = new ItemCitrine(5006).setUnlocalizedName("Citrine").setCreativeTab(OresPlusItemsTab.tab).setTextureName("oresplus:citrine");		
				
			//CitrineOre	
				citrineOre = new CitrineOre(Material.iron).setBlockName("CitrineOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:citrine_ore");
				citrineOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				citrineOre.setHarvestLevel("pickaxe", 2);
				
			//Ruby
				ruby = new ItemRuby(5003).setUnlocalizedName("Ruby").setCreativeTab(OresPlusItemsTab.tab).setTextureName("oresplus:ruby");
				
			//RubyPickaxe
				rubyPickaxe = new ItemRubyPickaxe(ToolMaterials.rubyMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("RubyPickaxe").setTextureName("oresplus:ruby_pickaxe");
	
			//SapphireOre
				sapphireOre = new SapphireOre(Material.iron).setBlockName("SapphireOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:sapphire_ore");
				sapphireOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				sapphireOre.setHarvestLevel("pickaxe", 2);
				
			//Sapphire
				sapphire = new ItemSapphire(5004).setUnlocalizedName("Sapphire").setCreativeTab(OresPlusItemsTab.tab).setTextureName("oresplus:sapphire");
				

			//AmethystOre
				amethystOre = new AmethystOre(Material.iron).setBlockName("AmethystOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:amethyst_ore");
			
			//Amethyst
				amethyst = new ItemAmethyst(5004).setUnlocalizedName("Amethyst").setCreativeTab(OresPlusItemsTab.tab).setTextureName("oresplus:amethyst");
	
	
			//SapphirePickaxe
				sapphirePickaxe = new ItemSapphirePickaxe(ToolMaterials.sapphireMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("SapphirePickaxe").setTextureName("oresplus:sapphire_pickaxe");
				
			//CitrinePickaxe
				citrinePickaxe = new ItemCitrinePickaxe(ToolMaterials.citrineMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("CitrinePickaxe").setTextureName("oresplus:citrine_pickaxe");
			
			//AmethystPickaxe
				amethystPickaxe = new ItemAmethystPickaxe(ToolMaterials.amethystMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("AmethystPickaxe").setTextureName("oresplus:amethyst_pickaxe");
				
			
			//JadeSpade
				jadeSpade = new ItemJadeSpade(ToolMaterials.jadeMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("JadeSpade").setTextureName("oresplus:jade_shovel");
				
			//RubySpade
				rubySpade = new ItemRubySpade(ToolMaterials.rubyMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("RubySpade").setTextureName("oresplus:ruby_shovel");
				
			//SapphireSpade
				sapphireSpade = new ItemSapphireSpade(ToolMaterials.sapphireMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("SapphireSpade").setTextureName("oresplus:sapphire_shovel");
				
			//CitrineSpade
				citrineSpade = new ItemCitrineSpade(ToolMaterials.citrineMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("CitrineSpade").setTextureName("oresplus:citrine_shovel");
				
			//AmethystSpade
				amethystSpade = new ItemAmethystSpade(ToolMaterials.amethystMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("AmethystSpade").setTextureName("oresplus:amethyst_shovel");	
				
			//UraniumOre
				uraniumOre = new UraniumOre(Material.iron).setBlockName("UraniumOre").setLightLevel(10.0F).setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:uranium_ore");
				
			//MixedGem
				mixedGem = new ItemMixedGem(6000).setCreativeTab(OresPlusItemsTab.tab).setUnlocalizedName("MixedGem").setTextureName("oresplus:jade");
	
	}
	
	@EventHandler
	public void init(FMLPreInitializationEvent event) 
	{
		
		
		//Register everything
			//Block
				GameRegistry.registerBlock(jadeStone, "JadeStone");
				GameRegistry.registerBlock(theisOre, "TheisOre");
				GameRegistry.registerBlock(rubyOre, "RubyOre");
				GameRegistry.registerBlock(sapphireOre, "SapphireOre");
				GameRegistry.registerBlock(amethystOre, "AmethystOre");
				GameRegistry.registerBlock(citrineOre, "CitrineOre");
				GameRegistry.registerBlock(uraniumOre, "UraniumOre");
				
			//Item
				GameRegistry.registerItem(jade, "Jade");
				GameRegistry.registerItem(jadePickaxe, "JadePickaxe");
				GameRegistry.registerItem(jadeSpade, "JadeSpade");
				GameRegistry.registerItem(theisIngot, "TheisIngot");				
				GameRegistry.registerItem(ruby, "Ruby");
				GameRegistry.registerItem(rubyPickaxe, "RubyPickaxe");
				GameRegistry.registerItem(rubySpade, "RubySpade");
				GameRegistry.registerItem(amethyst, "Amethyst");
				GameRegistry.registerItem(amethystPickaxe, "AmethystPickaxe");
				GameRegistry.registerItem(amethystSpade, "AmethystSpade");
				GameRegistry.registerItem(citrine, "Citrine");
				GameRegistry.registerItem(citrinePickaxe, "CitrinePickaxe");
				GameRegistry.registerItem(citrineSpade, "CitrineSpade");
				GameRegistry.registerItem(sapphire, "Sapphire");
				GameRegistry.registerItem(sapphirePickaxe, "SapphirePickaxe");
				GameRegistry.registerItem(sapphireSpade, "SapphireSpade");
				
				GameRegistry.registerItem(mixedGem, "MixedGem");
				
			//Crafting Recipe
				//JadePickaxe
					GameRegistry.addRecipe(new ItemStack(jadePickaxe), "XXX", " I ", " I ", 
							'X', new ItemStack(jade),
							'I', new ItemStack(Items.stick));
				//RubyPickaxe
					GameRegistry.addRecipe(new ItemStack(rubyPickaxe), "XXX", " I ", " I ",
							'X', new ItemStack(ruby),
							'I', new ItemStack(Items.stick));
				//SapphirePickaxe
					GameRegistry.addRecipe(new ItemStack(sapphirePickaxe), "XXX", " I ", " I ",
							'X', new ItemStack(sapphire),
							'I', new ItemStack(Items.stick));
				//CitrinePickaxe
					GameRegistry.addRecipe(new ItemStack(citrinePickaxe), "XXX", " I ", " I ",
							'X', new ItemStack(citrine),
							'I', new ItemStack(Items.stick));
				//CitrinePickaxe
					GameRegistry.addRecipe(new ItemStack(amethystPickaxe), "XXX", " I ", " I ",
							'X', new ItemStack(amethyst),
							'I', new ItemStack(Items.stick));
					
				
				
			//IWorldGenerator		
				GameRegistry.registerWorldGenerator(new JadeOreGenerator(), 3);
				GameRegistry.registerWorldGenerator(new TheisOreGen(), 6);
				GameRegistry.registerWorldGenerator(new RubyOreGen(), 3);
				GameRegistry.registerWorldGenerator(new AmethystOreGen(), 2);
				GameRegistry.registerWorldGenerator(new CitrineOreGen(), 3);
				GameRegistry.registerWorldGenerator(new SapphireOreGen(), 3);
				GameRegistry.registerWorldGenerator(new UraniumOreGen(), 3);
				
			//Smelting Recipe
				GameRegistry.addSmelting(theisOre, new ItemStack(theisIngot, 2), 10.0f);
	}
}