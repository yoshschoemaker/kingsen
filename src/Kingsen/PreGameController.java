package Kingsen;

import Kingsen.Command.AddPlayerCommand;
import Kingsen.Command.ClearPlayersCommand;
import Kingsen.Game.Player;
import Kingsen.Helpers.ConsoleColors;
import Kingsen.Observe.PlayerRanklistObserver;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PreGameController extends Controller {

    @FXML
    private VBox addPlayersVBox;

    @FXML
    private ScrollPane playerScrollPane;

    @FXML
    private VBox playerListVBox;

    @FXML
    private void quitButton() {
        switchScene("Main-no-styling");
    }

    @FXML
    private void addPlayer(Event event) {
        // THIS FUNCTION IS FOR TESTING

        Button btn = (Button) event.getSource();
        HBox hbox = (HBox) btn.getParent();
        VBox container = (VBox) hbox.getParent();

        btn.setText("-");
        btn.setOnAction(this::removePlayer);

        HBox newHbox = new HBox(10);
        newHbox.setPrefWidth(231);
        newHbox.setPrefHeight(35);
        newHbox.setAlignment(Pos.TOP_CENTER);

        TextField newTextField = new TextField();
        newTextField.setPrefWidth(183);
        newTextField.setPrefHeight(25);

        Button newBtn = new Button("+");
        newBtn.setOnAction(this::addPlayer);
        newBtn.setPrefWidth(25);

        newHbox.getChildren().add(newTextField);
        newHbox.getChildren().add(newBtn);

        container.getChildren().add(newHbox);
        playerScrollPane.vvalueProperty().bind(container.heightProperty());
    }

    @FXML
    private void removePlayer(Event event) {
        Button btn = (Button) event.getSource();
        HBox hbox = (HBox) btn.getParent();
        VBox container = (VBox) hbox.getParent();

        // remove the hbox
        container.getChildren().remove(hbox);
    }

    @FXML
    private void startFullGame() {
        boolean noEmptyFields = true;

        System.out.println("--- ADDING PLAYERS TO THE GAME ---");
        for (Node node : playerListVBox.getChildren()) {
            if (node instanceof HBox) {
                HBox hBox = (HBox) node;
                TextField playerNameTextField = (TextField) hBox.getChildren().get(0);

                if (playerNameTextField.getText().trim().isEmpty()) {
                    noEmptyFields = false;
                    System.out.println(ConsoleColors.RED + "Error: empty player name text field(s)! ---" + ConsoleColors.RESET);
                    game.executeCommand(new ClearPlayersCommand(game));
                    break;
                }

                Player player = new Player(playerNameTextField.getText());
                new PlayerRanklistObserver(game, player);
                game.executeCommand(new AddPlayerCommand(game, player));
            }
        }

        if (noEmptyFields) {
            game.getPlayerNames();
            System.out.println("--- PLAYERS ADDED ---");
            switchScene("Main-game-no-styling");
        }
    }
}
