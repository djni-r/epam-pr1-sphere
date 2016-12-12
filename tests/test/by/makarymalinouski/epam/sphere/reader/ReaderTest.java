package test.by.makarymalinouski.epam.sphere.reader;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import by.makarymalinouski.epam.sphere.reader.Reader;

public class ReaderTest {

    @Test
    public void readTest_EmptyFile() throws IOException {
        String fileName = "emptyFile.txt";
        Path filePath = Files.createFile(new File(fileName).toPath());
        Reader reader = new Reader();
        Collection<Map<String, Double>> data = reader.read(fileName);
        Files.delete(filePath);
        
        assertTrue("must be empty", data.isEmpty());
        
    }
    
    @Test
    public void readTest() {
        String fileName = "files/sphere.txt";            
        Reader reader = new Reader();
        Collection<Map<String, Double>> data = reader.read(fileName);

        assertEquals("size must be 3", 3, data.size());
        
        Map<String, Double> map = new HashMap<>();
        
        map.put("centerX", 0.0);
        map.put("centerY", 0.0);
        map.put("centerZ", 0.0);
        map.put("radius", 10.0);
        assertTrue("must contain this map", data.contains(map));
        
        map.put("centerX", -1.23);
        map.put("centerY", 3.54);
        map.put("centerZ", 4.01);
        map.put("radius", 1.43);
        assertTrue("must contain this map", data.contains(map));
        
        map.put("centerX", 2.0);
        map.put("centerY", 3.0);
        map.put("centerZ", 4.1);
        map.put("radius", 2.0);
        assertTrue("must contain this map", data.contains(map));

    }
    
}
