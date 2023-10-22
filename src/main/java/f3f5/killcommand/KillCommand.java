package f3f5.killcommand;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class KillCommand extends JavaPlugin {
    private final CommandExecutor killExecutor = new KillExecutor();

    @Override
    public void onEnable() {
        registerCommand("kill");
        registerCommand("suicide");
    }

    @Override
    public void onDisable() {
    }

    private void registerCommand(String commandName) {
        getCommand(commandName).setExecutor(killExecutor);
    }
}
