package astro.progression_reshuffled.util;

import astro.progression_reshuffled.ProgressionReshuffled;
import astro.progression_reshuffled.block.AdvancedFurnaceScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class PRScreenHandlers {
    public static final ScreenHandlerType<AdvancedFurnaceScreenHandler> ADVANCED_FURNACE_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of(ProgressionReshuffled.MOD_ID, "advanced_furnace_screen_handler"),
            new ScreenHandlerType<>(AdvancedFurnaceScreenHandler::new, FeatureFlags.VANILLA_FEATURES)
    );

    public static void registerScreenHandlers() {
        ProgressionReshuffled.LOGGER.info("Registering Screen Handlers for " + ProgressionReshuffled.MOD_ID);
    }
}