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
    private Window window;
    private Button sortByAlpha;
    private Button sortByCFR;
    private Button representDC;
    private Button representGA;
    private Button representMD;
    private Button representNC;
    private Button representTN;
    private Button representVA;
    private Button quit;
    private State[] state;
    private TextShape title;
    private Shape whiteBar;
    private Shape asianBar;
    private Shape blackBar;
    private Shape latinxBar;
    private Shape otherBar;
    private int whiteCFR;
    private int asianCFR;
    private int blackCFR;
    private int latinxCFR;
    private int otherCFR;
    private double whiteCFRPercent;
    private double asianCFRPercent;
    private double blackCFRPercent;
    private double latinxCFRPercent;
    private double asianCFRPercent;
    private double otherCFRPercent;
    private static final int XSTARTING = 70;
    private static final int XGAP = 130;
    private final int BAR_WIDTH = 10; 
}
