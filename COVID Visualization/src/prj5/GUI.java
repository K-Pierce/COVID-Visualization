/**
 * 
 */
package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
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

        renderGUI();
    }


    /** 
    * 
    * 
    *
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
     *
     *
     *
     */
    public void clickedAlpha(Button alphaButton) {

        currState.sortAlpha();
        renderGUI();
    }


    /**
     *
     *
     *
     *
     */
    public void clickedCFR(Button alphaButton) {

        currState.sortByCFR();
        renderGUI();
    }


    /** 
     *
     *
     *
     */
    public void clickedDC(Button stateClicked) {

        currState = states.get(0);
        System.out.println(currState.getName());
        renderGUI();
    }


    /** 
    *
    *
    *
    */
    public void clickedGA(Button stateClicked) {

        currState = states.get(1);
        System.out.println(currState.getName());
        renderGUI();
    }


    /** 
    *
    *
    *
    */
    public void clickedMD(Button stateClicked) {

        currState = states.get(2);
        System.out.println(currState.getName());
        renderGUI();
    }


    /** 
    *
    *
    *
    */
    public void clickedNC(Button stateClicked) {

        currState = states.get(3);
        System.out.println(currState.getName());
        renderGUI();
    }


    /** 
    *
    *
    *
    */
    public void clickedTN(Button stateClicked) {

        currState = states.get(4);
        System.out.println(currState.getName());
        renderGUI();
    }


    /** 
    *
    *
    *
    */
    public void clickedVA(Button stateClicked) {

        currState = states.get(5);
        System.out.println(currState.getName());
        renderGUI();
    }


    /**
     *
     *
     *
     */
    public void clickedQuit(Button quitButton) {

        System.exit(0);
    }

}
