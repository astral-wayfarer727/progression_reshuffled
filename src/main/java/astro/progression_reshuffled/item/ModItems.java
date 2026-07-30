package astro.progression_reshuffled.item;

import astro.progression_reshuffled.ProgressionReshuffled;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.equipment.trim.ArmorTrimMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ProgressionReshuffled.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    //Have yet to add the trim Material but given that it's purple and Amethyst already is that I'm not too pushed, would like to have it only for the consistency
    //.trimMaterial(ArmorTrimMaterials.ENDANIUM)
    public static Item ENDANIUM_INGOT = register("endanium_ingot", Item::new, new Item.Settings());
    public static Item ENDANIUM_CHUNK = register("endanium_chunk", Item::new, new Item.Settings());

    public static Item ENDANIUM_BOOTS = register("endanium_boots", Item::new, new Item.Settings().armor(ModArmorMaterials.ENDANIUM, EquipmentType.BOOTS));
    public static Item ENDANIUM_LEGGINGS = register("endanium_leggings", Item::new, new Item.Settings().armor(ModArmorMaterials.ENDANIUM, EquipmentType.LEGGINGS));
    public static Item ENDANIUM_CHESTPLATE = register("endanium_chestplate", Item::new, new Item.Settings().armor(ModArmorMaterials.ENDANIUM, EquipmentType.CHESTPLATE));
    public static Item ENDANIUM_HELMET = register("endanium_helmet", Item::new, new Item.Settings().armor(ModArmorMaterials.ENDANIUM, EquipmentType.HELMET));

    public static Item ENDANIUM_HORSE_ARMOR = register("endanium_horse_armor", Item::new, new Item.Settings().horseArmor(ModArmorMaterials.ENDANIUM));
    public static Item ENDANIUM_NAUTILUS_ARMOR = register("endanium_nautilus_armor", Item::new, new Item.Settings().nautilusArmor(ModArmorMaterials.ENDANIUM));

    public static Item ENDANIUM_SWORD = register("endanium_sword", Item::new, new Item.Settings().sword(ModToolMaterials.ENDANIUM, 3.0F, -2.4F));
    public static Item ENDANIUM_PICKAXE = register("endanium_pickaxe", Item::new, new Item.Settings().pickaxe(ModToolMaterials.ENDANIUM, 1.0F, -2.8F));
    public static Item ENDANIUM_SHOVEL = register("endanium_shovel", settings -> new ShovelItem(ModToolMaterials.ENDANIUM, 1.5F, -3.0F, settings), new Item.Settings());
    public static Item ENDANIUM_AXE = register("endanium_axe", settings -> new AxeItem(ModToolMaterials.ENDANIUM, 5.0F, -3.0F, settings), new Item.Settings());
    public static Item ENDANIUM_HOE = register("endanium_hoe", settings -> new HoeItem(ModToolMaterials.ENDANIUM, -4.0F, 0.0F, settings), new Item.Settings());
    public static Item ENDANIUM_SPEAR = register("endanium_spear", Item::new, new Item.Settings().spear(ModToolMaterials.ENDANIUM, 1.15F, 1.2F, 0.4F, 2.5F, 7.0F, 5.5F, 5.1F, 8.75F, 4.6F));



    public static void registerItems() {
        ProgressionReshuffled.LOGGER.info("Registering items for " + ProgressionReshuffled.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addAfter(Items.NETHERITE_SWORD, ModItems.ENDANIUM_SWORD);
            entries.addAfter(Items.NETHERITE_AXE, ModItems.ENDANIUM_AXE);
            entries.addAfter(Items.NETHERITE_SPEAR, ModItems.ENDANIUM_SPEAR);

            entries.addAfter(Items.NETHERITE_BOOTS, ModItems.ENDANIUM_HELMET);
            entries.addAfter(ModItems.ENDANIUM_HELMET, ModItems.ENDANIUM_CHESTPLATE);
            entries.addAfter(ModItems.ENDANIUM_CHESTPLATE, ModItems.ENDANIUM_LEGGINGS);
            entries.addAfter(ModItems.ENDANIUM_LEGGINGS, ModItems.ENDANIUM_BOOTS);
            entries.addAfter(Items.NETHERITE_HORSE_ARMOR, ModItems.ENDANIUM_HORSE_ARMOR);
            entries.addAfter(Items.NETHERITE_NAUTILUS_ARMOR, ModItems.ENDANIUM_NAUTILUS_ARMOR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.NETHERITE_HOE, ModItems.ENDANIUM_SHOVEL);
            entries.addAfter(ModItems.ENDANIUM_SHOVEL, ModItems.ENDANIUM_PICKAXE);
            entries.addAfter(ModItems.ENDANIUM_PICKAXE, ModItems.ENDANIUM_AXE);
            entries.addAfter(ModItems.ENDANIUM_AXE, ModItems.ENDANIUM_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.NETHERITE_INGOT, ModItems.ENDANIUM_CHUNK);
            entries.addAfter(ModItems.ENDANIUM_CHUNK, ModItems.ENDANIUM_INGOT);
        });
    }
}
