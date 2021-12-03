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
    private final int BAR_GAP = 0;
    private final int BAR_HEIGHT = 6;
    
    /**
     * Takes care of making a thread.
     * Pasuses between disk movement.
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    } // end sleep

    /**
     * Calls the puzzle's solve method.
     * Supports the the solve method. 
     * 
     * @param button The button to solve the game. 
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }  
}
