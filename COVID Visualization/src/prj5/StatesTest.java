// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kian Pierce (kianp20)
package prj5;

import student.TestCase;

/**
 * @author kianp
 * @version 19.11.21
 */
public class StatesTest extends TestCase {

    private State va;

    /**
     * Creates a new state object for testing
     */
    public void setUp() {

        int[] caseData = new int[] { 616402, 426362, 738177, -1, 137703 };
        int[] deathsData = new int[] { 34311, 14702, -1, -1, 2131 };
        va = new State("va", caseData, deathsData);
    }


    /**
     * Ensures getDaethsData properly returns the number of deaths for the given
     * race
     */
    public void testGetDeathsData() {

        assertEquals(34311, va.getDeathsData()[0]);
        assertEquals(14702, va.getDeathsData()[1]);
        assertEquals(-1, va.getDeathsData()[2]);
        assertEquals(-1, va.getDeathsData()[3]);
        assertEquals(2131, va.getDeathsData()[4]);
    }


    /**
     * Ensures getCaseData properly returns the nubmer of cases for the given
     * race
     */
    public void testGetCaseData() {

        assertEquals(616402, va.getCaseData()[0]);
        assertEquals(426362, va.getCaseData()[1]);
        assertEquals(738177, va.getCaseData()[2]);
        assertEquals(-1, va.getCaseData()[3]);
        assertEquals(137703, va.getCaseData()[4]);
    }


    /**
     * Ensures getCFRData properly returns the CFR for the given race
     */
    public void testGetCFRData() {

        assertEquals(5.6, va.getCFRData()[0], 0.1);
        assertEquals(3.4, va.getCFRData()[1], 0.1);
        assertEquals(-1, va.getCFRData()[2], 0.1);
        assertEquals(-1, va.getCFRData()[3], 0.1);
        assertEquals(1.5, va.getCFRData()[4], 0.1);
    }


    /**
     * Ensures sortByCFR properly returns an array of CFR data sorted from
     * greatest to least
     */
    public void testSortCFR() {

        va.sortByCFR();
        assertEquals(5.6, va.getCFRData()[0], 0.1);
        assertEquals(3.4, va.getCFRData()[1], 0.1);
        assertEquals(1.5, va.getCFRData()[2], 0.1);
        assertEquals(-1, va.getCFRData()[3], 0.1);
        assertEquals(-1, va.getCFRData()[4], 0.1);

        int[] caseData2 = new int[] { 100, -1, 1, -1, -1 };
        int[] deathsData2 = new int[] { 1, 1, -1, -1, -1 };
        State ga = new State("ga", caseData2, deathsData2);
        assertEquals(1, ga.getCFRData()[0], 0.1);
        assertEquals(-1, ga.getCFRData()[1], 0.1);
        assertEquals(-1, ga.getCFRData()[2], 0.1);
        assertEquals(-1, ga.getCFRData()[3], 0.1);
        assertEquals(-1, ga.getCFRData()[4], 0.1);

        int[] caseData3 = new int[] { 367, 367, 367, 367, 367 };
        int[] deathsData3 = new int[] { 25, 25, 25, 25, 25 };
        State nc = new State("ga", caseData3, deathsData3);
        nc.sortByCFR();
        assertEquals(6.8, nc.getCFRData()[0], 0.1);
        assertEquals(6.8, nc.getCFRData()[1], 0.1);
        assertEquals(6.8, nc.getCFRData()[2], 0.1);
        assertEquals(6.8, nc.getCFRData()[3], 0.1);
        assertEquals(6.8, nc.getCFRData()[4], 0.1);
    }


    /**
     * Ensures sortAlpha properly returns an array of CFR data sorted
     * alphabetically
     */
    public void testSortAlpha() {

        va.sortAlpha();
        assertEquals(-1, va.getCFRData()[0], 0.1);
        assertEquals(3.4, va.getCFRData()[1], 0.1);
        assertEquals(-1, va.getCFRData()[2], 0.1);
        assertEquals(1.5, va.getCFRData()[3], 0.1);
        assertEquals(5.6, va.getCFRData()[4], 0.1);
    }


    /**
     * Ensures toString properly summarizes the state as a string
     */
    public void testToString() {
        String str = "white: 616402 cases, 5.6% CFR\n"
            + "black: 426362 cases, 3.4% CFR\n"
            + "latinx: 738177 cases, -1% CFR\n" + "asian: -1 cases, -1% CFR\n"
            + "other: 137703 cases, 1.5% CFR";
        assertEquals(str, va.toString());
    }


    /**
     * Ensures getRaces properly returns an array of race enums
     */
    public void testGetRaces() {

        assertEquals("white", va.getRaces()[0]);
        assertEquals("black", va.getRaces()[1]);
        assertEquals("latinx", va.getRaces()[2]);
        assertEquals("asian", va.getRaces()[3]);
        assertEquals("other", va.getRaces()[4]);
    }

}
