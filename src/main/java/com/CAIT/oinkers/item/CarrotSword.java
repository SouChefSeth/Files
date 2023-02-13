package com.CAIT.oinkers.item;

import com.CAIT.oinkers.init.ModEffectsInit;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class CarrotSword extends SwordItem {

	public CarrotSword(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);
	}
	
	@Override
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
		target.addEffect(new MobEffectInstance((ModEffectsInit.CARROT_THIRST.get()), 200), target);
		return super.hurtEnemy(itemStack, target, attacker);
	}

}
