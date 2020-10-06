package net.mcreator.mymodpack.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.mymodpack.item.GreenAdamantFragmentItem;
import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class GreenAdamantOreDropsProcedure extends MyModpackElements.ModElement {
	public GreenAdamantOreDropsProcedure(MyModpackElements instance) {
		super(instance, 51);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GreenAdamantOreDrops!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() < 0.2)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(GreenAdamantFragmentItem.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Blocks.DIRT, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
