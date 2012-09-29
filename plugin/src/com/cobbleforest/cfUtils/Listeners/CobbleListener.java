package com.cobbleforest.cfUtils.Listeners;

import com.cobbleforest.cfUtils.Core;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
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

//    final String ERRORPREFIX = ChatColor.RED + "[CF]: NOPE. ";
//
//    @EventHandler
//    public void onSign(SignChangeEvent event) {
//        Permission permission = core.getPermissionHandler().getPermission();
//        Player player = event.getPlayer();
//        Block sign = event.getBlock();
//
//        if (event.getLine(0).equalsIgnoreCase("[CFU]:PaySign")) {
//            if (!permission.has(player, "cfUtils.PaySign")) {
//                player.sendMessage(ERRORPREFIX + "(NOPERMISSION)");
//                sign.breakNaturally();
//            }
//            if (event.getLine(1).isEmpty() || event.getLine(2).isEmpty()) {
//                player.sendMessage(ERRORPREFIX + "(EMPTYLINE)");
//                sign.breakNaturally();
//                return;
//            }
//            int price;
//            try {
//                price = Integer.parseInt(event.getLine(2));
//            } catch (NumberFormatException e) {
//                player.sendMessage(ERRORPREFIX + "(NaN)");
//                sign.breakNaturally();
//                return;
//            }
//
//            Sign sign2 = (Sign) sign.getState();
//            sign2.setLine(2, price + " Pebbles");
//
//            if (sign2.getLine(1).startsWith("/")) {
//                sign2.setLine(1, sign2.getLine(2).substring(1));
//            }
//            sign2.setLine(0, ChatColor.AQUA + "[CFU]:PaySign");
//        }
//
//
//    }
//
//    @EventHandler
//    public void onInteract(PlayerInteractEvent event) {
//        Player player = event.getPlayer();
//        Block block = event.getClickedBlock();
//        Economy economy = core.getMoneyHandler().getEconomy();
//        if (block != null) {
//            Material type = block.getType();
//            if (type == Material.SIGN_POST || type == Material.SIGN) {
//                Sign sign = (Sign) block.getState();
//                if (ChatColor.stripColor(sign.getLine(0)).equals("[CFU]:PaySign")) {
//                    String command = sign.getLine(1);
//                    int price = Integer.parseInt(sign.getLine(2));
//                    if (economy.getBalance(player.getName()) >= price) {
//                        core.getServer().dispatchCommand(core.getServer().getConsoleSender(), command);
//                        economy.withdrawPlayer(player.getName(), price);
//                    } else {
//                        player.sendMessage(ERRORPREFIX + "(YOU ARE TOO POOR)");
//                    }
//                }
//            }
//        }
//
//    }
}
