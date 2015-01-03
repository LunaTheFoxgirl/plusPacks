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

import java.util.*;

import net.minecraftforge.common.util.*;
import net.minecraft.client.renderer.texture.*;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.plusmods.boomplus.common.BoomPlus;
import com.plusmods.boomplus.creativeTab.BoomPlusTab;
import com.plusmods.boomplus.items.ItemRadioactivePowder;

public class BlockRadioactiveBoom extends Block {

		public BlockRadioactiveBoom(Material blockMaterial) 
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
		public void onBlockDestroyedByExplosion(World world, int i, int j,
				int k, Explosion e) {

			if (!world.isRemote) {
				for (int x = i - 124; x < i + 124; x++)
					for (int y = j - 32; y < j + 64; y++)
						for (int z = k - 124; z < k + 124; z++)
								if (
										world.getBlock(x, y, z) == Blocks.grass) 
								{
									world.setBlock(x, y, z, Block.getBlockById(243));
								}
								else if (world.getBlock(x, y, z) == Blocks.leaves || world.getBlock(x, y, z) == Blocks.leaves2)
								{
									world.setBlock(x, y, z, Blocks.air);
								}
								else if (world.getBlock(x, y, z) == Blocks.sand) 
								{
									world.setBlock(x, y, z, Blocks.glass);
								}
								else if (world.getBlock(x, y, z) == Blocks.tallgrass) 
								{
									world.setBlock(x, y, z, Blocks.air);
								}
								else if (world.getBlock(x, y, z) == Blocks.water) 
								{
									world.setBlock(x, y, z, Blocks.air);
								}
								else if (world.getBlock(x, y, z) == Blocks.waterlily) 
								{
									world.setBlock(x, y, z, Blocks.air);
								}
								else if (world.getBlock(x, y, z) == Blocks.flowing_water) 
								{
									world.setBlock(x, y, z, Blocks.air);
								}
								else if (world.getBlock(x, y, z) == Blocks.stone) 
								{
									world.setBlock(x, y, z, Blocks.gravel);
								}
				world.setBlock(i, j, k, Blocks.air);
				if(!world.isRemote)
					world.playSoundAtEntity(world.getClosestPlayer(i, j, k, -1), "minecraft:random.explode", 130.0f, 1.0f);
			}

		}
		
		@Override
		public void onNeighborBlockChange(World world, int i, int j, int k, Block l) {
			//String playerName = Minecraft.getMinecraft().thePlayer.getDisplayName();
			
			if (Block.getIdFromBlock(l) > 0 && l.canProvidePower()
					&& world.isBlockIndirectlyGettingPowered(i, j, k)) {
				for (int x = i - 124; x < i + 124; x++)
					for (int y = j - 32; y < j + 64; y++)
						for (int z = k - 124; z < k + 124; z++)
								if (
										world.getBlock(x, y, z) == Blocks.grass) 
								{
									world.setBlock(x, y, z, Block.getBlockById(243));
								}
								else if (world.getBlock(x, y, z) == Blocks.leaves || world.getBlock(x, y, z) == Blocks.leaves2)
								{
									world.setBlock(x, y, z, Blocks.air);
								}
								else if (world.getBlock(x, y, z) == Blocks.sand) 
								{
									world.setBlock(x, y, z, Blocks.glass);
								}
								else if (world.getBlock(x, y, z) == Blocks.tallgrass) 
								{
									world.setBlock(x, y, z, Blocks.air);
								}
								else if (world.getBlock(x, y, z) == Blocks.water) 
								{
									world.setBlock(x, y, z, Blocks.air);
								}
								else if (world.getBlock(x, y, z) == Blocks.waterlily) 
								{
									world.setBlock(x, y, z, Blocks.air);
								}
								else if (world.getBlock(x, y, z) == Blocks.flowing_water) 
								{
									world.setBlock(x, y, z, Blocks.air);
								}
								else if (world.getBlock(x, y, z) == Blocks.stone) 
								{
									world.setBlock(x, y, z, Blocks.gravel);
								}
				world.setBlock(i, j, k, Blocks.air);
				if(!world.isRemote)
					world.playSoundAtEntity(world.getClosestPlayer(i, j, k, -1), "minecraft:random.explode", 130.0f, 1.0f);
				/* } */
				/*if (world.isRemote) {
					world.getPlayerEntityByName(playerName).addPotionEffect(new PotionEffect(15, 30, 2)); //TODO: Find a replacement for this.
				}*/
				
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
				for (int l = 0; l < 30; ++l) {
					double d0 = (double) ((float) par2 + par5Random.nextFloat());
					double d1 = (double) ((float) par3 + par5Random.nextFloat());
					double d2 = (double) ((float) par4 + par5Random.nextFloat());
					double d3 = 0.0D;
					double d4 = 0.0D;
					double d5 = 0.0D;
					int i1 = par5Random.nextInt(2) * 2 - 1;
					d3 = ((double) par5Random.nextFloat() - 0.5D) * 2.0D;
					d4 = ((double) par5Random.nextFloat() - 0.5D) * 2.0D;
					d5 = ((double) par5Random.nextFloat() - 0.5D) * 2.0D;
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
