package com.lothrazar.cyclic.config;

import java.awt.Color;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.registry.ItemRegistry;
import com.lothrazar.cyclic.registry.TileRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

/**
 * TODO: fully refactor this as ConfigTemplate flow
 *
 * @author lothr
 */
public class ClientConfigCyclic {
    private static final Color DEFAULTC = Color.GRAY;
    public static ConfigValue<String> COLLECTOR_ITEM;
    public static ConfigValue<String> COLLECTOR_FLUID;
    public static ConfigValue<String> DETECTOR_ENTITY;
    public static ConfigValue<String> DETECTOR_ITEM;
    public static ConfigValue<String> DROPPER;
    public static ConfigValue<String> FORESTER;
    public static ConfigValue<String> HARVESTER;
    public static ConfigValue<String> MINER;
    public static ConfigValue<String> PEAT_FARM;
    public static ConfigValue<String> STRUCTURE;
    public static ConfigValue<String> LOCATION;
    public static ConfigValue<String> SHAPE_DATA;
    public static ConfigValue<String> RANDOMIZE_SCEPTER;
    public static ConfigValue<String> OFFSET_SCEPTER;
    public static ConfigValue<String> REPLACE_SCEPTER;
    public static ConfigValue<String> BUILD_SCEPTER;
    public static ConfigValue<Boolean> FLUID_BLOCK_STATUS;

    public static Color getColor(BlockEntity tile) {
        return DEFAULTC;
    }


    public static Color getColor(ItemStack item) {
        return DEFAULTC;
    }
}
