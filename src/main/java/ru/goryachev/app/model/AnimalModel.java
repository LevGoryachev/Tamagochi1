package ru.goryachev.app.model;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import ru.goryachev.app.AnimalAnimator;
import ru.goryachev.app.Recover;
import ru.goryachev.app.Saver;
import ru.goryachev.app.SceneSwitcher;

public class AnimalModel implements Serializable {
	
	
	private String imageFileName;
	private int animalNumber;
	private int mood;
	private Image img;
    private ImageView imagV;
    private AnimalAnimator animalAnimator;
    private long timePoint;
    private MoodAdjuster moodAdjuster;
    //private Pane paneNodeAnim;
    private int mealChosen;
    private Pane paneMeal;
    private VBox mainScene;
    
    private Button choiceReset;
    

	private static final long STARTDELAY = 10000;
    //Saver saver = new Saver();
    
	public void createAnimal (int animalNumber) throws IOException {
								 
		switch (animalNumber) {
        		
			case 1:
				this.imageFileName = "/sprites_hedgehog.png";
				this.mealChosen = 1;  //set a number of meal which this animal eats
				break;

			case 2:
				this.imageFileName = "/sprites_cat.png";
				this.mealChosen = 3; //set a number of meal which this animal eats
				break;
         
			case 3:
				this.imageFileName = "/sprites_turtle.png";
				this.mealChosen = 2; //set a number of meal which this animal eats
				break;
        
			case 4:
				this.imageFileName = "/sprites_dog.png";
				this.mealChosen = 3; //set a number of meal which this animal eats
				break;
		}
		 
		
		this.img = new Image(getClass().getResourceAsStream(imageFileName));
		this.imagV = new ImageView(img);
		this.animalAnimator = new AnimalAnimator(imagV, mood);
        //paneNodeAnim.getChildren().add(animalAnimator);
       
        this.animalNumber = animalNumber;
        //this.paneNodeAnim = paneNodeAnim;
        this.paneMeal = paneMeal;
        this.choiceReset = choiceReset;

        if (this.timePoint == 0) {
            this.timePoint = System.currentTimeMillis() + STARTDELAY;
        }
        
        Saver saver = new Saver();
        saver.writeState(animalNumber, mood, timePoint);
        
        //SceneSwitcher scSwitcher = new SceneSwitcher();
        //scSwitcher.sceneSwitch(mainScene);
      
        //Two: which meal eats this animal
        /*
        MoodReg timeReg = new MoodReg(paneNodeAnim, paneMeal, scSwitcher, animalNumber, mood, timePoint, img, imagV, choiceReset);
        timeReg.decrTimeByTime();
        this.moodAdjuster =  timeReg;
        */
	}
		
	public void setMood(int mood) {
		this.mood = mood;
	}

	public void setTimePoint(long timePoint) {
		this.timePoint = timePoint;
	}

	//public MoodReg getMoodAdjuster() {
	//	return moodAdjuster;
	//}

	public AnimalAnimator getAnimalAnimator() {
		return animalAnimator;
	}

	public Image getImg() {
		return img;
	}

	public ImageView getImagV() {
		return imagV;
	}

	public int getMealChosen() {
		return mealChosen;
	}
			
}
