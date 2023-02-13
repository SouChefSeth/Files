package com.CAIT.oinkers.item;

import com.CAIT.oinkers.init.ItemInit;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
	
	public static final Tier CARROT = new ForgeTier(
			6,
			1561,
			8f,
			11f,
			22,
			BlockTags.NEEDS_DIAMOND_TOOL,
			() -> Ingredient.of(ItemInit.CARROT_INGOT.get())
			);
	
	public static final Tier ATIUM = new ForgeTier(
			5,
			2100,
			8f,
			8,
			18,
			BlockTags.NEEDS_DIAMOND_TOOL,
			() -> Ingredient.of(ItemInit.ATIUM_GEM.get())
			);
}
