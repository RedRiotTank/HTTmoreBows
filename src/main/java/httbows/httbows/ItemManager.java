package httbows.httbows;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack returnExplosiveBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        //item.addEnchantment(Enchantment.ARROW_DAMAGE,1);
        meta.setDisplayName(ChatColor.DARK_RED + "Explosive Bow");
        List<String> list = new ArrayList<>();
        list.add("EPIC");
        list.add("This Explosive Bow is really destructive...");
        meta.setLore(list);
        item.setItemMeta(meta);

        return item;
    }
    public static ItemStack returnThunderBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + "Thunder Bow");
        List<String> list = new ArrayList<>();
        list.add("EPIC");
        list.add("This Thunder Bow is made by gods");

        meta.setLore(list);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack returnShadowBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Shadows Bow");
        List<String> list = new ArrayList<>();
        list.add("EPIC");
        list.add("This bow belonged to a shadow assassin");
        meta.setLore(list);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack returnLevitationBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_AQUA + "Levitation Bow");
        List<String> list = new ArrayList<>();
        list.add("EPIC");
        list.add("Go to the sky with this bow...");
        meta.setLore(list);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack returnFireBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Fire Bow");
        List<String> list = new ArrayList<>();
        list.add("EPIC");
        list.add("a firebow to burn them all");
        meta.setLore(list);
        item.setItemMeta(meta);
        return item;
    }
}
