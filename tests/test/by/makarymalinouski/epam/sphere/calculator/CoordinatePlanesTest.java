package test.by.makarymalinouski.epam.sphere.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

import by.makarymalinouski.epam.sphere.calculator.CoordinatePlanes;
import by.makarymalinouski.epam.sphere.entity.Sphere;

public class CoordinatePlanesTest {

    @Test
    public void touchSphereTest_True() {
        assertTrue("true - touches the plane", 
                CoordinatePlanes.touchSphere(new Sphere(3, 0, 0, 3)));
    }
    
    @Test
    public void touchSphereTest_False() {
        assertFalse("false - doesn't touch the plane", 
                CoordinatePlanes.touchSphere(new Sphere(3, 0, 0, 2)));
    }


}
