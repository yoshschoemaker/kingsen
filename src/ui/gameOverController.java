package ui;

import Kingsen.Command.ResetGameCommand;
import Kingsen.Controller;
import Kingsen.Game.Player;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class gameOverController extends Controller {

    @FXML
    private VBox playerRankingContainer;

    @Override
    public void afterInitialization() {
        if (!game.getPlayerRanklist().isEmpty()) {
            int i = 1;
            for (Player player : game.getPlayerRanklist()) {
                Text text = new Text();
                text.setFill(Paint.valueOf("WHITE"));
                text.setTextAlignment(TextAlignment.CENTER);
                text.setStyle("-fx-font: 16 'Open Sans';");
                text.setText(String.format("%1$s. %2$s %3$spts", Integer.toString(i), player.getName(), player.getScore()));
                playerRankingContainer.getChildren().add(text);
                i++;
            }
        } else {
            Text text = new Text();
            text.setFill(Paint.valueOf("WHITE"));
            text.setTextAlignment(TextAlignment.CENTER);
            text.setText("Seems like everyone is a winner?");
            text.setStyle("-fx-font: 16 'Open Sans';");
            playerRankingContainer.getChildren().add(text);
        }
    }

    /**
     * Will be called when the 'continue' button is clicked,
     * will change to the start screen.
     */
    public void continueClicked(MouseEvent event) {
        game.executeCommand(new ResetGameCommand(game));
        previousFxmls.clear();
        switchScene("start");
    }
}
