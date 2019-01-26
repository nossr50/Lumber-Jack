package com.gmail.nossr50.lumberjack.listeners;

import com.gmail.nossr50.lumberjack.util.LumberUtils;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.Plugin;

/**
 * Listener
 */
public class PlayerListener implements Listener {
    private Plugin plugin;

    public PlayerListener(Plugin plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        if(event.isCancelled())
            return;

        if(event.getAction() != Action.RIGHT_CLICK_BLOCK)
            return;

        BlockState blockState = event.getClickedBlock().getState();
        if(LumberUtils.isWood(blockState) && LumberUtils.isItemAxe(event.getPlayer().getInventory().getItemInMainHand()))
        {

            Location dropLocation = blockState.getLocation();
            LumberUtils.dropResources(blockState, dropLocation);
        }
    }
}
