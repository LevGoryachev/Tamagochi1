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
    private Button playWithAnim;

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
    long expireT;
    Image img;
    ImageView imagV;

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

        //will use for switching to the last scene (if animal die)
        //switcher.sceneSwitch(pickHedgehog);

        choice.pickAnimal(1);

        pickHedgehog.setVisible(false);
        pickCat.setVisible(false);
        feedWApple.setVisible(true);
        feedWSausage.setVisible(true);
        playWithAnim.setVisible(true);
        resetScene.setVisible(true);

        MoodReg timeReg = new MoodReg(paneNodeAnim, mood, img, imagV, resetScene);
        timeReg.decrTimeByTime();

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

        //will use for switching to the last scene (if animal die)
        //switcher.sceneSwitch(pickCat);

        choice.pickAnimal(2);

        pickHedgehog.setVisible(false);
        pickCat.setVisible(false);
        feedWApple.setVisible(true);
        feedWSausage.setVisible(true);
        playWithAnim.setVisible(true);
        resetScene.setVisible(true);

        MoodReg timeReg = new MoodReg(paneNodeAnim, mood, img, imagV, resetScene);
        timeReg.decrTimeByTime();

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

            this.timeEat = System.currentTimeMillis() + 5500;

            if (animalNumber == 1 && this.mood <= 440) {
                //paneNodeAnim.getChildren().clear();
                Animal animal = new Animal(imagV, mood);
                    GameAnim gameAnim = new GameAnim();
                    //Parameters: animal which to move, for what meal to, X of animal, Y of animal, X of meal, Y of meal
                    gameAnim.moveToMeal(animal, paneNodeApple, paneNodeAnim.getLayoutX(), paneNodeAnim.getLayoutY(), paneNodeApple.getLayoutX(), paneNodeApple.getLayoutY());
                paneNodeAnim.getChildren().add(animal);

                this.increaseMood();
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

            this.timeEat = System.currentTimeMillis() + 5500;
            if (animalNumber == 2 && this.mood <= 440) {
                //paneNodeAnim.getChildren().clear();
                Animal animal = new Animal(imagV, mood);
                    GameAnim gameAnim = new GameAnim();
                    //Parameters: animal which to move, for what meal to, X of animal, Y of animal, X of meal, Y of meal
                    gameAnim.moveToMeal(animal, paneNodeSausage, paneNodeAnim.getLayoutX(), paneNodeAnim.getLayoutY(), paneNodeSausage.getLayoutX(), paneNodeSausage.getLayoutY());
                paneNodeAnim.getChildren().add(animal);

                this.increaseMood();
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
