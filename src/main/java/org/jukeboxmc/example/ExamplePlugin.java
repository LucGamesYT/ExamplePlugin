package org.jukeboxmc.example;

import org.jukeboxmc.JukeboxMC;
import org.jukeboxmc.command.CommandManager;
import org.jukeboxmc.example.command.GiveItemCommand;
import org.jukeboxmc.example.listener.EntityDamageByEntityListener;
import org.jukeboxmc.example.listener.PlayerInteractListener;
import org.jukeboxmc.example.listener.PlayerJoinListener;
import org.jukeboxmc.example.listener.PlayerQuitListener;
import org.jukeboxmc.plugin.Plugin;
import org.jukeboxmc.plugin.PluginManager;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class ExamplePlugin extends Plugin {

    @Override
    public void onStartup() {
        this.getLogger().info( "Startup!" );
    }

    @Override
    public void onEnable() {
        PluginManager pluginManager = JukeboxMC.getPluginManager();
        pluginManager.registerListener( new PlayerJoinListener() );
        pluginManager.registerListener( new PlayerQuitListener() );
        pluginManager.registerListener( new PlayerInteractListener() );
        pluginManager.registerListener( new EntityDamageByEntityListener() );

        CommandManager commandManager = pluginManager.getCommandManager();
        commandManager.registerCommand( new GiveItemCommand() );

        this.getLogger().info( "Plugin is enabled!" );
    }

    @Override
    public void onDisable() {
        this.getLogger().info( "Disable plugin!" );
    }
}
