package ru.goryachev.app;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
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
    private Button resetScene;


    @FXML
    private Pane paneNodeAnim;

    @FXML
    private Pane paneNodeApple;

    @FXML
    private Pane paneNodeSausage;

    int animalNumber;
    int mood;
    long timeEat;
    Image img;
    ImageView imagV;
    MoodReg moodAdjuster;

    private AnimalSwitcher choice = new AnimalSwitcher();

    private SceneSwitcher switcher = new SceneSwitcher();



    //animals

    @FXML
    private void startHedgehog(ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/sprites_hedgehog.png"));
        ImageView imagView = new ImageView(image);
        Animal animal = new Animal(imagView, mood);

        paneNodeAnim.getChildren().add(animal);
        this.img = image;
        this.imagV = imagView;

        this.animalNumber = 1;

        choice.pickAnimal(1);

        pickHedgehog.setVisible(false);
        pickCat.setVisible(false);
        feedWApple.setVisible(true);
        feedWSausage.setVisible(true);
        resetScene.setVisible(true);

        MoodReg timeReg = new MoodReg(paneNodeAnim, paneNodeApple, mood, img, imagV, resetScene);
        timeReg.decrTimeByTime();
        this.moodAdjuster =  timeReg;


    }

    @FXML
    private void startCat(ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/sprites_cat.png"));
        ImageView imagView = new ImageView(image);
        Animal animal = new Animal(imagView, mood);

        paneNodeAnim.getChildren().add(animal);
        this.img = image;
        this.imagV = imagView;

        this.animalNumber = 2;

        choice.pickAnimal(2);

        pickHedgehog.setVisible(false);
        pickCat.setVisible(false);
        feedWApple.setVisible(true);
        feedWSausage.setVisible(true);
        resetScene.setVisible(true);

        MoodReg timeReg = new MoodReg(paneNodeAnim, paneNodeSausage, mood, img, imagV, resetScene);
        timeReg.decrTimeByTime();
        this.moodAdjuster =  timeReg;

    }

    //meal

    @FXML
    private void apple(ActionEvent event) {

        Image image = new Image(getClass().getResourceAsStream("/meal_apple.png"));
        ImageView imagView = new ImageView(image);
        imagView.setFitHeight(75);
        imagView.setFitWidth(75);
        paneNodeApple.getChildren().clear();
        paneNodeApple.getChildren().add(imagView);
        if (timeEat <= System.currentTimeMillis()) {
            this.timeEat = System.currentTimeMillis() + 3000; //Set 5500 later

            if (animalNumber == 1) {
                this.moodAdjuster.increaser();
            }
        }
        MealAnim expiredMeal = new MealAnim();
        expiredMeal.fadeMeal(imagView);
    }

    @FXML
    private void sausage(ActionEvent event) {

        Image image = new Image(getClass().getResourceAsStream("/meal_sausage.png"));
        ImageView imagView = new ImageView(image);
        imagView.setFitHeight(125);
        imagView.setFitWidth(125);
        paneNodeSausage.getChildren().clear();
        paneNodeSausage.getChildren().add(imagView);
        if (timeEat <= System.currentTimeMillis()) {
            this.timeEat = System.currentTimeMillis() + 3000; //Set 5500 later

            if (animalNumber == 2) {
                this.moodAdjuster.increaser();
            }
        }
        MealAnim expiredMeal = new MealAnim();
        expiredMeal.fadeMeal(imagView);
    }


    // Buttons for checking
    @FXML
    private void playWith(ActionEvent event) throws IOException {
        System.out.println("Play btn");

        paneNodeAnim.getChildren().clear();

        if (this.mood >= 660) {
            switcher.sceneSwitch(resetScene);
        }

        if (this.mood >= 440) {
            this.decreaseMood();
            ImageView imgDead = new ImageView(img);
            imgDead.setViewport(new Rectangle2D(660, 0, 200, 200));
            paneNodeAnim.getChildren().add(imgDead);
        } else {
            this.decreaseMood();
            Animal animal = new Animal(imagV, mood);
            paneNodeAnim.getChildren().add(animal);
        }

    }

    @FXML
    private void resetGame(ActionEvent event) throws IOException {

        switcher.sceneSwitch(resetScene);

    }


    public void increaseMood() {

        if (this.mood >= 220) {
            this.mood = mood - 220;
        }
    }

    public void decreaseMood() {

        if (this.mood <= 440) {
            this.mood = mood + 220;
        }
    }


}
