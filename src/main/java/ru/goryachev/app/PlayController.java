package ru.goryachev.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.IOException;

public class PlayController {

    @FXML
    private Button pickHedgehog;

    @FXML
    private Button pickCat;

    @FXML
    private Button feedWApple;

    @FXML
    private Button feedWSausage;

    @FXML
    private Button playWithAnim;


//  will use for switching to the last scene (if animal die)
    private SceneSwitcher switcher = new SceneSwitcher();

    private AnimalSwitcher choice = new AnimalSwitcher();

    @FXML
    private Pane paneNode;

    @FXML
    private void startHedgehog (ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/sprites_hedgehog.png"));
        ImageView imagView = new ImageView(image);
        Animal animal = new Animal(imagView);

        paneNode.getChildren().add(animal);

        //will use for switching to the last scene (if animal die)
        //switcher.sceneSwitch(pickHedgehog);

        choice.pickAnimal(1);

        pickHedgehog.setVisible(false);
        pickCat.setVisible(false);
        feedWApple.setVisible(true);
        feedWSausage.setVisible(true);
        playWithAnim.setVisible(true);

    }

    @FXML
    private void startCat (ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/sprites_cat.png"));
        ImageView imagView = new ImageView(image);
        Animal animal = new Animal(imagView);

        paneNode.getChildren().add(animal);

        //will use for switching to the last scene (if animal die)
        //switcher.sceneSwitch(pickCat);

        choice.pickAnimal(2);

        pickHedgehog.setVisible(false);
        pickCat.setVisible(false);
        feedWApple.setVisible(true);
        feedWSausage.setVisible(true);
        playWithAnim.setVisible(true);

    }

    @FXML
    private void apple (ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/meal_apple.png"));
        ImageView imagView = new ImageView(image);

        paneNode.getChildren().add(imagView);

    }

    @FXML
    private void sausage (ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/meal_sausage.png"));
        ImageView imagView = new ImageView(image);

        paneNode.getChildren().add(imagView);

    }

    @FXML
    private void playWith (ActionEvent event) throws IOException {


    }


}
