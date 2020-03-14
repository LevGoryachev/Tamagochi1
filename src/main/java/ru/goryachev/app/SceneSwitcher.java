package ru.goryachev.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {

    public void sceneSwitch (Button pickAndClose) throws IOException {

        //close select window
        Stage primaryStage = (Stage) pickAndClose.getScene().getWindow();
        primaryStage.close();

        //open play window
        Parent root = FXMLLoader.load(getClass().getResource("/playing.fxml"));
        primaryStage.setTitle("Tamagochi");
        primaryStage.setScene(new Scene(root, 800, 475));
        primaryStage.show();
    }

}
