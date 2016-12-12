package test.by.makarymalinouski.epam.sphere.reader;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
//        File file = new File(fileName);
//        try (FileWriter fileWriter = new FileWriter(file)) {
//            fileWriter.write("0 0 0 2\n-1 3 4 1");
//            fileWriter.close();
            
            SphereReader sphereReader = new SphereReader();
            Sphere sphere1 = new Sphere(new Point(0, 0, 0), 10);
            Sphere sphere2 = new Sphere(new Point(-1, 3, 4), 1);
            Collection<Sphere> spheres = sphereReader.read(fileName);
            assertTrue("size must be 2", spheres.size() == 2);
            assertTrue("must contain these spheres", spheres.containsAll(Arrays.asList(sphere1, sphere2)));
            
//        } catch (IOException e) {
//            
//        } finally {
//            file.delete();
//        }
    }

}
