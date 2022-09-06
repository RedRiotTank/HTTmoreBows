package httbows.httbows;
import commands.HTTbows;
import events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class HTTBows extends JavaPlugin {

    public String configPath;
    @Override
    public void onEnable() {

        //Commands register
        registerCommands();

        //register config
        registerConfig();

        //Events register
        getServer().getPluginManager().registerEvents(new onProjectileHitEvent(), this);
        getServer().getPluginManager().registerEvents(new FireTheBow(this), this);


        Runnables.runnable(this);

        //initialize legazy:
        PlayerpEffectsFromBow.InitializeLegazy("World");    //introducir uno de los mundos en los que se va a ejecutar el plugin, cualquiera vale.

        Bukkit.getConsoleSender().sendMessage("HTTBows started correctly");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("HTTrolplay closed correctly");
    }

    public void registerCommands(){
        this.getCommand("HTTbows").setExecutor(new HTTbows(this));
    }

    public void registerConfig(){
        File config = new File(this.getDataFolder(), "config.yml");
        configPath = config.getPath();


            this.getConfig().options().copyDefaults(true);
            saveConfig();


    }
}
