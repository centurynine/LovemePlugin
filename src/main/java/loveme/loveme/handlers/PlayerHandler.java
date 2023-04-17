package loveme.loveme.handlers;

import loveme.loveme.Loveme;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerHandler implements Listener {
    public PlayerHandler(Loveme plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        ItemStack item = new ItemStack(Material.TORCH, 32);
        Inventory inv = player.getInventory();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Tech");
        item.setItemMeta(meta);

        inv.addItem(item);
        inv.setItem(8, item);
    }
}
