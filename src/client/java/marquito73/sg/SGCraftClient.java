package marquito73.sg;

import marquito73.sg.init.SGCraftBlockEntityTypes;
import marquito73.sg.init.SGCraftScreenHandlerTypes;
import marquito73.sg.render.StargateRenderer;
import marquito73.sg.screen.StargateBaseScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class SGCraftClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockEntityRendererFactories.register(SGCraftBlockEntityTypes.STARGATE, StargateRenderer::new);
		BlockEntityRendererFactories.register(SGCraftBlockEntityTypes.STARGATE_RING, StargateRenderer::new);
		BlockEntityRendererFactories.register(SGCraftBlockEntityTypes.STARGATE_CHEVRON, StargateRenderer::new);

		// Bind screens
		HandledScreens.register(SGCraftScreenHandlerTypes.STARGATE_BASE, StargateBaseScreen::new);
	}
}