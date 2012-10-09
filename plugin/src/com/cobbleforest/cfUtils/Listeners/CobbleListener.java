package com.cobbleforest.cfUtils.Listeners;

import com.cobbleforest.cfUtils.Core;
import com.cobbleforest.cfUtils.Publisher;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * User: Benjamin
 * Date: 24/09/12
 * Time: 22:13
 */
public class CobbleListener implements org.bukkit.event.Listener {
    final Core core;
    final Publisher publisher;
    public CobbleListener(Core core) {
        this.core = core;
        publisher = core.getPublisher();
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

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GREEN + player.getDisplayName() +  " joined!");
        scheduleUpdate();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.RED + player.getDisplayName() +  " ran away!");
        scheduleUpdate();
    }

    void scheduleUpdate(){
        core.getServer().getScheduler().scheduleAsyncDelayedTask(core, new Runnable() {

            public void run() {
                publisher.update();
            }
        });
    }
}
