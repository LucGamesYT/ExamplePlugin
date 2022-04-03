package org.jukeboxmc.example.listener;

import org.jukeboxmc.event.EventHandler;
import org.jukeboxmc.event.Listener;
import org.jukeboxmc.event.player.PlayerQuitEvent;
import org.jukeboxmc.player.Player;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit ( PlayerQuitEvent event ) {
        Player player = event.getPlayer();
        event.setQuitMessage( "§7The boss §e" + player.getNameTag() + " §7left the game" );
    }

}
