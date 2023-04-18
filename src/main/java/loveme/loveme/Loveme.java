package loveme.loveme;

import loveme.loveme.handlers.LavaHandler;
import loveme.loveme.handlers.NoteBlockHandler;
import loveme.loveme.handlers.PlayerHandler;
import loveme.loveme.handlers.TorchHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Loveme extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("[Loveme] System started");

        saveDefaultConfig();
        List<String> kitItem = (List<String>) getConfig().getList("kit");
        for (String itemName : kitItem){
            Bukkit.getLogger().info((itemName));
        }
        double LavaDamage = getConfig().getDouble("lava_damage");
        Bukkit.getLogger().info(String.valueOf(LavaDamage));
        new NoteBlockHandler(this);
        LavaHandler LavaDamageSend = new LavaHandler(this);
        LavaDamageSend.setValue(LavaDamage);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[Loveme] System shutdown");
    }
}
