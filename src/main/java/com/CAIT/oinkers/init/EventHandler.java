package com.CAIT.oinkers.init;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
	
	@SubscribeEvent
	public void breakItem(PlayerDestroyItemEvent event) {	// When item broke
		Player player = event.getEntity();
		if (event.getOriginal().getItem().equals(ItemInit.CARROT_SHANK.get())) {	// If Carrot Shank give player stick
			player.addItem(new ItemStack(Items.STICK));
		}
	}
	@SubscribeEvent
	public void playerHurt(LivingHurtEvent event) {	// Player hurt (before damage calculations)
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if ((player.getInventory().getArmor(0).getItem() == ItemInit.LEVITATING_BOOTS.get()) && (event.getSource().isFall())) {
				// If levitating boots and taking fall damage
				event.setCanceled(true);	// Cancel damage
				player.getInventory().getArmor(0).hurtAndBreak(1, player, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.FEET));
			}
		}
	}
	
}
