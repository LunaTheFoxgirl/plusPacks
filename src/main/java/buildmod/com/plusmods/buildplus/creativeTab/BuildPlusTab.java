package com.plusmods.buildplus.creativeTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;



public class BuildPlusTab {

	public Object instance;

	public static CreativeTabs tab = new CreativeTabs("buildPlusTab") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.planks);
		}
	};
}
