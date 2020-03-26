package ru.goryachev.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {

    public void sceneSwitch (Button resetClose) throws IOException {

        //close old window
        Stage primaryStage = (Stage) resetClose.getScene().getWindow();
        primaryStage.close();

        //open new window
        Parent root = FXMLLoader.load(getClass().getResource("/playing.fxml"));
        primaryStage.setTitle("Tamagochi");
        primaryStage.setScene(new Scene(root, 800, 475));
        primaryStage.show();
    }
}
