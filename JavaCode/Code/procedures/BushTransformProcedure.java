package net.mcreator.mymodpack.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.mymodpack.block.StrawberryBushBlock;
import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class BushTransformProcedure extends MyModpackElements.ModElement {
	public BushTransformProcedure(MyModpackElements instance) {
		super(instance, 44);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BushTransform!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BushTransform!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BushTransform!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BushTransform!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), StrawberryBushBlock.block.getDefaultState(), 3);
	}
}
