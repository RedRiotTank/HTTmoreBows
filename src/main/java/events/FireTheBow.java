package events;

import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public class FireTheBow implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onEntityShootBow(EntityShootBowEvent event) {

       String nombrearco = event.getBow().getItemMeta().getDisplayName();
        String firebow = "Fire Bow",
                thunderbow = "Thunder Bow",
                levitationbow = "Levitation Bow",
                explosiveBow = "Explosive Bow";




       if(nombrearco.equals(firebow))
           event.getProjectile().setCustomName("FireBowProjectile");

        if(nombrearco.equals(thunderbow))
            event.getProjectile().setCustomName("ThunderBowProjectile");

        if(nombrearco.equals(levitationbow))
            event.getProjectile().setCustomName("LevitationBowProjectile");

        if(nombrearco.equals(explosiveBow))
            event.getProjectile().setCustomName("ExplosiveBowProjectile");


        nombrearco = event.getBow().getItemMeta().getDisplayName();







    }


}
