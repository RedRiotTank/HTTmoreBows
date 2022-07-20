package events;

import org.bukkit.EntityEffect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LevitationBow implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onProjectileHit(ProjectileHitEvent event) {

        Player player = (Player) event.getEntity().getShooter();
        Entity entitymob = event.getHitEntity();
        Mob livent = (Mob) entitymob;

        if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Levitation Bow")){

            player.sendMessage("Levitation Bow");
            livent.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,20,6));
        }



    }
}
