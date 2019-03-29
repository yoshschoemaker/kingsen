package ui;

import Kingsen.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class givePenaltyController extends Controller {

    @FXML
    private Text kingsLeftToFind;

    @FXML
    private VBox playerContainer;

    @Override
    public void afterInitialization() {
        kingsLeftToFind.setText(Integer.toString(game.getKingsLeft()));
    }

    /**
     * Will be called when the 'continue' button is clicked
     * will either refer to 'select loser' screen or the 'game' screen.
     */
    public void continueClicked(MouseEvent event) {
        switchScene("game");
    }

    public void openMenuClicked(MouseEvent event) {
        switchScene("menu");
    }
}
