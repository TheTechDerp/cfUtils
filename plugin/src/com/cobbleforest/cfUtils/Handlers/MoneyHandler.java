package com.cobbleforest.cfUtils.Handlers;

import com.cobbleforest.cfUtils.Core;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;

/**
 * User: Benjamin
 * Date: 24/09/12
 * Time: 21:41
 */
public class MoneyHandler {
    final Economy economy;
    final Core core;

    public MoneyHandler(Core core) {
        this.core = core;
        economy = setupEconomy();
        if (economy == null) {
            core.disable("Economy not found!");
        }

    }

    private Economy setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = core.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            return economyProvider.getProvider();
        }

        return null;
    }

    public Economy getEconomy() {
        return economy;
    }
}
