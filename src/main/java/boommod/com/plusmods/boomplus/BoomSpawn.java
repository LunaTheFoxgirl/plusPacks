package com.plusmods.boomplus;

import com.plusmods.boomplus.items.mcreator_guideBook;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class BoomSpawn
{

	boolean firstUse = false;
	EntityClientPlayerMP entityPlayer;
	Minecraft mc = Minecraft.getMinecraft();
	
	@SubscribeEvent()
	public void BoomJoin(EntityJoinWorldEvent event)
	{
				if (event.entity instanceof EntityClientPlayerMP)
				{
					entityPlayer = (EntityClientPlayerMP) event.entity;
						if(!entityPlayer.getStatFileWriter().hasAchievementUnlocked(AchievementList.openInventory) && firstUse == false)
						{
							
							System.out.println("Running gui..., giving book to: " + mc.thePlayer.getGameProfile().getName() + " entpl is: " + entityPlayer.getGameProfile().getName());
							boolean accepted = ((EntityPlayer)entityPlayer).inventory.addItemStackToInventory(new ItemStack(mcreator_guideBook.block, 1, 1));
							event.world.getPlayerEntityByName(entityPlayer.getDisplayName()).inventory.setInventorySlotContents(1, new ItemStack(mcreator_guideBook.block, 1, 1));
							System.out.println("AcceptStatus = " + accepted);
							//entityPlayer.openGui(BoomPlus.class, mcreator_welcomeGUI.GUIID, event.world, (int) entityPlayer.posX, (int) entityPlayer.posY, (int) entityPlayer.posZ);
							
							firstUse = true;
						}
				}
	}
	
	@SubscribeEvent
	public void PlayerDies(LivingDeathEvent event)
	{

	}
}
