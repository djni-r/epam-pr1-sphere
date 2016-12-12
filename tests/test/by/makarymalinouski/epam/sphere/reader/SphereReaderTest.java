package test.by.makarymalinouski.epam.sphere.reader;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import by.makarymalinouski.epam.sphere.entity.Point;
import by.makarymalinouski.epam.sphere.entity.Sphere;
import by.makarymalinouski.epam.sphere.reader.SphereReader;

public class SphereReaderTest {

    @Test
    public void readTest() {
        String fileName = "files/sphere.txt";            
        SphereReader sphereReader = new SphereReader();
        Sphere sphere1 = new Sphere(new Point(0, 0, 0), 10);
        Sphere sphere2 = new Sphere(new Point(-1, 3, 4), 1);
        Collection<Sphere> spheres = sphereReader.read(fileName);

        assertEquals("size must be 2", 2, spheres.size());
        assertTrue("must contain these spheres", spheres.containsAll(Arrays.asList(sphere1, sphere2)));
            
    }
    
}
