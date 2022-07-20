package httbows.httbows;


import commands.HTTbows;
import events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HTTBows extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("HTTrolplay started correctly");
        registerCommands();
        getServer().getPluginManager().registerEvents(new DropStick(),this);
        getServer().getPluginManager().registerEvents(new ExplosiveBow(), this);
        getServer().getPluginManager().registerEvents(new ThunderBow(), this);
        getServer().getPluginManager().registerEvents(new LevitationBow(), this);
        getServer().getPluginManager().registerEvents(new FireBow(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("HTTrolplay closed correctly");
    }

    public void registerCommands(){

        this.getCommand("HTTbows").setExecutor(new HTTbows(this));

    }
}
