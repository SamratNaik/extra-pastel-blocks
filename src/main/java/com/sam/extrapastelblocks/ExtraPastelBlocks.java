package com.sam.extrapastelblocks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;

public class ExtraPastelBlocks implements ModInitializer {

    public static final String MOD_ID = "extrapastelblocks";

    @Override
    public void onInitialize() {
        ModBlocks.register();
        ModItemGroup.register();


    }
}
