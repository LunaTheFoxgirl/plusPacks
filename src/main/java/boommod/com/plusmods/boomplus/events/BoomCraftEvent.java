package com.plusmods.boomplus.events;

import java.util.List;

import scala.Console;

import com.plusmods.boomplus.common.BoomPlus;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BoomCraftEvent
{
	@SubscribeEvent
	public void crafted(PlayerEvent.ItemCraftedEvent event)
	{
		if(event.player instanceof EntityPlayerMP)
		{
			System.out.println("Player " + event.player + " crafted " + event.crafting.toString());
			if (event.crafting.getItem() == Item.getItemFromBlock(BoomPlus.sneakyBoomDiamond) || event.crafting.getItem() == Item.getItemFromBlock(BoomPlus.sneakyBoomIron) || event.crafting.getItem() == Item.getItemFromBlock(BoomPlus.sneakyBoomGold) || event.crafting.getItem() == Item.getItemFromBlock(BoomPlus.sneakyBoomStone) || event.crafting.getItem() == Item.getItemFromBlock(BoomPlus.sneakyBoomChest))
			{
				System.out.println("Player " + event.player + " crafted required item " + event.crafting.toString());
					if (!((EntityPlayerMP) event.player).func_147099_x().hasAchievementUnlocked(BoomPlus.oreIsItAchievement))
					{
						System.out.println("Player did not have achievement.");
							System.out.println("Tried to give Achievement...");
							event.player.addStat(BoomPlus.oreIsItAchievement, 1);
					}
			}
		}	
	}
}
