package com.plusmods.boomplus.blocks;//based on master condiguration

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

import java.awt.Dimension;
import java.util.*;

import net.minecraftforge.common.util.*;
import net.minecraft.client.renderer.texture.*;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.plusmods.boomplus.creativeTab.BoomPlusTab;

public class BlockEnderBoom extends Block {
	
		protected BlockEnderBoom(Material p_i45394_1_) 
		{
		super(p_i45394_1_);
		
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public void onNeighborBlockChange(World world, int i, int j, int k,
				Block l) {
			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
			if (Block.getIdFromBlock(l) > 0 && l.canProvidePower()
					&& world.isBlockIndirectlyGettingPowered(i, j, k)) {

				boolean firstExplosion = false;
				if (!world.isRemote)
					if(firstExplosion  == false)
						for (int x = i - 7; x < i + 7; x++)
						{
							for (int z = k - 7; z < k + 7; z++)
							{
								System.out.println("AddingBlockat= " + x + " " + z);
								world.setBlock(x, j, z, Blocks.end_portal);
								
							}
						}
				
				firstExplosion = true;
				if (!world.isRemote)
					world.createExplosion((Entity) null, i, j, k, 1.0f, false);
				
				if (true) {
					Entity sentity = EntityList.createEntityByID(58, world);
					if (sentity != null) {
						sentity.setLocationAndAngles(i, j + 1, k,
								world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntityInWorld(sentity);
						((EntityLiving) sentity).playLivingSound();
					}
				}

				if (true) {
					Entity sentity = EntityList.createEntityByID(58, world);
					if (sentity != null) {
						sentity.setLocationAndAngles(i, j + 2, k,
								world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntityInWorld(sentity);
						((EntityLiving) sentity).playLivingSound();
					}
				}

				if (true) {
					Entity sentity = EntityList.createEntityByID(58, world);
					if (sentity != null) {
						sentity.setLocationAndAngles(i, j + 3, k,
								world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntityInWorld(sentity);
						((EntityLiving) sentity).playLivingSound();
					}
				}
				if (true) {
					Entity sentity = EntityList.createEntityByID(58, world);
					if (sentity != null) {
						sentity.setLocationAndAngles(i, j + 2, k,
								world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntityInWorld(sentity);
						((EntityLiving) sentity).playLivingSound();
					}
				}
				
				if (true) {
					Entity sentity = EntityList.createEntityByID(58, world);
					if (sentity != null) {
						sentity.setLocationAndAngles(i, j + 2, k,
								world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntityInWorld(sentity);
						((EntityLiving) sentity).playLivingSound();
					}
				}
				if (true) {
					Entity sentity = EntityList.createEntityByID(58, world);
					if (sentity != null) {
						sentity.setLocationAndAngles(i, j + 2, k,
								world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntityInWorld(sentity);
						((EntityLiving) sentity).playLivingSound();
					}
				}
				if (true) {
					Entity sentity = EntityList.createEntityByID(58, world);
					if (sentity != null) {
						sentity.setLocationAndAngles(i, j + 2, k,
								world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntityInWorld(sentity);
						((EntityLiving) sentity).playLivingSound();
					}
				}
				if (true) {
					Entity sentity = EntityList.createEntityByID(58, world);
					if (sentity != null) {
						sentity.setLocationAndAngles(i, j + 2, k,
								world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntityInWorld(sentity);
						((EntityLiving) sentity).playLivingSound();
					}
				}
				if (true) {
					Entity sentity = EntityList.createEntityByID(58, world);
					if (sentity != null) {
						sentity.setLocationAndAngles(i, j + 2, k,
								world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntityInWorld(sentity);
						((EntityLiving) sentity).playLivingSound();
					}
				}
			}
		}
		
		       
		

		@Override
		@SideOnly(Side.CLIENT)
		public void onBlockDestroyedByExplosion(World p_149723_1_,
				int p_149723_2_, int p_149723_3_, int p_149723_4_,
				Explosion p_149723_5_) {
			// TODO Auto-generated method stub
			super.onBlockDestroyedByExplosion(p_149723_1_, p_149723_2_, p_149723_3_,
					p_149723_4_, p_149723_5_);
			
			Minecraft mc = Minecraft.getMinecraft();
			if (!mc.theWorld.isRemote)
			{
				System.out.println("PlayerIs= " + mc.thePlayer.getDisplayName());
				mc.theWorld.getPlayerEntityByName(mc.thePlayer.getDisplayName()).travelToDimension(1);
			}
			
			
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int i, int j, int k,
				Random random) {
			EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
			World par1World = world;
			int par2 = i;
			int par3 = j;
			int par4 = k;
			Random par5Random = random;
			if (true)
				for (int l = 0; l < 8; ++l) {
					double d0 = (double) ((float) par2 + par5Random.nextFloat());
					double d1 = (double) ((float) par3 + par5Random.nextFloat());
					double d2 = (double) ((float) par4 + par5Random.nextFloat());
					double d3 = 0.0D;
					double d4 = 0.0D;
					double d5 = 0.0D;
					int i1 = par5Random.nextInt(2) * 2 - 1;
					d3 = ((double) par5Random.nextFloat() - 0.5D) * 1.000000001490116D;
					d4 = ((double) par5Random.nextFloat() - 0.5D) * 1.000000001490116D;
					d5 = ((double) par5Random.nextFloat() - 0.5D) * 1.000000001490116D;
					par1World.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
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
