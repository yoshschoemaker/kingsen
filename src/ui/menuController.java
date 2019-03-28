package ui;

import Kingsen.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class menuController extends Controller {

    public void givePenaltyClicked(MouseEvent event) throws IOException
    {
        Parent startViewParent = FXMLLoader.load(getClass().getResource("givePenalty.fxml"));
        Scene startViewScene = new Scene(startViewParent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(startViewScene);
        window.show();
    }

    public void closeMenuClicked(MouseEvent event) throws IOException
    {
        Parent startViewParent = FXMLLoader.load(getClass().getResource("game.fxml"));
        Scene startViewScene = new Scene(startViewParent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(startViewScene);
        window.show();
    }
}
