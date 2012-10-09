package com.cobbleforest.cfUtils;

import org.bukkit.Server;
import redis.clients.jedis.Jedis;

/**
 * User: TehRainbowGuy
 * Date: 09/10/12
 * Time: 17:48
 */
public class Publisher {
    final Jedis jedis;
    final Core core;
    final int MAXPLAYERS;
    final Server server;

    public Publisher(Core core) {
        this.core = core;
        this.jedis = new Jedis("localhost");
        this.server = core.getServer();
        MAXPLAYERS = server.getMaxPlayers();
    }

    public void update(){
        int online = server.getOnlinePlayers().length;
        String updateString = online+":"+MAXPLAYERS;
        jedis.publish("mainStats",updateString);
    }


}
