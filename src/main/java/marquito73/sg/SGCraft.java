package marquito73.sg;

import marquito73.sg.init.BlockInit;
import marquito73.sg.init.ChestLootTableInit;
import marquito73.sg.init.ItemGroupInit;
import marquito73.sg.init.ItemInit;
import marquito73.sg.init.worldgen.BiomeModificationInit;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SGCraft implements ModInitializer {
	public static final String MOD_ID = "sgcraft";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading " + MOD_ID + " mod ...");

		ItemInit.load();
		ItemGroupInit.load();
		BlockInit.load();
		BiomeModificationInit.load();
		ChestLootTableInit.load();

		LOGGER.info("Mod " + MOD_ID + " loaded !");
	}

	public static Identifier getID(String path) {
		return Identifier.of(MOD_ID, path);
	}
}