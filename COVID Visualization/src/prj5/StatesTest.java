/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author kianp
 * @version 19.11.21
 */
public class StatesTest extends TestCase {

    private State VA;

    /**
     * Creates a new state object for testing
     */
    public void setUp() {

        int[] caseData = new int[] { 616402, 426362, 738177, -1, 137703 };
        int[] deathsData = new int[] { 34311, 14702, -1, -1, 2131 };
        VA = new State("VA", caseData, deathsData);
    }


    /**
     * Ensures getDaethsData properly returns the number of deaths for the given
     * race
     */
    public void testGetDeathsData() {

        assertEquals(34311, VA.getDeathsData()[0]);
        assertEquals(14702, VA.getDeathsData()[1]);
        assertEquals(-1, VA.getDeathsData()[2]);
        assertEquals(-1, VA.getDeathsData()[3]);
        assertEquals(2131, VA.getDeathsData()[4]);
    }


    /**
     * Ensures getCaseData properly returns the nubmer of cases for the given
     * race
     */
    public void testGetCaseData() {

        assertEquals(616402, VA.getCaseData()[0]);
        assertEquals(426362, VA.getCaseData()[1]);
        assertEquals(738177, VA.getCaseData()[2]);
        assertEquals(-1, VA.getCaseData()[3]);
        assertEquals(137703, VA.getCaseData()[4]);
    }


    /**
     * Ensures getCFRData properly returns the CFR for the given race
     */
    public void testGetCFRData() {

        assertEquals(5.6, VA.getCFRData()[0], 0.1);
        assertEquals(3.4, VA.getCFRData()[1], 0.1);
        assertEquals(-1, VA.getCFRData()[2], 0.1);
        assertEquals(-1, VA.getCFRData()[3], 0.1);
        assertEquals(1.5, VA.getCFRData()[4], 0.1);
    }


    /**
     * Ensures sortByCFR properly returns an array of CFR data sorted from
     * greatest to least
     */
    public void testSortCFR() {

        VA.sortByCFR();
        assertEquals(5.6, VA.getCFRData()[0], 0.1);
        assertEquals(3.4, VA.getCFRData()[1], 0.1);
        assertEquals(1.5, VA.getCFRData()[2], 0.1);
        assertEquals(-1, VA.getCFRData()[3], 0.1);
        assertEquals(-1, VA.getCFRData()[4], 0.1);
    }


    /**
     * Ensures sortAlpha properly returns an array of CFR data sorted
     * alphabetically
     */
    public void testSortAlpha() {

        VA.sortAlpha();
        assertEquals(-1, VA.getCFRData()[0], 0.1);
        assertEquals(3.4, VA.getCFRData()[1], 0.1);
        assertEquals(-1, VA.getCFRData()[2], 0.1);
        assertEquals(1.5, VA.getCFRData()[3], 0.1);
        assertEquals(5.6, VA.getCFRData()[4], 0.1);
    }


    /**
     * Ensures toString properly summarizes the state as a string
     */
    public void testToString() {
        String str = "WHITE: 616402 cases, 5.6% CFR\n"
            + "BLACK: 426362 cases, 3.4% CFR\n"
            + "LATINX: 738177 cases, -1% CFR\n" + "ASIAN: -1 cases, -1% CFR\n"
            + "OTHER: 137703 cases, 1.5% CFR";
        assertEquals(str, VA.toString());
    }

}
