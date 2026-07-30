package astro.progression_reshuffled.block;

import astro.progression_reshuffled.ProgressionReshuffled;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.base.Function;

import static net.minecraft.block.Blocks.ANCIENT_DEBRIS;
import static net.minecraft.block.Blocks.NETHERITE_BLOCK;

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

    public static void registerBlocks() {
        ProgressionReshuffled.LOGGER.info("Registering Blocks for " + ProgressionReshuffled.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.NETHERITE_BLOCK, ModBlocks.ENDANIUM_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Blocks.ANCIENT_DEBRIS, ModBlocks.STELLAR_RUBBLE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Blocks.ANCIENT_DEBRIS, ModBlocks.STELLAR_RUBBLE);
        });
    }
}
