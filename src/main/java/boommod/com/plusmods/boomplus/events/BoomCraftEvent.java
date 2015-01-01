package com.plusmods.boomplus.events;

import java.util.List;

import com.plusmods.boomplus.common.BoomPlus;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BoomCraftEvent
{
	@EventHandler
	public void crafted(PlayerEvent.ItemCraftedEvent event)
	{
		if (event.crafting.getItem() == Item.getItemFromBlock(BoomPlus.sneakyBoomDiamond) || event.crafting.getItem() == Item.getItemFromBlock(BoomPlus.sneakyBoomIron) || event.crafting.getItem() == Item.getItemFromBlock(BoomPlus.sneakyBoomGold) || event.crafting.getItem() == Item.getItemFromBlock(BoomPlus.sneakyBoomStone) || event.crafting.getItem() == Item.getItemFromBlock(BoomPlus.sneakyBoomChest))
		{
			if(!event.player.worldObj.isRemote)
			{
				event.player.addStat(BoomPlus.oreIsItAchievement, 1);
				event.player.playSound("boomplus:orIsIt", 1.0f, 1.0f);
			}
		}
	}
}
