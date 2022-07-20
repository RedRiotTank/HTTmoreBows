package httbows.httbows;


import commands.HTTbows;
import events.*;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.List;

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
        getServer().getPluginManager().registerEvents(new FireTheBow(), this);
        runnable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("HTTrolplay closed correctly");
    }

    public void registerCommands(){

        this.getCommand("HTTbows").setExecutor(new HTTbows(this));

    }



    public void runnable(){
        new BukkitRunnable(){

            @Override
            public void run() {

                //List<Entity> entilist= getServer().getWorld("World").getEntities();
                Collection<Arrow> flechas = getServer().getWorld("World").getEntitiesByClass(org.bukkit.entity.Arrow.class);

                for(Entity flecha : flechas) {
                    System.out.println("runnable, customname flecha: " + flecha.getCustomName());
                    if (flecha.getType() == EntityType.ARROW && flecha.getCustomName().equals("FireBowProjectile") ) {
                        getServer().getWorld("World").spawnParticle(Particle.FLAME, flecha.getLocation(), 5);
                    }
                }

            }
        }.runTaskTimer(this,0,1);
    }
}
