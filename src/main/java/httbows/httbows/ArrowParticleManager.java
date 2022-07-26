package httbows.httbows;

import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import java.util.Collection;
import static org.bukkit.Bukkit.getServer;

public class ArrowParticleManager {

    public static void ArrowsParticles(){
        Collection<Arrow> flechas = getServer().getWorld("World").getEntitiesByClass(org.bukkit.entity.Arrow.class);
        Particle particleType = null;

        for(Entity flecha : flechas) {
            if (flecha.getCustomName().equals("FireBowProjectile") )
                particleType = Particle.FLAME;

            if (flecha.getCustomName().equals("ThunderBowProjectile") )
                particleType = Particle.FIREWORKS_SPARK;

            if (flecha.getCustomName().equals("LevitationBowProjectile") )
                particleType = Particle.SUSPENDED;

            if (flecha.getCustomName().equals("ExplosiveBowProjectile") )
                particleType = Particle.SMOKE_NORMAL;

            if(flecha.getCustomName().equals("ShadowBowProjectile"))
                particleType = Particle.PORTAL;



            if(particleType != null)
                flecha.getWorld().spawnParticle(particleType, flecha.getLocation(), 20,0,0,0,0.1);

        }

    }


}
