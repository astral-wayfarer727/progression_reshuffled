package astro.progression_reshuffled.datagen;

import astro.progression_reshuffled.block.ModBlocks;
import astro.progression_reshuffled.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class PRModelProvider extends FabricModelProvider {
    public PRModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STELLAR_RUBBLE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ENDANIUM_CHUNK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDANIUM_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDANIUM_NAUTILUS_ARMOR, Models.GENERATED);
    }
}
