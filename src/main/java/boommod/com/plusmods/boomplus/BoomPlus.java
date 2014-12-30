package com.plusmods.boomplus;//based on master condiguration

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.*;
import net.minecraft.client.audio.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.achievement.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.model.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.client.settings.*;
import net.minecraft.command.*;
import net.minecraft.crash.*;
import net.minecraft.creativetab.*;
import net.minecraft.dispenser.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.rcon.*;
import net.minecraft.pathfinding.*;
import net.minecraft.potion.*;
import net.minecraft.profiler.*;
import net.minecraft.server.*;
import net.minecraft.server.dedicated.*;
import net.minecraft.server.gui.*;
import net.minecraft.server.integrated.*;
import net.minecraft.server.management.*;
import net.minecraft.src.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.village.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.world.demo.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.world.storage.*;
import net.minecraftforge.classloading.*;
import net.minecraftforge.client.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.event.sound.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.event.entity.item.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.minecart.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.terraingen.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.oredict.*;
import net.minecraftforge.transformers.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.common.network.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import io.netty.buffer.ByteBuf;

import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import cpw.mods.fml.relauncher.*;

@Mod(modid = BoomPlus.MODID, version = BoomPlus.VERSION)
public class BoomPlus implements IFuelHandler, IWorldGenerator {

	public static final String MODID = "BoomPlus";
	public static final String VERSION = "1.2.0";

	@SidedProxy(clientSide = "com.plusmods.boomplus.ClientProxyBoomPlus", serverSide = "com.plusmods.boomplus.CommonProxyBoomPlus")
	// @SidedProxy(clientSide="mod.mcreator.ClientProxyBoomPlus",
	// serverSide="mod.mcreator.CommonProxyBoomPlus")
	public static CommonProxyBoomPlus proxy;
	// public static EnumMap<Side, FMLEmbeddedChannel> channels =
	// NetworkRegistry.INSTANCE.newChannel("MCRBUS", new
	// ChannelHandlerBoomPlus());

	@Instance(MODID)
	public static BoomPlus instance;

	mcreator_smallBoom mcreator_0 = new mcreator_smallBoom();
	mcreator_mediumBoom mcreator_1 = new mcreator_mediumBoom();
	mcreator_largeBoom mcreator_2 = new mcreator_largeBoom();
	mcreator_boomPlusTab mcreator_3 = new mcreator_boomPlusTab();
	mcreator_magicBoom mcreator_4 = new mcreator_magicBoom();
	mcreator_radGunpowder mcreator_5 = new mcreator_radGunpowder();
	mcreator_radOre mcreator_6 = new mcreator_radOre();
	mcreator_radioactiveBoom mcreator_7 = new mcreator_radioactiveBoom();
	mcreator_netherBoom mcreator_8 = new mcreator_netherBoom();
	mcreator_blazeOre mcreator_9 = new mcreator_blazeOre();
	mcreator_coolGuyGlasses mcreator_10 = new mcreator_coolGuyGlasses();
	mcreator_coolAchievement mcreator_11 = new mcreator_coolAchievement();
	mcreator_sneakyBoom mcreator_12 = new mcreator_sneakyBoom();
	mcreator_massiveBoom mcreator_13 = new mcreator_massiveBoom();
	mcreator_boomJacket mcreator_14 = new mcreator_boomJacket();
	mcreator_detonator mcreator_15 = new mcreator_detonator();
	mcreator_nuclearAchievement mcreator_16 = new mcreator_nuclearAchievement();
	mcreator_sneakyBoomIron mcreator_17 = new mcreator_sneakyBoomIron();
	mcreator_sneakyBoomGold mcreator_18 = new mcreator_sneakyBoomGold();
	mcreator_sneakyBoomDiamond mcreator_19 = new mcreator_sneakyBoomDiamond();
	mcreator_welcomeGUI mcreator_20 = new mcreator_welcomeGUI();
	mcreator_welcome mcreator_21 = new mcreator_welcome();
	mcreator_guideBook mcreator_22 = new mcreator_guideBook();
	mcreator_orisitAchievement mcreator_23 = new mcreator_orisitAchievement();
	mcreator_enderBoom mcreator_24 = new mcreator_enderBoom();
	mcreator_lavaBoom mcreator_25 = new mcreator_lavaBoom();
	mcreator_sneakyBoomEdible mcreator_26 = new mcreator_sneakyBoomEdible();
	mcreator_strangeSymbol mcreator_27 = new mcreator_strangeSymbol();
	mcreator_sneakyBoomChest mcreator_28 = new mcreator_sneakyBoomChest(203);


	@Override
	public int getBurnTime(ItemStack fuel) {
		if (mcreator_0.addFuel(fuel) != 0)
			return mcreator_0.addFuel(fuel);
		if (mcreator_1.addFuel(fuel) != 0)
			return mcreator_1.addFuel(fuel);
		if (mcreator_2.addFuel(fuel) != 0)
			return mcreator_2.addFuel(fuel);
		if (mcreator_3.addFuel(fuel) != 0)
			return mcreator_3.addFuel(fuel);
		if (mcreator_4.addFuel(fuel) != 0)
			return mcreator_4.addFuel(fuel);
		if (mcreator_5.addFuel(fuel) != 0)
			return mcreator_5.addFuel(fuel);
		if (mcreator_6.addFuel(fuel) != 0)
			return mcreator_6.addFuel(fuel);
		if (mcreator_7.addFuel(fuel) != 0)
			return mcreator_7.addFuel(fuel);
		if (mcreator_8.addFuel(fuel) != 0)
			return mcreator_8.addFuel(fuel);
		if (mcreator_9.addFuel(fuel) != 0)
			return mcreator_9.addFuel(fuel);
		if (mcreator_10.addFuel(fuel) != 0)
			return mcreator_10.addFuel(fuel);
		if (mcreator_11.addFuel(fuel) != 0)
			return mcreator_11.addFuel(fuel);
		if (mcreator_12.addFuel(fuel) != 0)
			return mcreator_12.addFuel(fuel);
		if (mcreator_13.addFuel(fuel) != 0)
			return mcreator_13.addFuel(fuel);
		if (mcreator_14.addFuel(fuel) != 0)
			return mcreator_14.addFuel(fuel);
		if (mcreator_15.addFuel(fuel) != 0)
			return mcreator_15.addFuel(fuel);
		if (mcreator_16.addFuel(fuel) != 0)
			return mcreator_16.addFuel(fuel);
		if (mcreator_17.addFuel(fuel) != 0)
			return mcreator_17.addFuel(fuel);
		if (mcreator_18.addFuel(fuel) != 0)
			return mcreator_18.addFuel(fuel);
		if (mcreator_19.addFuel(fuel) != 0)
			return mcreator_19.addFuel(fuel);
		if (mcreator_20.addFuel(fuel) != 0)
			return mcreator_20.addFuel(fuel);
		if (mcreator_21.addFuel(fuel) != 0)
			return mcreator_21.addFuel(fuel);
		return 0;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		chunkX = chunkX * 16;
		chunkZ = chunkZ * 16;
		if (world.provider.dimensionId == -1)
			mcreator_0.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_0.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_1.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_1.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_2.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_2.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_3.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_3.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_4.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_4.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_5.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_5.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_6.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_6.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_7.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_7.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_8.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_8.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_9.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_9.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_10.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_10.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_11.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_11.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_12.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_12.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_13.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_13.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_14.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_14.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_15.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_15.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_16.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_16.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_17.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_17.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_18.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_18.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_19.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_19.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_20.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_20.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == -1)
			mcreator_21.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.dimensionId == 0)
			mcreator_21.generateSurface(world, random, chunkX, chunkZ);

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		GameRegistry.registerFuelHandler(this);
		GameRegistry.registerWorldGenerator(this, 1);
		MinecraftForge.EVENT_BUS.register(new mcreator_GlobalEventsBoomPlus());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		mcreator_0.load();
		mcreator_1.load();
		mcreator_2.load();
		mcreator_3.load();
		mcreator_4.load();
		mcreator_5.load();
		mcreator_6.load();
		mcreator_7.load();
		mcreator_8.load();
		mcreator_9.load();
		mcreator_10.load();
		mcreator_11.load();
		mcreator_12.load();
		mcreator_13.load();
		mcreator_14.load();
		mcreator_15.load();
		mcreator_16.load();
		mcreator_17.load();
		mcreator_18.load();
		mcreator_19.load();
		mcreator_20.load();
		mcreator_21.load();
		mcreator_22.load();
		mcreator_23.load();
		mcreator_24.load();
		mcreator_25.load();
		mcreator_26.load();
		mcreator_27.load();
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		mcreator_0.serverLoad(event);
		mcreator_1.serverLoad(event);
		mcreator_2.serverLoad(event);
		mcreator_3.serverLoad(event);
		mcreator_4.serverLoad(event);
		mcreator_5.serverLoad(event);
		mcreator_6.serverLoad(event);
		mcreator_7.serverLoad(event);
		mcreator_8.serverLoad(event);
		mcreator_9.serverLoad(event);
		mcreator_10.serverLoad(event);
		mcreator_11.serverLoad(event);
		mcreator_12.serverLoad(event);
		mcreator_13.serverLoad(event);
		mcreator_14.serverLoad(event);
		mcreator_15.serverLoad(event);
		mcreator_16.serverLoad(event);
		mcreator_17.serverLoad(event);
		mcreator_18.serverLoad(event);
		mcreator_19.serverLoad(event);
		mcreator_20.serverLoad(event);
		mcreator_21.serverLoad(event);
		mcreator_22.serverLoad(event);
		mcreator_24.serverLoad(event);
		mcreator_25.serverLoad(event);
		mcreator_26.serverLoad(event);
		mcreator_27.serverLoad(event);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		mcreator_0.instance = this.instance;
		mcreator_1.instance = this.instance;
		mcreator_2.instance = this.instance;
		mcreator_3.instance = this.instance;
		mcreator_4.instance = this.instance;
		mcreator_5.instance = this.instance;
		mcreator_6.instance = this.instance;
		mcreator_7.instance = this.instance;
		mcreator_8.instance = this.instance;
		mcreator_9.instance = this.instance;
		mcreator_10.instance = this.instance;
		mcreator_11.instance = this.instance;
		mcreator_12.instance = this.instance;
		mcreator_13.instance = this.instance;
		mcreator_14.instance = this.instance;
		mcreator_15.instance = this.instance;
		mcreator_16.instance = this.instance;
		mcreator_17.instance = this.instance;
		mcreator_18.instance = this.instance;
		mcreator_19.instance = this.instance;
		mcreator_20.instance = this.instance;
		mcreator_21.instance = this.instance;
		mcreator_22.instance = this.instance;
		mcreator_0.preInit(event);
		mcreator_1.preInit(event);
		mcreator_2.preInit(event);
		mcreator_3.preInit(event);
		mcreator_4.preInit(event);
		mcreator_5.preInit(event);
		mcreator_6.preInit(event);
		mcreator_7.preInit(event);
		mcreator_8.preInit(event);
		mcreator_9.preInit(event);
		mcreator_10.preInit(event);
		mcreator_11.preInit(event);
		mcreator_12.preInit(event);
		mcreator_13.preInit(event);
		mcreator_14.preInit(event);
		mcreator_15.preInit(event);
		mcreator_16.preInit(event);
		mcreator_17.preInit(event);
		mcreator_18.preInit(event);
		mcreator_19.preInit(event);
		mcreator_20.preInit(event);
		mcreator_21.preInit(event);
		mcreator_22.preInit(event);
		mcreator_24.preInit(event);
		mcreator_25.preInit(event);
		mcreator_26.preInit(event);
		mcreator_27.preInit(event);
		proxy.registerRenderers(this);
<<<<<<< HEAD
		
		GameRegistry.registerBlock(mcreator_28, "SneakyBoomChest");
		GameRegistry.registerTileEntity(TileEntityChestValues.class, "isArmed");
		
=======
	
>>>>>>> acad4925384641453ec80bff4ed6e29596841d64
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new BoomSpawn());
	}

	public static class GuiHandler implements IGuiHandler {
		@Override
		public Object getServerGuiElement(int id, EntityPlayer player,
				World world, int x, int y, int z) {
			if (id == mcreator_welcomeGUI.GUIID)
				return new mcreator_welcomeGUI.GuiContainerMod(player);
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player,
				World world, int x, int y, int z) {
			if (id == mcreator_welcomeGUI.GUIID)
				return new mcreator_welcomeGUI.GuiWindow(world, x, y, z, player);
			return null;
		}
	}

}
