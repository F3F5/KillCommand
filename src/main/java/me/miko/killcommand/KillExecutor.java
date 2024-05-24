package me.miko.killcommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class KillExecutor implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!hasPermission(sender, "KillCommand.kill") || (args.length > 0 && !hasPermission(sender, "KillCommand.kill.others"))) {
            sender.sendMessage(ChatColor.RED + "I'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.");
            return true;
        }

        Player player = (args.length == 0 && sender instanceof Player) ? (Player) sender : (args.length > 0 ? Bukkit.getPlayer(args[0]) : null);
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        player.setLastDamageCause(new EntityDamageEvent(player, EntityDamageEvent.DamageCause.SUICIDE, Integer.MAX_VALUE));
        player.setHealth(Double.MIN_VALUE);
        return true;
    }

    private boolean hasPermission(CommandSender sender, String permission) {
        return sender.hasPermission(permission);
    }
}