package events;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;


import static org.bukkit.Bukkit.getServer;

public class onProjectileHitEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onProjectileHit(ProjectileHitEvent event) {
        //variables generales:
        Player player = (Player) event.getEntity().getShooter();

        //variables FireBow:
        boolean cumpleparametros = true;
        Block block = null;

        //entidad golpeada
        Entity HitEntity = event.getHitEntity();

        //Bloque golpeado
        Block hitBlock = event.getHitBlock();






        //EXPLOSIVE BOW
        if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Explosive Bow")) {
            player.getWorld().createExplosion(event.getEntity().getLocation(), 5, true, true);
        }

        //FIRE BOW
        if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "Fire Bow")) {

            if(HitEntity != null)
                hitBlock = HitEntity.getLocation().getBlock();

            //Main fire block
            setFire(player, hitBlock);

            //Arround fire blocks
            for (int i=0; i<10; i++){
                int plusX = (int) (Math.random()*4);
                int plusZ = (int) (Math.random()*4);

                Random negative = new Random();

                if(negative.nextBoolean()) {
                    plusX = plusX * -1;
                    player.sendMessage("RX");
                }
                if(negative.nextBoolean()) {
                    plusZ = plusZ * -1;
                    player.sendMessage("RZ");
                }

                Location locNearBlock = hitBlock.getLocation();
                locNearBlock.setX(hitBlock.getX() + plusX);
                locNearBlock.setZ(hitBlock.getZ() + plusZ);


                setFire(player, locNearBlock.getBlock());

            }
        }

        //LevitationBow
        if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Levitation Bow")){
            if(HitEntity instanceof Player){
                ((Player) HitEntity).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,20,6));
            } else if (HitEntity instanceof Mob){
                ((Mob) HitEntity).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,20,6));
            }



        }

        //ThunderBow
        if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Thunder Bow")){
            player.getWorld().strikeLightning(event.getEntity().getLocation());
            //player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,event.getEntity().getLocation(),500);
        }


        event.getEntity().remove();
    }

// INICIO FUNCIONES FIREBOW
    public void setFire( Player player, Block block){
        player.sendMessage("FUNCIONAFUNCIONFUEGO");
        Location Up = block.getLocation();
        Location Down = block.getLocation();
        int contador = 0;

        while(Up.getBlock().getType() != Material.AIR && Down.getBlock().getType() != Material.AIR && contador < 2){
            Up.setY(Up.getY() + 1);
            Down.setY(Down.getY() - 1);
            contador++;
        }

        if(Up.getBlock().getType() == Material.AIR){
            Up.getBlock().setType(Material.FIRE);
            player.getWorld().spawnParticle(Particle.FLAME, Up, 50,0,0,0,1);
            player.getWorld().playSound(Up,Sound.ENTITY_DRAGON_FIREBALL_EXPLODE,100,1);
        } else if(Down.getBlock().getType() == Material.AIR){
            Down.getBlock().setType(Material.FIRE);
            player.getWorld().spawnParticle(Particle.FLAME, Down, 50,0,0,0,1);
            player.getWorld().playSound(Down,Sound.ENTITY_DRAGON_FIREBALL_EXPLODE,100,1);

        }
    }


}
