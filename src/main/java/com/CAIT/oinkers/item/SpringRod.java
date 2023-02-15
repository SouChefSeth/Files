package com.CAIT.oinkers.item;

import com.CAIT.oinkers.init.EnchantmentsInit;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SpringRod extends BowItem {

	public SpringRod(Properties p_40660_) {
		super(p_40660_);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level p_40672_, Player p_40673_, InteractionHand p_40674_) {
		ItemStack itemstack = p_40673_.getItemInHand(p_40674_);
	      boolean flag = true;
	      InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, p_40672_, p_40673_, p_40674_, flag);
	      if (ret != null) return ret;

	      if (!p_40673_.getAbilities().instabuild && !flag) {
	         return InteractionResultHolder.fail(itemstack);
	      } else {
	         p_40673_.startUsingItem(p_40674_);
	         return InteractionResultHolder.consume(itemstack);
	      }
	}

	@Override
	public void releaseUsing(ItemStack item, Level level, LivingEntity entity, int amplifier) {
		if (item.getAllEnchantments().containsKey(EnchantmentsInit.ATIUM_SPRING.get())) {
			Player player = (Player)entity;
			Vec3 vec3 = player.getViewVector(1f);
			float magnitude = BowItem.getPowerForTime(this.getUseDuration(item) - amplifier);
			if (magnitude < 0.3) {
				magnitude = 0.3f;
			}
			if ((item.getAllEnchantments().get(EnchantmentsInit.ATIUM_SPRING.get())) == 1) {
				magnitude *= 0.333;
			}
			else if ((item.getAllEnchantments().get(EnchantmentsInit.ATIUM_SPRING.get())) == 2) {
				magnitude *= 0.666;
			}
			if (player.getY() > 128) {
				vec3 = vec3.multiply(magnitude, 0, magnitude);
			}
			else {
				vec3 = vec3.multiply(magnitude, magnitude*0.75, magnitude);
			}
			vec3 = vec3.multiply(5, 5, 5);
			player.setDeltaMovement(vec3);
			item.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.MAINHAND));
		}	
	}

	@Override
	public AbstractArrow customArrow(AbstractArrow arrow) {
		return null;
	}
}