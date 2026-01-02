package com.sam.extrapastelblocks;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ModBlocks {

    // ALL blocks (base + stairs + slabs)
    private static final Map<String, Block> ALL_BLOCKS = new LinkedHashMap<>();

    // ONLY base blocks (optional, useful for item group)
    private static final Map<String, Block> BASE_BLOCKS = new LinkedHashMap<>();

    static {
        registerSet("chalk_white_block");
        registerSet("ivory_block");
        registerSet("cream_block");
        registerSet("warm_beige_block");
        registerSet("cool_beige_block");

        registerSet("light_gray_block");
        registerSet("ash_gray_block");
        registerSet("stone_gray_block");
        registerSet("slate_gray_block");
        registerSet("charcoal_block");

        registerSet("soft_sand_block");
        registerSet("tan_block");
        registerSet("oak_brown_block");
        registerSet("walnut_brown_block");
        registerSet("dark_brown_block");

        registerSet("soft_red_block");
        registerSet("soft_clay_block");
        registerSet("rust_block");
        registerSet("burnt_orange_block");
        registerSet("peach_block");

        registerSet("mint_block");
        registerSet("sage_block");
        registerSet("olive_block");
        registerSet("teal_block");
        registerSet("deep_teal_block");

        registerSet("lavender_block");
        registerSet("soft_pink_block");
        registerSet("magenta_block");
        registerSet("soft_blue_block");
        registerSet("deep_blue_block");
    }

    private static void registerSet(String name) {

        // Base block (easy to break, NO tool logic)
        Block base = registerBlock(
                name,
                new Block(
                        AbstractBlock.Settings
                                .copy(Blocks.STONE)
                                .strength(0.1f) // 👈 EASY TO BREAK
                                .sounds(BlockSoundGroup.STONE)
                )
        );

        BASE_BLOCKS.put(name, base);

        // Stairs
        registerBlock(
                name + "_stairs",
                new StairsBlock(
                        base.getDefaultState(),
                        AbstractBlock.Settings.copy(base)
                )
        );

        // Slab
        registerBlock(
                name + "_slab",
                new SlabBlock(
                        AbstractBlock.Settings.copy(base)
                )
        );
    }

    private static Block registerBlock(String name, Block block) {
        Identifier id = Identifier.of(ExtraPastelBlocks.MOD_ID, name);

        Registry.register(Registries.BLOCK, id, block);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));

        ALL_BLOCKS.put(name, block);
        return block;
    }

    // ===== PUBLIC ACCESSORS =====

    /** Use this if you want EVERYTHING (blocks + stairs + slabs) */
    public static Collection<Block> getAllBlocks() {
        return ALL_BLOCKS.values();
    }

    /** Use this if you want ONLY the main pastel blocks */
    public static Collection<Block> getBaseBlocks() {
        return BASE_BLOCKS.values();
    }

    public static void register() {}
}
