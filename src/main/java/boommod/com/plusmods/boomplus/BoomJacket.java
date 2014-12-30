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
import net.minecraft.init.*;

import java.util.*;

import net.minecraftforge.common.util.*;

import org.lwjgl.opengl.GL11;

@SuppressWarnings("unchecked")
public class BoomJacket {

	public BoomJacket() {
	}

	public static Item block;
	public static Object instance;

	public void load() {

		GameRegistry.addRecipe(
				new ItemStack(block, 1),
				new Object[] { "012", "345", "678", Character.valueOf('0'),
						new ItemStack(Items.iron_ingot, 1),
						Character.valueOf('1'), new ItemStack(Blocks.tnt, 1),
						Character.valueOf('2'),
						new ItemStack(Items.iron_ingot, 1),
						Character.valueOf('3'), new ItemStack(Blocks.tnt, 1),
						Character.valueOf('4'),
						new ItemStack(Items.diamond_chestplate, 1),
						Character.valueOf('5'), new ItemStack(Blocks.tnt, 1),
						Character.valueOf('6'),
						new ItemStack(Items.iron_ingot, 1),
						Character.valueOf('7'), new ItemStack(Blocks.tnt, 1),
						Character.valueOf('8'),
						new ItemStack(Items.iron_ingot, 1), });
		new ChestGenHooks("dungeonChest")
				.addItem(new WeightedRandomChestContent(new ItemStack(block),
						1, 1, 5));
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
		block = (new ItemboomJacket(ArmorMaterial.CLOTH, 430, 1));
		Item.itemRegistry.addObject(430, "BoomJacket", block);

	}

	static class ItemboomJacket extends ItemArmor {

		public ItemboomJacket(ArmorMaterial armor, int par1, int par2)
		{
			super(armor, 1, par2);
			setMaxDamage(1);
			maxStackSize = 1;
			setUnlocalizedName("BoomJacket");
			setTextureName("boomplus:boomJackettexture");
			setCreativeTab(BoomPlusTab.tab);
		}

		
		
		
		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
		{
			return "boomplus:textures/armor/BoomJacket.png";
		}
		
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack par1ItemStack) {
			return 1;
		}

		public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
			return 1.0F;
		}

	}
}
