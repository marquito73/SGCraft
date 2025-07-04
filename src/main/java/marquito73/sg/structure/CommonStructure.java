package marquito73.sg.structure;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public abstract class CommonStructure {
    protected final World world;
    protected final BlockPos currentBlockPos;
    protected final Map<BlockPos, Block> positions = new HashMap<>();

    public CommonStructure(World world, BlockPos currentBlockPos) {
        this.world = world;
        this.currentBlockPos = currentBlockPos;
    }

    /**
     * Check structure
     *
     * @return The structure is valid
     */
    public abstract Boolean structureIsValid();
}
