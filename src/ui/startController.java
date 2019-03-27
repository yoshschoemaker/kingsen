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

public class startController implements Initializable {

    /**
     * When this method is called, it will change the Scene to
     * the settings menu
     */
    public void settingsButtonPushed(MouseEvent event) throws IOException
    {
        Parent settingsViewParent = FXMLLoader.load(getClass().getResource("settings.fxml"));
        Scene settingsViewScene = new Scene(settingsViewParent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(settingsViewScene);
        window.show();
    }

    /**
     * When this method is called, it will change the Scene to
     * the settings menu
     */
    public void informationButtonPushed(MouseEvent event) throws IOException
    {
        Parent informationViewParent = FXMLLoader.load(getClass().getResource("information.fxml"));
        Scene informationViewScene = new Scene(informationViewParent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(informationViewScene);
        window.show();
    }

    /**
     * When this method is called, it will change the Scene to
     * the player select screen
     */
    public void startButtonPushed(MouseEvent event) throws IOException
    {
        Parent selectPlayersViewParent = FXMLLoader.load(getClass().getResource("selectPlayers.fxml"));
        Scene selectPlayersViewScene = new Scene(selectPlayersViewParent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(selectPlayersViewScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
