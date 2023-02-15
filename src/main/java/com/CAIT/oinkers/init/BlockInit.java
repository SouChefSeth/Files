package com.CAIT.oinkers.init;

import java.util.function.Function;

import com.CAIT.oinkers.oinkers;
import com.CAIT.oinkers.block.custom.CarrotForgeBlock;
import com.CAIT.oinkers.block.custom.CarrotInfusingStationBlock;
import com.CAIT.oinkers.block.custom.DiamondCarrotBlock;
import com.CAIT.oinkers.block.custom.GoldCarrotBlock;
import com.CAIT.oinkers.block.custom.IronCarrotBlock;
import com.CAIT.oinkers.block.custom.ModFlammableRotatedPillarBlock;
import com.CAIT.oinkers.block.custom.StoneCarrotBlock;
import com.CAIT.oinkers.world.feature.tree.CarrotTreeGrower;
import com.google.common.base.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, oinkers.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
	
	
	public static final RegistryObject<Block> CARROT_GRASS = register("carrot_grass", () -> new GrassBlock
			(BlockBehaviour.Properties.of(
					Material.DIRT, 
					MaterialColor.COLOR_BROWN)
					.strength(1.0f)
					.sound(SoundType.ROOTED_DIRT)
					), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	
	public static final RegistryObject<Block> CARROT_DIRT = register("carrot_dirt", () -> new Block
			(BlockBehaviour.Properties.of(
					Material.DIRT, 
					MaterialColor.COLOR_BROWN)
					.strength(1.0f)
					.sound(SoundType.ROOTED_DIRT)
					), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	public static final RegistryObject<FarmBlock> CARROT_FARMLAND = register("carrot_farmland", () -> new FarmBlock(
			BlockBehaviour.Properties.copy(Blocks.FARMLAND)),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	
	public static final RegistryObject<Block> CARROT_STONE = register("carrot_stone", () -> new Block
			(BlockBehaviour.Properties.copy(Blocks.STONE)), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	public static final RegistryObject<Block> CARROT_COBBLESTONE = register("carrot_cobblestone", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
		
	
	
	public static final RegistryObject<Block> CARROT_LOG = register("carrot_log", () -> new ModFlammableRotatedPillarBlock
			(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<Block> CARROT_WOOD = register("carrot_wood", () -> new ModFlammableRotatedPillarBlock
			(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).requiresCorrectToolForDrops()), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<Block> STRIPPED_CARROT_LOG = register("stripped_carrot_log", () -> new ModFlammableRotatedPillarBlock
			(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).requiresCorrectToolForDrops()), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<Block> STRIPPED_CARROT_WOOD = register("stripped_carrot_wood", () -> new ModFlammableRotatedPillarBlock
			(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).requiresCorrectToolForDrops()), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	
	public static final RegistryObject<Block> CARROT_PLANKS = register("carrot_planks", () -> new Block
			(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops()) {
		
		
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }
        
        
    },	object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	public static final RegistryObject<Block> CARROT_LEAVES = register("carrot_leaves", () -> new LeavesBlock
			(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops()){
				
				
		        @Override
		        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		            return true;
		        }

		        @Override
		        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		            return 30;
		        }

		        @Override
		        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		            return 60;
		        }
		        
		        
		    }, 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	public static final RegistryObject<Block> CARROT_SAPLING = register("carrot_sapling", () -> new SaplingBlock
			(new CarrotTreeGrower() ,BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), 
					object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	// Carrot block
	public static final RegistryObject<Block> CARROT_BLOCK = register("carrot_block", () -> new Block(BlockBehaviour.Properties.of(
			Material.HEAVY_METAL,
			MaterialColor.COLOR_ORANGE)
			.strength(7)), 
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	
	
	// Carrot Juice
	public static final RegistryObject<LiquidBlock> PIG_JUICE_BLOCK = BLOCKS.register("pig_juice_block", 
			() -> new LiquidBlock(FluidInit.PIG_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
	
	
	public static final RegistryObject<Block> ATIUM_ORE = register("atium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops()), 
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	public static final RegistryObject<Block> ATIUM_BLOCK = register("atium_block", () -> new Block(BlockBehaviour.Properties.of(
			Material.METAL,
			MaterialColor.COLOR_LIGHT_BLUE)
			.strength(5)), 
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	
	// Custom Entity Block
	public static final RegistryObject<Block> CARROT_INFUSING_STATION = register("carrot_infusing_station", 
			() -> new CarrotInfusingStationBlock(BlockBehaviour.Properties.of(Material.METAL)
					.strength(6f)
					.noOcclusion()
					.requiresCorrectToolForDrops()), 
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	public static final RegistryObject<Block> CARROT_FORGE = register("carrot_forge", 
			() -> new CarrotForgeBlock(BlockBehaviour.Properties.of(Material.METAL)
					.strength(6f)
					.noOcclusion()
					.requiresCorrectToolForDrops()), 
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(oinkers.TAB)));
	
	
	// Carrot Crops
	
	public static final RegistryObject<Block> STONE_CARROT_PLANT = registerBlockWithoutBlockItem("stone_carrot_plant",
            () -> new StoneCarrotBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion()));
    public static final RegistryObject<Block> IRON_CARROT_PLANT = registerBlockWithoutBlockItem("iron_carrot_plant",
            () -> new IronCarrotBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion()));
    public static final RegistryObject<Block> GOLD_CARROT_PLANT = registerBlockWithoutBlockItem("gold_carrot_plant",
            () -> new GoldCarrotBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion()));
    public static final RegistryObject<Block> DIAMOND_CARROT_PLANT = registerBlockWithoutBlockItem("diamond_carrot_plant",
            () -> new DiamondCarrotBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion()));
	
	
	
	
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
    
    
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}
	
	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends  Item>> item) {
		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name, item.apply(obj));
		
		return (obj);
	}	
	
}
