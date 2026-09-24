package astro.progression_reshuffled;

import astro.progression_reshuffled.datagen.PRLootTableProvider;
import astro.progression_reshuffled.datagen.PRModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class PRDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(PRModelProvider::new);
		pack.addProvider(PRLootTableProvider::new);
	}
}
