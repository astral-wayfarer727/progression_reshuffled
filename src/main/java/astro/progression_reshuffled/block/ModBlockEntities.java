package astro.progression_reshuffled.block;

import astro.progression_reshuffled.ProgressionReshuffled;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<AdvancedFurnaceBlockEntity> ADVANCED_FURNACE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE, Identifier.of(ProgressionReshuffled.MOD_ID, "advanced_furnace_block_entity"),
            FabricBlockEntityTypeBuilder.create(AdvancedFurnaceBlockEntity::new, ModBlocks.ADVANCED_FURNACE).build()
    );

    public static void registerBlockEntities() {
        ProgressionReshuffled.LOGGER.info("Registering Block Entities for " + ProgressionReshuffled.MOD_ID);
    }
}