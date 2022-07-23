package httbows.httbows;
import commands.HTTbows;
import events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HTTBows extends JavaPlugin {
    @Override
    public void onEnable() {

        //Commands register
        registerCommands();

        //Events register
        getServer().getPluginManager().registerEvents(new onProjectileHitEvent(), this);
        getServer().getPluginManager().registerEvents(new FireTheBow(), this);

        //Runnables register
        //Runnables.runnable(this);
        Bukkit.getConsoleSender().sendMessage("HTTBows started correctly");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("HTTrolplay closed correctly");
    }

    public void registerCommands(){
        this.getCommand("HTTbows").setExecutor(new HTTbows(this));
    }

}
