package loveme.loveme.MonsterScan;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandScan implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only player can run this command.");

            return true;
        }

        Player player = (Player) sender;
        String targetMonsterName = "Zombie"; // ชื่อมอนสเตอร์ที่ต้องการสแกน
        int scanRange = 5; // ระยะที่ต้องการสแกน (บล็อค)

        // หากไม่ใช่ผู้เล่น
            for (Entity entity : player.getNearbyEntities(scanRange, scanRange, scanRange)) {
                if (entity.getType() == EntityType.valueOf(targetMonsterName.toUpperCase())) {
                    player.sendMessage("พบมอนสเตอร์ชื่อ " + targetMonsterName + " อยู่ใกล้คุณ!");
                    Bukkit.getLogger().info("พบมอนสเตอร์ชื่อ " + targetMonsterName + " อยู่ใกล้ " + player.getName());
                    return true;
                }

            }
        player.sendMessage("ไม่พบมอนสเตอร์ " + targetMonsterName + " ในระยะ "+ scanRange + "บล็อค");
        return true;


    }
}
