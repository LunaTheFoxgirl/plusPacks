package com.plusmods.vanillaplus.blocks;

import com.plusmods.boomplus.entities.TileEntityChestValues;
import com.plusmods.vanillaplus.tilentities.TileEntityInfuser;

import net.minecraft.block.BlockFurnace;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockInfuser extends BlockFurnace
{
	
	

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        TileEntityInfuser inf = new TileEntityInfuser();
        return inf;
    }

	public BlockInfuser(boolean p_i45407_1_) {
		super(p_i45407_1_);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
