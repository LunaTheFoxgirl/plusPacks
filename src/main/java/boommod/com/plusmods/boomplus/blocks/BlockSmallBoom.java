package com.plusmods.boomplus.blocks;//based on master condiguration

import java.util.Random;

import com.plusmods.boomplus.creativeTab.BoomPlusTab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockSmallBoom extends Block {
	
		public BlockSmallBoom(Material blockMaterial) 
		{
			super(blockMaterial);
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public void onBlockAdded(World world, int i, int j, int k) {
			EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
			if (entity != null && world != null) {
				int le = MathHelper
						.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
				world.setBlockMetadataWithNotify(i, j, k, le, 2);
			}

			world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));

		}

		@Override
		@SideOnly(Side.CLIENT)
		public void onNeighborBlockChange(World world, int i, int j, int k,
				Block l) {
			EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
			if (Block.getIdFromBlock(l) > 0 && l.canProvidePower()
					&& world.isBlockIndirectlyGettingPowered(i, j, k)) {

				if (!world.isRemote) {
					world.createExplosion((Entity) null, i, j, k, 2F, true);
				}

			}
		}

		@Override
		@SideOnly(Side.CLIENT)
		public void onBlockDestroyedByExplosion(World world, int i, int j,
				int k, Explosion e) {
			EntityPlayer entity = Minecraft.getMinecraft().thePlayer;

			if (!world.isRemote) {
				world.createExplosion((Entity) null, i, j, k, 2F, true);
			}

		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public int getRenderType() {
			return 0;
		}


		@Override
		public int quantityDropped(Random par1Random) {
			return 1;
		}

	}

