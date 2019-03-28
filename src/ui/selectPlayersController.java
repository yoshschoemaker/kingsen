package ui;

import Kingsen.Command.AddPlayerCommand;
import Kingsen.Controller;
import Kingsen.Game.Player;
import Kingsen.Helpers.ConsoleColors;
import Kingsen.Observe.PlayerRanklistObserver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class selectPlayersController extends Controller {

    @FXML
    TextField playerNameInput;

    @FXML
    VBox uiPlayerList;

    public void continueButtonPushed(MouseEvent event) throws IOException {
        // There are no players in the list
        if (uiPlayerList.getChildren().isEmpty()) {
            System.out.println(ConsoleColors.RED + "Add some players first!" + ConsoleColors.RESET);
        }
        // There are less than 2 players in the list
        else if (uiPlayerList.getChildren().size() < 2) {
            System.out.println(ConsoleColors.RED + "Add at least two players!" + ConsoleColors.RESET);
        }
        // YEAH!! Enough players to start the game.
        else {
            System.out.println("--- ADDING PLAYERS TO THE GAME ---");
            for (Node node : uiPlayerList.getChildren()) {
                if (node instanceof HBox) {
                    HBox hBox = (HBox) node;
                    Button playerNameButton = (Button) hBox.getChildren().get(0);
                    Player player = new Player(playerNameButton.getText());
                    new PlayerRanklistObserver(game, player);
                    game.executeCommand(new AddPlayerCommand(game, player));
                }
            }
            game.getPlayerNames();
            System.out.println("--- PLAYERS ADDED ---");
            System.out.println(ConsoleColors.YELLOW + "Switching to Game screen." + ConsoleColors.RESET);
            switchScene("game");
        }
    }

    public void addPlayer(MouseEvent event) throws IOException {
        String playerName = playerNameInput.getText();

        // Only add player when there is a name
        if (!playerNameInput.getText().trim().isEmpty()) {
            playerNameInput.clear();

            // Create the buttons
            Button playerNameButton = new Button(playerName);
            Button playerRemoveButton = new Button();

            // Load remove image
            Image image = new Image(getClass().getResourceAsStream("assets/images/minus-icon.png"));

            // Create remove button image view
            ImageView iv = new ImageView();
            iv.setImage(image);
            iv.setFitWidth(20.0);
            iv.setFitHeight(20.0);
            iv.setPreserveRatio(true);

            // Style and position buttons
            playerRemoveButton.setGraphic(iv);
            playerRemoveButton.getStyleClass().add("playerRemoveBtn");
            playerNameButton.getStyleClass().add("playerBlock");

            // Add remove button event listener.
            playerRemoveButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    var eventSrc = event.getSource();
                    Button button = (Button) eventSrc;

                    // Get the value of the 'button'. Can be used to remove the player
                    List children = ((HBox) button.getParent()).getChildren();
                    Button textButton = ((Button) children.get(0));
                    String buttonText = textButton.getText();

                    // You can use buttonText to delete the value from the players array (which is left to implement).
                    //System.out.print(buttonText);

                    HBox row = (HBox) button.getParent();
                    ((VBox) row.getParent()).getChildren().remove(row);
                }
            });

            // Add buttons to the HBox (one row)
            HBox hbox = new HBox(playerNameButton, playerRemoveButton);
            hbox.setMargin(playerNameButton, new Insets(0, 8, 0, 0));
            hbox.setPadding(new Insets(4, 0, 4, 0));
            hbox.setAlignment(Pos.TOP_CENTER);

            // Add the row in the UI.
            uiPlayerList.getChildren().add(hbox);
        } else {
            System.out.println(ConsoleColors.RED + "Cannot add player with empty name!" + ConsoleColors.RESET);
        }
    }

}
