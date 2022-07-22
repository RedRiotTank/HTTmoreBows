package events;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FireTheBow implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onEntityShootBow(EntityShootBowEvent event) {
        Player player = null;
        String nombrearco = event.getBow().getItemMeta().getDisplayName();
        String firebow = "Fire Bow",
                thunderbow = "Thunder Bow",
                levitationbow = "Levitation Bow",
                explosiveBow = "Explosive Bow",
                shadowBow = "Shadows Bow";

       if(nombrearco.equals(shadowBow)){
           player = (Player) event.getEntity();
           player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,100,4));
       }

        if(nombrearco.equals(firebow))
            event.getProjectile().setCustomName("FireBowProjectile");

        if(nombrearco.equals(thunderbow))
            event.getProjectile().setCustomName("ThunderBowProjectile");

        if(nombrearco.equals(levitationbow))
            event.getProjectile().setCustomName("LevitationBowProjectile");

        if(nombrearco.equals(explosiveBow))
            event.getProjectile().setCustomName("ExplosiveBowProjectile");
    }


}
