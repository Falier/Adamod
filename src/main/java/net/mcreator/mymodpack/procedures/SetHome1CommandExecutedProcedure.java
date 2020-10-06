package net.mcreator.mymodpack.procedures;

import net.minecraft.world.World;

import net.mcreator.mymodpack.MyModpackVariables;
import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class SetHome1CommandExecutedProcedure extends MyModpackElements.ModElement {
	public SetHome1CommandExecutedProcedure(MyModpackElements instance) {
		super(instance, 67);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SetHome1CommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SetHome1CommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SetHome1CommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SetHome1CommandExecuted!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		MyModpackVariables.MapVariables.get(world).home1x = (double) x;
		MyModpackVariables.MapVariables.get(world).syncData(world);
		MyModpackVariables.MapVariables.get(world).home1y = (double) y;
		MyModpackVariables.MapVariables.get(world).syncData(world);
		MyModpackVariables.MapVariables.get(world).home1z = (double) z;
		MyModpackVariables.MapVariables.get(world).syncData(world);
	}
}
