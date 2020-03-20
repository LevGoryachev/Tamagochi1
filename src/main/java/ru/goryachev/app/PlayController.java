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

    @FXML
    private Pane paneNodeAnim;

    @FXML
    private Pane paneNodeApple;

    @FXML
    private Pane paneNodeSausage;

    int mood;
    ImageView imagV;

    //  will use for switching to the last scene (if animal die)
    private SceneSwitcher switcher = new SceneSwitcher();

    private AnimalSwitcher choice = new AnimalSwitcher();

    //animals

    @FXML
    private void startHedgehog (ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/sprites_hedgehog.png"));
        ImageView imagView = new ImageView(image);
        Animal animal = new Animal(imagView, mood);

        paneNodeAnim.getChildren().add(animal);
        this.setAnimal(imagView);

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
        Animal animal = new Animal(imagView, mood);

        paneNodeAnim.getChildren().add(animal);
        this.setAnimal(imagView);

        //will use for switching to the last scene (if animal die)
        //switcher.sceneSwitch(pickCat);

        choice.pickAnimal(2);

        pickHedgehog.setVisible(false);
        pickCat.setVisible(false);
        feedWApple.setVisible(true);
        feedWSausage.setVisible(true);
        playWithAnim.setVisible(true);

    }

    //meal

    @FXML
    private void apple (ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/meal_apple.png"));
        ImageView imagView = new ImageView(image);
        imagView.setFitHeight(75);
        imagView.setFitWidth(75);

        paneNodeApple.getChildren().add(imagView);


        choice.pickAnimal(3);



    }

    @FXML
    private void sausage (ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/meal_sausage.png"));
        ImageView imagView = new ImageView(image);
        imagView.setFitHeight(125);
        imagView.setFitWidth(125);

        paneNodeSausage.getChildren().add(imagView);

        choice.pickAnimal(4);

        paneNodeAnim.getChildren().clear();
        this.increaseMood();
        Animal animal = new Animal(imagV, mood);
        paneNodeAnim.getChildren().add(animal);


    }

    @FXML
    private void playWith (ActionEvent event) throws IOException {
        System.out.println("Play btn");

        //paneNodeApple.getChildren().remove(pickCat);
        //paneNodeApple.setVisible(false);
        //paneNodeApple.getChildren().clear();

        paneNodeAnim.getChildren().clear();
        this.decreaseMood();
        Animal animal = new Animal(imagV, mood);
        paneNodeAnim.getChildren().add(animal);


    }

    public void setAnimal (ImageView imagV){
        this.imagV = imagV;
    }

    public void increaseMood () {

        if (this.mood >= 220) {
            this.mood = mood - 220;
        } this.mood = mood;
    }

    public void decreaseMood () {

        if (this.mood <= 220) {
            this.mood = mood + 220;
        } this.mood = mood;
    }





}
