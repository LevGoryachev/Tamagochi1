package ru.goryachev.app.mealmodel;

import java.io.IOException;

import javafx.scene.image.ImageView;

public interface MealModelling {
	
	public void createMeal (int mealNumber) throws IOException;
	
	public ImageView getImagV();
}
