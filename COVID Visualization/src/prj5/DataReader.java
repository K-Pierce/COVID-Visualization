/**
 * 
 */
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author kianp
 *
 */
public class DataReader {

    private State[] states;

    public DataReader(String dataFileName) throws FileNotFoundException {

        states = readStateFile(dataFileName);
    }


    public State[] getStates() {
        return states;
    }


    private State[] readStateFile(String fileName)
        throws FileNotFoundException {

        State[] readStates = new State[6];

        Scanner file = new Scanner(new File(fileName));

        int i = 0;
        String line = file.nextLine();
        while (file.hasNextLine()) {
            line = file.nextLine();

            String[] data = line.split("\t");

            int[] cases = new int[5];
            for (int j = 0; j < 5; j++) {
                cases[j] = Integer.valueOf(data[j + 1]);
            }

            int[] deaths = new int[5];
            for (int j = 0; j < 5; j++) {
                deaths[j] = Integer.valueOf(data[j + 6]);
            }

            readStates[i] = new State(data[0], cases, deaths);
            i++;
        }

        return readStates;
    }
}
