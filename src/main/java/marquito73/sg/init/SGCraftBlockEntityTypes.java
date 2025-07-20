package marquito73.sg.init;

import marquito73.sg.SGCraft;
import marquito73.sg.entity.StargateBaseBlockEntity;
import marquito73.sg.entity.StargateChevronBlockEntity;
import marquito73.sg.entity.StargateRingBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

/**
 * Registers all block entity types
 */
public class SGCraftBlockEntityTypes {
    /**
     * Stargate base block
     */
    public static final BlockEntityType<StargateBaseBlockEntity> STARGATE = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            SGCraft.getID("stargate"),
            BlockEntityType.Builder.create(StargateBaseBlockEntity::new, SGCraftBlocks.STARGATE_BASE).build(null)
    );

    /**
     * Stargate ring block
     */
    public static final BlockEntityType<StargateRingBlockEntity> STARGATE_RING = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            SGCraft.getID("stargate_ring"),
            BlockEntityType.Builder.create(StargateRingBlockEntity::new, SGCraftBlocks.STARGATE_RING).build(null)
    );

    /**
     * Stargate chevron block
     */
    public static final BlockEntityType<StargateChevronBlockEntity> STARGATE_CHEVRON = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            SGCraft.getID("stargate_chevron"),
            BlockEntityType.Builder.create(StargateChevronBlockEntity::new, SGCraftBlocks.STARGATE_CHEVRON).build(null)
    );

    public static void load() {}
}