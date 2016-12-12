package by.makarymalinouski.epam.sphere.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.makarymalinouski.epam.sphere.entity.Sphere;

public class VolumesRatio {
    static final Logger LOGGER = LogManager.getLogger(VolumesRatio.class);
    
    public double disectedByXYPlane(Sphere sphere) throws SphereNotCrossesCoordPlanesException {
        if (!CoordinatePlanes.xyCrossesSphere(sphere)) {
            throw new SphereNotCrossesCoordPlanesException();
        }
            
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
    
    public double disectedByYZPlane(Sphere sphere) throws SphereNotCrossesCoordPlanesException {
        if (!CoordinatePlanes.yzCrossesSphere(sphere)) {
            throw new SphereNotCrossesCoordPlanesException();
        }
        double R = sphere.getRadius();
        double H = R - Math.abs(sphere.getCenter().getX());

        double V1 = Math.PI * H*H / 3 * (3*R - H);
        double V = 4/3 * Math.PI * Math.pow(R, 3);
        
        return V1 / (V - V1);   
    }
    
    public double disectedByXZPlane(Sphere sphere) throws SphereNotCrossesCoordPlanesException {
        if (!CoordinatePlanes.xzCrossesSphere(sphere)) {
            throw new SphereNotCrossesCoordPlanesException();
        }
        double R = sphere.getRadius();
        double H = R - Math.abs(sphere.getCenter().getY());

        double V1 = Math.PI * H*H / 3 * (3*R - H);
        double V = 4/3 * Math.PI * Math.pow(R, 3);
        
        return V1 / (V - V1);
    }
}
