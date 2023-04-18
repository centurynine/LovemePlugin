package loveme.loveme.MonsterScan;

import loveme.loveme.Loveme;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

public class MonsterScanHandler implements Listener {

    public MonsterScanHandler(Loveme plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    // สร้างเมธอดหรือฟังก์ชันที่ต้องการใช้งาน
    @EventHandler
    public void scanForMonster(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        String targetMonsterName = "Zombie"; // ชื่อมอนสเตอร์ที่ต้องการสแกน
        int scanRange = 5; // ระยะที่ต้องการสแกน (บล็อค)

        // หากไม่ใช่ผู้เล่น


        if(event.getBlock().getType() == Material.OAK_PLANKS) {
            for (Entity entity : player.getNearbyEntities(scanRange, scanRange, scanRange)) {
                if (entity.getType() == EntityType.valueOf(targetMonsterName.toUpperCase())) {
                    player.sendMessage("พบมอนสเตอร์ชื่อ " + targetMonsterName + " อยู่ใกล้คุณ!");
                    Bukkit.getLogger().info("พบมอนสเตอร์ชื่อ " + targetMonsterName + " อยู่ใกล้ " + player.getName());
                    return;
                }
            }
        }

    }
}