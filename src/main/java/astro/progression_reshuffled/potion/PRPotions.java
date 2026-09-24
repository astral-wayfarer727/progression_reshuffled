package astro.progression_reshuffled.potion;

import astro.progression_reshuffled.ProgressionReshuffled;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class PRPotions {
    //Dolphin's Grace Potions
    public static final RegistryEntry<Potion> DOLPHINS_GRACE = registerPotion(
            "dolphins_grace", new Potion("dolphins_grace", new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 440))
    );
    public static final RegistryEntry<Potion> LONG_DOLPHINS_GRACE = registerPotion(
            "long_dolphins_grace", new Potion("dolphins_grace", new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 900))
    );

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(ProgressionReshuffled.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        ProgressionReshuffled.LOGGER.info("Registering potions for " + ProgressionReshuffled.MOD_ID);
    }
}
