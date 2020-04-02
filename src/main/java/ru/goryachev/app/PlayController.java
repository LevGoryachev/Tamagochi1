package ru.goryachev.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

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
    private Button resetBtn;

    @FXML
    private VBox mainScene;

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

    private SceneSwitcher scSwitcher = new SceneSwitcher();

    //animals

    @FXML
    private void startHedgehog(ActionEvent event) {

        Image image = new Image(getClass().getResourceAsStream("/sprites_hedgehog.png"));
        ImageView imagView = new ImageView(image);
        Animal animal = new Animal(imagView, mood);
        paneNodeAnim.getChildren().add(animal);

        this.img = image;
        this.imagV = imagView;
        this.animalNumber = 1;

        scSwitcher.sceneSwitch(mainScene, pickHedgehog, pickCat, feedWApple, feedWSausage, resetBtn);

        MoodReg timeReg = new MoodReg(paneNodeAnim, paneNodeApple, scSwitcher, mood, img, imagV, resetBtn);
        timeReg.decrTimeByTime();
        this.moodAdjuster =  timeReg;

    }

    @FXML
    private void startCat(ActionEvent event) {

        Image image = new Image(getClass().getResourceAsStream("/sprites_cat.png"));
        ImageView imagView = new ImageView(image);
        Animal animal = new Animal(imagView, mood);

        paneNodeAnim.getChildren().add(animal);
        this.img = image;
        this.imagV = imagView;
        this.animalNumber = 2;

        scSwitcher.sceneSwitch(mainScene, pickHedgehog, pickCat, feedWApple, feedWSausage, resetBtn);

        MoodReg timeReg = new MoodReg(paneNodeAnim, paneNodeSausage, scSwitcher, mood, img, imagV, resetBtn);
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
    private void resetGame(ActionEvent event) throws IOException {
        SceneSwitcher scSwitcher = new SceneSwitcher();
        scSwitcher.sceneReset(resetBtn);

    }

}
