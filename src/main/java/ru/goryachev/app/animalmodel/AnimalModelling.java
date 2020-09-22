package ru.goryachev.app.animalmodel;

import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface AnimalModelling {
	
	public void createAnimal (int animalNumber) throws IOException;
	
	public void setMood(int mood);

	public void setTimePoint(long timePoint);

	public AnimalAnimator getAnimalAnimator();

	public Image getImg();

	public ImageView getImagV();

	public int getMealChosen();
}
