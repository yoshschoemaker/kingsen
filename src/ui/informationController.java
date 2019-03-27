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

public class informationController implements Initializable {

    /**
     * When this method is called, it will change the Scene to
     * the settings menu
     */
    public void backButtonPushed(MouseEvent event) throws IOException
    {
        Parent startViewParent = FXMLLoader.load(getClass().getResource("start.fxml"));
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
