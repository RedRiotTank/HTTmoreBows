package events;

import com.sun.tools.javac.util.Pair;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;


import static org.bukkit.Bukkit.getPluginManager;

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

                }
                if(negative.nextBoolean()) {
                    plusZ = plusZ * -1;

                }

                Location locNearBlock = hitBlock.getLocation();
                locNearBlock.setX(hitBlock.getX() + plusX);
                locNearBlock.setZ(hitBlock.getZ() + plusZ);


                setFire(player, locNearBlock.getBlock());

            }
        }

        int LevitationBowRadius = 2;
        //LevitationBow
        if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Levitation Bow")){
            if(HitEntity instanceof Player){
                ((Player) HitEntity).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,20,6));
            } else if (HitEntity instanceof Mob){
                ((Mob) HitEntity).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,20,6));
            } else {
                Material matMainBlock = hitBlock.getType();
                Location locUpBlock = hitBlock.getLocation();
                locUpBlock.setY(locUpBlock.getY() + 1);
                Location locBlock = hitBlock.getLocation();




                Location locBlockDOWN = hitBlock.getLocation();
                locBlockDOWN.setX(hitBlock.getX() + 1);
                Material matDOWNBlock = locBlockDOWN.getBlock().getType();
                Location locUpBlockDOWN = locBlockDOWN.clone();
                locUpBlockDOWN.setY(locUpBlockDOWN.getY() + 1);
                new BukkitRunnable(){
                    int repeatTaskmain = 0, repeatTaskDOWN = 0;
                    int cancel = 0;
                    boolean mainBlockFinish = false, DOWNBlockFinish = false;
                    int counterMainBlockFinish = 0, counterDownBlockFinish = 0;
                    @Override
                    public void run() {


                        DOWNBlockFinish = levitate(locUpBlockDOWN, locBlockDOWN, DOWNBlockFinish, matDOWNBlock, player, repeatTaskDOWN);

                        if(DOWNBlockFinish && counterDownBlockFinish == 0) {
                            cancel++;
                            counterDownBlockFinish++;
                        }else
                            repeatTaskDOWN++;




                        mainBlockFinish = levitate(locUpBlock, locBlock, mainBlockFinish, matMainBlock, player, repeatTaskmain);

                        if(mainBlockFinish && counterMainBlockFinish == 0) {
                            cancel++;
                            counterMainBlockFinish ++;
                        }else
                            repeatTaskmain++;






                        /*
                        if((locUpBlock.getBlock().getType() != Material.AIR || repeatTaskmain >= 10) && !mainBlockFinish){
                            locBlock.getBlock().setType(Material.AIR);

                            player.getWorld().spawnFallingBlock(locBlock,matMainBlock,(byte) 0);
                            cancel++;
                            mainBlockFinish = true;
                        } else if(!mainBlockFinish){

                            locBlock.getBlock().setType(Material.AIR);
                            locUpBlock.getBlock().setType(matMainBlock);
                            repeatTaskmain++;

                            locBlock.setY(locBlock.getY() + 1);
                            locUpBlock.setY(locUpBlock.getY() + 1);
                        }

                         */

                        /*
                        if((locUpBlockDOWN.getBlock().getType() != Material.AIR || repeatTaskDOWN >= 10) && !DOWNBlockFinish){
                            locBlockDOWN.getBlock().setType(Material.AIR);

                            player.getWorld().spawnFallingBlock(locBlockDOWN,matDOWNBlock,(byte) 0);
                            cancel++;
                            DOWNBlockFinish = true;
                        } else if(!DOWNBlockFinish){

                            locBlockDOWN.getBlock().setType(Material.AIR);
                            locUpBlockDOWN.getBlock().setType(matDOWNBlock);
                            repeatTaskDOWN++;

                            locBlockDOWN.setY(locBlockDOWN.getY() + 1);
                            locUpBlockDOWN.setY(locUpBlockDOWN.getY() + 1);
                        }
                        */

                        if(cancel >= 2){
                            cancel();
                        }
                    }
                }.runTaskTimer(getPluginManager().getPlugin("HTTBows"), 2,1);
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

    public boolean levitate(Location locUpBlock, Location locBlock, boolean mainBlockFinish, Material matMainBlock, Player player, int repeatTaskmain){


        if((locUpBlock.getBlock().getType() != Material.AIR || repeatTaskmain >= 10) && !mainBlockFinish){
            locBlock.getBlock().setType(Material.AIR);

            player.getWorld().spawnFallingBlock(locBlock,matMainBlock,(byte) 0);

            mainBlockFinish = true;
        } else if(!mainBlockFinish){

            locBlock.getBlock().setType(Material.AIR);
            locUpBlock.getBlock().setType(matMainBlock);


            locBlock.setY(locBlock.getY() + 1);
            locUpBlock.setY(locUpBlock.getY() + 1);
        }
        return mainBlockFinish;

    }


}
