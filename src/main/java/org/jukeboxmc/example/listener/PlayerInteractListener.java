package org.jukeboxmc.example.listener;

import org.jukeboxmc.event.EventHandler;
import org.jukeboxmc.event.Listener;
import org.jukeboxmc.event.player.PlayerInteractEvent;
import org.jukeboxmc.form.ButtonList;
import org.jukeboxmc.item.Item;
import org.jukeboxmc.item.ItemType;
import org.jukeboxmc.math.Vector;
import org.jukeboxmc.player.Player;
import org.jukeboxmc.world.Dimension;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract( PlayerInteractEvent event ) {
        Player player = event.getPlayer();
        Item item = event.getItem();

        if ( item.getItemType().equals( ItemType.STICK ) ) {
            ButtonList buttonList = new ButtonList( "This is the title" );

            buttonList.addButton( "spawn", "Teleport to spawn" );
            buttonList.addButton( "random", "Teleport to a random position" );

            player.sendMessage( "YA" );

            player.showForm( buttonList ).onResponse( id -> {
                if ( id.equalsIgnoreCase( "spawn" ) ) {
                    player.teleport( player.getWorld().getSpawnLocation( Dimension.OVERWORLD ) );
                } else if ( id.equalsIgnoreCase( "random" ) ) {
                    int randomX = ThreadLocalRandom.current().nextInt( -100, 100 );
                    int randomY = ThreadLocalRandom.current().nextInt( 64, 100 );
                    int randomZ = ThreadLocalRandom.current().nextInt( -100, 100 );
                    player.teleport( new Vector( randomX, randomY, randomZ ) );
                }
            } );
        }
    }

}
