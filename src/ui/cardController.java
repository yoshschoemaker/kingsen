package ui;

import Kingsen.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class cardController extends Controller {

    /**
     * Will be called when the 'continue' button is clicked
     * will either refer to 'select loser' screen or the 'game' screen.
     */
    public void continueClicked(MouseEvent event) throws IOException
    {
        // Handle the continue button clicked

        Parent startViewParent = FXMLLoader.load(getClass().getResource("givePenalty.fxml"));
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
