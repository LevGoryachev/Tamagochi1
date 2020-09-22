package ru.goryachev.app.model;

import java.io.IOException;

import javafx.scene.image.ImageView;

public interface MealModelling {
	
	public void createMeal (int mealNumber, MoodAdjuster moodAdjuster, int mealChosen) throws IOException;
	
	public ImageView getImagV();
}
