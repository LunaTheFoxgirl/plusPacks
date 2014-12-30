package com.plusmods.oresplus;

import java.util.Random;





import com.plusmods.boomplus.BoomPlus.GuiHandler;
import com.plusmods.boomplus.gui.GuiWelcomeGui;
import com.plusmods.oresplus.blocks.AmethystBlock;
import com.plusmods.oresplus.blocks.AmethystOre;
import com.plusmods.oresplus.blocks.BlockJadeStone;
import com.plusmods.oresplus.blocks.CitrineBlock;
import com.plusmods.oresplus.blocks.CitrineOre;
import com.plusmods.oresplus.blocks.JadeBlock;
import com.plusmods.oresplus.blocks.RubyBlock;
import com.plusmods.oresplus.blocks.RubyOre;
import com.plusmods.oresplus.blocks.SapphireBlock;
import com.plusmods.oresplus.blocks.SapphireOre;
import com.plusmods.oresplus.blocks.TheisOre;
import com.plusmods.oresplus.blocks.UraniumBlock;
import com.plusmods.oresplus.blocks.UraniumOre;
import com.plusmods.oresplus.creativeTabs.OresPlusItemsTab;
import com.plusmods.oresplus.creativeTabs.OresPlusTab;
import com.plusmods.oresplus.creativeTabs.OresPlusToolsTab;
import com.plusmods.oresplus.gui.GuiWelcomeGui;
import com.plusmods.oresplus.handles.CommonProxy;
import com.plusmods.oresplus.items.ItemAmethyst;
import com.plusmods.oresplus.items.ItemAmethystAxe;
import com.plusmods.oresplus.items.ItemAmethystPickaxe;
import com.plusmods.oresplus.items.ItemAmethystSpade;
import com.plusmods.oresplus.items.ItemAmethystSword;
import com.plusmods.oresplus.items.ItemCitrine;
import com.plusmods.oresplus.items.ItemCitrineAxe;
import com.plusmods.oresplus.items.ItemCitrinePickaxe;
import com.plusmods.oresplus.items.ItemCitrineSpade;
import com.plusmods.oresplus.items.ItemCitrineSword;
import com.plusmods.oresplus.items.ItemGuideBook;
import com.plusmods.oresplus.items.ItemJade;
import com.plusmods.oresplus.items.ItemJadeAxe;
import com.plusmods.oresplus.items.ItemJadePickaxe;
import com.plusmods.oresplus.items.ItemJadeSpade;
import com.plusmods.oresplus.items.ItemJadeSword;
import com.plusmods.oresplus.items.ItemMixedGem;
import com.plusmods.oresplus.items.ItemRuby;
import com.plusmods.oresplus.items.ItemRubyAxe;
import com.plusmods.oresplus.items.ItemRubyPickaxe;
import com.plusmods.oresplus.items.ItemRubySpade;
import com.plusmods.oresplus.items.ItemRubySword;
import com.plusmods.oresplus.items.ItemSapphire;
import com.plusmods.oresplus.items.ItemSapphireAxe;
import com.plusmods.oresplus.items.ItemSapphirePickaxe;
import com.plusmods.oresplus.items.ItemSapphireSpade;
import com.plusmods.oresplus.items.ItemSapphireSword;
import com.plusmods.oresplus.items.ItemUranium;
import com.plusmods.oresplus.items.TheisIngot;
import com.plusmods.oresplus.oreGen.UraniumOreGen;
import com.plusmods.oresplus.toolMaterials.ToolMaterials;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
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
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(modid = OresPlus.MODID, version = OresPlus.VERSION)
public class OresPlus {

	public static final String MODID = "OresPlus";
    public static final String VERSION = "1.2.0";



	//@SidedProxy(clientSide="com.plusmods.oresplus.ClientProxy", serverSide="com.plusmods.oresplus.CommonProxy")
    //@SidedProxy(clientSide="mod.mcreator.ClientProxyTestEnvironmentMod", serverSide="mod.mcreator.CommonProxyTestEnvironmentMod")
    public static CommonProxy proxy;
    //public static EnumMap<Side, FMLEmbeddedChannel> channels = NetworkRegistry.INSTANCE.newChannel("MCRBUS", new ChannelHandlerTestEnvironmentMod());

	@Instance(value = "oresplus")
    public static OresPlus instance;
	
	
	//Blocks
		public static Block blockJadeOre;
		public static Block blockRubyOre;
		public static Block blockSapphireOre;
		public static Block blockAmethystOre;
		public static Block blockCitrineOre;
		public static Block blockUraniumOre;
		public static Block blockJadeBlock;
		public static Block blockRubyBlock;
		public static Block blockSapphireBlock;
		public static Block blockUraniumBlock;
		public static Block blockCitrineBlock;
		public static Block blockAmethystBlock;
	
	//Items
		public static Item itemJade;
		public static Item itemRuby;
		public static Item itemSapphire;
		public static Item itemAmethyst;		
		public static Item itemCitrine;
		public static Item itemUranium;
		public static Item itemMixedGem;
		
	//Tools
		public static Item itemJadePickaxe;
		public static Item itemJadeSpade;
		public static Item itemJadeAxe;
		public static Item itemJadeSword;
		public static Item itemRubyPickaxe;
		public static Item itemRubySpade;
		public static Item itemRubyAxe;
		public static Item itemRubySword;
		public static Item itemSapphirePickaxe;
		public static Item itemSapphireSpade;
		public static Item itemSapphireAxe;
		public static Item itemSapphireSword;
		public static Item itemCitrinePickaxe;
		public static Item itemCitrineSpade;
		public static Item itemCitrineAxe;
		public static Item itemCitrineSword;
		public static Item itemAmethystPickaxe;		
		public static Item itemAmethystSpade;
		public static Item itemAmethystAxe;
		public static Item itemAmethystSword;
		
		public static Item itemGuideBook;



		
	
	@EventHandler
	public void load(FMLPreInitializationEvent event) 
	{
						
				itemGuideBook = new ItemGuideBook(5000).setCreativeTab(OresPlusItemsTab.tab).setUnlocalizedName("GuideBook").setTextureName("oresplus:guideBook"); 
		
			//JadeStone
				blockJadeOre = new BlockJadeStone(Material.iron).setBlockName("JadeOre").setHardness(2.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:jade_ore");
				blockJadeOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				blockJadeOre.setHarvestLevel("pickaxe", 2);
				
			//RubyOre
				blockRubyOre = new RubyOre(Material.iron).setBlockName("RubyOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:ruby_ore");
				blockRubyOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				blockRubyOre.setHarvestLevel("pickaxe", 2);
				
			//SapphireOre
				blockSapphireOre = new SapphireOre(Material.iron).setBlockName("SapphireOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:sapphire_ore");
				blockSapphireOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				blockSapphireOre.setHarvestLevel("pickaxe", 2);
				
			//CitrineOre	
				blockCitrineOre = new CitrineOre(Material.iron).setBlockName("CitrineOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:citrine_ore");
				blockCitrineOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				blockCitrineOre.setHarvestLevel("pickaxe", 2);
			
			//AmethystOre
				blockAmethystOre = new AmethystOre(Material.iron).setBlockName("AmethystOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:amethyst_ore");
				blockAmethystOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				blockAmethystOre.setHarvestLevel("pickaxe", 2);
				
			//UraniumOre
				blockUraniumOre = new UraniumOre(Material.iron).setBlockName("UraniumOre").setLightLevel(10.0F).setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:uranium_ore");
				blockUraniumOre.setLightLevel(10.0F);
				
				
				
			//JadeBlock
				blockJadeBlock = new JadeBlock(Material.iron).setBlockName("JadeBlock").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:jade_block");
			
			//RubyBlock
				blockRubyBlock = new RubyBlock(Material.iron).setBlockName("RubyBlock").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:ruby_block");
				
			//SapphireBlock
				blockSapphireBlock = new SapphireBlock(Material.iron).setBlockName("SapphireBlock").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:sapphire_block");
				
		    //CitrineBlock
		        blockCitrineBlock = new CitrineBlock(Material.iron).setBlockName("CitrineBlock").setCreativeTab(OresPlusTab.tab).setHardness(3.0f).setBlockTextureName("oresplus:citrine_block");
		        
		    //AmethystBlock
		        blockAmethystBlock = new AmethystBlock(Material.iron).setBlockName("AmethystBlock").setCreativeTab(OresPlusTab.tab).setHardness(3.0f).setBlockTextureName("oresplus:amethyst_block");
		    
		    //UraniumBlock
		        blockUraniumBlock = new UraniumBlock(Material.iron).setBlockName("UraniumBlock").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:uranium_block");
		        
				
				
			//Jade
				itemJade = new ItemJade(5000).setCreativeTab(OresPlusItemsTab.tab).setUnlocalizedName("Jade").setTextureName("oresplus:jade");
				
			//Ruby
				itemRuby = new ItemRuby(5003).setUnlocalizedName("Ruby").setCreativeTab(OresPlusItemsTab.tab).setTextureName("oresplus:ruby");
				
			//Sapphire
				itemSapphire = new ItemSapphire(5004).setUnlocalizedName("Sapphire").setCreativeTab(OresPlusItemsTab.tab).setTextureName("oresplus:sapphire");
				
			//Citrine
				itemCitrine = new ItemCitrine(5006).setUnlocalizedName("Citrine").setCreativeTab(OresPlusItemsTab.tab).setTextureName("oresplus:citrine");		
									
			//Amethyst
				itemAmethyst = new ItemAmethyst(5004).setUnlocalizedName("Amethyst").setCreativeTab(OresPlusItemsTab.tab).setTextureName("oresplus:amethyst");
				
				
			//MixedGem
				itemMixedGem = new ItemMixedGem(6000).setCreativeTab(OresPlusItemsTab.tab).setUnlocalizedName("MixedGem").setTextureName("oresplus:jade");
	
			//Uranium
		        itemUranium = new ItemUranium(5005).setUnlocalizedName("Uranium").setCreativeTab(OresPlusItemsTab.tab).setTextureName("oresplus:uranium");
		        
				
				
				
			//JadePickaxe
				itemJadePickaxe = new ItemJadePickaxe(ToolMaterials.jadeMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("JadePickaxe").setTextureName("oresplus:jade_pickaxe");				
				
			//RubyPickaxe
				itemRubyPickaxe = new ItemRubyPickaxe(ToolMaterials.rubyMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("RubyPickaxe").setTextureName("oresplus:ruby_pickaxe");
				
			//SapphirePickaxe
				itemSapphirePickaxe = new ItemSapphirePickaxe(ToolMaterials.sapphireMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("SapphirePickaxe").setTextureName("oresplus:sapphire_pickaxe");
				
			//CitrinePickaxe
				itemCitrinePickaxe = new ItemCitrinePickaxe(ToolMaterials.citrineMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("CitrinePickaxe").setTextureName("oresplus:citrine_pickaxe");
			
			//AmethystPickaxe
				itemAmethystPickaxe = new ItemAmethystPickaxe(ToolMaterials.amethystMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("AmethystPickaxe").setTextureName("oresplus:amethyst_pickaxe");
				
			
				
			//JadeSpade
				itemJadeSpade = new ItemJadeSpade(ToolMaterials.jadeMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("JadeSpade").setTextureName("oresplus:jade_shovel");
				
			//RubySpade
				itemRubySpade = new ItemRubySpade(ToolMaterials.rubyMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("RubySpade").setTextureName("oresplus:ruby_shovel");
				
			//SapphireSpade
				itemSapphireSpade = new ItemSapphireSpade(ToolMaterials.sapphireMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("SapphireSpade").setTextureName("oresplus:sapphire_shovel");
				
			//CitrineSpade
				itemCitrineSpade = new ItemCitrineSpade(ToolMaterials.citrineMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("CitrineSpade").setTextureName("oresplus:citrine_shovel");
				
			//AmethystSpade
				itemAmethystSpade = new ItemAmethystSpade(ToolMaterials.amethystMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("AmethystSpade").setTextureName("oresplus:amethyst_shovel");	
				
				
				
			//JadeAxe
				itemJadeAxe = new ItemJadeAxe(ToolMaterials.jadeMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("JadeAxe").setTextureName("oresplus:jade_axe");
				
			//RubyAxe
				itemRubyAxe = new ItemRubyAxe(ToolMaterials.rubyMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("RubyAxe").setTextureName("oresplus:ruby_axe");
				
			//SapphireAxe
				itemSapphireAxe = new ItemSapphireAxe(ToolMaterials.sapphireMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("SapphireAxe").setTextureName("oresplus:sapphire_axe");
				
			//CitrineAxe
				itemCitrineAxe = new ItemCitrineAxe(ToolMaterials.citrineMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("CitrineAxe").setTextureName("oresplus:citrine_axe");
				
			//AmethystAxe
				itemAmethystAxe = new ItemAmethystAxe(ToolMaterials.amethystMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("AmethystAxe").setTextureName("oresplus:amethyst_axe");
				
				
				
			//JadeAxe
				itemJadeSword = new ItemJadeAxe(ToolMaterials.jadeMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("JadeAxe").setTextureName("oresplus:jade_axe");
				
			//RubyAxe
				itemRubySword = new ItemRubyAxe(ToolMaterials.rubyMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("RubyAxe").setTextureName("oresplus:ruby_axe");
				
			//SapphireAxe
				itemSapphireSword = new ItemSapphireAxe(ToolMaterials.sapphireMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("SapphireAxe").setTextureName("oresplus:sapphire_axe");
				
			//CitrineSword
				itemCitrineSword = new ItemCitrineSword(ToolMaterials.citrineMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("CitrineAxe").setTextureName("oresplus:citrine_axe");
				
			//AmethystSword
				itemAmethystSword = new ItemAmethystSword(ToolMaterials.amethystMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("AmethystAxe").setTextureName("oresplus:amethyst_axe");
				
				
				
			//JadeSword
				itemJadeSword = new ItemJadeSword(ToolMaterials.jadeMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("JadeSword").setTextureName("oresplus:jade_sword");
				
			//RubySword
				itemRubySword = new ItemRubySword(ToolMaterials.rubyMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("RubySword").setTextureName("oresplus:ruby_sword");
				
			//SapphireSword
				itemSapphireSword = new ItemSapphireSword(ToolMaterials.sapphireMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("SapphireSword").setTextureName("oresplus:sapphire_sword");
				
			//CitrineSword
				itemCitrineSword = new ItemCitrineSword(ToolMaterials.citrineMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("CitrineSword").setTextureName("oresplus:citrine_sword");
				
			//AmethystSword
				itemAmethystSword = new ItemAmethystSword(ToolMaterials.amethystMaterial).setCreativeTab(OresPlusToolsTab.tab).setUnlocalizedName("AmethystSword").setTextureName("oresplus:amethyst_sword");
				
				
					
				
				
				
			
			
			
	
	
	
	}
	
	@EventHandler
	public void init(FMLPreInitializationEvent event) 
	{
		
		
		//Register everything
			//Block
				GameRegistry.registerBlock(blockJadeOre, blockJadeOre.getUnlocalizedName().substring(5));
				GameRegistry.registerBlock(blockRubyOre, blockRubyOre.getUnlocalizedName().substring(5));
				GameRegistry.registerBlock(blockSapphireOre, blockSapphireOre.getUnlocalizedName().substring(5));
				GameRegistry.registerBlock(blockAmethystOre, blockAmethystOre.getUnlocalizedName().substring(5));
				GameRegistry.registerBlock(blockCitrineOre, blockCitrineOre.getUnlocalizedName().substring(5));
				GameRegistry.registerBlock(blockUraniumOre, blockUraniumOre.getUnlocalizedName().substring(5));
				GameRegistry.registerBlock(blockJadeBlock, blockJadeBlock.getUnlocalizedName().substring(5));
				GameRegistry.registerBlock(blockRubyBlock, blockRubyBlock.getUnlocalizedName().substring(5));
				GameRegistry.registerBlock(blockSapphireBlock, blockSapphireBlock.getUnlocalizedName().substring(5));		
				GameRegistry.registerBlock(blockUraniumBlock, blockUraniumBlock.getUnlocalizedName().substring(5));
				GameRegistry.registerBlock(blockCitrineBlock, blockCitrineBlock.getUnlocalizedName().substring(5));
				GameRegistry.registerBlock(blockAmethystBlock, blockAmethystBlock.getUnlocalizedName().substring(5));
				
			//Item
				GameRegistry.registerItem(itemJade, itemJade.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemJadePickaxe, itemJadePickaxe.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemJadeSpade, itemJadeSpade.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemJadeAxe, itemJadeAxe.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemJadeSword, itemJadeSword.getUnlocalizedName().substring(5));			
				GameRegistry.registerItem(itemRuby, itemRuby.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemRubyPickaxe, itemRubyPickaxe.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemRubySpade, itemRubySpade.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemRubyAxe, itemRubyAxe.getUnlocalizedName().substring(5));;
				GameRegistry.registerItem(itemRubySword, itemRubySword.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemAmethyst, itemAmethyst.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemAmethystPickaxe, itemAmethystPickaxe.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemAmethystSpade, itemAmethystSpade.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemAmethystAxe, itemAmethystAxe.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemAmethystSword, itemAmethystSword.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemCitrine, itemCitrine.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemCitrinePickaxe, itemCitrinePickaxe.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemCitrineSpade, itemCitrineSpade.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemCitrineAxe, itemCitrineAxe.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemCitrineSword, itemCitrineSword.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemSapphire, itemSapphire.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemSapphirePickaxe, itemSapphirePickaxe.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemSapphireSpade, itemSapphireSpade.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemSapphireAxe, itemSapphireAxe.getUnlocalizedName().substring(5));
				GameRegistry.registerItem(itemSapphireSword, itemSapphireSword.getUnlocalizedName().substring(5));
				
				GameRegistry.registerItem(itemGuideBook, "ItemGuideBook");			
				GameRegistry.registerItem(itemMixedGem, "MixedGem");
				GameRegistry.registerItem(itemUranium, "Uranium");
				
			//Crafting Recipe
				//JadePickaxe
					GameRegistry.addRecipe(new ItemStack(itemJadePickaxe), "XXX", " I ", " I ", 
							'X', new ItemStack(itemJade),
							'I', new ItemStack(Items.stick));
				//RubyPickaxe
					GameRegistry.addRecipe(new ItemStack(itemRubyPickaxe), "XXX", " I ", " I ",
							'X', new ItemStack(itemRuby),
							'I', new ItemStack(Items.stick));
				//SapphirePickaxe
					GameRegistry.addRecipe(new ItemStack(itemSapphirePickaxe), "XXX", " I ", " I ",
							'X', new ItemStack(itemSapphire),
							'I', new ItemStack(Items.stick));
				//CitrinePickaxe
					GameRegistry.addRecipe(new ItemStack(itemCitrinePickaxe), "XXX", " I ", " I ",
							'X', new ItemStack(itemCitrine),
							'I', new ItemStack(Items.stick));
				//AmethystPickaxe
					GameRegistry.addRecipe(new ItemStack(itemAmethystPickaxe), "XXX", " I ", " I ",
							'X', new ItemStack(itemAmethyst),
							'I', new ItemStack(Items.stick));
					
				//JadeShovel
					GameRegistry.addRecipe(new ItemStack(itemJadeSpade), " X ", " I ", " I ", 
							'X', new ItemStack(itemJade),
							'I', new ItemStack(Items.stick));
				//RubyShovel
					GameRegistry.addRecipe(new ItemStack(itemRubySpade), " X ", " I ", " I ",
							'X', new ItemStack(itemRuby),
							'I', new ItemStack(Items.stick));
				//SapphireShovel
					GameRegistry.addRecipe(new ItemStack(itemSapphireSpade), " X ", " I ", " I ",
							'X', new ItemStack(itemSapphire),
							'I', new ItemStack(Items.stick));
				//CitrineShovel
					GameRegistry.addRecipe(new ItemStack(itemCitrineSpade), " X ", " I ", " I ",
							'X', new ItemStack(itemCitrine),
							'I', new ItemStack(Items.stick));
				//AmethystShovel
					GameRegistry.addRecipe(new ItemStack(itemAmethystSpade), " X ", " I ", " I ",
							'X', new ItemStack(itemAmethyst),
							'I', new ItemStack(Items.stick));
					
				//JadeAxe
					GameRegistry.addRecipe(new ItemStack(itemJadeAxe), "XX ", "XI ", " I ", 
							'X', new ItemStack(itemJade),
							'I', new ItemStack(Items.stick));
				//RubyAxe
					GameRegistry.addRecipe(new ItemStack(itemRubyAxe), "XX ", "XI ", " I ",
							'X', new ItemStack(itemRuby),
							'I', new ItemStack(Items.stick));
				//SapphireAxe
					GameRegistry.addRecipe(new ItemStack(itemSapphireAxe), "XX ", "XI ", " I ",
							'X', new ItemStack(itemSapphire),
							'I', new ItemStack(Items.stick));
				//CitrineAxe
					GameRegistry.addRecipe(new ItemStack(itemCitrineAxe), "XX ", "XI ", " I ",
							'X', new ItemStack(itemCitrine),
							'I', new ItemStack(Items.stick));
				//AmethystAxe
					GameRegistry.addRecipe(new ItemStack(itemAmethystAxe), "XX ", "XI ", " I ",
							'X', new ItemStack(itemAmethyst),
							'I', new ItemStack(Items.stick));
					
					
				//JadeSword
					GameRegistry.addRecipe(new ItemStack(itemJadeSword), " X ", " X ", " I ", 
							'X', new ItemStack(itemJade),
							'I', new ItemStack(Items.stick));
				//RubySword
					GameRegistry.addRecipe(new ItemStack(itemRubySword), " X ", " X ", " I ",
							'X', new ItemStack(itemRuby),
							'I', new ItemStack(Items.stick));
				//SapphireSword
					GameRegistry.addRecipe(new ItemStack(itemSapphireSword), " X ", " X ", " I ",
							'X', new ItemStack(itemSapphire),
							'I', new ItemStack(Items.stick));
				//CitrineSword
					GameRegistry.addRecipe(new ItemStack(itemCitrineSpade), " X ", " X ", " I ",
							'X', new ItemStack(itemCitrine),
							'I', new ItemStack(Items.stick));
				//AmethystSword
					GameRegistry.addRecipe(new ItemStack(itemAmethystSpade), " X ", " X ", " I ",
							'X', new ItemStack(itemAmethyst),
							'I', new ItemStack(Items.stick));
					
					
					
					
				//JadeBlock
					GameRegistry.addRecipe(new ItemStack(blockJadeBlock), "XXX", "XXX", "XXX",
							'X', new ItemStack(itemJade));
					
				//RubyBlock
					GameRegistry.addRecipe(new ItemStack(blockRubyBlock), "XXX", "XXX", "XXX",
							'X', new ItemStack(itemRuby));
					
				//SapphireBlock
					GameRegistry.addRecipe(new ItemStack(blockSapphireBlock), "XXX", "XXX", "XXX",
							'X', new ItemStack(itemSapphire));
				
				//UraniumBlock
					GameRegistry.addRecipe(new ItemStack(blockUraniumBlock), "XXX", "XXX", "XXX",
							'X', new ItemStack(itemUranium));
					
				//CitrineBlock
					GameRegistry.addRecipe(new ItemStack(blockCitrineBlock), "XXX", "XXX", "XXX",
							'X', new ItemStack(itemCitrine));
				
				//AmethystBlock
					GameRegistry.addRecipe(new ItemStack(blockAmethystBlock), "XXX", "XXX", "XXX",
							'X', new ItemStack(itemAmethyst));
			//IWorldGenerator		
				GameRegistry.registerWorldGenerator(new JadeOreGenerator(), 2);
				GameRegistry.registerWorldGenerator(new RubyOreGen(), 2);
				GameRegistry.registerWorldGenerator(new AmethystOreGen(), 2);
				GameRegistry.registerWorldGenerator(new CitrineOreGen(), 2);
				GameRegistry.registerWorldGenerator(new SapphireOreGen(), 2);
				GameRegistry.registerWorldGenerator(new UraniumOreGen(), 3);
				
			//Smelting Recipe
				
				
				
				
			//GUI
				NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}
	//Gui Handlers
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