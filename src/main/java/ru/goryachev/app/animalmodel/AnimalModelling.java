package ru.goryachev.app.animalmodel;

import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ru.goryachev.app.serializer.Serializer;

public interface AnimalModelling {
	
	public void createAnimal (int animalNumber) throws IOException;
	
	public void setGameSerializer(Serializer gameSerializer);
	
	public void setMood(int mood);

	public void setTimePoint(long timePoint);

	public AnimalAnimator getAnimalAnimator();

	public Image getImg();

	public ImageView getImagV();

	public int getMealChosen();
}
