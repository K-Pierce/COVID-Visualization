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

    }


    /**
     * 
     */
    public void testGetCaseData() {

    }


    /**
     * 
     */
    public void testGetCFRData() {

    }


    public void testSortAlpha() {

    }

}
