package com.CAIT.oinkers.enchantment;

import com.CAIT.oinkers.init.ItemInit;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class AtiumSpring extends Enchantment {

	public AtiumSpring(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot... slot) {
		super(p_44676_, p_44677_, slot);
	}

	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		return false;
	}

	@Override
	public boolean canEnchant(ItemStack item) {
		if (item.getItem() == ItemInit.ATIUM_ROD_OF_SPRING.get()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isDiscoverable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return false;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}

	@Override
	public boolean isAllowedOnBooks() {
		return false;
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}



}