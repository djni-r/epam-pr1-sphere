package by.makarymalinouski.epam.sphere.calculator;

import by.makarymalinouski.epam.sphere.entity.Sphere;

public class CoordinatePlanes {
    
    public static boolean touchSphere(Sphere sphere) {
        double R = sphere.getRadius();
        return sphere.getCenter().getX() - R == 0 ||
               sphere.getCenter().getY() - R == 0 ||
               sphere.getCenter().getZ() - R == 0;
    }
    
    public static boolean xyCrossesSphere(Sphere sphere) {
        return sphere.getRadius() < sphere.getCenter().getZ();
    }
    
    public static boolean yzCrossesSphere(Sphere sphere) {
        return sphere.getRadius() < sphere.getCenter().getX();
    }
    
    public static boolean xzCrossesSphere(Sphere sphere) {
        return sphere.getRadius() < sphere.getCenter().getY();
    }

}
