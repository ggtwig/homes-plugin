package com.jack.homes.commands;

import com.jack.homes.HomePlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class HomeCommand implements CommandExecutor {
    private final HomePlugin plugin;
    public HomeCommand(HomePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            UUID id = player.getUniqueId();

            if (!plugin.hasHome(id)) {
                player.sendMessage("§cYou do not have a home set!");
            } else {
                player.teleport(plugin.getHome(id));
                player.sendMessage("§aTeleporting!");
            }
        }
        return true;
    }
}
