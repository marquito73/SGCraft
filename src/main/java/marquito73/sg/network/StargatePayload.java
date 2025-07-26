package marquito73.sg.network;

import marquito73.sg.SGCraft;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.math.BlockPos;

/**
 * A payload for Stargate screen
 * @param pos
 */
public record StargatePayload(BlockPos pos) implements CustomPayload {
    public static final Id<StargatePayload> ID = new Id<>(SGCraft.getID("stargate"));
    public static final PacketCodec<RegistryByteBuf, StargatePayload> PACKET_CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, StargatePayload::pos, StargatePayload::new);
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
