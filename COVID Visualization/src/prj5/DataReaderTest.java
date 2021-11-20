/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

/**
 * Class for testing the methods in DataReader
 * 
 * @author kianp
 *
 */
public class DataReaderTest extends TestCase {

    private DataReader reader;

    /**
     * Creates a ew DataReader object for testing
     */
    public void setUp() throws FileNotFoundException {

        reader = new DataReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }


    /**
     * Ensures data is properly read from the given file
     */
    public void testRead() {

        assertEquals("DC", reader.getStates().get(0).getName());
        assertEquals("GA", reader.getStates().get(1).getName());
        assertEquals("MD", reader.getStates().get(2).getName());
        assertEquals("NC", reader.getStates().get(3).getName());
        assertEquals("TN", reader.getStates().get(4).getName());
        assertEquals("VA", reader.getStates().get(5).getName());

        assertEquals(1924, reader.getStates().get(0).getDeathsData()[0]);
        assertEquals(13365, reader.getStates().get(0).getDeathsData()[1]);
        assertEquals(2269, reader.getStates().get(0).getDeathsData()[2]);
        assertEquals(254, reader.getStates().get(0).getDeathsData()[3]);
        assertEquals(170, reader.getStates().get(0).getDeathsData()[4]);

        assertEquals(34311, reader.getStates().get(5).getDeathsData()[0]);
        assertEquals(14702, reader.getStates().get(5).getDeathsData()[1]);
        assertEquals(-1, reader.getStates().get(5).getDeathsData()[2]);
        assertEquals(-1, reader.getStates().get(5).getDeathsData()[3]);
        assertEquals(5745, reader.getStates().get(5).getDeathsData()[4]);

        assertEquals(70678, reader.getStates().get(0).getCaseData()[0]);
        assertEquals(179563, reader.getStates().get(0).getCaseData()[1]);
        assertEquals(97118, reader.getStates().get(0).getCaseData()[2]);
        assertEquals(5407, reader.getStates().get(0).getCaseData()[3]);
        assertEquals(108784, reader.getStates().get(0).getCaseData()[4]);

        assertEquals(616402, reader.getStates().get(5).getCaseData()[0]);
        assertEquals(426362, reader.getStates().get(5).getCaseData()[1]);
        assertEquals(738177, reader.getStates().get(5).getCaseData()[2]);
        assertEquals(-1, reader.getStates().get(5).getCaseData()[3]);
        assertEquals(777332, reader.getStates().get(5).getCaseData()[4]);
    }

}
