package net.mcreator.dohess.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CadetTimerDownProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.world);
		}
	}

	public static void execute(IWorld world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, IWorld world) {
		if (DohessModVariables.WorldVariables.get(world).PauseTimerCadets == true) {
			if (world instanceof ServerWorld) {
				IWorld _worldorig = world;
				world = ((ServerWorld) world).getServer().getWorld(World.OVERWORLD);
				if (world != null) {
					DohessModVariables.WorldVariables.get(world).CadetTimerNumber = DohessModVariables.WorldVariables.get(world).CadetTimerNumber - 0.05;
					DohessModVariables.WorldVariables.get(world).syncData(world);
					if (world instanceof ServerWorld)
						((ServerWorld) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
								("bossbar set minecraft:69 name [\"\",{\"text\":\"Cadet Timer: \",\"color\":\"gold\"},{\"text\":\"" + "" + new java.text.DecimalFormat("##").format(DohessModVariables.WorldVariables.get(world).CadetTimerNumber)
										+ "\",\"color\":\"aqua\"}]"));
					if (world instanceof ServerWorld)
						((ServerWorld) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
								("bossbar set minecraft:69 value " + new java.text.DecimalFormat("##").format(DohessModVariables.WorldVariables.get(world).CadetTimerNumber)));
				}
				world = _worldorig;
			}
		}
		if (0 > DohessModVariables.WorldVariables.get(world).CadetTimerNumber) {
			if (world instanceof ServerWorld)
				((ServerWorld) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
						"bossbar remove minecraft:69");
		}
	}
}