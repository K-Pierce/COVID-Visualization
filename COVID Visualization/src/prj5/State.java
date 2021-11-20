package prj5;

import java.text.DecimalFormat;

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
    private double[] cfrData;
    private Races[] races;

    public State(String name, int[] cData, int[] dData) {

        races = new Races[5];

        caseData = cData;
        deathData = dData;
        this.name = name;

        cfrData = new double[6];
        for (int i = 0; i < 5; i++) {
            cfrData[i] = calculateCFR(deathData[i], caseData[i]);
        }

        races[0] = Races.WHITE;
        races[1] = Races.BLACK;
        races[2] = Races.LATINX;
        races[3] = Races.ASIAN;
        races[4] = Races.OTHER;
    }


    public String getName() {
        return name;
    }


    public int[] getDeathsData() {
        return deathData;
    }


    public int[] getCaseData() {
        return caseData;
    }


    public double[] getCFRData() {
        return cfrData;
    }


    private double calculateCFR(int deaths, int cases) {

        if (deaths != -1 && cases != -1) {
            double num = ((double)deaths / cases) * 100;
            DecimalFormat form = new DecimalFormat("###.#");
            String out = form.format(num);

            return Double.valueOf(out);
        }

        return -1;

    }


    /**
     * Selection Sort algorithm to sort the data by races alphabetically.
     */
    public void sortAlpha() {
        int size = caseData.length;

        for (int i = 0; i < size - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (races[j].toString().compareTo(races[minIndex]
                    .toString()) < 0) {
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

            double tempCFR = cfrData[minIndex];
            cfrData[minIndex] = cfrData[i];
            cfrData[i] = tempCFR;

        }
    }


    /**
     * Selection Sort algorithm to sort the data by CFR from descending order.
     */
    public void sortByCFR() {
        int size = caseData.length;

        for (int i = 0; i < size - 1; i++) {

            int maxIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (cfrData[j] > cfrData[maxIndex]) {
                    maxIndex = j;
                }
                else if (cfrData[j] == cfrData[maxIndex]) {
                    if (races[j].toString().compareTo(races[maxIndex]
                        .toString()) < 0) {
                        maxIndex = j;
                    }
                }

                Races tempRace = races[maxIndex];
                races[maxIndex] = races[i];
                races[i] = tempRace;

                int tempDeath = deathData[maxIndex];
                deathData[maxIndex] = deathData[i];
                deathData[i] = tempDeath;

                int tempCase = caseData[maxIndex];
                caseData[maxIndex] = caseData[i];
                caseData[i] = tempCase;

                double tempCFR = cfrData[maxIndex];
                cfrData[maxIndex] = cfrData[i];
                cfrData[i] = tempCFR;
            }
        }
    }


    /**
     * Returns a string representation of a State
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < caseData.length; i++) {
            builder.append(races[i].toString() + ": ");
            builder.append(caseData[i] + " cases, ");
            // builder.append(deathData[i] + " deaths\t");

            if (cfrData[i] == -1.0) {
                builder.append("-1% CFR");
            }
            else if (cfrData[i] == 1.0) {
                builder.append("1% CFR");
            }
            else {
                builder.append(cfrData[i] + "% CFR");
            }
            if (i != caseData.length - 1) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }
}
