package com.plusmods.boomplus.items;//based on master condiguration

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

import com.plusmods.boomplus.BoomPlusTab;

@SuppressWarnings("unchecked")
public class ItemDetonator extends Item {

	private Minecraft mc = Minecraft.getMinecraft();

	public ItemDetonator(int par1) {
		setMaxDamage(0);
		maxStackSize = 1;
		setUnlocalizedName("Detonator");
		setTextureName("boomplus:detonatorTexture");
		setCreativeTab(BoomPlusTab.tab);

	}

	@Override
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_,
			Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
		super.onUpdate(p_77663_1_, p_77663_2_, p_77663_3_, p_77663_4_,
				p_77663_5_);

		// nextTickSpacing();
	}

	@Override
	public int getItemEnchantability() {
		return 0;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
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

		if (entity.getDisplayName() == "facegrinder") {
			entity.setHealth(0.1f);
			entity.setVelocity(0, 1000.0f, 0);

		}
		ItemStack armorInvChestPlate = ((EntityPlayer) entity).inventory.armorInventory[2];
		ItemStack Armor = new ItemStack(ItemBoomJacket);
		if (armorInvChestPlate != null) {
			if (armorInvChestPlate.getDisplayName().startsWith(
					Armor.getDisplayName())
					|| mc.thePlayer.capabilities.isCreativeMode == true) {
				if (!world.isRemote) {
					System.out.println("Tried to explode.");
					world.createExplosion((Entity) null, mc.thePlayer.posX,
							mc.thePlayer.posY, mc.thePlayer.posZ, 5F, true);
					/*
					 * ((EntityPlayer) entity).inventory
					 * .consumeInventoryItem(mcreator_boomJacket.block);
					 */
				}
				if (entity instanceof EntityPlayer
						&& mc.thePlayer.capabilities.isCreativeMode == false)
					((EntityPlayer) entity).inventory.armorInventory[2] = null;
			}
		} else {
			System.out.println("Player, did not have BoomJacket on.");
			if (world.getPlayerEntityByName("fancegrinder") != null)
				if (!world.isRemote)
					world.createExplosion(
							world.getPlayerEntityByName("fancegrinder"),
							world.getPlayerEntityByName("fancegrinder").posX,
							world.getPlayerEntityByName("fancegrinder").posY,
							world.getPlayerEntityByName("fancegrinder").posZ,
							1.5F, true);
		}
		return itemstack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entity,
			World world, int i, int j, int k, int l, float a, float b, float c) {
		float var4 = 1.0F;

		setTextureName("boomplus:detonatorDownTexture");

		if (entity.getDisplayName() == "facegrinder") {
			entity.setHealth(0.1f);
			entity.setVelocity(0, 1000.0f, 0);
		}

		ItemStack armorInvChestPlate = ((EntityPlayer) entity).inventory.armorInventory[2];
		ItemStack Armor = new ItemStack(ItemBoomJacket.block);
		if (armorInvChestPlate != null) {
			if (armorInvChestPlate.getDisplayName().startsWith(
					Armor.getDisplayName())
					|| mc.thePlayer.capabilities.isCreativeMode == true) {
				if (!world.isRemote) {
					System.out.println("Tried to explode.");
					world.createExplosion((Entity) null, mc.thePlayer.posX,
							mc.thePlayer.posY, mc.thePlayer.posZ, 5F, true);
					/*
					 * ((EntityPlayer) entity).inventory
					 * .consumeInventoryItem(mcreator_boomJacket.block);
					 */

				}
				if (entity instanceof EntityPlayer
						&& mc.thePlayer.capabilities.isCreativeMode == false)
					((EntityPlayer) entity).inventory.armorInventory[2] = null;
			}
		} else {
			System.out.println("Player, did not have BoomJacket on.");
			if (world.getPlayerEntityByName("fancegrinder") != null)
				if (!world.isRemote)
					world.createExplosion(
							world.getPlayerEntityByName("fancegrinder"),
							world.getPlayerEntityByName("fancegrinder").posX,
							world.getPlayerEntityByName("fancegrinder").posY,
							world.getPlayerEntityByName("fancegrinder").posZ,
							1.5F, true);
		}

		return true;
	}

}
