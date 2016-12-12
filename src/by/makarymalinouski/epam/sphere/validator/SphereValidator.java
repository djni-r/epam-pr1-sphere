package by.makarymalinouski.epam.sphere.validator;

import by.makarymalinouski.epam.sphere.entity.Sphere;

public class SphereValidator {
    public static boolean isRealSphere(Sphere sphere) {
        return sphere.getRadius() > 0;
    }

}
