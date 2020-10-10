package net.mcreator.mymodpack.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mymodpack.item.StrawberryItem;
import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class StrawberryCowEntityIsHurtProcedure extends MyModpackElements.ModElement {
	public StrawberryCowEntityIsHurtProcedure(MyModpackElements instance) {
		super(instance, 45);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure StrawberryCowEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(StrawberryItem.block, (int) (1));
			_setstack.setCount(3);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
	}
}
