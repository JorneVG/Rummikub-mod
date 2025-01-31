package mod.rummikub.item;

import mod.rummikub.RummikubMod;
import mod.rummikub.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CANNABIS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(RummikubMod.MOD_ID, "cannabis_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CANNABIS))
                    .displayName(Text.translatable("itemgroup.rummikubmod.cannabis_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CANNABIS_SEEDS);
                        entries.add(ModItems.CANNABIS);
                        entries.add(ModItems.JONKO);
                        entries.add(ModItems.DRIED_CANNABIS);
                        entries.add(ModItems.CANNABIS_COOKIE);
                        entries.add(ModBlocks.CANNABIS_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        RummikubMod.LOGGER.info("Registering Item Groups for " + RummikubMod.MOD_ID);
    }
}
