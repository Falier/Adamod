
package net.mcreator.mymodpack.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.mymodpack.itemgroup.AdamantItemGroup;
import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class AdamantSwordItem extends MyModpackElements.ModElement {
	@ObjectHolder("mymodpack:adamantsword")
	public static final Item block = null;
	public AdamantSwordItem(MyModpackElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 3000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 18f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(AdamantIngotsItem.block, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(AdamantItemGroup.tab)) {
		}.setRegistryName("adamantsword"));
	}
}
