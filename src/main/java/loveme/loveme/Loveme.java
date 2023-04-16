package loveme.loveme;

import loveme.loveme.handlers.NoteBlockHandler;
import loveme.loveme.handlers.TorchHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Loveme extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("[LOVEME] System started");

        new NoteBlockHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[LOVEME] System shutdown");
    }
}
