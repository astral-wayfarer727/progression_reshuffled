package astro.progression_reshuffled.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.FuelRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class AdvancedFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    private static final Text CONTAINER_NAME_TEXT = Text.translatable("container.progression_reshuffled.advanced_furnace");

    public AdvancedFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ADVANCED_FURNACE_BLOCK_ENTITY, pos, state, RecipeType.SMELTING);
    }

    @Override
    protected Text getContainerName() {
        return CONTAINER_NAME_TEXT;
    }

    @Override
    public int getFuelTime(FuelRegistry fuelRegistry, ItemStack stack) {
        return (int) (super.getFuelTime(fuelRegistry, stack) * 1.5F);
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new AdvancedFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
