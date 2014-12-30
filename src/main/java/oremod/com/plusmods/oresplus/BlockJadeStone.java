package com.plusmods.oresplus;

import java.util.Random;

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
		
		public BlockJadeStone(int i)
		{
			super(Material.ground);
			this.id = i;

		}

		@SideOnly(Side.SERVER)
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
		public Item getItemDropped(int metaData, Random random, int fortune)
		{
			return OresPlus.itemJade;
		}
		
		@Override
		public int quantityDropped(Random par1Random) {
			return 1;
		}

	}
