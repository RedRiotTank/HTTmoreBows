package events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;




public class ExplosiveBow implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onProjectileHit(ProjectileHitEvent event) {


        Player player = (Player) event.getEntity().getShooter();

        if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Explosive Bow"))
            player.getWorld().createExplosion(event.getEntity().getLocation(),5,true,true);



    }
}



