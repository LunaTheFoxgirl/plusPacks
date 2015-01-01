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

public class BlockInstaBoom extends Block {

	public BlockInstaBoom() {
		super(Material.iron);

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
	public void onBlockDestroyedByExplosion(World p_149723_1_, int p_149723_2_,
			int p_149723_3_, int p_149723_4_, Explosion p_149723_5_) {
		if (!p_149723_1_.isRemote) {
			/*
			 * p_149723_1_.createExplosion((Entity) null, p_149723_2_,
			 * p_149723_3_, p_149723_4_, 5.0f, true);
			 */

			for (int x = p_149723_2_ - 5; x < p_149723_2_ + 5; x++)
				for (int y = p_149723_3_ - 5; y < p_149723_3_ + 5; y++)
					for (int z = p_149723_4_ - 5; z < p_149723_4_ + 5; z++)
							if (
									p_149723_1_.getBlock(x, y, z) == Blocks.bedrock ||
									p_149723_1_.getBlock(x, y, z) == Blocks.coal_ore ||
									p_149723_1_.getBlock(x, y, z) == Blocks.coal_block||
									p_149723_1_.getBlock(x, y, z) == Blocks.iron_bars ||
									p_149723_1_.getBlock(x, y, z) == Blocks.iron_block||
									p_149723_1_.getBlock(x, y, z) == Blocks.iron_door ||
									p_149723_1_.getBlock(x, y, z) == Blocks.iron_ore ||
									p_149723_1_.getBlock(x, y, z) == Blocks.gold_block ||
									p_149723_1_.getBlock(x, y, z) == Blocks.gold_ore ||
									p_149723_1_.getBlock(x, y, z) == Blocks.golden_rail ||
									p_149723_1_.getBlock(x, y, z) == Blocks.rail ||
									p_149723_1_.getBlock(x, y, z) == Blocks.diamond_block ||
									p_149723_1_.getBlock(x, y, z) == Blocks.diamond_ore ||
									p_149723_1_.getBlock(x, y, z) == Blocks.redstone_block ||
									p_149723_1_.getBlock(x, y, z) == Blocks.redstone_lamp ||
									p_149723_1_.getBlock(x, y, z) == Blocks.redstone_ore ||
									p_149723_1_.getBlock(x, y, z) == Blocks.redstone_torch ||
									p_149723_1_.getBlock(x, y, z) == Blocks.redstone_wire ||
									p_149723_1_.getBlock(x, y, z) == Blocks.torch ||
									p_149723_1_.getBlock(x, y, z) == Blocks.lever ||
									p_149723_1_.getBlock(x, y, z) == Blocks.wool ||
									p_149723_1_.getBlock(x, y, z) == Blocks.planks ||
									p_149723_1_.getBlock(x, y, z) == Blocks.log ||
									p_149723_1_.getBlock(x, y, z) == Blocks.log2 ||
									p_149723_1_.getBlock(x, y, z) == Blocks.wooden_button ||
									p_149723_1_.getBlock(x, y, z) == Blocks.wooden_door ||
									p_149723_1_.getBlock(x, y, z) == Blocks.wooden_pressure_plate ||
									p_149723_1_.getBlock(x, y, z) == Blocks.wooden_slab ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.blazeOre ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.radioactiveOre ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.radioactiveBoom ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.smallBoom ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.mediumBoom ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.largeBoom ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.massiveBoom ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.magicBoom ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.enderBoom ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.sneakyBoomChest ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.sneakyBoomIron ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.sneakyBoomGold ||
									p_149723_1_.getBlock(x, y, z) == BoomPlus.sneakyBoomDiamond) 
							{
								
							}
							else 
							{
								p_149723_1_.setBlock(x, y, z, Blocks.air);
							}
			if(!p_149723_1_.isRemote)
				p_149723_1_.playSound(p_149723_2_, p_149723_3_, p_149723_4_, "minecraft:random.explode", 1.0f, 1.0f, true);
		}
	}

	@Override
	public void onNeighborBlockChange(World world, int i, int j, int k, Block l) {
		if (Block.getIdFromBlock(l) > 0 && l.canProvidePower()
				&& world.isBlockIndirectlyGettingPowered(i, j, k)) {

			/*
			 * if (!world.isRemote) {
			 */
			/* world.createExplosion((Entity) null, i, j, k, 5.0f, true); */

			for (int x = i - 5; x < i + 5; x++)
				for (int y = j - 5; y < j + 5; y++)
					for (int z = k - 5; z < k + 5; z++)
							if (
									world.getBlock(x, y, z) == Blocks.bedrock ||
									world.getBlock(x, y, z) == Blocks.coal_ore ||
									world.getBlock(x, y, z) == Blocks.coal_block||
									world.getBlock(x, y, z) == Blocks.iron_bars ||
									world.getBlock(x, y, z) == Blocks.iron_block||
									world.getBlock(x, y, z) == Blocks.iron_door ||
									world.getBlock(x, y, z) == Blocks.iron_ore ||
									world.getBlock(x, y, z) == Blocks.gold_block ||
									world.getBlock(x, y, z) == Blocks.gold_ore ||
									world.getBlock(x, y, z) == Blocks.golden_rail ||
									world.getBlock(x, y, z) == Blocks.rail ||
									world.getBlock(x, y, z) == Blocks.diamond_block ||
									world.getBlock(x, y, z) == Blocks.diamond_ore ||
									world.getBlock(x, y, z) == Blocks.redstone_block ||
									world.getBlock(x, y, z) == Blocks.redstone_lamp ||
									world.getBlock(x, y, z) == Blocks.redstone_ore ||
									world.getBlock(x, y, z) == Blocks.redstone_torch ||
									world.getBlock(x, y, z) == Blocks.redstone_wire ||
									world.getBlock(x, y, z) == Blocks.torch ||
									world.getBlock(x, y, z) == Blocks.lever ||
									world.getBlock(x, y, z) == Blocks.wool ||
									world.getBlock(x, y, z) == Blocks.planks ||
									world.getBlock(x, y, z) == Blocks.log ||
									world.getBlock(x, y, z) == Blocks.log2 ||
									world.getBlock(x, y, z) == Blocks.wooden_button ||
									world.getBlock(x, y, z) == Blocks.wooden_door ||
									world.getBlock(x, y, z) == Blocks.wooden_pressure_plate ||
									world.getBlock(x, y, z) == Blocks.wooden_slab ||
									world.getBlock(x, y, z) == BoomPlus.blazeOre ||
									world.getBlock(x, y, z) == BoomPlus.radioactiveOre ||
									world.getBlock(x, y, z) == BoomPlus.radioactiveBoom ||
									world.getBlock(x, y, z) == BoomPlus.smallBoom ||
									world.getBlock(x, y, z) == BoomPlus.mediumBoom ||
									world.getBlock(x, y, z) == BoomPlus.largeBoom ||
									world.getBlock(x, y, z) == BoomPlus.massiveBoom ||
									world.getBlock(x, y, z) == BoomPlus.magicBoom ||
									world.getBlock(x, y, z) == BoomPlus.enderBoom ||
									world.getBlock(x, y, z) == BoomPlus.sneakyBoomChest ||
									world.getBlock(x, y, z) == BoomPlus.sneakyBoomIron ||
									world.getBlock(x, y, z) == BoomPlus.sneakyBoomGold ||
									world.getBlock(x, y, z) == BoomPlus.sneakyBoomDiamond) 
							{
								
							}
							else 
							{
								world.setBlock(x, y, z, Blocks.air);
							}
			if(!world.isRemote)
				world.playSoundAtEntity(world.getClosestPlayer(i, j, k, -1), "minecraft:random.explode", 1.0f, 1.0f);
			/* } */
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