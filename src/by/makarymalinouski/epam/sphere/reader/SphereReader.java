package by.makarymalinouski.epam.sphere.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import by.makarymalinouski.epam.sphere.entity.Point;
import by.makarymalinouski.epam.sphere.entity.Sphere;

public class SphereReader {
    static final Logger LOGGER = LogManager.getLogger(SphereReader.class);
    
    
    public Collection<Sphere> read(String fileName) {
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName)))
                ) {
            String line;
            String[] values = new String[4];
            Collection<Sphere> spheres = new HashSet<Sphere>();
            while ((line = reader.readLine()) != null) {
                LOGGER.debug("line: " + line);
                if (!(line.startsWith("#"))) {
                    values = line.split(" ");
                    
                    spheres.add(new Sphere(
                        new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2])), 
                        Integer.parseInt(values[3])) );
                }
            }
            return spheres;
        } catch (IOException e) {
            LOGGER.error("ioexception", e);
        }
        return Collections.emptySet();
    }
    
//    public Sphere makeSphere()
}
