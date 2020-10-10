package net.mcreator.mymodpack.procedures;

import net.minecraft.world.GameType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class GM1CommandExecutedProcedure extends MyModpackElements.ModElement {
	public GM1CommandExecutedProcedure(MyModpackElements instance) {
		super(instance, 60);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GM1CommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).setGameType(GameType.CREATIVE);
	}
}
