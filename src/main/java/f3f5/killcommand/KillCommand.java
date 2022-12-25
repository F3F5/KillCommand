package f3f5.killcommand;

import org.bukkit.plugin.java.JavaPlugin;

public class KillCommand extends JavaPlugin {
    public void onEnable() {
        getCommand("kill").setExecutor(new KillExecutor());
        getCommand("suicide").setExecutor(new KillExecutor());
    }

    public void onDisable() {}
}


