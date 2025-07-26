package marquito73.sg.init;

import marquito73.sg.SGCraft;
import marquito73.sg.network.StargatePayload;
import marquito73.sg.screenhandler.StargateBaseScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

/**
 * Represent screen handler types
 */
public class SGCraftScreenHandlerTypes {
    /**
     * Stargate screen handler type
     */
    public static final ScreenHandlerType<StargateBaseScreenHandler> STARGATE_BASE = register("", StargateBaseScreenHandler::new, StargatePayload.PACKET_CODEC);

    /**
     * Register a screen handler type
     *
     * @param name His name
     * @param factory Factory
     * @param codec Codec
     * @return A screen handler type registered
     * @param <T> A screen handler
     * @param <D> A screen payload
     */
    public static <T extends ScreenHandler, D extends CustomPayload> ExtendedScreenHandlerType<T, D> register(String name, ExtendedScreenHandlerType.ExtendedFactory<T, D> factory, PacketCodec<? super RegistryByteBuf, D> codec) {
        return Registry.register(Registries.SCREEN_HANDLER, SGCraft.getID(name), new ExtendedScreenHandlerType<>(factory, codec));
    }

    public static void load()
    {

    };
}
