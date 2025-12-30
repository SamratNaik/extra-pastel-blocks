package com.sam.extrapastelblocks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup EXTRA_PASTEL_BLOCKS = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(ExtraPastelBlocks.MOD_ID, "extra_pastel_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(
                            ModBlocks.getAllBlocks().values().iterator().next()
                    ))
                    .displayName(Text.translatable(
                            "itemGroup.extrapastelblocks.extra_pastel_blocks"
                    ))
                    .entries((context, entries) -> {
                        ModBlocks.getAllBlocks().values().forEach(entries::add);

                    })
                    .build()
    );

    public static void register() {
        // forces class loading
    }
}
