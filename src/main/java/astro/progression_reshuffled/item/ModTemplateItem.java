package astro.progression_reshuffled.item;

import astro.progression_reshuffled.ProgressionReshuffled;
import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModTemplateItem extends SmithingTemplateItem {

    public ModTemplateItem(Text appliesToText, Text ingredientsText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures, Settings settings) {
        super(appliesToText, ingredientsText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures, settings);
    }

    private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;

    private static final Text ENDANIUM_UPGRADE_APPLIES_TO_TEXT = Text.translatable(
                    Util.createTranslationKey("item", Identifier.of(ProgressionReshuffled.MOD_ID, "smithing_template.endanium_upgrade.applies_to"))
            )
            .formatted(DESCRIPTION_FORMATTING);
    private static final Text ENDANIUM_UPGRADE_INGREDIENTS_TEXT = Text.translatable(
                    Util.createTranslationKey("item", Identifier.of(ProgressionReshuffled.MOD_ID, "smithing_template.endanium_upgrade.ingredients"))
            )
            .formatted(DESCRIPTION_FORMATTING);
    private static final Text ENDANIUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(
            Util.createTranslationKey("item", Identifier.of(ProgressionReshuffled.MOD_ID, "smithing_template.endanium_upgrade.base_slot_description"))
    );
    private static final Text ENDANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(
            Util.createTranslationKey("item", Identifier.of(ProgressionReshuffled.MOD_ID, "smithing_template.endanium_upgrade.additions_slot_description"))
    );

    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.ofVanilla("container/slot/helmet");
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.ofVanilla("container/slot/chestplate");
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.ofVanilla("container/slot/leggings");
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.ofVanilla("container/slot/boots");
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = Identifier.ofVanilla("container/slot/hoe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = Identifier.ofVanilla("container/slot/axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = Identifier.ofVanilla("container/slot/sword");
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.ofVanilla("container/slot/shovel");
    private static final Identifier EMPTY_SLOT_SPEAR_TEXTURE = Identifier.ofVanilla("container/slot/spear");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.ofVanilla("container/slot/pickaxe");
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = Identifier.ofVanilla("container/slot/ingot");
    private static final Identifier EMPTY_SLOT_NAUTILUS_ARMOR_TEXTURE = Identifier.ofVanilla("container/slot/nautilus_armor");

    private static List<Identifier> getEndaniumUpgradeEmptyBaseSlotTextures() {
        return List.of(
                EMPTY_ARMOR_SLOT_HELMET_TEXTURE,
                EMPTY_SLOT_SWORD_TEXTURE,
                EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
                EMPTY_SLOT_PICKAXE_TEXTURE,
                EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE,
                EMPTY_SLOT_AXE_TEXTURE,
                EMPTY_ARMOR_SLOT_BOOTS_TEXTURE,
                EMPTY_SLOT_HOE_TEXTURE,
                EMPTY_SLOT_SHOVEL_TEXTURE,
                EMPTY_SLOT_NAUTILUS_ARMOR_TEXTURE,
                EMPTY_SLOT_SPEAR_TEXTURE
        );
    }

    private static List<Identifier> getEndaniumUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE);
    }

    public static SmithingTemplateItem createEndaniumUpgrade(Item.Settings settings) {
        return new SmithingTemplateItem(
                ENDANIUM_UPGRADE_APPLIES_TO_TEXT,
                ENDANIUM_UPGRADE_INGREDIENTS_TEXT,
                ENDANIUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
                ENDANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
                getEndaniumUpgradeEmptyBaseSlotTextures(),
                getEndaniumUpgradeEmptyAdditionsSlotTextures(),
                settings
        );
    }
}
