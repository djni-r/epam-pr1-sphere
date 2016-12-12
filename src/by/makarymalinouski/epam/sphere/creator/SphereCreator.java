package by.makarymalinouski.epam.sphere.creator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import by.makarymalinouski.epam.sphere.entity.Sphere;
import by.makarymalinouski.epam.sphere.exception.NoCreatorValuesException;;


public class SphereCreator {

    public Collection<Sphere> createFromCollection(Collection<Map<String, Double>> valuesCollection) throws NoCreatorValuesException {
        Collection<Sphere> spheres = new HashSet<>();
        for (Map<String, Double> values : valuesCollection) {
            if (values.isEmpty()) {
                throw new NoCreatorValuesException("Unable to create sphere. The map of values is empty");
            }
            spheres.add(makeSphere(values));
        }
        return spheres;
    }
    
    private Sphere makeSphere(Map<String, Double> values) {
        return new Sphere(values.get("centerX"), 
                          values.get("centerY"), 
                          values.get("centerZ"), 
                          values.get("radius")
                      );
    }
}
