package astro.progression_reshuffled.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static net.minecraft.item.equipment.ArmorMaterials.createDefenseMap;
import static net.minecraft.registry.tag.ItemTags.*;

@Mixin(ArmorMaterials.class)
public interface ArmorMaterialMixin {

	@ModifyExpressionValue(
			method = "<clinit>()V",
			at = @At(
					value = "NEW",
					target = "Lnet/minecraft/item/equipment/ArmorMaterial;"
			)
	)
    private static ArmorMaterial modifyMaterialValues(ArmorMaterial original) {
		if (original.repairIngredient() == REPAIRS_LEATHER_ARMOR) {
			return new ArmorMaterial(
					original.durability(),
					original.defense(),
					4,
					original.equipSound(),
					original.toughness(),
					original.knockbackResistance(),
					original.repairIngredient(),
					original.assetId()
			);
		}
		if (original.repairIngredient() == REPAIRS_CHAIN_ARMOR) {
			return new ArmorMaterial(
					original.durability(),
					createDefenseMap(2,5,6,2,5),
					15,
					original.equipSound(),
					1,
					0.025F,
					original.repairIngredient(),
					original.assetId()
			);
		}
		if (original.repairIngredient() == REPAIRS_COPPER_ARMOR) {
			return new ArmorMaterial(
					10,
					createDefenseMap(2,3,4,2,4),
					10,
					original.equipSound(),
					1,
					0.025F,
					original.repairIngredient(),
					original.assetId()
			);
		}
		if (original.repairIngredient() == REPAIRS_IRON_ARMOR) {
			return new ArmorMaterial(
					original.durability(),
					original.defense(),
					15,
					original.equipSound(),
					1,
					0.025F,
					original.repairIngredient(),
					original.assetId()
			);
		}
		if (original.repairIngredient() == REPAIRS_GOLD_ARMOR) {
			return new ArmorMaterial(
					25,
					createDefenseMap(2,5,7,3,7),
					20,
					original.equipSound(),
					2.15F,
					0.065F,
					original.repairIngredient(),
					original.assetId()
			);
		}
		if (original.repairIngredient() == REPAIRS_DIAMOND_ARMOR) {
			return new ArmorMaterial(
					30,
					original.defense(),
					20,
					original.equipSound(),
					original.toughness(),
					0.05F,
					original.repairIngredient(),
					original.assetId()
			);
		}
		if (original.repairIngredient() == REPAIRS_NETHERITE_ARMOR) {
			return new ArmorMaterial(
					40,
					createDefenseMap(4,6,8,4,19),
					25,
					original.equipSound(),
					3.15F,
					0.125F,
					original.repairIngredient(),
					original.assetId()
			);
		}
		return original;
	}
}