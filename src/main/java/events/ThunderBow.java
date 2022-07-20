package events;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ThunderBow implements Listener {


    @EventHandler(ignoreCancelled = true)
    public void onProjectileHit(ProjectileHitEvent event) {

        Player player = (Player) event.getEntity().getShooter();

        if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Thunder Bow")){

            player.getWorld().strikeLightning(event.getEntity().getLocation());
            player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,event.getEntity().getLocation(),500);

        }

    }
}
