package ru.goryachev.app;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.io.Serializable;

public class SceneSwitcher implements Serializable {

    public void sceneSwitch (VBox mSceneBGround) {

        BackgroundImage mainBGround= new BackgroundImage(new Image("/BackGround.jpg",800,425,true,false),
                BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        mSceneBGround.setBackground(new Background(mainBGround));

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
