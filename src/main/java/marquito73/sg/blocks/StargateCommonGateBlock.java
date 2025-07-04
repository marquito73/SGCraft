package marquito73.sg.blocks;

import marquito73.sg.structure.StargateStructure;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class StargateCommonGateBlock extends StargateBlock {
    public StargateCommonGateBlock() {
        super(AbstractBlock.Settings
                .create()
                .strength(1.5F, 6.0F)
                .requiresTool());
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        StargateStructure stargateStructure = new StargateStructure(world, pos);

        world.getPlayers().getFirst().sendMessage(Text.literal("Stargate structure is valid : " + stargateStructure.structureIsValid()));
    }
}
