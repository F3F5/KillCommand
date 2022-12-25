package f3f5.killcommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class KillExecutor implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("KillCommand.kill") || (args.length > 0 && !sender.hasPermission("KillCommand.kill.others"))) {
            sender.sendMessage(ChatColor.RED + "I'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.");
            return true;
        }
        if (!(sender instanceof Player) && args.length == 0) {
            sender.sendMessage(ChatColor.RED + "You must be a player to run this command without any arguments.");
            return true;
        }
        if (args.length == 0) {
            Player player1 = (Player)sender;
            player1.setHealth(0.0D);
            return true;
        }
        Player player = Bukkit.getPlayer(args[0]);
        player.setHealth(0.0D);
        return true;
    }
}
