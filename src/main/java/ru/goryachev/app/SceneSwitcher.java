package ru.goryachev.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {

    public void sceneSwitch (Button pickHedgehog, Button pickCat, Button feedWApple, Button feedWSausage, Button res) {

        pickHedgehog.setVisible(false);
        pickCat.setVisible(false);
        feedWApple.setVisible(true);
        feedWSausage.setVisible(true);
        //res.setVisible(true);

    }

    public void sceneReset (Button resetClose) throws IOException {

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
