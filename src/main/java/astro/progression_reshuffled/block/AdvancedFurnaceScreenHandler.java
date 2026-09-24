package astro.progression_reshuffled.block;

import astro.progression_reshuffled.util.PRScreenHandlers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.RecipePropertySet;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.RecipeBookType;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class AdvancedFurnaceScreenHandler extends AbstractFurnaceScreenHandler {
    public AdvancedFurnaceScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(PRScreenHandlers.ADVANCED_FURNACE_SCREEN_HANDLER, RecipeType.SMELTING, RecipePropertySet.FURNACE_INPUT, RecipeBookType.FURNACE, syncId, playerInventory);
    }

    public AdvancedFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(
                PRScreenHandlers.ADVANCED_FURNACE_SCREEN_HANDLER,
                RecipeType.SMELTING,
                RecipePropertySet.FURNACE_INPUT,
                RecipeBookType.FURNACE,
                syncId,
                playerInventory,
                inventory,
                propertyDelegate
        );
    }
}
