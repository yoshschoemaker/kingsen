package ui;

import Kingsen.Controller;
import Kingsen.Helpers.ConsoleColors;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class startController extends Controller {

    /**
     * When this method is called, it will change the Scene to
     * the settings menu
     */
    public void settingsButtonPushed(MouseEvent event) throws IOException
    {
        switchScene("settings-responsive");
    }

    /**
     * When this method is called, it will change the Scene to
     * the settings menu
     */
    public void informationButtonPushed(MouseEvent event) throws IOException
    {
        switchScene("information");
    }

    /**
     * When this method is called, it will change the Scene to
     * the player select screen
     */
    public void startButtonPushed(MouseEvent event) throws IOException
    {
        System.out.println(ConsoleColors.YELLOW + "Switching to Player Select screen." + ConsoleColors.RESET);
        switchScene("selectPlayers");
    }
}
