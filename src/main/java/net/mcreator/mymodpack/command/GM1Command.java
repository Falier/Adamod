
package net.mcreator.mymodpack.command;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;

import net.mcreator.mymodpack.procedures.GM1CommandExecutedProcedure;
import net.mcreator.mymodpack.MyModpackElements;

import java.util.HashMap;
import java.util.Arrays;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.arguments.StringArgumentType;

@MyModpackElements.ModElement.Tag
public class GM1Command extends MyModpackElements.ModElement {
	public GM1Command(MyModpackElements instance) {
		super(instance, 60);
	}

	@Override
	public void serverLoad(FMLServerStartingEvent event) {
		event.getCommandDispatcher().register(customCommand());
	}

	private LiteralArgumentBuilder<CommandSource> customCommand() {
		return LiteralArgumentBuilder.<CommandSource>literal("gm 1")
				.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(this::execute)).executes(this::execute);
	}

	private int execute(CommandContext<CommandSource> ctx) {
		Entity entity = ctx.getSource().getEntity();
		if (entity != null) {
			int x = entity.getPosition().getX();
			int y = entity.getPosition().getY();
			int z = entity.getPosition().getZ();
			World world = entity.world;
			HashMap<String, String> cmdparams = new HashMap<>();
			int[] index = {-1};
			Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
				if (index[0] >= 0)
					cmdparams.put(Integer.toString(index[0]), param);
				index[0]++;
			});
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				GM1CommandExecutedProcedure.executeProcedure($_dependencies);
			}
		}
		return 0;
	}
}
