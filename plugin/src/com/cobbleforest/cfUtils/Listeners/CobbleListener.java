package com.cobbleforest.cfUtils.Listeners;

import com.cobbleforest.cfUtils.Core;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;
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

    @EventHandler(priority = EventPriority.LOWEST)
    public void onMove(PlayerMoveEvent event) {
        if (core.getFrozenPlayers().contains(event.getPlayer().getName())) {
            event.setTo(event.getFrom());
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onHurt(EntityDamageEvent event) {
        if (event.getEntityType().equals(EntityType.PLAYER)) {
            Player player = (Player) event.getEntity();
            if (core.getFrozenPlayers().contains(player.getName())) {
                event.setCancelled(true);
            }


        }

    }
}
