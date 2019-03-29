package ui;

import Kingsen.Command.SelectLoserCommand;
import Kingsen.Controller;
import Kingsen.Game.Player;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class givePenaltyController extends Controller {

    @FXML
    private Text kingsLeftToFind;

    @FXML
    private VBox playerContainer;

    @Override
    public void afterInitialization() {
        kingsLeftToFind.setText(Integer.toString(game.getKingsLeft()));

        for (Player player : game.getPlayers()) {
            try {
                Button btn = FXMLLoader.load(getClass().getResource("DataTemplates/givePenaltyPlayerButton.fxml"));
                btn.setText(player.getName());
                btn.setUserData(player);
                btn.setOnAction(this::givePenaltyToPlayer);
                playerContainer.getChildren().add(btn);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Will be called when the 'continue' button is clicked
     * will either refer to 'select loser' screen or the 'game' screen.
     */
    public void continueClicked(MouseEvent event) {
        switchScene("game");
    }

    public void givePenaltyToPlayer(Event event) {
        Button btn = (Button) event.getSource();
        game.executeCommand(new SelectLoserCommand(game, (Player) btn.getUserData()));
        switchScene("game");
    }

    public void openMenuClicked(MouseEvent event) {
        switchScene("menu");
    }
}
