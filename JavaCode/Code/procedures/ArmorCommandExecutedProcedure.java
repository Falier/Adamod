package net.mcreator.mymodpack.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mymodpack.item.AdamantArmorItem;
import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class ArmorCommandExecutedProcedure extends MyModpackElements.ModElement {
	public ArmorCommandExecutedProcedure(MyModpackElements instance) {
		super(instance, 64);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ArmorCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(1, new ItemStack(AdamantArmorItem.helmet, (int) (1)));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(2, new ItemStack(AdamantArmorItem.body, (int) (1)));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(3, new ItemStack(AdamantArmorItem.legs, (int) (1)));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(4, new ItemStack(AdamantArmorItem.boots, (int) (1)));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */
	}
}
