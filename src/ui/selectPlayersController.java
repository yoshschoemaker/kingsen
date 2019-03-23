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

public class selectPlayersController implements Initializable {

    /**
     * When this method is called, it will change the Scene to
     * the settings menu
     */
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
}
