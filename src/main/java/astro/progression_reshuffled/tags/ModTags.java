package astro.progression_reshuffled.tags;

import astro.progression_reshuffled.ProgressionReshuffled;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_ENDANIUM_TOOL = createTag("incorrect_for_endanium_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ProgressionReshuffled.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ENDANIUM_TOOL_MATERIALS = createTag("endanium_tool_materials");
        public static final TagKey<Item> REPAIRS_ENDANIUM_ARMOR = createTag("repairs_endanium_armor");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ProgressionReshuffled.MOD_ID, name));
        }
    }
}
