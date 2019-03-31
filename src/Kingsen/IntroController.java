package Kingsen;

import Kingsen.Game.Game;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * @deprecated This was a test class and is no longer in use. It should be ignored!
 */
@Deprecated
public class IntroController extends Controller {

    @FXML
    private Button startBtn;

    @FXML
    private void startGameButtonClicked() {
        switchScene("Main-pre-game-no-styling");
    }
}
