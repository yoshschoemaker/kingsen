package ui;

import Kingsen.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class gameController extends Controller {

    /**
     * Will be called on a card click,
     * should open the card.
     */
    public void cardClicked(MouseEvent event) throws IOException
    {
        // Handle card clicked

        Parent startViewParent = FXMLLoader.load(getClass().getResource("card.fxml"));
        Scene startViewScene = new Scene(startViewParent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(startViewScene);
        window.show();
    }

    public void openMenuClicked(MouseEvent event) throws IOException
    {
        // Handle card clicked

        Parent startViewParent = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene startViewScene = new Scene(startViewParent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(startViewScene);
        window.show();
    }
}
