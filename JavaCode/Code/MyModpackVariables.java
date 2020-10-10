package net.mcreator.mymodpack;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.LogicalSide;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.World;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class MyModpackVariables {
	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "mymodpack_worldvars";
		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(World world) {
			this.markDirty();
			if (world.isRemote) {
				MyModpack.PACKET_HANDLER.sendToServer(new WorldSavedDataSyncMessage(1, this));
			} else {
				MyModpack.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(world.dimension::getType), new WorldSavedDataSyncMessage(1, this));
			}
		}
		static WorldVariables clientSide = new WorldVariables();
		public static WorldVariables get(World world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "mymodpack_mapvars";
		public double home1x = 0;
		public double home1y = 0;
		public double home1z = 0;
		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			home1x = nbt.getDouble("home1x");
			home1y = nbt.getDouble("home1y");
			home1z = nbt.getDouble("home1z");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putDouble("home1x", home1x);
			nbt.putDouble("home1y", home1y);
			nbt.putDouble("home1z", home1z);
			return nbt;
		}

		public void syncData(World world) {
			this.markDirty();
			if (world.isRemote) {
				MyModpack.PACKET_HANDLER.sendToServer(new WorldSavedDataSyncMessage(0, this));
			} else {
				MyModpack.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
			}
		}
		static MapVariables clientSide = new MapVariables();
		public static MapVariables get(World world) {
			if (world instanceof ServerWorld) {
				return world.getServer().getWorld(DimensionType.OVERWORLD).getSavedData().getOrCreate(MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;
		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			if (this.type == 0)
				this.data = new MapVariables();
			else
				this.data = new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (context.getDirection().getReceptionSide().isServer())
					syncData(message, context.getDirection().getReceptionSide(), context.getSender().world);
				else
					syncData(message, context.getDirection().getReceptionSide(), Minecraft.getInstance().player.world);
			});
			context.setPacketHandled(true);
		}

		private static void syncData(WorldSavedDataSyncMessage message, LogicalSide side, World world) {
			if (side.isServer()) {
				message.data.markDirty();
				if (message.type == 0) {
					MyModpack.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), message);
					world.getServer().getWorld(DimensionType.OVERWORLD).getSavedData().set(message.data);
				} else {
					MyModpack.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(world.dimension::getType), message);
					((ServerWorld) world).getSavedData().set(message.data);
				}
			} else {
				if (message.type == 0) {
					MapVariables.clientSide = (MapVariables) message.data;
				} else {
					WorldVariables.clientSide = (WorldVariables) message.data;
				}
			}
		}
	}
}
