package prj5;

/**
 * 
 * @author kianp
 * @version 19.11.21
 */
public class State {

    private String name;
    private int[] caseData;
    private int[] deathData;

    public State(String nme, int[] cData, int[] dData) {

        caseData = cData;
        deathData = dData;
        name = nme;
    }


    public int getDeathsData(Races race) {
        switch (race) {
            case WHITE:
                return deathData[0];
            case BLACK:
                return deathData[1];
            case LATINX:
                return deathData[2];
            case ASIAN:
                return deathData[3];
            default:
                return deathData[4];
        }
    }


    public int getCaseData(Races race) {
        switch (race) {
            case WHITE:
                return caseData[0];
            case BLACK:
                return caseData[1];
            case LATINX:
                return caseData[2];
            case ASIAN:
                return caseData[3];
            default:
                return caseData[4];
        }
    }


    public double getCFRData(Races race) {
        switch (race) {
            case WHITE:
                return calculateCFR(race);
            case BLACK:
                return calculateCFR(race);
            case LATINX:
                return calculateCFR(race);
            case ASIAN:
                return calculateCFR(race);
            default:
                return calculateCFR(race);
        }
    }


    private double calculateCFR(Races race) {

        if (getDeathsData(race) > 0 && getCaseData(race) > 0) {
            float div = ((float)getDeathsData(race)) / getCaseData(race);
            return div * 100;
        }
        else {
            return -1;
        }
    }

}
