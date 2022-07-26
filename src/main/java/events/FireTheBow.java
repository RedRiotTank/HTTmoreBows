package events;


import org.bukkit.ChatColor;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
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
        String firebow = ChatColor.RED + "Fire Bow",
                thunderbow = ChatColor.GRAY + "Thunder Bow",
                levitationbow = ChatColor.DARK_AQUA + "Levitation Bow",
                explosiveBow = ChatColor.DARK_RED + "Explosive Bow",
                shadowBow = ChatColor.DARK_PURPLE + "Shadows Bow";

        //This is to avoid errors
        if(event.getEntity() instanceof Mob){
            event.getProjectile().setCustomName("MobProjectile");
        }

       if(nombrearco.equals(shadowBow)){
           event.getProjectile().setCustomName("ShadowBowProjectile");
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
