package com.cobbleforest.cfUtils;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * User: Rainbow
 * Date: 24/09/12
 * Time: 09:37
 */
public class Core extends JavaPlugin {
    Logger log;

    @Override
    public void onEnable() {
        log = getLogger();
    }

    @Override
    public void onDisable() {
    }

    public void disable(String reason) {
        this.setEnabled(false);
        log.severe("Shutting down!");
        log.severe("Shutdown reason: " + reason);
    }


}
