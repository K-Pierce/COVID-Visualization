/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

/**
 * @author kianp
 *
 */
public class DataReaderTest extends TestCase {

    private DataReader reader;

    public void setUp() throws FileNotFoundException {

        reader = new DataReader("Data_RANDOM_NUMBERS.txt");
    }


    public void testRead() {

        assertEquals("DC", reader.getStates().get(0).getName());
        assertEquals("GA", reader.getStates().get(1).getName());
        assertEquals("MD", reader.getStates().get(2).getName());
        assertEquals("NC", reader.getStates().get(3).getName());
        assertEquals("TN", reader.getStates().get(4).getName());
        assertEquals("VA", reader.getStates().get(5).getName());
    }

}
