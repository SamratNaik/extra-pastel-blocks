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
            Identifier.of(ExtraPastelBlocks.MOD_ID, "extra_pastel_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(
                            Registries.ITEM.get(
                                    Identifier.of(ExtraPastelBlocks.MOD_ID, "chalk_white_block")
                            )
                    ))
                    .displayName(Text.translatable("itemgroup.extrapastelblocks"))
                    .entries((context, entries) -> {

                        // (recommended): only base blocks
                        ModBlocks.getBaseBlocks()
                                .forEach(block -> entries.add(block.asItem()));


                    })
                    .build()
    );

    public static void register() {}
}
