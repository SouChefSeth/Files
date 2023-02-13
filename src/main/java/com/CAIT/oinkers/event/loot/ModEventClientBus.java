package com.CAIT.oinkers.event.loot;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.armor.CarrotArmor;
import com.CAIT.oinkers.entity.client.armor.CarrotArmorRenderer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = oinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBus {
	
	@SubscribeEvent
	public static void registerArmorRenderer(final EntityRenderersEvent.AddLayers event) {
		GeoArmorRenderer.registerArmorRenderer(CarrotArmor.class, new CarrotArmorRenderer());
	}
}
