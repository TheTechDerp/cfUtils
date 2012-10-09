package com.cobbleforest.cfUtils;

import com.cobbleforest.cfUtils.Handlers.MoneyHandler;
import com.cobbleforest.cfUtils.Handlers.PermissionHandler;
import com.cobbleforest.cfUtils.Listeners.CobbleListener;
import com.cobbleforest.cfUtils.commands.FreezeCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * User: Rainbow
 * Date: 24/09/12
 * Time:09:37
 */
public class Core extends JavaPlugin {
    Logger log;
    Publisher publisher;
    MoneyHandler moneyHandler;
    PermissionHandler permissionHandler;
    ArrayList<String> frozenPlayers = new ArrayList<String>();

    @Override
    public void onEnable() {
        log = getLogger();
        setupHandlers();
        publisher = new Publisher(this);
        getServer().getPluginManager().registerEvents(new CobbleListener(this), this);
        getCommand("freeze").setExecutor(new FreezeCommand(this));
    }

    @Override
    public void onDisable() {
    }

    private void setupHandlers() {
        moneyHandler = new MoneyHandler(this);
        permissionHandler = new PermissionHandler(this);
    }

    public void disable(String reason) {
        this.setEnabled(false);
        log.severe("Shutting down!");
        log.severe("Shutdown reason: " + reason);
    }

    public Logger getLog() {
        return log;
    }

    public MoneyHandler getMoneyHandler() {
        return moneyHandler;
    }

    public PermissionHandler getPermissionHandler() {
        return permissionHandler;
    }

    public ArrayList<String> getFrozenPlayers() {
        return frozenPlayers;
    }

    public Publisher getPublisher() {
        return publisher;
    }
}
