package by.makarymalinouski.epam.sphere.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Reader {
    static final Logger LOGGER = LogManager.getLogger(Reader.class);
    
    
    public Collection<List<Double>> read(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Scanner scanner = null;
            Collection<List<Double>> validLines = new HashSet<>();
            while ((line = reader.readLine()) != null) {
                LOGGER.debug("line: " + line);
                if (line.matches("(-?\\d*[.]?\\d+\\s){3}\\d*[.]?\\d+")) {
                    scanner = new Scanner(line);
                    LOGGER.debug("line match: " + line);
                    validLines.add(Collections.unmodifiableList(Arrays.asList(scanner.nextDouble(),
                                                                              scanner.nextDouble(),
                                                                              scanner.nextDouble(),
                                                                              scanner.nextDouble()) ));
                }
            }
            return validLines;
            
        } catch (IOException e) {
            LOGGER.error("ioexception", e);
        }
        return Collections.emptySet();
    }
    
    
    
    
    public Collection<List<Double>> readSc(String fileName) {
        Collection<List<Double>> validLines = new HashSet<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
    
                if (scanner.hasNext("(-?\\d*[.]?\\d+\\s){3}\\d*[.]?\\d+")) {
    
                    validLines.add(Collections.unmodifiableList(Arrays.asList(scanner.nextDouble(),
                            scanner.nextDouble(),
                            scanner.nextDouble(),
                            scanner.nextDouble()) ));
                } else {
                    LOGGER.debug(scanner.nextLine().matches("(-?\\d*[.]?\\d+\\s){3}\\d*[.]?\\d+"));
                }
    
            }
        } catch (IOException e) {
            LOGGER.error("IOException", e);
        }
        return validLines;
    }
    
}
