package astro.progression_reshuffled.util;

import astro.progression_reshuffled.ProgressionReshuffled;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModEquipmentAssets {
    private static final RegistryKey<? extends Registry<EquipmentAsset>> ROOT_ID = RegistryKey.ofRegistry(Identifier.of("equipment_asset"));

    public static final RegistryKey<EquipmentAsset> ENDANIUM = id("endanium");

    private static RegistryKey<EquipmentAsset> id(String name) {
        return RegistryKey.of(ROOT_ID, Identifier.of(ProgressionReshuffled.MOD_ID, name));
    }

    public static void bootstrap(BiConsumer<RegistryKey<EquipmentAsset>, EquipmentModel> consumer) {
        consumer.accept(ModEquipmentAssets.ENDANIUM, endaniumArmor("endanium"));
    }

    private static EquipmentModel endaniumArmor(String name) {
        return EquipmentModel.builder()
                .addHumanoidLayers(Identifier.of(ProgressionReshuffled.MOD_ID, name))
                .addLayers(EquipmentModel.LayerType.HORSE_BODY, new EquipmentModel.Layer(Identifier.of(ProgressionReshuffled.MOD_ID, name)))
                .addLayers(EquipmentModel.LayerType.NAUTILUS_BODY, new EquipmentModel.Layer(Identifier.of(ProgressionReshuffled.MOD_ID, name)))
                .build();
    }
}