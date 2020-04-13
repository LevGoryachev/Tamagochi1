package ru.goryachev.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;


public class PlayController implements Serializable, Initializable {

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

   // @FXML
   // public TextField userTxt = new TextField();

    int animalNumber;
    int mood;
    long timeEat;
    Image img;
    ImageView imagV;
    MoodReg moodAdjuster;

    private SceneSwitcher scSwitcher = new SceneSwitcher();
    Saver saver = new Saver();

    public PlayController() throws IOException {
    }

    private void btnVisibility () {

        //Welcome screen, hide animal buttons
        pickHedgehog.setVisible(false);
        pickCat.setVisible(false);

        //Play screen, show food buttons
        feedWApple.setVisible(true);
        feedWSausage.setVisible(true);
        //resetBtn.setVisible(true);
    }

    //animals
    @FXML
    private void startHedgehog() throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/sprites_hedgehog.png"));
        ImageView imagView = new ImageView(image);
        Animal animal = new Animal(imagView, mood);
        paneNodeAnim.getChildren().add(animal);

        this.img = image;
        this.imagV = imagView;
        this.animalNumber = 1;

        saver.writeState(animalNumber, mood);

        scSwitcher.sceneSwitch(mainScene);
        btnVisibility();

        MoodReg timeReg = new MoodReg(paneNodeAnim, paneNodeApple, scSwitcher, animalNumber, mood, img, imagV, resetBtn);
        timeReg.decrTimeByTime();
        this.moodAdjuster =  timeReg;

    }

    @FXML
    private void startCat() throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/sprites_cat.png"));
        ImageView imagView = new ImageView(image);
        Animal animal = new Animal(imagView, mood);

        paneNodeAnim.getChildren().add(animal);
        this.img = image;
        this.imagV = imagView;
        this.animalNumber = 2;

        saver.writeState(animalNumber, mood);

        scSwitcher.sceneSwitch(mainScene);
        btnVisibility();

        MoodReg timeReg = new MoodReg(paneNodeAnim, paneNodeSausage, scSwitcher, animalNumber, mood, img, imagV, resetBtn);
        timeReg.decrTimeByTime();
        this.moodAdjuster =  timeReg;

    }

    //meal
    @FXML
    private void apple(ActionEvent event) throws IOException {


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
    private void sausage(ActionEvent event) throws IOException {


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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Recover recover = new Recover();
        try {
            HashMap<String, Integer> restoreMap = recover.readState();
            this.animalNumber = restoreMap.get("condition");
            this.mood = restoreMap.get("mood");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Initialize check No " + animalNumber);
        switch (animalNumber) {
            case 1:
                try {
                    startHedgehog();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            break;

            case 2:
                try {
                    startCat();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            break;
        }

    }

}


