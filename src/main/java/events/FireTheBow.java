package events;


import httbows.httbows.HTTBows;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FireTheBow implements Listener {
    public HTTBows plugin;

    public FireTheBow(HTTBows plugin){
        this.plugin = plugin;
    }
    @EventHandler(ignoreCancelled = true)
    public void onEntityShootBow(EntityShootBowEvent event) {
        Player player = null;
        String nombrearco = event.getBow().getItemMeta().getDisplayName();
        String Lore = "";
        String firebowName, thunderbowName, levitationbowName, explosivebowName, shadowbowName,
                firebowLore, thunderbowLore, levitationbowLore, explosivebowLore, shadowbowLore;


        FileConfiguration config = plugin.getConfig();

        if(config.getString("Config.CustomNames").equals("true")){

            firebowName = config.getString("Config.FireBowName");
            thunderbowName = config.getString("Config.ThunderBowName");
            levitationbowName = config.getString("Config.LevitationBowName");
            explosivebowName = config.getString("Config.ExplosiveBowName");
            shadowbowName = config.getString("Config.ShadowBowName");
        } else {
            firebowName = ChatColor.RED + "Fire Bow";
            thunderbowName = ChatColor.GRAY + "Thunder Bow";
            levitationbowName = ChatColor.DARK_AQUA + "Levitation Bow";
            explosivebowName = ChatColor.DARK_RED + "Explosive Bow";
            shadowbowName = ChatColor.DARK_PURPLE + "Shadows Bow";
        }

        if(config.getString("Config.CustomLores").equals("true")){

            firebowLore = config.getString("Config.FireBowLore");
            thunderbowLore = config.getString("Config.ThunderBowLore");
            levitationbowLore = config.getString("Config.LevitationBowLore");
            explosivebowLore = config.getString("Config.ExplosiveBowLore");
            shadowbowLore = config.getString("Config.ShadowBowLore");
        } else {
            firebowLore = "a firebow to burn them all";
            thunderbowLore = "This Thunder Bow is made by gods";
            levitationbowLore = "Go to the sky with this bow...";
            explosivebowLore = "This Explosive Bow is really destructive...";
            shadowbowLore = "This bow belonged to a shadow assassin";
        }
        if(event.getBow().getItemMeta().hasLore()) {

                Lore = event.getBow().getItemMeta().getLore().get(0);


        }

        //This is to avoid errors
        if(event.getEntity() instanceof Mob)
            event.getProjectile().setCustomName("MobProjectile");


       if(nombrearco.equals(shadowbowName) && shadowbowLore.equals(Lore)){
           event.getProjectile().setCustomName("ShadowBowProjectile");
           player = (Player) event.getEntity();
           player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,100,4));
       }

        if(nombrearco.equals(firebowName) && firebowLore.equals(Lore))
            event.getProjectile().setCustomName("FireBowProjectile");

        if(nombrearco.equals(thunderbowName) && thunderbowLore.equals(Lore))
            event.getProjectile().setCustomName("ThunderBowProjectile");

        if(nombrearco.equals(levitationbowName) && levitationbowLore.equals(Lore))
            event.getProjectile().setCustomName("LevitationBowProjectile");

        if(nombrearco.equals(explosivebowName) && explosivebowLore.equals(Lore))
            event.getProjectile().setCustomName("ExplosiveBowProjectile");
    }
}
