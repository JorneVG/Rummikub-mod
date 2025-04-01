package mod.rummikub.item;

import mod.rummikub.RummikubMod;
import mod.rummikub.block.ModBlocks;
import mod.rummikub.item.custom.JonkoItem;
import mod.rummikub.item.custom.ModFoodComponents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CANNABIS=registerItem("cannabis",new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RummikubMod.MOD_ID,"cannabis")))));
    public static final Item DRIED_CANNABIS=registerItem("dried_cannabis",new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RummikubMod.MOD_ID,"dried_cannabis")))));

    public static final Item JONKO=registerItem("jonko",new JonkoItem(new Item.Settings().maxDamage(32).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RummikubMod.MOD_ID,"jonko")))));

    public static final Item CANNABIS_SEEDS = registerItem("cannabis_seeds",
            new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RummikubMod.MOD_ID, "cannabis_seeds")))));

    public static final Item CANNABIS_COOKIE=registerItem("cannabis_cookie",new Item(new Item.Settings().food(ModFoodComponents.CANNABIS_COOKIE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RummikubMod.MOD_ID,"cannabis_cookie"))).food(ModFoodComponents.CANNABIS_COOKIE, ModFoodComponents.CANNABIS_COOKIE_EFFECT)));
    public static final Item KEBAB=registerItem("kebab",new Item(new Item.Settings().food(ModFoodComponents.KEBAB).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RummikubMod.MOD_ID,"kebab"))).food(ModFoodComponents.KEBAB)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RummikubMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RummikubMod.LOGGER.info("registerModItems() is running!");
        RummikubMod.LOGGER.info("Registering Mod Items for " + RummikubMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(CANNABIS_SEEDS);
            entries.add(CANNABIS);
            entries.add(JONKO);
            entries.add(DRIED_CANNABIS);
            entries.add(CANNABIS_COOKIE);
            entries.add(KEBAB);
        });
    }
}