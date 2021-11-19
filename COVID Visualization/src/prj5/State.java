package prj5;

/**
 * Defines a State which has fields for the number of cases and deaths for 
 * each race (6). 
 * 
 * @author kianp
 * @author nazartax
 * @version 19.11.21
 */
public class State {

    private String name;
    private int[] caseData;
    private int[] deathData;
    private Races[] races;
    
    public State(String name, int[] cData, int[] dData) {

        races = new Races[5];

        caseData = cData;
        deathData = dData;
        this.name = name;
        races[0] = Races.WHITE;
        races[1] = Races.BLACK; 
        races[2] = Races.LATINX; 
        races[3] = Races.ASIAN; 
        races[4] = Races.OTHER; 
     }

    
    public String getName() {
        return name;
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
    
    /**
     * Selection Sort algorithm to sort the data by races alphabetically. 
     */
    public void sortAlpha() {
        int size = caseData.length; 

        for (int i = 0; i < size - 1; i++) {
            
            int minIndex = i;
            
            for (int j = i + 1; j < size; j++) { 
                if (races[j].toString().compareTo(races[minIndex].toString())
                    < 0) {
                    minIndex = j;
                }
            }

            Races tempRace = races[minIndex]; 
            races[minIndex] = races[i]; 
            races[i] = tempRace; 
            
            
            int tempDeath = deathData[minIndex];
            deathData[minIndex] = deathData[i];
            deathData[i] = tempDeath;
            
            int tempCase = caseData[minIndex];
            caseData[minIndex] = caseData[i];
            caseData[i] = tempCase;
        }
    }
    
    /**
     * Selection Sort algorithm to sort the data by CFR from descending order. 
     */
    public void sortByCFR() {
        int size = caseData.length; 

        for (int i = 0; i < size - 1; i++) {
            
            int minIndex = i;
            
            for (int j = i + 1; j < size; j++) { 
                if (calculateCFR(races[j]) < calculateCFR(races[minIndex])) {
                    minIndex = j;
                }
            }

            Races tempRace = races[minIndex]; 
            races[minIndex] = races[i]; 
            races[i] = tempRace; 
            
            
            int tempDeath = deathData[minIndex];
            deathData[minIndex] = deathData[i];
            deathData[i] = tempDeath;
            
            int tempCase = caseData[minIndex];
            caseData[minIndex] = caseData[i];
            caseData[i] = tempCase;
        }
    }
    
    /**
     * Returns a string representation of a State
     */
    public String toString() { 
        StringBuilder builder = new StringBuilder(); 
        
        for (int i = 0; i < caseData.length; i++) { 
            builder.append(races[i].toString() + ": "); 
            builder.append(caseData[i] + "cases, "); 
            builder.append(calculateCFR(races[i]) + "% CFR");
            builder.append("\n"); 
        }
        
        return builder.toString(); 
    }
}
