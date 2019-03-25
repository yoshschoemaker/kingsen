package Kingsen;

import Kingsen.Game.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;


public class IntroController {

    private Game game;

    @FXML
    private Button startBtn;

    @FXML
    private void startGameButtonClicked() {
        System.out.print("Start game button clicked");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main-game-no-styling.fxml"));
            GameController gameController = loader.getController();
            Stage stage = (Stage) startBtn.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
