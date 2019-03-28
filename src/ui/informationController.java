package ui;

import Kingsen.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class informationController extends Controller {

    /**
     * When this method is called, it will change the Scene to
     * the settings menu
     */
    public void backButtonPushed(MouseEvent event) throws IOException
    {
        switchScene("start");
    }
}
