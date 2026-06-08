package net.mcreator.dohess.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.command.CommandSource;

import net.mcreator.dohess.network.DohessModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class ManageRegimentRankProcedure {
	public static void execute(IWorld world, CommandContext<CommandSource> arguments) {
		if (DoubleArgumentType.getDouble(arguments, "priority") == 1) {
			DohessModVariables.WorldVariables.get(world).Rank1 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 2) {
			DohessModVariables.WorldVariables.get(world).Rank2 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 3) {
			DohessModVariables.WorldVariables.get(world).Rank3 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 4) {
			DohessModVariables.WorldVariables.get(world).Rank4 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 5) {
			DohessModVariables.WorldVariables.get(world).Rank5 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 6) {
			DohessModVariables.WorldVariables.get(world).Rank6 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 7) {
			DohessModVariables.WorldVariables.get(world).Rank7 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 8) {
			DohessModVariables.WorldVariables.get(world).Rank8 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 9) {
			DohessModVariables.WorldVariables.get(world).Rank9 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 10) {
			DohessModVariables.WorldVariables.get(world).Rank10 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 11) {
			DohessModVariables.WorldVariables.get(world).Rank11 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 12) {
			DohessModVariables.WorldVariables.get(world).Rank12 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 13) {
			DohessModVariables.WorldVariables.get(world).Rank13 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 14) {
			DohessModVariables.WorldVariables.get(world).Rank14 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 15) {
			DohessModVariables.WorldVariables.get(world).Rank15 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 16) {
			DohessModVariables.WorldVariables.get(world).Rank16 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 17) {
			DohessModVariables.WorldVariables.get(world).Rank17 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 18) {
			DohessModVariables.WorldVariables.get(world).Rank18 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 19) {
			DohessModVariables.WorldVariables.get(world).Rank19 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
		if (DoubleArgumentType.getDouble(arguments, "priority") == 20) {
			DohessModVariables.WorldVariables.get(world).Rank20 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"" + "" + StringArgumentType.getString(arguments, "rankname") + ". \",\"color\":\"#"
					+ StringArgumentType.getString(arguments, "rankhex") + "\"}]";
			DohessModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}