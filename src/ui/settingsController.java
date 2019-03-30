package ui;

import Kingsen.Controller;
import javafx.scene.input.MouseEvent;

public class settingsController extends Controller {

    /**
     * When this method is called, it will change the Scene to
     * the settings menu
     */
    public void backButtonPushed(MouseEvent event)
    {
        switchScene("start");
    }
}
