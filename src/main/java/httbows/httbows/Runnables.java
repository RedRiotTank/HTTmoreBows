package httbows.httbows;


import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Runnables {
    public static void runnable(Plugin plugin){
        new BukkitRunnable(){
            @Override
            public void run() {

                //ShadowBow
                PlayerpEffectsFromBow.ShadowBowEffects();

                //ArrowsParticles
                ArrowParticleManager.ArrowsParticles();
            }
        }.runTaskTimer(plugin,0,1);
    }
}
