package marquito73.sg.data.provider;

import marquito73.sg.init.BlockInit;
import marquito73.sg.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class SGCraftModelProvider extends FabricModelProvider {
    public SGCraftModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.NAQUADAH_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.OVERWORLD_NAQUADAH_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.DEEPSLATE_NAQUADAH_ORE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ItemInit.NAQUADAH_INGOT, Models.GENERATED);
        itemModelGenerator.register(ItemInit.NAQUADAH_RAW, Models.GENERATED);
    }
}
