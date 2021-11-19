
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

    /**
     * Constructor 
     * @param dataFileName name of the input file
     * @throws FileNotFoundException if the name does not exist. 
     */
    public DataReader(String dataFileName) throws FileNotFoundException {

        states = readStateFile(dataFileName);
    }


    /**
     * Getter method for the list of states
     * @return the list of states
     */
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

            String[] data = line.split(",");

            int[] cases = new int[5];
            for (int j = 0; j < 5; j++) {
                if (data[j + 1].equals("NA")) {
                    cases[j] = -1;
                }
                else {
                    cases[j] = Integer.valueOf(data[j + 1]);
                }
            }

            int[] deaths = new int[5];
            for (int j = 0; j < 5; j++) {
                if (data[j + 6].equals("NA")) {
                    deaths[j] = -1;
                }
                else {
                    deaths[j] = Integer.valueOf(data[j + 6]);
                }
            }

            readStates.add(new State(data[0], cases, deaths));
        }
        readStates = readStates.sortStates(); 
        return readStates;
    }
    
    
}
