package com.plusmods.oresplus.blocks;


import java.util.Random;

import com.plusmods.oresplus.OresPlus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class CitrineOre extends Block
{

	public CitrineOre(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		// TODO Auto-generated method stub
		return OresPlus.citrine;
	}
	
	

}
