/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author kianp
 *
 */
public class StatesTest extends TestCase {

    private State VA;

    public void setUp() {

        int[] caseData = new int[] { 616402, 426362, 738177, -1, 137703 };
        int[] deathsData = new int[] { 34311, 14702, -1, -1, 2131 };
        VA = new State("VA", caseData, deathsData);
    }


    /**
     * 
     */
    public void testGetDeathsData() {

        assertEquals(34311, VA.getDeathsData(Races.WHITE));
        assertEquals(14702, VA.getDeathsData(Races.BLACK));
        assertEquals(-1, VA.getDeathsData(Races.LATINX));
        assertEquals(-1, VA.getDeathsData(Races.ASIAN));
        assertEquals(2131, VA.getDeathsData(Races.OTHER));
    }


    /**
     * 
     */
    public void testGetCaseData() {

        assertEquals(616402, VA.getCaseData(Races.WHITE));
        assertEquals(426362, VA.getCaseData(Races.BLACK));
        assertEquals(738177, VA.getCaseData(Races.LATINX));
        assertEquals(-1, VA.getCaseData(Races.ASIAN));
        assertEquals(137703, VA.getCaseData(Races.OTHER));
    }


    /**
     * 
     */
    public void testGetCFRData() {

        assertEquals(5.57, VA.getCFRData(Races.WHITE), 0.01);
        assertEquals(3.45, VA.getCFRData(Races.BLACK), 0.01);
        assertEquals(-1, VA.getCFRData(Races.LATINX), 0.01);
        assertEquals(-1, VA.getCFRData(Races.ASIAN), 0.01);
        assertEquals(1.55, VA.getCFRData(Races.OTHER), 0.01);
    }

}
