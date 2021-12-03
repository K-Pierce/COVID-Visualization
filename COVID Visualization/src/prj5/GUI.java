/**
 * 
 */
package prj5;

import cs2.Button;
import cs2.Window;
import cs2.WindowSide;

/**
 * @author kianp
 * @author aniketc2002
 * @version 12/3/2021
 */
public class GUI {
    // private Shape barData;
    // private TextShape displayCFR;
    // private TextShape displayEthnicity;
    // private TextShape displayTitle;
    private Window window;
    private static int BAR_WIDTH = 10;
    private static int BAR_GAP = 5;
    private Button alphaSort;
    private Button cfrSort;
    private Button stateVA;
    private Button stateGA;
    private Button stateDC;
    private Button stateMD;
    private Button stateTN;
    private Button stateNC;
    private Button quitButton;

    private State currState;
    SinglyLinkedList<State> states;

    /**
     * This constructor initializes a new window of display that
     * implements the information given to the graph
     *
     * @param
     */
    public GUI(SinglyLinkedList<State> statesData) {
        states = statesData;
        currState = states.get(0);

        window = new Window();
        window.setTitle("Graph of COVID Cases and Deaths");

        alphaSort = new Button("Sort by Alpha");
        cfrSort = new Button("Sort by CFR");
        quitButton = new Button("Quit");

        stateVA = new Button("Represent VA");
        stateGA = new Button("Represent GA");
        stateDC = new Button("Represent DC");
        stateMD = new Button("Represent MD");
        stateTN = new Button("Represent TN");
        stateNC = new Button("Represent NC");

        window.addButton(stateVA, WindowSide.SOUTH);
        window.addButton(stateGA, WindowSide.SOUTH);
        window.addButton(stateDC, WindowSide.SOUTH);
        window.addButton(stateMD, WindowSide.SOUTH);
        window.addButton(stateTN, WindowSide.SOUTH);
        window.addButton(stateNC, WindowSide.SOUTH);
        window.addButton(alphaSort, WindowSide.NORTH);
        window.addButton(quitButton, WindowSide.NORTH);
        window.addButton(cfrSort, WindowSide.NORTH);

        stateVA.onClick(this, "clickedVA");
        stateGA.onClick(this, "clickedGA");
        stateDC.onClick(this, "clickedDC");
        stateMD.onClick(this, "clickedMD");
        stateTN.onClick(this, "clickedTN");
        stateNC.onClick(this, "clickedNC");
        alphaSort.onClick(this, "clickedAlpha");
        quitButton.onClick(this, "clickedQuit");
        cfrSort.onClick(this, "clickedCFR");
    }


    /** 
    * 
    * 
    *
    */
    public void renderGUI() {

    }


    /** 
     *
     *
     *
     */
    public void sortByAlphaClicked(Button alphaButton) {

    }


    /**
     *
     *
     *
     *
     */
    public void sortByCFRClicked(Button alphaButton) {

    }


    /** 
     *
     *
     *
     */
    public void representStateClicked(Button stateClicked) {

    }


    /**
     *
     *
     *
     */
    public void quitClicked(Button quitButton) {

    }


    /** 
     *
     *
     *
     */
    private int calculateBarHeight() {

    }

}
