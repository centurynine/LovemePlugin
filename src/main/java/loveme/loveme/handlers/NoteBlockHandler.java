package loveme.loveme.handlers;

import loveme.loveme.Loveme;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class NoteBlockHandler implements Listener {
    public NoteBlockHandler(Loveme plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onNoteBlockPlace(BlockPlaceEvent event){

        if(event.getBlock().getType() == Material.NOTE_BLOCK){
            if(event.getPlayer().hasPermission("loveme.admin")){
                return;
            }

            if(event.getPlayer().hasPermission("loveme.block.noteblock")){
                String PlayerName = event.getPlayer().getName();
                Bukkit.getLogger().info("[Loveme] Player "+PlayerName+" has placed noteblock!");
                event.getBlock().setType(Material.GRASS_BLOCK);
                return;
            }
        }

    }

}
