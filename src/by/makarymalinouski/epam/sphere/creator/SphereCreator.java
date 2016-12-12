package by.makarymalinouski.epam.sphere.creator;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import by.makarymalinouski.epam.sphere.entity.Sphere;

public class SphereCreator {
    public Collection<Sphere> createFromCollection(Collection<List<Double>> valuesCollection) {
        Collection<Sphere> spheres = new HashSet<>();
        for (List<Double> values : valuesCollection) {
            spheres.add(makeSphere(values));
        }
        return spheres;
    }
    
    public Sphere makeSphere(List<Double> values) {
        return new Sphere(values.get(0), values.get(1), values.get(2), values.get(3));
    }
}
