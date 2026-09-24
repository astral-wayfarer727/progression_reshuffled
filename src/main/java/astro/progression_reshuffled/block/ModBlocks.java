package astro.progression_reshuffled.block;

import astro.progression_reshuffled.ProgressionReshuffled;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.base.Function;

import static net.minecraft.block.Blocks.*;

public class ModBlocks {

    private static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(ProgressionReshuffled.MOD_ID, name);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    public static Block STELLAR_RUBBLE = register("stellar_rubble",
            Block::new, AbstractBlock.Settings.copy(ANCIENT_DEBRIS).mapColor(MapColor.PURPLE));
    public static Block ENDANIUM_BLOCK = register("endanium_block",
            Block::new, AbstractBlock.Settings.copy(NETHERITE_BLOCK).mapColor(MapColor.PURPLE));
    public static Block ADVANCED_FURNACE = register("advanced_furnace",
            AdvancedFurnaceBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(4.0F).luminance(createLightLevelFromLitBlockState(8)));

    public static void registerBlocks() {
        ProgressionReshuffled.LOGGER.info("Registering Blocks for " + ProgressionReshuffled.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.NETHERITE_BLOCK, ModBlocks.ENDANIUM_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Blocks.ANCIENT_DEBRIS, ModBlocks.STELLAR_RUBBLE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Blocks.BLAST_FURNACE, ModBlocks.ADVANCED_FURNACE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Blocks.ANCIENT_DEBRIS, ModBlocks.STELLAR_RUBBLE);
        });
    }
}
