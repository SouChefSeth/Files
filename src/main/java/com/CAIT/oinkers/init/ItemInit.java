 package com.CAIT.oinkers.init;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.armor.CarrotArmor;
import com.CAIT.oinkers.item.AtiumRod;
import com.CAIT.oinkers.item.CarrotShank;
import com.CAIT.oinkers.item.FlyingBoatItem;
import com.CAIT.oinkers.item.LevitatingBoots;
import com.CAIT.oinkers.item.ModArmorMaterials;
import com.CAIT.oinkers.item.ModTiers;
import com.CAIT.oinkers.item.SpringRod;
import com.google.common.base.Supplier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, oinkers.MOD_ID);
	
	public static final RegistryObject<Item> CARROT_SHANK = register("carrot_shank", 
			() -> new CarrotShank(Tiers.GOLD, 3, 0.75f, new Item.Properties().tab(oinkers.TAB).fireResistant().stacksTo(1).durability(8)
					.food(new FoodProperties.Builder().nutrition(6).saturationMod(2).build())));
	
	
	/**
	 * Various carrots
	 */
	public static final RegistryObject<Item> SWEET_POTATO = register("sweet_potato", 
			() -> new Item(new Item.Properties().tab(oinkers.TAB).food(new FoodProperties.Builder().nutrition(20).saturationMod(10)
					.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2000, 5), 1)
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2000, 5), 1)
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2000, 5), 1)
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2000, 5), 1)
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2000, 50), 1)
					.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 2000, 5), 1)
					.alwaysEat()
					.build()).fireResistant().stacksTo(100)));
	public static final RegistryObject<Item> STONE_CARROT = register("stone_carrot", () -> new ItemNameBlockItem(BlockInit.STONE_CARROT_PLANT.get(), 
			new Item.Properties().tab(oinkers.TAB).food(new FoodProperties.Builder().nutrition(4).saturationMod(2.5f)
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 0), 1)
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1)
					.effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0) , 1)
					.alwaysEat().build())));
	
	public static final RegistryObject<Item> IRON_CARROT = register("iron_carrot", 
			() -> new ItemNameBlockItem(BlockInit.IRON_CARROT_PLANT.get(), 
					new Item.Properties().tab(oinkers.TAB).food(new FoodProperties.Builder().nutrition(6).saturationMod(2.5f)
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1), 1).alwaysEat().build())));
	
	public static final RegistryObject<Item> GOLD_CARROT = register("gold_carrot", 
			() -> new ItemNameBlockItem(BlockInit.GOLD_CARROT_PLANT.get(), new Item.Properties().tab(oinkers.TAB).food(new FoodProperties.Builder()
					.nutrition(8)
					.saturationMod(2.5f)
					.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1)
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1)
					.alwaysEat().build())));
	
	public static final RegistryObject<Item> DIAMOND_CARROT = register("diamond_carrot", 
			() -> new ItemNameBlockItem(BlockInit.DIAMOND_CARROT_PLANT.get(), new Item.Properties().tab(oinkers.TAB).food(new FoodProperties.Builder()
					.nutrition(10)
					.saturationMod(2.5f)
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1), 1)
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1)
					.alwaysEat().build())));
	
	/**
	 * Atium ore
	 */
	public static final RegistryObject<Item> ATIUM_GEM = register("atium_gem", () -> new Item(new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<Item> ATIUM_NUGGET = register("atium_nugget", () -> new Item(new Item.Properties().tab(oinkers.TAB)));
	
	/**
	 * Atium tools
	 */
	public static final RegistryObject<SwordItem> ATIUM_SWORD = register("atium_sword", 
			() -> new SwordItem(ModTiers.ATIUM, 7, .5f, new Item.Properties().tab(oinkers.TAB)));	// first int attack dam, second is speed
	public static final RegistryObject<PickaxeItem> ATIUM_PICK = register("atium_pick",
			() -> new PickaxeItem(ModTiers.ATIUM, 3, .5f, new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<ShovelItem> ATIUM_SHOVEL = register("atium_shovel",
			() -> new ShovelItem(ModTiers.ATIUM, 1.5f, .5f, new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<AxeItem> ATIUM_AXE = register("atium_axe",
			() -> new AxeItem(ModTiers.ATIUM, 11, .3f, new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<HoeItem> ATIUM_HOE = register("atium_hoe",		// <---- Seth
			() -> new HoeItem(ModTiers.ATIUM, 1, .5f, new Item.Properties().tab(oinkers.TAB)));
	
	public static final RegistryObject<Item> ATIUM_ROD_OF_LIGHT = register("atium_rod_of_light", 
			() -> new AtiumRod(ModTiers.ATIUM, 0, .15f, new Item.Properties().tab(oinkers.TAB).durability(150)));	
	public static final RegistryObject<SwordItem> ATIUM_ROD_OF_FIRE = register("atium_rod_of_fire", 
			() -> new AtiumRod(ModTiers.ATIUM, 0, .15f, new Item.Properties().tab(oinkers.TAB).durability(150)));	
	public static final RegistryObject<Item> ATIUM_ROD_OF_SPRING = register("atium_rod_of_spring", 
			() -> new SpringRod(new Item.Properties().tab(oinkers.TAB).durability(150)));	



	/**
	 * Atium Armor
	 */
	public static final RegistryObject<ArmorItem> ATIUM_HELMET = register("atium_helmet",		
			() -> new ArmorItem(ModArmorMaterials.ATIUM, EquipmentSlot.HEAD, 
			new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<ArmorItem> ATIUM_CHEST = register("atium_chest",		
			() -> new ArmorItem(ModArmorMaterials.ATIUM, EquipmentSlot.CHEST, 
			new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<ArmorItem> ATIUM_LEGS = register("atium_legs",		
			() -> new ArmorItem(ModArmorMaterials.ATIUM, EquipmentSlot.LEGS, 
			new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<ArmorItem> ATIUM_BOOTS = register("atium_boots",		
			() -> new ArmorItem(ModArmorMaterials.ATIUM, EquipmentSlot.FEET, 
			new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<ArmorItem> LEVITATING_BOOTS = register("levitating_boots",		
			() -> new LevitatingBoots(ArmorMaterials.LEATHER, EquipmentSlot.FEET, 
			new Item.Properties().tab(oinkers.TAB).durability(65)));
	
	
	
	/**
	 * Carrot ore
	 */
	public static final RegistryObject<Item> CARROT_SHARD = register("carrot_shard", () -> new Item(new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<Item> CARROT_INGOT = register("carrot_ingot", () -> new Item(new Item.Properties().tab(oinkers.TAB)));
	
	
	/**
	 * Carrot tools
	 */
	public static final RegistryObject<SwordItem> CARROT_SWORD = register("carrot_sword", 
			() -> new SwordItem(ModTiers.CARROT, 8, .5f, new Item.Properties().tab(oinkers.TAB)));	// first int attack dam, second is speed
	public static final RegistryObject<PickaxeItem> CARROT_PICK = register("carrot_pick",
			() -> new PickaxeItem(ModTiers.CARROT, 4, .5f, new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<ShovelItem> CARROT_SHOVEL = register("carrot_shovel",	
			() -> new ShovelItem(ModTiers.CARROT, 2, .5f, new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<AxeItem> CARROT_AXE = register("carrot_axe",
			() -> new AxeItem(ModTiers.CARROT, 10, .3f, new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<HoeItem> CARROT_HOE = register("carrot_hoe",		// <---- Seth
			() -> new HoeItem(ModTiers.CARROT, 2, .5f, new Item.Properties().tab(oinkers.TAB)));
	
	/**
	 * Carrot armor
	 */
	public static final RegistryObject<CarrotArmor> CARROT_HELMET = register("carrot_helmet",		
			() -> new CarrotArmor(ModArmorMaterials.CARROT, EquipmentSlot.HEAD, 
			new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<CarrotArmor> CARROT_CHEST = register("carrot_chest",		
			() -> new CarrotArmor(ModArmorMaterials.CARROT, EquipmentSlot.CHEST, 
			new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<CarrotArmor> CARROT_LEGS = register("carrot_legs",		
			() -> new CarrotArmor(ModArmorMaterials.CARROT, EquipmentSlot.LEGS, 
			new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<CarrotArmor> CARROT_BOOTS = register("carrot_boots",		
			() -> new CarrotArmor(ModArmorMaterials.CARROT, EquipmentSlot.FEET, 
			new Item.Properties().tab(oinkers.TAB)));
	
	// Fluid Buckets
	public static final RegistryObject<Item> PIG_JUICE_BUCKET = ITEMS.register("pig_juice_bucket", 
			() -> new BucketItem(FluidInit.PIG_JUICE, 
					new Item.Properties().tab(oinkers.TAB).craftRemainder(Items.BUCKET).stacksTo(1)));
	
	public static final RegistryObject<Item> FLYING_BOAT_ITEM = ITEMS.register("flying_boat_item",
            () -> new FlyingBoatItem(new Item.Properties().tab(oinkers.TAB)));
	
	
	/**
	 * Spawn Eggs
	 */
	public static final RegistryObject<ForgeSpawnEggItem> WIGGLER_SPAWN_EGG = ITEMS.register("wiggler_spawn_egg", 
			() -> new ForgeSpawnEggItem(ModEntityTypes.WIGGLER, 25514528, 25518348, 
					new Item.Properties().tab(oinkers.TAB)));
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}
	
}
