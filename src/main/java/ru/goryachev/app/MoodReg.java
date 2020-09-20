package ru.goryachev.app;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MoodReg {

    private Pane paneNodeAnim;
    private Pane paneMeal;
    private int animalNo;
    private int mood;
    private long timePoint;
    private Image img;
    private ImageView imagV;
    private Button choiceReset;
    private SceneSwitcher scSwitcher;

    Saver saver = new Saver();

    public MoodReg(Pane paneNodeAnim, Pane paneMeal, SceneSwitcher switcher, int animalNo, int mood, long timePoint, Image img, ImageView imagV, Button choiceReset) throws IOException {
        this.paneNodeAnim = paneNodeAnim;
        this.paneMeal = paneMeal;
        this.animalNo = animalNo;
        this.mood = mood;
        this.timePoint = timePoint;
        this.img = img;
        this.imagV = imagV;
        this.choiceReset = choiceReset;
        this.scSwitcher = switcher;
    }

    public void increaser() throws IOException {

        if (this.mood <= 440) {
            this.increaseMood();
            paneNodeAnim.getChildren().clear();
            Animal animal = new Animal(imagV, mood);
            GameAnim gameAnim = new GameAnim();
            //Parameters: animal which to move, for what meal to, X of animal, Y of animal, X of meal, Y of meal
            gameAnim.moveToMeal(animal, paneMeal, paneNodeAnim.getLayoutX(), paneNodeAnim.getLayoutY(), paneMeal.getLayoutX(), paneMeal.getLayoutY());
            paneNodeAnim.getChildren().add(animal);

            //rewrite current params (file: condition.bin)
            saver.writeState(animalNo, mood, timePoint);
        }
    }

    public void decreaser() throws IOException {

        paneNodeAnim.getChildren().clear();
        if (this.mood >= 660) {

            //rewrite params with default (file: condition.bin)
            saver.dropState();

            timer.stop();
            scSwitcher.sceneReset(choiceReset);
            System.out.println("SCENEResetting...");
        }

        if (this.mood == 440) {
            this.decreaseMood();
            ImageView imgDead = new ImageView(img);
            imgDead.setViewport(new Rectangle2D(660, 0, 200, 200));
            paneNodeAnim.getChildren().add(imgDead);

            //rewrite current params (file: condition.bin)
            saver.writeState(animalNo, mood, timePoint);
            System.out.println("440-660 FALLING AND SAVING");
        }

        if (this.mood < 440) {
            this.decreaseMood();
            Animal animal = new Animal(imagV, mood);
            paneNodeAnim.getChildren().add(animal);

            //rewrite current params (file: condition.bin)
            saver.writeState(animalNo, mood, timePoint);
            System.out.println("0-440 DECREASING AND SAVING");
        }
    }

    AnimationTimer timer = new AnimationTimer() {

        @Override
        public void handle(long l) {

            if (timePoint <= System.currentTimeMillis()) {
                try {
                    decreaser();
                    timePoint = timePoint + 15000;
                    System.out.println("Animation handle tp: "+ timePoint);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public void decrTimeByTime () {
        timer.start();
    }

    public void increaseMood() throws IOException {
        if (this.mood >= 220) {
            this.mood = mood - 220;

        }
    }

    public void decreaseMood() throws IOException {
        if (this.mood <= 440) {
            this.mood = mood + 220;
            System.out.println(""+ mood);
        }
    }

    public int getMood() {
        return mood;
    }

    public ImageView getImagV() {
        return imagV;
    }

}