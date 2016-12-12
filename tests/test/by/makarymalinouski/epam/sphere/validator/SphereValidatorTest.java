package test.by.makarymalinouski.epam.sphere.validator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import by.makarymalinouski.epam.sphere.entity.Sphere;
import by.makarymalinouski.epam.sphere.validator.SphereValidator;

public class SphereValidatorTest {

    @Test
    public void isRealSphereTest_True() {
        assertTrue(SphereValidator.isRealSphere(new Sphere(0, 0, 0, 3)));
    }
    
    @Test
    public void isRealSphereTest_False() {
        assertFalse(SphereValidator.isRealSphere(new Sphere(0, 0, 0, -3)));
    }

}
