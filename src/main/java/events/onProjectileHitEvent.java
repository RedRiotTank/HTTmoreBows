package events;


import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
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

        if(event.getEntity().getShooter() instanceof Player) {
            //Jugador que dispara.
            Player player = (Player) event.getEntity().getShooter();

            //Bloque golpeado
            Block hitBlock = event.getHitBlock();

            //entidad golpeada
            Entity HitEntity = event.getHitEntity();


            //EXPLOSIVE BOW
            if (event.getEntity().getCustomName().equals("ExplosiveBowProjectile")) {
                player.getWorld().createExplosion(event.getEntity().getLocation(), 5, true, true);
            }

            //FIRE BOW
            if (event.getEntity().getCustomName().equals("FireBowProjectile")) {

                if (HitEntity != null)
                    hitBlock = HitEntity.getLocation().getBlock();

                //Main fire block
                setFire(player, hitBlock);

                //Arround fire blocks
                for (int i = 0; i < 10; i++) {
                    int plusX = (int) (Math.random() * 4);
                    int plusZ = (int) (Math.random() * 4);

                    Random negative = new Random();

                    if (negative.nextBoolean()) {
                        plusX = plusX * -1;

                    }
                    if (negative.nextBoolean()) {
                        plusZ = plusZ * -1;

                    }

                    Location locNearBlock = hitBlock.getLocation();
                    locNearBlock.setX(hitBlock.getX() + plusX);
                    locNearBlock.setZ(hitBlock.getZ() + plusZ);

                    setFire(player, locNearBlock.getBlock());

                }
            }

            //LevitationBow
            if (event.getEntity().getCustomName().equals("LevitationBowProjectile")) {
                if (HitEntity instanceof Player) {
                    ((Player) HitEntity).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20, 6));
                } else if (HitEntity instanceof Mob) {
                    ((Mob) HitEntity).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20, 6));
                } else {
                    Material matMainBlock = hitBlock.getType();
                    Location locUpBlock = hitBlock.getLocation();
                    locUpBlock.setY(locUpBlock.getY() + 1);
                    Location locBlock = hitBlock.getLocation();


                    Location locBlockDOWN = hitBlock.getLocation();
                    locBlockDOWN.setX(hitBlock.getX() + 1);
                    Location up_BlockDOWN = locBlockDOWN.clone();
                    Location down_BlockDOWN = locBlockDOWN.clone();
                    int contador_down = 0;
                    while (up_BlockDOWN.getBlock().getType() == Material.AIR && down_BlockDOWN.getBlock().getType() == Material.AIR && contador_down < 2) {
                        up_BlockDOWN.setY(up_BlockDOWN.getY() + 1);
                        down_BlockDOWN.setY(down_BlockDOWN.getY() - 1);
                        contador_down++;
                    }

                    if (up_BlockDOWN.getBlock().getType() != Material.AIR) {
                        locBlockDOWN.setY(up_BlockDOWN.getY());
                    } else if (down_BlockDOWN.getBlock().getType() != Material.AIR) {
                        locBlockDOWN.setY(down_BlockDOWN.getY());
                    }
                    Material matDOWNBlock = locBlockDOWN.getBlock().getType();
                    Location locUpBlockDOWN = locBlockDOWN.clone();
                    locUpBlockDOWN.setY(locUpBlockDOWN.getY() + 1);


                    Location locBlockUP = hitBlock.getLocation();
                    locBlockUP.setX(hitBlock.getX() - 1);
                    Location up_BlockUP = locBlockUP.clone();
                    Location down_BlockUP = locBlockUP.clone();
                    int contador_up = 0;
                    while (up_BlockUP.getBlock().getType() == Material.AIR && down_BlockUP.getBlock().getType() == Material.AIR && contador_up < 2) {
                        up_BlockUP.setY(up_BlockUP.getY() + 1);
                        down_BlockUP.setY(down_BlockUP.getY() - 1);
                        contador_down++;
                    }
                    if (up_BlockUP.getBlock().getType() != Material.AIR) {
                        locBlockUP.setY(up_BlockUP.getY());
                    } else if (down_BlockUP.getBlock().getType() != Material.AIR) {
                        locBlockUP.setY(down_BlockDOWN.getY());
                    }
                    Material matUPBlock = locBlockUP.getBlock().getType();
                    Location locUpBlockUP = locBlockUP.clone();
                    locUpBlockUP.setY(locUpBlockUP.getY() + 1);


                    Location locBlockRIGHT = hitBlock.getLocation();
                    locBlockRIGHT.setZ(hitBlock.getZ() - 1);
                    Location up_BlockRIGHT = locBlockRIGHT.clone();
                    Location down_BlockRIGHT = locBlockRIGHT.clone();
                    int contador_RIGHT = 0;
                    while (up_BlockRIGHT.getBlock().getType() == Material.AIR && down_BlockRIGHT.getBlock().getType() == Material.AIR && contador_RIGHT < 2) {
                        up_BlockRIGHT.setY(up_BlockRIGHT.getY() + 1);
                        down_BlockRIGHT.setY(down_BlockRIGHT.getY() - 1);
                        contador_RIGHT++;
                    }
                    if (up_BlockRIGHT.getBlock().getType() != Material.AIR) {
                        locBlockRIGHT.setY(up_BlockRIGHT.getY());
                    } else if (down_BlockRIGHT.getBlock().getType() != Material.AIR) {
                        locBlockRIGHT.setY(down_BlockRIGHT.getY());
                    }
                    Material matRIGHTBlock = locBlockRIGHT.getBlock().getType();
                    Location locUpBlockRIGHT = locBlockRIGHT.clone();
                    locUpBlockRIGHT.setY(locUpBlockRIGHT.getY() + 1);


                    Location locBlockLEFT = hitBlock.getLocation();
                    locBlockLEFT.setZ(hitBlock.getZ() + 1);
                    Location up_BlockLEFT = locBlockLEFT.clone();
                    Location down_BlockLEFT = locBlockLEFT.clone();
                    int contador_LEFT = 0;
                    while (up_BlockLEFT.getBlock().getType() == Material.AIR && down_BlockLEFT.getBlock().getType() == Material.AIR && contador_LEFT < 2) {
                        up_BlockLEFT.setY(up_BlockLEFT.getY() + 1);
                        down_BlockLEFT.setY(down_BlockLEFT.getY() - 1);
                        contador_LEFT++;
                    }
                    if (up_BlockLEFT.getBlock().getType() != Material.AIR) {
                        locBlockLEFT.setY(up_BlockLEFT.getY());
                    } else if (down_BlockLEFT.getBlock().getType() != Material.AIR) {
                        locBlockLEFT.setY(down_BlockLEFT.getY());
                    }
                    Material matLEFTBlock = locBlockLEFT.getBlock().getType();
                    Location locUpBlockLEFT = locBlockLEFT.clone();
                    locUpBlockLEFT.setY(locUpBlockLEFT.getY() + 1);


                    Location locBlockUPLEFT = hitBlock.getLocation();
                    locBlockUPLEFT.setX(hitBlock.getX() - 1);
                    locBlockUPLEFT.setZ(hitBlock.getZ() + 1);
                    Location up_BlockUPLEFT = locBlockUPLEFT.clone();
                    Location down_BlockUPLEFT = locBlockUPLEFT.clone();
                    int contador_UPLEFT = 0;
                    while (up_BlockUPLEFT.getBlock().getType() == Material.AIR && down_BlockUPLEFT.getBlock().getType() == Material.AIR && contador_UPLEFT < 2) {
                        up_BlockUPLEFT.setY(up_BlockUPLEFT.getY() + 1);
                        down_BlockUPLEFT.setY(down_BlockUPLEFT.getY() - 1);
                        contador_UPLEFT++;
                    }
                    if (up_BlockUPLEFT.getBlock().getType() != Material.AIR) {
                        locBlockUPLEFT.setY(up_BlockUPLEFT.getY());
                    } else if (down_BlockUPLEFT.getBlock().getType() != Material.AIR) {
                        locBlockUPLEFT.setY(down_BlockUPLEFT.getY());
                    }
                    Material matUPLEFTBlock = locBlockUPLEFT.getBlock().getType();
                    Location locUpBlockUPLEFT = locBlockUPLEFT.clone();
                    locUpBlockUPLEFT.setY(locUpBlockUPLEFT.getY() + 1);


                    Location locBlockUPRIGHT = hitBlock.getLocation();
                    locBlockUPRIGHT.setX(hitBlock.getX() - 1);
                    locBlockUPRIGHT.setZ(hitBlock.getZ() - 1);
                    Location up_BlockUPRIGHT = locBlockUPRIGHT.clone();
                    Location down_BlockUPRIGHT = locBlockUPRIGHT.clone();
                    int contador_UPRIGHT = 0;
                    while (up_BlockUPRIGHT.getBlock().getType() == Material.AIR && down_BlockUPRIGHT.getBlock().getType() == Material.AIR && contador_UPRIGHT < 2) {
                        up_BlockUPRIGHT.setY(up_BlockUPRIGHT.getY() + 1);
                        down_BlockUPRIGHT.setY(down_BlockUPRIGHT.getY() - 1);
                        contador_UPRIGHT++;
                    }
                    if (up_BlockUPRIGHT.getBlock().getType() != Material.AIR) {
                        locBlockUPRIGHT.setY(up_BlockUPRIGHT.getY());
                    } else if (down_BlockUPRIGHT.getBlock().getType() != Material.AIR) {
                        locBlockUPRIGHT.setY(down_BlockUPRIGHT.getY());
                    }
                    Material matUPRIGHTBlock = locBlockUPRIGHT.getBlock().getType();
                    Location locUpBlockUPRIGHT = locBlockUPRIGHT.clone();
                    locUpBlockUPRIGHT.setY(locUpBlockUPRIGHT.getY() + 1);


                    Location locBlockDOWNLEFT = hitBlock.getLocation();
                    locBlockDOWNLEFT.setX(hitBlock.getX() + 1);
                    locBlockDOWNLEFT.setZ(hitBlock.getZ() + 1);
                    Location up_BlockDOWNLEFT = locBlockDOWNLEFT.clone();
                    Location down_BlockDOWNLEFT = locBlockDOWNLEFT.clone();
                    int contador_DOWNLEFT = 0;
                    while (up_BlockDOWNLEFT.getBlock().getType() == Material.AIR && down_BlockDOWNLEFT.getBlock().getType() == Material.AIR && contador_DOWNLEFT < 2) {
                        up_BlockDOWNLEFT.setY(up_BlockDOWNLEFT.getY() + 1);
                        down_BlockDOWNLEFT.setY(down_BlockDOWNLEFT.getY() - 1);
                        contador_DOWNLEFT++;
                    }
                    if (up_BlockDOWNLEFT.getBlock().getType() != Material.AIR) {
                        locBlockDOWNLEFT.setY(up_BlockDOWNLEFT.getY());
                    } else if (down_BlockDOWNLEFT.getBlock().getType() != Material.AIR) {
                        locBlockDOWNLEFT.setY(down_BlockDOWNLEFT.getY());
                    }
                    Material matDOWNLEFTBlock = locBlockDOWNLEFT.getBlock().getType();
                    Location locUpBlockDOWNLEFT = locBlockDOWNLEFT.clone();
                    locUpBlockDOWNLEFT.setY(locUpBlockDOWNLEFT.getY() + 1);


                    Location locBlockDOWNRIGHT = hitBlock.getLocation();
                    locBlockDOWNRIGHT.setX(hitBlock.getX() + 1);
                    locBlockDOWNRIGHT.setZ(hitBlock.getZ() - 1);
                    Location up_BlockDOWNRIGHT = locBlockDOWNRIGHT.clone();
                    Location down_BlockDOWNRIGHT = locBlockDOWNRIGHT.clone();
                    int contador_DOWNRIGHT = 0;
                    while (up_BlockDOWNRIGHT.getBlock().getType() == Material.AIR && down_BlockDOWNRIGHT.getBlock().getType() == Material.AIR && contador_DOWNRIGHT < 2) {
                        up_BlockDOWNRIGHT.setY(up_BlockDOWNRIGHT.getY() + 1);
                        down_BlockDOWNRIGHT.setY(down_BlockDOWNRIGHT.getY() - 1);
                        contador_DOWNRIGHT++;
                    }
                    if (up_BlockDOWNRIGHT.getBlock().getType() != Material.AIR) {
                        locBlockDOWNRIGHT.setY(up_BlockDOWNRIGHT.getY());
                    } else if (down_BlockDOWNRIGHT.getBlock().getType() != Material.AIR) {
                        locBlockDOWNRIGHT.setY(down_BlockDOWNRIGHT.getY());
                    }
                    Material matDOWNRIGHTBlock = locBlockDOWNRIGHT.getBlock().getType();
                    Location locUpBlockDOWNRIGHT = locBlockDOWNRIGHT.clone();
                    locUpBlockDOWNRIGHT.setY(locUpBlockDOWNRIGHT.getY() + 1);
                    new BukkitRunnable() {
                        int repeatTaskmain = 0, repeatTaskDOWN = 0, repeatTaskUP = 0, repeatTaskRIGHT = 0, repeatTaskLEFT = 0,
                                repeatTaskUPLEFT = 0, repeatTaskUPRIGHT = 0, repeatTaskDOWNLEFT = 0, repeatTaskDOWNRIGHT = 0;
                        int cancel = 0;
                        boolean mainBlockFinish = false, DOWNBlockFinish = false, UPBlockFinish = false, RIGHTBlockFinish = false,
                                LEFTBlockFinish = false, UPLEFTBlockFinish = false, UPRIGHTBlockFinish = false,
                                DOWNRIGHTBlockFinish = false, DOWNLEFTBlockFinish = false;
                        int counterMainBlockFinish = 0, counterDownBlockFinish = 0, counterUpBlockFinish = 0, counterRightBlockFinish = 0,
                                counterLeftBlockFinish = 0, counterUpLeftBlockFinish = 0, counterUpRightBlockFinish = 0,
                                counterDownRightBlockFinish = 0, counterDownLeftBlockFinish = 0;

                        @Override
                        public void run() {

                            DOWNLEFTBlockFinish = levitate(locUpBlockDOWNLEFT, locBlockDOWNLEFT, DOWNLEFTBlockFinish, matDOWNLEFTBlock, player, repeatTaskDOWNLEFT);
                            if (DOWNLEFTBlockFinish && counterDownLeftBlockFinish == 0) {
                                cancel++;
                                counterDownLeftBlockFinish++;
                            } else
                                repeatTaskDOWNLEFT++;


                            DOWNRIGHTBlockFinish = levitate(locUpBlockDOWNRIGHT, locBlockDOWNRIGHT, DOWNRIGHTBlockFinish, matDOWNRIGHTBlock, player, repeatTaskDOWNRIGHT);
                            if (DOWNRIGHTBlockFinish && counterDownRightBlockFinish == 0) {
                                cancel++;
                                counterDownRightBlockFinish++;
                            } else
                                repeatTaskDOWNRIGHT++;


                            UPRIGHTBlockFinish = levitate(locUpBlockUPRIGHT, locBlockUPRIGHT, UPRIGHTBlockFinish, matUPRIGHTBlock, player, repeatTaskUPRIGHT);
                            if (UPRIGHTBlockFinish && counterUpRightBlockFinish == 0) {
                                cancel++;
                                counterUpRightBlockFinish++;
                            } else
                                repeatTaskUPRIGHT++;


                            UPLEFTBlockFinish = levitate(locUpBlockUPLEFT, locBlockUPLEFT, UPLEFTBlockFinish, matUPLEFTBlock, player, repeatTaskUPLEFT);
                            if (UPLEFTBlockFinish && counterUpLeftBlockFinish == 0) {
                                cancel++;
                                counterUpLeftBlockFinish++;
                            } else
                                repeatTaskUPLEFT++;


                            LEFTBlockFinish = levitate(locUpBlockLEFT, locBlockLEFT, LEFTBlockFinish, matLEFTBlock, player, repeatTaskLEFT);
                            if (LEFTBlockFinish && counterLeftBlockFinish == 0) {
                                cancel++;
                                counterLeftBlockFinish++;
                            } else
                                repeatTaskLEFT++;


                            DOWNBlockFinish = levitate(locUpBlockDOWN, locBlockDOWN, DOWNBlockFinish, matDOWNBlock, player, repeatTaskDOWN);
                            if (DOWNBlockFinish && counterDownBlockFinish == 0) {
                                cancel++;
                                counterDownBlockFinish++;
                            } else
                                repeatTaskDOWN++;


                            UPBlockFinish = levitate(locUpBlockUP, locBlockUP, UPBlockFinish, matUPBlock, player, repeatTaskUP);
                            if (UPBlockFinish && counterUpBlockFinish == 0) {
                                cancel++;
                                counterUpBlockFinish++;
                            } else
                                repeatTaskUP++;


                            mainBlockFinish = levitate(locUpBlock, locBlock, mainBlockFinish, matMainBlock, player, repeatTaskmain);
                            if (mainBlockFinish && counterMainBlockFinish == 0) {
                                cancel++;
                                counterMainBlockFinish++;
                            } else
                                repeatTaskmain++;


                            RIGHTBlockFinish = levitate(locUpBlockRIGHT, locBlockRIGHT, RIGHTBlockFinish, matRIGHTBlock, player, repeatTaskRIGHT);
                            if (RIGHTBlockFinish && counterRightBlockFinish == 0) {
                                cancel++;
                                counterRightBlockFinish++;
                            } else
                                repeatTaskRIGHT++;

                            if (cancel >= 9) {
                                cancel();
                            }
                        }
                    }.runTaskTimer(getPluginManager().getPlugin("HTTBows"), 2, 1);
                }
            }

            //ThunderBow
            if (event.getEntity().getCustomName().equals("ThunderBowProjectile")) {
                player.getWorld().strikeLightning(event.getEntity().getLocation());
                //player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,event.getEntity().getLocation(),500);
            }

            //ShadowBow
            if (event.getEntity().getCustomName().equals("ShadowBowProjectile")) {

                if (hitBlock != null) {
                    Location teleport = hitBlock.getLocation().clone();
                    if(event.getHitBlockFace() == BlockFace.UP)
                        teleport.setY(teleport.getY() + 1);

                    player.teleport(teleport);
                    player.getWorld().playSound(hitBlock.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 1);

                } else if(HitEntity != null){

                    if(HitEntity instanceof Player){
                        ((Player) HitEntity).addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS,100,2));
                    }

                    if(HitEntity instanceof Mob){
                        ((Mob) HitEntity).addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS,100,2));

                    }

                }
            }

            event.getEntity().remove();
        }
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
            player.spawnParticle(Particle.BLOCK_CRACK, locBlock, 10, matMainBlock.createBlockData());

            locBlock.setY(locBlock.getY() + 1);
            locUpBlock.setY(locUpBlock.getY() + 1);
        }
        return mainBlockFinish;
    }
}
