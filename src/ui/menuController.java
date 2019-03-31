package ui;

import Kingsen.Command.ResetGameCommand;
import Kingsen.Controller;
import Kingsen.Game.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class menuController extends Controller {

    @FXML
    private Text kingsLeftToFind;

    @FXML
    private VBox playerRankingContainer;

    @FXML
    private Button givePenaltyBtn;

    @Override
    public void afterInitialization() {
        kingsLeftToFind.setText(Integer.toString(game.getKingsLeft()));

        if (!game.getPlayerRanklist().isEmpty()) {
            int i = 1;
            for (Player player : game.getPlayerRanklist()) {
                Text text = new Text();
                text.setFill(Paint.valueOf("WHITE"));
                text.setTextAlignment(TextAlignment.CENTER);
                text.setText(String.format("%1$s. %2$s %3$spts", Integer.toString(i), player.getName(), player.getScore()));
                playerRankingContainer.getChildren().add(text);
                i++;
            }
        } else {
            Text text = new Text();
            text.setFill(Paint.valueOf("WHITE"));
            text.setTextAlignment(TextAlignment.CENTER);
            text.setText("There are no results yet.");
            playerRankingContainer.getChildren().add(text);
        }

        // Hide Give Penalty Button when player comes from the Card scene
        if (getPreviousSceneName().equals("card") || getPreviousSceneName().equals("givePenalty")) {
            givePenaltyBtn.setVisible(false);
        }
    }

    public void givePenaltyClicked() {
        switchScene("givePenalty");
    }

    public void closeMenuClicked() {
        switchToPreviousScene();
    }

    public void quitGameClicked() {
        game.executeCommand(new ResetGameCommand(game));
        switchScene("start");
    }
}
