package com.jack.homes;

import com.jack.homes.commands.HomeCommand;
import com.jack.homes.commands.SetHomeCommand;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class HomePlugin extends JavaPlugin {

    private HashMap<UUID, Location> homes;
    private HomeFiles files;

    @Override
    public void onEnable() {
        this.homes = new HashMap<>();
        this.files = new HomeFiles(this);
        this.files.initialise();

        getCommand("sethome").setExecutor(new SetHomeCommand(this));
        getCommand("home").setExecutor(new HomeCommand(this));
    }

    @Override
    public void onDisable() {
        this.files.terminate();
    }

    public void addHome(UUID id, Location location) {
        this.homes.put(id, location);
    }

    public Location getHome(UUID id) {
        return this.homes.get(id);
    }

    public boolean hasHome(UUID id) {
        return this.homes.containsKey(id);
    }

    public HashMap<UUID, Location> getHomes() {
        return homes;
    }

    public HomeFiles getFiles() {
        return files;
    }

}
