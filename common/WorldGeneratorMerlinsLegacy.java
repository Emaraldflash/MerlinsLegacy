package mods.MerlinsLegacy.common;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorMerlinsLegacy implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case 1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case -1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
		
	}

	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
	
			}

	private void generateSurface(World world, Random random, int chunkX,int chunkZ) {
		for (int i = 0; i < 8; i++){
			 	int xCoord = chunkX + random.nextInt(16); 
	            int yCoord = random.nextInt(64); 
	            int zCoord = chunkZ + random.nextInt(16);	
			
			(new WorldGenMinable(MerlinsLegacy.ElementiumOre.blockID, 8)).generate(world, random, xCoord, yCoord, zCoord);
			
			for (int i1 = 0; i1 < 4; i1++){
			 	int xCoord1 = chunkX + random.nextInt(16); 
	            int yCoord1 = random.nextInt(20); 
	            int zCoord1 = chunkZ + random.nextInt(16);
			(new WorldGenMinable(MerlinsLegacy.DragoniteOre.blockID, 4)).generate(world, random, xCoord1, yCoord1, zCoord1);
			
			}
		}
			
	}

	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
	
	}

}
