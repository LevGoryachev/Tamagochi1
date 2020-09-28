package ru.goryachev.app.animalmodel;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ru.goryachev.app.serializer.Saver;

public class AnimalModel implements AnimalModelling {
	
	private String imageFileName;
	private int mood;
	private Image img;
    private ImageView imagV;
    private AnimalAnimator animalAnimator;
    private long timePoint;
    private int mealChosen;
    
    private Saver saver = new Saver();
        
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
        saver.writeState(animalNumber, mood, timePoint);
 	}
		
	public void setMood(int mood) {
		this.mood = mood;
	}

	public void setTimePoint(long timePoint) {
		this.timePoint = timePoint;
	}

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
