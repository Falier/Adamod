
package net.mcreator.mymodpack.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.Minecraft;

import net.mcreator.mymodpack.procedures.AdvancedCraftProcedure;
import net.mcreator.mymodpack.MyModpackElements;
import net.mcreator.mymodpack.MyModpack;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@MyModpackElements.ModElement.Tag
public class CraftingFOrgeGui extends MyModpackElements.ModElement {
	public static HashMap guistate = new HashMap();
	private static ContainerType<GuiContainerMod> containerType = null;
	public CraftingFOrgeGui(MyModpackElements instance) {
		super(instance, 46);
		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);
		containerType = new ContainerType<>(new GuiContainerModFactory());
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		ScreenManager.registerFactory(containerType, GuiWindow::new);
	}

	@SubscribeEvent
	public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(containerType.setRegistryName("craftingforge"));
	}
	public static class GuiContainerModFactory implements IContainerFactory {
		public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
			return new GuiContainerMod(id, inv, extraData);
		}
	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private World world;
		private PlayerEntity entity;
		private int x, y, z;
		private IInventory internal;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);
			this.entity = inv.player;
			this.world = inv.player.world;
			this.internal = new Inventory(18);
			if (extraData != null) {
				BlockPos pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
				TileEntity ent = inv.player != null ? inv.player.world.getTileEntity(pos) : null;
				if (ent instanceof IInventory)
					this.internal = (IInventory) ent;
			}
			internal.openInventory(inv.player);
			this.customSlots.put(0, this.addSlot(new Slot(internal, 0, 36, 23) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(0, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(2, this.addSlot(new Slot(internal, 2, 35, 45) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(2, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(3, this.addSlot(new Slot(internal, 3, 35, 65) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(3, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(4, this.addSlot(new Slot(internal, 4, 35, 2) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(4, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(5, this.addSlot(new Slot(internal, 5, 55, 64) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(5, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(6, this.addSlot(new Slot(internal, 6, 53, 44) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(6, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(7, this.addSlot(new Slot(internal, 7, 55, 22) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(7, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(8, this.addSlot(new Slot(internal, 8, 54, 1) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(8, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(10, this.addSlot(new Slot(internal, 10, 74, 2) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(10, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(9, this.addSlot(new Slot(internal, 9, 75, 20) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(9, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(11, this.addSlot(new Slot(internal, 11, 76, 43) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(11, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(12, this.addSlot(new Slot(internal, 12, 75, 64) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(12, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(13, this.addSlot(new Slot(internal, 13, 95, 1) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(13, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(14, this.addSlot(new Slot(internal, 14, 96, 21) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(15, this.addSlot(new Slot(internal, 15, 95, 43) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(15, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(16, this.addSlot(new Slot(internal, 16, 96, 63) {
				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(16, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(17, this.addSlot(new Slot(internal, 17, 134, 34) {
				@Override
				public ItemStack onTake(PlayerEntity entity, ItemStack stack) {
					ItemStack retval = super.onTake(entity, stack);
					GuiContainerMod.this.slotChanged(17, 1, 0);
					return retval;
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			int si;
			int sj;
			for (si = 0; si < 3; ++si)
				for (sj = 0; sj < 9; ++sj)
					this.addSlot(new Slot(inv, sj + (si + 1) * 9, 0 + 8 + sj * 18, 0 + 84 + si * 18));
			for (si = 0; si < 9; ++si)
				this.addSlot(new Slot(inv, si, 0 + 8 + si * 18, 0 + 142));
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return internal.isUsableByPlayer(player);
		}

		@Override
		public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
			ItemStack itemstack = ItemStack.EMPTY;
			Slot slot = (Slot) this.inventorySlots.get(index);
			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();
				if (index < 17) {
					if (!this.mergeItemStack(itemstack1, 17, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
					slot.onSlotChange(itemstack1, itemstack);
				} else if (!this.mergeItemStack(itemstack1, 0, 17, false)) {
					if (index < 17 + 27) {
						if (!this.mergeItemStack(itemstack1, 17 + 27, this.inventorySlots.size(), true)) {
							return ItemStack.EMPTY;
						}
					} else {
						if (!this.mergeItemStack(itemstack1, 17, 17 + 27, false)) {
							return ItemStack.EMPTY;
						}
					}
					return ItemStack.EMPTY;
				}
				if (itemstack1.getCount() == 0) {
					slot.putStack(ItemStack.EMPTY);
				} else {
					slot.onSlotChanged();
				}
				if (itemstack1.getCount() == itemstack.getCount()) {
					return ItemStack.EMPTY;
				}
				slot.onTake(playerIn, itemstack1);
			}
			return itemstack;
		}

		@Override /**
					 * Merges provided ItemStack with the first avaliable one in the
					 * container/player inventor between minIndex (included) and maxIndex
					 * (excluded). Args : stack, minIndex, maxIndex, negativDirection. /!\ the
					 * Container implementation do not check if the item is valid for the slot
					 */
		protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
			boolean flag = false;
			int i = startIndex;
			if (reverseDirection) {
				i = endIndex - 1;
			}
			if (stack.isStackable()) {
				while (!stack.isEmpty()) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot = this.inventorySlots.get(i);
					ItemStack itemstack = slot.getStack();
					if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && areItemsAndTagsEqual(stack, itemstack)) {
						int j = itemstack.getCount() + stack.getCount();
						int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
						if (j <= maxSize) {
							stack.setCount(0);
							itemstack.setCount(j);
							slot.putStack(itemstack);
							flag = true;
						} else if (itemstack.getCount() < maxSize) {
							stack.shrink(maxSize - itemstack.getCount());
							itemstack.setCount(maxSize);
							slot.putStack(itemstack);
							flag = true;
						}
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			if (!stack.isEmpty()) {
				if (reverseDirection) {
					i = endIndex - 1;
				} else {
					i = startIndex;
				}
				while (true) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot1 = this.inventorySlots.get(i);
					ItemStack itemstack1 = slot1.getStack();
					if (itemstack1.isEmpty() && slot1.isItemValid(stack)) {
						if (stack.getCount() > slot1.getSlotStackLimit()) {
							slot1.putStack(stack.split(slot1.getSlotStackLimit()));
						} else {
							slot1.putStack(stack.split(stack.getCount()));
						}
						slot1.onSlotChanged();
						flag = true;
						break;
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			return flag;
		}

		@Override
		public void onContainerClosed(PlayerEntity playerIn) {
			super.onContainerClosed(playerIn);
			internal.closeInventory(playerIn);
			if ((internal instanceof Inventory) && (playerIn instanceof ServerPlayerEntity)) {
				this.clearContainer(playerIn, playerIn.world, internal);
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote) {
				MyModpack.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class GuiWindow extends ContainerScreen<GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		public GuiWindow(GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 166;
		}
		private static final ResourceLocation texture = new ResourceLocation("mymodpack:textures/craftingforge.png");
		@Override
		public void render(int mouseX, int mouseY, float partialTicks) {
			this.renderBackground();
			super.render(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			Minecraft.getInstance().getTextureManager().bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.blit(k, l, 0, 0, this.xSize, this.ySize);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		}

		@Override
		public void removed() {
			super.removed();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
		}
	}

	public static class ButtonPressedMessage {
		int buttonID, x, y, z;
		public ButtonPressedMessage(PacketBuffer buffer) {
			this.buttonID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
		}

		public ButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.buttonID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
		}

		public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}

	public static class GUISlotChangedMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		public GUISlotChangedMessage(PacketBuffer buffer) {
			this.slotID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
			this.changeType = buffer.readInt();
			this.meta = buffer.readInt();
		}

		public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.slotID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			buffer.writeInt(message.changeType);
			buffer.writeInt(message.meta);
		}

		public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}
	private static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}

	private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (slotID == 0 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 2 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 3 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 4 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 5 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 6 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 7 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 8 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 10 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 9 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 11 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 12 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 13 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 15 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 16 && changeType == 2) {
			int amount = meta;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
		if (slotID == 17 && changeType == 1) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				AdvancedCraftProcedure.executeProcedure($_dependencies);
			}
		}
	}
}