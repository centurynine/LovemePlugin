package loveme.loveme.handlers;

import loveme.loveme.Loveme;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class NoteBlockHandler implements Listener {
    public NoteBlockHandler(Loveme plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    /**
     * Lowest
     * Low
     * Normal
     * High
     * Highest
     * ------
     * Monitor
     */

    @EventHandler(priority = EventPriority.LOW)
    public void onNoteBlockPlace_Low(BlockPlaceEvent event){
        if(event.getBlock().getType() == Material.NOTE_BLOCK){
            event.getBlock().setType(Material.GRASS_BLOCK);
        }
    }
    @EventHandler
    public void onNoteBlockPlace_Normal(BlockPlaceEvent event) {
        Block block = event.getBlock();

        if(block.getType() != Material.NOTE_BLOCK){
            return;
        }

        Bukkit.getLogger().info("NoteBlock was placed");
    }
}
