package by.makarymalinouski.epam.sphere.reader;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Reader {
    static final Logger LOGGER = LogManager.getLogger(Reader.class);
    
    public Collection<Map<String, Double>> read(String fileName) {
        Collection<Map<String, Double>> validLines = new HashSet<>();
        
        try (Scanner scanner = new Scanner(new File(fileName))) {
            
            while (scanner.hasNextLine()) {
                scanner.useDelimiter("\n");
        
                if (scanner.hasNext("(-?\\d*[.]?\\d+\\s){3}\\d*[.]?\\d+")) {
                    scanner.reset();
                    Map<String, Double> map = new HashMap<>();
                    map.put("centerX", scanner.nextDouble());
                    map.put("centerY", scanner.nextDouble());
                    map.put("centerZ", scanner.nextDouble());
                    map.put("radius", scanner.nextDouble());
                    
                    validLines.add(Collections.unmodifiableMap(map));
                } else {
                    String line = scanner.nextLine();
                    LOGGER.debug(line.matches("(-?\\d*[.]?\\d+\\s){3}\\d*[.]?\\d+"));
                }
    
            }
        } catch (IOException e) {
            LOGGER.error("IOException", e);
        }
        return validLines;
    }
    
}
