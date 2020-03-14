package ru.goryachev.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectController {

    @FXML
    private Button pickHedgehog;

    @FXML
    private Button pickCat;

    private SceneSwitcher switcher = new SceneSwitcher();


    @FXML
    private void startHedgehog (ActionEvent event) throws IOException {
        System.out.println("button Hedgehog");

        switcher.sceneSwitch(pickHedgehog);


    }

    @FXML
    private void startCat (ActionEvent event) throws IOException {
        System.out.println("button cat");

        switcher.sceneSwitch(pickCat);
    }

}
