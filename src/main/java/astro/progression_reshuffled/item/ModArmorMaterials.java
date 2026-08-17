package astro.progression_reshuffled.item;

import astro.progression_reshuffled.tags.ModTags;
import astro.progression_reshuffled.util.ModEquipmentAssets;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {

    public static ArmorMaterial ENDANIUM = new ArmorMaterial(45, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 16);
    }), 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ModTags.Items.REPAIRS_ENDANIUM_ARMOR,  ModEquipmentAssets.ENDANIUM);
}