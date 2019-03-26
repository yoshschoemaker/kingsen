package Kingsen;

import Kingsen.Command.AddPlayerCommand;
import Kingsen.Game.Game;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameController extends Controller {

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
        addPlayersVBox.setVisible(false);

        /*for (Node node : playerListVBox.getChildren()) {
            if (node instanceof HBox) {
                HBox hBox = (HBox) node;
                for (Node hBoxNode : hBox.getChildren()) {
                    if (hBoxNode instanceof TextField) {
                        TextField playerTextField = (TextField) node;
                        System.out.println(playerTextField.getText());
                    }
                }
            }

        }*/
    }
}
