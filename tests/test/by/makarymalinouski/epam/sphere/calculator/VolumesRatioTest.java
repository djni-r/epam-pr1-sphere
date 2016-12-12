package test.by.makarymalinouski.epam.sphere.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.makarymalinouski.epam.sphere.calculator.VolumesRatio;
import by.makarymalinouski.epam.sphere.entity.Sphere;
import by.makarymalinouski.epam.sphere.exception.SphereNotCrossesCoordPlanesException;

public class VolumesRatioTest {

    @Test
    public void disectedByXYPlaneTest() throws SphereNotCrossesCoordPlanesException {
        double h = 0.5;
        double r = 3.5;
        double v1 = Math.PI * h*h / 3 * (3*r - h);
        double v = 4/3 * Math.PI * Math.pow(r, 3);
        double ratio = v1 / (v - v1);
            assertEquals("ratio of volumes divided by XY plane", ratio, 
                    VolumesRatio.disectedByXYPlane(new Sphere(0, 2, -3, 3.5)), 0);

    }
    
    @Test (expected = SphereNotCrossesCoordPlanesException.class)
    public void disectedByXYPlaneTest_Exception() throws SphereNotCrossesCoordPlanesException {
        VolumesRatio.disectedByXYPlane(new Sphere(5, 4, 5, 2));
    }

}
