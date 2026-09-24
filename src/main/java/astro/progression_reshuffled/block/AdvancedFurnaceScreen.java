package astro.progression_reshuffled.block;

import astro.progression_reshuffled.ProgressionReshuffled;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.recipebook.RecipeBookType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class AdvancedFurnaceScreen extends AbstractFurnaceScreen<AdvancedFurnaceScreenHandler> {
    private static final Identifier LIT_PROGRESS_TEXTURE = Identifier.of(ProgressionReshuffled.MOD_ID, "container/advanced_furnace/advanced_lit_progress");
    private static final Identifier BURN_PROGRESS_TEXTURE = Identifier.of(ProgressionReshuffled.MOD_ID,"container/advanced_furnace/advanced_burn_progress");
    private static final Identifier TEXTURE = Identifier.of(ProgressionReshuffled.MOD_ID,"textures/gui/container/advanced_furnace.png");
    private static final Text TOGGLE_SMELTABLE_TEXT = Text.translatable("gui.recipebook.toggleRecipes.smeltable");
    private static final List<RecipeBookWidget.Tab> TABS = List.of(
            new RecipeBookWidget.Tab(RecipeBookType.FURNACE),
            new RecipeBookWidget.Tab(Items.PORKCHOP, RecipeBookCategories.FURNACE_FOOD),
            new RecipeBookWidget.Tab(Items.STONE, RecipeBookCategories.FURNACE_BLOCKS),
            new RecipeBookWidget.Tab(Items.LAVA_BUCKET, Items.EMERALD, RecipeBookCategories.FURNACE_MISC)
    );

    public AdvancedFurnaceScreen(AdvancedFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title, TOGGLE_SMELTABLE_TEXT, TEXTURE, LIT_PROGRESS_TEXTURE, BURN_PROGRESS_TEXTURE, TABS);
    }
}
