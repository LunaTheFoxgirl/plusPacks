package com.plusmods.oresplus.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMixedGem extends Item
{
	int itemID, test = 1;
	
	public ItemMixedGem(int id)
	{
		itemID = id;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_,
			EntityPlayer p_77659_3_) {
		// TODO Auto-generated method stub
		
		
		
		
		return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);		
	}
	
	
}
