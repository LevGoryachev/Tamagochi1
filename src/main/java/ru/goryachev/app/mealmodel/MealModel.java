package ru.goryachev.app.mealmodel;

import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MealModel implements MealModelling {
	
	private String imageFileName;
	private double height; //setting size of imagView
	private double width; //setting size of imagView
	private ImageView imagV;
			
		@Override
		public void createMeal (int mealNumber) throws IOException {
		
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
	        MealAnimator expiredMeal = new MealAnimator();
	        expiredMeal.fadeMeal(imagV);
		}

		public ImageView getImagV() {
			return imagV;
		}
}
