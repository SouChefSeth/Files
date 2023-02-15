package com.CAIT.oinkers.recipe;

import org.jetbrains.annotations.Nullable;

import com.CAIT.oinkers.oinkers;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class CarrotForgeRecipe implements Recipe<SimpleContainer>{

	private final ResourceLocation id;
	private final ItemStack output;
	private final NonNullList<Ingredient> recipeItems;

	public CarrotForgeRecipe(ResourceLocation id, ItemStack stack, NonNullList<Ingredient> recipeItems) {
		this.id = id;
		this.output = stack;
		this.recipeItems = recipeItems;
	}
	
	@Override
	public boolean matches(SimpleContainer container, Level level) {
		if(level.isClientSide()) {
			return false;
		}
		boolean firstSlot = recipeItems.get(0).test(container.getItem(1));
		
		
		if(firstSlot) {
			return true;
		}
		else 
			return false;
	}
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}

	@Override
	public ItemStack assemble(SimpleContainer container) {
		// TODO Auto-generated method stub
		return output;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		// TODO Auto-generated method stub
		return output.copy();
	}

	@Override
	public ResourceLocation getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		// TODO Auto-generated method stub
		return Serializer.INSTANCE;
	}

	@Override
	public RecipeType<?> getType() {
		// TODO Auto-generated method stub
		return Type.INSTANCE;
	}
	
	public static class Type implements RecipeType<CarrotForgeRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "carrot_forging";
    }
	public static class Serializer implements RecipeSerializer<CarrotForgeRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(oinkers.MOD_ID, "carrot_forging");

        @Override
        public CarrotForgeRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new CarrotForgeRecipe(pRecipeId, output, inputs);
        }

        @Override
        public @Nullable CarrotForgeRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new CarrotForgeRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CarrotForgeRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }
    }
	
	
}
