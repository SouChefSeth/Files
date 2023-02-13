package com.CAIT.oinkers.event.loot;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.WigglerEntity;
import com.CAIT.oinkers.init.ModEntityTypes;

@Mod.EventBusSubscriber(modid = oinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBus {
	
	@SubscribeEvent
	public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
		event.put(ModEntityTypes.WIGGLER.get(), WigglerEntity.setAttributes());
	}
}
