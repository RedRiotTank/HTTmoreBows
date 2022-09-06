package httbows.httbows;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public HTTBows plugin;
    FileConfiguration config;
    public static ItemStack item = new ItemStack(Material.BOW, 1);
    public static ItemMeta meta = item.getItemMeta();
    public static List<String> list = new ArrayList<>();

    public ItemManager(HTTBows plugin){
        this.plugin = plugin;
        config = plugin.getConfig();
    }
    public ItemStack returnExplosiveBow(){

        if(config.getString("Config.CustomNames").equals("true"))
            meta.setDisplayName(config.getString("Config.ExplosiveBowName"));
        else
            meta.setDisplayName(ChatColor.DARK_RED + "Explosive Bow");

        list.clear();


        if(config.getString("Config.CustomLores").equals("true"))
            list.add(config.getString("Config.ExplosiveBowLore"));
        else
            list.add("This Explosive Bow is really destructive...");

        meta.setLore(list);
        item.setItemMeta(meta);

        return item;
    }
    public ItemStack returnThunderBow(){
        if(config.getString("Config.CustomNames").equals("true"))
            meta.setDisplayName(config.getString("Config.ThunderBowName"));
        else
            meta.setDisplayName(ChatColor.GRAY + "Thunder Bow");

        list.clear();


        if(config.getString("Config.CustomLores").equals("true"))
            list.add(config.getString("Config.ThunderBowLore"));
        else
            list.add("This Thunder Bow is made by gods");



        meta.setLore(list);
        item.setItemMeta(meta);

        return item;
    }

    public  ItemStack returnShadowBow(){

        if(config.getString("Config.CustomNames").equals("true"))
            meta.setDisplayName(config.getString("Config.ShadowBowName"));
        else
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Shadows Bow");

        list.clear();


        if(config.getString("Config.CustomLores").equals("true"))
            list.add(config.getString("Config.ShadowBowLore"));
        else
            list.add("This bow belonged to a shadow assassin");

        meta.setLore(list);
        item.setItemMeta(meta);

        return item;
    }
    public ItemStack returnLevitationBow(){

        if(config.getString("Config.CustomNames").equals("true"))
            meta.setDisplayName(config.getString("Config.LevitationBowName"));
         else
            meta.setDisplayName(ChatColor.DARK_AQUA + "Levitation Bow");


        list.clear();


        if(config.getString("Config.CustomLores").equals("true"))
            list.add(config.getString("Config.LevitationBowLore"));
        else
            list.add("Go to the sky with this bow...");

        meta.setLore(list);
        item.setItemMeta(meta);

        return item;
    }

    public  ItemStack returnFireBow(){

        if(config.getString("Config.CustomNames").equals("true"))
            meta.setDisplayName(config.getString("Config.FireBowName"));
        else
            meta.setDisplayName(ChatColor.RED + "Fire Bow");

        list.clear();


        if(config.getString("Config.CustomLores").equals("true"))
            list.add(config.getString("Config.FireBowLore"));
        else
            list.add("a firebow to burn them all");

        meta.setLore(list);
        item.setItemMeta(meta);

        return item;
    }
}
