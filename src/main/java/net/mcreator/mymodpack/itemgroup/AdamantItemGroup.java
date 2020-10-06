
package net.mcreator.mymodpack.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.mymodpack.block.AdamantOreBlock;
import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class AdamantItemGroup extends MyModpackElements.ModElement {
	public AdamantItemGroup(MyModpackElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabadamant") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AdamantOreBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
