package test.by.makarymalinouski.epam.sphere.creator;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;

import by.makarymalinouski.epam.sphere.creator.SphereCreator;
import by.makarymalinouski.epam.sphere.entity.Sphere;
import by.makarymalinouski.epam.sphere.exception.NoCreatorValuesException;

public class SphereCreatorTest {

    @Test
    public void createFromCollectionTest_Empty() throws NoCreatorValuesException {
        SphereCreator creator = new SphereCreator();
        Collection<Map<String, Double>> collection = new HashSet<>();
        Collection<Sphere> spheres = creator.createFromCollection(collection);
        assertEquals("size must be 0", 0, spheres.size());
    }
    
    
    @Test (expected = NoCreatorValuesException.class)
    public void createFromCollectionTest_Exception() throws NoCreatorValuesException {
        SphereCreator creator = new SphereCreator();
        Collection<Map<String, Double>> collection = new HashSet<>();
        Map<String, Double> map = new HashMap<>();
        collection.add(map);
        Collection<Sphere> spheres = creator.createFromCollection(collection);
    }
    
    
    @Test
    public void createFromCollectionTest() throws NoCreatorValuesException {
        SphereCreator creator = new SphereCreator();
        Collection<Map<String, Double>> collection = new HashSet<>();
        Map<String, Double> map = new HashMap<>();
        map.put("centerX", 0.0);
        map.put("centerY", 0.0);
        map.put("centerZ", 0.0);
        map.put("radius", 3.0);
        collection.add(map);
        Collection<Sphere> spheres = creator.createFromCollection(collection);
        assertEquals("size must be 1", 1, spheres.size());
        assertTrue("collection must contain this sphere", spheres.contains(new Sphere(0.0, 0.0, 0.0, 3.0)));
        
    }

}
