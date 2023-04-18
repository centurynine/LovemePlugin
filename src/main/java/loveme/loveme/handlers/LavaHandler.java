package loveme.loveme.handlers;

import loveme.loveme.Loveme;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class LavaHandler implements Listener {
    public LavaHandler(Loveme plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerOnLava(EntityDamageEvent event){
        Entity player = event.getEntity();

        if (player.getLastDamageCause() != null && player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.LAVA){
            player.sendMessage("You in lava!");
            Player player2 = (Player) player; // แปลงเป็น Player object
            player2.setHealth(player2.getHealth() - 4);
            Bukkit.getLogger().info("Player in lava");
        }

    }
}
