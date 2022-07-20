package events;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.graalvm.compiler.phases.schedule.BlockClosure;

public class FireBow implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onProjectileHit(ProjectileHitEvent event) {
        boolean cumpleparametros = true;
        Player player = (Player) event.getEntity().getShooter();
        Block block = null;

        if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Fire Bow")) {

            if (event.getHitBlockFace() == BlockFace.UP){
                block= event.getHitBlock();


            } else if(event.getHitEntity() != null){
                Location entityLoc = event.getHitEntity().getLocation();
                entityLoc.setY(entityLoc.getY() - 1);
                block = entityLoc.getBlock();

            } else {
                cumpleparametros = false;
            }

            if(cumpleparametros){
                block.setType(Material.NETHERRACK);
                setFireupside(block.getLocation());

                Random rand = new Random();
                switch (rand.nextInt(5)){
                    case 0:
                        FireSet0(block);
                        break;

                    case 1:
                        FireSet1(block);
                        break;

                    case 2:
                        FireSet2(block);
                        break;
                    case 3:
                        FireSet3(block);
                        break;
                    case 4:
                        FireSet4(block);
                        break;
                }


            }




        }



    }

    public void FireSet0(Block block){
        setFireBlock(block.getLocation(),3,1);
        setFireBlock(block.getLocation(),-1,-2);
        setFireBlock(block.getLocation(),1,0);
        setFireBlock(block.getLocation(),-1,0);
        setFireBlock(block.getLocation(),2,1);
        setFireBlock(block.getLocation(),0,-1);
        setFireBlock(block.getLocation(),-3,1);
    }

    public void FireSet1(Block block){
        setFireBlock(block.getLocation(),1,1);
        setFireBlock(block.getLocation(),-1,-1);

        setFireBlock(block.getLocation(),-1,0);
        setFireBlock(block.getLocation(),0,1);
        setFireBlock(block.getLocation(),2,-2);
        setFireBlock(block.getLocation(),1,-1);
        setFireBlock(block.getLocation(),-1,2);
    }

    public void FireSet2(Block block){
        setFireBlock(block.getLocation(),1,1);
        setFireBlock(block.getLocation(),1,0);
        setFireBlock(block.getLocation(),-1,2);
        setFireBlock(block.getLocation(),0,1);
        setFireBlock(block.getLocation(),2,-1);
        setFireBlock(block.getLocation(),1,-1);
        setFireBlock(block.getLocation(),-1,2);
    }

    public void FireSet3(Block block){
        setFireBlock(block.getLocation(),2,1);
        setFireBlock(block.getLocation(),-1,-1);
        setFireBlock(block.getLocation(),-1,0);
        setFireBlock(block.getLocation(),3,1);
        setFireBlock(block.getLocation(),0,-1);
        setFireBlock(block.getLocation(),1,-1);
        setFireBlock(block.getLocation(),-1,2);
    }

    public void FireSet4(Block block){
        setFireBlock(block.getLocation(),2,1);
        setFireBlock(block.getLocation(),-1,-1);
        setFireBlock(block.getLocation(),1,3);
        setFireBlock(block.getLocation(),-1,0);
        setFireBlock(block.getLocation(),0,1);
        setFireBlock(block.getLocation(),1,-2);
        setFireBlock(block.getLocation(),-1,1);
    }





    public void setFireupside(Location blockLocation){

        Location firelocation = blockLocation;
        firelocation.setY(blockLocation.getY() + 1);
        //firelocation.getBlock().setType(Material.FIRE);
        firelocation.getWorld().spawnFallingBlock(firelocation, Material.FIRE, (byte) 0);

    }

    //@SuppressWarnings("deprecation")
    public void setFireBlock(Location blocklocation, int plusX, int plusZ){


        Location xzplus1 = blocklocation;
        xzplus1.setX(blocklocation.getX() + plusX);
        xzplus1.setZ(blocklocation.getZ() + plusZ);


        while(xzplus1.getBlock().getType() == Material.AIR){
            xzplus1.setY(xzplus1.getY() - 1);
        }



        xzplus1.getWorld().spawnFallingBlock(xzplus1, Material.SAND, blocklocation.getBlock().getData());
        //xzplus1.getBlock().setType(Material.NETHERRACK);


        setFireupside(xzplus1);



    }



}
