package by.makarymalinouski.epam.sphere.calculator;

import by.makarymalinouski.epam.sphere.entity.Sphere;

public class SurfaceArea {
    public static double calculate(Sphere sphere) {
        return 4 * Math.PI * Math.pow(sphere.getRadius(), 2);
    }
}
