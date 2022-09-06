package httbows.httbows;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;

import static org.bukkit.Bukkit.getServer;
public class PlayerpEffectsFromBow {
    public static void ShadowBowEffects() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Shadows Bow")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 3, 2));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 3, 2));
                }
            }
        }
    }
    public static void InitializeLegazy(String WorldName){
        Location ini = getServer().getWorld(WorldName).getSpawnLocation();
        ini.setX(0);
        ini.setY(100);
        ini.setZ(0);
        getServer().getWorld(WorldName).spawnFallingBlock(ini, Material.ANDESITE, (byte) 0);
    }


}