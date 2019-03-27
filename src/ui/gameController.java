package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class gameController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
