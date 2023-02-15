package com.CAIT.oinkers.init;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.enchantment.Absorption;
import com.CAIT.oinkers.enchantment.AtiumFire;
import com.CAIT.oinkers.enchantment.AtiumLight;
import com.CAIT.oinkers.enchantment.AtiumSpring;
import com.CAIT.oinkers.enchantment.Speed;
import com.CAIT.oinkers.enchantment.Strength;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentsInit {

	public static final DeferredRegister<Enchantment> ENCHANTMENTS = 
			DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, oinkers.MOD_ID);
	
	public static RegistryObject<Enchantment> ABSORPTION = 
			ENCHANTMENTS.register("absorption", 
					() -> new Absorption(Enchantment.Rarity.VERY_RARE,
							EnchantmentCategory.ARMOR, new EquipmentSlot[] {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}));
	
	public static RegistryObject<Enchantment> SPEED = 
			ENCHANTMENTS.register("speed", 
					() -> new Speed(Enchantment.Rarity.VERY_RARE,
							EnchantmentCategory.ARMOR, new EquipmentSlot[] {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}));
	
	public static RegistryObject<Enchantment> STRENGTH = 
			ENCHANTMENTS.register("strength", 
					() -> new Strength(Enchantment.Rarity.VERY_RARE,
							EnchantmentCategory.ARMOR, new EquipmentSlot[] {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}));
	
	public static RegistryObject<Enchantment> ATIUM_LIGHT = 
			ENCHANTMENTS.register("atium_light", 
					() -> new AtiumLight(Enchantment.Rarity.VERY_RARE,
							EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
	public static RegistryObject<Enchantment> ATIUM_FIRE = 
			ENCHANTMENTS.register("atium_fire", 
					() -> new AtiumFire(Enchantment.Rarity.VERY_RARE,
							EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
	public static RegistryObject<Enchantment> ATIUM_SPRING = 
			ENCHANTMENTS.register("atium_spring", 
					() -> new AtiumSpring(Enchantment.Rarity.VERY_RARE,
							EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
	
	
	public static void register(IEventBus bus) {
		ENCHANTMENTS.register(bus);
	}
}
