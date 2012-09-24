package com.cobbleforest.cfUtils;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;

/**
 * User: Benjamin
 * Date: 24/09/12
 * Time: 09:46
 */
public class PermissionHandler {
    final Permission permission;
    final Core core;

    public PermissionHandler(Core core) {
        this.core = core;
        permission = setupPermissions();

        if (permission == null) {
            core.disable("Permissions not enabled!");
        }
    }

    private Permission setupPermissions() {
        RegisteredServiceProvider<Permission> permissionProvider = core.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        Permission retVal = null;
        if (permissionProvider != null) {
            retVal = permissionProvider.getProvider();
        }
        return retVal;
    }
}
