package com.CAIT.oinkers.entity.client;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.entity.custom.WigglerEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WigglerRenderer extends GeoEntityRenderer<WigglerEntity>{

	public WigglerRenderer(Context renderManager) {
		super(renderManager, new WigglerModel());
		this.shadowRadius = 1;
	}
	
	@Override
	public ResourceLocation getTextureLocation(WigglerEntity animatable) {
		// TODO Auto-generated method stub
		return new ResourceLocation(oinkers.MOD_ID, "textures/entity/wiggler/wiggler.png");
	}
	
	@Override
	public RenderType getRenderType(WigglerEntity animatable, float partialTick, PoseStack poseStack,
			MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		poseStack.scale(3.2f, 3.2f, 3.2f);	// Scale model
		return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
	}

}
