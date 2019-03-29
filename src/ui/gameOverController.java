package ui;

import Kingsen.Controller;
import javafx.scene.input.MouseEvent;

public class gameOverController extends Controller {

    /**
     * Will be called when the 'continue' button is clicked,
     * will change to the start screen.
     */
    public void continueClicked(MouseEvent event) {
        switchScene("start");
    }
}
