
package prj5;

import java.io.FileNotFoundException;

/**
 * Main class to run the project, reads in data from command line input file
 * name and creates a Linked list to store in the data of each State
 * and its cases. Prints out State data.
 * 
 * @author kianp
 * @author nazartax
 * @version 11/19/2021
 */
public class Input {

    /**
     * @param args
     *            Command Line inputs
     * @throws FileNotFoundException
     *             if the file does not exist
     */
    public static void main(String[] args) throws FileNotFoundException {
        DataReader reader = new DataReader(args[0]);
        SinglyLinkedList<State> allStates = reader.getStates();
        for (int i = 0; i < allStates.size(); i++) {
            State currentState = allStates.get(i);
            System.out.println(currentState.getName());
            currentState.sortAlpha();
            System.out.println(currentState.toString());
            System.out.println("====");
            currentState.sortByCFR();
            System.out.println(currentState.toString());
            System.out.println("====");
        }
    }

}
