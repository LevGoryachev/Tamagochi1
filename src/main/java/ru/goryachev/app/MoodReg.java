package ru.goryachev.app;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


import java.io.IOException;

public class MoodReg {

    Pane paneNodeAnim;
    Pane paneMeal;
    int mood;
    Image img;
    ImageView imagV;
    Button resetBtn;
    SceneSwitcher scSwitcher;

    public MoodReg(Pane paneNodeAnim, Pane paneMeal, SceneSwitcher switcher, int mood, Image img, ImageView imagV, Button resetBtn) {
        this.paneNodeAnim = paneNodeAnim;
        this.paneMeal = paneMeal;
        this.mood = mood;
        this.img = img;
        this.imagV = imagV;
        this.resetBtn = resetBtn;
        this.scSwitcher = switcher;

    }

    public void increaser() {

        if (this.mood <= 440) {
            this.increaseMood();
            paneNodeAnim.getChildren().clear();
            Animal animal = new Animal(imagV, mood);
            GameAnim gameAnim = new GameAnim();
            //Parameters: animal which to move, for what meal to, X of animal, Y of animal, X of meal, Y of meal
            gameAnim.moveToMeal(animal, paneMeal, paneNodeAnim.getLayoutX(), paneNodeAnim.getLayoutY(), paneMeal.getLayoutX(), paneMeal.getLayoutY());
            paneNodeAnim.getChildren().add(animal);
            System.out.println("increaser() works succefully");

        }
    }

    public void decreaser() throws IOException {

        paneNodeAnim.getChildren().clear();

        if (this.mood >= 660) {
            scSwitcher.sceneReset(resetBtn);
            timer.stop();
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

    long changeMoment = System.currentTimeMillis() + 5000;

    AnimationTimer timer = new AnimationTimer() {

        @Override
        public void handle(long l) {
            if (changeMoment <= System.currentTimeMillis()) {

                try {
                    decreaser();
                    changeMoment = System.currentTimeMillis() + 15000;
                    System.out.println("decreaser() works succefully");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public void decrTimeByTime () {

        timer.start();

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