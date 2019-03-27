package ui;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class givePenaltyController implements Initializable {


    /**
     * Will be called when the 'continue' button is clicked
     * will either refer to 'select loser' screen or the 'game' screen.
     */
    public void continueClicked(MouseEvent event) throws IOException
    {
        // Handle the continue button clicked

        Parent startViewParent = FXMLLoader.load(getClass().getResource("game.fxml"));
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
