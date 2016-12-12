package test.by.makarymalinouski.epam.sphere.info;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Rule;

import by.makarymalinouski.epam.sphere.info.SphereInfo;
import by.makarymalinouski.epam.sphere.entity.Sphere;

public class SphereInfoTest {

    public SphereInfo sphereInfo = new SphereInfo(new Sphere(0, 2, -3, 3.5));

    @Test
    public void surfaceAreaTest() {
        double surfaceArea = 4 * Math.PI * 3.5 * 3.5;
        assertEquals("surface area must be", surfaceArea, sphereInfo.surfaceArea(), 0);
    }

    @Test
    public void volumeTest() {
        double volume = 4 * Math.PI * Math.pow(3.5, 3);
        assertEquals("volume must be", volume, sphereInfo.volume(), 0);
        
    }

    @Test
    public void volumesRatioXYTest() {
        double h = 0.5;
        double r = 3.5;
        double v1 = Math.PI * h*h / 3 * (3*r - h);
        double v = 4/3 * Math.PI * Math.pow(r, 3);
        double ratio = v1 / (v - v1);
        assertEquals("ratio of volumes divided by XY plane", ratio, sphereInfo.volumesRatioXY(), 0);

    }

    @Ignore
    @Test
    public void volumesRatioYZTest() {
        fail("Not yet implemented");
    }
    @Ignore
    @Test
    public void volumesRatioZXTest() {
        fail("Not yet implemented");
    }

    @Test
    public void touchesCoordinatePlaneTest_True() {
        assertTrue("true - touches the plane", 
                new SphereInfo(new Sphere(3, 0, 0, 3)).touchesCoordinatePlane());
    }
    
    @Test
    public void touchesCoordinatePlaneTest_False() {
        assertFalse("false - doesn't touch the plane", 
                new SphereInfo(new Sphere(3, 0, 0, 2)).touchesCoordinatePlane());
    }

}
