package net.mcreator.dohess.network;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import net.mcreator.dohess.DohessMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DohessModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		DohessMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
		DohessMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().world.isRemote())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getPlayer().world.isRemote())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().world.isRemote())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.ChangingRankSquad = original.ChangingRankSquad;
			clone.HorseColour = original.HorseColour;
			clone.HorseID = original.HorseID;
			clone.HorseName = original.HorseName;
			clone.MCPlayerColour = original.MCPlayerColour;
			clone.MCPlayerRank = original.MCPlayerRank;
			clone.MCPlayerRankPri = original.MCPlayerRankPri;
			clone.MCPlayerSquad = original.MCPlayerSquad;
			clone.MCPlayerSquadPri = original.MCPlayerSquadPri;
			clone.ModTeam = original.ModTeam;
			clone.NameVisibility = original.NameVisibility;
			clone.PDImmortal = original.PDImmortal;
			clone.PDInvisibility = original.PDInvisibility;
			clone.PDManager = original.PDManager;
			clone.PDSpeed = original.PDSpeed;
			clone.PDSpeedNO = original.PDSpeedNO;
			clone.PlayerMessage = original.PlayerMessage;
			clone.PlayerUser = original.PlayerUser;
			clone.TCI = original.TCI;
			clone.TCIHighlight = original.TCIHighlight;
			clone.VisableName = original.VisableName;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().world.isRemote()) {
				WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
				WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
				if (mapdata != null)
					DohessMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					DohessMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().world.isRemote()) {
				WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
				if (worlddata != null)
					DohessMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "dohess_worldvars";
		public ItemStack ArmyPants = ItemStack.EMPTY;
		public ItemStack ArmyShoes = ItemStack.EMPTY;
		public ItemStack CadetCape = ItemStack.EMPTY;
		public ItemStack CadetFormal = ItemStack.EMPTY;
		public ItemStack CadetJacket = ItemStack.EMPTY;
		public double CadetNo1 = 0;
		public double CadetNo2 = 0;
		public double CadetNo3 = 0;
		public double CadetNo4 = 0;
		public double CadetNo5 = 0;
		public double CadetNo6 = 0;
		public double CadetNo7 = 0;
		public double CadetNo8 = 0;
		public String CadetRank = "\"\"";
		public ItemStack CadetSlot1 = ItemStack.EMPTY;
		public ItemStack CadetSlot2 = ItemStack.EMPTY;
		public ItemStack CadetSlot3 = ItemStack.EMPTY;
		public ItemStack CadetSlot4 = ItemStack.EMPTY;
		public ItemStack CadetSlot5 = ItemStack.EMPTY;
		public ItemStack CadetSlot6 = ItemStack.EMPTY;
		public ItemStack CadetSlot7 = ItemStack.EMPTY;
		public ItemStack CadetSlot8 = ItemStack.EMPTY;
		public String CadetSquad = "";
		public String DeathMessageAnnounce = "";
		public String DeathMessageOnDeath = "";
		public String Gov1 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String Gov2 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String Gov3 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String Gov4 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String Gov5 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String Gov6 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String Gov7 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String Gov8 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String Gov9 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public double HorseDistant = 50.0;
		public double HorsesPEED = 0.5;
		public ItemStack ODMGear = ItemStack.EMPTY;
		public String OfflinePlayersRank = "";
		public double PD = 0.0;
		public String Rank1 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank10 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank11 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank12 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank13 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank14 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank15 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank16 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank17 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank18 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank19 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank2 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank20 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank3 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank4 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank5 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank6 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank7 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank8 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String Rank9 = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String SL1 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String SL2 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String SL3 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String SL4 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String SL5 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String SL6 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String SL7 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String SL8 = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public ItemStack SLCape = ItemStack.EMPTY;
		public ItemStack SLFormal = ItemStack.EMPTY;
		public ItemStack SLJacket = ItemStack.EMPTY;
		public String WrapTrost = "\"\"";
		public String WarpShig = "\"\"";
		public String WarpSLHQ = "\"\"";
		public String WarpTc = "\"\"";
		public double BladeDamage = 0;
		public boolean PauseTimerCadets = false;
		public double CadetTimerNumber = 0;

		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			ArmyPants = ItemStack.read(nbt.getCompound("ArmyPants"));
			ArmyShoes = ItemStack.read(nbt.getCompound("ArmyShoes"));
			CadetCape = ItemStack.read(nbt.getCompound("CadetCape"));
			CadetFormal = ItemStack.read(nbt.getCompound("CadetFormal"));
			CadetJacket = ItemStack.read(nbt.getCompound("CadetJacket"));
			CadetNo1 = nbt.getDouble("CadetNo1");
			CadetNo2 = nbt.getDouble("CadetNo2");
			CadetNo3 = nbt.getDouble("CadetNo3");
			CadetNo4 = nbt.getDouble("CadetNo4");
			CadetNo5 = nbt.getDouble("CadetNo5");
			CadetNo6 = nbt.getDouble("CadetNo6");
			CadetNo7 = nbt.getDouble("CadetNo7");
			CadetNo8 = nbt.getDouble("CadetNo8");
			CadetRank = nbt.getString("CadetRank");
			CadetSlot1 = ItemStack.read(nbt.getCompound("CadetSlot1"));
			CadetSlot2 = ItemStack.read(nbt.getCompound("CadetSlot2"));
			CadetSlot3 = ItemStack.read(nbt.getCompound("CadetSlot3"));
			CadetSlot4 = ItemStack.read(nbt.getCompound("CadetSlot4"));
			CadetSlot5 = ItemStack.read(nbt.getCompound("CadetSlot5"));
			CadetSlot6 = ItemStack.read(nbt.getCompound("CadetSlot6"));
			CadetSlot7 = ItemStack.read(nbt.getCompound("CadetSlot7"));
			CadetSlot8 = ItemStack.read(nbt.getCompound("CadetSlot8"));
			CadetSquad = nbt.getString("CadetSquad");
			DeathMessageAnnounce = nbt.getString("DeathMessageAnnounce");
			DeathMessageOnDeath = nbt.getString("DeathMessageOnDeath");
			Gov1 = nbt.getString("Gov1");
			Gov2 = nbt.getString("Gov2");
			Gov3 = nbt.getString("Gov3");
			Gov4 = nbt.getString("Gov4");
			Gov5 = nbt.getString("Gov5");
			Gov6 = nbt.getString("Gov6");
			Gov7 = nbt.getString("Gov7");
			Gov8 = nbt.getString("Gov8");
			Gov9 = nbt.getString("Gov9");
			HorseDistant = nbt.getDouble("HorseDistant");
			HorsesPEED = nbt.getDouble("HorsesPEED");
			ODMGear = ItemStack.read(nbt.getCompound("ODMGear"));
			OfflinePlayersRank = nbt.getString("OfflinePlayersRank");
			PD = nbt.getDouble("PD");
			Rank1 = nbt.getString("Rank1");
			Rank10 = nbt.getString("Rank10");
			Rank11 = nbt.getString("Rank11");
			Rank12 = nbt.getString("Rank12");
			Rank13 = nbt.getString("Rank13");
			Rank14 = nbt.getString("Rank14");
			Rank15 = nbt.getString("Rank15");
			Rank16 = nbt.getString("Rank16");
			Rank17 = nbt.getString("Rank17");
			Rank18 = nbt.getString("Rank18");
			Rank19 = nbt.getString("Rank19");
			Rank2 = nbt.getString("Rank2");
			Rank20 = nbt.getString("Rank20");
			Rank3 = nbt.getString("Rank3");
			Rank4 = nbt.getString("Rank4");
			Rank5 = nbt.getString("Rank5");
			Rank6 = nbt.getString("Rank6");
			Rank7 = nbt.getString("Rank7");
			Rank8 = nbt.getString("Rank8");
			Rank9 = nbt.getString("Rank9");
			SL1 = nbt.getString("SL1");
			SL2 = nbt.getString("SL2");
			SL3 = nbt.getString("SL3");
			SL4 = nbt.getString("SL4");
			SL5 = nbt.getString("SL5");
			SL6 = nbt.getString("SL6");
			SL7 = nbt.getString("SL7");
			SL8 = nbt.getString("SL8");
			SLCape = ItemStack.read(nbt.getCompound("SLCape"));
			SLFormal = ItemStack.read(nbt.getCompound("SLFormal"));
			SLJacket = ItemStack.read(nbt.getCompound("SLJacket"));
			WrapTrost = nbt.getString("WrapTrost");
			WarpShig = nbt.getString("WarpShig");
			WarpSLHQ = nbt.getString("WarpSLHQ");
			WarpTc = nbt.getString("WarpTc");
			BladeDamage = nbt.getDouble("BladeDamage");
			PauseTimerCadets = nbt.getBoolean("PauseTimerCadets");
			CadetTimerNumber = nbt.getDouble("CadetTimerNumber");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.put("ArmyPants", ArmyPants.write(new CompoundNBT()));
			nbt.put("ArmyShoes", ArmyShoes.write(new CompoundNBT()));
			nbt.put("CadetCape", CadetCape.write(new CompoundNBT()));
			nbt.put("CadetFormal", CadetFormal.write(new CompoundNBT()));
			nbt.put("CadetJacket", CadetJacket.write(new CompoundNBT()));
			nbt.putDouble("CadetNo1", CadetNo1);
			nbt.putDouble("CadetNo2", CadetNo2);
			nbt.putDouble("CadetNo3", CadetNo3);
			nbt.putDouble("CadetNo4", CadetNo4);
			nbt.putDouble("CadetNo5", CadetNo5);
			nbt.putDouble("CadetNo6", CadetNo6);
			nbt.putDouble("CadetNo7", CadetNo7);
			nbt.putDouble("CadetNo8", CadetNo8);
			nbt.putString("CadetRank", CadetRank);
			nbt.put("CadetSlot1", CadetSlot1.write(new CompoundNBT()));
			nbt.put("CadetSlot2", CadetSlot2.write(new CompoundNBT()));
			nbt.put("CadetSlot3", CadetSlot3.write(new CompoundNBT()));
			nbt.put("CadetSlot4", CadetSlot4.write(new CompoundNBT()));
			nbt.put("CadetSlot5", CadetSlot5.write(new CompoundNBT()));
			nbt.put("CadetSlot6", CadetSlot6.write(new CompoundNBT()));
			nbt.put("CadetSlot7", CadetSlot7.write(new CompoundNBT()));
			nbt.put("CadetSlot8", CadetSlot8.write(new CompoundNBT()));
			nbt.putString("CadetSquad", CadetSquad);
			nbt.putString("DeathMessageAnnounce", DeathMessageAnnounce);
			nbt.putString("DeathMessageOnDeath", DeathMessageOnDeath);
			nbt.putString("Gov1", Gov1);
			nbt.putString("Gov2", Gov2);
			nbt.putString("Gov3", Gov3);
			nbt.putString("Gov4", Gov4);
			nbt.putString("Gov5", Gov5);
			nbt.putString("Gov6", Gov6);
			nbt.putString("Gov7", Gov7);
			nbt.putString("Gov8", Gov8);
			nbt.putString("Gov9", Gov9);
			nbt.putDouble("HorseDistant", HorseDistant);
			nbt.putDouble("HorsesPEED", HorsesPEED);
			nbt.put("ODMGear", ODMGear.write(new CompoundNBT()));
			nbt.putString("OfflinePlayersRank", OfflinePlayersRank);
			nbt.putDouble("PD", PD);
			nbt.putString("Rank1", Rank1);
			nbt.putString("Rank10", Rank10);
			nbt.putString("Rank11", Rank11);
			nbt.putString("Rank12", Rank12);
			nbt.putString("Rank13", Rank13);
			nbt.putString("Rank14", Rank14);
			nbt.putString("Rank15", Rank15);
			nbt.putString("Rank16", Rank16);
			nbt.putString("Rank17", Rank17);
			nbt.putString("Rank18", Rank18);
			nbt.putString("Rank19", Rank19);
			nbt.putString("Rank2", Rank2);
			nbt.putString("Rank20", Rank20);
			nbt.putString("Rank3", Rank3);
			nbt.putString("Rank4", Rank4);
			nbt.putString("Rank5", Rank5);
			nbt.putString("Rank6", Rank6);
			nbt.putString("Rank7", Rank7);
			nbt.putString("Rank8", Rank8);
			nbt.putString("Rank9", Rank9);
			nbt.putString("SL1", SL1);
			nbt.putString("SL2", SL2);
			nbt.putString("SL3", SL3);
			nbt.putString("SL4", SL4);
			nbt.putString("SL5", SL5);
			nbt.putString("SL6", SL6);
			nbt.putString("SL7", SL7);
			nbt.putString("SL8", SL8);
			nbt.put("SLCape", SLCape.write(new CompoundNBT()));
			nbt.put("SLFormal", SLFormal.write(new CompoundNBT()));
			nbt.put("SLJacket", SLJacket.write(new CompoundNBT()));
			nbt.putString("WrapTrost", WrapTrost);
			nbt.putString("WarpShig", WarpShig);
			nbt.putString("WarpSLHQ", WarpSLHQ);
			nbt.putString("WarpTc", WarpTc);
			nbt.putDouble("BladeDamage", BladeDamage);
			nbt.putBoolean("PauseTimerCadets", PauseTimerCadets);
			nbt.putDouble("CadetTimerNumber", CadetTimerNumber);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !((World) world).isRemote())
				DohessMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(IWorld world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "dohess_mapvars";

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				DohessMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(IWorld world) {
			if (world instanceof IServerWorld) {
				return ((IServerWorld) world).getWorld().getServer().getWorld(World.OVERWORLD).getSavedData().getOrCreate(MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private WorldSavedData data;

		public SavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			CompoundNBT nbt = buffer.readCompoundTag();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables)
					((MapVariables) this.data).read(nbt);
				else if (this.data instanceof WorldVariables)
					((WorldVariables) this.data).read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("dohess", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null, nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putString("ChangingRankSquad", instance.ChangingRankSquad);
			nbt.putDouble("HorseColour", instance.HorseColour);
			nbt.putString("HorseID", instance.HorseID);
			nbt.putString("HorseName", instance.HorseName);
			nbt.putString("MCPlayerColour", instance.MCPlayerColour);
			nbt.putString("MCPlayerRank", instance.MCPlayerRank);
			nbt.putString("MCPlayerRankPri", instance.MCPlayerRankPri);
			nbt.putString("MCPlayerSquad", instance.MCPlayerSquad);
			nbt.putString("MCPlayerSquadPri", instance.MCPlayerSquadPri);
			nbt.putBoolean("ModTeam", instance.ModTeam);
			nbt.putBoolean("NameVisibility", instance.NameVisibility);
			nbt.putBoolean("PDImmortal", instance.PDImmortal);
			nbt.putBoolean("PDInvisibility", instance.PDInvisibility);
			nbt.putBoolean("PDManager", instance.PDManager);
			nbt.putBoolean("PDSpeed", instance.PDSpeed);
			nbt.putDouble("PDSpeedNO", instance.PDSpeedNO);
			nbt.putString("PlayerMessage", instance.PlayerMessage);
			nbt.putString("PlayerUser", instance.PlayerUser);
			nbt.putBoolean("TCI", instance.TCI);
			nbt.putBoolean("TCIHighlight", instance.TCIHighlight);
			nbt.putBoolean("VisableName", instance.VisableName);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.ChangingRankSquad = nbt.getString("ChangingRankSquad");
			instance.HorseColour = nbt.getDouble("HorseColour");
			instance.HorseID = nbt.getString("HorseID");
			instance.HorseName = nbt.getString("HorseName");
			instance.MCPlayerColour = nbt.getString("MCPlayerColour");
			instance.MCPlayerRank = nbt.getString("MCPlayerRank");
			instance.MCPlayerRankPri = nbt.getString("MCPlayerRankPri");
			instance.MCPlayerSquad = nbt.getString("MCPlayerSquad");
			instance.MCPlayerSquadPri = nbt.getString("MCPlayerSquadPri");
			instance.ModTeam = nbt.getBoolean("ModTeam");
			instance.NameVisibility = nbt.getBoolean("NameVisibility");
			instance.PDImmortal = nbt.getBoolean("PDImmortal");
			instance.PDInvisibility = nbt.getBoolean("PDInvisibility");
			instance.PDManager = nbt.getBoolean("PDManager");
			instance.PDSpeed = nbt.getBoolean("PDSpeed");
			instance.PDSpeedNO = nbt.getDouble("PDSpeedNO");
			instance.PlayerMessage = nbt.getString("PlayerMessage");
			instance.PlayerUser = nbt.getString("PlayerUser");
			instance.TCI = nbt.getBoolean("TCI");
			instance.TCIHighlight = nbt.getBoolean("TCIHighlight");
			instance.VisableName = nbt.getBoolean("VisableName");
		}
	}

	public static class PlayerVariables {
		public String ChangingRankSquad = "\"\"";
		public double HorseColour = 0.0;
		public String HorseID = "";
		public String HorseName = "No Name";
		public String MCPlayerColour = "white";
		public String MCPlayerRank = "{\"text\":\"] | \",\"color\":\"#6E6E6E\"},{\"text\":\"No Rank. \",\"color\":\"#D5D5D5\"}]";
		public String MCPlayerRankPri = "z";
		public String MCPlayerSquad = "[{\"text\":\"[\",\"color\":\"#6E6E6E\"},{\"text\":\"No Squad\",\"color\":\"#D5D5D5\"},";
		public String MCPlayerSquadPri = "z";
		public boolean ModTeam = false;
		public boolean NameVisibility = true;
		public boolean PDImmortal = false;
		public boolean PDInvisibility = false;
		public boolean PDManager = false;
		public boolean PDSpeed = false;
		public double PDSpeedNO = 0;
		public String PlayerMessage = "";
		public String PlayerUser = "";
		public boolean TCI = false;
		public boolean TCIHighlight = false;
		public boolean VisableName = true;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				DohessMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity), new PlayerVariablesSyncMessage(this));
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.ChangingRankSquad = message.data.ChangingRankSquad;
					variables.HorseColour = message.data.HorseColour;
					variables.HorseID = message.data.HorseID;
					variables.HorseName = message.data.HorseName;
					variables.MCPlayerColour = message.data.MCPlayerColour;
					variables.MCPlayerRank = message.data.MCPlayerRank;
					variables.MCPlayerRankPri = message.data.MCPlayerRankPri;
					variables.MCPlayerSquad = message.data.MCPlayerSquad;
					variables.MCPlayerSquadPri = message.data.MCPlayerSquadPri;
					variables.ModTeam = message.data.ModTeam;
					variables.NameVisibility = message.data.NameVisibility;
					variables.PDImmortal = message.data.PDImmortal;
					variables.PDInvisibility = message.data.PDInvisibility;
					variables.PDManager = message.data.PDManager;
					variables.PDSpeed = message.data.PDSpeed;
					variables.PDSpeedNO = message.data.PDSpeedNO;
					variables.PlayerMessage = message.data.PlayerMessage;
					variables.PlayerUser = message.data.PlayerUser;
					variables.TCI = message.data.TCI;
					variables.TCIHighlight = message.data.TCIHighlight;
					variables.VisableName = message.data.VisableName;
				}
			});
			context.setPacketHandled(true);
		}
	}
}