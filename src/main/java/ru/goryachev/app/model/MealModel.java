package ru.goryachev.app.model;

import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import ru.goryachev.app.MealAnimator;

public class MealModel implements MealModelling {
	
	private String imageFileName;
	private double height; //setting size of imagView
	private double width; //setting size of imagView
	private ImageView imagV;
	private MoodAdjuster moodAdjuster;
	private long timeEat;
	
		@Override
		public void createMeal (int mealNumber, MoodAdjuster moodAdjuster, int mealChosen) throws IOException {
		
			this.moodAdjuster = moodAdjuster;
			
			
			switch (mealNumber) {
    		
			case 1:
				this.imageFileName = "/meal_apple.png";
				height = 75;
				width = 75;
				break;

			case 2:
				this.imageFileName = "/meal_seaweed.png";
				height = 100;
				width = 100;
				break;
         
			case 3:
				this.imageFileName = "/meal_sausage.png";
				height = 125;
				width = 125;
				break;
			}
			
			Image image = new Image(getClass().getResourceAsStream(imageFileName));
	        this.imagV = new ImageView(image);
	        this.imagV.setFitHeight(this.height);
	        this.imagV.setFitWidth(this.width);
	        /*
	        if (timeEat <= System.currentTimeMillis()) {
	            this.timeEat = System.currentTimeMillis() + 3000; //Set 5500 later

	            // check if the meal is appropriate for our animal 
	            if (mealNumber == mealChosen) {
	                this.moodAdjuster.increaser();
	            }

	        }
	        */
	        MealAnimator expiredMeal = new MealAnimator();
	        expiredMeal.fadeMeal(imagV);
		}

		public ImageView getImagV() {
			return imagV;
		}
}
