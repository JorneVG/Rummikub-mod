package mod.rummikub.block;

import mod.rummikub.RummikubMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block CANNABIS_BLOCK = registerBlock("cannabis_block",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(RummikubMod.MOD_ID, "cannabis_block")))
                    .strength(0.5f).sounds(BlockSoundGroup.GRASS)));
    public static final Block CANNABIS_BUSH = registerBlock("cannabis_bush",
            new Block(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(RummikubMod.MOD_ID, "cannabis_bush")))));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RummikubMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(RummikubMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RummikubMod.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        RummikubMod.LOGGER.info("Registering Mod Blocks for " + RummikubMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CANNABIS_BLOCK);
            entries.add(ModBlocks.CANNABIS_BUSH);
        });
    }
}
