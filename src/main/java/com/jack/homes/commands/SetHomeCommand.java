package com.jack.homes.commands;

import com.jack.homes.HomePlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class SetHomeCommand implements CommandExecutor {
    private final HomePlugin plugin;
    public SetHomeCommand(HomePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            UUID id = player.getUniqueId();
            Location location = player.getLocation();

            plugin.addHome(id, location);
            player.sendMessage(ChatColor.GREEN + "Home has been set!");

            plugin.getFiles().addHome(id, location);

            if (plugin.hasHome(id)) {
                player.sendMessage(ChatColor.RED + "Your previous home was overwritten!");
            }
        }

        return true;
    }
}
