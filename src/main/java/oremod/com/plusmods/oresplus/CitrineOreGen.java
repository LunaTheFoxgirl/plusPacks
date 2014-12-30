package com.plusmods.oresplus;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class CitrineOreGen implements IWorldGenerator {

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
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(70);
			int z = chunkZ + random.nextInt(5);
			(new WorldGenMinable(OresPlus.blockCitrineOre, 10)).generate(world, random, x, y, z);
		}
		
	}

}
