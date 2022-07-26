package httbows.httbows;
import commands.HTTbows;
import events.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public final class HTTBows extends JavaPlugin {
    @Override
    public void onEnable() {

        //Commands register
        registerCommands();

        //Events register
        getServer().getPluginManager().registerEvents(new onProjectileHitEvent(), this);
        getServer().getPluginManager().registerEvents(new FireTheBow(), this);


        Runnables.runnable(this);

        //initialize lgazy:
        Location ini = getServer().getWorld("World").getSpawnLocation();
        ini.setX(0);
        ini.setY(100);
        ini.setZ(0);
        getServer().getWorld("World").spawnFallingBlock(ini, Material.ANDESITE, (byte) 0);
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
