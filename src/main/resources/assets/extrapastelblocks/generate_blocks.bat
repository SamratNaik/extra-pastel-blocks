@echo off
set MODID=extrapastelblocks

REM ===== LIST ALL BASE BLOCK NAMES (NO _block AT END) =====
set BLOCKS=chalk_white ivory cream warm_beige cool_beige ^
light_gray ash_gray stone_gray slate_gray charcoal ^
soft_sand tan oak_brown walnut_brown dark_brown ^
soft_red soft_clay rust burnt_orange peach ^
mint sage olive teal deep_teal ^
lavender soft_pink magenta soft_blue deep_blue

for %%B in (%BLOCKS%) do (
    echo Generating %%B...

    REM ================= STAIRS =================
    echo {> blockstates/%%B_block_stairs.json
    echo   "variants": {>> blockstates/%%B_block_stairs.json
    echo     "facing=east,half=bottom,shape=straight": { "model": "%MODID%:block/%%B_block_stairs" },>> blockstates/%%B_block_stairs.json
    echo     "facing=west,half=bottom,shape=straight": { "model": "%MODID%:block/%%B_block_stairs", "y": 180 },>> blockstates/%%B_block_stairs.json
    echo     "facing=south,half=bottom,shape=straight": { "model": "%MODID%:block/%%B_block_stairs", "y": 90 },>> blockstates/%%B_block_stairs.json
    echo     "facing=north,half=bottom,shape=straight": { "model": "%MODID%:block/%%B_block_stairs", "y": 270 },>> blockstates/%%B_block_stairs.json
    echo     "facing=east,half=top,shape=straight": { "model": "%MODID%:block/%%B_block_stairs", "x": 180 },>> blockstates/%%B_block_stairs.json
    echo     "facing=west,half=top,shape=straight": { "model": "%MODID%:block/%%B_block_stairs", "x": 180, "y": 180 },>> blockstates/%%B_block_stairs.json
    echo     "facing=south,half=top,shape=straight": { "model": "%MODID%:block/%%B_block_stairs", "x": 180, "y": 90 },>> blockstates/%%B_block_stairs.json
    echo     "facing=north,half=top,shape=straight": { "model": "%MODID%:block/%%B_block_stairs", "x": 180, "y": 270 }>> blockstates/%%B_block_stairs.json
    echo   }>> blockstates/%%B_block_stairs.json
    echo }>> blockstates/%%B_block_stairs.json

    echo {> models/block/%%B_block_stairs.json
    echo   "parent": "minecraft:block/stairs",>> models/block/%%B_block_stairs.json
    echo   "textures": {>> models/block/%%B_block_stairs.json
    echo     "bottom": "%MODID%:block/%%B_block",>> models/block/%%B_block_stairs.json
    echo     "top": "%MODID%:block/%%B_block",>> models/block/%%B_block_stairs.json
    echo     "side": "%MODID%:block/%%B_block">> models/block/%%B_block_stairs.json
    echo   }>> models/block/%%B_block_stairs.json
    echo }>> models/block/%%B_block_stairs.json

    echo {> models/item/%%B_block_stairs.json
    echo   "parent": "%MODID%:block/%%B_block_stairs">> models/item/%%B_block_stairs.json
    echo }>> models/item/%%B_block_stairs.json

    REM ================= SLABS =================
    echo {> blockstates/%%B_block_slab.json
    echo   "variants": {>> blockstates/%%B_block_slab.json
    echo     "type=bottom": { "model": "%MODID%:block/%%B_block_slab" },>> blockstates/%%B_block_slab.json
    echo     "type=top": { "model": "%MODID%:block/%%B_block_slab_top" },>> blockstates/%%B_block_slab.json
    echo     "type=double": { "model": "%MODID%:block/%%B_block" }>> blockstates/%%B_block_slab.json
    echo   }>> blockstates/%%B_block_slab.json
    echo }>> blockstates/%%B_block_slab.json

    echo {> models/block/%%B_block_slab.json
    echo   "parent": "minecraft:block/slab",>> models/block/%%B_block_slab.json
    echo   "textures": {>> models/block/%%B_block_slab.json
    echo     "bottom": "%MODID%:block/%%B_block",>> models/block/%%B_block_slab.json
    echo     "top": "%MODID%:block/%%B_block",>> models/block/%%B_block_slab.json
    echo     "side": "%MODID%:block/%%B_block">> models/block/%%B_block_slab.json
    echo   }>> models/block/%%B_block_slab.json
    echo }>> models/block/%%B_block_slab.json

    echo {> models/block/%%B_block_slab_top.json
    echo   "parent": "minecraft:block/slab_top",>> models/block/%%B_block_slab_top.json
    echo   "textures": {>> models/block/%%B_block_slab_top.json
    echo     "bottom": "%MODID%:block/%%B_block",>> models/block/%%B_block_slab_top.json
    echo     "top": "%MODID%:block/%%B_block",>> models/block/%%B_block_slab_top.json
    echo     "side": "%MODID%:block/%%B_block">> models/block/%%B_block_slab_top.json
    echo   }>> models/block/%%B_block_slab_top.json
    echo }>> models/block/%%B_block_slab_top.json

    echo {> models/item/%%B_block_slab.json
    echo   "parent": "%MODID%:block/%%B_block_slab">> models/item/%%B_block_slab.json
    echo }>> models/item/%%B_block_slab.json
)

echo DONE! All stairs & slabs generated.
pause
