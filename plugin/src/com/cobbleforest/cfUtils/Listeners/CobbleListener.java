package com.cobbleforest.cfUtils.Listeners;

import com.cobbleforest.cfUtils.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * User: Benjamin
 * Date: 24/09/12
 * Time: 22:13
 */
public class CobbleListener implements org.bukkit.event.Listener {
    final Core core;

    public CobbleListener(Core core) {
        this.core = core;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (core.getFrozenPlayers().contains(event.getPlayer().getName())) {
            event.setTo(event.getFrom());
        }
    }
}
