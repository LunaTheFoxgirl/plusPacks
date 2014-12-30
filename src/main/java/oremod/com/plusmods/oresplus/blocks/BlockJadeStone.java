package com.plusmods.oresplus.blocks;

import java.util.Random;

import com.plusmods.oresplus.OresPlus;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


	public class BlockJadeStone extends Block {

		int id;
		
		public BlockJadeStone(Material id)
		{
			super(id);

		}
		

		
		public int getRenderType() {
			return 0;
		}

		@Override
		public int tickRate(World world) {
			return 10;
		}

		@Override
		public Item getItemDropped(int metaData, Random random, int fortune)
		{
			return OresPlus.itemJade;
		}
		
		@Override
		public int quantityDropped(Random par1Random) {
			return 1;
		}

	}
