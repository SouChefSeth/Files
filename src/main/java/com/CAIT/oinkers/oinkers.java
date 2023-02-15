package com.CAIT.oinkers;

import com.CAIT.oinkers.block.entity.ModBlockEntitiesTypes;
import com.CAIT.oinkers.entity.ModAnimal;
import com.CAIT.oinkers.entity.client.WigglerRenderer;
import com.CAIT.oinkers.fluids.FluidTypes;
import com.CAIT.oinkers.init.BiomeInit;
import com.CAIT.oinkers.init.BlockInit;
import com.CAIT.oinkers.init.BoatClient;
import com.CAIT.oinkers.init.EnchantmentsInit;
import com.CAIT.oinkers.init.EventHandler;
import com.CAIT.oinkers.init.FluidInit;
import com.CAIT.oinkers.init.ItemInit;
import com.CAIT.oinkers.init.ModEffectsInit;
import com.CAIT.oinkers.init.ModEntityTypes;
import com.CAIT.oinkers.init.TagInit;
import com.CAIT.oinkers.recipe.ModRecipes;
import com.CAIT.oinkers.screen.CarrotForgeScreen;
import com.CAIT.oinkers.screen.CarrotInfuserScreen;
import com.CAIT.oinkers.screen.ModMenuTypes;
import com.CAIT.oinkers.world.dimension.ModDimensions;
import com.CAIT.oinkers.world.feature.ModConfiguredFeatures;
import com.CAIT.oinkers.world.feature.ModPlacedFeatures;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod("oinkers")
public class oinkers {
	
	public static final String MOD_ID = "oinkers";
	
	public static final CreativeModeTab TAB = new CreativeModeTab(MOD_ID) {
		
		@Override
		public ItemStack makeIcon() {
			// TODO Auto-generated method stub
			return (new ItemStack(ItemInit.CARROT_SHANK.get()));
		}
	};
	
	public static oinkers instance;
	
	@SuppressWarnings("deprecation")
	public oinkers() {
		
		instance = this;
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		bus.addListener(this::clientSetup);
		bus.addListener(this::commonSetup);
		bus.addListener(this::loadComplete);
		
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		
		ModEntityTypes.register(bus);
		
		ModBlockEntitiesTypes.register(bus);
		ModMenuTypes.register(bus);
		
		FluidTypes.register(bus);
		FluidInit.register(bus);
		
		ModConfiguredFeatures.register(bus);
		ModPlacedFeatures.register(bus);
		ModRecipes.register(bus);
		GeckoLib.initialize();
		ModDimensions.register();
		BiomeInit.BIOMES.register(bus);
		ModEffectsInit.register(bus);
		EnchantmentsInit.register(bus);
		
		DistExecutor.runWhenOn(
        		Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().addListener(BoatClient::boatClientOne));
        	DistExecutor.runWhenOn(
        		Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().addListener(BoatClient::boatClientTwo));
		
		
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SuppressWarnings("deprecation")
	private void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() ->{
			SpawnPlacements.register(ModEntityTypes.WIGGLER.get(),
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					ModAnimal::checkAnimalSpawnRules);
		}
		);
	}
	
	@SuppressWarnings("removal")
	private void clientSetup(final FMLClientSetupEvent event) {
		EntityRenderers.register(ModEntityTypes.WIGGLER.get(), WigglerRenderer::new);
		ItemBlockRenderTypes.setRenderLayer(FluidInit.PIG_JUICE.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(FluidInit.FLOWING_PIG_JUICE.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.STONE_CARROT_PLANT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.IRON_CARROT_PLANT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLD_CARROT_PLANT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.DIAMOND_CARROT_PLANT.get(), RenderType.cutout());
		MenuScreens.register(ModMenuTypes.CARROT_INFUSER_MENU.get(), CarrotInfuserScreen::new);
		MenuScreens.register(ModMenuTypes.CARROT_FORGE_MENU.get(), CarrotForgeScreen::new);
		
	}
	
	private void loadComplete(final FMLLoadCompleteEvent event)
    {
        // Setup tags
        TagInit.setup();
    }
}
