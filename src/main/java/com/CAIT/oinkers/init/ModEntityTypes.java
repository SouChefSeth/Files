package com.CAIT.oinkers.init;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.WigglerEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, oinkers.MOD_ID);
	
	public static final RegistryObject<EntityType<WigglerEntity>> WIGGLER = ENTITY_TYPES.register("wiggler",
			() -> EntityType.Builder.of(WigglerEntity::new, MobCategory.CREATURE)
			.sized(1f, 2.4f)
			.build(new ResourceLocation(oinkers.MOD_ID, "wiggler").toString()));
	
	public static void register(IEventBus bus) {
		ENTITY_TYPES.register(bus);
	}
}
