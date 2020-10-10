
package net.mcreator.mymodpack.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.mymodpack.itemgroup.AdamantItemGroup;
import net.mcreator.mymodpack.MyModpackElements;

import java.util.List;
import java.util.Collections;

@MyModpackElements.ModElement.Tag
public class OreWoodBlock extends MyModpackElements.ModElement {
	@ObjectHolder("mymodpack:orewood")
	public static final Block block = null;
	public OreWoodBlock(MyModpackElements instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(AdamantItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends FallingBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(5f, 10f).lightValue(0).harvestLevel(3)
					.harvestTool(ToolType.AXE));
			setRegistryName("orewood");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Blocks.IRON_ORE, (int) (1)));
		}
	}
}
