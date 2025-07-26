package marquito73.sg;

import marquito73.sg.entity.StargateBaseBlockEntity;
import marquito73.sg.init.*;
import marquito73.sg.init.worldgen.BiomeModificationInit;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SGCraft implements ModInitializer {
	public static final String MOD_ID = "sgcraft";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading " + MOD_ID + " mod ...");

		SGCraftItems.load();
		ItemGroupInit.load();
		SGCraftBlocks.load();
		SGCraftBlockEntityTypes.load();
		BiomeModificationInit.load();
		ChestLootTableInit.load();
		SGCraftScreenHandlerTypes.load();

		ItemStorage.SIDED.registerForBlockEntity(StargateBaseBlockEntity::getInventoryProvider, SGCraftBlockEntityTypes.STARGATE);

		LOGGER.info("Mod " + MOD_ID + " loaded !");
	}

	public static Identifier getID(String path) {
		return Identifier.of(MOD_ID, path);
	}
}