package net.mcreator.mymodpack.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.mymodpack.MyModpackVariables;
import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class Home1CommandExecutedProcedure extends MyModpackElements.ModElement {
	public Home1CommandExecutedProcedure(MyModpackElements instance) {
		super(instance, 68);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Home1CommandExecuted!");
			return;
		}
		World world = (World) dependencies.get("world");
		if (!world.isRemote && world.getServer() != null) {
			world.getServer().getCommandManager()
					.handleCommand(new CommandSource(ICommandSource.field_213139_a_,
							new Vec3d((MyModpackVariables.MapVariables.get(world).home1x), (MyModpackVariables.MapVariables.get(world).home1y),
									(MyModpackVariables.MapVariables.get(world).home1z)),
							Vec2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
							"tp @p");
		}
	}
}
