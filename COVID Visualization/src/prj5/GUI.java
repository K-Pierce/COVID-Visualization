// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kian Pierce (kianp20)
package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * @author kianp
 * @version 12/3/2021
 */
public class GUI {

    private Window window;
    private static int BAR_WIDTH = 10;
    private static int BAR_GAP = 100;
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
    private SinglyLinkedList<State> states;

    /**
     * This constructor initializes a new window of display that
     * implements the information given to the graph
     *
     * @param statesData
     *            - a singly linked list of all states
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

        renderGUI();
    }


    /**
     * Wipes the window clean and re-populates all shapes in updated locations
     */
    public void renderGUI() {

        window.removeAllShapes();

        TextShape stateName = new TextShape(0, 25, currState.getName()
            + " Case Fatality Ratios by Race");
        stateName.setX((window.getWidth() - stateName.getWidth()) / 2);

        window.addShape(stateName);

        String[] races = currState.getRaces();
        double[] CFR = currState.getCFRData();

        for (int i = 0; i < 5; i++) {

            TextShape race = new TextShape(100 * i + BAR_GAP, window
                .getGraphPanelHeight() - 50, races[i]);

            window.addShape(race);

            int height = (int)CFR[i] * 25 + 20;
            if ((int)CFR[i] != -1) {

                TextShape cfr = new TextShape(100 * i + BAR_GAP, window
                    .getGraphPanelHeight() - 25, String.valueOf(CFR[i]) + "%");

                Shape bar = new Shape(i * 100 + BAR_GAP + 12, 250 - height,
                    BAR_WIDTH, height, Color.BLUE);

                window.addShape(bar);
                window.addShape(cfr);

            }
            else {

                TextShape NA = new TextShape(100 * i + BAR_GAP + 12, window
                    .getGraphPanelHeight() - 25, "NA", Color.BLACK);

                Shape bar = new Shape(i * 100 + BAR_GAP + 12, 250 - 15,
                    BAR_WIDTH, 15, Color.BLUE);

                window.addShape(bar);
                window.addShape(NA);
            }
        }
    }


    /**
     * When "Sort by Alpha" is clicked, sort the races in the state
     * alphabetically
     * 
     * @param alphaButton
     *            - button pressed to sort alphabetically
     */
    public void clickedAlpha(Button clickedAlpha) {

        currState.sortAlpha();
        renderGUI();
    }


    /**
     * When "Sort by CFR" is clicked, sort the races in the state by descending
     * CFR
     * 
     * @param cfrButton
     *            - button pressed to sort by CFR
     */
    public void clickedCFR(Button clickedCFR) {

        currState.sortByCFR();
        renderGUI();
    }


    /**
     * Sets DC as the current state
     * 
     * @param stateDC
     *            - the button clicked
     */
    public void clickedDC(Button stateDC) {

        currState = states.get(0);
        renderGUI();
    }


    /**
     * Sets GA as the current state
     * 
     * @param stateGA
     *            - the button clicked
     */
    public void clickedGA(Button stateGA) {

        currState = states.get(1);
        renderGUI();
    }


    /**
     * Sets MD as the current state
     * 
     * @param stateMD
     *            - the button clicked
     */
    public void clickedMD(Button stateMD) {

        currState = states.get(2);
        renderGUI();
    }


    /**
     * Sets NC as the current state
     * 
     * @param stateNC
     *            - the button clicked
     */
    public void clickedNC(Button stateNC) {

        currState = states.get(3);
        renderGUI();
    }


    /**
     * Sets TN as the current state
     * 
     * @param stateTN
     *            - the button clicked
     */
    public void clickedTN(Button stateTN) {

        currState = states.get(4);
        renderGUI();
    }


    /**
     * Sets VA as the current state
     * 
     * @param stateVA
     *            - the button clicked
     */
    public void clickedVA(Button stateVA) {

        currState = states.get(5);
        renderGUI();
    }


    /**
     * Exits the program
     * 
     * @param clickedQuit
     *            - the button clicked
     */
    public void clickedQuit(Button clickedQuit) {

        System.exit(0);
    }

}
