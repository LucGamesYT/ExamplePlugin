package org.jukeboxmc.example.listener;

import org.jukeboxmc.JukeboxMC;
import org.jukeboxmc.event.EventHandler;
import org.jukeboxmc.event.Listener;
import org.jukeboxmc.event.player.PlayerJoinEvent;
import org.jukeboxmc.player.GameMode;
import org.jukeboxmc.player.Player;
import org.jukeboxmc.scoreboard.DisplaySlot;
import org.jukeboxmc.scoreboard.Scoreboard;
import org.jukeboxmc.scoreboard.ScoreboardDisplay;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin( PlayerJoinEvent event ) {
        Player player = event.getPlayer();

        player.addPermission( "jukeboxmc.example" ); // Add a permission to player
        player.removePermission( "jukeboxmc.permission" ); // Remove a permission from player

        player.setHealth( 10 ); //Set player health to 10
        player.setSaturation( 2 ); //Set the saturation to 2
        player.setHunger( 20 ); //Set the hunger (food) to 20
        player.setLevel( 34 ); //Set player level 34
        player.setExperience( 100 ); //Set the player 100 experience
        player.setGameMode( GameMode.CREATIVE ); //Set the player to creative
        player.sendTip( "This is a tip message" );
        player.sendPopup( "This is a popup message" );

        //Create a scoreboard!
        Scoreboard scoreboard = new Scoreboard();
        ScoreboardDisplay scoreboardDisplay = scoreboard.addDisplay( DisplaySlot.SIDEBAR, "dummy", " " + "This is the title" );

        scoreboardDisplay.addLine( "This is the first line", 0 );
        scoreboardDisplay.addLine( "§a", 1 ); //This is a empty line
        scoreboardDisplay.addLine( "§7Name§8: §e" + player.getNameTag(), 2 );
        scoreboardDisplay.addLine( "§b", 3 );
        scoreboardDisplay.addLine( "§cTPS: §e" + JukeboxMC.getCurrentTps(), 4 );

        scoreboard.showFor( player );

        event.setJoinMessage( "§l§aA player has joined the server!" );
    }

}
