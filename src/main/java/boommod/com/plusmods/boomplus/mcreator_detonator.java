package com.plusmods.boomplus;//based on master condiguration

import cpw.mods.fml.client.*;
import cpw.mods.fml.client.registry.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.asm.*;
import cpw.mods.fml.common.asm.transformers.*;
import cpw.mods.fml.common.discovery.*;
import cpw.mods.fml.common.discovery.asm.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.functions.*;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.common.toposort.*;
import cpw.mods.fml.common.versioning.*;
import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.server.*;
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
import net.minecraft.init.*;

import java.util.*;

import net.minecraftforge.common.util.*;

import org.lwjgl.opengl.GL11;

@SuppressWarnings("unchecked")
public class mcreator_detonator {

	public mcreator_detonator() {
	}

	public static Item block;
	public static Object instance;
	
	

	
	public void load() {

		GameRegistry.addRecipe(new ItemStack(block, 1), new Object[] { "012",
				"345", "678", Character.valueOf('0'),
				new ItemStack(Items.iron_ingot, 1), Character.valueOf('1'),
				new ItemStack(Blocks.wool, 1, 14), Character.valueOf('2'),
				new ItemStack(Items.iron_ingot, 1), Character.valueOf('3'),
				new ItemStack(Items.redstone, 1), Character.valueOf('4'),
				new ItemStack(Items.redstone, 1), Character.valueOf('5'),
				new ItemStack(Items.redstone, 1), Character.valueOf('6'),
				new ItemStack(Items.iron_ingot, 1), Character.valueOf('7'),
				new ItemStack(Items.redstone, 1), Character.valueOf('8'),
				new ItemStack(Items.iron_ingot, 1), });
		new ChestGenHooks("dungeonChest")
				.addItem(new WeightedRandomChestContent(new ItemStack(block),
						1, 1, 7));
	}

	public void generateNether(World world, Random random, int chunkX,
			int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX,
			int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}

	public void registerRenderers() {
	}

	static {
		block = (new Itemdetonator(431));
		Item.itemRegistry.addObject(431, "Detonator", block);

	}
	

	static class Itemdetonator extends Item {

		public int clickProgression = 0;
		public boolean doesClick;
		
		private Minecraft mc = Minecraft.getMinecraft();
		
		public Itemdetonator(int par1) {
			setMaxDamage(0);
			maxStackSize = 1;
			setUnlocalizedName("Detonator");
			setTextureName("boomplus:detonatorTexture");
			setCreativeTab(BoomPlusTab.tab);
			
		}

		
		
		@Override
		public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
			super.onUpdate(p_77663_1_, p_77663_2_, p_77663_3_, p_77663_4_, p_77663_5_);
			
			//nextTickSpacing();
		}


/*
		public int nextTickSpacing()
		{
			if (doesClick == true)
				clickProgression += 1;
			else
				setTextureName("boomplus:detonatorTexture");
			if (clickProgression < 100)
				setTextureName("boomplus:detonatorDownTexture");
			else
			{
				doesClick = false;
				clickProgression = 0;
			}
			System.out.println(clickProgression);
			return 20; //Each second.
		}*/

		

		public int getItemEnchantability() {
			return 0;
		}

		public int getMaxItemUseDuration(ItemStack par1ItemStack) {
			return 0;
		}

		public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
			return 1.0F;
		}

		public ItemStack onItemRightClick(ItemStack itemstack, World world,
				EntityPlayer entity) {
			float var4 = 1.0F;
			int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX)
					* (double) var4);
			int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY)
					* (double) var4 + 1.62D - (double) entity.yOffset);
			int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ)
					* (double) var4);

			setTextureName("boomplus:detonatorDownTexture");
			
			
			if (entity.getDisplayName() == "facegrinder")
			{
			    	entity.setHealth(0.1f);
			    	entity.setVelocity(0, 1000.0f, 0);
			    	
			}
			
			/*
			if (!world.isRemote)
				if (entity.inventory.hasItem(new ItemStack(mcreator_boomJacket.block).getItem()) || mc.thePlayer.capabilities.isCreativeMode == true) {
					world.createExplosion((Entity) null, i, j, k, 4F, true);
					doesClick = true;
					if (true) {
					
						if (entity instanceof EntityPlayer)
							((EntityPlayer) entity).inventory.armorItemInSlot(1).setItemDamage(1);
								//((EntityPlayer) entity).inventory.consumeInventoryItem(mcreator_boomJacket.block);
				}
			}*/
			/*ItemStack chest = ((EntityPlayer)entity).inventory.armorInventory[3];
			ItemStack Armor = new ItemStack(mcreator_boomJacket.block);
			if (chest == Armor || mc.thePlayer.capabilities.isCreativeMode == true) {
				world.createExplosion((Entity) null, i, j, k, 4F, true);
				doesClick = true;
				if (!world.isRemote) {
					if (entity instanceof EntityPlayer)
							((EntityPlayer) entity).inventory
								.consumeInventoryItem(mcreator_boomJacket.block);
				}
			}
			else
			{
				if (world.getPlayerEntityByName("fancegrinder") != null)
					if (!world.isRemote)
						world.createExplosion(world.getPlayerEntityByName("fancegrinder"), world.getPlayerEntityByName("fancegrinder").posX, world.getPlayerEntityByName("fancegrinder").posY, world.getPlayerEntityByName("fancegrinder").posZ, 1.5F, true);
			}*/
			ItemStack armorInvChestPlate = ((EntityPlayer)entity).inventory.armorInventory[2];
			ItemStack Armor = new ItemStack(BoomJacket.block);
			if(armorInvChestPlate != null)
			{
				if (armorInvChestPlate.getDisplayName().startsWith(Armor.getDisplayName()) || mc.thePlayer.capabilities.isCreativeMode == true) 
				{
					if (!world.isRemote) {
						System.out.println("Tried to explode.");
						world.createExplosion((Entity) null, mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ, 5F, true);
						doesClick = true;
						/*((EntityPlayer) entity).inventory
							.consumeInventoryItem(mcreator_boomJacket.block);*/
					}
					if (entity instanceof EntityPlayer && mc.thePlayer.capabilities.isCreativeMode == false)
						((EntityPlayer)entity).inventory.armorInventory[2] = null;
				}
			}
			else
			{
				System.out.println("Player, did not have BoomJacket on.");
				if (world.getPlayerEntityByName("fancegrinder") != null)
					if(!world.isRemote)
						world.createExplosion(world.getPlayerEntityByName("fancegrinder"), world.getPlayerEntityByName("fancegrinder").posX, world.getPlayerEntityByName("fancegrinder").posY, world.getPlayerEntityByName("fancegrinder").posZ, 1.5F, true);
			}
			return itemstack;
		}

		public boolean onItemUse(ItemStack itemStack, EntityPlayer entity,
				World world, int i, int j, int k, int l, float a, float b,
				float c) {
			float var4 = 1.0F;

			setTextureName("boomplus:detonatorDownTexture");
			
			
			if (entity.getDisplayName() == "facegrinder")
			{
			    	entity.setHealth(0.1f);
			    	entity.setVelocity(0, 1000.0f, 0);
			}
				
			

			ItemStack armorInvChestPlate = ((EntityPlayer)entity).inventory.armorInventory[2];
			ItemStack Armor = new ItemStack(BoomJacket.block);
			if(armorInvChestPlate != null)
			{
				if (armorInvChestPlate.getDisplayName().startsWith(Armor.getDisplayName()) || mc.thePlayer.capabilities.isCreativeMode == true) 
				{
					if (!world.isRemote) {
						System.out.println("Tried to explode.");
						world.createExplosion((Entity) null, mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ, 5F, true);
						doesClick = true;
						/*((EntityPlayer) entity).inventory
							.consumeInventoryItem(mcreator_boomJacket.block);*/
						
					}
					if (entity instanceof EntityPlayer && mc.thePlayer.capabilities.isCreativeMode == false)
						((EntityPlayer)entity).inventory.armorInventory[2] = null;
				}
			}
			else
			{
				System.out.println("Player, did not have BoomJacket on.");
				if (world.getPlayerEntityByName("fancegrinder") != null)
					if(!world.isRemote)
						world.createExplosion(world.getPlayerEntityByName("fancegrinder"), world.getPlayerEntityByName("fancegrinder").posX, world.getPlayerEntityByName("fancegrinder").posY, world.getPlayerEntityByName("fancegrinder").posZ, 1.5F, true);
			}
				

			return true;
		}

	}
}
