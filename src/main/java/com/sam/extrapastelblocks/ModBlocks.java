package com.sam.extrapastelblocks;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModBlocks {

    // Base blocks only
    private static final Map<String, Block> BLOCKS = new LinkedHashMap<>();
    // Base + stairs + slabs (for creative tab)
    private static final Map<String, Block> EXTRA_BLOCKS = new LinkedHashMap<>();

    static {
        registerBase("chalk_white_block");
        registerBase("ivory_block");
        registerBase("cream_block");
        registerBase("warm_beige_block");
        registerBase("cool_beige_block");

        registerBase("light_gray_block");
        registerBase("ash_gray_block");
        registerBase("stone_gray_block");
        registerBase("slate_gray_block");
        registerBase("charcoal_block");

        registerBase("soft_sand_block");
        registerBase("tan_block");
        registerBase("oak_brown_block");
        registerBase("walnut_brown_block");
        registerBase("dark_brown_block");

        registerBase("soft_red_block");
        registerBase("soft_clay_block");
        registerBase("rust_block");
        registerBase("burnt_orange_block");
        registerBase("peach_block");

        registerBase("mint_block");
        registerBase("sage_block");
        registerBase("olive_block");
        registerBase("teal_block");
        registerBase("deep_teal_block");

        registerBase("lavender_block");
        registerBase("soft_pink_block");
        registerBase("magenta_block");
        registerBase("soft_blue_block");
        registerBase("deep_blue_block");
    }

    /* ================= REGISTRATION ================= */

    private static void registerBase(String name) {

        // Base block
        Block base = new Block(
                AbstractBlock.Settings
                        .copy(Blocks.STONE)
                        .strength(0.1f,6f) // 👈 stone-like hardness & resistance
        );

        register(name, base);
        BLOCKS.put(name, base);

        // Stairs
        register(
                name + "_stairs",
                new StairsBlock(
                        base.getDefaultState(),
                        AbstractBlock.Settings
                                .copy(base)

                )
        );

        // Slab
        register(
                name + "_slab",
                new SlabBlock(
                        AbstractBlock.Settings
                                .copy(base)

                )
        );
    }

    private static void register(String name, Block block) {
        Identifier id = new Identifier(ExtraPastelBlocks.MOD_ID, name);

        Registry.register(Registries.BLOCK, id, block);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));

        EXTRA_BLOCKS.put(name, block);
    }

    public static void register() {
        // force class load
    }

    /** Used by creative tab */
    public static Map<String, Block> getAllBlocks() {
        return EXTRA_BLOCKS;
    }
}
