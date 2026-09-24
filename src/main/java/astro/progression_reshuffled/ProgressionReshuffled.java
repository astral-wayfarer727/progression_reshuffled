package astro.progression_reshuffled;

import astro.progression_reshuffled.block.ModBlockEntities;
import astro.progression_reshuffled.block.ModBlocks;
import astro.progression_reshuffled.item.ModItems;
import astro.progression_reshuffled.potion.PRPotions;
import astro.progression_reshuffled.util.PRScreenHandlers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
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
		ModBlockEntities.registerBlockEntities();
		PRScreenHandlers.registerScreenHandlers();
		PRPotions.registerPotions();

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.FALCATE_FIN, PRPotions.DOLPHINS_GRACE);
			builder.registerPotionRecipe(PRPotions.DOLPHINS_GRACE, Items.REDSTONE, PRPotions.LONG_DOLPHINS_GRACE);
		});
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
