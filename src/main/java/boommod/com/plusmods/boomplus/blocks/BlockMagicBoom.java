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

import com.plusmods.boomplus.creativeTab.BoomPlusTab;

public class BlockMagicBoom extends Block {

		public BlockMagicBoom(Material blockMaterial) 
		{
			super(blockMaterial);
		}

		@Override
		public void onBlockAdded(World world, int i, int j, int k) {
			String playerName = Minecraft.getMinecraft().thePlayer.getDisplayName();
			if (world.getPlayerEntityByName(playerName) != null && world != null) {
				int le = MathHelper
						.floor_double((double) (world.getPlayerEntityByName(playerName).rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
				world.setBlockMetadataWithNotify(i, j, k, le, 2);
			}

			world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));

		}


		@Override
		public void onNeighborBlockChange(World world, int i, int j, int k, Block l) 
		{
			String playerName = "Steve";
			if (world.isRemote)
				playerName = Minecraft.getMinecraft().thePlayer.getDisplayName();
			
			if (Block.getIdFromBlock(l) > 0 && l.canProvidePower() && world.isBlockIndirectlyGettingPowered(i, j, k) || Block.getIdFromBlock(l) > 0 && l.canProvidePower()) {

				if (true) {
					world.spawnEntityInWorld(new EntityLightningBolt(world,
							i + 1, j, k + 1));
				}

				if (!world.isRemote) {
					world.createExplosion((Entity) null, i, j, k, 0.5F, true);
				}

				if (true) {
					world.getPlayerEntityByName(playerName).attackEntityFrom(DamageSource.generic, 3);
				}

				if (!world.isRemote) {
					world.getPlayerEntityByName(playerName).addPotionEffect(new PotionEffect(15, 15, 0));
				}

				if (!world.isRemote) {
					world.createExplosion((Entity) null, i, j, k, 4F, true);
				}

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
					d3 = ((double) par5Random.nextFloat() - 0.5D) * 1.500000001490116D;
					d4 = ((double) par5Random.nextFloat() - 0.5D) * 1.500000001490116D;
					d5 = ((double) par5Random.nextFloat() - 0.5D) * 1.500000001490116D;
					par1World.spawnParticle("instantSpell", d0, d1, d2, d3, d4,
							d5);
				}

		}

		@Override
		public void onBlockDestroyedByExplosion(World world, int i, int j,
				int k, Explosion e) {

			if (!world.isRemote) {
				world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
				world.createExplosion((Entity) null, i, j, k, 4F, true);
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
