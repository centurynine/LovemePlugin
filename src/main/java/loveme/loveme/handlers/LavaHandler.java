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
    public LavaHandler(Loveme plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private double valueDamage;

    public void setValue(double value) {
        this.valueDamage = value;
    }

    @EventHandler
    public void playerOnLava(EntityDamageEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (player.getLastDamageCause() != null && player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.LAVA) {
                double newHealth = player.getHealth() - valueDamage;
                if (newHealth <= 0 ) {
                    player.setHealth(0);
                }
                else {
                    player.setHealth(newHealth);
                }
            }
        }
    }
}