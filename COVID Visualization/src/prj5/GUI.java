/**
 * 
 */
package prj5;

import CS2GraphWindowLib;
import java.text.DecimalFormat;

/**
 * @author kianp
 * @author aniketc2002
 * @version 12/3/2021
 */
public class GUI {
    private Shape barData;
    private TextShape displayCFR;
    private TextShape displayEthnicity;
    private TextShape displayTitle;
    private Window window;private static final BAR_WIDTH=10;private static final BAR_GAP=5;
    private Button alphaSort;
    private Button cfrSort;
    private Button stateVA;
    private Button stateGA;
    private Button stateDC;
    private Button statetMD;
    private Button stateTN;
    private Button stareNC;
    private Button quitButton;

/**
 * 
 *
 */
 public GUI(DataController String) 
 { 
     window = new Window();
     window.setTitle("Graph of COVID Cases and Deaths");    
     alphaSort = new Button("Sort by Alpha");
     cfrSort = new Buton("Sort by CFR");
     quit = new Buton("Quit");
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
     window.addButton(quit, WindowSide.NORTH);
     window.addButton(cfrSort, WindowSide.NORTH);
     
     stateVA.onClick(this, "clickedVA");
     stateGA.onClick(this, "clickedGA");
     stateDC.onClick(this, "clickedDC");
     stateMD.onClick(this, "clickedMD");
     stateTN.onClick(this, "clickedTN");
     stateNC.onClick(this, "clickedNC");
 }
