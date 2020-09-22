package ru.goryachev.app.model;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import ru.goryachev.app.AnimalAnimator;
import ru.goryachev.app.GameAnimator;
import ru.goryachev.app.Saver;
import ru.goryachev.app.SceneSwitcher;

import java.io.IOException;

public class MoodAdjuster {
	
    private Pane paneNodeAnim;
    private int animalNumber;
    private int mood;
    private long timePoint;
    private Image img;
    private ImageView imagV;
    private Button choiceReset;
    private SceneSwitcher scSwitcher;
    private long timeEat;
    
    private Saver saver = new Saver();
    
    private static final long STARTDELAY = 10000;
    
    public void increaser(int animalNumber, Pane paneNodeAnim, Pane paneMeal, ImageView imagV) throws IOException {
     	
        if (this.mood <= 440) {
            this.increaseMood();
            paneNodeAnim.getChildren().clear();
            AnimalAnimator animalAnimator = new AnimalAnimator(imagV, mood);
            GameAnimator gameAnim = new GameAnimator();
            //Parameters: animal which to move, for what meal to, X of animal, Y of animal, X of meal, Y of meal
            gameAnim.moveToMeal(animalAnimator, paneMeal, paneNodeAnim.getLayoutX(), paneNodeAnim.getLayoutY(), paneMeal.getLayoutX(), paneMeal.getLayoutY());
            paneNodeAnim.getChildren().add(animalAnimator);

            //rewrite current params (file: condition.bin)
            saver.writeState(animalNumber, mood, timePoint);
        }
    }

    public void decreaser(int animalNumber, Pane paneNodeAnim, SceneSwitcher scSwitcher,Image img, ImageView imagV, Button choiceReset) throws IOException {

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
            saver.writeState(animalNumber, mood, timePoint);
            System.out.println("440-660 FALLING AND SAVING");
        }

        if (this.mood < 440) {
            this.decreaseMood();
            AnimalAnimator animal = new AnimalAnimator(imagV, mood);
            paneNodeAnim.getChildren().add(animal);

            //rewrite current params (file: condition.bin)
            saver.writeState(animalNumber, mood, timePoint);
            System.out.println("0-440 DECREASING AND SAVING");
        }
    }

    AnimationTimer timer = new AnimationTimer() {

        @Override
        public void handle(long l) {

            if (timePoint <= System.currentTimeMillis()) {
                try {
                    decreaser(animalNumber, paneNodeAnim, scSwitcher, img, imagV, choiceReset);
                    timePoint = timePoint + 15000;
                    System.out.println("Animation handle tp: "+ timePoint);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    
    public void increaseByMeal (int animalNumber, Pane paneNodeAnim, Pane paneMeal, ImageView imagV, int mealNumber, int mealChosen) {
    	
    	if (timeEat <= System.currentTimeMillis()) {
            this.timeEat = System.currentTimeMillis() + 3000; //Set 5500 later

            // check if the meal is appropriate for our animal 
            if (mealNumber == mealChosen) {
                try {
					this.increaser(animalNumber, paneNodeAnim, paneMeal, imagV);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
    	
    }
    
    public void decrTimeByTime (int animalNumber, int mood, Pane paneNodeAnim, SceneSwitcher scSwitcher,Image img, ImageView imagV, Button choiceReset) {
    	
    	if (this.timePoint == 0) {
            this.timePoint = System.currentTimeMillis() + STARTDELAY;
        }
    	    	
    	this.animalNumber = animalNumber;
    	this.mood = mood;
        this.paneNodeAnim = paneNodeAnim;
        this.scSwitcher = scSwitcher;
        this.img = img;
        this.imagV = imagV;
        this.choiceReset = choiceReset;
   	
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
    
	public void setTimePoint(long timePoint) {
		this.timePoint = timePoint;
	}
	
}