package by.makarymalinouski.epam.sphere.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.makarymalinouski.epam.sphere.entity.Sphere;

public class SphereInfo {
    static final Logger LOGGER = LogManager.getLogger(SphereInfo.class);
    private Sphere sphere;
    
    public SphereInfo(Sphere sphere) {
        this.sphere = sphere;
    }
    
    public double surfaceArea() {
        return 4 * Math.PI * Math.pow(sphere.getRadius(), 2);
    }
    
    public double volume() {
        return 4 * Math.PI * Math.pow(sphere.getRadius(), 3);
    }
    
    public double volumesRatioXY() {
        double R = sphere.getRadius();
        LOGGER.debug("radius: " + R);
        double H = R - Math.abs(sphere.getCenter().getZ());
        LOGGER.debug("height: " + H);

        // formula for this and next methods 
        // from https://en.wikipedia.org/wiki/Spherical_cap
        double V1 = Math.PI * H*H / 3 * (3*R - H);
        LOGGER.debug("cap vol: " + V1);

        double V = 4/3 * Math.PI * Math.pow(R, 3);
        LOGGER.debug("sphere vol: " + V);

        return V1 / (V - V1);
    }
    
    public double volumesRatioYZ() {
        double R = sphere.getRadius();
        double H = R - Math.abs(sphere.getCenter().getX());

        double V1 = Math.PI * H*H / 3 * (3*R - H);
        double V = 4/3 * Math.PI * Math.pow(R, 3);
        
        return V1 / (V - V1);   
    }
    
    public double volumesRatioZX() {
        double R = sphere.getRadius();
        double H = R - Math.abs(sphere.getCenter().getY());

        double V1 = Math.PI * H*H / 3 * (3*R - H);
        double V = 4/3 * Math.PI * Math.pow(R, 3);
        
        return V1 / (V - V1);
    }
    
    public boolean touchesCoordinatePlane() {
        double R = sphere.getRadius();
        return sphere.getCenter().getX() - R == 0 ||
               sphere.getCenter().getY() - R == 0 ||
               sphere.getCenter().getZ() - R == 0;
    }
}
