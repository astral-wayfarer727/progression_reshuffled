package astro.progression_reshuffled.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static net.minecraft.registry.tag.BlockTags.*;

@Mixin(ToolMaterial.class)
public class ToolMaterialMixin {

    @ModifyExpressionValue(
            method = "<clinit>()V",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/ToolMaterial;"
            )
    )
    private static ToolMaterial modifyMaterialValues(ToolMaterial original) {
        if (original.incorrectBlocksForDrops() == INCORRECT_FOR_WOODEN_TOOL) {
            return new ToolMaterial(
                    original.incorrectBlocksForDrops(),
                    64,
                    3.0F,
                    original.attackDamageBonus(),
                    4,
                    original.repairItems()
            );
        }
        if (original.incorrectBlocksForDrops() == INCORRECT_FOR_STONE_TOOL) {
            return new ToolMaterial(
                    original.incorrectBlocksForDrops(),
                    192,
                    5.0F,
                    original.attackDamageBonus(),
                    7,
                    original.repairItems()
            );
        }
        if (original.incorrectBlocksForDrops() == INCORRECT_FOR_COPPER_TOOL) {
            return new ToolMaterial(
                    original.incorrectBlocksForDrops(),
                    448,
                    6.0F,
                    original.attackDamageBonus(),
                    10,
                    original.repairItems()
            );
        }
        if (original.incorrectBlocksForDrops() == INCORRECT_FOR_IRON_TOOL) {
            return new ToolMaterial(
                    original.incorrectBlocksForDrops(),
                    704,
                    7.0F,
                    original.attackDamageBonus(),
                    15,
                    original.repairItems()
            );
        }
        if (original.incorrectBlocksForDrops() == INCORRECT_FOR_GOLD_TOOL) {
            return new ToolMaterial(
                    original.incorrectBlocksForDrops(),
                    1152,
                    10.0F,
                    3.0F,
                    20,
                    original.repairItems()
            );
        }
        if (original.incorrectBlocksForDrops() == INCORRECT_FOR_DIAMOND_TOOL) {
            return new ToolMaterial(
                    original.incorrectBlocksForDrops(),
                    1536,
                    9.0F,
                    original.attackDamageBonus(),
                    20,
                    original.repairItems()
            );
        }
        if (original.incorrectBlocksForDrops() == INCORRECT_FOR_NETHERITE_TOOL) {
            return new ToolMaterial(
                    original.incorrectBlocksForDrops(),
                    2560,
                    12.0F,
                    5.0F,
                    22,
                    original.repairItems()
            );
        }
        return original;
    }
}