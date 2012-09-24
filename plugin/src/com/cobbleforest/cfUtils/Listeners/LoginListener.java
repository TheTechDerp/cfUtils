package com.cobbleforest.cfUtils.Listeners;

import com.cobbleforest.cfUtils.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * User: Benjamin
 * Date: 24/09/12
 * Time: 22:13
 */
public class LoginListener implements Listener {
    final Core core;

    public LoginListener(Core core) {
        this.core = core;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
    }

}
