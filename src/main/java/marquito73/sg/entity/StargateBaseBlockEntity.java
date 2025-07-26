package marquito73.sg.entity;

import marquito73.sg.SGCraft;
import marquito73.sg.init.SGCraftBlockEntityTypes;
import marquito73.sg.network.StargatePayload;
import marquito73.sg.screenhandler.StargateBaseScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

/**
 * Stargate base block entity
 */
public class StargateBaseBlockEntity extends StargateBlockEntity implements ExtendedScreenHandlerFactory<StargatePayload> {
    public static final Text TITLE = Text.translatable("container." + SGCraft.MOD_ID + ".stargate_base");

    private final SimpleInventory inventory = new SimpleInventory(5) {
        @Override
        public void markDirty() {
            super.markDirty();
            update();
        }

        @Override
        public void onOpen(PlayerEntity player) {
            super.onOpen(player);

            update();
        }

        @Override
        public void onClose(PlayerEntity player) {
            super.onClose(player);

            update();
        }
    };

    private final InventoryStorage inventoryStorage = InventoryStorage.of(this.inventory, null);

    public StargateBaseBlockEntity(BlockPos pos, BlockState state) {
        super(SGCraftBlockEntityTypes.STARGATE, pos, state);
    }

    @Override
    public StargatePayload getScreenOpeningData(ServerPlayerEntity player) {
        return new StargatePayload(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return TITLE;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new StargateBaseScreenHandler(syncId, playerInventory, this);
    }

    public InventoryStorage getInventoryProvider(Direction direction) {
        return this.inventoryStorage;
    }

    public SimpleInventory getInventory() {
        return this.inventory;
    }

    private void update() {
        this.markDirty();
        if (this.world != null) {
            this.world.updateListeners(this.pos, this.getCachedState(), this.getCachedState(), Block.NOTIFY_ALL);
        }
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, this.inventory.getHeldStacks(), registryLookup);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, this.inventory.getHeldStacks(), registryLookup);
        super.writeNbt(nbt, registryLookup);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return this.createNbt(registryLookup);
    }
}
