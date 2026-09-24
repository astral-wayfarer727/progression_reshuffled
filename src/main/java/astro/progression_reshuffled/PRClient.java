package astro.progression_reshuffled;

import astro.progression_reshuffled.block.AdvancedFurnaceScreen;
import astro.progression_reshuffled.util.PRScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class PRClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(PRScreenHandlers.ADVANCED_FURNACE_SCREEN_HANDLER, AdvancedFurnaceScreen::new);
    }
}
