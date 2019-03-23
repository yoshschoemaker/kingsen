package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        changeScene("start.fxml");
        this.primaryStage.show();
    }

    public void changeScene(String fxml) throws Exception{
        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));
        Scene scene = new Scene(pane);
        this.primaryStage.setScene(scene);
    }

    public void settingsClicked() throws Exception{
        System.out.print(this.primaryStage);
        changeScene("settings.fxml");
    }
}