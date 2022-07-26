package httbows.httbows;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
}