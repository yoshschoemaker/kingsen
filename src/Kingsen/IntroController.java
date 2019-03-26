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


public class IntroController extends Controller {

    @FXML
    private Button startBtn;

    @FXML
    private void startGameButtonClicked() {
        System.out.print("Start game button clicked");
        game.start();

        switchScene("Main-game-no-styling");
    }
}
