
package prj5;

import java.io.FileNotFoundException;

/**
 * Main class to run the project, reads in data from command line input file
 * or manually coded file name and passes it to a controller 
 * and then displaying a window of the data for COVID visualization
 * 
 * @author kianp
 * @author Nazar Taxitiemuer (nazartax)
 * @author aniketc2002
 * @version 12/3/2021
 */
public class Input {

    /**
     * Uses DataReader to take in data from the file provided, then uses 
     * DataController to manage the data and create a Linked List from it, 
     * finally everything is displayed with the GUI class. 
     * 
     * @param args
     *            Command Line inputs
     * @throws FileNotFoundException
     *             if the file does not exist
     */
    public static void main(String[] args) throws FileNotFoundException {
<<<<<<< HEAD

        DataReader reader;
        if (args.length > 0) {
            reader = new DataReader(args[0]);
        }
        else {

            reader = new DataReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }

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
=======
        
        DataReader reader = new DataReader("Cases_and_Deaths_CRDT_NEW.csv"); 
        DataController controller = new DataController(reader); 
        GUI newWindow = new GUI(controller); 
        
        /**
         * (Intermediate Submission) 
         * 
         * DataReader reader = new DataReader(args[0]);
         * SinglyLinkedList<State> allStates = reader.getStates();
         * for (int i = 0; i < allStates.size(); i++) {
         *    State currentState = allStates.get(i);
         *    System.out.println(currentState.getName());
         *    currentState.sortAlpha();
         *    System.out.println(currentState.toString());
         *    System.out.println("====");
         *    currentState.sortByCFR();
         *    System.out.println(currentState.toString());
         *    System.out.println("====");
         * }
         * 
         */
>>>>>>> branch 'main' of https://github.com/K-Pierce/COVID-Visualization
    }

}
