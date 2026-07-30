package astro.progression_reshuffled;

import astro.progression_reshuffled.block.ModBlocks;
import astro.progression_reshuffled.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgressionReshuffled implements ModInitializer {
	public static final String MOD_ID = "progression_reshuffled";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModBlocks.registerBlocks();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
