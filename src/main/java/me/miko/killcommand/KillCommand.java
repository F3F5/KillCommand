package me.miko.killcommand;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class KillCommand extends JavaPlugin {
    private final CommandExecutor killExecutor = new KillExecutor();

    @Override
    public void onEnable() {
        registerCommand("kill");
    }

    @Override
    public void onDisable() {
    }

    private void registerCommand(String commandName) {
        getCommand(commandName).setExecutor(killExecutor);
    }
}
