package com.gmail.nossr50.lumberjack;

import com.gmail.nossr50.lumberjack.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Adds benefits to logging
 */
public class LumberJack extends JavaPlugin {

    public static LumberJack p;

    @Override
    public void onEnable() {
        super.onEnable();

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        getLogger().info("Lumber Jack has loaded.");

        p = this;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getLogger().info("Lumber Jack has been disabled.");
    }
}
