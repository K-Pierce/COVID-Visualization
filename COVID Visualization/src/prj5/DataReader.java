
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author kianp
 * @author nazartax
 * @version 11/19/2021
 */
public class DataReader {

    private SinglyLinkedList<State> states;

    public DataReader(String dataFileName) throws FileNotFoundException {

        states = readStateFile(dataFileName);
    }


    public SinglyLinkedList<State> getStates() {
        return states;
    }


    private SinglyLinkedList<State> readStateFile(String fileName)
        throws FileNotFoundException {

        SinglyLinkedList<State> readStates = new SinglyLinkedList<State>(); 

        Scanner file = new Scanner(new File(fileName));

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

            readStates.add(new State(data[0], cases, deaths)); 
        }

        return readStates;
    }
}
