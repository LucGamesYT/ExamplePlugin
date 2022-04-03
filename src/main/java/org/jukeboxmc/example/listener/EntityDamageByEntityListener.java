package org.jukeboxmc.example.listener;

import org.jukeboxmc.JukeboxMC;
import org.jukeboxmc.entity.Entity;
import org.jukeboxmc.event.EventHandler;
import org.jukeboxmc.event.Listener;
import org.jukeboxmc.event.entity.EntityDamageByEntityEvent;
import org.jukeboxmc.player.Player;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class EntityDamageByEntityListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity( EntityDamageByEntityEvent event ) {
        Entity damager = event.getDamager();

        if ( damager instanceof Player player ) {
            JukeboxMC.getScheduler().scheduleDelayed( () -> {
                player.sendMessage( "This message is 3 seconds delayed" );
            }, 20 * 3 );
        } else {
            event.setCancelled( true ); //If damager is not a player the event will be canceled
        }
    }

}
