package net.mcreator.dohess.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.Direction;
import net.minecraft.entity.Entity;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.Commands;

import net.mcreator.dohess.procedures.TCIChestGUISetProcedure;
import net.mcreator.dohess.procedures.SetTCIProcedure;
import net.mcreator.dohess.procedures.SetCadetSquadProcedure;
import net.mcreator.dohess.procedures.SetCadetRankProcedure;
import net.mcreator.dohess.procedures.SetCadetProcedure;
import net.mcreator.dohess.procedures.OpenMenuProcedure;
import net.mcreator.dohess.procedures.ManageRegimentSLSquadProcedure;
import net.mcreator.dohess.procedures.ManageRegimentRankProcedure;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

@Mod.EventBusSubscriber
public class ManageregimentCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("manageregiment").requires(s -> s.hasPermissionLevel(1)).then(Commands.literal("scouts").then(Commands.literal("ranks")
				.then(Commands.argument("rankname", StringArgumentType.string()).then(Commands.argument("rankhex", StringArgumentType.word()).then(Commands.argument("priority", DoubleArgumentType.doubleArg(1, 20)).executes(arguments -> {
					World world = arguments.getSource().getWorld();
					double x = arguments.getSource().getPos().getX();
					double y = arguments.getSource().getPos().getY();
					double z = arguments.getSource().getPos().getZ();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerWorld)
						entity = FakePlayerFactory.getMinecraft((ServerWorld) world);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getHorizontalFacing();

					ManageRegimentRankProcedure.execute(world, arguments);
					return 0;
				}))))).then(Commands.literal("squad")
						.then(Commands.argument("squadname", StringArgumentType.string()).then(Commands.argument("squadhex", StringArgumentType.word()).then(Commands.argument("priority", DoubleArgumentType.doubleArg(1, 10)).executes(arguments -> {
							World world = arguments.getSource().getWorld();
							double x = arguments.getSource().getPos().getX();
							double y = arguments.getSource().getPos().getY();
							double z = arguments.getSource().getPos().getZ();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerWorld)
								entity = FakePlayerFactory.getMinecraft((ServerWorld) world);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getHorizontalFacing();

							ManageRegimentSLSquadProcedure.execute(world, arguments);
							return 0;
						}))))))
				.then(Commands.literal("cadets").then(Commands.literal("menu").executes(arguments -> {
					World world = arguments.getSource().getWorld();
					double x = arguments.getSource().getPos().getX();
					double y = arguments.getSource().getPos().getY();
					double z = arguments.getSource().getPos().getZ();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerWorld)
						entity = FakePlayerFactory.getMinecraft((ServerWorld) world);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getHorizontalFacing();

					OpenMenuProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("setcadet").then(Commands.argument("username", EntityArgument.player()).executes(arguments -> {
					World world = arguments.getSource().getWorld();
					double x = arguments.getSource().getPos().getX();
					double y = arguments.getSource().getPos().getY();
					double z = arguments.getSource().getPos().getZ();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerWorld)
						entity = FakePlayerFactory.getMinecraft((ServerWorld) world);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getHorizontalFacing();

					SetCadetProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("settci").then(Commands.argument("username", EntityArgument.player()).then(Commands.argument("tci", BoolArgumentType.bool()).executes(arguments -> {
					World world = arguments.getSource().getWorld();
					double x = arguments.getSource().getPos().getX();
					double y = arguments.getSource().getPos().getY();
					double z = arguments.getSource().getPos().getZ();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerWorld)
						entity = FakePlayerFactory.getMinecraft((ServerWorld) world);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getHorizontalFacing();

					SetTCIProcedure.execute(arguments);
					return 0;
				})))).then(Commands.literal("setrank").then(Commands.argument("rankname", StringArgumentType.string()).then(Commands.argument("rankhex", StringArgumentType.word()).executes(arguments -> {
					World world = arguments.getSource().getWorld();
					double x = arguments.getSource().getPos().getX();
					double y = arguments.getSource().getPos().getY();
					double z = arguments.getSource().getPos().getZ();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerWorld)
						entity = FakePlayerFactory.getMinecraft((ServerWorld) world);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getHorizontalFacing();

					SetCadetRankProcedure.execute(world, arguments, entity);
					return 0;
				})))).then(Commands.literal("setsquad").then(Commands.argument("squadname", StringArgumentType.string()).then(Commands.argument("squadhex", StringArgumentType.word()).executes(arguments -> {
					World world = arguments.getSource().getWorld();
					double x = arguments.getSource().getPos().getX();
					double y = arguments.getSource().getPos().getY();
					double z = arguments.getSource().getPos().getZ();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerWorld)
						entity = FakePlayerFactory.getMinecraft((ServerWorld) world);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getHorizontalFacing();

					SetCadetSquadProcedure.execute(world, arguments, entity);
					return 0;
				})))).then(Commands.literal("setchest").then(Commands.argument("username", StringArgumentType.string()).executes(arguments -> {
					World world = arguments.getSource().getWorld();
					double x = arguments.getSource().getPos().getX();
					double y = arguments.getSource().getPos().getY();
					double z = arguments.getSource().getPos().getZ();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerWorld)
						entity = FakePlayerFactory.getMinecraft((ServerWorld) world);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getHorizontalFacing();

					TCIChestGUISetProcedure.execute(world, arguments, entity);
					return 0;
				})))));
	}

}