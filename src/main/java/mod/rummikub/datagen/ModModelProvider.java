package mod.rummikub.datagen;

import mod.rummikub.block.ModBlocks;
import mod.rummikub.block.custom.CannabisBushBlock;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;

import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.CANNABIS_BUSH, BlockStateModelGenerator.CrossType.NOT_TINTED,
                CannabisBushBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}