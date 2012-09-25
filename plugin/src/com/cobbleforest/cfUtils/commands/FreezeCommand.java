package com.cobbleforest.cfUtils.commands;

import com.cobbleforest.cfUtils.Core;
import com.cobbleforest.cfUtils.Objects.CommandBase;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * User: Benjamin
 * Date: 25/09/12
 * Time: 07:24
 */
public class FreezeCommand extends CommandBase {

    public FreezeCommand(Core core) {
        super(core);
    }

    @Override
    protected void run(CommandSender sender, String[] args, Player player, String playerName) {
        Permission permission = core.getPermissionHandler().getPermission();
        if (permission.has(player, "cfutils.freeze")) {
            if (args.length == 1) {
                if (core.getServer().getPlayer(args[0]) != null) {
                    String playertofreeze = core.getServer().getPlayer(args[0]).getName();
                    if (core.getFrozenPlayers().contains(playertofreeze)) {
                        core.getFrozenPlayers().remove(playertofreeze);
                    } else {
                        core.getFrozenPlayers().add(playertofreeze);
                    }

                    for (Player player1 : core.getServer().getOnlinePlayers()) {
                        if (permission.getPrimaryGroup(player1).equalsIgnoreCase("Admin")) {
                            player1.sendMessage(ChatColor.GRAY + "[CF]: Freeze toggled on " + playertofreeze);
                        }
                    }

                }
            }

        }
    }
}
