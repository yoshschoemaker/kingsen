package ui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.event.EventHandler;

public class selectPlayersController implements Initializable {

    @FXML
    TextField playerNameInput;

    @FXML
    VBox uiPlayerList;

    public void continueButtonPushed(MouseEvent event) throws IOException
    {
        Parent gameViewParent = FXMLLoader.load(getClass().getResource("game.fxml"));
        Scene gameViewScene = new Scene(gameViewParent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(gameViewScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void addPlayer(MouseEvent event) throws IOException{
        String playerName = playerNameInput.getText();
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
                var eventSrc  = event.getSource();
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
    }

}
