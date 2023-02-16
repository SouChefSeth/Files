package com.CAIT.oinkers.item;

import com.CAIT.oinkers.init.EnchantmentsInit;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class AtiumRod extends SwordItem {

	public AtiumRod(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if (!(level.isClientSide())) {
			if ((player.getMainHandItem().getAllEnchantments().containsKey(EnchantmentsInit.ATIUM_LIGHT.get()))) {
				ServerLevel world = ((ServerLevel) ((LivingEntity)player).level);
				HitResult block = player.pick(20D, 0F, false);
				HitResult fluid = player.pick(20D, 0F, true);
				BlockPos pos = null;
				if (block.getType() == HitResult.Type.BLOCK) {
					pos = ((BlockHitResult)block).getBlockPos();
				}
				else if (fluid.getType() == HitResult.Type.BLOCK) {
					pos = ((BlockHitResult)fluid).getBlockPos();
				}
				else if (block.getType() == HitResult.Type.ENTITY) {
					Vec3 vec = ((EntityHitResult)block).getLocation();
					pos = new BlockPos(vec.x(), vec.y(), vec.z());
				}
				if (player.getMainHandItem().getAllEnchantments().get(EnchantmentsInit.ATIUM_LIGHT.get()) == 1) {
					EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
					EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
					// 3 sec
					player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 60);
				}
				else if (player.getMainHandItem().getAllEnchantments().get(EnchantmentsInit.ATIUM_LIGHT.get()) == 2) {
					EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
					EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
					EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
					// 2 sec
					player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 40);
				}
				else {
					EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
					EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
					EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
					EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
					// 1 sec
					player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 20);
				}
				player.getMainHandItem().hurtAndBreak(1, player, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.MAINHAND));
			}
			else if ((player.getMainHandItem().getAllEnchantments().containsKey(EnchantmentsInit.ATIUM_FIRE.get())) && 0==0) {
				ServerLevel world = ((ServerLevel) ((LivingEntity)player).level);
				HitResult block = player.pick(20D, 0F, false);
				HitResult fluid = player.pick(20D, 0F, true);
				BlockPos pos = null;
				if (block.getType() == HitResult.Type.BLOCK) {
					pos = ((BlockHitResult)block).getBlockPos();
				}
				else if (fluid.getType() == HitResult.Type.BLOCK) {
					pos = ((BlockHitResult)fluid).getBlockPos();
				}
				else if (block.getType() == HitResult.Type.ENTITY) {
					Vec3 vec = ((EntityHitResult)block).getLocation();
					pos = new BlockPos(vec.x(), vec.y(), vec.z());
				}
				else if (block.getType() == HitResult.Type.MISS) {
					pos = ((BlockHitResult)block).getBlockPos();
				}
				if (player.getMainHandItem().getAllEnchantments().get(EnchantmentsInit.ATIUM_FIRE.get()) == 1) {
	                  Vec3 vec3 = player.getViewVector(1.0F);
	                  double d2 = pos.getX() - (player.getX() + vec3.x * 4.0D);
	                  double d3 = pos.getY() - (0.5D + player.getY());
	                  double d4 = pos.getZ() - (player.getZ() + vec3.z * 4.0D);
	                  LargeFireball largefireball = new LargeFireball(level, player, d2, d3, d4, 1);
	                  largefireball.setPos(player.getX() + vec3.x * 4.0D, player.getY() + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
	                  level.addFreshEntity(largefireball);
	                  // 3 sec
	                  player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 60);
				}
				else if (player.getMainHandItem().getAllEnchantments().get(EnchantmentsInit.ATIUM_FIRE.get()) == 2) {
					Vec3 vec3 = player.getViewVector(1.0F);
		            double d2 = pos.getX() - (player.getX() + vec3.x * 4.0D);
		            double d3 = pos.getY() - (0.5D + player.getY());
		            double d4 = pos.getZ() - (player.getZ() + vec3.z * 4.0D);
		            LargeFireball largefireball = new LargeFireball(level, player, d2, d3, d4, 2);
		            largefireball.setPos(player.getX() + vec3.x * 4.0D, player.getY() + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
		            level.addFreshEntity(largefireball);
		            // 2 sec
		            player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 40);
				}
				else {
					Vec3 vec3 = player.getViewVector(1.0F);
		            double d2 = pos.getX() - (player.getX() + vec3.x * 4.0D);
		            double d3 = pos.getY() - (0.5D + player.getY());
		            double d4 = pos.getZ() - (player.getZ() + vec3.z * 4.0D);
		            LargeFireball largefireball = new LargeFireball(level, player, d2, d3, d4, 3);
		            largefireball.setPos(player.getX() + vec3.x * 4.0D, player.getY() + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
		            level.addFreshEntity(largefireball);
		            level.addFreshEntity(largefireball);
		            // 1 sec
		            player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 20);
				}
				player.getMainHandItem().hurtAndBreak(1, player, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.MAINHAND));
			}
			else {
				return super.use(level, player, hand);
			}
		}
		return super.use(level, player, hand);
	}

}
