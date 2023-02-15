package com.CAIT.oinkers.integration;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.init.BlockInit;
import com.CAIT.oinkers.recipe.CarrotForgeRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class CarrotForgeRecipeCatagory implements IRecipeCategory<CarrotForgeRecipe>{
	
	public final static ResourceLocation UID = new ResourceLocation(oinkers.MOD_ID, "carrot_forging");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(oinkers.MOD_ID, "textures/gui/carrot_forge_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public CarrotForgeRecipeCatagory(IGuiHelper helper) {
    	this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
    	this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockInit.CARROT_FORGE.get()));
    }
    
    
@Override
public RecipeType<CarrotForgeRecipe> getRecipeType() {
	// TODO Auto-generated method stub
	return JEIoinkersModPlugin.FORGE_TYPE;
}

@Override
public Component getTitle() {
	// TODO Auto-generated method stub
	return Component.literal("Carrot Forge");
	
}

@Override
public IDrawable getBackground() {
	// TODO Auto-generated method stub
	return this.background;
}

@Override
public IDrawable getIcon() {
	// TODO Auto-generated method stub
	return this.icon;
}

@Override
public void setRecipe(IRecipeLayoutBuilder builder, CarrotForgeRecipe recipe, IFocusGroup focuses) {
	
	builder.addSlot(RecipeIngredientRole.INPUT, 86, 15).addIngredients(recipe.getIngredients().get(0));
	builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 60).addItemStack(recipe.getResultItem());
	
}

}
