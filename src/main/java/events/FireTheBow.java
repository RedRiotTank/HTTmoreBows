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
        String firebow = "Fire Bow";




       if(nombrearco.equals(firebow))
           event.getProjectile().setCustomName("FireBowProjectile");


        nombrearco = event.getBow().getItemMeta().getDisplayName();







    }


}
