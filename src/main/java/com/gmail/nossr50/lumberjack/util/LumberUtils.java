package com.gmail.nossr50.lumberjack.util;

import com.gmail.nossr50.lumberjack.datatypes.TreeSpecies;
import org.bukkit.Location;
import org.bukkit.Material;

import org.bukkit.block.BlockState;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class LumberUtils {
    public static boolean isWood(BlockState blockState)
    {
        switch(blockState.getType())
        {
            case ACACIA_LOG:
            case BIRCH_LOG:
            case DARK_OAK_LOG:
            case JUNGLE_LOG:
            case OAK_LOG:
            case SPRUCE_LOG:
                return true;
            default:
                return false;
        }
    }

    public static void dropResources(BlockState blockState, Location dropLocation)
    {
        TreeSpecies treeSpecies = getTreeSpecies(blockState);

        //Randomize Drops
        Random random = new Random();
        int amount = random.nextInt(4);

        if(amount > 0)
        {
            ItemStack planks = new ItemStack(getPlankType(treeSpecies), amount);

            //Drop Planks
            dropLocation.getWorld().dropItemNaturally(dropLocation, planks);
        }

        //Drop XP
        dropLocation.getWorld().spawnEntity(dropLocation, EntityType.EXPERIENCE_ORB);
        dropLocation.getWorld().spawnEntity(dropLocation, EntityType.EXPERIENCE_ORB);
    }

    public static Material getPlankType(TreeSpecies treeSpecies)
    {
        switch(treeSpecies)
        {
            case ACACIA:
                return Material.ACACIA_PLANKS;
            case BIRCH:
                return Material.BIRCH_PLANKS;
            case DARK_OAK:
                return Material.DARK_OAK_PLANKS;
            case OAK:
                return Material.OAK_PLANKS;
            case SPRUCE:
                return Material.SPRUCE_PLANKS;
            case JUNGLE:
                return Material.JUNGLE_PLANKS;
            default:
                return Material.BIRCH_PLANKS;
        }
    }

    public static TreeSpecies getTreeSpecies(BlockState blockState)
    {
        switch(blockState.getType())
        {
            case ACACIA_LOG:
                return TreeSpecies.ACACIA;
            case BIRCH_LOG:
                return TreeSpecies.BIRCH;
            case DARK_OAK_LOG:
                return TreeSpecies.DARK_OAK;
            case JUNGLE_LOG:
                return TreeSpecies.JUNGLE;
            case OAK_LOG:
                return TreeSpecies.OAK;
            case SPRUCE_LOG:
                return TreeSpecies.SPRUCE;
            default:
                return TreeSpecies.BIRCH;
        }
    }

    public static boolean isItemAxe(ItemStack itemStack)
    {
        switch(itemStack.getType())
        {
            case DIAMOND_AXE:
            case GOLDEN_AXE:
            case IRON_AXE:
            case STONE_AXE:
            case WOODEN_AXE:
                return true;
            default:
                return false;
        }
    }
}
