package events;

import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Set;
import java.util.UUID;


public class DropStick implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player p  = event.getPlayer();
        Item droppedItem = event.getItemDrop();

        Block b = p.getTargetBlockExact(5);
        Chest chest = null;
        BlockState state = b.getState();

        if(state instanceof Chest)
             chest = (Chest) state;

        //


        if(droppedItem.getItemStack().getType() == Material.STICK  && b.getBlockData().getMaterial() == Material.CHEST && chest.getBlockInventory().contains(Material.ENDER_EYE) ) {
            p.sendMessage(p.getName() + "Comenzó su proceso de Negromante");

            Location itemloc = droppedItem.getLocation();

            int direc = getCardinalDirection(p);

            switch (direc){
                case 0:
                    itemloc.setX(itemloc.getX()-2);
                    break;
                case 1:
                    itemloc.setX(itemloc.getX()-2);
                    itemloc.setZ(itemloc.getZ()-2);
                    break;
                case 4:
                    itemloc.setX(itemloc.getX()+2);
                    break;
                case 3:

                    itemloc.setX(itemloc.getX()+2);
                    itemloc.setZ(itemloc.getZ()-2);
                    break;
                case 5:
                    itemloc.setX(itemloc.getX()+2);
                    itemloc.setZ(itemloc.getZ()+2);
                    break;
                case 2:
                    itemloc.setZ(itemloc.getZ()-2);
                    break;
                case 6:
                    itemloc.setZ(itemloc.getZ()+2);
                    break;
                case 7:
                    itemloc.setX(itemloc.getX()-2);
                    itemloc.setZ(itemloc.getZ()+2);
                    break;
                default:
                    break;
            }


            p.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS,100,4));
            p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,100,4));
            p.getWorld().strikeLightningEffect(itemloc);

            for (int i = 0; i < 10; i++)
                p.getWorld().spawnEntity(itemloc, EntityType.BAT);


            ItemStack is = new ItemStack(Material.GOLDEN_SWORD,1);
            droppedItem.setItemStack(is);


        }

    }

    public static int getCardinalDirection(Player player) {
        double rotation = (player.getLocation().getYaw() - 90) % 360;
        if (rotation < 0) {
            rotation += 360.0;
        }
        if (0 <= rotation && rotation < 22.5) {
            return 0; //N
        } else if (22.5 <= rotation && rotation < 67.5) {
            return 1;    //NE
        } else if (67.5 <= rotation && rotation < 112.5) {
            return 2; //E
        } else if (112.5 <= rotation && rotation < 157.5) {
            return 3;    //SE
        } else if (157.5 <= rotation && rotation < 202.5) {
            return 4; //S
        } else if (202.5 <= rotation && rotation < 247.5) {
            return 5;    //SW
        } else if (247.5 <= rotation && rotation < 292.5) {
            return 6; //W
        } else if (292.5 <= rotation && rotation < 337.5) {
            return 7;    //NW
        } else if (337.5 <= rotation && rotation < 360.0) {
            return 0; //N (yup, again)
        } else {
            return -1;
        }
    }
}



