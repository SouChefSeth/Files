package com.CAIT.oinkers.init;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
}
