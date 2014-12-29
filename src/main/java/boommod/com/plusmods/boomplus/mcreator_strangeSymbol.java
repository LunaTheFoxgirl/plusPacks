package com.plusmods.boomplus;//based on master condiguration

import cpw.mods.fml.client.*;
import cpw.mods.fml.client.registry.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.asm.*;
import cpw.mods.fml.common.asm.transformers.*;
import cpw.mods.fml.common.discovery.*;
import cpw.mods.fml.common.discovery.asm.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.functions.*;
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
public class mcreator_strangeSymbol {

	public mcreator_strangeSymbol() {
	}

	public static Item block;
	public static Object instance;

	public void load() {
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

	
	public static final Item.ToolMaterial symbol = EnumHelper.addToolMaterial("symbolMaterial", 12, 2000, 6, 120000000000000000.0f, 0);
	
	static {
		block = (new ItemstrangeSymbol(symbol));
		Item.itemRegistry.addObject(424, "StrangeSymbol", block);

	}

	static class ItemstrangeSymbol extends ItemSword {

		
		
		
		/*public ItemstrangeSymbol(int par1) {
			setMaxDamage(0);
			maxStackSize = 1;
			setUnlocalizedName("StrangeSymbol");
			setTextureName("boomplus:oreisit");
			setCreativeTab(mcreator_boomPlusTab.tab);
		}*/

		public ItemstrangeSymbol(ToolMaterial p_i45356_1_) {
			super(p_i45356_1_);
			// TODO Auto-generated constructor stub
			setMaxDamage(0);
			maxStackSize = 1;
			setUnlocalizedName("StrangeSymbol");
			setTextureName("boomplus:oreisit");
			setCreativeTab(mcreator_boomPlusTab.tab);
		}

		public int getItemEnchantability() {
			return 0;
		}

		public int getMaxItemUseDuration(ItemStack par1ItemStack) {
			return 0;
		}
		
		
		

		@Override
		public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
			/*if (world.isRemote)
				((EntityClientPlayerMP) player).sendChatMessage("Whoops! my bad.");
			if (!world.isRemote)
				((EntityPlayer) player).inventory.consumeInventoryItem(mcreator_strangeSymbol.block);*/
			
			return super.onItemUse(p_77648_1_, player, world, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
		}

		@Override
		public ItemStack onItemRightClick(ItemStack p_77659_1_,
				World world, EntityPlayer player) {
			if (world.isRemote)
				((EntityClientPlayerMP) player).sendChatMessage("Whoops! my bad.");
			if (!world.isRemote)
				((EntityPlayer) player).inventory.consumeInventoryItem(mcreator_strangeSymbol.block);
			// TODO Auto-generated method stub
			return super.onItemRightClick(p_77659_1_, world, player);
		}

		public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
			return 1.0F;
		}

	}
}
