package org.jukeboxmc.example.command;

import org.jukeboxmc.command.Command;
import org.jukeboxmc.command.CommandSender;
import org.jukeboxmc.command.annotation.Alias;
import org.jukeboxmc.command.annotation.Description;
import org.jukeboxmc.command.annotation.Name;
import org.jukeboxmc.item.ItemType;
import org.jukeboxmc.player.Player;

/**
 * @author LucGamesYT
 * @version 1.0
 */
@Name ( "give" )
@Description("Give a item")
//@Permission("jukeboxmc.command.example") Add a permission to this command
@Alias("giveitem")
public class GiveItemCommand extends Command {

    @Override
    public void execute( CommandSender commandSender, String s, String[] args ) {
        if ( commandSender instanceof Player player) {
            player.getInventory().addItem( ItemType.OAK_PLANKS.getItem().setAmount( 32 ) );
            player.getInventory().setItem( 2, ItemType.FENCE_GATE.getItem() );
            player.sendMessage( "You got 2 item!" );
        } else {
            commandSender.sendMessage( "You must be a player!" );
        }
    }
}
