package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class ManageRegimentSLSquadProcedure {
	public static void execute(IWorld world, CommandContext<CommandSource> arguments) {
		if (DoubleArgumentType.getDouble(arguments, "priority") == 1) {
			DohessModVariables.WorldVariables.get(world).SL1 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "squadname") + "\",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "squadhex") + "\"},";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 2) {
			DohessModVariables.WorldVariables.get(world).SL2 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "squadname") + "\",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "squadhex") + "\"},";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 3) {
			DohessModVariables.WorldVariables.get(world).SL3 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "squadname") + "\",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "squadhex") + "\"},";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 4) {
			DohessModVariables.WorldVariables.get(world).SL4 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "squadname") + "\",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "squadhex") + "\"},";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 5) {
			DohessModVariables.WorldVariables.get(world).SL5 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "squadname") + "\",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "squadhex") + "\"},";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 6) {
			DohessModVariables.WorldVariables.get(world).SL6 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "squadname") + "\",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "squadhex") + "\"},";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 7) {
			DohessModVariables.WorldVariables.get(world).SL7 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "squadname") + "\",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "squadhex") + "\"},";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 8) {
			DohessModVariables.WorldVariables.get(world).SL8 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "squadname") + "\",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "squadhex") + "\"},";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}