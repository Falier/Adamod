
package net.mcreator.mymodpack.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.mymodpack.itemgroup.AdamantItemGroup;
import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class AdamantAxeItem extends MyModpackElements.ModElement {
	@ObjectHolder("mymodpack:adamantaxe")
	public static final Item block = null;
	public AdamantAxeItem(MyModpackElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3000;
			}

			public float getEfficiency() {
				return 20f;
			}

			public float getAttackDamage() {
				return 28f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(AdamantIngotsItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(AdamantItemGroup.tab)) {
		}.setRegistryName("adamantaxe"));
	}
}
