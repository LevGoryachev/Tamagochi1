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

//will use for switching to the last scene (if animal die)
//    private SceneSwitcher switcher = new SceneSwitcher();
//    private AnimalSwitcher choosen = new AnimalSwitcher();

    @FXML
    private Pane sp;

    @FXML
    private void startHedgehog (ActionEvent event) throws IOException {
        System.out.println("button Hedgehog");

        Image image = new Image(getClass().getResourceAsStream("/sprites_hedgehog.png"));
        ImageView imagView = new ImageView(image);
        Animal animal = new Animal(imagView);

        sp.getChildren().add(animal);

        //will use for switching to the last scene (if animal die)
        //switcher.sceneSwitch(pickHedgehog);
        //choosen.pickAnimal(1);

    }



    @FXML
    private void startCat (ActionEvent event) throws IOException {
        System.out.println("button cat");

        Image image = new Image(getClass().getResourceAsStream("/sprites_cat.png"));
        ImageView imagView = new ImageView(image);
        Animal animal = new Animal(imagView);

        sp.getChildren().add(animal);

        //will use for switching to the last scene (if animal die)
        //switcher.sceneSwitch(pickCat);
        //choosen.pickAnimal(2);


    }

}
