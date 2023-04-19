package loveme.loveme.MonsterScan;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.List;

public class CommandScan implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only player can run this command.");

            return true;
        }

        Player player = (Player) sender;

        if (player.getPlayer().hasPermission("loveme.admin")) {
            if (args.length == 1) {
                String monsterName = args[0].toLowerCase(); // ชื่อมอนสเตอร์ที่ต้องการหา (แปลงเป็นตัวพิมพ์เล็กทั้งหมด)

                int range = 50; // ระยะทางสำหรับการค้นหา (50 บล็อค)
                List<Entity> entities = player.getNearbyEntities(range, range, range);
                for (Entity entity : entities) {
                    String entityType = entity.getType().toString().toLowerCase(); // ชื่อประเภทของมอนสเตอร์ (แปลงเป็นตัวพิมพ์เล็กทั้งหมด)
                    if (entityType.contains(monsterName)) {
                        int x = entity.getLocation().getBlockX();
                        int y = entity.getLocation().getBlockY();
                        int z = entity.getLocation().getBlockZ();
                        player.sendMessage(ChatColor.GREEN + "มอนสเตอร์ " + entityType + " อยู่ที่ x:" + x + " y:" + y + " z:" + z);
                        return true;
                    }
                }
                player.sendMessage("ไม่พบมอนสเตอร์ " + monsterName + " ในระยะ " + range + "บล็อค");
            } else {
                player.sendMessage(ChatColor.RED + "กรุณาระบุชื่อมอนสเตอร์ที่ต้องการค้นหา");
            }
            return true;
        }
        return true;
    }
}

