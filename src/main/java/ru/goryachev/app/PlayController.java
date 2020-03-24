package ru.goryachev.app;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.util.Duration;


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

    int animalNumber;
    int mood;
    Image img;
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
        this.img = image;
        this.imagV = imagView;

        this.animalNumber = 1;

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
        this.img = image;
        this.imagV = imagView;

        this.animalNumber = 2;

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
    private void apple (ActionEvent event) throws IOException, InterruptedException {

        Image image = new Image(getClass().getResourceAsStream("/meal_apple.png"));
        ImageView imagView = new ImageView(image);
        imagView.setFitHeight(75);
        imagView.setFitWidth(75);

        paneNodeApple.getChildren().add(imagView);

        choice.pickAnimal(3);

        if (animalNumber == 1) {
            paneNodeAnim.getChildren().clear();

            Animal animal = new Animal(imagV, mood);

            GameAnim gameAnim = new GameAnim();

            //Parameters: animal which to move, for what meal to, X of animal, Y of animal, X of meal, Y of meal
            gameAnim.moveToMeal(animal, paneNodeApple, paneNodeAnim.getLayoutX(), paneNodeAnim.getLayoutY(), paneNodeApple.getLayoutX(), paneNodeApple.getLayoutY());

            paneNodeAnim.getChildren().add(animal);

            Thread.sleep(3000);
            paneNodeApple.getChildren().clear();
            this.increaseMood();
            //paneNodeApple.getChildren().clear();

            //Doesn't work
            /*if (animal.getBoundsInParent().intersects(paneNodeApple.getBoundsInParent())) {
                paneNodeApple.getChildren().clear();
            }*/
        }


    }

    @FXML
    private void sausage (ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/meal_sausage.png"));
        ImageView imagView = new ImageView(image);
        imagView.setFitHeight(125);
        imagView.setFitWidth(125);

        paneNodeSausage.getChildren().add(imagView);

        choice.pickAnimal(4);

        if (animalNumber == 2) {
            paneNodeAnim.getChildren().clear();
            this.increaseMood();
            Animal animal = new Animal(imagV, mood);
            paneNodeAnim.getChildren().add(animal);
        }
    }

    @FXML
    private void playWith (ActionEvent event) throws IOException {
        System.out.println("Play btn");

        paneNodeAnim.getChildren().clear();

        if (this.mood >= 440) {
            ImageView imgDead = new ImageView(img);
            imgDead.setViewport(new Rectangle2D(660, 0, 200, 200));
            paneNodeAnim.getChildren().add(imgDead);
        }

        else {
            this.decreaseMood();
            Animal animal = new Animal(imagV, mood);
            paneNodeAnim.getChildren().add(animal);
        }

    }

    public void increaseMood () {

        if (this.mood >= 220) {
            this.mood = mood - 220;
        }
    }

    public void decreaseMood () {

        if (this.mood <= 220) {
            this.mood = mood + 220;
        }
    }





}
