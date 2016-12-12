package test.by.makarymalinouski.epam.sphere.reader;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import by.makarymalinouski.epam.sphere.reader.Reader;

public class ReaderTest {

    @Test
    public void readTest() {
        String fileName = "files/sphere.txt";            
        Reader reader = new Reader();
        Collection<List<Double>> data = reader.read(fileName);

        assertEquals("size must be 3", 3, data.size());
        assertTrue("must contain these lists", data.containsAll(Arrays.asList(
                Arrays.asList(0.0, 0.0, 0.0, 10.0),
                Arrays.asList(-1.23, 3.54, 4.01, 1.43), 
                Arrays.asList(2.0, 3.0, 4.1, 2.0)))
            );
    }
    
}
