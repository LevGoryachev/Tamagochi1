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
import ru.goryachev.app.Animal;
import ru.goryachev.app.MoodReg;
import ru.goryachev.app.Recover;
import ru.goryachev.app.Saver;
import ru.goryachev.app.SceneSwitcher;

public class AnimalModel implements Serializable {
	
	
	private String imageFileName;
	private int animalNumber;
	private int mood;
	private Image img;
    private ImageView imagV;
    private Animal animal;
    private long timePoint;
    private MoodReg moodAdjuster;
    private Pane paneNodeAnim;
    private Pane paneNodeApple;
    private VBox mainScene;
    
    private Button resetBtn;
    

	private static final long STARTDELAY = 10000;
    //Saver saver = new Saver();
    
	public void initAnimal (int animalNumber, Pane paneNodeAnim, Pane paneNodeApple, VBox mainScene, Button resetBtn) throws IOException {
								 
		switch (animalNumber) {
        		
			case 1:
				this.imageFileName = "/sprites_hedgehog.png";
				break;

			case 2:
				this.imageFileName = "/sprites_cat.png";
				break;
         
			case 3:
				this.imageFileName = "/sprites_turtle.png";
				break;
        
			case 4:
				this.imageFileName = "/sprites_dog.png";
				break;
		}
		 
		//join these strings with this.fields
		Image image = new Image(getClass().getResourceAsStream(imageFileName));
        ImageView imagView = new ImageView(image);
        Animal animal = new Animal(imagView, mood);

        paneNodeAnim.getChildren().add(animal);
        
        this.img = image;
        this.imagV = imagView;
        this.animal = animal;
        this.animalNumber = animalNumber;
        this.paneNodeAnim = paneNodeAnim;
        this.paneNodeApple = paneNodeApple;
        this.resetBtn = resetBtn;

        if (this.timePoint == 0) {
            this.timePoint = System.currentTimeMillis() + STARTDELAY;
        }
        
        Saver saver = new Saver();
        saver.writeState(animalNumber, mood, timePoint);
        
        SceneSwitcher scSwitcher = new SceneSwitcher();
        scSwitcher.sceneSwitch(mainScene);
      
        //Two: which meal eats this animal
        MoodReg timeReg = new MoodReg(paneNodeAnim, paneNodeApple, scSwitcher, animalNumber, mood, timePoint, img, imagV, resetBtn);
        timeReg.decrTimeByTime();
        this.moodAdjuster =  timeReg;

	}
	
	
	/*
	public void initialize() {
		
		try {
            Recover recover = new Recover();
            this.animalNumber = recover.readState().getAnimalNo();
            this.mood = recover.readState().getMood();
            this.timePoint = recover.readState().getTimePoint();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Initialize animal No " + animalNumber);
        System.out.println("Initialize TimePoint: " + timePoint);
        System.out.println("Initialize Mood: " + mood);
        
        if (animalNumber != 0) 
        	try {
        		initAnimal(animalNumber, paneNodeAnim, paneNodeApple, mainScene, resetBtn);
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        

	}
	 */

	public MoodReg getMoodAdjuster() {
		return moodAdjuster;
	}

		
			
}
