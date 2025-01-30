package mod.rummikub;

import mod.rummikub.block.ModBlocks;
import mod.rummikub.effect.ModEffects;
import mod.rummikub.item.ModItemGroups;
import mod.rummikub.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RummikubMod implements ModInitializer {
	public static final String MOD_ID = "rummikubmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModEffects.registerEffects();
	}
}