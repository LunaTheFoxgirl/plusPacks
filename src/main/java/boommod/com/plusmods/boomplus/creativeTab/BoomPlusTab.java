package com.plusmods.boomplus.creativeTab;//based on master condiguration

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;



public class BoomPlusTab {

	public Object instance;

	public static CreativeTabs tab = new CreativeTabs("tabboomPlusTab") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.tnt);
		}
	};
}
