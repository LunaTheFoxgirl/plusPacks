package com.plusmods.vanillaplus.oreGen;

import java.util.Random;

import com.plusmods.oresplus.common.OresPlus;
import com.plusmods.vanillaplus.common.VanillaPlus;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class InfusedOreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		generateSurface(world, random, chunkX * 16, chunkZ * 16);
		
	}
	
	public void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		for(int gen = 0; gen < 50; gen++)
		{
			int x = chunkX + random.nextInt(13);
			int y = random.nextInt(70);
			int z = chunkZ + random.nextInt(5);
			(new WorldGenMinable(VanillaPlus.infusedOre, 7)).generate(world, random, x, y, z);
		}
		
	}

}
