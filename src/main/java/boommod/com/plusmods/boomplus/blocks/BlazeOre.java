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

import com.plusmods.boomplus.BoomPlusTab;

public class BlazeOre {

	public BlazeOre() {
	}

	public static BlockBlazeOre block;

	public static Object instance;

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {

		GameRegistry.registerBlock(block, "BlazeOre");
	}

	public void registerRenderers() {
	}

	public void load() {
	}

	static {

		block = (BlockBlazeOre) (new BlockBlazeOre().setHardness(6.0F)
				.setResistance(15.0F).setLightLevel(0.0F)
				.setBlockName("BlazeOre")
				.setBlockTextureName("boomplus:blazeOreTexture")
				.setLightOpacity(0)
				.setStepSound(Block.soundTypeStone)
				.setCreativeTab(BoomPlusTab.tab));
		block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		Block.blockRegistry.addObject(189, "BlazeOre", block);
		block.setHarvestLevel("pickaxe", 2);
	}

	public void generateSurface(World world, Random random, int chunkX,
			int chunkZ) {
	}

	public void generateNether(World world, java.util.Random rand, int chunkX,
			int chunkZ) {
		for (int i = 0; i < 6; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(44) + 9;
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(BlazeOre.block, 12)).generate(world,
					rand, randPosX, randPosY, randPosZ);
		}
	}

	static class BlockBlazeOre extends Block {

		int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0;

		IIcon gor = null, dol = null, st1 = null, st2 = null, st3 = null,
				st4 = null;

		boolean red = false;

		protected BlockBlazeOre() {
			super(Material.ground);

		}

		public void onBlockAdded(World world, int i, int j, int k) {
			EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
			if (entity != null && world != null) {
				int le = MathHelper
						.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
				world.setBlockMetadataWithNotify(i, j, k, le, 2);
			}

			world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));

		}

		public int isProvidingStrongPower(IBlockAccess par1IBlockAccess,
				int par2, int par3, int par4, int par5) {
			return red ? 1 : 0;
		}

		public void randomDisplayTick(World world, int i, int j, int k,
				Random random) {
			EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
			World par1World = world;
			int par2 = i;
			int par3 = j;
			int par4 = k;
			Random par5Random = random;
			if (true)
				for (int l = 0; l < 10; ++l) {
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
					par1World.spawnParticle("flame", d0, d1, d2, d3, d4, d5);
				}

		}

		public void onBlockDestroyedByPlayer(World world, int i, int j, int k,
				int l) {
			EntityPlayer entity = Minecraft.getMinecraft().thePlayer;

			if (!world.isRemote)
				if (true) {
					Entity sentity = EntityList.createEntityByID(61, world);
					if (sentity != null) {
						sentity.setLocationAndAngles(i, j, k,
							world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntityInWorld(sentity);
					((EntityLiving) sentity).playLivingSound();
				}
			}

		}

		public void onBlockDestroyedByExplosion(World world, int i, int j,
				int k, Explosion e) {
			EntityPlayer entity = Minecraft.getMinecraft().thePlayer;

			if (true) {
				Entity sentity = EntityList.createEntityByID(61, world);
				if (sentity != null) {
					sentity.setLocationAndAngles(i, j, k,
							world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntityInWorld(sentity);
					((EntityLiving) sentity).playLivingSound();
				}
			}

		}



		@SideOnly(Side.CLIENT)
		public int getRenderType() {
			return 0;
		}

		@Override
		public int tickRate(World world) {
			return 10;
		}

		public int quantityDropped(Random par1Random) {
			return 3;
		}

		public Item getItemDropped(int par1, Random par2Random, int par3) {
			return Items.blaze_powder;
		}
	}
}
